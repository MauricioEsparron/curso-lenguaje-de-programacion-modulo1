package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hilos.HiloBarraProgreso;

import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class PreLoader extends JFrame implements ChangeListener {

	private JPanel contentPane;
	public static JProgressBar prbCarga;
	private JLabel lblGif;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PreLoader frame = new PreLoader();
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
	public PreLoader() {
		setBackground(new Color(0, 0, 0));
		setTitle("Cargando... :D");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 319, 198);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		prbCarga = new JProgressBar();
		prbCarga.setForeground(new Color(0, 250, 154));
		prbCarga.addChangeListener(this);
		prbCarga.setStringPainted(true);
		prbCarga.setBounds(0, 140, 303, 19);
		contentPane.add(prbCarga);

		JLabel lblMensajes = new JLabel("El sistema est\u00E1 cargando, espere unos segundos");
		lblMensajes.setForeground(new Color(255, 255, 255));
		lblMensajes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMensajes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensajes.setBounds(0, 5, 313, 14);
		contentPane.add(lblMensajes);
		
		lblGif = new JLabel("");
		lblGif.setIcon(new ImageIcon(PreLoader.class.getResource("/img/pacman-eating-dots.gif")));
		lblGif.setHorizontalAlignment(SwingConstants.CENTER);
		lblGif.setBounds(0, 30, 303, 107);
		contentPane.add(lblGif);

		iniciarBarraProgreso();
	}

	private void iniciarBarraProgreso() {
		HiloBarraProgreso h = new HiloBarraProgreso();
		h.start();
	}

	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == prbCarga) {
			stateChangedPrbCarga(e);
		}
	}

	protected void stateChangedPrbCarga(ChangeEvent e) {
		if (prbCarga.getValue() == 100) {
			FrmPrincipal prin = new FrmPrincipal();
			prin.setVisible(true);
			prin.setLocationRelativeTo(this);
			prin.setExtendedState(MAXIMIZED_BOTH);
			this.dispose();
		}
	}
}
