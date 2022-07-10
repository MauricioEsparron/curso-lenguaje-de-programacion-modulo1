package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidad.Cliente;
import entidad.Movimiento;
import entidad.TipoOperacion;
import mantenimiento.GestionClienteDAO;
import mantenimiento.GestionMovimientoDAO;
import mantenimiento.GestionTipoOperacionDAO;
import utils.Validaciones;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import com.toedter.calendar.JDateChooser;

public class FrmMovimiento extends JInternalFrame implements ActionListener, KeyListener, MouseListener {

	private JPanel contentPane;
	private JLabel lblNumeroTarjeta;
	private JLabel lblCodigoCliente;
	private JLabel lblNumeroDeCuenta;
	private JLabel lblCodigoOperacion;
	private JLabel lblFechaMovimiento;
	private JLabel lblNewLabel;
	private JLabel lblMonto;
	private JTextField txtNumeroTarjeta;
	private JTextField txtNumeroDeCuenta;
	private JComboBox cboOperacion;
	private JTextField txtCuentaDestino;
	private JTextField txtMonto;
	private JButton btnGuardar;
	private JButton btnEliminar;
	private JTable tblMovimiento;
	private JButton btnActualizar;
	private JButton btnNuevo;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane;

	GestionMovimientoDAO gMovimiento = new GestionMovimientoDAO();
	GestionClienteDAO gCliente = new GestionClienteDAO();
	GestionTipoOperacionDAO gTipoOperacion = new GestionTipoOperacionDAO();
	DefaultTableModel model = new DefaultTableModel();

