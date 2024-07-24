package guis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;

public class GUIingresosyConsumosPagados extends JDialog {
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GUIingresosyConsumosPagados dialog = new GUIingresosyConsumosPagados();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GUIingresosyConsumosPagados() {
		setBounds(100, 100, 704, 397);
		getContentPane().setLayout(null);
		{
			txtS = new JTextArea();
			txtS.setText("");
			txtS.setFont(new Font("Monospaced", Font.PLAIN, 15));
			txtS.setBounds(10, 11, 668, 336);
			getContentPane().add(txtS);
		}
	}

}
