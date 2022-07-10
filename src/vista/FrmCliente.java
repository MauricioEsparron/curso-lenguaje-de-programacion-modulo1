package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidad.Cliente;
import mantenimiento.GestionClienteDAO;
import utils.Validaciones;

public class FrmCliente extends JInternalFrame implements ActionListener, KeyListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblCodigoCliente;
	private JLabel lblnombreCliente;
	private JLabel lblApellidoCliente;
	private JLabel lblDniCliente;
	private JLabel lblTelefonoCliente;
	private JTextField txtCodigoCliente;
	private JTextField txtNombreCliente;
	private JTextField txtApellidoCliente;
	private JTextField txtDniCliente;
	private JTextField txtTelefonoCliente;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnActualizar;
	private JLabel lblNewLabel;
	private JLabel lblCodAyuda;
	private JButton btnCodAyuda;
	private JButton btnCodAyuda_1;
	private JButton btnCodAyuda_2;
	private JButton btnCodAyuda_3;
	private JButton btnCodAyuda_4;
	private JLabel lblNombAyuda;
	private JLabel lblApeAyuda;
	private JLabel lblDniAyuda;
	private JLabel lblTelefAyuda;
	private JButton btnEliminar;
	private JTable tblCliente;
	private JScrollPane scrollPane;

	GestionClienteDAO gCliente = new GestionClienteDAO();
	DefaultTableModel model = new DefaultTableModel();
	private JButton btnRefresh;
	private JButton btnHelp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCliente frame = new FrmCliente();
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
	public FrmCliente() {
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setBounds(100, 100, 744, 570);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblCodigoCliente = new JLabel("Codigo :");
		lblCodigoCliente.setBounds(10, 94, 62, 14);
		contentPane.add(lblCodigoCliente);

		lblnombreCliente = new JLabel("Nombre :");
		lblnombreCliente.setBounds(10, 119, 62, 14);
		contentPane.add(lblnombreCliente);

		lblApellidoCliente = new JLabel("Apellido :");
		lblApellidoCliente.setBounds(10, 144, 62, 14);
		contentPane.add(lblApellidoCliente);

		lblDniCliente = new JLabel("Dni :");
		lblDniCliente.setBounds(10, 169, 62, 14);
		contentPane.add(lblDniCliente);

		lblTelefonoCliente = new JLabel("Telefono :");
		lblTelefonoCliente.setBounds(10, 194, 62, 14);
		contentPane.add(lblTelefonoCliente);

		txtCodigoCliente = new JTextField();
		txtCodigoCliente.setForeground(SystemColor.desktop);
		txtCodigoCliente.setEnabled(false);
		txtCodigoCliente.addKeyListener(this);
		txtCodigoCliente.setBounds(101, 91, 86, 20);
		contentPane.add(txtCodigoCliente);
		txtCodigoCliente.setColumns(10);

		txtNombreCliente = new JTextField();
		txtNombreCliente.addKeyListener(this);
		txtNombreCliente.setBounds(101, 116, 131, 20);
		contentPane.add(txtNombreCliente);
		txtNombreCliente.setColumns(10);

		txtApellidoCliente = new JTextField();
		txtApellidoCliente.addKeyListener(this);
		txtApellidoCliente.setBounds(101, 141, 131, 20);
		contentPane.add(txtApellidoCliente);
		txtApellidoCliente.setColumns(10);

		txtDniCliente = new JTextField();
		txtDniCliente.addKeyListener(this);
		txtDniCliente.setBounds(101, 166, 86, 20);
		contentPane.add(txtDniCliente);
		txtDniCliente.setColumns(10);

		txtTelefonoCliente = new JTextField();
		txtTelefonoCliente.addKeyListener(this);
		txtTelefonoCliente.setBounds(101, 191, 86, 20);
		contentPane.add(txtTelefonoCliente);
		txtTelefonoCliente.setColumns(10);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setIcon(new ImageIcon(FrmCliente.class.getResource("/img/370092_add_plus_create_new_icon.png")));
		btnNuevo.setBounds(451, 114, 115, 29);
		contentPane.add(btnNuevo);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setIcon(
				new ImageIcon(FrmCliente.class.getResource("/img/7351060_bookmark_favorite_star_save_icon.png")));
		btnGuardar.setBounds(576, 114, 115, 29);
		contentPane.add(btnGuardar);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		btnActualizar.setIcon(new ImageIcon(
				FrmCliente.class.getResource("/img/1976055_edit_edit document_edit file_edited_editing_icon.png")));
		btnActualizar.setBounds(451, 154, 115, 29);
		contentPane.add(btnActualizar);

		lblNewLabel = new JLabel("Registro Cliente");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(143, 188, 143));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 27));
		lblNewLabel.setBounds(0, 0, 779, 50);
		contentPane.add(lblNewLabel);

		lblCodAyuda = new JLabel("Autogenerable  ");
		lblCodAyuda.setBounds(226, 94, 153, 14);
		lblCodAyuda.setVisible(false);
		contentPane.add(lblCodAyuda);

		lblNombAyuda = new JLabel("(3 a 15 digitos)");
		lblNombAyuda.setBounds(281, 119, 98, 14);
		lblNombAyuda.setVisible(false);
		contentPane.add(lblNombAyuda);

		lblApeAyuda = new JLabel("(3 a 15 digitos)");
		lblApeAyuda.setBounds(281, 144, 98, 14);
		lblApeAyuda.setVisible(false);
		contentPane.add(lblApeAyuda);

		lblDniAyuda = new JLabel("(8 digitos)");
		lblDniAyuda.setBounds(237, 169, 98, 14);
		lblDniAyuda.setVisible(false);
		contentPane.add(lblDniAyuda);

		lblTelefAyuda = new JLabel("(9 digitos)");
		lblTelefAyuda.setBounds(236, 194, 121, 14);
		lblTelefAyuda.setVisible(false);
		contentPane.add(lblTelefAyuda);

		btnCodAyuda = new JButton("...");
		btnCodAyuda.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCodAyuda.addActionListener(this);
		btnCodAyuda.setEnabled(true);
		btnCodAyuda.setBounds(191, 90, 29, 23);
		contentPane.add(btnCodAyuda);

		btnCodAyuda_1 = new JButton("...");
		btnCodAyuda_1.addActionListener(this);
		btnCodAyuda_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCodAyuda_1.setEnabled(true);
		btnCodAyuda_1.setBounds(242, 115, 29, 23);
		contentPane.add(btnCodAyuda_1);

		btnCodAyuda_2 = new JButton("...");
		btnCodAyuda_2.addActionListener(this);
		btnCodAyuda_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCodAyuda_2.setEnabled(true);
		btnCodAyuda_2.setBounds(242, 140, 29, 23);
		contentPane.add(btnCodAyuda_2);

		btnCodAyuda_3 = new JButton("...");
		btnCodAyuda_3.addActionListener(this);
		btnCodAyuda_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCodAyuda_3.setEnabled(true);
		btnCodAyuda_3.setBounds(197, 165, 29, 23);
		contentPane.add(btnCodAyuda_3);

		btnCodAyuda_4 = new JButton("...");
		btnCodAyuda_4.addActionListener(this);
		btnCodAyuda_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCodAyuda_4.setEnabled(true);
		btnCodAyuda_4.setBounds(197, 190, 29, 23);
		contentPane.add(btnCodAyuda_4);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(
				new ImageIcon(FrmCliente.class.getResource("/img/370086_bin_delete_empty_out_recycle_icon (1).png")));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(576, 154, 115, 29);
		contentPane.add(btnEliminar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 246, 708, 283);
		contentPane.add(scrollPane);

		tblCliente = new JTable();
		tblCliente.addKeyListener(this);
		tblCliente.addMouseListener(this);
		tblCliente.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblCliente);

		model.addColumn("Código");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Dni");
		model.addColumn("Telefono");

		tblCliente.setModel(model);

		btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(this);
		btnRefresh.setBounds(624, 73, 78, 23);
		contentPane.add(btnRefresh);

		btnHelp = new JButton("Help");
		btnHelp.addActionListener(this);
		btnHelp.setBounds(525, 73, 89, 23);
		contentPane.add(btnHelp);

		cargarDataClientes();

		mostrarData(0);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnHelp) {
			actionPerformedBtnHelp(e);
		}
		if (e.getSource() == btnRefresh) {
			actionPerformedBtnRefresh(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}
		if (e.getSource() == btnCodAyuda_4) {
			actionPerformedBtnCodAyuda_4(e);
		}
		if (e.getSource() == btnCodAyuda_3) {
			actionPerformedBtnCodAyuda_3(e);
		}
		if (e.getSource() == btnCodAyuda_2) {
			actionPerformedBtnCodAyuda_2(e);
		}
		if (e.getSource() == btnCodAyuda_1) {
			actionPerformedBtnCodAyuda_1(e);
		}
		if (e.getSource() == btnCodAyuda) {
			actionPerformedBtnCodAyuda(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
	}

	protected void actionPerformedBtnGuardar(ActionEvent e) {
		ingresar();
		cargarDataClientes();
	}

	private void ingresar() {

		int dni, telef;
		String nomb, ape;

		nomb = getNombre();
		ape = getApellido();
		dni = getDni();
		telef = getTelefono();

		if (nomb == null || ape == null || dni == -1 || telef == -1) {
			return;
		} else {

			Cliente c = new Cliente();

			c.setNombre(nomb);
			c.setApellido(ape);
			c.setDni(dni);
			c.setTelefono(telef);

			int res = gCliente.registrar(c);

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

	private int getTelefono() {
		int telef = -1;
		if (txtTelefonoCliente.getText().trim().length() == -1) {
			mensajeError("El campo es obligatorio, porfavor ingrese un Telefono");
			txtTelefonoCliente.requestFocus();
			txtTelefonoCliente.setBackground(Color.RED);
			telef = -1;
		} else if (txtTelefonoCliente.getText().trim().matches(Validaciones.TELEFONO)) {
			telef = Integer.parseInt(txtTelefonoCliente.getText());
		} else {
			mensajeError("Ingreso de dats no válido. debe contener 9 caracteres");
			txtTelefonoCliente.setText("");
			txtTelefonoCliente.requestFocus();
			txtTelefonoCliente.setBackground(Color.RED);
			telef = -1;
		}

		return telef;
	}

	private int getDni() {
		int dni = -1;
		if (txtDniCliente.getText().trim().length() == 0) {
			mensajeError("El campo es obligatorio, porfavor ingrese un número de Dni");
			txtDniCliente.requestFocus();
			txtDniCliente.setBackground(Color.RED);
			dni = -1;
		} else if (txtDniCliente.getText().trim().matches(Validaciones.DNI)) {
			dni = Integer.parseInt(txtDniCliente.getText());
		} else {
			mensajeError("Ingreso de dats no v�lido. debe contener 8 caracteres");
			txtDniCliente.setText("");
			txtDniCliente.requestFocus();
			txtDniCliente.setBackground(Color.RED);
			dni = -1;
		}
		return dni;
	}

	private String getApellido() {
		String ape = null;
		if (txtApellidoCliente.getText().trim().length() == 0) {
			mensajeError("El campo es obligatorio, porfavor ingrese un apellido");
			txtApellidoCliente.requestFocus();
			txtApellidoCliente.setBackground(Color.RED);
			ape = null;
		} else if (txtApellidoCliente.getText().trim().matches(Validaciones.APELLIDO)) {
			ape = txtApellidoCliente.getText();
		} else {
			mensajeError("Ingresa un Apellido que contenga de 3 a 45 caracteres");
			txtApellidoCliente.setText("");
			txtApellidoCliente.requestFocus();
			txtApellidoCliente.setBackground(Color.RED);
			ape = null;
		}
		return ape;
	}

	private String getNombre() {
		String nomb = null;
		if (txtNombreCliente.getText().trim().length() == 0) {
			mensajeError("El campo es obligatorio, porfavor ingrese un Nombre");
			txtNombreCliente.requestFocus();
			txtNombreCliente.setBackground(Color.RED);
			nomb = null;
		} else if (txtNombreCliente.getText().trim().matches(Validaciones.NOMBRE)) {
			nomb = txtNombreCliente.getText();
		} else {
			mensajeError("Ingresa un Nombre que contenga de 3 a 45 caracteres");
			txtNombreCliente.setText("");
			txtNombreCliente.requestFocus();
			txtNombreCliente.setBackground(Color.RED);
			nomb = null;
		}
		return nomb;
	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error !!!", 0);

	}

	public void keyPressed(KeyEvent e) {
		if (e.getSource() == txtTelefonoCliente) {
			keyPressedTxtTelefonoCliente(e);
		}
		if (e.getSource() == txtDniCliente) {
			keyPressedTxtDniCliente(e);
		}
		if (e.getSource() == txtApellidoCliente) {
			keyPressedTxtApellidoCliente(e);
		}
		if (e.getSource() == txtNombreCliente) {
			keyPressedTxtNombreCliente(e);
		}
		if (e.getSource() == txtCodigoCliente) {
			keyPressedTxtCodigoCliente(e);
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tblCliente) {
			keyReleasedTblCliente(e);
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	protected void keyPressedTxtCodigoCliente(KeyEvent e) {
		txtCodigoCliente.setBackground(Color.WHITE);
		lblCodAyuda.setVisible(false);

	}

	protected void keyPressedTxtNombreCliente(KeyEvent e) {
		txtNombreCliente.setBackground(Color.WHITE);
		lblNombAyuda.setVisible(false);

	}

	protected void keyPressedTxtApellidoCliente(KeyEvent e) {
		txtApellidoCliente.setBackground(Color.WHITE);
		lblApeAyuda.setVisible(false);

	}

	protected void keyPressedTxtDniCliente(KeyEvent e) {
		txtDniCliente.setBackground(Color.WHITE);
		lblDniAyuda.setVisible(false);

	}

	protected void keyPressedTxtTelefonoCliente(KeyEvent e) {
		txtTelefonoCliente.setBackground(Color.WHITE);
		lblTelefAyuda.setVisible(false);

	}

	protected void actionPerformedBtnNuevo(ActionEvent e) {
		txtCodigoCliente.setText("Autogenerable");
		txtNombreCliente.setText("");
		txtApellidoCliente.setText("");
		txtDniCliente.setText("");
		txtTelefonoCliente.setText("");
		txtNombreCliente.requestFocus();
	}

	protected void actionPerformedBtnCodAyuda(ActionEvent e) {
		lblCodAyuda.setVisible(true);
	}

	protected void actionPerformedBtnCodAyuda_1(ActionEvent e) {
		lblNombAyuda.setVisible(true);

	}

	protected void actionPerformedBtnCodAyuda_2(ActionEvent e) {
		lblApeAyuda.setVisible(true);

	}

	protected void actionPerformedBtnCodAyuda_3(ActionEvent e) {
		lblDniAyuda.setVisible(true);

	}

	protected void actionPerformedBtnCodAyuda_4(ActionEvent e) {
		lblTelefAyuda.setVisible(true);

	}

	protected void actionPerformedBtnActualizar(ActionEvent e) {
		actualizarUsuario();
		cargarDataClientes();
		txtCodigoCliente.setEnabled(true);

	}

	private void actualizarUsuario() {

		int cod_cliente;
		String nombre;
		String apellido;
		int dni;
		int telefono;

		cod_cliente = getCodigoCliente();
		nombre = getNombre();
		apellido = getApellido();
		dni = getDni();
		telefono = getTelefono();

		if (cod_cliente == -1 || nombre == null || apellido == null || dni == -1 || telefono == -1) {
			return;
		} else {
			Cliente c = new Cliente();

			c.setCod(cod_cliente);
			c.setNombre(nombre);
			c.setApellido(apellido);
			c.setDni(dni);
			c.setTelefono(telefono);

			int ok = gCliente.actualizar(c);
			if (ok == 0) {
				mensajeError("Error en la actualización");
			} else {
				mensajeExitoso("Usuario actualizado");
			}

		}

	}

	private int getCodigoCliente() {
		int cod = -1;
		if (txtCodigoCliente.getText().trim().length() == 0) {
			mensajeError("debes ingresar el código para poder continuar");
			txtCodigoCliente.requestFocus();
			txtCodigoCliente.setBackground(Color.RED);
			cod = -1;
		} else {
			cod = Integer.parseInt(txtCodigoCliente.getText());
		}
		return cod;
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		txtCodigoCliente.setEnabled(true);
		eliminarCliente();
		cargarDataClientes();
	}

	private void eliminarCliente() {

		int cod_cliente;
		int opcion;

		cod_cliente = getCodigoCliente();

		if (cod_cliente == -1) {
			return;
		} else {
			opcion = JOptionPane.showConfirmDialog(this, "Desea eliminar al cliente ?", "Sistema",
					JOptionPane.YES_NO_OPTION);
			if (opcion == 0) {
				int ok = gCliente.eliminar(cod_cliente);
				if (ok == 0) {
					mensajeError("El código ingresado no existe");
				} else {
					mensajeExitoso("El Cliente fue eliminado con éxito");
				}
			}
		}

	}

	private void cargarDataClientes() {

		model.setRowCount(0);
		ArrayList<Cliente> data = gCliente.listarCliente();
		for (Cliente c : data) {
			Object fila[] = { c.getCod_cliente(), c.getNombre(), c.getApellido(), c.getDni(), c.getTelefono() };

			model.addRow(fila);
		}

	}

	private void mostrarData(int posFila) {
		String cod_cliente, nombre, apellido, dni, telefono;

		cod_cliente = tblCliente.getValueAt(posFila, 0).toString();
		nombre = tblCliente.getValueAt(posFila, 1).toString();
		apellido = tblCliente.getValueAt(posFila, 2).toString();
		dni = tblCliente.getValueAt(posFila, 3).toString();
		telefono = tblCliente.getValueAt(posFila, 4).toString();

		txtCodigoCliente.setText(cod_cliente);
		txtNombreCliente.setText(nombre);
		txtApellidoCliente.setText(apellido);
		txtDniCliente.setText(dni);
		txtTelefonoCliente.setText(telefono);

	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblCliente) {
			mouseClickedTblCliente(e);
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

	protected void mouseClickedTblCliente(MouseEvent e) {
		int posFila = tblCliente.getSelectedRow();

		mostrarData(posFila);
	}

	protected void keyReleasedTblCliente(KeyEvent e) {
		int posFila = tblCliente.getSelectedRow();

		mostrarData(posFila);
	}

	protected void actionPerformedBtnRefresh(ActionEvent e) {
		cargarDataClientes();
	}

	protected void actionPerformedBtnHelp(ActionEvent e) {
		@SuppressWarnings("unused")
		int opcion;
		opcion = JOptionPane
				.showConfirmDialog(this,
						"Para Registrar un Cliente debes completar todos los campos del formulario," + "\n"
								+ "No olvides cumplir con los formatos establecidos :D",
						"Sistema", JOptionPane.CLOSED_OPTION);

	}
}