	private JComboBox cboCodigoCliente;
	private JLabel lblNewLabel_2;
	private JTextField txtCodigoMovimiento;
	private JButton btnAyuda;
	private JButton btnAyuda_1;
	private JButton btnAyuda_2;
	private JButton btnAyuda_3;
	private JButton btnAyuda_4;
	private JButton btnAyuda_5;
	private JButton btnAyuda_6;
	private JButton btnAyuda_7;
	private JLabel lblAyuda;
	private JLabel lblDigitos;
	private JLabel lblseleccione;
	private JLabel lblDigitos_1;
	private JLabel lblseleccione_1;
	private JLabel lblautogenerable;
	private JLabel lblDigitos_2;
	private JLabel lbllimite;
	private JButton btnNewButton;
	private JDateChooser txtFechaMovimiento;
	private JTextField txtCodigoCliente;
	private JTextField txtOperacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMovimiento frame = new FrmMovimiento();
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
	public FrmMovimiento() {
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setBounds(100, 100, 844, 598);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNumeroTarjeta = new JLabel("Nro. Tarjeta :");
		lblNumeroTarjeta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumeroTarjeta.setBounds(10, 102, 109, 14);
		contentPane.add(lblNumeroTarjeta);

		lblCodigoCliente = new JLabel("Cod. Cliente :");
		lblCodigoCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodigoCliente.setBounds(10, 131, 109, 14);
		contentPane.add(lblCodigoCliente);

		lblNumeroDeCuenta = new JLabel("Num. cuenta :");
		lblNumeroDeCuenta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumeroDeCuenta.setBounds(10, 159, 109, 14);
		contentPane.add(lblNumeroDeCuenta);

		lblCodigoOperacion = new JLabel("Operación :");
		lblCodigoOperacion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodigoOperacion.setBounds(10, 189, 109, 14);
		contentPane.add(lblCodigoOperacion);

		lblFechaMovimiento = new JLabel("Fecha Transacción :");
		lblFechaMovimiento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechaMovimiento.setBounds(10, 219, 122, 14);
		contentPane.add(lblFechaMovimiento);

		lblNewLabel = new JLabel("Cuenta destino :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 244, 109, 14);
		contentPane.add(lblNewLabel);

		lblMonto = new JLabel("Monto :");
		lblMonto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMonto.setBounds(10, 269, 109, 14);
		contentPane.add(lblMonto);

		txtNumeroTarjeta = new JTextField();
		txtNumeroTarjeta.addKeyListener(this);
		txtNumeroTarjeta.setBounds(142, 99, 131, 20);
		contentPane.add(txtNumeroTarjeta);
		txtNumeroTarjeta.setColumns(10);

		txtNumeroDeCuenta = new JTextField();
		txtNumeroDeCuenta.addKeyListener(this);
		txtNumeroDeCuenta.setBounds(142, 156, 131, 20);
		contentPane.add(txtNumeroDeCuenta);
		txtNumeroDeCuenta.setColumns(10);

		cboOperacion = new JComboBox();
		cboOperacion.addMouseListener(this);
		cboOperacion.addKeyListener(this);
		cboOperacion.setBounds(142, 185, 174, 22);
		cboOperacion.setVisible(false);
		contentPane.add(cboOperacion);

		txtCuentaDestino = new JTextField();
		txtCuentaDestino.addKeyListener(this);
		txtCuentaDestino.setBounds(142, 241, 131, 20);
		contentPane.add(txtCuentaDestino);
		txtCuentaDestino.setColumns(10);

		txtMonto = new JTextField();
		txtMonto.addKeyListener(this);
		txtMonto.setBounds(142, 266, 131, 20);
		contentPane.add(txtMonto);
		txtMonto.setColumns(10);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setIcon(
				new ImageIcon(FrmMovimiento.class.getResource("/img/7351060_bookmark_favorite_star_save_icon.png")));
		btnGuardar.setBounds(686, 119, 114, 39);
		contentPane.add(btnGuardar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon(
				FrmMovimiento.class.getResource("/img/370086_bin_delete_empty_out_recycle_icon (1).png")));
		btnEliminar.setBounds(686, 164, 114, 39);
		contentPane.add(btnEliminar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 297, 808, 251);
		contentPane.add(scrollPane);

		tblMovimiento = new JTable();
		tblMovimiento.addKeyListener(this);
		tblMovimiento.addMouseListener(this);
		tblMovimiento.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblMovimiento);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		btnActualizar.setIcon(new ImageIcon(
				FrmMovimiento.class.getResource("/img/1976055_edit_edit document_edit file_edited_editing_icon.png")));
		btnActualizar.setBounds(562, 164, 114, 39);
		contentPane.add(btnActualizar);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setIcon(new ImageIcon(FrmMovimiento.class.getResource("/img/370092_add_plus_create_new_icon.png")));
		btnNuevo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNuevo.setBounds(562, 119, 114, 39);
		contentPane.add(btnNuevo);

		lblNewLabel_1 = new JLabel("Registro Movimiento");
		lblNewLabel_1.setBackground(new Color(143, 188, 143));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setForeground(new Color(255, 255, 240));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(0, 0, 828, 56);
		contentPane.add(lblNewLabel_1);

		model.addColumn("Cod Movimiento");
		model.addColumn("Nro Tarjeta");
		model.addColumn("Cod Cliente");
		model.addColumn("Num Cuenta");
		model.addColumn("Cod Operación");
		model.addColumn("Fec Transacción");
		model.addColumn("Cuenta destino");
		model.addColumn("Monto");

		tblMovimiento.setModel(model);

		cboCodigoCliente = new JComboBox();
		cboCodigoCliente.addMouseListener(this);
		cboCodigoCliente.setBounds(142, 127, 131, 22);
		cboCodigoCliente.setVisible(false);
		contentPane.add(cboCodigoCliente);

		lblNewLabel_2 = new JLabel("Cod. Movimiento :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 77, 122, 14);
		contentPane.add(lblNewLabel_2);

		txtCodigoMovimiento = new JTextField();
		txtCodigoMovimiento.setEditable(false);
		txtCodigoMovimiento.addKeyListener(this);
		txtCodigoMovimiento.setBounds(142, 74, 131, 20);
		contentPane.add(txtCodigoMovimiento);
		txtCodigoMovimiento.setColumns(10);

		btnAyuda = new JButton("...");
		btnAyuda.addActionListener(this);
		btnAyuda.setBounds(283, 71, 23, 23);
		contentPane.add(btnAyuda);

		btnAyuda_1 = new JButton("...");
		btnAyuda_1.addActionListener(this);
		btnAyuda_1.setBounds(283, 100, 23, 23);
		contentPane.add(btnAyuda_1);

		btnAyuda_2 = new JButton("...");
		btnAyuda_2.addActionListener(this);
		btnAyuda_2.setBounds(283, 125, 23, 23);
		contentPane.add(btnAyuda_2);

		btnAyuda_3 = new JButton("...");
		btnAyuda_3.addActionListener(this);
		btnAyuda_3.setBounds(283, 153, 23, 23);
		contentPane.add(btnAyuda_3);

		btnAyuda_4 = new JButton("...");
		btnAyuda_4.addActionListener(this);
		btnAyuda_4.setBounds(326, 185, 23, 23);
		contentPane.add(btnAyuda_4);

		btnAyuda_5 = new JButton("...");
		btnAyuda_5.addActionListener(this);
		btnAyuda_5.setBounds(283, 213, 23, 23);
		contentPane.add(btnAyuda_5);

		btnAyuda_6 = new JButton("...");
		btnAyuda_6.addActionListener(this);
		btnAyuda_6.setBounds(283, 238, 23, 23);
		contentPane.add(btnAyuda_6);

		btnAyuda_7 = new JButton("...");
		btnAyuda_7.addActionListener(this);
		btnAyuda_7.setBounds(283, 263, 23, 23);
		contentPane.add(btnAyuda_7);

		lblAyuda = new JLabel("(Autogenerable)");
		lblAyuda.setBounds(316, 75, 97, 14);
		lblAyuda.setVisible(false);
		contentPane.add(lblAyuda);

		lblDigitos = new JLabel("(6 digitos)");
		lblDigitos.setBounds(316, 100, 97, 14);
		lblDigitos.setVisible(false);
		contentPane.add(lblDigitos);

		lblseleccione = new JLabel("(Seleccione)");
		lblseleccione.setBounds(316, 129, 97, 14);
		lblseleccione.setVisible(false);
		contentPane.add(lblseleccione);

		lblDigitos_1 = new JLabel("(4 digitos)");
		lblDigitos_1.setBounds(316, 160, 97, 14);
		lblDigitos_1.setVisible(false);
		contentPane.add(lblDigitos_1);

		lblseleccione_1 = new JLabel("(seleccione)");
		lblseleccione_1.setBounds(359, 189, 97, 14);
		lblseleccione_1.setVisible(false);
		contentPane.add(lblseleccione_1);

		lblautogenerable = new JLabel("(Autogenerable)");
		lblautogenerable.setBounds(321, 217, 120, 14);
		lblautogenerable.setVisible(false);
		contentPane.add(lblautogenerable);

		lblDigitos_2 = new JLabel("(4 digitos)");
		lblDigitos_2.setBounds(316, 242, 97, 14);
		lblDigitos_2.setVisible(false);
		contentPane.add(lblDigitos_2);

		lbllimite = new JLabel("(limite 99999)");
		lbllimite.setBounds(316, 267, 97, 14);
		lbllimite.setVisible(false);
		contentPane.add(lbllimite);

		btnNewButton = new JButton("Refresh");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(711, 67, 89, 23);
		contentPane.add(btnNewButton);

		txtFechaMovimiento = new JDateChooser();
		txtFechaMovimiento.setBounds(142, 213, 131, 20);
		txtFechaMovimiento.setDateFormatString("yyyy-MM-dd");
		contentPane.add(txtFechaMovimiento);

		txtCodigoCliente = new JTextField();
		txtCodigoCliente.setBounds(142, 128, 131, 20);
		contentPane.add(txtCodigoCliente);
		txtCodigoCliente.setColumns(10);

		txtOperacion = new JTextField();
		txtOperacion.setBounds(142, 186, 174, 20);
		contentPane.add(txtOperacion);
		txtOperacion.setColumns(10);

		cargardataComboBox();
		mostrarDataMovimiento();
		mostrarData(0);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}
		if (e.getSource() == btnAyuda_7) {
			actionPerformedBtnAyuda_7(e);
		}
		if (e.getSource() == btnAyuda_6) {
			actionPerformedBtnAyuda_6(e);
		}
		if (e.getSource() == btnAyuda_5) {
			actionPerformedBtnAyuda_5(e);
		}
		if (e.getSource() == btnAyuda_4) {
			actionPerformedBtnAyuda_4(e);
		}
		if (e.getSource() == btnAyuda_3) {
			actionPerformedBtnAyuda_3(e);
		}
		if (e.getSource() == btnAyuda_2) {
			actionPerformedBtnAyuda_2(e);
		}
		if (e.getSource() == btnAyuda_1) {
			actionPerformedBtnAyuda_1(e);
		}
		if (e.getSource() == btnAyuda) {
			actionPerformedBtnAyuda(e);
		}
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
	}

