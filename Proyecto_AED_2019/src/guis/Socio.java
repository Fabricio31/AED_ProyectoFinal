package guis;

import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arregloSocio.ArregloSocios;
import socio.AdicionarSocio;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Socio extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDni;
	private JLabel lblTelefono;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
	private JTextField txtTelefono;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnAceptar;
	private JScrollPane scrollPane;
	private JTable tblTabla;
	private DefaultTableModel modelo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Socio frame = new Socio();
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame.setVisible(true);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Socio() {
		
		setBounds(100, 100, 601, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 22, 46, 14);
		contentPane.add(lblCodigo);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 58, 46, 14);
		contentPane.add(lblNombre);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 94, 46, 14);
		contentPane.add(lblApellido);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(10, 125, 46, 14);
		contentPane.add(lblDni);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 160, 46, 14);
		contentPane.add(lblTelefono);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(66, 19, 150, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(66, 91, 150, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(66, 58, 150, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(66, 122, 150, 20);
		contentPane.add(txtDNI);
		txtDNI.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(66, 157, 150, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(486, 18, 89, 23);
		contentPane.add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(486, 54, 89, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(486, 90, 89, 23);
		contentPane.add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 185, 565, 185);
		contentPane.add(scrollPane);
		
		tblTabla = new JTable();
		tblTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTabla);
	
		modelo = new DefaultTableModel();
		modelo.addColumn("C�digo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellidos");
		modelo.addColumn("DNI");
		modelo.addColumn("Telefono");
		tblTabla.setModel(modelo);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setEnabled(false);
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(248, 85, 89, 23);
		contentPane.add(btnAceptar);
		
		listar();	
	}
	ArregloSocios aa=new ArregloSocios();
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
			}
		}
	
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		btnAdicionar.setEnabled(false);
		btnModificar.setEnabled(true);
		btnAceptar.setEnabled(true);
		limpieza();
		habilitarEntradas(true);
		txtNombre.requestFocus();
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(false);
		if (aa.tama�o() == 0) {
			btnAceptar.setEnabled(false);
			habilitarEntradas(false);
			mensaje("No existen pacientes");	
		}
		else {
			editarFila();
			btnAceptar.setEnabled(true);
			habilitarEntradas(true);
			txtNombre.requestFocus();
		}
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnAceptar.setEnabled(false);
		if (aa.tama�o() == 0)
			mensaje("No existen pacientes");
		else {
			editarFila();
			habilitarEntradas(false);
			int ok = confirmar("� Desea eliminar el registro ?");
			if (ok == 0) {
				aa.eliminar(aa.buscar(leerCodigo()));
				aa.grabarPacientes();
				listar();
				editarFila();
			}
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		int codigoPaciente = leerCodigo();
		String nombres = leerNombre();
		if (nombres.length() > 0) {
			String apellidos = leerApellido();
			if (apellidos.length() > 0) {
				String telefono = leerTelefono();
				if (telefono.length() > 0) {
					String dni = leerDNI();
					if (dni.length() > 0) {
						if (btnAdicionar.isEnabled() == false) {
							AdicionarSocio nuevo = new AdicionarSocio(codigoPaciente, nombres, apellidos, telefono, dni);
							aa.adicionar(nuevo);
							aa.grabarPacientes();
							btnAdicionar.setEnabled(true);
						}
						if (btnModificar.isEnabled() == false) {
							AdicionarSocio p = aa.buscar(codigoPaciente);
							p.setNombres(nombres);
							p.setApellidos(apellidos);
							p.setTelefono(telefono);
							p.setDni(dni);
							aa.grabarPacientes();
							btnModificar.setEnabled(true);
						}
						listar();
						habilitarEntradas(false);
					}
					else
						error("Ingrese DNI correcto", txtDNI);
				}
				else
					error("Ingrese TEL�FONO correcto", txtTelefono);		
			}
			else
				error("ingrese APELLIDOS correctos", txtApellido);
		}
		else
			error("ingrese NOMBRES correctos", txtNombre);		
	
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
		arg0.consume();
		editarFila();		
	}
	public void keyTyped(KeyEvent arg0) {
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblTabla) {
			mouseClickedTblPaciente(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
		if (arg0.getSource() == btnAceptar) {
			mouseEnteredBtnAceptar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			mouseEnteredBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			mouseEnteredBtnModificar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			mouseEnteredBtnAdicionar(arg0);
		}
		if (arg0.getSource() == tblTabla) {
			mouseEnteredTblPaciente(arg0);
		}
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mouseClickedTblPaciente(MouseEvent arg0) {
		habilitarEntradas(false);
		habilitarBotones(true);
		editarFila();
	}
	protected void mouseEnteredTblPaciente(MouseEvent arg0) {
		tblTabla.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredBtnAdicionar(MouseEvent arg0) {
		btnAdicionar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredBtnModificar(MouseEvent arg0) {
		btnModificar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredBtnEliminar(MouseEvent arg0) {
		btnEliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredBtnAceptar(MouseEvent arg0) {
		btnAceptar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblTabla.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(20));  // codigoPaciente
		tcm.getColumn(1).setPreferredWidth(anchoColumna(20));  // nombres
		tcm.getColumn(2).setPreferredWidth(anchoColumna(20));  // apellidos
		tcm.getColumn(3).setPreferredWidth(anchoColumna(20));  // telefono
		tcm.getColumn(4).setPreferredWidth(anchoColumna(20));  // dni
	}
	void listar() {
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = tblTabla.getSelectedRow();
		if (modelo.getRowCount() == aa.tama�o() - 1)
			posFila = aa.tama�o() - 1;
		if (posFila == aa.tama�o())
			posFila --;
		modelo.setRowCount(0);
		AdicionarSocio p;
		for (int i=0; i<aa.tama�o(); i++) {
			p = aa.obtener(i);
			Object[] fila = { p.getCodigo(),
					          p.getNombres(),
					          p.getApellidos(),
					          p.getTelefono(),
					          p.getDni() };
			modelo.addRow(fila);
		}
		if (aa.tama�o() > 0)
			tblTabla.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	void editarFila() {
		if (aa.tama�o() == 0)
			limpieza();
		else {
			AdicionarSocio p = aa.obtener(tblTabla.getSelectedRow());
			txtCodigo.setText("" + p.getCodigo());
			txtNombre.setText(p.getNombres());
			txtApellido.setText(p.getApellidos());
			txtTelefono.setText(p.getTelefono());
			txtDNI.setText(p.getDni());
		}
	}
	void limpieza() {
		txtCodigo.setText("" + aa.numeroCorrelativo());
		txtNombre.setText("");
		txtApellido.setText("");
		txtTelefono.setText("");
		txtDNI.setText("");
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Informaci�n", 0);
	}
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	void habilitarEntradas(boolean sino) {
		btnAceptar.setEnabled(sino);
		txtNombre.setEditable(sino);
		txtApellido.setEditable(sino);
		txtTelefono.setEditable(sino);
		txtDNI.setEditable(sino);
	}
	void habilitarBotones(boolean sino) {
		btnAdicionar.setEnabled(sino);
		btnModificar.setEnabled(sino);
	}
	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	String leerNombre() {
		return txtNombre.getText().trim();
	}
	String leerApellido() {
		return txtApellido.getText().trim();
	}
	String leerDNI() {
		return txtDNI.getText().trim();
	}
	String leerTelefono() {
		return txtTelefono.getText().trim();
	}
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}
	
}
