package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidad.Usuario;
import hilos.HiloTiempo;
import mantenimiento.GestionUsuarioDAO;
import utils.Validaciones;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Window.Type;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Logueo extends JFrame implements WindowListener, ActionListener, MouseListener {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtClave;
	public static Logueo frame;
	private JButton btnAceptar;
	private JLabel lblTexto;
	public static JLabel lblTiempo;
	private JLabel lblCandadoCerrado;
	private JLabel lblCandadoAbierto;
	private JLabel lblImagen;
	private JLabel lblTexto2;
	private JButton btnCliente;
	private JLabel lblNewLabel;
	private JLabel lblRegistro;

	GestionUsuarioDAO gUser = new GestionUsuarioDAO();
	public static Usuario usuario = new Usuario();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Logueo();
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
	public Logueo() {
		setBackground(new Color(192, 192, 192));
		setType(Type.UTILITY);
		addWindowListener(this);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Logueo.class.getResource("/img/7142978_vent_among us_steam_icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 615);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTexto2 = new JLabel("INICIO DE SESIÓN");
		lblTexto2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTexto2.setForeground(Color.WHITE);
		lblTexto2.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 20));
		lblTexto2.setBounds(345, 181, 247, 42);
		contentPane.add(lblTexto2);

		JLabel lblUsuario = new JLabel("Cod Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsuario.setBounds(24, 193, 111, 20);
		contentPane.add(lblUsuario);

		JLabel lblClave = new JLabel("Clave:");
		lblClave.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblClave.setBounds(24, 254, 111, 20);
		contentPane.add(lblClave);

		txtUsuario = new JTextField();
		txtUsuario.setForeground(new Color(0, 0, 205));
		txtUsuario.setToolTipText("");
		txtUsuario.setBounds(145, 194, 130, 22);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtClave = new JPasswordField();
		txtClave.setBounds(145, 256, 130, 20);
		contentPane.add(txtClave);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(new Color(0, 139, 139));
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar.setForeground(new Color(255, 255, 224));
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(32, 318, 103, 35);
		contentPane.add(btnAceptar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(new Color(128, 0, 0));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalir.setForeground(new Color(255, 255, 224));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(178, 318, 96, 35);
		contentPane.add(btnSalir);

		lblTexto = new JLabel("Esta ventana se cerrara en ");
		lblTexto.setForeground(new Color(255, 255, 224));
		lblTexto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTexto.setBounds(366, 551, 170, 14);
		contentPane.add(lblTexto);

		lblTiempo = new JLabel("60s");
		lblTiempo.setForeground(new Color(255, 255, 224));
		lblTiempo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTiempo.setBounds(546, 551, 46, 14);
		contentPane.add(lblTiempo);

		lblCandadoCerrado = new JLabel("");
		lblCandadoCerrado.setHorizontalAlignment(SwingConstants.CENTER);
		lblCandadoCerrado.setIcon(
				new ImageIcon(Logueo.class.getResource("/img/5402395_encryption_lock_password_security_key_icon.png")));
		lblCandadoCerrado.setVisible(true);
		lblCandadoCerrado.setBounds(92, 47, 114, 97);
		contentPane.add(lblCandadoCerrado);

		lblCandadoAbierto = new JLabel("");
		lblCandadoAbierto.setHorizontalAlignment(SwingConstants.CENTER);
		lblCandadoAbierto.setIcon(
				new ImageIcon(Logueo.class.getResource("/img/5402433_access_decrypt_open_unlock_lock_icon.png")));
		lblCandadoAbierto.setVisible(false);
		lblCandadoAbierto.setBounds(92, 47, 114, 97);
		contentPane.add(lblCandadoAbierto);

		btnCliente = new JButton("Ingresar Como Cliente");
		btnCliente.setBackground(new Color(169, 169, 169));
		btnCliente.addActionListener(this);
		btnCliente.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		btnCliente.setForeground(new Color(255, 255, 224));
		btnCliente.setBounds(55, 461, 196, 23);
		contentPane.add(btnCliente);

		lblNewLabel = new JLabel("Ó");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(132, 397, 46, 14);
		contentPane.add(lblNewLabel);

		lblRegistro = new JLabel("Resgistrate Aquí");
		lblRegistro.setForeground(Color.BLUE);
		lblRegistro.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblRegistro.setBounds(106, 550, 96, 14);
		contentPane.add(lblRegistro);

		lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(Logueo.class.getResource("/img/Paisaje.jpg")));
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setBackground(Color.WHITE);
		lblImagen.setBounds(316, 0, 307, 576);
		contentPane.add(lblImagen);
	}

	private void iniciarConteo() {
		HiloTiempo h = new HiloTiempo();
		h.start();

	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowOpened(WindowEvent e) {
		if (e.getSource() == this) {
			windowOpenedThis(e);
		}
	}

	protected void windowOpenedThis(WindowEvent e) {
		iniciarConteo();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCliente) {
			actionPerformedBtnCliente(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}

	protected void actionPerformedBtnAceptar(ActionEvent e) {

		validarAcceso();

	}

	private void validarAcceso() {
		String user, clave;

		user = getUsuario();
		clave = getClave();

		if (user == null || clave == null) {
			return;
		} else {
			usuario = gUser.validarAcceso(user, clave);
			if (usuario == null) {
				mensajeError("Usuario y/o Password incorrectos");
			} else {
				cargarBarraProgreso();
			}
		}

	}

	private void cargarBarraProgreso() {
		PreLoader p = new PreLoader();
		p.setVisible(true);
		p.setLocationRelativeTo(this);
		this.dispose();
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

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error !!!", 0);

	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	protected void actionPerformedBtnCliente(ActionEvent e) {
		FrmPrincipal p = new FrmPrincipal();
		p.setVisible(true);
		p.setLocationRelativeTo(this);
		this.dispose();
		lblCandadoCerrado.setVisible(false);
		lblCandadoAbierto.setVisible(true);

	}
}