	protected void actionPerformedBtnGuardar(ActionEvent e) {
		registrar();
		mostrarDataMovimiento();
	}

	private void registrar() {

		int num_Tarjeta;
		int cod_cliente;
		int num_cuenta;
		int operacion;
		String fecMovimiento;
		int cuenta_destino;
		double monto;

		num_Tarjeta = getNumeroTarjeta();
		cod_cliente = getCodigoCliente();
		num_cuenta = getNumCuenta();
		operacion = getOperacion();
		fecMovimiento = getfechaMovimiento();
		cuenta_destino = getCuentaDestino();
		monto = getMonto();

		if (num_Tarjeta == -1 || cod_cliente == 0 || num_cuenta == -1 || operacion == 0 || fecMovimiento == null
				|| cuenta_destino == -1 || monto == -1) {
			return;
		} else {

			Movimiento m = new Movimiento();

			m.setNum_tarjeta(num_Tarjeta);
			m.setCod_cliente(cod_cliente);
			m.setNum_cuenta(num_cuenta);
			m.setCod_operacion(operacion);
			m.setFecha_movimiento(fecMovimiento);
			m.setCuenta_destino(cuenta_destino);
			m.setMonto(monto);

			int res = gMovimiento.registrar(m);

			if (res == 0) {
				mensajeError("Error en el registro");
			} else {
				mensajeExitoso("Registro Exitoso");
			}

		}
	}

