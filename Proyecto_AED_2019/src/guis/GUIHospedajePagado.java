package guis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;

public class GUIHospedajePagado extends JDialog {
	private JTextArea txtSHospedajesPagados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GUIHospedajePagado dialog = new GUIHospedajePagado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GUIHospedajePagado() {
		setBounds(100, 100, 634, 377);
		getContentPane().setLayout(null);
		{
			txtSHospedajesPagados = new JTextArea();
			txtSHospedajesPagados.setText("");
			txtSHospedajesPagados.setFont(new Font("Monospaced", Font.PLAIN, 15));
			txtSHospedajesPagados.setBounds(10, 11, 598, 324);
			getContentPane().add(txtSHospedajesPagados);
		}
	}

}
