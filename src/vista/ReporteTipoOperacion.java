package vista;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import entidad.Movimiento;
import entidad.TipoOperacion;
import mantenimiento.GestionMovimientoDAO;
import mantenimiento.GestionTipoOperacionDAO;

public class ReporteTipoOperacion extends JInternalFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JComboBox cboTipoOperacion;
	private JTable tbTipoOperacion;
	private JScrollPane scrollPane;
	private JButton btnReportar;
	DefaultTableModel model = new DefaultTableModel();
	GestionTipoOperacionDAO gTipoOperacion = new GestionTipoOperacionDAO();
	GestionMovimientoDAO gMovimiento = new GestionMovimientoDAO();
	private JLabel lblNewLabel_1;
	private JButton btnPdf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporteTipoOperacion frame = new ReporteTipoOperacion();
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
	public ReporteTipoOperacion() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 714, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Tipo Operación :");
		lblNewLabel.setBounds(10, 103, 129, 14);
		contentPane.add(lblNewLabel);

		cboTipoOperacion = new JComboBox();
		cboTipoOperacion.setBounds(113, 99, 174, 22);
		contentPane.add(cboTipoOperacion);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 150, 678, 207);
		contentPane.add(scrollPane);

		tbTipoOperacion = new JTable();
		tbTipoOperacion.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbTipoOperacion);

		btnReportar = new JButton("Reportar");
		btnReportar.addActionListener(this);
		btnReportar.setBounds(364, 99, 89, 23);
		contentPane.add(btnReportar);

		model.addColumn("Cod Movimiento");
		model.addColumn("Num Tarjeta");
		model.addColumn("Cliente");
		model.addColumn("Núm Cuenta");
		model.addColumn("Operación");
		model.addColumn("Fec Movimiento");
		model.addColumn("Cuenta destino");
		model.addColumn("Monto");

		tbTipoOperacion.setModel(model);

		lblNewLabel_1 = new JLabel("Reporte Tipo Operación");
		lblNewLabel_1.setBackground(new Color(143, 188, 143));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setForeground(new Color(255, 255, 240));
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 27));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 698, 66);
		contentPane.add(lblNewLabel_1);

		btnPdf = new JButton("PDF");
		btnPdf.addActionListener(this);
		btnPdf.setBounds(537, 99, 89, 23);
		contentPane.add(btnPdf);

		cargarDataComboBox();

	}

	private void cargarDataComboBox() {
		ArrayList<TipoOperacion> listaTipoOperacion = gTipoOperacion.listaTipoOperacion();
		if (listaTipoOperacion.size() == 0) {
			mensajeError("La lista se encuentra Vacía");
		} else {
			cboTipoOperacion.addItem("Seleccione...");
			for (TipoOperacion to : listaTipoOperacion) {
				cboTipoOperacion.addItem(to.getCod_operacion() + " - " + to.getDescripcion());

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
		if (e.getSource() == btnReportar) {
			actionPerformedBtnReportar(e);
		}
	}

	protected void actionPerformedBtnReportar(ActionEvent e) {

		model.setRowCount(0);
		int tipo = getOperacion();
		if (tipo == 0) {
			return;
		} else {
			ArrayList<entidad.ReporteTipoOperacion> lista = gTipoOperacion.listarReporteTipoOperacion(tipo);
			if (lista.size() == 0) {
				mensajeError("Lista Vacía");
			} else {
				for (entidad.ReporteTipoOperacion rto : lista) {
					Object fila[] = { rto.getCodMovimiento(), rto.getNumTarjeta(), rto.getCliente(),
							rto.getNumTarjeta(), rto.getTipoOperacion(), rto.getFecMovimiento(), rto.getCuentaDestino(),
							rto.getMonto() };
					model.addRow(fila);
				}
			}
		}
	}

	private int getOperacion() {
		return cboTipoOperacion.getSelectedIndex();
	}

	protected void actionPerformedBtnPdf(ActionEvent e) {
		imprimirPDF();
	}

	private void imprimirPDF() {

		String nombArchivo = "Reportes/listadoTipoOperaciones.pdf";
		try {

			Document plantilla = new Document();

			FileOutputStream fos = new FileOutputStream(nombArchivo);

			PdfWriter pdfWr = PdfWriter.getInstance(plantilla, fos);

			plantilla.open();

			Paragraph p = new Paragraph("Listado Operaciones",
					FontFactory.getFont("arial", 22, Font.BOLD, BaseColor.BLUE));
			p.setAlignment(Chunk.ALIGN_CENTER);
			plantilla.add(p);

			p = new Paragraph(" ");
			plantilla.add(p);

			int tipo = getOperacion();
			if (tipo == 0) {
				return;
			} else {
				ArrayList<Movimiento> Listmovimiento = gMovimiento.listarMovimientoXCodigoOperacion(tipo);
				if (Listmovimiento.size() == 0) {
					p = new Paragraph("Lista vacía", FontFactory.getFont("arial", 14, Font.ITALIC, BaseColor.RED));
				} else {

					PdfPTable tabla = new PdfPTable(5);

					tabla.addCell("COd Movimiento");
					tabla.addCell("Num Tarjeta");
					tabla.addCell("Cod cliente");
					tabla.addCell("Núm Cuenta");
					tabla.addCell("Fec Movimineto");
					tabla.addCell("Cuenta destino");
					tabla.addCell("Monto");

					for (Movimiento to : Listmovimiento) {

						tabla.addCell(to.getCod_movimiento() + " ");
						tabla.addCell(to.getNum_tarjeta() + " ");
						tabla.addCell(to.getCod_cliente() + " ");
						tabla.addCell(to.getFecha_movimiento() + " ");
						tabla.addCell(to.getCuenta_destino() + " ");
						tabla.addCell(to.getMonto() + " ");

					}
					plantilla.add(tabla);
				}

				plantilla.close();

				Desktop.getDesktop().open(new File(nombArchivo));
			}
		} catch (

		Exception e) {
			System.out.println("Error al generar reporte" + e.getMessage());
		}
	}
}