	private int getNumCuenta() {
		int cuenta = -1;
		if (txtNumeroDeCuenta.getText().trim().length() == 0) {
			mensajeError("El campo es obligatorio, porfavor ingresa tu número cuenta");
			txtNumeroDeCuenta.requestFocus();
			cuenta = -1;
		} else if (txtNumeroDeCuenta.getText().trim().matches(Validaciones.NUM_CUENTA)) {
			cuenta = Integer.parseInt(txtNumeroDeCuenta.getText());
		} else {
			mensajeError("Formato del código no válido. Ejem 0001");
			txtNumeroDeCuenta.setText("");
			txtNumeroDeCuenta.requestFocus();
			txtNumeroDeCuenta.setBackground(Color.RED);
			cuenta = -1;
		}
		return cuenta;
	}

	private int getCodigoMovimiento() {
		int cod = -1;
		if (txtCodigoMovimiento.getText().trim().length() == 0) {
			mensajeError("debes ingresar el código para poder continuar");
			txtCodigoMovimiento.requestFocus();
			txtCodigoMovimiento.setBackground(Color.RED);
			cod = -1;
		} else {
			cod = Integer.parseInt(txtCodigoMovimiento.getText());
		}
		return cod;
	}

	private double getMonto() {
		double monto = -1;
		if (txtMonto.getText().trim().length() == 0) {
			mensajeError("Ingresa un monto");
			txtMonto.requestFocus();
			txtMonto.setText("");
			txtMonto.setBackground(Color.RED);
			monto = -1;
		} else if (txtMonto.getText().trim().matches(Validaciones.MONTO)) {
			monto = Double.parseDouble(txtMonto.getText());
		} else {
			mensajeError("Solo se puede realizar transacciones hasta de S/.99999");
			txtMonto.requestFocus();
			txtMonto.setText("");
			txtMonto.setBackground(Color.RED);
			monto = -1;
		}
		return monto;

	}

	private int getCuentaDestino() {
		int cuentaDestino = -1;
		if (txtCuentaDestino.getText().trim().length() == 0) {
			mensajeError("Debe s ingresar este campo para poder continuar con la operación ");
		} else if (txtCuentaDestino.getText().trim().matches(Validaciones.NUM_CUENTA)) {
			cuentaDestino = Integer.parseInt(txtCuentaDestino.getText());
		} else {
			mensajeError("El número de cuenta no existe");
			txtCuentaDestino.setText("");
			txtCuentaDestino.requestFocus();
			txtCuentaDestino.setBackground(Color.RED);
			cuentaDestino = -1;
		}
		return cuentaDestino;
	}

