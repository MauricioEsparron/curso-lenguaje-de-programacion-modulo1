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

import entidad.TipoUsuario;
import entidad.Usuario;
import mantenimiento.GestionTipoUsuarioDAO;
import mantenimiento.GestionUsuarioDAO;

public class ReporteTipoUsuario extends JInternalFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JComboBox cboTipoUsuario;
	private JTable tbTipoUsuario;
	private JButton btnReporte;

	DefaultTableModel model = new DefaultTableModel();
	GestionTipoUsuarioDAO gTipoUser = new GestionTipoUsuarioDAO();
	GestionUsuarioDAO gUser = new GestionUsuarioDAO();

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
					ReporteTipoUsuario frame = new ReporteTipoUsuario();
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
	public ReporteTipoUsuario() {
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 666, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Tipo Usuario :  ");
		lblNewLabel.setBounds(10, 99, 89, 14);
		contentPane.add(lblNewLabel);

		cboTipoUsuario = new JComboBox();
		cboTipoUsuario.setBounds(108, 95, 160, 22);
		contentPane.add(cboTipoUsuario);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 140, 630, 211);
		contentPane.add(scrollPane);

		tbTipoUsuario = new JTable();
		tbTipoUsuario.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbTipoUsuario);

		btnReporte = new JButton("Reporte");
		btnReporte.addActionListener(this);
		btnReporte.setBounds(393, 90, 89, 23);
		contentPane.add(btnReporte);

		model.addColumn("Código");
		model.addColumn("Nombre Completo");
		model.addColumn("Dni");
		model.addColumn("Telefono");
		model.addColumn("usuario");
		model.addColumn("Clave");
		model.addColumn("Tipo Usuario");

		tbTipoUsuario.setModel(model);

		lblNewLabel_1 = new JLabel("Reporte Tipo Usuario");
		lblNewLabel_1.setForeground(new Color(255, 255, 240));
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 27));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(143, 188, 143));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 650, 60);
		contentPane.add(lblNewLabel_1);

		btnPdf = new JButton("PDF");
		btnPdf.addActionListener(this);
		btnPdf.setBounds(511, 90, 89, 23);
		contentPane.add(btnPdf);

		cargarDataComboBox();
	}

	private void cargarDataComboBox() {
		ArrayList<TipoUsuario> listarTipoUsuarios = gTipoUser.listaTipoUsuario();
		if (listarTipoUsuarios.size() == 0) {
			mensajeError("La lista se encuentra vacía");
		} else {
			cboTipoUsuario.addItem("Seleccione...");
			for (TipoUsuario tu : listarTipoUsuarios) {
				cboTipoUsuario.addItem(tu.getCodTipoUsuario() + " - " + tu.getDescripcion());
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
			ArrayList<entidad.ReporteTipoUsuario> listaTipoUsuario = gUser.listarReporteUsuarioXTipousuario(tipo);
			if (listaTipoUsuario.size() == 0) {
				mensajeError("Lista vacía");
			} else {
				for (entidad.ReporteTipoUsuario rtu : listaTipoUsuario) {
					Object fila[] = { rtu.getCod(), rtu.getNombCompleto(), rtu.getDni(), rtu.getTelefono(),
							rtu.getUsuario(), rtu.getClave(), rtu.getDescripcion() };
					model.addRow(fila);
				}
			}
		}

	}

	private int getTipo() {
		return cboTipoUsuario.getSelectedIndex();
	}

	protected void actionPerformedBtnPdf(ActionEvent e) {
		imprimirPDF();
	}

	void imprimirPDF() {

		String nombArchivo = "Reportes/listadoUsuarios.pdf";
		try {

			Document plantilla = new Document();

			FileOutputStream fos = new FileOutputStream(nombArchivo);

			PdfWriter pdfWr = PdfWriter.getInstance(plantilla, fos);

			plantilla.open();

			Paragraph p = new Paragraph("Listado Usuarios",
					FontFactory.getFont("arial", 22, Font.BOLD, BaseColor.BLACK));
			p.setAlignment(Chunk.ALIGN_CENTER);
			plantilla.add(p);

			p = new Paragraph(" ");
			plantilla.add(p);

			int tipo = getTipo();
			if (tipo == 0) {
				return;
			} else {
				ArrayList<entidad.ReporteTipoUsuario> ListarUser = gUser.listarReporteUsuarioXTipousuario(tipo);
				if (ListarUser.size() == 0) {
					p = new Paragraph("Lista vacía", FontFactory.getFont("arial", 14, Font.ITALIC, BaseColor.RED));
				} else {

					PdfPTable tabla = new PdfPTable(7);

					tabla.addCell("Código");
					tabla.addCell("Nombre Completo");
					tabla.addCell("Dni");
					tabla.addCell("Telefono");
					tabla.addCell("Usuario");
					tabla.addCell("Clave");
					tabla.addCell("Tipo Usuario");

					for (entidad.ReporteTipoUsuario rtu : ListarUser) {

						tabla.addCell(rtu.getCod() + " ");
						tabla.addCell(rtu.getNombCompleto());
						tabla.addCell(rtu.getDni() + " ");
						tabla.addCell(rtu.getTelefono() + " ");
						tabla.addCell(rtu.getUsuario());
						tabla.addCell(rtu.getClave());
						tabla.addCell(rtu.getDescripcion() + " ");
					}
					plantilla.add(tabla);
				}
				plantilla.close();

				Desktop.getDesktop().open(new File(nombArchivo));
			}
		} catch (

		Exception e) {
			System.out.println("Error al generar reporte " + e.getMessage());
		}

	}
}
