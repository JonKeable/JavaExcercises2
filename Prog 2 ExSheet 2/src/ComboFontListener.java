import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JTextField;

public class ComboFontListener implements ItemListener {

	private JTextField textField;
	
	public ComboFontListener(JTextField textField) {
		this.textField = textField;
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			//Sets the font to that of the font selected
			textField.setFont(new Font(e.getItem().toString(), textField.getFont().getStyle(), textField.getFont().getSize()));
			//Sets the text to the name of the font selected
			textField.setText(e.getItem().toString());
		}

		
	}

}
