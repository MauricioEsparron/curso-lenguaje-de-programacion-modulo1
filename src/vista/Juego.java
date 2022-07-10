package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Juego extends JInternalFrame implements MouseListener, ActionListener {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;

	String siguienteJuego = "O";
	String turno = "X";
	JLabel lbs[] = new JLabel[9];

	int victorias[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 2, 5, 8 }, { 3, 6, 9 }, { 1, 5, 9 }, { 3, 5, 7 } };
	private JButton btnNewButton;
	private JLabel lblTurno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Juego frame = new Juego();
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
	public Juego() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 394, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 11, 358, 391);
		contentPane.add(panel);
		panel.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(47, 79, 79));
		panel_1.setBounds(48, 90, 259, 198);
		panel.add(panel_1);
		panel_1.setLayout(null);

		lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(this);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBounds(0, 0, 80, 59);
		panel_1.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(this);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 30));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(90, 0, 80, 59);
		panel_1.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(this);
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 30));
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(180, 0, 80, 59);
		panel_1.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.addMouseListener(this);
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 30));
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setBounds(0, 70, 80, 59);
		panel_1.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.addMouseListener(this);
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 30));
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setBounds(90, 70, 80, 59);
		panel_1.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.addMouseListener(this);
		lblNewLabel_5.setOpaque(true);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Yu Gothic UI", Font.PLAIN, 30));
		lblNewLabel_5.setBackground(Color.WHITE);
		lblNewLabel_5.setBounds(180, 70, 80, 59);
		panel_1.add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.addMouseListener(this);
		lblNewLabel_6.setOpaque(true);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Yu Gothic UI", Font.PLAIN, 30));
		lblNewLabel_6.setBackground(Color.WHITE);
		lblNewLabel_6.setBounds(0, 140, 80, 59);
		panel_1.add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.addMouseListener(this);
		lblNewLabel_7.setOpaque(true);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Yu Gothic UI", Font.PLAIN, 30));
		lblNewLabel_7.setBackground(Color.WHITE);
		lblNewLabel_7.setBounds(90, 140, 80, 59);
		panel_1.add(lblNewLabel_7);

		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.addMouseListener(this);
		lblNewLabel_8.setOpaque(true);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Yu Gothic UI", Font.PLAIN, 30));
		lblNewLabel_8.setBackground(Color.WHITE);
		lblNewLabel_8.setBounds(180, 140, 80, 59);
		panel_1.add(lblNewLabel_8);


		System.out.println(victorias[4][2]);

		lbs[0] = lblNewLabel;
		lbs[1] = lblNewLabel_1;
		lbs[2] = lblNewLabel_2;
		lbs[3] = lblNewLabel_3;
		lbs[4] = lblNewLabel_4;
		lbs[5] = lblNewLabel_5;
		lbs[6] = lblNewLabel_6;
		lbs[7] = lblNewLabel_7;
		lbs[8] = lblNewLabel_8;

		btnNewButton = new JButton("Reiniciar");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(218, 35, 89, 23);
		panel.add(btnNewButton);

		lblTurno = new JLabel("Truno de  X");
		lblTurno.setBounds(36, 39, 112, 14);
		panel.add(lblTurno);
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		if (e.getSource() == lblNewLabel) {
			mousePressedLblNewLabel(e);
		}
		if (e.getSource() == lblNewLabel_8) {
			mousePressedLblNewLabel_8(e);
		}
		if (e.getSource() == lblNewLabel_1) {
			mousePressedLblNewLabel_1(e);
		}
		if (e.getSource() == lblNewLabel_3) {
			mousePressedLblNewLabel_3(e);
		}
		if (e.getSource() == lblNewLabel_7) {
			mousePressedLblNewLabel_7(e);
		}
		if (e.getSource() == lblNewLabel_5) {
			mousePressedLblNewLabel_5(e);
		}
		if (e.getSource() == lblNewLabel_6) {
			mousePressedLblNewLabel_6(e);
		}
		if (e.getSource() == lblNewLabel_4) {
			mousePressedLblNewLabel_4(e);
		}
		if (e.getSource() == lblNewLabel_2) {
			mousePressedLblNewLabel_2(e);
		}
	}

	public void mouseReleased(MouseEvent e) {
	}

	protected void mousePressedLblNewLabel_2(MouseEvent e) {
		presionar(3);
	}

	protected void mousePressedLblNewLabel_4(MouseEvent e) {
		presionar(5);
	}

	protected void mousePressedLblNewLabel_6(MouseEvent e) {
		presionar(7);
	}

	protected void mousePressedLblNewLabel_5(MouseEvent e) {
		presionar(6);
	}

	protected void mousePressedLblNewLabel_7(MouseEvent e) {
		presionar(8);
	}

	protected void mousePressedLblNewLabel_3(MouseEvent e) {
		presionar(4);
	}

	protected void mousePressedLblNewLabel_1(MouseEvent e) {
		presionar(2);
	}

	protected void mousePressedLblNewLabel_8(MouseEvent e) {
		presionar(9);
	}

	protected void mousePressedLblNewLabel(MouseEvent e) {
		presionar(1);

	}

	public void presionar(int casilla) {
		if (lbs[casilla - 1].getText().equals("")) {
			lbs[casilla - 1].setText(turno);
			cambiarTurno();
			comprobarGanador();
		}
	}

	private void comprobarGanador() {
		for (int i = 0; i < victorias.length; i++) {
			if (lbs[victorias[i][0] - 1].getText().equals("X") && lbs[victorias[i][1] - 1].getText().equals("X")
					&& lbs[victorias[i][2] - 1].getText().equals("X")) {

				lbs[victorias[i][0] - 1].setBackground(Color.GREEN);
				lbs[victorias[i][1] - 1].setBackground(Color.GREEN);
				lbs[victorias[i][2] - 1].setBackground(Color.GREEN);
				System.out.println("Gano X");

			}
			if (lbs[victorias[i][0] - 1].getText().equals("O") && lbs[victorias[i][1] - 1].getText().equals("O")
					&& lbs[victorias[i][2] - 1].getText().equals("O")) {
				lbs[victorias[i][0] - 1].setBackground(Color.GREEN);
				lbs[victorias[i][1] - 1].setBackground(Color.GREEN);
				lbs[victorias[i][2] - 1].setBackground(Color.GREEN);
				System.out.println("Gano O");
			}
		}
	}

	public void cambiarTurno() {
		if (turno.equals("X")) {
			turno = "O";
		} else {
			turno = "X";
		}
		lblTurno.setText("Turno de " + turno);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
	}

	protected void actionPerformedBtnNewButton(ActionEvent e) {
		for (int i = 0; i < lbs.length; i++) {
			lbs[i].setText("");
			lbs[i].setBackground(Color.WHITE);

		}
		turno = siguienteJuego;
		if (siguienteJuego.equals("O")) {
			siguienteJuego = "X";
		} else {
			siguienteJuego = "O";
		}
	}
}
