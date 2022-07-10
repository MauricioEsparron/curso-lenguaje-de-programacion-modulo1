package vista;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import entidad.Fondo;
import entidad.Panel;
import hilos.HiloHora;

public class FrmPrincipal2 extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuItem mntmSalir;
	private JMenuItem mntmTarjeta;
	private JDesktopPane escritorio;
	private JMenuItem mntmCliente;
	private JMenuItem mntmCuenta;
	private JMenuItem mntmReporteTipoCuenta;
	private JMenuItem mntmOperacion;
	private JMenuItem mntmMovimiento;
	private JMenu mnTransacción;
	private JMenuItem mntmReporteTarjetas;
	private JMenuItem mntmMovimientos;
	public static JLabel lblHora;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					FrmPrincipal2 frame = new FrmPrincipal2();
					frame.setVisible(true);
					frame.setExtendedState(MAXIMIZED_BOTH);
//					Panel p = new Panel("/img/pexels-tuesday-temptation-3780104.jpg");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmPrincipal2() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(FrmPrincipal2.class.getResource("/img/7142978_vent_among us_steam_icon.png")));
		// apariencia
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 986, 697);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnSistema = new JMenu("Sistema");
		mnSistema.setIcon(new ImageIcon(FrmPrincipal2.class
				.getResource("/img/976607_appliances_computer_laptop_notebook_portable computer_icon.png")));
		mnSistema.setMnemonic('S');
		menuBar.add(mnSistema);

		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mntmSalir.setIcon(new ImageIcon(
				FrmPrincipal2.class.getResource("/img/646197_cancel_close_cross_delete_remove_icon.png")));
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, InputEvent.ALT_DOWN_MASK));
		mnSistema.add(mntmSalir);

		JMenu mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setIcon(
				new ImageIcon(FrmPrincipal2.class.getResource("/img/3844474_gear_setting_settings_wheel_icon.png")));
		mnMantenimiento.setMnemonic('M');
		menuBar.add(mnMantenimiento);

		mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(this);
		mntmCliente.setIcon(
				new ImageIcon(FrmPrincipal2.class.getResource("/img/4781818_account_avatar_face_man_people_icon.png")));
		mnMantenimiento.add(mntmCliente);

		mntmTarjeta = new JMenuItem("Tarjeta");
		mntmTarjeta.addActionListener(this);
		mntmTarjeta.setIcon(new ImageIcon(
				FrmPrincipal2.class.getResource("/img/4753726_bank_bill_finance_invoice_money_icon.png")));
		mnMantenimiento.add(mntmTarjeta);

		mntmCuenta = new JMenuItem("Cuenta");
		mntmCuenta.setIcon(new ImageIcon(
				FrmPrincipal2.class.getResource("/img/3507745_business_card_finance_iconoteka_membership_icon.png")));
		mntmCuenta.addActionListener(this);
		mnMantenimiento.add(mntmCuenta);

		mntmOperacion = new JMenuItem("Operacion");
		mntmOperacion.setIcon(new ImageIcon(
				FrmPrincipal2.class.getResource("/img/5402398_list_menu_options_settings_checklist_icon.png")));
		mnMantenimiento.add(mntmOperacion);

		mntmMovimiento = new JMenuItem("Movimiento");
		mntmMovimiento.addActionListener(this);
		mnMantenimiento.add(mntmMovimiento);
		mntmOperacion.addActionListener(this);

		mnTransacción = new JMenu("Transacción");
		mnTransacción
				.setIcon(new ImageIcon(FrmPrincipal2.class.getResource("/img/7142978_vent_among us_steam_icon.png")));
		menuBar.add(mnTransacción);

		JMenu mnReportes = new JMenu("Reportes");
		mnReportes.setIcon(
				new ImageIcon(FrmPrincipal2.class.getResource("/img/7557017_result_test_product_research_icon.png")));
		mnReportes.setMnemonic('R');
		menuBar.add(mnReportes);

		mntmReporteTarjetas = new JMenuItem("Tarjetas");
		mntmReporteTarjetas.addActionListener(this);
		mntmReporteTarjetas.setIcon(new ImageIcon(
				FrmPrincipal2.class.getResource("/img/4753726_bank_bill_finance_invoice_money_icon.png")));
		mnReportes.add(mntmReporteTarjetas);

		mntmReporteTipoCuenta = new JMenuItem("Tipo Cuenta");
		mntmReporteTipoCuenta.addActionListener(this);
		mntmReporteTipoCuenta.setIcon(new ImageIcon(
				FrmPrincipal2.class.getResource("/img/3507745_business_card_finance_iconoteka_membership_icon.png")));
		mnReportes.add(mntmReporteTipoCuenta);

		mntmMovimientos = new JMenuItem("Movimiento");
		mntmMovimientos.addActionListener(this);
		mntmMovimientos
				.setIcon(new ImageIcon(FrmPrincipal2.class.getResource("/img/7142978_vent_among us_steam_icon.png")));
		mnReportes.add(mntmMovimientos);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		escritorio = new JDesktopPane();
		escritorio.setLocation(10, 0);
		escritorio.setBackground(new Color(25, 25, 112));
