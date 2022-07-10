package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.util.ArrayList;

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

import entidad.Cliente;
import entidad.Tarjeta;
import entidad.TipoCuenta;
import mantenimiento.GestionClienteDAO;
import mantenimiento.GestionTarjetaDAO;
import mantenimiento.GestionTipoCuentaDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;

public class ReporteTarjeta extends JInternalFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JComboBox cboCliente;
	private JTable tbCliente;
	private JScrollPane scrollPane;
	private JButton btnReporte;

	DefaultTableModel model = new DefaultTableModel();
	GestionClienteDAO gCliente = new GestionClienteDAO();
	GestionTarjetaDAO gTarjeta = new GestionTarjetaDAO();
	GestionTipoCuentaDAO gTipCuenta = new GestionTipoCuentaDAO();
	private JLabel lblNewLabel_1;
	private JButton btnPdf;
	private JButton btnReporteTipoCuenta;
	private JComboBox cboTipoCuenta;
	private JLabel lblNewLabel_2;
	private JButton btnOpciones;
	private JButton btnPdf2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporteTarjeta frame = new ReporteTarjeta();
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
	public ReporteTarjeta() {
		setMaximizable(true);
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 679, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Código Cliente :");
		lblNewLabel.setBounds(10, 114, 129, 14);
		contentPane.add(lblNewLabel);

		cboCliente = new JComboBox();
		cboCliente.setBounds(125, 110, 170, 22);
		contentPane.add(cboCliente);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 180, 643, 206);
		contentPane.add(scrollPane);

		tbCliente = new JTable();
		tbCliente.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbCliente);

		btnReporte = new JButton("Reporte");
		btnReporte.addActionListener(this);
		btnReporte.setBounds(342, 110, 89, 23);
		contentPane.add(btnReporte);

		model.addColumn("Núm Tarjeta");
		model.addColumn("CLiente");
		model.addColumn("Tipo Cuenta");
		model.addColumn("Núm Cuenta");
		model.addColumn("Afiliación");
		model.addColumn("Caducidad");
		model.addColumn("Saldo");

		tbCliente.setModel(model);

		lblNewLabel_1 = new JLabel("Reporte Tarjeta");
		lblNewLabel_1.setForeground(new Color(255, 255, 240));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 27));
		lblNewLabel_1.setBackground(new Color(143, 188, 143));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 663, 79);
		contentPane.add(lblNewLabel_1);

		btnPdf = new JButton("PDF");
		btnPdf.addActionListener(this);
		btnPdf.setBounds(441, 110, 89, 23);
		contentPane.add(btnPdf);

		btnReporteTipoCuenta = new JButton("Reporte2");
		btnReporteTipoCuenta.addActionListener(this);
		btnReporteTipoCuenta.setBounds(342, 139, 89, 23);
		contentPane.add(btnReporteTipoCuenta);

		cboTipoCuenta = new JComboBox();
		cboTipoCuenta.setBounds(125, 139, 170, 22);
		contentPane.add(cboTipoCuenta);

		lblNewLabel_2 = new JLabel("Tipo Cuenta:");
		lblNewLabel_2.setBounds(20, 139, 83, 14);
		contentPane.add(lblNewLabel_2);

		btnOpciones = new JButton("Help");
		btnOpciones.addActionListener(this);
		btnOpciones.setBounds(550, 110, 89, 23);
		contentPane.add(btnOpciones);

		btnPdf2 = new JButton("PDF2");
		btnPdf2.addActionListener(this);
		btnPdf2.setBounds(441, 139, 89, 23);
		contentPane.add(btnPdf2);

		cargarDataComboBox();
		cargarDataComboBox2();
	}

	private void cargarDataComboBox2() {
		ArrayList<TipoCuenta> listarTipoCuenta = gTipCuenta.listaTipoCuenta();
		if (listarTipoCuenta.size() == 0) {
			mensajeError("La lista se encuentra Vacía");
		} else {
			cboTipoCuenta.addItem("Seleccione...");
			for (TipoCuenta tc : listarTipoCuenta) {
				cboTipoCuenta.addItem(tc.getCod_cuenta() + " - " + tc.getDescripcion());
			}
		}

	}

	private void cargarDataComboBox() {
		ArrayList<Cliente> listarCliente = gCliente.listarCliente();
		if (listarCliente.size() == 0) {
			mensajeError("La lista se encuentra Vacía");
		} else {
			cboCliente.addItem("Seleccione...");
			for (Cliente c : listarCliente) {
				cboCliente.addItem(c.getCod_cliente() + " - " + c.getNombre());
			}
		}

	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error !!!", 0);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPdf2) {
			actionPerformedBtnPdf2(e);
		}
		if (e.getSource() == btnOpciones) {
			actionPerformedBtnOpciones(e);
		}
		if (e.getSource() == btnReporteTipoCuenta) {
			actionPerformedBtnReporte2(e);
		}
		if (e.getSource() == btnPdf) {
			actionPerformedBtnPdf(e);
		}
		if (e.getSource() == btnReporte) {
			actionPerformedBtnReporte(e);
		}
	}

	protected void actionPerformedBtnReporte(ActionEvent e) {
//		cargarReporte();
		model.setRowCount(0);
		int tipo = getCliente();
		if (tipo == 0) {
			return;
		} else {
			ArrayList<entidad.ReporteTarjeta> listCuenta = gTarjeta.listaReporterTarjetaXCodigoCliente(tipo);
			if (listCuenta.size() == 0) {
				mensajeError("Lista vacía");
			} else {
				for (entidad.ReporteTarjeta rt : listCuenta) {
					Object fila[] = { rt.getNumTarjeta(), rt.getNombCliente(), rt.getTipoCuenta(), rt.getNumCuenta(),
							rt.getFecAfiliacion(), rt.getFecCaducidad(), rt.getSaldo() };
					model.addRow(fila);
				}
			}
		}

	}

	private int getCliente() {
		return cboCliente.getSelectedIndex();
	}

	protected void actionPerformedBtnPdf(ActionEvent e) {

		String nombArchivo = "Reportes/listadoTarjetas.pdf";
		try {
			Document plantilla = new Document();

			FileOutputStream fos = new FileOutputStream(nombArchivo);

			PdfWriter pdfWr = PdfWriter.getInstance(plantilla, fos);

			plantilla.open();

			Paragraph p = new Paragraph("Listado de Tarjetas",
					FontFactory.getFont("arial", 22, Font.BOLD, BaseColor.BLACK));
			p.setAlignment(Chunk.ALIGN_CENTER);
			plantilla.add(p);

			p = new Paragraph(" ");
			plantilla.add(p);

			int tipo = getCliente();
			if (tipo == 0) {
				mensajeError("Debes Seleccionar un usuario");
				return;
			} else {
				ArrayList<Tarjeta> lisCuenta = gTarjeta.listarTarjetaXCodigoCliente(tipo);
				if (lisCuenta.size() == 0) {
					p = new Paragraph("Lista vacía", FontFactory.getFont("arial", 14, Font.ITALIC, BaseColor.RED));
				} else {

					PdfPTable tabla = new PdfPTable(7);

					tabla.addCell("Num Tarjeta");
					tabla.addCell("Cod Cliente");
					tabla.addCell("Cod Cuenta");
					tabla.addCell("Num Cuenta");
					tabla.addCell("Afiliación");
					tabla.addCell("Caducidad");
					tabla.addCell("Saldo");

					for (Tarjeta t : lisCuenta) {

						tabla.addCell(t.getNum_Tarjeta() + " ");
						tabla.addCell(t.getCod_cliente() + " ");
						tabla.addCell(t.getCodTipo_cuenta() + " ");
						tabla.addCell(t.getNum_cuenta() + " ");
						tabla.addCell(t.getFecAfliacion() + " ");
						tabla.addCell(t.getFecCaducidad() + " ");
						tabla.addCell(t.getSaldo() + " ");
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

	protected void actionPerformedBtnReporte2(ActionEvent e) {

		model.setRowCount(0);
		int tipo = getTipoCuenta();
		if (tipo == 0) {
			return;
		} else {
			ArrayList<entidad.ReporteTarjeta> listCuenta = gTarjeta.listaReporterTarjetaXTipoCuenta(tipo);
			if (listCuenta.size() == 0) {
				mensajeError("Lista vacía");
			} else {
				for (entidad.ReporteTarjeta rt : listCuenta) {
					Object fila[] = { rt.getNumTarjeta(), rt.getNombCliente(), rt.getTipoCuenta(), rt.getNumCuenta(),
							rt.getFecAfiliacion(), rt.getFecCaducidad(), rt.getSaldo() };
					model.addRow(fila);
				}
			}
		}

	}

	private int getTipoCuenta() {
		return cboTipoCuenta.getSelectedIndex();
	}

	protected void actionPerformedBtnOpciones(ActionEvent e) {

		@SuppressWarnings("unused")
		int opcion;
		opcion = JOptionPane.showConfirmDialog(
				this, "Puedes Realizar el Reporte de la Tarjeta de dos maneras: " + "\n\n"
						+ " - Por el nombre del usuario" + "\n" + " - Por el Tipo de Cuenta",
				"Sistema", JOptionPane.CLOSED_OPTION);

	}

	protected void actionPerformedBtnPdf2(ActionEvent e) {

		String nombArchivo = "Reportes/listadoTarjetas.pdf";
		try {
			Document plantilla = new Document();

			FileOutputStream fos = new FileOutputStream(nombArchivo);

			PdfWriter pdfWr = PdfWriter.getInstance(plantilla, fos);

			plantilla.open();

			Paragraph p = new Paragraph("Listado de Tarjetas",
					FontFactory.getFont("arial", 22, Font.BOLD, BaseColor.BLACK));
			p.setAlignment(Chunk.ALIGN_CENTER);
			plantilla.add(p);

			p = new Paragraph(" ");
			plantilla.add(p);

			int tipo = getTipoCuenta();
			if (tipo == 0) {
				mensajeError("Debes Seleccionar un Tipo e cuenta");
				return;
			} else {
				ArrayList<entidad.ReporteTarjeta> listCuenta = gTarjeta.listaReporterTarjetaXTipoCuenta(tipo);
				if (listCuenta.size() == 0) {
					p = new Paragraph("Lista vacía", FontFactory.getFont("arial", 14, Font.ITALIC, BaseColor.RED));
				} else {

					PdfPTable tabla = new PdfPTable(7);

					tabla.addCell("Num Tarjeta");
					tabla.addCell("Cliente");
					tabla.addCell("Cuenta");
					tabla.addCell("Num Cuenta");
					tabla.addCell("Afiliación");
					tabla.addCell("Caducidad");
					tabla.addCell("Saldo");

					for (entidad.ReporteTarjeta rt : listCuenta) {

						tabla.addCell(rt.getNumTarjeta() + " ");
						tabla.addCell(rt.getNombCliente() + " ");
						tabla.addCell(rt.getTipoCuenta() + " ");
						tabla.addCell(rt.getNumCuenta() + " ");
						tabla.addCell(rt.getFecAfiliacion() + " ");
						tabla.addCell(rt.getFecCaducidad() + " ");
						tabla.addCell(rt.getSaldo() + " ");

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
