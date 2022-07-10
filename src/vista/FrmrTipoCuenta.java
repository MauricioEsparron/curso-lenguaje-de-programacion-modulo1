package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidad.TipoCuenta;
import mantenimiento.GestionTipoCuentaDAO;
import utils.Validaciones;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class FrmrTipoCuenta extends JInternalFrame implements ActionListener, KeyListener, MouseListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblCodigoTipoCuenta;
	private JLabel lblDescripcion;
	private JTextField txtCodigoTipoCuenta;
	private JTextField txtDescripcionTipoCuenta;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private final JTable tblTipoCuenta = new JTable();
	private JScrollPane scrollPane;

	DefaultTableModel model = new DefaultTableModel();
	GestionTipoCuentaDAO gTipoCuenta = new GestionTipoCuentaDAO();
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnAyuda;
	private JButton btnAyuda1;
	private JLabel lblCodigotipoCuentaAyuda;
	private JLabel lblDescripcionAyuda;
	private JButton btnCancelar;
	private JButton btnNewButton;
	private JButton btnHelp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmrTipoCuenta frame = new FrmrTipoCuenta();
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
	public FrmrTipoCuenta() {
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setBounds(100, 100, 534, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Registro Tipo Cuenta");
		lblNewLabel.setForeground(new Color(255, 255, 240));
		lblNewLabel.setBackground(new Color(143, 188, 143));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 517, 55);
		contentPane.add(lblNewLabel);

		lblCodigoTipoCuenta = new JLabel("Cod. tipo Cuenta :");
		lblCodigoTipoCuenta.setBounds(10, 82, 106, 14);
		contentPane.add(lblCodigoTipoCuenta);

		lblDescripcion = new JLabel("Descripción :");
		lblDescripcion.setBounds(10, 118, 106, 14);
		contentPane.add(lblDescripcion);

		txtCodigoTipoCuenta = new JTextField();
		txtCodigoTipoCuenta.setEditable(false);
		txtCodigoTipoCuenta.addKeyListener(this);
		txtCodigoTipoCuenta.setBounds(115, 79, 89, 20);
		contentPane.add(txtCodigoTipoCuenta);
		txtCodigoTipoCuenta.setColumns(10);

		txtDescripcionTipoCuenta = new JTextField();
		txtDescripcionTipoCuenta.addKeyListener(this);
		txtDescripcionTipoCuenta.setBounds(115, 115, 141, 20);
		contentPane.add(txtDescripcionTipoCuenta);
		txtDescripcionTipoCuenta.setColumns(10);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(350, 167, 114, 31);
		contentPane.add(btnNuevo);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(350, 242, 114, 31);
		contentPane.add(btnGuardar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 156, 280, 203);
		contentPane.add(scrollPane);
		tblTipoCuenta.addKeyListener(this);
		tblTipoCuenta.addMouseListener(this);
		tblTipoCuenta.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTipoCuenta);

		btnActualizar = new JButton(" Actualizar");
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(350, 203, 114, 31);
		contentPane.add(btnActualizar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(350, 278, 114, 31);
		contentPane.add(btnEliminar);

		model.addColumn("Código");
		model.addColumn("Descripción");

		tblTipoCuenta.setModel(model);

		btnAyuda = new JButton("...");
		btnAyuda.addActionListener(this);
		btnAyuda.setBounds(215, 78, 21, 23);
		contentPane.add(btnAyuda);

		btnAyuda1 = new JButton("...");
		btnAyuda1.addActionListener(this);
		btnAyuda1.setBounds(266, 114, 21, 23);
		contentPane.add(btnAyuda1);

		lblCodigotipoCuentaAyuda = new JLabel("(autogenerable)");
		lblCodigotipoCuentaAyuda.setBounds(252, 82, 106, 14);
		lblCodigotipoCuentaAyuda.setVisible(false);
		contentPane.add(lblCodigotipoCuentaAyuda);

		lblDescripcionAyuda = new JLabel("(de 3 a 45 letras)");
		lblDescripcionAyuda.setBounds(303, 118, 106, 14);
		lblDescripcionAyuda.setVisible(false);
		contentPane.add(lblDescripcionAyuda);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(350, 313, 114, 35);
		contentPane.add(btnCancelar);

		btnNewButton = new JButton("Refresh");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(431, 78, 76, 23);
		contentPane.add(btnNewButton);

		btnHelp = new JButton("Help");
		btnHelp.addActionListener(this);
		btnHelp.setBounds(352, 78, 76, 23);
		contentPane.add(btnHelp);

		cargarDataTipoCuenta();

		mostrarDaTa(0);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnHelp) {
			actionPerformedBtnHelp(e);
		}
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnAyuda1) {
			actionPerformedBtnAyuda1(e);
		}
		if (e.getSource() == btnAyuda) {
			actionPerformedBtnAyuda(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
	}

	protected void actionPerformedBtnNuevo(ActionEvent e) {
		txtCodigoTipoCuenta.setText("Autogenerable");
		txtDescripcionTipoCuenta.setText("");
		txtCodigoTipoCuenta.requestFocus();
		cargarDataTipoCuenta();
	}

	protected void actionPerformedBtnGuardar(ActionEvent e) {
		registrar();
		cargarDataTipoCuenta();
	}

	private void registrar() {

		String descripcion;

		descripcion = getDescripcion();

		if (descripcion == null) {
			return;
		} else {

			TipoCuenta tc = new TipoCuenta();

			tc.setDescripcion(descripcion);

			int res = gTipoCuenta.registrar(tc);

			if (res == 0) {
				mensajeError("Error en el registro");
			} else {
				mensajeExitoso("Registro Exitoso");
			}

		}

	}

	private void mensajeExitoso(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Sistema", 1);
	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error !!!", 0);

	}

	private String getDescripcion() {
		String desc = null;
		if (txtDescripcionTipoCuenta.getText().trim().length() == 0) {
			mensajeError("Debes ingresar una descripción");
			txtDescripcionTipoCuenta.requestFocus();
			txtDescripcionTipoCuenta.setBackground(Color.RED);
			desc = null;
		} else if (txtDescripcionTipoCuenta.getText().trim().matches(Validaciones.TEXTO)) {
			desc = txtDescripcionTipoCuenta.getText();
		} else {
			mensajeError("la descripción ingresada no cumple con el formato permitido");
			txtDescripcionTipoCuenta.requestFocus();
			txtDescripcionTipoCuenta.setText("");
			txtDescripcionTipoCuenta.setBackground(Color.RED);
			desc = null;
		}
		return desc;

	}

	public void keyPressed(KeyEvent e) {
		if (e.getSource() == txtDescripcionTipoCuenta) {
			keyPressedTxtDescripcionTipoCuenta(e);
		}
		if (e.getSource() == txtCodigoTipoCuenta) {
			keyPressedTxtCodigoTipoCuenta(e);
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tblTipoCuenta) {
			keyReleasedTblTipoCuenta(e);
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	protected void keyPressedTxtCodigoTipoCuenta(KeyEvent e) {
		txtCodigoTipoCuenta.setBackground(Color.WHITE);
		lblCodigotipoCuentaAyuda.setVisible(false);

	}

	protected void keyPressedTxtDescripcionTipoCuenta(KeyEvent e) {
		txtDescripcionTipoCuenta.setBackground(Color.WHITE);
		lblDescripcionAyuda.setVisible(false);

	}

	protected void actionPerformedBtnActualizar(ActionEvent e) {
		actualizarCodigoTipoCuenta();
		txtCodigoTipoCuenta.setEditable(true);
		cargarDataTipoCuenta();
	}

	private void actualizarCodigoTipoCuenta() {

		int codTipoCuenta;
		String descripcion;

		descripcion = getDescripcion();
		codTipoCuenta = getCodigoTipoCuenta();

		if (codTipoCuenta == -1 || descripcion == null) {
			return;
		} else {
			TipoCuenta tc = new TipoCuenta();

			tc.setCod_cuenta(codTipoCuenta);
			tc.setDescripcion(descripcion);

			int ok = gTipoCuenta.actualizar(tc);
			if (ok == 0) {
				mensajeError("Error en la actualización");
			} else {
				mensajeExitoso("Tipo de cuenta actualizado");
			}

		}

	}

	private int getCodigoTipoCuenta() {
		int codTipoCuenta = -1;
		if (txtCodigoTipoCuenta.getText().trim().length() == 0) {
			mensajeError("Debes ingresar el código para poder continuar");
			txtCodigoTipoCuenta.requestFocus();
			txtCodigoTipoCuenta.setBackground(Color.RED);
			codTipoCuenta = -1;
		} else if (txtCodigoTipoCuenta.getText().trim().matches(Validaciones.CODIGO_CUENTA)) {
			codTipoCuenta = Integer.parseInt(txtCodigoTipoCuenta.getText());
		} else {
			mensajeError("El código ingresado no cumple con el formato permitido");
			txtCodigoTipoCuenta.requestFocus();
			txtCodigoTipoCuenta.setText("");
			txtCodigoTipoCuenta.setBackground(Color.RED);
			codTipoCuenta = -1;
		}
		return codTipoCuenta;
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		txtCodigoTipoCuenta.setEditable(true);
		eliminarCodTipoCuenta();
	}

	private void eliminarCodTipoCuenta() {
		int codTipoCuenta;
		int opcion;

		codTipoCuenta = getCodigoTipoCuenta();
		if (codTipoCuenta == -1) {
			return;
		} else {
			opcion = JOptionPane.showConfirmDialog(this, "Desea eliminar el tipo de cuenta ?", "Sistema",
					JOptionPane.YES_NO_OPTION);
			if (opcion == 0) {
				int ok = gTipoCuenta.eliminar(codTipoCuenta);
				if (ok == 0) {
					mensajeError("El código ingresado no existe");
				} else {
					mensajeExitoso("El Tipo de cuenta fue eliminado con éxito");
				}
			}
		}

	}

	private void cargarDataTipoCuenta() {
		model.setRowCount(0);
		ArrayList<TipoCuenta> data = gTipoCuenta.listaTipoCuenta();
		for (TipoCuenta tc : data) {
			Object fila[] = { tc.getCod_cuenta(), tc.getDescripcion() };

			model.addRow(fila);
		}
	}

	protected void actionPerformedBtnAyuda(ActionEvent e) {
		lblCodigotipoCuentaAyuda.setVisible(true);

	}

	protected void actionPerformedBtnAyuda1(ActionEvent e) {
		lblDescripcionAyuda.setVisible(true);

	}

	protected void actionPerformedBtnCancelar(ActionEvent e) {
		txtCodigoTipoCuenta.setText("");
		txtDescripcionTipoCuenta.setText("");
		txtCodigoTipoCuenta.requestFocus();
		txtCodigoTipoCuenta.setBackground(Color.WHITE);
		txtDescripcionTipoCuenta.setBackground(Color.WHITE);
		txtCodigoTipoCuenta.setEditable(false);
		cargarDataTipoCuenta();
	}

	private void mostrarDaTa(int posFila) {
		String codTipoCuenta, descripcion;

		codTipoCuenta = tblTipoCuenta.getValueAt(posFila, 0).toString();
		descripcion = tblTipoCuenta.getValueAt(posFila, 1).toString();

		txtCodigoTipoCuenta.setText(codTipoCuenta);
		txtDescripcionTipoCuenta.setText(descripcion);

	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblTipoCuenta) {
			mouseClickedTblTipoCuenta(e);
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	protected void mouseClickedTblTipoCuenta(MouseEvent e) {
		int posFila = tblTipoCuenta.getSelectedRow();

		mostrarDaTa(posFila);
	}

	protected void keyReleasedTblTipoCuenta(KeyEvent e) {
		int posFila = tblTipoCuenta.getSelectedRow();

		mostrarDaTa(posFila);
	}

	protected void actionPerformedBtnNewButton(ActionEvent e) {
		cargarDataTipoCuenta();
		lblCodigotipoCuentaAyuda.setVisible(false);
		lblCodigotipoCuentaAyuda.setVisible(false);
	}

	protected void actionPerformedBtnHelp(ActionEvent e) {
		int opcion;
		opcion = JOptionPane.showConfirmDialog(this,
				"Para realizar el Registro de un nuevo tipo de cuenta debes " + "\n"
						+ "oprimir el botón *nuevo* luego debes darle una descripción," + "\n"
						+ "y por ultimo debes darle al botón *guardar*.",
				"Sistema", JOptionPane.CLOSED_OPTION);

	}
}
