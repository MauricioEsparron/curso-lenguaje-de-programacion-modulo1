package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidad.Fondo;
import entidad.Panel;
import hilos.HiloHora;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class FrmPrincipal extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuItem mntmSalir;
	private JMenuItem mntmTarjeta;
	private JDesktopPane escritorio;
	private JMenuItem mntmCliente;
	public static JLabel lblHora;
	private JMenuItem mntmCuenta;
	private JMenuItem mntmReporteTipoCuenta;
	private JMenuItem mntmOperacion;
	private JMenuItem mntmMovimiento;
	private JMenu mnTransacción;
	private JMenuItem mntmReporteTarjetas;
	private JMenuItem mntmTipoOperacion;

	Fondo f = new Fondo();
	private JMenuItem mntmUsuarios;
	private JMenuItem mnCalculadora;
	private JMenuItem mntmJuego;
	private JMenuItem mntmMovimientoTransaccion;
	private JMenuItem mntmReportesTipoUsuarios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
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
	@SuppressWarnings("deprecation")
	public FrmPrincipal() {
		setForeground(new Color(139, 0, 0));
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(FrmPrincipal.class.getResource("/img/7142978_vent_among us_steam_icon.png")));
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
		mnSistema.setIcon(new ImageIcon(FrmPrincipal.class
				.getResource("/img/976607_appliances_computer_laptop_notebook_portable computer_icon.png")));
		mnSistema.setMnemonic('S');
		menuBar.add(mnSistema);

		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);

		mnCalculadora = new JMenuItem("Calculadora");
		mnCalculadora.setIcon(new ImageIcon(
				FrmPrincipal.class.getResource("/img/4213589_calculate_calculator_doodle_education_line_icon.png")));
		mnCalculadora.addActionListener(this);

		mntmJuego = new JMenuItem("Juegos");
		mntmJuego.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/6936483_game_gaming_play_icon.png")));
		mntmJuego.addActionListener(this);
		mnSistema.add(mntmJuego);
		mnSistema.add(mnCalculadora);
		mntmSalir.setIcon(
				new ImageIcon(FrmPrincipal.class.getResource("/img/646197_cancel_close_cross_delete_remove_icon.png")));
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, InputEvent.ALT_DOWN_MASK));
		mnSistema.add(mntmSalir);

		JMenu mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setIcon(
				new ImageIcon(FrmPrincipal.class.getResource("/img/3844474_gear_setting_settings_wheel_icon.png")));
		mnMantenimiento.setMnemonic('M');
		menuBar.add(mnMantenimiento);

		mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(this);
		mntmCliente.setIcon(
				new ImageIcon(FrmPrincipal.class.getResource("/img/4781818_account_avatar_face_man_people_icon.png")));
		mnMantenimiento.add(mntmCliente);

		mntmTarjeta = new JMenuItem("Tarjeta");
		mntmTarjeta.addActionListener(this);
		mntmTarjeta.setIcon(
				new ImageIcon(FrmPrincipal.class.getResource("/img/4753726_bank_bill_finance_invoice_money_icon.png")));
		mnMantenimiento.add(mntmTarjeta);

		mntmCuenta = new JMenuItem("Cuenta");
		mntmCuenta.setIcon(new ImageIcon(
				FrmPrincipal.class.getResource("/img/3507745_business_card_finance_iconoteka_membership_icon.png")));
		mntmCuenta.addActionListener(this);
		mnMantenimiento.add(mntmCuenta);

		mntmOperacion = new JMenuItem("Operaciones");
		mntmOperacion.setIcon(new ImageIcon(
				FrmPrincipal.class.getResource("/img/5402398_list_menu_options_settings_checklist_icon.png")));
		mnMantenimiento.add(mntmOperacion);

		mntmMovimiento = new JMenuItem("Movimientos Bancarios");
		mntmMovimiento.setIcon(new ImageIcon(
				FrmPrincipal.class.getResource("/img/8111397_rightarrow_arrow_direction_navigation_right_icon.png")));
		mntmMovimiento.addActionListener(this);
		mnMantenimiento.add(mntmMovimiento);

		mntmUsuarios = new JMenuItem("Usuarios");
		mntmUsuarios.addActionListener(this);
		mntmUsuarios
				.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/7142978_vent_among us_steam_icon.png")));
		mnMantenimiento.add(mntmUsuarios);
		mntmOperacion.addActionListener(this);

		mnTransacción = new JMenu("Transacción");
		mnTransacción
				.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/7142978_vent_among us_steam_icon.png")));
		menuBar.add(mnTransacción);

		mntmMovimientoTransaccion = new JMenuItem("Movimiento Bancario");
		mntmMovimientoTransaccion.setIcon(new ImageIcon(
				FrmPrincipal.class.getResource("/img/8111397_rightarrow_arrow_direction_navigation_right_icon.png")));
		mntmMovimientoTransaccion.addActionListener(this);
		mnTransacción.add(mntmMovimientoTransaccion);

		JMenu mnReportes = new JMenu("Reportes");
		mnReportes.setIcon(
				new ImageIcon(FrmPrincipal.class.getResource("/img/7557017_result_test_product_research_icon.png")));
		mnReportes.setMnemonic('R');
		menuBar.add(mnReportes);

		mntmReporteTarjetas = new JMenuItem("Tarjeta por Usuario");
		mntmReporteTarjetas.addActionListener(this);
		mntmReporteTarjetas.setIcon(
				new ImageIcon(FrmPrincipal.class.getResource("/img/4753726_bank_bill_finance_invoice_money_icon.png")));
		mnReportes.add(mntmReporteTarjetas);

		mntmReporteTipoCuenta = new JMenuItem("Tipo Cuenta");
		mntmReporteTipoCuenta.addActionListener(this);
		mntmReporteTipoCuenta.setIcon(new ImageIcon(
				FrmPrincipal.class.getResource("/img/3507745_business_card_finance_iconoteka_membership_icon.png")));
		mnReportes.add(mntmReporteTipoCuenta);

		mntmTipoOperacion = new JMenuItem("Tipo Operación");
		mntmTipoOperacion.addActionListener(this);
		mntmTipoOperacion.setIcon(new ImageIcon(
				FrmPrincipal.class.getResource("/img/5402398_list_menu_options_settings_checklist_icon.png")));
		mnReportes.add(mntmTipoOperacion);

		mntmReportesTipoUsuarios = new JMenuItem("Reporte Usuarios");
		mntmReportesTipoUsuarios.addActionListener(this);
		mntmReportesTipoUsuarios
				.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/7142978_vent_among us_steam_icon.png")));
		mnReportes.add(mntmReportesTipoUsuarios);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(10, 10));
		setContentPane(contentPane);