	private String getfechaMovimiento() {
		String fecMovimiento = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM--dd");
		fecMovimiento = sdf.format(txtFechaMovimiento.getDate());
		return fecMovimiento;
	}

	private int getOperacion() {
		int operacion = 1;
		operacion = cboOperacion.getSelectedIndex();
		if (operacion != 0) {
			operacion = cboOperacion.getSelectedIndex();
		} else {
			mensajeError("Debes seleccionar el código de un cliente");
			cboOperacion.setSelectedIndex(0);
			cboOperacion.setBackground(Color.RED);
			operacion = 0;
		}
		return operacion;
	}

	private int getCodigoCliente() {
		int codCliente = 1;
		codCliente = cboCodigoCliente.getSelectedIndex();
		if (codCliente != 0) {
			codCliente = cboCodigoCliente.getSelectedIndex();
		} else {
			mensajeError("Debes seleccionar el código de un cliente");
			cboCodigoCliente.setSelectedIndex(0);
			cboCodigoCliente.setBackground(Color.RED);
			codCliente = 0;
		}
		return codCliente;
	}

	private int getNumeroTarjeta() {
		int numTarjeta = -1;
		if (txtNumeroTarjeta.getText().trim().length() == 0) {
			mensajeError("");
			txtNumeroTarjeta.requestFocus();
			numTarjeta = -1;
		} else if (txtNumeroTarjeta.getText().trim().matches(Validaciones.NUM_TARJETA)) {
			numTarjeta = Integer.parseInt(txtNumeroTarjeta.getText());
		} else {
			mensajeError("Formato del código no válido. Debe contener 16 caracteres");
			txtNumeroTarjeta.setText("");
			txtNumeroTarjeta.requestFocus();
			txtNumeroTarjeta.setBackground(Color.RED);
			numTarjeta = -1;
		}
		return numTarjeta;
	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error !!!", 0);

	}

	private void mensajeExitoso(String msj) {

		JOptionPane.showMessageDialog(this, msj, "Sistema", 1);

	}

