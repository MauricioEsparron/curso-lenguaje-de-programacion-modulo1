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

import entidad.TipoUsuario;
import entidad.Usuario;
import mantenimiento.GestionClienteDAO;
import mantenimiento.GestionTipoUsuarioDAO;
import mantenimiento.GestionUsuarioDAO;
import utils.Validaciones;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

public class FrmUsuario extends JInternalFrame implements ActionListener, KeyListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblCodigoUsuario;
	private JLabel lblnombreUsuario;
	private JLabel lblApellidoUsuario;
	private JLabel lblDniUsuario;
	private JLabel lblTelefonoUsuario;
	private JTextField txtCodigoUsuario;
	private JTextField txtNombreUsuario;
	private JTextField txtApellidoUsuario;
	private JTextField txtDniUsuario;
	private JTextField txtTelefonoUsuario;
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

	GestionUsuarioDAO gUser = new GestionUsuarioDAO();
	GestionTipoUsuarioDAO gTipoUser = new GestionTipoUsuarioDAO();
	DefaultTableModel model = new DefaultTableModel();
	private JButton btnRefresh;
	private JButton btnHelp;
	private JLabel lblNewLabel_1;
	private JTextField txtCodigoTipoUsuario;
	private JPasswordField txtClave;
	private JLabel lblNewLabel_3;
	private JButton btnCodAyuda_5;
	private JLabel lblAyudaClave;
	private JLabel lblNewLabel_4;
	private JTextField txtUsuario;
	private JComboBox cboTipoUsuario;
	private JButton btnCodAyuda_6;
	private JButton btnCodAyuda_7;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmUsuario frame = new FrmUsuario();
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
	public FrmUsuario() {
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setBounds(100, 100, 775, 636);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		cboTipoUsuario = new JComboBox();
		cboTipoUsuario.addMouseListener(this);
		cboTipoUsuario.setBounds(99, 295, 133, 22);
		cboTipoUsuario.setVisible(false);
		contentPane.add(cboTipoUsuario);

		lblCodigoUsuario = new JLabel("Codigo :");
		lblCodigoUsuario.setBounds(10, 88, 62, 14);
		contentPane.add(lblCodigoUsuario);

		lblnombreUsuario = new JLabel("Nombre :");
		lblnombreUsuario.setBounds(10, 118, 62, 14);
		contentPane.add(lblnombreUsuario);

		lblApellidoUsuario = new JLabel("Apellido :");
		lblApellidoUsuario.setBounds(10, 148, 62, 14);
		contentPane.add(lblApellidoUsuario);

		lblDniUsuario = new JLabel("Dni :");
		lblDniUsuario.setBounds(10, 178, 62, 14);
		contentPane.add(lblDniUsuario);

		lblTelefonoUsuario = new JLabel("Telefono :");
		lblTelefonoUsuario.setBounds(10, 208, 62, 14);
		contentPane.add(lblTelefonoUsuario);

		txtCodigoUsuario = new JTextField();
		txtCodigoUsuario.addMouseListener(this);
		txtCodigoUsuario.setForeground(SystemColor.desktop);
		txtCodigoUsuario.setEnabled(false);
		txtCodigoUsuario.addKeyListener(this);
		txtCodigoUsuario.setBounds(101, 85, 86, 20);
		contentPane.add(txtCodigoUsuario);
		txtCodigoUsuario.setColumns(10);

		txtNombreUsuario = new JTextField();
		txtNombreUsuario.addKeyListener(this);
		txtNombreUsuario.setBounds(101, 115, 131, 20);
		contentPane.add(txtNombreUsuario);
		txtNombreUsuario.setColumns(10);

		txtApellidoUsuario = new JTextField();
		txtApellidoUsuario.addKeyListener(this);
		txtApellidoUsuario.setBounds(101, 145, 131, 20);
		contentPane.add(txtApellidoUsuario);
		txtApellidoUsuario.setColumns(10);

		txtDniUsuario = new JTextField();
		txtDniUsuario.addKeyListener(this);
		txtDniUsuario.setBounds(101, 175, 86, 20);
		contentPane.add(txtDniUsuario);
		txtDniUsuario.setColumns(10);

		txtTelefonoUsuario = new JTextField();
		txtTelefonoUsuario.addKeyListener(this);
		txtTelefonoUsuario.setBounds(101, 205, 86, 20);
		contentPane.add(txtTelefonoUsuario);
		txtTelefonoUsuario.setColumns(10);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setIcon(new ImageIcon(FrmUsuario.class.getResource("/img/370092_add_plus_create_new_icon.png")));
		btnNuevo.setBounds(492, 114, 121, 29);
		contentPane.add(btnNuevo);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setIcon(
				new ImageIcon(FrmUsuario.class.getResource("/img/7351060_bookmark_favorite_star_save_icon.png")));
		btnGuardar.setBounds(623, 114, 115, 29);
		contentPane.add(btnGuardar);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		btnActualizar.setIcon(new ImageIcon(
				FrmUsuario.class.getResource("/img/1976055_edit_edit document_edit file_edited_editing_icon.png")));
		btnActualizar.setBounds(492, 154, 121, 29);
		contentPane.add(btnActualizar);

		lblNewLabel = new JLabel("Registro Usuario");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(143, 188, 143));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 27));
		lblNewLabel.setBounds(0, 0, 779, 50);
		contentPane.add(lblNewLabel);

		lblCodAyuda = new JLabel("Autogenerable  ");
		lblCodAyuda.setBounds(236, 88, 153, 14);
		lblCodAyuda.setVisible(false);
		contentPane.add(lblCodAyuda);

		lblNombAyuda = new JLabel("(3 a 15 digitos)");
		lblNombAyuda.setBounds(281, 118, 98, 14);
		lblNombAyuda.setVisible(false);
		contentPane.add(lblNombAyuda);

		lblApeAyuda = new JLabel("(3 a 15 digitos)");
		lblApeAyuda.setBounds(281, 148, 98, 14);
		lblApeAyuda.setVisible(false);
		contentPane.add(lblApeAyuda);

		lblDniAyuda = new JLabel("(8 digitos)");
		lblDniAyuda.setBounds(237, 178, 98, 14);
		lblDniAyuda.setVisible(false);
		contentPane.add(lblDniAyuda);

		lblTelefAyuda = new JLabel("(9 digitos)");
		lblTelefAyuda.setBounds(236, 208, 121, 14);
		lblTelefAyuda.setVisible(false);
		contentPane.add(lblTelefAyuda);

		btnCodAyuda = new JButton("...");
		btnCodAyuda.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCodAyuda.addActionListener(this);
		btnCodAyuda.setEnabled(true);
		btnCodAyuda.setBounds(191, 84, 29, 23);
		contentPane.add(btnCodAyuda);

		btnCodAyuda_1 = new JButton("...");
		btnCodAyuda_1.addActionListener(this);
		btnCodAyuda_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCodAyuda_1.setEnabled(true);
		btnCodAyuda_1.setBounds(242, 114, 29, 23);
		contentPane.add(btnCodAyuda_1);

		btnCodAyuda_2 = new JButton("...");
		btnCodAyuda_2.addActionListener(this);
		btnCodAyuda_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCodAyuda_2.setEnabled(true);
		btnCodAyuda_2.setBounds(242, 144, 29, 23);
		contentPane.add(btnCodAyuda_2);

		btnCodAyuda_3 = new JButton("...");
		btnCodAyuda_3.addActionListener(this);
		btnCodAyuda_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCodAyuda_3.setEnabled(true);
		btnCodAyuda_3.setBounds(197, 174, 29, 23);
		contentPane.add(btnCodAyuda_3);

		btnCodAyuda_4 = new JButton("...");
		btnCodAyuda_4.addActionListener(this);
		btnCodAyuda_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCodAyuda_4.setEnabled(true);
		btnCodAyuda_4.setBounds(197, 204, 29, 23);
		contentPane.add(btnCodAyuda_4);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(
				new ImageIcon(FrmUsuario.class.getResource("/img/370086_bin_delete_empty_out_recycle_icon (1).png")));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(623, 154, 115, 29);
		contentPane.add(btnEliminar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 337, 739, 258);
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
		model.addColumn("Usuario");
		model.addColumn("Clave");
		model.addColumn("Tipo usuario");

		tblCliente.setModel(model);

		btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(this);
		btnRefresh.setBounds(642, 74, 96, 23);
		contentPane.add(btnRefresh);

		btnHelp = new JButton("Help");
		btnHelp.addActionListener(this);
		btnHelp.setBounds(543, 74, 89, 23);
		contentPane.add(btnHelp);

		lblNewLabel_1 = new JLabel("Tipo Usuario :");
		lblNewLabel_1.setBounds(10, 299, 78, 14);
		contentPane.add(lblNewLabel_1);

		txtCodigoTipoUsuario = new JTextField();
		txtCodigoTipoUsuario.addKeyListener(this);
		txtCodigoTipoUsuario.setBounds(101, 296, 86, 20);
		contentPane.add(txtCodigoTipoUsuario);
		txtCodigoTipoUsuario.setColumns(10);

		txtClave = new JPasswordField();
		txtClave.addKeyListener(this);
		txtClave.setBounds(101, 264, 86, 20);
		contentPane.add(txtClave);

		lblNewLabel_3 = new JLabel("Clave :");
		lblNewLabel_3.setBounds(10, 267, 62, 14);
		contentPane.add(lblNewLabel_3);

		btnCodAyuda_5 = new JButton("...");
		btnCodAyuda_5.addActionListener(this);
		btnCodAyuda_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCodAyuda_5.setEnabled(true);
		btnCodAyuda_5.setBounds(197, 263, 29, 23);
		contentPane.add(btnCodAyuda_5);

		lblAyudaClave = new JLabel("(6 digitos)");
		lblAyudaClave.setBounds(236, 267, 74, 14);
		contentPane.add(lblAyudaClave);
		lblAyudaClave.setVisible(false);

		lblNewLabel_4 = new JLabel(" Usuario :");
		lblNewLabel_4.setBounds(10, 238, 62, 14);
		contentPane.add(lblNewLabel_4);

		txtUsuario = new JTextField();
		txtUsuario.addKeyListener(this);
		txtUsuario.setBounds(101, 235, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		btnCodAyuda_6 = new JButton("...");
		btnCodAyuda_6.addActionListener(this);
		btnCodAyuda_6.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCodAyuda_6.setEnabled(true);
		btnCodAyuda_6.setBounds(197, 234, 29, 23);
		contentPane.add(btnCodAyuda_6);

		btnCodAyuda_7 = new JButton("...");
		btnCodAyuda_7.addActionListener(this);
		btnCodAyuda_7.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCodAyuda_7.setEnabled(true);
		btnCodAyuda_7.setBounds(242, 295, 29, 23);
		contentPane.add(btnCodAyuda_7);

		lblNewLabel_2 = new JLabel("(1 letra seguido de 3 números)");
		lblNewLabel_2.setBounds(235, 242, 165, 14);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);

		lblNewLabel_5 = new JLabel("(Seleccione)");
		lblNewLabel_5.setBounds(281, 299, 98, 14);
		contentPane.add(lblNewLabel_5);
		lblNewLabel_5.setVisible(false);

		cargarDataClientes();

		cargarDataComboBox();

		mostrarData(0);
	}

	private void cargarDataComboBox() {
		ArrayList<TipoUsuario> listarTipoUsuario = gTipoUser.listaTipoUsuario();
		if (listarTipoUsuario.size() == 0) {
			mensajeError("la lista se encuentra vacía");
		} else {
			cboTipoUsuario.addItem("Seleccione");
			for (TipoUsuario tu : listarTipoUsuario) {
				cboTipoUsuario.addItem(tu.getCodTipoUsuario() + " - " + tu.getDescripcion());
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCodAyuda_7) {
			actionPerformedBtnCodAyuda_7(e);
		}
		if (e.getSource() == btnCodAyuda_6) {
			actionPerformedBtnCodAyuda_6(e);
		}
		if (e.getSource() == btnCodAyuda_5) {
			actionPerformedBtnCodAyuda_5(e);
		}
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

	}

	private void ingresar() {

		int dni, telef, codTipoUsuario;
		String nomb, ape, user, clave;

		nomb = getNombre();
		ape = getApellido();
		dni = getDni();
		telef = getTelefono();
		user = getUsuario();
		codTipoUsuario = getCodigoTipoUsuario();
		clave = getClave();

		if (nomb == null || ape == null || dni == -1 || telef == -1 || user == null || clave == null
				|| codTipoUsuario == 0) {
			return;
		} else {

			Usuario u = new Usuario();

			u.setNombUsuario(nomb);
			u.setApeUsuario(ape);
			u.setDni(dni);
			u.setTelefono(telef);
			u.setUsuario(user);
			u.setClave(clave);
			u.setCodTipoUsuario(codTipoUsuario);

			int res = gUser.registrar(u);

			if (res == 0) {
				mensajeError("Error en el registro");
			} else {
				mensajeExitoso("Registro Exitoso");
			}
		}

	}

	private int getCodigoTipoUsuario() {
		int codTipoUsuario = 0;
		codTipoUsuario = cboTipoUsuario.getSelectedIndex();
		if (codTipoUsuario != 0) {
			codTipoUsuario = cboTipoUsuario.getSelectedIndex();
		} else {
			mensajeError("Debes seleccionar el tipo de usuario");
			cboTipoUsuario.setSelectedIndex(0);
			cboTipoUsuario.setBackground(Color.RED);
			codTipoUsuario = 0;
		}
		return codTipoUsuario;
	}

	private void mensajeExitoso(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Sistema", 1);
	}

	private String getUsuario() {
		String user = null;
		if (txtUsuario.getText().trim().length() == 0) {
			mensajeError("Ingresar Usuario");
			txtUsuario.setBackground(Color.RED);
			txtUsuario.requestFocus();
			txtUsuario.setText("");
		} else if (txtUsuario.getText().trim().matches(Validaciones.USUARIO)) {
			user = txtUsuario.getText().trim();
		} else {
			mensajeError(
					"Formato de usuario no valido,debe cumplir con la siguiente estructura : [A-Z]{0-9} Ejem: U001");
			txtUsuario.setBackground(Color.RED);
			txtUsuario.requestFocus();
			user = null;
		}
		return user;
	}

	private String getClave() {
		String pass = null;

		if (txtClave.getPassword().length == 0) {
			mensajeError("Ingresa tu clave");
			txtClave.requestFocus();
			txtClave.setBackground(Color.RED);
			pass = null;
		} else if (txtClave.getPassword().length == 4) {
			pass = String.valueOf(txtClave.getPassword());
		} else {
			mensajeError("la clave debe contener 4 digitos");
			txtClave.setBackground(Color.RED);
			txtClave.setText("");
			txtClave.requestFocus();
			pass = null;
		}

		return pass;
	}

	private int getTelefono() {
		int telef = -1;
		if (txtTelefonoUsuario.getText().trim().length() == 0) {
			mensajeError("El campo es obligatorio, porfavor ingrese un Telefono");
			txtTelefonoUsuario.requestFocus();
			txtTelefonoUsuario.setBackground(Color.RED);
			telef = -1;
		} else if (txtTelefonoUsuario.getText().trim().matches(Validaciones.TELEFONO)) {
			telef = Integer.parseInt(txtTelefonoUsuario.getText());
		} else {
			mensajeError("El telefono debe contener 9 caracteres");
			txtTelefonoUsuario.setText("");
			txtTelefonoUsuario.requestFocus();
			txtTelefonoUsuario.setBackground(Color.RED);
			telef = -1;
		}

		return telef;
	}

	private int getDni() {
		int dni = -1;
		if (txtDniUsuario.getText().trim().length() == 0) {
			mensajeError("El campo es obligatorio, porfavor ingrese un número de Dni");
			txtDniUsuario.requestFocus();
			txtDniUsuario.setBackground(Color.RED);
			dni = -1;
		} else if (txtDniUsuario.getText().trim().matches(Validaciones.DNI)) {
			dni = Integer.parseInt(txtDniUsuario.getText());
		} else {
			mensajeError("El DNI debe contener 8 caracteres");
			txtDniUsuario.setText("");
			txtDniUsuario.requestFocus();
			txtDniUsuario.setBackground(Color.RED);
			dni = -1;
		}
		return dni;
	}

	private String getApellido() {
		String ape = null;
		if (txtApellidoUsuario.getText().trim().length() == 0) {
			mensajeError("El campo es obligatorio, porfavor ingrese un apellido");
			txtApellidoUsuario.requestFocus();
			txtApellidoUsuario.setBackground(Color.RED);
			ape = null;
		} else if (txtApellidoUsuario.getText().trim().matches(Validaciones.APELLIDO)) {
			ape = txtApellidoUsuario.getText();

		} else {
			mensajeError("Debes ingresar un nombre que contenga de 3 a 45 caracteres");
			txtApellidoUsuario.setText("");
			txtApellidoUsuario.requestFocus();
			txtApellidoUsuario.setBackground(Color.RED);
			ape = null;
		}
		return ape;
	}

	private String getNombre() {
		String nomb = null;
		if (txtNombreUsuario.getText().trim().length() == 0) {
			mensajeError("El campo es obligatorio, porfavor ingrese un Nombre");
			txtNombreUsuario.requestFocus();
			txtNombreUsuario.setBackground(Color.RED);
			nomb = null;
		} else if (txtNombreUsuario.getText().trim().matches(Validaciones.NOMBRE)) {
			nomb = txtNombreUsuario.getText();
		} else {
			mensajeError("Debes ingresar un nombre que contenga de 3 a 45 caracteres");
			txtNombreUsuario.setText("");
			txtNombreUsuario.requestFocus();
			txtNombreUsuario.setBackground(Color.RED);
			nomb = null;
		}
		return nomb;
	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error !!!", 0);

	}

	public void keyPressed(KeyEvent e) {
		if (e.getSource() == txtClave) {
			keyPressedTxtClave(e);
		}
		if (e.getSource() == txtUsuario) {
			keyPressedTxtUsuario(e);
		}
		if (e.getSource() == txtTelefonoUsuario) {
			keyPressedTxtTelefonoCliente(e);
		}
		if (e.getSource() == txtDniUsuario) {
			keyPressedTxtDniCliente(e);
		}
		if (e.getSource() == txtApellidoUsuario) {
			keyPressedTxtApellidoCliente(e);
		}
		if (e.getSource() == txtNombreUsuario) {
			keyPressedTxtNombreCliente(e);
		}
		if (e.getSource() == txtCodigoUsuario) {
			keyPressedTxtCodigoCliente(e);
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtCodigoTipoUsuario) {
			keyReleasedTxtCodigoTipoUsuario(e);
		}
		if (e.getSource() == tblCliente) {
			keyReleasedTblCliente(e);
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	protected void keyPressedTxtCodigoCliente(KeyEvent e) {
		txtCodigoUsuario.setBackground(Color.WHITE);
		lblCodAyuda.setVisible(false);

	}

	protected void keyPressedTxtNombreCliente(KeyEvent e) {
		txtNombreUsuario.setBackground(Color.WHITE);
		lblNombAyuda.setVisible(false);

	}

	protected void keyPressedTxtApellidoCliente(KeyEvent e) {
		txtApellidoUsuario.setBackground(Color.WHITE);
		lblApeAyuda.setVisible(false);

	}

	protected void keyPressedTxtDniCliente(KeyEvent e) {
		txtDniUsuario.setBackground(Color.WHITE);
		lblDniAyuda.setVisible(false);

	}

	protected void keyPressedTxtTelefonoCliente(KeyEvent e) {
		txtTelefonoUsuario.setBackground(Color.WHITE);
		lblTelefAyuda.setVisible(false);

	}

	protected void keyReleasedTxtCodigoTipoUsuario(KeyEvent e) {
		txtCodigoTipoUsuario.setBackground(Color.WHITE);
	}

	protected void actionPerformedBtnNuevo(ActionEvent e) {
		txtCodigoTipoUsuario.setVisible(false);
		cboTipoUsuario.setVisible(true);
		txtCodigoUsuario.setText("Autogenerable");
		txtNombreUsuario.setText("");
		txtApellidoUsuario.setText("");
		txtDniUsuario.setText("");
		txtTelefonoUsuario.setText("");
		txtCodigoTipoUsuario.setText("");
		txtClave.setText("");
		txtUsuario.setText("");
		txtNombreUsuario.requestFocus();
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
		txtCodigoUsuario.setEnabled(true);
		txtCodigoTipoUsuario.setVisible(false);
		cboTipoUsuario.setVisible(true);
	}

	private void actualizarUsuario() {

		int cod, dni, telef, codTipoUsuario;
		String nomb, ape, user, clave;

		cod = getCodigoUsuario();
		nomb = getNombre();
		ape = getApellido();
		dni = getDni();
		telef = getTelefono();
		user = getUsuario();
		clave = getClave();
		codTipoUsuario = getCodigoTipoUsuario();

		if (cod == -1 || nomb == null || ape == null || dni == -1 || telef == -1 || user == null || clave == null
				|| codTipoUsuario == 0) {
			return;
		} else {

			Usuario u = new Usuario();

			u.setCodUsuario(cod);
			u.setNombUsuario(nomb);
			u.setApeUsuario(ape);
			u.setDni(dni);
			u.setTelefono(telef);
			u.setUsuario(user);
			u.setClave(clave);
			u.setCodTipoUsuario(codTipoUsuario);

			int ok = gUser.actualizar(u);
			if (ok == 0) {
				mensajeError("Error en la actualización");
			} else {
				mensajeExitoso("Usuario actualizado");
			}

		}

	}

	private int getCodigoUsuario() {
		int cod = -1;
		if (txtCodigoUsuario.getText().trim().length() == 0) {
			mensajeError("debes ingresar el código para poder continuar");
			txtCodigoUsuario.requestFocus();
			txtCodigoUsuario.setBackground(Color.RED);
			cod = -1;
		} else {
			cod = Integer.parseInt(txtCodigoUsuario.getText());
			txtCodigoUsuario.setBackground(Color.GREEN);
		}
		return cod;
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		txtCodigoUsuario.setEnabled(true);
		eliminarCliente();
	}

	private void eliminarCliente() {

		int codUsuario;
		int opcion;

		codUsuario = getCodigoUsuario();

		if (codUsuario == -1) {
			return;
		} else {
			opcion = JOptionPane.showConfirmDialog(this, "Desea eliminar al usuario ?", "Sistema",
					JOptionPane.YES_NO_OPTION);
			if (opcion == 0) {
				int ok = gUser.eliminar(codUsuario);
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
		ArrayList<Usuario> data = gUser.listarUsuario();
		for (Usuario u : data) {
			Object fila[] = { u.getCodUsuario(), u.getNombUsuario(), u.getApeUsuario(), u.getDni(), u.getTelefono(),
					u.getUsuario(), u.getClave(), u.getCodTipoUsuario() };

			model.addRow(fila);
		}

	}

	private void mostrarData(int posFila) {
		String codUsuario, nombUsuario, apeUsuario, dni, telefono, usuario, clave, codTipoUsuario;

		codUsuario = tblCliente.getValueAt(posFila, 0).toString();
		nombUsuario = tblCliente.getValueAt(posFila, 1).toString();
		apeUsuario = tblCliente.getValueAt(posFila, 2).toString();
		dni = tblCliente.getValueAt(posFila, 3).toString();
		telefono = tblCliente.getValueAt(posFila, 4).toString();
		usuario = tblCliente.getValueAt(posFila, 5).toString();
		clave = tblCliente.getValueAt(posFila, 6).toString();
		codTipoUsuario = tblCliente.getValueAt(posFila, 7).toString();

		txtCodigoUsuario.setText(codUsuario);
		txtNombreUsuario.setText(nombUsuario);
		txtApellidoUsuario.setText(apeUsuario);
		txtDniUsuario.setText(dni);
		txtTelefonoUsuario.setText(telefono);
		txtUsuario.setText(usuario);
		txtClave.setText(clave);
		txtCodigoTipoUsuario.setText(codTipoUsuario);

	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == txtCodigoUsuario) {
			mouseClickedTxtCodigoUsuario(e);
		}
		if (e.getSource() == cboTipoUsuario) {
			mouseClickedCboTipoUsuario(e);
		}
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
		cboTipoUsuario.setVisible(false);
		txtCodigoTipoUsuario.setVisible(true);
		mostrarData(posFila);
	}

	protected void keyReleasedTblCliente(KeyEvent e) {
		int posFila = tblCliente.getSelectedRow();

		mostrarData(posFila);
	}

	protected void actionPerformedBtnRefresh(ActionEvent e) {
		txtCodigoTipoUsuario.setVisible(true);
		cboTipoUsuario.setVisible(false);
		cargarDataClientes();
	}

	protected void actionPerformedBtnHelp(ActionEvent e) {
		@SuppressWarnings("unused")
		int opcion;
		opcion = JOptionPane
				.showConfirmDialog(this,
						"Para Registrar un Usuario debes completar todos los campos del formulario," + "\n"
								+ "No olvides cumplir con los formatos establecidos :D",
						"Sistema", JOptionPane.CLOSED_OPTION);

	}

	protected void keyPressedTxtUsuario(KeyEvent e) {
		txtUsuario.setBackground(Color.WHITE);
		lblNewLabel_2.setVisible(false);

	}

	protected void keyPressedTxtClave(KeyEvent e) {
		lblAyudaClave.setVisible(false);
		txtClave.setBackground(Color.WHITE);
	}

	protected void actionPerformedBtnCodAyuda_5(ActionEvent e) {
		lblAyudaClave.setVisible(true);
	}

	protected void actionPerformedBtnCodAyuda_6(ActionEvent e) {
		lblNewLabel_2.setVisible(true);
	}

	protected void actionPerformedBtnCodAyuda_7(ActionEvent e) {
		lblNewLabel_5.setVisible(true);
	}

	protected void mouseClickedCboTipoUsuario(MouseEvent e) {
		lblNewLabel_5.setVisible(false);
	}

	protected void mouseClickedTxtCodigoUsuario(MouseEvent e) {
		lblCodAyuda.setVisible(false);
	}
}
