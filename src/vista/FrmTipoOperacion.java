package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidad.TipoOperacion;
import mantenimiento.GestionTipoOperacionDAO;
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

public class FrmTipoOperacion extends JInternalFrame implements ActionListener, KeyListener, MouseListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblCodigoTipoCuenta;
	private JLabel lblDescripcion;
	private JTextField txtCodigoOperacion;
	private JTextField txtDescripcionOperacion;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private final JTable tblOperacion = new JTable();
	private JScrollPane scrollPane;

	DefaultTableModel model = new DefaultTableModel();
	GestionTipoOperacionDAO gTipoOperacion = new GestionTipoOperacionDAO();
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
					FrmTipoOperacion frame = new FrmTipoOperacion();
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
	public FrmTipoOperacion() {
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setBounds(100, 100, 534, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Registro Tipo operación");
		lblNewLabel.setForeground(new Color(255, 255, 240));
		lblNewLabel.setBackground(new Color(143, 188, 143));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 518, 55);
		contentPane.add(lblNewLabel);

		lblCodigoTipoCuenta = new JLabel("Cod. Operación :");
		lblCodigoTipoCuenta.setBounds(10, 82, 106, 14);
		contentPane.add(lblCodigoTipoCuenta);

		lblDescripcion = new JLabel("Descripción :");
		lblDescripcion.setBounds(10, 118, 106, 14);
		contentPane.add(lblDescripcion);

		txtCodigoOperacion = new JTextField();
		txtCodigoOperacion.setEditable(false);
		txtCodigoOperacion.addKeyListener(this);
		txtCodigoOperacion.setBounds(115, 79, 89, 20);
		contentPane.add(txtCodigoOperacion);
		txtCodigoOperacion.setColumns(10);

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
		tblOperacion.addKeyListener(this);
		tblOperacion.addMouseListener(this);
		tblOperacion.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblOperacion);

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

		tblOperacion.setModel(model);

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
		btnRefresh.setBounds(432, 78, 76, 23);
		contentPane.add(btnRefresh);
		
		btnHelp = new JButton("Help");
		btnHelp.addActionListener(this);
		btnHelp.setBounds(352, 78, 76, 23);
		contentPane.add(btnHelp);

		cargarDataTipoOperacion();

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
		txtCodigoOperacion.setText("Autogenerable");
		txtDescripcionOperacion.setText("");
		txtDescripcionOperacion.setBackground(Color.WHITE);
		txtCodigoOperacion.setEditable(false);
		txtCodigoOperacion.requestFocus();
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

			TipoOperacion to = new TipoOperacion();

			to.setDescripcion(descripcion);

			int res = gTipoOperacion.registrar(to);

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
		if (e.getSource() == txtCodigoOperacion) {
			keyPressedTxtCodigoTipoCuenta(e);
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tblOperacion) {
			keyReleasedTblTipoCuenta(e);
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	protected void keyPressedTxtCodigoTipoCuenta(KeyEvent e) {
		txtCodigoOperacion.setBackground(Color.WHITE);
		lblCodigotipoCuentaAyuda.setVisible(false);

	}

	protected void keyPressedTxtDescripcionTipoCuenta(KeyEvent e) {
		txtDescripcionOperacion.setBackground(Color.WHITE);
		lblDescripcionAyuda.setVisible(false);

	}

	protected void actionPerformedBtnActualizar(ActionEvent e) {
		actualizarCodigoTipoOperacion();
		txtCodigoOperacion.setEditable(true);
	}

	private void actualizarCodigoTipoOperacion() {

		int codTipoOperacion;
		String descripcion;

		descripcion = getDescripcion();
		codTipoOperacion = getCodigoTipoOperacion();

		if (codTipoOperacion == -1 || descripcion == null) {
			return;
		} else {
			TipoOperacion to = new TipoOperacion();

			to.setCod_operacion(codTipoOperacion);
			to.setDescripcion(descripcion);

			int ok = gTipoOperacion.actualizar(to);
			if (ok == 0) {
				mensajeError("Error en la actualización");
			} else {
				mensajeExitoso("Tipo de cuenta actualizado");
			}

		}

	}

	private int getCodigoTipoOperacion() {
		int codTipoOperacion = -1;
		if (txtCodigoOperacion.getText().trim().length() == 0) {
			mensajeError("Debes ingresar el código para poder continuar");
			txtCodigoOperacion.requestFocus();
			txtCodigoOperacion.setBackground(Color.RED);
			codTipoOperacion = -1;
		} else if (txtCodigoOperacion.getText().trim().matches(Validaciones.CODIGO_CUENTA)) {
			codTipoOperacion = Integer.parseInt(txtCodigoOperacion.getText());
		} else {
			mensajeError("El código ingresado no cumple con el formato permitido");
			txtCodigoOperacion.requestFocus();
			txtCodigoOperacion.setText("");
			txtCodigoOperacion.setBackground(Color.RED);
			codTipoOperacion = -1;
		}
		return codTipoOperacion;
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		txtCodigoOperacion.setEditable(true);
		eliminarCodTipoOperacion();
	}

	private void eliminarCodTipoOperacion() {
		int codTipoOperacion;
		int opcion;

		codTipoOperacion = getCodigoTipoOperacion();
		if (codTipoOperacion == -1) {
			return;
		} else {
			opcion = JOptionPane.showConfirmDialog(this, "Desea eliminar el tipo de Operación ?", "Sistema",
					JOptionPane.YES_NO_OPTION);
			if (opcion == 0) {
				int ok = gTipoOperacion.eliminar(codTipoOperacion);
				if (ok == 0) {
					mensajeError("El código ingresado no existe");
				} else {
					mensajeExitoso("El Tipo de Operación fue eliminado con éxito");
				}
			}
		}

	}

	private void cargarDataTipoOperacion() {
		model.setRowCount(0);
		ArrayList<TipoOperacion> data = gTipoOperacion.listaTipoOperacion();
		for (TipoOperacion to : data) {
			Object fila[] = { to.getCod_operacion(), to.getDescripcion() };

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
		txtCodigoOperacion.setText("");
		txtDescripcionOperacion.setText("");
		txtCodigoOperacion.requestFocus();
		txtCodigoOperacion.setBackground(Color.WHITE);
		txtDescripcionOperacion.setBackground(Color.WHITE);
		txtCodigoOperacion.setEditable(false);

	}

	private void mostrarDaTa(int posFila) {
		String codTipoOperacion, descripcion;

		codTipoOperacion = tblOperacion.getValueAt(posFila, 0).toString();
		descripcion = tblOperacion.getValueAt(posFila, 1).toString();

		txtCodigoOperacion.setText(codTipoOperacion);
		txtDescripcionOperacion.setText(descripcion);

	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblOperacion) {
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
		int posFila = tblOperacion.getSelectedRow();

		mostrarDaTa(posFila);
	}

	protected void keyReleasedTblTipoCuenta(KeyEvent e) {
		int posFila = tblOperacion.getSelectedRow();

		mostrarDaTa(posFila);
	}

	protected void actionPerformedBtnNewButton(ActionEvent e) {
		cargarDataTipoOperacion();
		lblCodigotipoCuentaAyuda.setVisible(false);
		lblCodigotipoCuentaAyuda.setVisible(false);
	}
	protected void actionPerformedBtnHelp(ActionEvent e) {
		int opcion;
		opcion = JOptionPane.showConfirmDialog(this,
				"Para realizar el Registro de un nuevo tipo de operación debes " + "\n" + 
						"oprimir el botón *nuevo* luego debes darle una descripción," + "\n" + 
						"y por ultimo debes darle al botón *guardar*.",
				"Sistema", JOptionPane.CLOSED_OPTION);

	}
}
