package guis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIBungalow extends JDialog implements ActionListener {
	private JTable tblMostrar;
	private JTextField txtNumero;
	private JLabel lblNumero;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnConsultar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GUIBungalow dialog = new GUIBungalow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GUIBungalow() {
		setBounds(100, 100, 619, 299);
		getContentPane().setLayout(null);
		{
			tblMostrar = new JTable();
			tblMostrar.setBounds(10, 77, 585, 177);
			getContentPane().add(tblMostrar);
		}
		{
			lblNumero = new JLabel("Numero");
			lblNumero.setBounds(10, 11, 64, 23);
			getContentPane().add(lblNumero);
		}
		{
			txtNumero = new JTextField();
			txtNumero.setColumns(10);
			txtNumero.setBounds(63, 12, 86, 20);
			getContentPane().add(txtNumero);
		}
		{
			btnAdicionar = new JButton("Adicionar");
			btnAdicionar.setBounds(394, 11, 89, 23);
			getContentPane().add(btnAdicionar);
		}
		{
			btnModificar = new JButton("Modificar");
			btnModificar.setBounds(493, 11, 89, 23);
			getContentPane().add(btnModificar);
		}
		{
			btnEliminar = new JButton("Eliminar");
			btnEliminar.setBounds(394, 43, 89, 23);
			getContentPane().add(btnEliminar);
		}
		{
			btnConsultar = new JButton("Consultar");
			btnConsultar.setBounds(493, 45, 89, 23);
			getContentPane().add(btnConsultar);
		}
	}

	public void actionPerformed(ActionEvent e) {
	}
}
