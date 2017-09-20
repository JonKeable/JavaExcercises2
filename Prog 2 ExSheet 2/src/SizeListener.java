import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JTextField;

public class SizeListener implements ItemListener {

	private JTextField textField;
	
	public SizeListener(JTextField textField) {
		this.textField = textField;
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			//sets the font size to that specified by the event (the drop down box)
			textField.setFont(textField.getFont().deriveFont(Float.parseFloat(e.getItem().toString())));
		}

		
	}

}
