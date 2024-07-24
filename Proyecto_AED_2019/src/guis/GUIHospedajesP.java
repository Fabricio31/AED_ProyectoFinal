package guis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;

public class GUIHospedajesP extends JDialog {
	private JTextArea txtSHospedajePendiente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GUIHospedajesP dialog = new GUIHospedajesP();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GUIHospedajesP() {
		setBounds(100, 100, 681, 399);
		getContentPane().setLayout(null);
		{
			txtSHospedajePendiente = new JTextArea();
			txtSHospedajePendiente.setText("");
			txtSHospedajePendiente.setFont(new Font("Monospaced", Font.PLAIN, 15));
			txtSHospedajePendiente.setBounds(10, 11, 645, 338);
			getContentPane().add(txtSHospedajePendiente);
		}
	}

}
