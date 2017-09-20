import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JTextField;

public class FontListener implements ItemListener{

	private JTextField textField;
	private String fontName;
	
	public FontListener(JTextField textField, String fontName) {
		this.textField = textField;
		this.fontName = fontName;
	}
	

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			textField.setFont(new Font(fontName, textField.getFont().getStyle(), textField.getFont().getSize()));
			textField.setText(fontName);
		}
		
	}
	
}