//		escritorio.setBackground(SystemColor.menu);

//		 muestra imagen de fondo
		escritorio.setSize(970, 600);
		contentPane.add(escritorio);

//		escritorio.setLayout(null);

		lblHora = new JLabel("00:00:00");
		escritorio.setLayer(lblHora, 1000);
		escritorio.add(lblHora);
		lblHora.setForeground(Color.WHITE);
		lblHora.setBackground(Color.BLACK);
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHora.setHorizontalAlignment(SwingConstants.CENTER);
		lblHora.setBounds(0, 0, 970, 52);

		mostrarHora();
		class FondoPanel extends JPanel {
			private Image imagen;

			@Override
			public void paint(Graphics g) {

				// se obtiene la imagen a travez de la ruta indicada
				imagen = new ImageIcon(getClass().getResource("/img/pexels-tuesday-temptation-3780104.jpg")).getImage();

				g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

				// si se quita esto no se mostrara la imagen
				setOpaque(false);

				// no nos muestra todos los componentes
				super.paint(g);

			}

		}
//		 muestra imagen de fondo
		FondoPanel fondo = new FondoPanel();
		this.setContentPane(fondo);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmMovimientos) {
			actionPerformedMntmMovimientos(e);
		}
		if (e.getSource() == mntmReporteTarjetas) {
			actionPerformedMntmReporteTarjetas(e);
		}
		if (e.getSource() == mntmReporteTipoCuenta) {
			actionPerformedMntmReporteTipoCuenta(e);
		}
		if (e.getSource() == mntmMovimiento) {
			actionPerformedMntmMovimiento(e);
		}
		if (e.getSource() == mntmOperacion) {
			actionPerformedMntmOperacion(e);
		}
		if (e.getSource() == mntmCuenta) {
			actionPerformedMntmCuenta(e);
		}
		if (e.getSource() == mntmCliente) {
			actionPerformedMntmCliente(e);
		}
		if (e.getSource() == mntmTarjeta) {
			actionPerformedMntmTarjeta(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
	}

	protected void actionPerformedMntmSalir(ActionEvent e) {
		System.exit(0);
	}

	protected void actionPerformedMntmTarjeta(ActionEvent e) {
		FrmTarjeta tarjeta = new FrmTarjeta();
		tarjeta.setVisible(true);
		escritorio.add(tarjeta);
	}

	protected void actionPerformedMntmCliente(ActionEvent e) {
		FrmCliente cliente = new FrmCliente();
		cliente.setVisible(true);
		escritorio.add(cliente);
	}

	private void mostrarHora() {
		HiloHora hora = new HiloHora();

		hora.start();
	}

	protected void actionPerformedMntmCuenta(ActionEvent e) {
		FrmrTipoCuenta tipoCuenta = new FrmrTipoCuenta();
		tipoCuenta.setVisible(true);
		escritorio.add(tipoCuenta);
	}

	protected void actionPerformedMntmOperacion(ActionEvent e) {
		FrmTipoOperacion operacion = new FrmTipoOperacion();
		operacion.setVisible(true);
		escritorio.add(operacion);
	}

	protected void actionPerformedMntmMovimiento(ActionEvent e) {
		FrmMovimiento movimiento = new FrmMovimiento();
		movimiento.setVisible(true);
		escritorio.add(movimiento);
	}

	protected void actionPerformedMntmReporteTipoCuenta(ActionEvent e) {
		ReporteTipoCuenta ReportTipocuenta = new ReporteTipoCuenta();
		ReportTipocuenta.setVisible(true);
		escritorio.add(ReportTipocuenta);

	}

	protected void actionPerformedMntmReporteTarjetas(ActionEvent e) {
		ReporteTarjeta ReportTarjeta = new ReporteTarjeta();
		ReportTarjeta.setVisible(true);
		escritorio.add(ReportTarjeta);
	}

	protected void actionPerformedMntmMovimientos(ActionEvent e) {
		ReporteTipoOperacion ReportMovimiento = new ReporteTipoOperacion();
		ReportMovimiento.setVisible(true);
		escritorio.add(ReportMovimiento);
	}
}
