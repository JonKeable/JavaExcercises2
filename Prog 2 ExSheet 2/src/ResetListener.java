import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ResetListener implements ActionListener {
	
	private JTextField textField;
	
	public ResetListener(JTextField textField) {
		this.textField = textField;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//sets the value of the field to 0
		textField.setText(Integer.toString(0));
	}
}
