import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class IncListener implements ActionListener {

	private JTextField textField;
	
	public IncListener(JTextField textField) {
		this.textField = textField;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			//Increment the value int the textField by 1
			textField.setText(Integer.toString(Integer.parseInt(textField.getText())+1));
		}
		catch(NumberFormatException nfe) {
			//If the value in the textField is not a valid number, display an error and set the value to 0
			JOptionPane.showMessageDialog(null, "The text field was not in int format, resetting to 0");
			textField.setText(Integer.toString(0));
		}
		
	}

}
