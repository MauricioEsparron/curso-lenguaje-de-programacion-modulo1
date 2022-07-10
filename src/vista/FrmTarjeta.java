package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import entidad.Cliente;
import entidad.Tarjeta;
import entidad.TipoCuenta;
import mantenimiento.GestionClienteDAO;
import mantenimiento.GestionTarjetaDAO;
import mantenimiento.GestionTipoCuentaDAO;
import utils.Validaciones;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

public class FrmTarjeta extends JInternalFrame implements ActionListener, KeyListener, MouseListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNumeroTarjeta;
	private JLabel lblCodigoCliente;
	private JLabel lblCodigoCuenta;
	private JLabel lblNumeroCuenta;
	private JLabel lblFechaAfiliacion;
	private JLabel lblFechaCaducidad;
	private JLabel lblSaldo;
	private JTextField txtNumeroTarjeta;
	private JTextField txtNumeroCuenta;
	private JTextField txtSaldo;
	private JDateChooser txtFechaCaducidad;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JScrollPane scrollPane;
	private JButton btnAyuda;
	private JButton btnAyuda_1;
	private JButton btnAyuda_2;
	private JButton btnAyuda_3;
	private JLabel lblNumTarjAyuda;
	private JLabel lblCodCliAyuda;
	private JLabel lblCodCuentAyuda;
	private JLabel lblNumCuentAyuda;
	private JComboBox cboCodigoCliente;
	private JButton btnAyuda_4;
	private JLabel lblSaldoAyuda;

	GestionTarjetaDAO gTarjeta = new GestionTarjetaDAO();
	GestionClienteDAO gCliente = new GestionClienteDAO();
	GestionTipoCuentaDAO gTipoCuenta = new GestionTipoCuentaDAO();
	DefaultTableModel model = new DefaultTableModel();

	private JTable tblTarjeta;
	private JComboBox cboCodTipoCuenta;
	private JButton btnRefresh;
	private JButton btnEliminar;
	private JButton btnActualizar;
	private JDateChooser txtFechaAfiliacion;
	private JTextField txtCodigoCliente;
	private JTextField txtCodigoTipoCuenta;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTarjeta frame = new FrmTarjeta();
					frame.setVisible(true);
					frame.setBounds(10, 10, 70, 50);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmTarjeta() {
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setBounds(100, 100, 716, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Registro de Tarjeta");
		lblNewLabel.setForeground(new Color(255, 255, 240));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(143, 188, 143));
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 700, 51);
		contentPane.add(lblNewLabel);

		lblNumeroTarjeta = new JLabel("Numero Tarjeta :");
		lblNumeroTarjeta.setBounds(10, 92, 96, 14);
		contentPane.add(lblNumeroTarjeta);

		lblCodigoCliente = new JLabel("cod cliente :");
		lblCodigoCliente.setBounds(10, 117, 96, 14);
		contentPane.add(lblCodigoCliente);

		lblCodigoCuenta = new JLabel("Cod Tipo cuenta :");
		lblCodigoCuenta.setBounds(10, 142, 107, 14);
		contentPane.add(lblCodigoCuenta);

		lblNumeroCuenta = new JLabel("Num cuenta :");
		lblNumeroCuenta.setBounds(10, 167, 96, 14);
		contentPane.add(lblNumeroCuenta);

		lblFechaAfiliacion = new JLabel("Fecha afiliación :");
		lblFechaAfiliacion.setBounds(10, 193, 96, 14);
		contentPane.add(lblFechaAfiliacion);

		lblFechaCaducidad = new JLabel("Fecha caducidad :");
		lblFechaCaducidad.setBounds(10, 218, 96, 14);
		contentPane.add(lblFechaCaducidad);

		lblSaldo = new JLabel("Saldo :");
		lblSaldo.setBounds(10, 243, 96, 14);
		contentPane.add(lblSaldo);

		txtNumeroTarjeta = new JTextField();
		txtNumeroTarjeta.addKeyListener(this);
		txtNumeroTarjeta.setBounds(127, 89, 147, 20);
		contentPane.add(txtNumeroTarjeta);
		txtNumeroTarjeta.setColumns(10);

		txtNumeroCuenta = new JTextField();
		txtNumeroCuenta.addKeyListener(this);
		txtNumeroCuenta.setText(" ");
		txtNumeroCuenta.setBounds(127, 164, 147, 20);
		contentPane.add(txtNumeroCuenta);
		txtNumeroCuenta.setColumns(10);

		txtSaldo = new JTextField();
		txtSaldo.addKeyListener(this);
		txtSaldo.setBounds(127, 243, 116, 20);
		contentPane.add(txtSaldo);
		txtSaldo.setColumns(10);

		txtFechaCaducidad = new JDateChooser();
		txtFechaCaducidad.setDateFormatString("yyyy-MM-dd");
		txtFechaCaducidad.setBounds(127, 218, 129, 20);
		contentPane.add(txtFechaCaducidad);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setIcon(new ImageIcon(FrmTarjeta.class.getResource("/img/8201360_add_plus_new_ui_icon.png")));
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(440, 117, 104, 29);
		contentPane.add(btnNuevo);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(
				new ImageIcon(FrmTarjeta.class.getResource("/img/7351060_bookmark_favorite_star_save_icon.png")));
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(554, 117, 107, 29);
		contentPane.add(btnGuardar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 277, 700, 236);
		contentPane.add(scrollPane);

		tblTarjeta = new JTable();
		tblTarjeta.addKeyListener(this);
		tblTarjeta.addMouseListener(this);
		tblTarjeta.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTarjeta);

		btnAyuda = new JButton("...");
		btnAyuda.addActionListener(this);
		btnAyuda.setBounds(284, 88, 21, 23);
		contentPane.add(btnAyuda);

		btnAyuda_1 = new JButton("...");
		btnAyuda_1.addActionListener(this);
		btnAyuda_1.setBounds(284, 113, 21, 23);
		btnAyuda_1.setVisible(false);
		contentPane.add(btnAyuda_1);

		btnAyuda_2 = new JButton("...");
		btnAyuda_2.addActionListener(this);
		btnAyuda_2.setBounds(284, 138, 21, 23);
		btnAyuda_2.setVisible(false);
		contentPane.add(btnAyuda_2);

		btnAyuda_3 = new JButton("...");
		btnAyuda_3.addActionListener(this);
		btnAyuda_3.setBounds(284, 167, 21, 23);
		contentPane.add(btnAyuda_3);

		lblNumTarjAyuda = new JLabel("(6 digitos)");
		lblNumTarjAyuda.setBounds(315, 92, 115, 14);
		lblNumTarjAyuda.setVisible(false);
		contentPane.add(lblNumTarjAyuda);

		lblCodCliAyuda = new JLabel("(seleccione)");
		lblCodCliAyuda.setBounds(315, 117, 115, 14);
		lblCodCliAyuda.setVisible(false);
		contentPane.add(lblCodCliAyuda);

		lblCodCuentAyuda = new JLabel("(seleccione)");
		lblCodCuentAyuda.setBounds(315, 142, 115, 14);
		lblCodCuentAyuda.setVisible(false);
		contentPane.add(lblCodCuentAyuda);

		lblNumCuentAyuda = new JLabel("(4 digitos)");
		lblNumCuentAyuda.setBounds(315, 171, 115, 14);
		lblNumCuentAyuda.setVisible(false);
		contentPane.add(lblNumCuentAyuda);

		cboCodigoCliente = new JComboBox();
		cboCodigoCliente.addMouseListener(this);
		cboCodigoCliente.setBounds(126, 113, 148, 22);
		cboCodigoCliente.setVisible(false);
		contentPane.add(cboCodigoCliente);

		btnAyuda_4 = new JButton("...");
		btnAyuda_4.addActionListener(this);
		btnAyuda_4.setBounds(253, 243, 21, 23);
		contentPane.add(btnAyuda_4);

		lblSaldoAyuda = new JLabel("(solo números)");
		lblSaldoAyuda.setBounds(281, 246, 86, 14);
		lblSaldoAyuda.setVisible(false);
		contentPane.add(lblSaldoAyuda);

		model.addColumn("Num. Tarjeta");
		model.addColumn("cod. Cliente");
		model.addColumn("Cod. Cuenta");
		model.addColumn("Num. Cuenta");
		model.addColumn("Fec Afiliación");
		model.addColumn("Fec Caducidad");
		model.addColumn("Saldo");

		tblTarjeta.setModel(model);

		cboCodTipoCuenta = new JComboBox();
		cboCodTipoCuenta.addMouseListener(this);
		cboCodTipoCuenta.setBounds(127, 138, 147, 22);
		cboCodTipoCuenta.setVisible(false);
		contentPane.add(cboCodTipoCuenta);

		btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(this);
		btnRefresh.setBounds(610, 62, 80, 20);
		contentPane.add(btnRefresh);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(554, 160, 107, 29);
		contentPane.add(btnEliminar);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(440, 163, 104, 29);
		contentPane.add(btnActualizar);

		txtFechaAfiliacion = new JDateChooser();
		txtFechaAfiliacion.setDateFormatString("yyyy-MM-dd");
		txtFechaAfiliacion.setBounds(127, 190, 129, 20);
		contentPane.add(txtFechaAfiliacion);

		txtCodigoCliente = new JTextField();
		txtCodigoCliente.setBounds(127, 114, 147, 20);
		contentPane.add(txtCodigoCliente);
		txtCodigoCliente.setVisible(true);
		txtCodigoCliente.setEditable(false);
		txtCodigoCliente.setColumns(10);

		txtCodigoTipoCuenta = new JTextField();
		txtCodigoTipoCuenta.setBounds(127, 139, 147, 20);
		contentPane.add(txtCodigoTipoCuenta);
		txtCodigoTipoCuenta.setVisible(true);
		txtCodigoTipoCuenta.setEditable(false);
		txtCodigoTipoCuenta.setColumns(10);

		btnNewButton = new JButton("Help");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(528, 61, 72, 23);
		contentPane.add(btnNewButton);

		cargarDataComboBox();

		mostraDataTarjeta();

		mostrarData(0);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}
		if (e.getSource() == btnRefresh) {
			actionPerformedBtnRefresh(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
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
		mostraDataTarjeta();
	}

	private void registrar() {
		int numTarjeta;
		int codCliente;
		int codCuenta;
		int numCuenta;
		String fecAfiliacion;
		String fecCaducidad;
		double saldo;

		numTarjeta = getNumeroTarjeta();
		codCliente = getCodigoCliente();
		codCuenta = getCodigoTipoCuenta();
		numCuenta = getNumeroCuenta();
		fecAfiliacion = getFechaAfiliacion();
		fecCaducidad = getFechaCaducidad();
		saldo = getSaldo();

		if (numTarjeta == -1 || codCliente == 0 || codCuenta == 0 || numCuenta == -1 || fecAfiliacion == null
				|| fecCaducidad == null || saldo == -1) {
			return;
		} else {

			Tarjeta t = new Tarjeta();

			t.setNum_Tarjeta(numTarjeta);
			t.setCod_cliente(codCliente);
			t.setCod_cuenta(codCuenta);
			t.setNum_cuenta(numCuenta);
			t.setFecAfliacion(fecAfiliacion);
			t.setFecCaducidad(fecCaducidad);
			t.setSaldo(saldo);

			int res = gTarjeta.registrar(t);

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

	private double getSaldo() {
		double saldo = -1;
		if (txtSaldo.getText().trim().length() == 0) {
			mensajeError("Por favor ingresa el saldo del Cliente");
			txtSaldo.requestFocus();
			txtSaldo.setText("");
			txtSaldo.setBackground(Color.RED);
			saldo = -1;
		} else if (txtSaldo.getText().trim().matches(Validaciones.MONTO)) {
			saldo = Double.parseDouble(txtSaldo.getText());
		} else {
			mensajeError("Asegurate que el saldo ingresado contenga valores númericos");
			txtSaldo.requestFocus();
			txtSaldo.setText("");
			txtSaldo.setBackground(Color.RED);
			saldo = -1;
		}
		return saldo;
	}

	// aún está en prueba
	private String getFechaCaducidad() {
		String fecCaducidad = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM--dd");
		fecCaducidad = sdf.format(txtFechaCaducidad.getDate());
		return fecCaducidad;
	}

	private String getFechaAfiliacion() {
		String fecAfiliacion = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM--dd");
		fecAfiliacion = sdf.format(txtFechaAfiliacion.getDate());
		return fecAfiliacion;

	}

	private int getNumeroCuenta() {
		int numCuenta = -1;
		if (txtNumeroCuenta.getText().trim().length() == 0) {
			mensajeError("Este campo es necesario para poder continuar con la operación");
			txtNumeroCuenta.requestFocus();
			txtNumeroCuenta.setBackground(Color.RED);
			numCuenta = -1;
		} else if (txtNumeroCuenta.getText().trim().matches(Validaciones.NUM_CUENTA)) {
			numCuenta = Integer.parseInt(txtNumeroCuenta.getText());
		} else {
			mensajeError("El número de cuenta no cumple con el formato establecido");
			txtNumeroCuenta.setText("");
			txtNumeroCuenta.requestFocus();
			txtNumeroCuenta.setBackground(Color.RED);
			numCuenta = -1;
		}
		return numCuenta;
	}

	private int getCodigoTipoCuenta() {
		int codCuenta = 0;
		codCuenta = cboCodTipoCuenta.getSelectedIndex();
		if (codCuenta != 0) {
			codCuenta = cboCodTipoCuenta.getSelectedIndex();
		} else {
			mensajeError("Debes seleccionar el código de un cliente");
			cboCodTipoCuenta.setSelectedIndex(0);
			cboCodTipoCuenta.setBackground(Color.RED);
			codCuenta = 0;
		}
		return codCuenta;
	}

	private int getCodigoCliente() {
		int codCliente = 0;
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
			mensajeError("El campos es obligatorio, porfavor ingresa el número de tarjeta");
			txtNumeroTarjeta.requestFocus();
			txtNumeroTarjeta.setBackground(Color.RED);
			numTarjeta = -1;
		} else if (txtNumeroTarjeta.getText().trim().matches(Validaciones.NUM_TARJETA)) {
			numTarjeta = Integer.parseInt(txtNumeroTarjeta.getText());
		} else {
			mensajeError("El número de tarjeta no es válido asegurate de que contenga 6 digitos");
			txtNumeroTarjeta.setText("");
			txtNumeroTarjeta.requestFocus();
			txtNumeroTarjeta.setBackground(Color.RED);
			numTarjeta = -1;
		}

		return numTarjeta;
	}

	protected void actionPerformedBtnAyuda(ActionEvent e) {
		lblNumTarjAyuda.setVisible(true);
	}

	protected void actionPerformedBtnAyuda_1(ActionEvent e) {
		lblCodCliAyuda.setVisible(true);

	}

	protected void actionPerformedBtnAyuda_2(ActionEvent e) {
		lblCodCuentAyuda.setVisible(true);

	}

	protected void actionPerformedBtnAyuda_3(ActionEvent e) {
		lblNumCuentAyuda.setVisible(true);

	}

	protected void actionPerformedBtnAyuda_4(ActionEvent e) {
		lblSaldoAyuda.setVisible(true);

	}

	public void keyPressed(KeyEvent e) {
		if (e.getSource() == txtSaldo) {
			keyPressedTxtSaldo(e);
		}
		if (e.getSource() == txtNumeroCuenta) {
			keyPressedTxtNumeroCuenta(e);
		}
		if (e.getSource() == txtNumeroTarjeta) {
			keyPressedTxtNumeroTarjeta(e);
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tblTarjeta) {
			keyReleasedTblTarjeta(e);
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	protected void keyPressedTxtNumeroTarjeta(KeyEvent e) {
		lblNumTarjAyuda.setVisible(false);
		txtNumeroTarjeta.setBackground(Color.WHITE);
	}

	protected void keyPressedTxtNumeroCuenta(KeyEvent e) {
		lblNumCuentAyuda.setVisible(false);
		txtNumeroCuenta.setBackground(Color.WHITE);

	}

	protected void keyPressedTxtSaldo(KeyEvent e) {
		lblSaldoAyuda.setVisible(false);
		txtSaldo.setBackground(Color.WHITE);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == cboCodTipoCuenta) {
			mouseClickedCboCodTipoCuenta(e);
		}
		if (e.getSource() == tblTarjeta) {
			mouseClickedTblTarjeta(e);
		}
		if (e.getSource() == cboCodigoCliente) {
			mouseClickedCboCodigoCliente(e);
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		cboCodigoCliente.setBackground(Color.WHITE);
		lblCodCliAyuda.setVisible(false);
	}

	public void mouseReleased(MouseEvent e) {
		cboCodigoCliente.setBackground(Color.WHITE);
		lblCodCliAyuda.setVisible(false);
	}

	protected void mouseClickedCboCodigoCliente(MouseEvent e) {
		cboCodigoCliente.setBackground(Color.WHITE);
		lblCodCliAyuda.setVisible(false);
	}

	protected void mouseClickedCboCodTipoCuenta(MouseEvent e) {
		cboCodTipoCuenta.setBackground(Color.WHITE);
		lblCodCliAyuda.setVisible(false);
	}

	private void cargarDataComboBox() {

		ArrayList<Cliente> listaCliente = gCliente.listarCliente();
		if (listaCliente.size() == 0) {
			mensajeError("Lista cod clientes vacía");
		} else {
			cboCodigoCliente.addItem("Seleccione..");
			for (Cliente cliente : listaCliente) {
				cboCodigoCliente.addItem(cliente.getCod_cliente() + " - " + cliente.getNombre());

			}
		}

		ArrayList<TipoCuenta> listaTipoCuenta = gTipoCuenta.listaTipoCuenta();
		if (listaTipoCuenta.size() == 0) {
			mensajeError("lista tipo cuenta vacía");
		} else {
			cboCodTipoCuenta.addItem("Seleccione..");
			for (TipoCuenta tipoCuenta : listaTipoCuenta) {
				cboCodTipoCuenta.addItem(tipoCuenta.getCod_cuenta() + " - " + tipoCuenta.getDescripcion());
			}
		}

	}

	private void mostraDataTarjeta() {

		model.setRowCount(0);
		ArrayList<Tarjeta> data = gTarjeta.listartarjeta();
		for (Tarjeta t : data) {
			Object fila[] = { t.getNum_Tarjeta(), t.getCod_cliente(), t.getCodTipo_cuenta(), t.getNum_cuenta(),
					t.getFecAfliacion(), t.getFecCaducidad(), t.getSaldo() };
			model.addRow(fila);
		}

	}

	private void mostrarData(int posFila) {
		String numTarjeta, codCliente, codTipoCuenta, numCuenta, fechaAfiliacion, fechaCaducidad, saldo;

		numTarjeta = tblTarjeta.getValueAt(posFila, 0).toString();
		codCliente = tblTarjeta.getValueAt(posFila, 1).toString();
		codTipoCuenta = tblTarjeta.getValueAt(posFila, 2).toString();
		numCuenta = tblTarjeta.getValueAt(posFila, 3).toString();
		fechaAfiliacion = tblTarjeta.getValueAt(posFila, 4).toString();
		fechaCaducidad = tblTarjeta.getValueAt(posFila, 5).toString();
		saldo = tblTarjeta.getValueAt(posFila, 6).toString();

		txtNumeroTarjeta.setText(numTarjeta);
		txtCodigoCliente.setText(codCliente);
		txtCodigoTipoCuenta.setText(codTipoCuenta);
		txtNumeroCuenta.setText(numCuenta);
		try {
			txtFechaAfiliacion.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(fechaAfiliacion));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		try {
			txtFechaCaducidad.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(fechaCaducidad));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtSaldo.setText(saldo);

	}

	protected void actionPerformedBtnNuevo(ActionEvent e) {
		txtNumeroTarjeta.setText("");
		cboCodigoCliente.setSelectedIndex(0);
		cboCodTipoCuenta.setSelectedIndex(0);
		txtNumeroCuenta.setText("");
		txtSaldo.setText("");
		txtNumeroTarjeta.requestFocus();
		txtFechaAfiliacion.setDate(new Date());
		txtFechaCaducidad.setDate(new Date());
		cboCodigoCliente.setVisible(true);
		cboCodTipoCuenta.setVisible(true);
		btnAyuda_1.setVisible(true);
		btnAyuda_2.setVisible(true);
	}

	protected void actionPerformedBtnRefresh(ActionEvent e) {
		mostraDataTarjeta();
		mostrarData(0);
		cboCodigoCliente.setVisible(false);
		cboCodTipoCuenta.setVisible(false);
		txtCodigoCliente.setVisible(true);
		txtCodigoTipoCuenta.setVisible(true);
		btnAyuda_1.setVisible(false);
		btnAyuda_2.setVisible(false);
	}

	protected void actionPerformedBtnActualizar(ActionEvent e) {
		ocultar();
		actualizarTarjeta();
		mostraDataTarjeta();
	}

	private void actualizarTarjeta() {
		int numTarjeta;
		int codCliente;
		int codTipoCuenta;
		int numCuenta;
		String fecAfiliacion;
		String fecCaducidad;
		double saldo;

		numTarjeta = getNumeroTarjeta();
		codCliente = getCodigoCliente();
		codTipoCuenta = getCodigoTipoCuenta();
		numCuenta = getNumeroCuenta();
		fecAfiliacion = getFechaAfiliacion();
		fecCaducidad = getFechaCaducidad();
		saldo = getSaldo();

		if (numTarjeta == -1 || codCliente == -1 || codTipoCuenta == -1 || numCuenta == -1 || fecAfiliacion == null
				|| fecCaducidad == null || saldo == -1) {
			return;
		} else {
			Tarjeta t = new Tarjeta();

			t.setNum_Tarjeta(numTarjeta);
			t.setCod_cliente(codCliente);
			t.setCod_cuenta(codTipoCuenta);
			t.setNum_cuenta(numCuenta);
			t.setFecAfliacion(fecAfiliacion);
			t.setFecCaducidad(fecCaducidad);
			t.setSaldo(saldo);

			int ok = gTarjeta.actualizar(t);
			if (ok == 0) {
				mensajeError("Error en la actualización");
			} else {
				mensajeExitoso("Tarjetta Actualizada exitosamente");
			}

		}

	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		eliminarTarjeta();
		ocultar();
		mostraDataTarjeta();
	}

	private void eliminarTarjeta() {
		int numTarjeta;
		int opcion;

		numTarjeta = getNumeroTarjeta();

		if (numTarjeta == -1) {
			return;
		} else {
			opcion = JOptionPane.showConfirmDialog(this, "Desea eliminar la tarjeta ?", "Sistema",
					JOptionPane.YES_NO_OPTION);
			if (opcion == 0) {
				int ok = gTarjeta.eliminar(numTarjeta);
				if (ok == 0) {
					mensajeError("El Número de tarjeta ingresado no existe");
				} else {
					mensajeExitoso("La tarjeta fue elimanada con éxito");
				}
			}

		}

	}

	protected void mouseClickedTblTarjeta(MouseEvent e) {
		int posFila = tblTarjeta.getSelectedRow();

		mostrarData(posFila);

	}

	protected void keyReleasedTblTarjeta(KeyEvent e) {
		int posFila = tblTarjeta.getSelectedRow();

		mostrarData(posFila);
	}

	private void ocultar() {
		btnAyuda_1.setVisible(true);
		btnAyuda_2.setVisible(true);
		cboCodigoCliente.setVisible(true);
		cboCodTipoCuenta.setVisible(true);
		txtCodigoCliente.setVisible(false);
		txtCodigoTipoCuenta.setVisible(false);

	}

	private void mostrar() {
		btnAyuda_1.setVisible(false);
		btnAyuda_2.setVisible(false);
		cboCodigoCliente.setVisible(false);
		cboCodTipoCuenta.setVisible(false);
		txtCodigoCliente.setVisible(true);
		txtCodigoTipoCuenta.setVisible(true);
	}

	protected void actionPerformedBtnNewButton(ActionEvent e) {
		int opcion;
		opcion = JOptionPane.showConfirmDialog(this,
				"Las tarjetas solo pueden ser creadas a Clientes ya existentes, para ello selecciona " + "\n"
						+ " el botón nuevo y se desplegaran dos listas en las que debes seleccionar:" + "\n\n"
						+ " - Código del Cliente" + "\n" + " - Tipo de cuenta deseada.",
				"Sistema", JOptionPane.CLOSED_OPTION);

	}
}
