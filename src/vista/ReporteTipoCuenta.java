package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import entidad.Tarjeta;
import entidad.TipoCuenta;
import mantenimiento.GestionTarjetaDAO;
import mantenimiento.GestionTipoCuentaDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.SwingConstants;
import java.awt.Font;

public class ReporteTipoCuenta extends JInternalFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JComboBox cboTipoCuenta;
	private JTable tbTipoCuenta;
	private JButton btnReporte;

	DefaultTableModel model = new DefaultTableModel();
	GestionTipoCuentaDAO gTipoCuenta = new GestionTipoCuentaDAO();
	GestionTarjetaDAO gTarjeta = new GestionTarjetaDAO();

	private JScrollPane scrollPane;
	private JLabel lblNewLabel_1;
	private JButton btnPdf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporteTipoCuenta frame = new ReporteTipoCuenta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReporteTipoCuenta() {
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 680, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Tipo Cuenta :  ");
		lblNewLabel.setBounds(10, 90, 126, 14);
		contentPane.add(lblNewLabel);

		cboTipoCuenta = new JComboBox();
		cboTipoCuenta.setBounds(108, 86, 160, 22);
		contentPane.add(cboTipoCuenta);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 142, 644, 181);
		contentPane.add(scrollPane);

		tbTipoCuenta = new JTable();
		tbTipoCuenta.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbTipoCuenta);

		btnReporte = new JButton("Reporte");
		btnReporte.addActionListener(this);
		btnReporte.setBounds(293, 86, 89, 23);
		contentPane.add(btnReporte);

		model.addColumn("Núm Tarjeta");
		model.addColumn("Nombre Completo");
		model.addColumn("Tipo Cuenta");
		model.addColumn("Núm Cuenta");
		model.addColumn("Afiliación");
		model.addColumn("Caducidad");
		model.addColumn("Saldo");

		tbTipoCuenta.setModel(model);

		lblNewLabel_1 = new JLabel("Reporte Tipo Cuenta");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 27));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(143, 188, 143));
		lblNewLabel_1.setForeground(new Color(255, 255, 240));
		lblNewLabel_1.setBounds(0, 0, 664, 64);
		contentPane.add(lblNewLabel_1);

		btnPdf = new JButton("PDF");
		btnPdf.addActionListener(this);
		btnPdf.setBounds(513, 86, 89, 23);
		contentPane.add(btnPdf);

		cargarDataComboBox();
	}

	private void cargarDataComboBox() {
		ArrayList<TipoCuenta> listarTipoCuentas = gTipoCuenta.listaTipoCuenta();
		if (listarTipoCuentas.size() == 0) {
			mensajeError("La lista se encuentra vacía");
		} else {
			cboTipoCuenta.addItem("Seleccione...");
			for (TipoCuenta tc : listarTipoCuentas) {
				cboTipoCuenta.addItem(tc.getCod_cuenta() + " - " + tc.getDescripcion());
			}
		}

	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error !!!", 0);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPdf) {
			actionPerformedBtnPdf(e);
		}
		if (e.getSource() == btnReporte) {
			actionPerformedBtnReporte(e);
		}
	}

	protected void actionPerformedBtnReporte(ActionEvent e) {
		model.setRowCount(0);
		int tipo = getTipo();
		if (tipo == 0) {
			return;
		} else {
			ArrayList<entidad.ReporteTipoCuenta> listCuenta = gTipoCuenta.listarReporteCuentaXTipocuenta(tipo);
			if (listCuenta.size() == 0) {
				mensajeError("Lista vacía");
			} else {
				for (entidad.ReporteTipoCuenta t : listCuenta) {
					Object fila[] = { t.getNumTarjeta(), t.getNombCliente(), t.getTipoCuenta(), t.getNumCuenta(),
							t.getFecAfiliacion(), t.getFecCaducidad(), t.getSaldo() };
					model.addRow(fila);
				}
			}
		}

	}

	private int getTipo() {
		return cboTipoCuenta.getSelectedIndex();
	}

	protected void actionPerformedBtnPdf(ActionEvent e) {

		String nombArchivo = "Reportes/listadoTipoCuenta.pdf";
		try {
			Document plantilla = new Document();

			FileOutputStream fos = new FileOutputStream(nombArchivo);

			PdfWriter pdfWr = PdfWriter.getInstance(plantilla, fos);

			plantilla.open();

			Paragraph p = new Paragraph("Listado Tipos de cuenta",
					FontFactory.getFont("arial", 22, Font.BOLD, BaseColor.BLACK));
			p.setAlignment(Chunk.ALIGN_CENTER);
			plantilla.add(p);

			p = new Paragraph(" ");
			plantilla.add(p);

			int tipo = getTipo();
			if (tipo == 0) {
				mensajeError("Debes Seleccionar un tipo de Cuenta");
				return;
			} else {
				ArrayList<entidad.ReporteTipoCuenta> listCuenta = gTipoCuenta.listarReporteCuentaXTipocuenta(tipo);
				if (listCuenta.size() == 0) {
					p = new Paragraph("Lista vacía", FontFactory.getFont("arial", 14, Font.ITALIC, BaseColor.RED));
				} else {

					PdfPTable tabla = new PdfPTable(7);

					tabla.addCell("Num Tarjeta");
					tabla.addCell("Cliente");
					tabla.addCell("Tipo Cuenta");
					tabla.addCell("Num Cuenta");
					tabla.addCell("Fec Afiliación");
					tabla.addCell("Fec Caducidad");
					tabla.addCell("Saldo");

					for (entidad.ReporteTipoCuenta rtp : listCuenta) {

						tabla.addCell(rtp.getNumTarjeta() + " ");
						tabla.addCell(rtp.getNombCliente() + " ");
						tabla.addCell(rtp.getTipoCuenta() + " ");
						tabla.addCell(rtp.getNumCuenta() + " ");
						tabla.addCell(rtp.getFecAfiliacion() + " ");
						tabla.addCell(rtp.getFecCaducidad() + " ");
						tabla.addCell(rtp.getSaldo() + " ");
					}
					plantilla.add(tabla);
				}

				plantilla.close();

				Desktop.getDesktop().open(new File(nombArchivo));
			}
		} catch (

		Exception f) {
			System.out.println("Error al generar reporte" + f.getMessage());
		}

	}
}
