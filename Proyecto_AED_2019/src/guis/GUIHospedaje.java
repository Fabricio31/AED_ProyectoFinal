package guis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUIHospedaje extends JDialog {
	private JTextField txtCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GUIHospedaje dialog = new GUIHospedaje();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GUIHospedaje() {
		setBounds(100, 100, 626, 417);
		getContentPane().setLayout(null);
		{
			JLabel lblCodigo = new JLabel("Codigo");
			lblCodigo.setBounds(10, 11, 63, 23);
			getContentPane().add(lblCodigo);
		}
		{
			txtCodigo = new JTextField();
			txtCodigo.setEditable(false);
			txtCodigo.setColumns(10);
			txtCodigo.setBounds(83, 12, 85, 23);
			getContentPane().add(txtCodigo);
		}
	}

}
