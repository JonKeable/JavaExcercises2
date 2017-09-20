import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class FontFrame2 extends JFrame{
	
	//Stores the font names to be used in the combo box
	private String[] fontNames = {"Times", "Helvetica", "Courier", "Ariel", "Tahoma", "Windings"};
	
	public FontFrame2() {
		//Initialising the frame
		JFrame window = new JFrame("Font Chooser");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(600, 150);
		//window.setResizable(false);
	    
		//gets the content panel so we can add things to it, and sets it to a flow layout
		Container panel = window.getContentPane();
		panel.setLayout(new FlowLayout());
		
		//creates a panel to add the checkboxes to, with a vertical box layout
	    JPanel checkboxPanel = new JPanel();
	    checkboxPanel.setLayout(new BoxLayout(checkboxPanel, BoxLayout.PAGE_AXIS));
	    //creates the checkboxes and adds them to the subpanel
	    JCheckBox boldBox = new JCheckBox("Bold");
	    JCheckBox italicBox = new JCheckBox("Italic");
	    checkboxPanel.add(boldBox);
	    checkboxPanel.add(italicBox);
	   
	    //creates a combo box, and gets the contents from the array of font names
	    JComboBox fontsBox = new JComboBox(fontNames);
	    //creates the text field and ok button
	    JTextField textField = new JTextField(30);
	    JButton okButton = new JButton("OK");
	    
	    //adds the subpanel and standalone elements to the content panel
	    panel.add(checkboxPanel);
	    panel.add(fontsBox);
	    panel.add(textField);
	    panel.add(okButton);

	    //window.pack();
	    
	    //centers the frame on the screen and makes it visible
	    window.setLocationRelativeTo(null);
	    window.setVisible(true);
	}

}