	public void keyPressed(KeyEvent e) {
		if (e.getSource() == txtCodigoMovimiento) {
			keyPressedTxtCodigoMoviniento(e);
		}

		if (e.getSource() == txtMonto) {
			keyPressedTxtMonto(e);
		}
		if (e.getSource() == txtCuentaDestino) {
			keyPressedTxtCuentaDestino(e);
		}
		if (e.getSource() == txtNumeroDeCuenta) {
			keyPressedTxtNumeroDeCuenta(e);
		}
		if (e.getSource() == txtNumeroTarjeta) {
			keyPressedTxtNumeroTarjeta(e);
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tblMovimiento) {
			keyReleasedTblMovimiento(e);
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	protected void keyPressedTxtNumeroTarjeta(KeyEvent e) {
		lblDigitos.setVisible(false);
		txtNumeroTarjeta.setBackground(Color.WHITE);
	}

	protected void keyPressedTxtNumeroDeCuenta(KeyEvent e) {
		lblDigitos_1.setVisible(false);
		txtNumeroDeCuenta.setBackground(Color.WHITE);

	}

	protected void keyPressedTxtCuentaDestino(KeyEvent e) {
		lblDigitos_2.setVisible(false);
		txtCuentaDestino.setBackground(Color.WHITE);

	}

	protected void keyPressedTxtMonto(KeyEvent e) {
		lbllimite.setVisible(false);
		txtMonto.setBackground(Color.WHITE);

	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblMovimiento) {
			mouseClickedTblMovimiento(e);
		}
		if (e.getSource() == cboOperacion) {
			mouseClickedCboOperacion(e);
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		if (e.getSource() == cboCodigoCliente) {
			mousePressedCboCodigoCliente(e);
		}
	}

	public void mouseReleased(MouseEvent e) {
	}

	protected void mouseClickedCboOperacion(MouseEvent e) {
		cboOperacion.setBackground(Color.WHITE);
		lblseleccione_1.setVisible(false);
	}

	protected void actionPerformedBtnAyuda(ActionEvent e) {
		lblAyuda.setVisible(true);
	}

	protected void actionPerformedBtnAyuda_1(ActionEvent e) {
		lblDigitos.setVisible(true);
	}

	protected void actionPerformedBtnAyuda_2(ActionEvent e) {
		lblseleccione.setVisible(true);
	}

	protected void actionPerformedBtnAyuda_3(ActionEvent e) {
		lblDigitos_1.setVisible(true);
	}

	protected void actionPerformedBtnAyuda_4(ActionEvent e) {
		lblseleccione_1.setVisible(true);
	}

	protected void actionPerformedBtnAyuda_5(ActionEvent e) {
		lblautogenerable.setVisible(true);
	}

	protected void actionPerformedBtnAyuda_6(ActionEvent e) {
		lblDigitos_2.setVisible(true);
	}

	protected void actionPerformedBtnAyuda_7(ActionEvent e) {
		lbllimite.setVisible(true);
	}

	protected void keyPressedTxtCodigoMoviniento(KeyEvent e) {
		lblAyuda.setVisible(false);
	}

	protected void mousePressedCboCodigoCliente(MouseEvent e) {
		lblseleccione.setVisible(false);
	}

	private void cargardataComboBox() {
		ArrayList<Cliente> listaCliente = gCliente.listarCliente();
		if (listaCliente.size() == 0) {
			mensajeError("Lista cod clientes vacía");
		} else {
			cboCodigoCliente.addItem("Seleccione..");
			for (Cliente cliente : listaCliente) {
				cboCodigoCliente.addItem(cliente.getCod_cliente() + " - " + cliente.getNombre());

			}
		}

		ArrayList<TipoOperacion> listaTipoOperacion = gTipoOperacion.listaTipoOperacion();
		if (listaTipoOperacion.size() == 0) {
			mensajeError("Lista cod operación vacía");
		} else {
			cboOperacion.addItem("Seleccione..");
			for (TipoOperacion operacion : listaTipoOperacion) {
				cboOperacion.addItem(operacion.getCod_operacion() + " - " + operacion.getDescripcion());

			}
		}

	}

	private void mostrarDataMovimiento() {

		model.setRowCount(0);
		ArrayList<Movimiento> data = gMovimiento.listarMovimiento();
		for (Movimiento m : data) {
			Object fila[] = { m.getCod_movimiento(), m.getNum_tarjeta(), m.getCod_cliente(), m.getNum_cuenta(),
					m.getCod_operacion(), m.getFecha_movimiento(), m.getCuenta_destino(), m.getMonto() };
			model.addRow(fila);
		}

	}

	private void mostrarData(int posFila) {
		String codMovimiento, numTarjeta, codCliente, numCuenta, codOperacion, fecMovimiento, cuentaDestino, monto;

		codMovimiento = tblMovimiento.getValueAt(posFila, 0).toString();
		numTarjeta = tblMovimiento.getValueAt(posFila, 1).toString();
		codCliente = tblMovimiento.getValueAt(posFila, 2).toString();
		numCuenta = tblMovimiento.getValueAt(posFila, 3).toString();
		codOperacion = tblMovimiento.getValueAt(posFila, 4).toString();
		fecMovimiento = tblMovimiento.getValueAt(posFila, 5).toString();
		cuentaDestino = tblMovimiento.getValueAt(posFila, 6).toString();
		monto = tblMovimiento.getValueAt(posFila, 7).toString();

		txtCodigoMovimiento.setText(codMovimiento);
		txtNumeroTarjeta.setText(numTarjeta);
		txtCodigoCliente.setText(codCliente);
		txtNumeroDeCuenta.setText(numCuenta);
		txtOperacion.setText(codOperacion);
		try {
			txtFechaMovimiento.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(fecMovimiento));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtCuentaDestino.setText(cuentaDestino);
		txtMonto.setText(monto);

	}

	protected void actionPerformedBtnNewButton(ActionEvent e) {
		mostrar();
		mostrarDataMovimiento();
		mostrarData(0);
		limpiar();
	}

	protected void actionPerformedBtnNuevo(ActionEvent e) {
		txtCodigoMovimiento.setText("");
		txtNumeroTarjeta.setText("");
		cboCodigoCliente.setSelectedIndex(0);
		txtNumeroDeCuenta.setText("");
		cboOperacion.setSelectedIndex(0);
		txtFechaMovimiento.setDate(new Date());
		txtCuentaDestino.setText("");
		txtMonto.setText("");
		txtNumeroTarjeta.requestFocus();
		ocultar();
		limpiar();
	}

	protected void actionPerformedBtnActualizar(ActionEvent e) {
		actualizarMovimiento();
		mostrarDataMovimiento();
		ocultar();
		limpiar();
	}

	private void actualizarMovimiento() {

		int cod_movimiento;
		int num_tarjeta;
		int cod_cliente;
		int num_cuenta;
		int codOperacion;
		String fec_movimiento;
		int cuenta_destino;
		double monto;

		cod_movimiento = getCodigoMovimiento();
		num_tarjeta = getNumeroTarjeta();
		cod_cliente = getCodigoCliente();
		num_cuenta = getNumCuenta();
		codOperacion = getOperacion();
		fec_movimiento = getfechaMovimiento();
		cuenta_destino = getCuentaDestino();
		monto = getMonto();

		if (cod_movimiento == -1 || num_tarjeta == -1 || cod_cliente == 0 || num_cuenta == -1 || codOperacion == 0
				|| fec_movimiento == null || cuenta_destino == -1 || monto == -1) {
			return;
		} else {
			Movimiento m = new Movimiento();

			m.setCod_movimiento(cod_movimiento);
			m.setNum_tarjeta(num_tarjeta);
			m.setCod_cliente(cod_cliente);
			m.setNum_cuenta(num_cuenta);
			m.setCod_operacion(codOperacion);
			m.setFecha_movimiento(fec_movimiento);
			m.setCuenta_destino(cuenta_destino);
			m.setMonto(monto);

			int ok = gMovimiento.actualizar(m);
			if (ok == 0) {
				mensajeError("Error en la actualización");
			} else {
				mensajeExitoso("Movimento Actualizado");
			}

		}
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		eliminarMovimiento();
		ocultar();
		mostrarDataMovimiento();
	}

	private void eliminarMovimiento() {

		int codMovimiento;
		int opcion;

		codMovimiento = getCodigoMovimiento();
		if (codMovimiento == -1) {
			return;
		} else {
			opcion = JOptionPane.showConfirmDialog(this, "Desea eliminar el movimiento ?", "Sistema",
					JOptionPane.YES_NO_OPTION);
			if (opcion == 0) {
				int ok = gMovimiento.eliminar(codMovimiento);
				if (ok == 0) {
					mensajeError("El código ingresado no existe");
				} else {
					mensajeExitoso("El Movimineto bancario fue eliminado con éxito");
				}
			}
		}
	}

	protected void mouseClickedTblMovimiento(MouseEvent e) {
		int posFila = tblMovimiento.getSelectedRow();

		mostrarData(posFila);
	}

	protected void keyReleasedTblMovimiento(KeyEvent e) {
		int posFila = tblMovimiento.getSelectedRow();

		mostrarData(posFila);
	}

	private void ocultar() {
		cboCodigoCliente.setVisible(true);
		cboOperacion.setVisible(true);
		txtCodigoCliente.setVisible(false);
		txtOperacion.setVisible(false);
	}

	private void mostrar() {
		cboCodigoCliente.setVisible(false);
		cboOperacion.setVisible(false);
		txtCodigoCliente.setVisible(true);
		txtOperacion.setVisible(true);
	}

	private void limpiar() {
		txtCodigoCliente.setBackground(Color.WHITE);
		txtCodigoMovimiento.setBackground(Color.WHITE);
		txtCuentaDestino.setBackground(Color.WHITE);
		txtFechaMovimiento.setBackground(Color.WHITE);
		txtMonto.setBackground(Color.WHITE);
		txtNumeroDeCuenta.setBackground(Color.WHITE);
		txtNumeroTarjeta.setBackground(Color.WHITE);
		txtOperacion.setBackground(Color.WHITE);
		cboCodigoCliente.setBackground(Color.WHITE);
		cboOperacion.setBackground(Color.WHITE);
	}
}