//		contentPane.setLayout(null);

		escritorio = new JDesktopPane();
		escritorio.setBackground(Color.WHITE);
//		escritorio.setBackground(SystemColor.menu);

		// muestra imagen de fondo
		escritorio.setSize(600, 600);
		escritorio.setLayout(new BoxLayout(escritorio, BoxLayout.X_AXIS));
		Panel q = new Panel("/img/pexels-tuesday-temptation-3780104.jpg");
		escritorio.add(q);
		q.setLayout(null);
		contentPane.add(escritorio, BorderLayout.CENTER);

		lblHora = new JLabel("00:00:00");
		q.add(lblHora);
		lblHora.setForeground(Color.WHITE);
		lblHora.setBackground(Color.BLACK);
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHora.setHorizontalAlignment(SwingConstants.CENTER);
		lblHora.setBounds(10, 11, 940, 25);

		mostrarHora();

		restringirPermisos();

	}

	private void restringirPermisos() {
		switch (Logueo.usuario.getCodTipoUsuario()) {
		case 1:
			mntmCliente.setVisible(true);
			mntmCuenta.setVisible(true);
			mntmMovimiento.setVisible(true);
			mntmOperacion.setVisible(true);
			mntmReporteTarjetas.setVisible(true);
			mntmReporteTipoCuenta.setVisible(true);
			mntmTarjeta.setVisible(true);
			mntmTipoOperacion.setVisible(true);
			mntmUsuarios.setVisible(false);
			mnTransacción.setVisible(true);
			mntmReportesTipoUsuarios.setVisible(false);
			break;
		case 2:
			mntmCliente.setVisible(true);
			mntmCuenta.setVisible(true);
			mntmMovimiento.setVisible(true);
			mntmOperacion.setVisible(true);
			mntmReporteTarjetas.setVisible(true);
			mntmReporteTipoCuenta.setVisible(true);
			mntmTarjeta.setVisible(true);
			mntmTipoOperacion.setVisible(true);
			mntmUsuarios.setVisible(true);
			mnTransacción.setVisible(true);
			mntmReportesTipoUsuarios.setVisible(true);
			break;
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmReportesTipoUsuarios) {
			actionPerformedMntmReportesTipoUsuarios(e);
		}
		if (e.getSource() == mntmMovimientoTransaccion) {
			actionPerformedMntmMovimientoTransaccion(e);
		}
		if (e.getSource() == mntmJuego) {
			actionPerformedMntmJuego(e);
		}
		if (e.getSource() == mnCalculadora) {
			actionPerformedMnCalculadora(e);
		}
		if (e.getSource() == mntmUsuarios) {
			actionPerformedMntmUsuarios(e);
		}
		if (e.getSource() == mntmTipoOperacion) {
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
		operacion.show();
	}

	protected void actionPerformedMntmMovimiento(ActionEvent e) {
		FrmMovimiento movimiento = new FrmMovimiento();
		movimiento.setVisible(true);
		escritorio.add(movimiento);
	}

	protected void actionPerformedMntmUsuarios(ActionEvent e) {
		FrmUsuario usuario = new FrmUsuario();
		usuario.setVisible(true);
		escritorio.add(usuario);
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

	protected void actionPerformedMnCalculadora(ActionEvent e) {
		Calculadora calc = new Calculadora();
		calc.setVisible(true);
		escritorio.add(calc);
	}

	protected void actionPerformedMntmJuego(ActionEvent e) {
		Juego j = new Juego();
		j.setVisible(true);
		escritorio.add(j);
	}

	protected void actionPerformedMntmMovimientoTransaccion(ActionEvent e) {
		FrmMovimiento Movimiento = new FrmMovimiento();
		Movimiento.setVisible(true);
		escritorio.add(Movimiento);
	}

	protected void actionPerformedMntmReportesTipoUsuarios(ActionEvent e) {
		ReporteTipoUsuario tipUser = new ReporteTipoUsuario();
		tipUser.setVisible(true);
		escritorio.add(tipUser);
	}
}
