package guis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIMenu extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuProyecto;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
	private JMenu mnMantenimiento;
	private JMenuItem mntmSocio;
	private JMenuItem mntmProducto;
	private JMenuItem mntmBungalow;
	private JMenu mnRegistro;
	private JMenuItem mntmIngreso;
	private JMenuItem mntmConsumo;
	private JMenu mnPago;
	private JMenuItem mntmIngresosYConsumos;
	private JMenuItem mntmHospedajes;
	private JMenu mnReporte;
	private JMenuItem mntmIngresosYConsumosPendientes;
	private JMenuItem mntmIngresosYConsumosPagados;
	private JMenuItem mntmHospedajesPendientes;
	private JMenuItem mntmHospedajesPagados;
	private JMenuItem mntmHospedaje;
	private JMenu mnBoleta;
	private JMenuItem mntmBoletas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMenu frame = new GUIMenu();
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
	public GUIMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuProyecto = new JMenuBar();
		menuProyecto.setBounds(0, 0, 434, 21);
		contentPane.add(menuProyecto);
		
		mnArchivo = new JMenu("Archivo");
		menuProyecto.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuProyecto.add(mnMantenimiento);
		
		mntmSocio = new JMenuItem("Socio");
		mntmSocio.addActionListener(this);
		mnMantenimiento.add(mntmSocio);
		
		mntmProducto = new JMenuItem("Producto");
		mntmProducto.addActionListener(this);
		mnMantenimiento.add(mntmProducto);
		
		mntmBungalow = new JMenuItem("Bungalow");
		mntmBungalow.addActionListener(this);
		mnMantenimiento.add(mntmBungalow);
		
		mnRegistro = new JMenu("Registro");
		menuProyecto.add(mnRegistro);
		
		mntmIngreso = new JMenuItem("Ingreso");
		mnRegistro.add(mntmIngreso);
		
		mntmConsumo = new JMenuItem("Consumo");
		mnRegistro.add(mntmConsumo);
		
		mntmHospedaje = new JMenuItem("Hospedaje");
		mnRegistro.add(mntmHospedaje);
		
		mnPago = new JMenu("Pago");
		menuProyecto.add(mnPago);
		
		mntmIngresosYConsumos = new JMenuItem("Ingresos y consumos");
		mnPago.add(mntmIngresosYConsumos);
		
		mntmHospedajes = new JMenuItem("Hospedajes");
		mnPago.add(mntmHospedajes);
		
		mnReporte = new JMenu("Reporte");
		menuProyecto.add(mnReporte);
		
		mntmIngresosYConsumosPendientes = new JMenuItem("Ingresos y consumos pendientes");
		mntmIngresosYConsumosPendientes.addActionListener(this);
		mnReporte.add(mntmIngresosYConsumosPendientes);
		
		mntmIngresosYConsumosPagados = new JMenuItem("Ingresos y consumos pagados");
		mntmIngresosYConsumosPagados.addActionListener(this);
		mnReporte.add(mntmIngresosYConsumosPagados);
		
		mntmHospedajesPendientes = new JMenuItem("Hospedajes pendientes");
		mntmHospedajesPendientes.addActionListener(this);
		mnReporte.add(mntmHospedajesPendientes);
		
		mntmHospedajesPagados = new JMenuItem("Hospedajes pagados");
		mntmHospedajesPagados.addActionListener(this);
		mnReporte.add(mntmHospedajesPagados);
		
		mnBoleta = new JMenu("Boleta");
		menuProyecto.add(mnBoleta);
		
		mntmBoletas = new JMenuItem("Boletas");
		mnBoleta.add(mntmBoletas);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmHospedajesPagados) {
			actionPerformedMntmHospedajesPagados(e);
		}
		if (e.getSource() == mntmHospedajesPendientes) {
			actionPerformedMntmHospedajesPendientes(e);
		}
		if (e.getSource() == mntmIngresosYConsumosPagados) {
			actionPerformedMntmIngresosYConsumosPagados(e);
		}
		if (e.getSource() == mntmIngresosYConsumosPendientes) {
			actionPerformedMntmIngresosYConsumosPendientes(e);
		}
		if (e.getSource() == mntmBungalow) {
			actionPerformedMntmBungalow(e);
		}
		if (e.getSource() == mntmProducto) {
			actionPerformedMntmProducto(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
		if (e.getSource() == mntmSocio) {
			actionPerformedMntmSocio(e);
		}
	}
	protected void actionPerformedMntmSocio(ActionEvent e) {
		Socio gsocio=new Socio();
		gsocio.setLocationRelativeTo(this);
		gsocio.setVisible(true);
	}
	protected void actionPerformedMntmSalir(ActionEvent e) {
		int ok = confirmacionDeSalida();
		if (ok == 0)
			System.exit(0);
	}
	protected void actionPerformedMntmProducto(ActionEvent e) {
		Producto gproducto=new Producto();
		gproducto.setLocationRelativeTo(this);
		gproducto.setVisible(true);
	}
	protected void actionPerformedMntmBungalow(ActionEvent e) {
	    Bungalow gBungalow=new Bungalow();
	    gBungalow.setLocationRelativeTo(this);
	    gBungalow.setVisible(true);
	}
	protected void actionPerformedMntmIngresosYConsumosPendientes(ActionEvent e) {
		GUIIngresosyconsumosP gingresospend=new GUIIngresosyconsumosP();
		gingresospend.setLocationRelativeTo(this);
		gingresospend.setVisible(true);
	}
	protected void actionPerformedMntmIngresosYConsumosPagados(ActionEvent e) {
		GUIingresosyConsumosPagados gingresospagados=new GUIingresosyConsumosPagados();
		gingresospagados.setLocationRelativeTo(this);
		gingresospagados.setVisible(true);
	}
	protected void actionPerformedMntmHospedajesPendientes(ActionEvent e) {
		GUIHospedajesP ghospedajespend=new GUIHospedajesP();
		ghospedajespend.setLocationRelativeTo(this);
		ghospedajespend.setVisible(true);
	}
	protected void actionPerformedMntmHospedajesPagados(ActionEvent e) {
		GUIHospedajePagado ghospedajepagado=new GUIHospedajePagado();
		ghospedajepagado.setLocationRelativeTo(this);
		ghospedajepagado.setVisible(true);
	}
	int confirmacionDeSalida() {
		return JOptionPane.showConfirmDialog(this,
			   "� Desea salir del programa ?",
			   "TEXTO", 0, 3, null);
	}
}
