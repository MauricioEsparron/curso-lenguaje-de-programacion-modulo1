package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class GeneradorNumeros extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnGenerar;
	private JTable tblDatos;
	private JScrollPane scrollPane;
	DefaultTableModel model = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneradorNumeros frame = new GeneradorNumeros();
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
	public GeneradorNumeros() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 354, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnGenerar = new JButton("Generar");
		btnGenerar.addActionListener(this);
		btnGenerar.setBounds(126, 15, 89, 23);
		contentPane.add(btnGenerar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 49, 320, 351);
		contentPane.add(scrollPane);

		tblDatos = new JTable();
		tblDatos.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblDatos);

		model.addColumn("Num. Tarjeta");
		model.addColumn("Num. cuenta");
		model.addColumn("Cod. cuenta");
		tblDatos.setModel(model);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGenerar) {
			actionPerformedBtnGenerar(e);
		}
	}

	protected void actionPerformedBtnGenerar(ActionEvent e) {
		generar();
	}

	void generar() {

		int num_tarjeta, num_cuenta, cod_cuenta;

		num_tarjeta = leerNumeroTarjeta();

		num_cuenta = leerNumeroCuenta();

		cod_cuenta = leerCodigoCuenta();

		if (num_tarjeta == 0 || num_cuenta == 0 || cod_cuenta == 0) {
			// mostrar ventana de error
			return;

		} else {
			// mostrar dato en la tabla

			Object fila[] = { num_tarjeta, num_cuenta, cod_cuenta };
			model.addRow(fila);

		}

	}

	private int leerCodigoCuenta() {

		Random codCuenta = new Random();

		int numero = 0;

		for (int i = 0; i < 1; i++) {

			numero = (int) (codCuenta.nextDouble(9999 - 1000 + 1) + 1000);
		}

		return numero;
	}

	private int leerNumeroCuenta() {

		Random numCuenta = new Random();

		int numero = 0;

		for (int i = 0; i < 1; i++) {

			numero = (int) (numCuenta.nextDouble(999999999 - 900000000 + 1) + 900000000);
		}
		return numero + numero;
	}

	private int leerNumeroTarjeta() {

		int numero = (int) (Math.random() * (999999 - 900000 + 1) + 900000);
		return numero;
	}
}
