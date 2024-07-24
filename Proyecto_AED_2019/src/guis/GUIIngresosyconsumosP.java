package guis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;

public class GUIIngresosyconsumosP extends JDialog {
	private JTextArea txtSMostar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GUIIngresosyconsumosP dialog = new GUIIngresosyconsumosP();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GUIIngresosyconsumosP() {
		setBounds(100, 100, 712, 402);
		getContentPane().setLayout(null);
		
		txtSMostar = new JTextArea();
		txtSMostar.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtSMostar.setBounds(10, 11, 673, 343);
		getContentPane().add(txtSMostar);
	}
}
