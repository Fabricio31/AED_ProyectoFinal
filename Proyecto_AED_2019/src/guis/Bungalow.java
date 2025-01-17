package guis;

import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arreglos.ArregloBungalow;
import clase.BungalowClass;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Bungalow extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNmero;
	private JTextField txtNumero;
	private JLabel lblCategoria;
	private JComboBox <String>cboCategoria;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JLabel lblEstado;
	private JComboBox <String>cboEstado;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnAceptar;
	private JScrollPane scrollPane;
	private JTable tblBungalow;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bungalow frame = new Bungalow();
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
	public Bungalow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNmero = new JLabel("N\u00FAmero");
		lblNmero.setBounds(10, 11, 46, 14);
		contentPane.add(lblNmero);
		
		txtNumero = new JTextField();
		txtNumero.setEditable(false);
		txtNumero.setBounds(66, 8, 86, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(10, 36, 55, 14);
		contentPane.add(lblCategoria);
		
		cboCategoria = new JComboBox <String>();
		cboCategoria.addActionListener(this);
		cboCategoria.setModel(new DefaultComboBoxModel <String>(new String[] {"Simple", "Doble", "Familiar"}));
		cboCategoria.setBounds(66, 33, 86, 20);
		contentPane.add(cboCategoria);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 61, 46, 14);
		contentPane.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(66, 58, 86, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(10, 86, 46, 14);
		contentPane.add(lblEstado);
		
		cboEstado = new JComboBox <String>();
		cboEstado.setModel(new DefaultComboBoxModel <String>(new String[] {"Libre", "Ocupado"}));
		cboEstado.setBounds(66, 83, 86, 20);
		contentPane.add(cboEstado);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(335, 7, 89, 23);
		contentPane.add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(335, 32, 89, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(335, 57, 89, 23);
		contentPane.add(btnEliminar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setEnabled(false);
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(162, 36, 89, 23);
		contentPane.add(btnAceptar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 111, 414, 139);
		contentPane.add(scrollPane);
		
		tblBungalow = new JTable();
		tblBungalow.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblBungalow);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("N�MERO");
		modelo.addColumn("CATEGOR�A");
		modelo.addColumn("PRECIO");
		modelo.addColumn("ESTADO");
		
		tblBungalow.setModel(modelo);
		
		txtNumero.setEditable(false);
		
		ajustarAnchoColumnas();
		listar();
		editarFila();
		//habilitarEntradas(false);
	}
	ArregloBungalow bn=new ArregloBungalow();
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cboCategoria) {
			actionPerformedCboCategoria(arg0);
		}
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
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(false);
		if (bn.tama�o() == 0) {
			btnAceptar.setEnabled(false);
			habilitarEntradas(false);
			mensaje("No existen cuartos");	
		}
		else {
			editarFila();
			int numeroCuarto = leerNumeroCuarto();
			BungalowClass x = bn.buscar(numeroCuarto);
			if (x.getEstado() == 0) {
				btnAceptar.setEnabled(true);
				habilitarEntradas(true);
			}
			else {
				btnModificar.setEnabled(true);
				mensaje("No se puede modificar el n�mero de cuarto " + numeroCuarto + " porque est� Ocupada");
			}
		}
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnAceptar.setEnabled(false);
		if (bn.tama�o() == 0)
			mensaje("No existen cuartos");
		else {
			editarFila();
			habilitarEntradas(false);
			int numeroCuarto = leerNumeroCuarto();
			BungalowClass x = bn.buscar(numeroCuarto);
			if (x.getEstado() == 0) {
				int ok = confirmar("� Desea eliminar el registro ?");
				if (ok == 0) {
					bn.eliminar(bn.buscar(leerNumeroCuarto()));
					bn.grabarBungalows();
					listar();
					editarFila();
				}
			}
			else
				mensaje("No se puede eliminar el n�mero de cama " + numeroCuarto + " porque est� Ocupada");
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		int numeroCuarto = leerNumeroCuarto();
		int categoria = leerPosCategoria();
		double precioDia = leerPrecioDia();
		int estado = leerPosEstado();
		if (btnAdicionar.isEnabled() == false) {
			BungalowClass nueva = new BungalowClass(numeroCuarto, categoria, estado, precioDia);
			bn.adicionar(nueva);
			bn.grabarBungalows();
			btnAdicionar.setEnabled(true);
		}
		if (btnModificar.isEnabled() == false) {
			BungalowClass x = bn.buscar(numeroCuarto);
			x.setCategoria(categoria);
			x.setPrecioPorDia(precioDia);
			x.setEstado(estado);
			bn.grabarBungalows();
			btnModificar.setEnabled(true);
		}
		listar();
		habilitarEntradas(false);
	}
	protected void actionPerformedCboCategoria(ActionEvent arg0) {
		txtPrecio.setText("" + establecerPrecio());
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
		if (arg0.getSource() == tblBungalow) {
			mouseClickedTblBungalow(arg0);
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
		if (arg0.getSource() == tblBungalow) {
			mouseEnteredTblBungalow(arg0);
		}
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mouseClickedTblBungalow(MouseEvent arg0) {
		habilitarEntradas(false);
		habilitarBotones(true);
		editarFila();
	}
	protected void mouseEnteredTblBungalow(MouseEvent arg0) {
		tblBungalow.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
		TableColumnModel tcm = tblBungalow.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(25));  
		tcm.getColumn(1).setPreferredWidth(anchoColumna(25));  
		tcm.getColumn(2).setPreferredWidth(anchoColumna(25));  
		tcm.getColumn(3).setPreferredWidth(anchoColumna(25));  
	}
	void listar() {
		int Fila = 0;
		if (modelo.getRowCount() > 0)
			Fila = tblBungalow.getSelectedRow();
		if (modelo.getRowCount() == bn.tama�o() - 1)
			Fila = bn.tama�o() - 1;
		if (Fila == bn.tama�o())
		    Fila --;
		modelo.setRowCount(0);
		BungalowClass x;
		for (int i=0; i<bn.tama�o(); i++) {
			x = bn.obtener(i);
			Object[] fila = { x.getNumeroBungalow(),
			          		  enTextoCategoria(x.getCategoria()),
			                  x.getPrecioPorDia(),
			                  enTextoEstado(x.getEstado()) };
			modelo.addRow(fila);
		}
		if (bn.tama�o() > 0)
			tblBungalow.getSelectionModel().setSelectionInterval(Fila, Fila);
	}
	void editarFila() {
		if (bn.tama�o() == 0)
			limpieza();
		else {
			BungalowClass x = bn.obtener(tblBungalow.getSelectedRow());
			txtNumero.setText("" + x.getNumeroBungalow());
			cboCategoria.setSelectedIndex(x.getCategoria());
			txtPrecio.setText("" + x.getPrecioPorDia());
			cboEstado
			.setSelectedIndex(x.getEstado());
		}
	}
	void limpieza() {
		txtNumero.setText("" + bn.numeroCorrelativo());
		cboCategoria.setSelectedIndex(0);
		cboEstado.setSelectedIndex(0);
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
		cboCategoria.setEnabled(sino);
	}
	void habilitarBotones(boolean sino) {
		btnAdicionar.setEnabled(sino);
		btnModificar.setEnabled(sino);
	}
	
	int leerNumeroCuarto() {
		return Integer.parseInt(txtNumero.getText().trim());
	}
	int leerPosCategoria() {
		return cboCategoria.getSelectedIndex();
	}
	double leerPrecioDia() {
		return Double.parseDouble(txtPrecio.getText().trim());
	}
	int leerPosEstado() {
		return cboEstado.getSelectedIndex();
	}
	double  establecerPrecio() {
		switch (leerPosCategoria()) {
			case 0:
				return 100.0;
			case 1:
				return 200.0;
		    default:
		    	return 500.0;
		}
	}

	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}
	String enTextoCategoria(int i) {
		return cboCategoria.getItemAt(i);
	}
	String enTextoEstado(int i) {
		return cboEstado.getItemAt(i);
	}
	
	
}
