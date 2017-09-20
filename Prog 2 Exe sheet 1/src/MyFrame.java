
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame{

	public MyFrame() {

		//Initializes the frame
		JFrame window = new JFrame("Simple Submit Cancel Form");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(400, 100);
		//window.setResizable(false);
	    
		//creates a content panel to have elements added to
	    JPanel panel = new JPanel();
	    panel.setLayout(new FlowLayout());
	    window.setContentPane(panel);
	    
	    //creates and adds to the panel the text field, submit button and cancel button
	    JTextField textField = new JTextField(30);
	    panel.add(textField);
	    JButton submitButton = new JButton("Submit");
	    panel.add(submitButton);
	    JButton cancelButton = new JButton("Cancel");
	    panel.add(cancelButton);
	    
	    //window.pack();
	    
	    //centers the frame on the screen and makes it visible
	    window.setLocationRelativeTo(null);
	    window.setVisible(true);
	}

}
