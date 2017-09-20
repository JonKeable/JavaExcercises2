import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class StyleListener implements ItemListener {

	private JCheckBox boldBox;
	private JCheckBox italBox;
	private JTextField textField;
	
	public StyleListener(JTextField textField, JCheckBox boldBox, JCheckBox italBox) {
		this.boldBox = boldBox;
		this.italBox = italBox;
		this.textField = textField;
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		//if both boxes are selected make the text bold and italic
		if(boldBox.isSelected() && italBox.isSelected()) {
			textField.setFont(textField.getFont().deriveFont(Font.BOLD+Font.ITALIC));
		}
		//if just bold box selected make the text bold only
		else if(boldBox.isSelected()) {
			textField.setFont(textField.getFont().deriveFont(Font.BOLD));
		}
		//if just italic box selected make the text italic only
		else if(italBox.isSelected()) {
			textField.setFont(textField.getFont().deriveFont(Font.ITALIC));
		}
		//if neither box is selected, make the text plain
		else {
			textField.setFont(textField.getFont().deriveFont(0));
		}
		
	}

}
