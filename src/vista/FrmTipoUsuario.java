package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidad.TipoOperacion;
import entidad.TipoUsuario;
import mantenimiento.GestionTipoOperacionDAO;
import mantenimiento.GestionTipoUsuarioDAO;
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

public class FrmTipoUsuario extends JInternalFrame implements ActionListener, KeyListener, MouseListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblCodigoTipoUsuario;
	private JLabel lblDescripcion;
	private JTextField txtCodigoTipoUsuario;
	private JTextField txtDescripcionOperacion;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private final JTable tblTipoUsuario = new JTable();
	private JScrollPane scrollPane;

	DefaultTableModel model = new DefaultTableModel();
	GestionTipoUsuarioDAO gTipoUsuarioDAO = new GestionTipoUsuarioDAO();
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnAyuda;
	private JButton btnAyuda1;
	private JLabel lblCodigotipoCuentaAyuda;
	private JLabel lblDescripcionAyuda;
	private JButton btnCancelar;
	private JButton btnRefresh;
	private JButton btnHelp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTipoUsuario frame = new FrmTipoUsuario();
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
	public FrmTipoUsuario() {
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setBounds(100, 100, 550, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Registro Tipo Usuario");
		lblNewLabel.setForeground(new Color(255, 255, 240));
		lblNewLabel.setBackground(new Color(143, 188, 143));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 534, 55);
		contentPane.add(lblNewLabel);

		lblCodigoTipoUsuario = new JLabel("Cod. Operación :");
		lblCodigoTipoUsuario.setBounds(10, 82, 106, 14);
		contentPane.add(lblCodigoTipoUsuario);

		lblDescripcion = new JLabel("Descripción :");
		lblDescripcion.setBounds(10, 118, 106, 14);
		contentPane.add(lblDescripcion);

		txtCodigoTipoUsuario = new JTextField();
		txtCodigoTipoUsuario.setEditable(false);
		txtCodigoTipoUsuario.addKeyListener(this);
		txtCodigoTipoUsuario.setBounds(115, 79, 89, 20);
		contentPane.add(txtCodigoTipoUsuario);
		txtCodigoTipoUsuario.setColumns(10);

		txtDescripcionOperacion = new JTextField();
		txtDescripcionOperacion.addKeyListener(this);
		txtDescripcionOperacion.setBounds(115, 115, 141, 20);
		contentPane.add(txtDescripcionOperacion);
		txtDescripcionOperacion.setColumns(10);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(352, 169, 114, 31);
		contentPane.add(btnNuevo);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(352, 244, 114, 31);
		contentPane.add(btnGuardar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 156, 280, 203);
		contentPane.add(scrollPane);
		tblTipoUsuario.addKeyListener(this);
		tblTipoUsuario.addMouseListener(this);
		tblTipoUsuario.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTipoUsuario);

		btnActualizar = new JButton(" Actualizar");
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(352, 205, 114, 31);
		contentPane.add(btnActualizar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(352, 280, 114, 31);
		contentPane.add(btnEliminar);

		model.addColumn("Código Operación");
		model.addColumn("Descripción");

		tblTipoUsuario.setModel(model);

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
		btnCancelar.setBounds(352, 315, 114, 35);
		contentPane.add(btnCancelar);

		btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(this);
		btnRefresh.setBounds(438, 78, 80, 23);
		contentPane.add(btnRefresh);

		btnHelp = new JButton("Help");
		btnHelp.addActionListener(this);
		btnHelp.setBounds(352, 78, 76, 23);
		contentPane.add(btnHelp);

		cargarDataTipoUsuario();

		mostrarDaTa(0);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnHelp) {
			actionPerformedBtnHelp(e);
		}
		if (e.getSource() == btnRefresh) {
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
		txtCodigoTipoUsuario.setText("");
		txtDescripcionOperacion.setText("");
		txtDescripcionOperacion.setBackground(Color.WHITE);
		txtCodigoTipoUsuario.setEditable(false);
		txtCodigoTipoUsuario.requestFocus();
	}

	protected void actionPerformedBtnGuardar(ActionEvent e) {
		registrar();
	}

	private void registrar() {

		String descripcion;

		descripcion = getDescripcion();

		if (descripcion == null) {
			return;
		} else {

			TipoUsuario to = new TipoUsuario();

			to.setDescripcion(descripcion);

			int res = gTipoUsuarioDAO.registrar(to);

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
		if (txtDescripcionOperacion.getText().trim().length() == 0) {
			mensajeError("Debes ingresar una descripción");
			txtDescripcionOperacion.requestFocus();
			txtDescripcionOperacion.setBackground(Color.RED);
			desc = null;
		} else if (txtDescripcionOperacion.getText().trim().matches(Validaciones.TEXTO)) {
			desc = txtDescripcionOperacion.getText();
		} else {
			mensajeError("la descripción ingresada no cumple con el formato permitido");
			txtDescripcionOperacion.requestFocus();
			txtDescripcionOperacion.setText("");
			txtDescripcionOperacion.setBackground(Color.RED);
			desc = null;
		}
		return desc;

	}

	public void keyPressed(KeyEvent e) {
		if (e.getSource() == txtDescripcionOperacion) {
			keyPressedTxtDescripcionTipoCuenta(e);
		}
		if (e.getSource() == txtCodigoTipoUsuario) {
			keyPressedTxtCodigoTipoCuenta(e);
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tblTipoUsuario) {
			keyReleasedTblTipoCuenta(e);
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	protected void keyPressedTxtCodigoTipoCuenta(KeyEvent e) {
		txtCodigoTipoUsuario.setBackground(Color.WHITE);
		lblCodigotipoCuentaAyuda.setVisible(false);

	}

	protected void keyPressedTxtDescripcionTipoCuenta(KeyEvent e) {
		txtDescripcionOperacion.setBackground(Color.WHITE);
		lblDescripcionAyuda.setVisible(false);

	}

	protected void actionPerformedBtnActualizar(ActionEvent e) {
		actualizarCodigoTipoUsuario();
		txtCodigoTipoUsuario.setEditable(true);
	}

	private void actualizarCodigoTipoUsuario() {

		int codTipoUsuario;
		String descripcion;

		descripcion = getDescripcion();
		codTipoUsuario = getCodigoTipoUsuario();

		if (codTipoUsuario == -1 || descripcion == null) {
			return;
		} else {
			TipoUsuario tu = new TipoUsuario();

			tu.setCodTipoUsuario(codTipoUsuario);
			tu.setDescripcion(descripcion);

			int ok = gTipoUsuarioDAO.actualizar(tu);
			if (ok == 0) {
				mensajeError("Error en la actualización");
			} else {
				mensajeExitoso("Tipo de cuenta actualizado");
			}

		}

	}

	private int getCodigoTipoUsuario() {
		int codTipoUsuario = -1;
		if (txtCodigoTipoUsuario.getText().trim().length() == 0) {
			mensajeError("Debes ingresar el código para poder continuar");
			txtCodigoTipoUsuario.requestFocus();
			txtCodigoTipoUsuario.setBackground(Color.RED);
			codTipoUsuario = -1;
		} else if (txtCodigoTipoUsuario.getText().trim().matches(Validaciones.CODIGO_CUENTA)) {
			codTipoUsuario = Integer.parseInt(txtCodigoTipoUsuario.getText());
		} else {
			mensajeError("El código ingresado no cumple con el formato permitido");
			txtCodigoTipoUsuario.requestFocus();
			txtCodigoTipoUsuario.setText("");
			txtCodigoTipoUsuario.setBackground(Color.RED);
			codTipoUsuario = -1;
		}
		return codTipoUsuario;
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		txtCodigoTipoUsuario.setEditable(true);
		eliminarCodTipoUsuario();
	}

	private void eliminarCodTipoUsuario() {
		int codTipoUsuario;
		int opcion;

		codTipoUsuario = getCodigoTipoUsuario();
		if (codTipoUsuario == -1) {
			return;
		} else {
			opcion = JOptionPane.showConfirmDialog(this, "Desea eliminar el tipo de Operación ?", "Sistema",
					JOptionPane.YES_NO_OPTION);
			if (opcion == 0) {
				int ok = gTipoUsuarioDAO.eliminar(codTipoUsuario);
				if (ok == 0) {
					mensajeError("El código ingresado no existe");
				} else {
					mensajeExitoso("El Tipo de Operación fue eliminado con éxito");
				}
			}
		}

	}

	private void cargarDataTipoUsuario() {
		model.setRowCount(0);
		ArrayList<TipoUsuario> data = gTipoUsuarioDAO.listaTipoUsuario();
		for (TipoUsuario tu : data) {
			Object fila[] = { tu.getCodTipoUsuario(), tu.getDescripcion() };

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
		txtCodigoTipoUsuario.setText("");
		txtDescripcionOperacion.setText("");
		txtCodigoTipoUsuario.requestFocus();
		txtCodigoTipoUsuario.setBackground(Color.WHITE);
		txtDescripcionOperacion.setBackground(Color.WHITE);
		txtCodigoTipoUsuario.setEditable(false);

	}

	private void mostrarDaTa(int posFila) {
		String codTipoUsuario, descripcion;

		codTipoUsuario = tblTipoUsuario.getValueAt(posFila, 0).toString();
		descripcion = tblTipoUsuario.getValueAt(posFila, 1).toString();

		txtCodigoTipoUsuario.setText(codTipoUsuario);
		txtDescripcionOperacion.setText(descripcion);

	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblTipoUsuario) {
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
		int posFila = tblTipoUsuario.getSelectedRow();

		mostrarDaTa(posFila);
	}

	protected void keyReleasedTblTipoCuenta(KeyEvent e) {
		int posFila = tblTipoUsuario.getSelectedRow();

		mostrarDaTa(posFila);
	}

	protected void actionPerformedBtnNewButton(ActionEvent e) {
		cargarDataTipoUsuario();
		lblCodigotipoCuentaAyuda.setVisible(false);
		lblCodigotipoCuentaAyuda.setVisible(false);
	}

	protected void actionPerformedBtnHelp(ActionEvent e) {
		int opcion;
		opcion = JOptionPane.showConfirmDialog(this,
				"Para realizar el Registro de un nuevo tipo de Usuario debes " + "\n"
						+ "oprimir el botón *nuevo* luego debes darle una descripción," + "\n"
						+ "y por ultimo debes darle al botón *guardar*.",
				"Sistema", JOptionPane.CLOSED_OPTION);

	}
}
