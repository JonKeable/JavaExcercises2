import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class FontFrame extends JFrame{
	
	public FontFrame() {
		
		/*
		String fonts[]
		        = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

		for (int i = 0; i < fonts.length; i++) {
		    System.out.println(fonts[i]);
		}
		*/
		
		//Initialising the frame
		JFrame window = new JFrame("Font Chooser");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(600, 150);
		//window.setResizable(false);
	    
		//gets the content panel so we can add things to it, and sets it to a flow layout
		Container panel = window.getContentPane();
		panel.setLayout(new FlowLayout());
		
		//creates the text field and ok button
	    JTextField textField = new JTextField(30);
	    JButton okButton = new JButton("OK");
		
	    
	    
		//creates a panel to add the checkboxes to, with a vertical box layout
	    JPanel checkboxPanel = new JPanel();
	    checkboxPanel.setLayout(new BoxLayout(checkboxPanel, BoxLayout.PAGE_AXIS));
	    //creates the checkboxes and adds them to the subpanel
	    JCheckBox boldBox = new JCheckBox("Bold");
	    JCheckBox italicBox = new JCheckBox("Italic");
	    StyleListener styleListener = new StyleListener(textField, boldBox, italicBox);
	    boldBox.addItemListener(styleListener);
	    italicBox.addItemListener(styleListener);
	    checkboxPanel.add(boldBox);
	    checkboxPanel.add(italicBox);
	   
	    //creates a panel to add the radio buttons to, with a vertical box layout
	    JPanel radioPanel = new JPanel();
	    radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.PAGE_AXIS));
	    //creates and groups the radio buttons, then adds them to the subpanel
	    JRadioButton timesButton = new JRadioButton("Times");
	    timesButton.addItemListener(new FontListener(textField, "Times New Roman"));
	    JRadioButton arialButton = new JRadioButton("Arial");
	    arialButton.addItemListener(new FontListener(textField, "Arial"));
	    JRadioButton courButton = new JRadioButton("Courier");
	    courButton.addItemListener(new FontListener(textField, "Courier New"));
	    ButtonGroup fontButtons = new ButtonGroup();
	    fontButtons.add(timesButton);
	    fontButtons.add(arialButton);
	    fontButtons.add(courButton);
	    radioPanel.add(timesButton);
	    radioPanel.add(arialButton);
	    radioPanel.add(courButton);
	    
	    //adds the subpanels, text field and ok button to the content panel
	    panel.add(checkboxPanel);
	    panel.add(radioPanel);
	    panel.add(textField);
	    panel.add(okButton);

	    //window.pack();
	    
	    //centers the frame on the screen and makes it visible
	    window.setLocationRelativeTo(null);
	    window.setVisible(true);
	}

}
