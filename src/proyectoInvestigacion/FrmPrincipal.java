package proyectoInvestigacion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.Alertas;

public class FrmPrincipal extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenuItem mntmSalir;
	private JMenuItem mntmConsultarCocina;
	private JMenuItem mntmModificarCocina;
	private JMenuItem mntmListarCocinas;
	private JMenu mnVentas;
	private JMenu mnConfiguracion;
	private JMenu mnAyuda;
	private JMenuItem mntmVender;
	private JMenuItem mntmGenerarReportes;
	private JMenuItem mntmConfigurarDescuentos;
	private JMenuItem mntmConfigurarObsequios;
	private JMenuItem mntmConfigurarCantidadOPtima;
	private JMenuItem mntmConfigurarCuotaDiaria;
	private JMenuItem mntmAcercaDeTienda;

	// variables globales
	// Datos minimos de la primera cocina
	public static String modelo0 = "Mabe EMP6120PG0";
	public static double precio0 = 949.0;
	public static double fondo0 = 58.6;
	public static double ancho0 = 60.0;
	public static double alto0 = 91.0;
	public static int quemadores0 = 4;
	// Datos mínimos de la segunda cocina
	public static String modelo1 = "Indurama Parma";
	public static double precio1 = 1089.0;
	public static double ancho1 = 80.0;
	public static double alto1 = 94.0;
	public static double fondo1 = 67.5;
	public static int quemadores1 = 6;
	// Datos mínimos de la tercera cocina
	public static String modelo2 = "Sole COSOL027";
	public static double precio2 = 850.0;
	public static double ancho2 = 60.0;
	public static double alto2 = 90.0;
	public static double fondo2 = 50.0;
	public static int quemadores2 = 4;
	// Datos mínimos de la cuarta cocina
	public static String modelo3 = "Coldex CX602";
	public static double precio3 = 629.0;
	public static double ancho3 = 61.6;
	public static double alto3 = 95.0;
	public static double fondo3 = 51.5;
	public static int quemadores3 = 5;
	// Datos mínimos de la quinta cocina
	public static String modelo4 = "Reco Dakota";
	public static double precio4 = 849.0;
	public static double ancho4 = 75.4;
	public static double alto4 = 94.5;
	public static double fondo4 = 66.0;
	public static int quemadores4 = 5;
	// Porcentajes de descuento
	public static double porcentaje1 = 7.5;
	public static double porcentaje2 = 10.0;
	public static double porcentaje3 = 12.5;
	public static double porcentaje4 = 15.0;
	// Obsequios
	public static String obsequio1 = "Cafetera";
	public static String obsequio2 = "Licuadora";
	public static String obsequio3 = "Extractor";
	// Cantidad óptima de unidades vendidas
	public static int cantidadOptima = 10;
	// Cuota diaria
	public static double cuotaDiaria = 75000;
	// Variables de Vender
	// Contador de cada venta
	public static int contVent;
	// Acumluador específico de ventas (Mensaje predeterminado)
	public static int acuVent = 5;
	// Importe Total de ventas
	public static double impGeneral;
	// Porcentaje que representa cada Aporte a la couta diaria
	public static double porcentajeCoutaDiaria;
	// Ventas: Generar reportes
	// Variables para Ventas por Modelo
	// Cantidad de Ventas por producto
	public static int cantVentMod0;
	public static int cantVentMod1;
	public static int cantVentMod2;
	public static int cantVentMod3;
	public static int cantVentMod4;
	// Unidades vendidas del Modelo
	public static int uniVendMod0;
	public static int uniVendMod1;
	public static int uniVendMod2;
	public static int uniVendMod3;
	public static int uniVendMod4;
	// Importe de ventas totales
	public static double impTotVendMod0;
	public static double impTotVendMod1;
	public static double impTotVendMod2;
	public static double impTotVendMod3;
	public static double impTotVendMod4;
	// Aporte a la couta diaria
	public static double aprtCoutDiariaMod0;
	public static double aprtCoutDiariaMod1;
	public static double aprtCoutDiariaMod2;
	public static double aprtCoutDiariaMod3;
	public static double aprtCoutDiariaMod4;

	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if ("ok".equalsIgnoreCase(FrmLogin.login)) {
						FrmPrincipal frame = new FrmPrincipal();
						frame.setVisible(true);
					}else {
						Alertas.mensajeError("Usted no tiene permisos para acceder al modulo");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmPrincipal() {
		setResizable(false);
		setForeground(Color.WHITE);
		setTitle("Tienda 1.0");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(FrmPrincipal.class.getResource("/imagen/24563_chip_cpu_microchip_icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 973, 639);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnArchivo = new JMenu("Archivo");
		mnArchivo.setIcon(
				new ImageIcon(FrmPrincipal.class.getResource("/imagen/23453_add_archive_folder_manilla_to_icon.png")));
		menuBar.add(mnArchivo);

		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(
				new ImageIcon(FrmPrincipal.class.getResource("/imagen/8679990_logout_circle_r_line_icon (1).png")));
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);

		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagen/60190_maintenance_icon.png")));
		menuBar.add(mnMantenimiento);

		mntmConsultarCocina = new JMenuItem("Consultar cocina");
		mntmConsultarCocina.addActionListener(this);
		mnMantenimiento.add(mntmConsultarCocina);

		mntmModificarCocina = new JMenuItem("Modificar cocina");
		mntmModificarCocina.addActionListener(this);
		mnMantenimiento.add(mntmModificarCocina);

		mntmListarCocinas = new JMenuItem("Listar cocinas");
		mntmListarCocinas.addActionListener(this);
		mnMantenimiento.add(mntmListarCocinas);

		mnVentas = new JMenu("Ventas");
		mnVentas.setIcon(new ImageIcon(
				FrmPrincipal.class.getResource("/imagen/3827713_color_delivery_lineal_sale_shipping_icon (1).png")));
		menuBar.add(mnVentas);

		mntmVender = new JMenuItem("Vender");
		mntmVender.addActionListener(this);
		mnVentas.add(mntmVender);

		mntmGenerarReportes = new JMenuItem("Generar reportes");
		mntmGenerarReportes.addActionListener(this);
		mnVentas.add(mntmGenerarReportes);

		mnConfiguracion = new JMenu("Configuraci\u00F3n");
		mnConfiguracion.setIcon(new ImageIcon(
				FrmPrincipal.class.getResource("/imagen/6764700_internet_maintance_network_online_setting_icon.png")));
		menuBar.add(mnConfiguracion);

		mntmConfigurarDescuentos = new JMenuItem("Configurar descuentos ");
		mntmConfigurarDescuentos.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarDescuentos);

		mntmConfigurarObsequios = new JMenuItem("Configurar obsequios");
		mntmConfigurarObsequios.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarObsequios);

		mntmConfigurarCantidadOPtima = new JMenuItem("Configurar cantidad \u00F3ptima");
		mntmConfigurarCantidadOPtima.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarCantidadOPtima);

		mntmConfigurarCuotaDiaria = new JMenuItem("Configurar cuota diaria");
		mntmConfigurarCuotaDiaria.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarCuotaDiaria);

		mnAyuda = new JMenu("Ayuda");
		mnAyuda.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagen/41750_mypc_help_icon.png")));
		menuBar.add(mnAyuda);

		mntmAcercaDeTienda = new JMenuItem("Acerca de Tienda");
		mntmAcercaDeTienda.addActionListener(this);
		mnAyuda.add(mntmAcercaDeTienda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("");

		//
		lblNewLabel.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagen/computo.jpg")));
		lblNewLabel.setBounds(0, 0, 960, 350);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagen/computo.jpg")));
		lblNewLabel_1.setBounds(-408, 342, 960, 350);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagen/computo.jpg")));
		lblNewLabel_2.setBounds(0, 342, 960, 350);
		contentPane.add(lblNewLabel_2);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmGenerarReportes) {
			actionPerformedMntmGenerarReportes(e);
		}
		if (e.getSource() == mntmAcercaDeTienda) {
			actionPerformedMntmAcercaDeTienda(e);
		}
		if (e.getSource() == mntmVender) {
			actionPerformedMntmVender(e);
		}
		if (e.getSource() == mntmListarCocinas) {
			actionPerformedMntmListarCocinas(e);
		}
		if (e.getSource() == mntmModificarCocina) {
			actionPerformedMntmModificarCocina(e);
		}
		if (e.getSource() == mntmConsultarCocina) {
			actionPerformedMntmConsultarCocina(e);
		}
		if (e.getSource() == mntmConfigurarCuotaDiaria) {
			actionPerformedMntmConfigurarCuotaDiaria(e);
		}
		if (e.getSource() == mntmConfigurarCantidadOPtima) {
			actionPerformedMntmConfigurarCantidadOPtima(e);
		}
		if (e.getSource() == mntmConfigurarObsequios) {
			actionPerformedMntmConfigurarObsequios(e);
		}
		if (e.getSource() == mntmConfigurarDescuentos) {
			actionPerformedMntmConfigurarDescuentos(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
	}

	protected void actionPerformedMntmSalir(ActionEvent e) {
		// cerrar una aplicación
		System.exit(0);
	}

	protected void actionPerformedMntmConfigurarDescuentos(ActionEvent e) {
		DlgConfigurarDescuentos confiDesc = new DlgConfigurarDescuentos();
		confiDesc.setVisible(true);
		confiDesc.setLocationRelativeTo(this);

	}

	protected void actionPerformedMntmConfigurarObsequios(ActionEvent e) {
		DlgConfiguracionObsequios confiObs = new DlgConfiguracionObsequios();
		confiObs.setVisible(true);
		confiObs.setLocationRelativeTo(this);
	}

	protected void actionPerformedMntmConfigurarCantidadOPtima(ActionEvent e) {
		DlgConfigurarCantidadOptima confiCanti = new DlgConfigurarCantidadOptima();
		confiCanti.setVisible(true);
		confiCanti.setLocationRelativeTo(this);
	}

	protected void actionPerformedMntmConfigurarCuotaDiaria(ActionEvent e) {
		DlgConfigurarCuotaDiaria confiCuota = new DlgConfigurarCuotaDiaria();
		confiCuota.setVisible(true);
		confiCuota.setLocationRelativeTo(this);
	}

	protected void actionPerformedMntmConsultarCocina(ActionEvent e) {
		DlgConsultarcocina con = new DlgConsultarcocina();
		con.setVisible(true);
		con.setLocationRelativeTo(this);
	}

	protected void actionPerformedMntmModificarCocina(ActionEvent e) {
		DlgModificarcocina mod = new DlgModificarcocina();
		mod.setVisible(true);
		mod.setLocationRelativeTo(this);
	}

	protected void actionPerformedMntmListarCocinas(ActionEvent e) {
		DlgListarcocina listarCoci = new DlgListarcocina();
		listarCoci.setVisible(true);
		listarCoci.setLocationRelativeTo(this);
	}

	protected void actionPerformedMntmVender(ActionEvent e) {
		DlgVenderCocina veCo = new DlgVenderCocina();
		veCo.setVisible(true);
		veCo.setLocationRelativeTo(this);
	}

	protected void actionPerformedMntmAcercaDeTienda(ActionEvent e) {
		DlgAcerdaDeTienda acer = new DlgAcerdaDeTienda();
		acer.setVisible(true);
		acer.setLocationRelativeTo(this);
	}

	protected void actionPerformedMntmGenerarReportes(ActionEvent e) {
		DlgGenerarReportes gnrRep = new DlgGenerarReportes();
		gnrRep.setVisible(true);
		gnrRep.setLocationRelativeTo(this);
	}
}
