package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Calculadora extends JInternalFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtTexto;
	private JButton btn1;
	private JButton btn1_3;
	private JButton btn1_4;
	private JButton btn1_6;
	private JButton btn1_1;
	private JButton btn1_2;
	private JButton btn1_5;
	private JButton btn1_7;
	private JButton btn1_8;
	private JButton btn1_9;
	private JButton btn1_10;
	private JButton btn1_11;
	private JButton btn1_12;
	private JButton btn1_13;
	private JButton btn1_14;
	private JButton btn1_15;
	private JButton btn1_16;
	private JButton btn1_17;
	private JButton btn1_18;
	private JButton btn1_19;

	String memoria1;
	String signo;
	String memoria2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
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
	public Calculadora() {
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setBackground(new Color(105, 105, 105));
		setBounds(100, 100, 419, 486);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtTexto = new JTextField();
		txtTexto.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTexto.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtTexto.setForeground(new Color(255, 255, 224));
		txtTexto.setBackground(new Color(0, 0, 0));
		txtTexto.setBounds(10, 0, 383, 64);
		contentPane.add(txtTexto);
		txtTexto.setColumns(10);

		btn1 = new JButton("1");
		btn1.addActionListener(this);
		btn1.setBackground(new Color(105, 105, 105));
		btn1.setForeground(new Color(0, 0, 0));
		btn1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		btn1.setBounds(10, 139, 89, 53);
		contentPane.add(btn1);

		btn1_3 = new JButton("2");
		btn1_3.addActionListener(this);
		btn1_3.setBackground(new Color(105, 105, 105));
		btn1_3.setForeground(new Color(0, 0, 0));
		btn1_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		btn1_3.setBounds(109, 139, 89, 53);
		contentPane.add(btn1_3);

		btn1_4 = new JButton("3");
		btn1_4.addActionListener(this);
		btn1_4.setBackground(new Color(105, 105, 105));
		btn1_4.setForeground(new Color(0, 0, 0));
		btn1_4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		btn1_4.setBounds(208, 139, 89, 53);
		contentPane.add(btn1_4);

		btn1_6 = new JButton("-");
		btn1_6.setBackground(new Color(112, 128, 144));
		btn1_6.addActionListener(this);
		btn1_6.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		btn1_6.setBounds(307, 203, 89, 53);
		contentPane.add(btn1_6);

		btn1_1 = new JButton("4");
		btn1_1.addActionListener(this);
		btn1_1.setBackground(new Color(105, 105, 105));
		btn1_1.setForeground(new Color(0, 0, 0));
		btn1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		btn1_1.setBounds(10, 203, 89, 53);
		contentPane.add(btn1_1);

		btn1_2 = new JButton("5");
		btn1_2.addActionListener(this);
		btn1_2.setBackground(new Color(105, 105, 105));
		btn1_2.setForeground(new Color(0, 0, 0));
		btn1_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		btn1_2.setBounds(109, 203, 89, 53);
		contentPane.add(btn1_2);

		btn1_5 = new JButton("6");
		btn1_5.addActionListener(this);
		btn1_5.setBackground(new Color(105, 105, 105));
		btn1_5.setForeground(new Color(0, 0, 0));
		btn1_5.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		btn1_5.setBounds(208, 203, 89, 53);
		contentPane.add(btn1_5);

		btn1_7 = new JButton("+");
		btn1_7.setBackground(new Color(112, 128, 144));
		btn1_7.addActionListener(this);
		btn1_7.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		btn1_7.setBounds(307, 75, 89, 53);
		contentPane.add(btn1_7);

		btn1_8 = new JButton("7");
		btn1_8.addActionListener(this);
		btn1_8.setBackground(new Color(105, 105, 105));
		btn1_8.setForeground(new Color(0, 0, 0));
		btn1_8.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		btn1_8.setBounds(10, 267, 89, 53);
		contentPane.add(btn1_8);

		btn1_9 = new JButton("8");
		btn1_9.addActionListener(this);
		btn1_9.setBackground(new Color(105, 105, 105));
		btn1_9.setForeground(new Color(0, 0, 0));
		btn1_9.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		btn1_9.setBounds(109, 267, 89, 53);
		contentPane.add(btn1_9);

		btn1_10 = new JButton("9");
		btn1_10.addActionListener(this);
		btn1_10.setBackground(new Color(105, 105, 105));
		btn1_10.setForeground(new Color(0, 0, 0));
		btn1_10.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		btn1_10.setBounds(208, 267, 89, 53);
		contentPane.add(btn1_10);

		btn1_11 = new JButton("*");
		btn1_11.setBackground(new Color(112, 128, 144));
		btn1_11.addActionListener(this);
		btn1_11.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		btn1_11.setBounds(307, 139, 89, 53);
		contentPane.add(btn1_11);

		btn1_12 = new JButton("0");
		btn1_12.addActionListener(this);
		btn1_12.setBackground(new Color(105, 105, 105));
		btn1_12.setForeground(new Color(0, 0, 0));
		btn1_12.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		btn1_12.setBounds(109, 331, 89, 53);
		contentPane.add(btn1_12);

		btn1_13 = new JButton("+/-");
		btn1_13.addActionListener(this);
		btn1_13.setBackground(new Color(105, 105, 105));
		btn1_13.setForeground(new Color(0, 0, 0));
		btn1_13.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		btn1_13.setBounds(10, 331, 89, 53);
		contentPane.add(btn1_13);

		btn1_14 = new JButton(".");
		btn1_14.addActionListener(this);
		btn1_14.setBackground(new Color(105, 105, 105));
		btn1_14.setForeground(new Color(0, 0, 0));
		btn1_14.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		btn1_14.setBounds(208, 331, 89, 53);
		contentPane.add(btn1_14);

		btn1_15 = new JButton("/");
		btn1_15.setBackground(new Color(112, 128, 144));
		btn1_15.addActionListener(this);
		btn1_15.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		btn1_15.setBounds(307, 267, 89, 53);
		contentPane.add(btn1_15);

		btn1_16 = new JButton("1/x");
		btn1_16.addActionListener(this);
		btn1_16.setBackground(new Color(112, 128, 144));
		btn1_16.setForeground(new Color(0, 0, 0));
		btn1_16.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		btn1_16.setBounds(10, 75, 89, 53);
		contentPane.add(btn1_16);

		btn1_17 = new JButton("CE");
		btn1_17.addActionListener(this);
		btn1_17.setBackground(new Color(112, 128, 144));
		btn1_17.setForeground(new Color(0, 0, 0));
		btn1_17.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		btn1_17.setBounds(109, 75, 89, 53);
		contentPane.add(btn1_17);

		btn1_18 = new JButton("C");
		btn1_18.addActionListener(this);
		btn1_18.setBackground(new Color(112, 128, 144));
		btn1_18.setForeground(new Color(0, 0, 0));
		btn1_18.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		btn1_18.setBounds(208, 75, 89, 53);
		contentPane.add(btn1_18);

		btn1_19 = new JButton("=");
		btn1_19.addActionListener(this);
		btn1_19.setBackground(new Color(95, 158, 160));
		btn1_19.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		btn1_19.setBounds(307, 331, 89, 53);
		contentPane.add(btn1_19);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1_9) {
			actionPerformedBtn1_9(e);
		}
		if (e.getSource() == btn1_13) {
			actionPerformedBtn1_13(e);
		}
		if (e.getSource() == btn1_15) {
			actionPerformedBtn1_15(e);
		}
		if (e.getSource() == btn1_18) {
			actionPerformedBtn1_18(e);
		}
		if (e.getSource() == btn1_5) {
			actionPerformedBtn1_5(e);
		}
		if (e.getSource() == btn1_4) {
			actionPerformedBtn1_4(e);
		}
		if (e.getSource() == btn1) {
			actionPerformedBtn1(e);
		}
		if (e.getSource() == btn1_17) {
			actionPerformedBtn1_17(e);
		}
		if (e.getSource() == btn1_1) {
			actionPerformedBtn1_1(e);
		}
		if (e.getSource() == btn1_19) {
			actionPerformedBtn1_19(e);
		}
		if (e.getSource() == btn1_7) {
			actionPerformedBtn1_7(e);
		}
		if (e.getSource() == btn1_10) {
			actionPerformedBtn1_10(e);
		}
		if (e.getSource() == btn1_16) {
			actionPerformedBtn1_16(e);
		}
		if (e.getSource() == btn1_14) {
			actionPerformedBtn1_14(e);
		}
		if (e.getSource() == btn1_11) {
			actionPerformedBtn1_11(e);
		}
		if (e.getSource() == btn1_6) {
			actionPerformedBtn1_6(e);
		}
		if (e.getSource() == btn1_2) {
			actionPerformedBtn1_2(e);
		}
		if (e.getSource() == btn1_12) {
			actionPerformedBtn1_12(e);
		}
		if (e.getSource() == btn1_3) {
			actionPerformedBtn1_3(e);
		}
		if (e.getSource() == btn1_8) {
			actionPerformedBtn1_8(e);
		}
	}

	protected void actionPerformedBtn1_8(ActionEvent e) {
		txtTexto.setText(txtTexto.getText() + "7");

	}

	protected void actionPerformedBtn1_3(ActionEvent e) {
		txtTexto.setText(txtTexto.getText() + "2");

	}

	protected void actionPerformedBtn1_12(ActionEvent e) {
		txtTexto.setText(txtTexto.getText() + "0");

	}

	protected void actionPerformedBtn1_2(ActionEvent e) {
		txtTexto.setText(txtTexto.getText() + "5");

	}

	protected void actionPerformedBtn1_6(ActionEvent e) {
		if (!txtTexto.getText().equals("")) {
			memoria1 = txtTexto.getText();
			signo = "-";
			txtTexto.setText("");
		}
	}

	protected void actionPerformedBtn1_11(ActionEvent e) {
		if (!txtTexto.getText().equals("")) {
			memoria1 = txtTexto.getText();
			signo = "*";
			txtTexto.setText("");
		}
	}

	protected void actionPerformedBtn1_14(ActionEvent e) {
		String cadena;
		cadena = txtTexto.getText();
		if (cadena.length() <= 0) {
			txtTexto.setText("0.");
		} else {
			if (!existepunto(txtTexto.getText())) {
				txtTexto.setText(txtTexto.getText() + ".");
			}
		}
	}

	private boolean existepunto(String cadena) {
		boolean resultado;
		resultado = false;
		for (int i = 0; i < cadena.length(); i++) {
			if (cadena.substring(i, i + 1).equals(".")) {
				resultado = true;
				break;
			}
		}
		return resultado;
	}

	protected void actionPerformedBtn1_16(ActionEvent e) {
		String cadena;
		Double num;
		cadena = txtTexto.getText();
		if (cadena.length() > 0) {
			num = 1 / (Double.parseDouble(cadena));
			txtTexto.setText(num.toString());
		}

	}

	protected void actionPerformedBtn1_10(ActionEvent e) {
		txtTexto.setText(txtTexto.getText() + "9");

	}

	protected void actionPerformedBtn1_7(ActionEvent e) {
		if (!txtTexto.getText().equals("")) {
			memoria1 = txtTexto.getText();
			signo = "+";
			txtTexto.setText("");
		}
	}

	protected void actionPerformedBtn1_19(ActionEvent e) {
		String resultado;
		memoria2 = txtTexto.getText();
		if (!memoria2.equals("")) {
			resultado = calculadora(memoria1, memoria2, signo);
			txtTexto.setText(resultado);
		}
	}

	private String calculadora(String memoria1, String memoria2, String signo) {
		Double resultado = 0.0;
		String respuesta;
		if (signo.equals("-")) {
			resultado = Double.parseDouble(memoria1) - Double.parseDouble(memoria2);
		}
		if (signo.equals("+")) {
			resultado = Double.parseDouble(memoria1) + Double.parseDouble(memoria2);
		}
		if (signo.equals("*")) {
			resultado = Double.parseDouble(memoria1) * Double.parseDouble(memoria2);
		}
		if (signo.equals("/")) {
			resultado = Double.parseDouble(memoria1) / Double.parseDouble(memoria2);
		}

		respuesta = resultado.toString();
		return respuesta;
	}

	protected void actionPerformedBtn1_1(ActionEvent e) {
		txtTexto.setText(txtTexto.getText() + "4");

	}

	protected void actionPerformedBtn1_17(ActionEvent e) {
		txtTexto.setText("");
	}

	protected void actionPerformedBtn1(ActionEvent e) {
		txtTexto.setText(txtTexto.getText() + "1");
	}

	protected void actionPerformedBtn1_4(ActionEvent e) {
		txtTexto.setText(txtTexto.getText() + "3");

	}

	protected void actionPerformedBtn1_5(ActionEvent e) {
		txtTexto.setText(txtTexto.getText() + "6");

	}

	protected void actionPerformedBtn1_18(ActionEvent e) {
		String cadena;
		cadena = txtTexto.getText();

		if (cadena.length() >= 0) {
			cadena = cadena.substring(0, cadena.length() - 1);
			txtTexto.setText(cadena);
		}
	}

	protected void actionPerformedBtn1_15(ActionEvent e) {
		if (!txtTexto.getText().equals("")) {
			memoria1 = txtTexto.getText();
			signo = "/";
			txtTexto.setText("");
		}
	}

	protected void actionPerformedBtn1_13(ActionEvent e) {
		Double num;
		String cadena;
		cadena = txtTexto.getText();
		if (cadena.length() > 0) {
			num = (-1) * Double.parseDouble(cadena);
			txtTexto.setText(num.toString());
		}
	}

	protected void actionPerformedBtn1_9(ActionEvent e) {
		txtTexto.setText(txtTexto.getText() + "8");

	}
}
