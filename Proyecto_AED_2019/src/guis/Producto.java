package guis;

import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arregloProd.ArregloProducto;

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

public class Producto extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblCodigo;
	private JLabel lblPrecio;
	private JLabel lblStock;
	private JLabel lblDetalle;
	private JTextField txtCodigo;
	private JTextField txtPrecio;
	private JTextField txtStock;
	private JTextField txtDetalle;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
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
					Producto frame = new Producto();
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
	public Producto() {
		setBounds(100, 100, 696, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 11, 46, 14);
		contentPane.add(lblCodigo);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 51, 46, 14);
		contentPane.add(lblPrecio);
		
		lblStock = new JLabel("Stock");
		lblStock.setBounds(10, 89, 46, 14);
		contentPane.add(lblStock);
		
		lblDetalle = new JLabel("Detalle");
		lblDetalle.setBounds(10, 134, 46, 14);
		contentPane.add(lblDetalle);
		
		txtCodigo = new JTextField();
		txtCodigo.setEnabled(false);
		txtCodigo.setBounds(66, 8, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(66, 48, 86, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtStock = new JTextField();
		txtStock.setBounds(66, 86, 86, 20);
		contentPane.add(txtStock);
		txtStock.setColumns(10);
		
		txtDetalle = new JTextField();
		txtDetalle.setBounds(66, 131, 86, 20);
		contentPane.add(txtDetalle);
		txtDetalle.setColumns(10);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(581, 7, 89, 23);
		contentPane.add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(581, 47, 89, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(581, 85, 89, 23);
		contentPane.add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 159, 660, 228);
		contentPane.add(scrollPane);
		tblTabla = new JTable();
		tblTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTabla);
	
		modelo = new DefaultTableModel();
		modelo.addColumn("Código");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellidos");
		modelo.addColumn("DNI");
		tblTabla.setModel(modelo);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setEnabled(false);
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(199, 61, 89, 23);
		contentPane.add(btnAceptar);
		
		listar();	
	}
	ArregloProducto pp=new ArregloProducto();
	private JButton btnAceptar;

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
	}
	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		btnAdicionar.setEnabled(false);
		btnModificar.setEnabled(true);
		btnAceptar.setEnabled(true);
		limpieza();
		habilitarEntradas(true);
		txtCodigo.requestFocus();
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(false);
		if (pp.tamaño() == 0) {
			btnAceptar.setEnabled(false);
			habilitarEntradas(false);
			mensaje("No existen productos");	
		}
		else {
			editarFila();
			btnAceptar.setEnabled(true);
			habilitarEntradas(true);
			txtCodigo.requestFocus();
		}
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnAceptar.setEnabled(false);
		if (pp.tamaño() == 0)
			mensaje("No existen pacientes");
		else {
			editarFila();
			habilitarEntradas(false);
			int ok = confirmar("¿ Desea eliminar el registro ?");
			if (ok == 0) {
				pp.eliminar(pp.buscar(leerCodigoProd()));
				pp.grabarProdu();
				listar();
				editarFila();
			}
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		int codigoProd = leerCodigoProd();
		String detalle = leerDetalle();
			if (detalle.length() > 0)
				try {
					int stock = leerStock();
					try {
						double precio = leerPrecio();
						if (btnAdicionar.isEnabled() == false) {
							producto.Producto nueva = new producto.Producto(codigoProd, stock,precio, detalle);
							pp.adicionar(nueva);
							pp.grabarProdu();
							btnAdicionar.setEnabled(true);
						}
						if (btnModificar.isEnabled() == false) {
						    producto.Producto p = pp.buscar(codigoProd);
							p.setDetalle(detalle);
							p.setStock(stock);
							p.setPrecioUni(precio);
							pp.grabarProdu();
							btnModificar.setEnabled(true);
						}
						listar();
						habilitarEntradas(false);
					}
						catch (Exception x) {
							error("Ingrese PRECIO correcto", txtPrecio);
						}
					}
					catch (Exception x) {
						error("Ingrese STOCK correcto", txtStock);
					}
				else
					error("ingrese DETALLE correcto", txtDetalle);
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
			mouseClickedTblMedicina(arg0);
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
			mouseEnteredTblMedicina(arg0);
		}
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mouseClickedTblMedicina(MouseEvent arg0) {
		habilitarEntradas(false);
		habilitarBotones(true);
		editarFila();
	}
	protected void mouseEnteredTblMedicina(MouseEvent arg0) {
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
		tcm.getColumn(0).setPreferredWidth(anchoColumna(20));  // codigoMedicina
		tcm.getColumn(1).setPreferredWidth(anchoColumna(20));  // nombre
		tcm.getColumn(2).setPreferredWidth(anchoColumna(20));  // laboratorio
		tcm.getColumn(3).setPreferredWidth(anchoColumna(20));  // stock
		tcm.getColumn(4).setPreferredWidth(anchoColumna(20));  // precioUnitario
	}
	void listar() {
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = tblTabla.getSelectedRow();
		if (modelo.getRowCount() == pp.tamaño() - 1)
			posFila = pp.tamaño() - 1;
		if (posFila == pp.tamaño())
			posFila --;
		modelo.setRowCount(0);
		producto.Producto p;
		for (int i=0; i<pp.tamaño(); i++) {
			p = pp.obtener(i);
			Object[] fila = { p.getCodigoPro(),
					          p.getDetalle(),
					          p.getStock(),
					          p.getPrecioUni() };
			modelo.addRow(fila);
		}
		if (pp.tamaño() > 0)
			tblTabla.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	void editarFila() {
		if (pp.tamaño() == 0)
			limpieza();
		else {
			producto.Producto p = pp.obtener(tblTabla.getSelectedRow());
			txtCodigo.setText("" + p.getCodigoPro());
			txtDetalle.setText(p.getDetalle());
			txtStock.setText("" + p.getStock());
			txtPrecio.setText("" +p.getPrecioUni());
		}
	}
	void limpieza() {
		txtCodigo.setText("" + pp.codigoCorrelativo());
		txtDetalle.setText("");
		txtStock.setText("");
		txtPrecio.setText("");
	}	
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	void habilitarEntradas(boolean sino) {
		btnAceptar.setEnabled(sino);
		txtDetalle.setEditable(sino);
		txtStock.setEditable(sino);
		txtPrecio.setEditable(sino);
	}
	void habilitarBotones(boolean sino) {
		btnAdicionar.setEnabled(sino);
		btnModificar.setEnabled(sino);
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	
	int leerCodigoProd() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	String leerDetalle() {
		return txtDetalle.getText().trim();
	}
	int leerStock() {
		return Integer.parseInt(txtStock.getText().trim());
	}
	double leerPrecio() {
		return Double.parseDouble(txtPrecio.getText().trim());
	}
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}
	
}
