
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OLDWindow{

	private JFrame frame;

	public OLDWindow() {

		JFrame window = new JFrame("Simple Submit Cancel Form");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(500, 200);
	    
	    JPanel panel = new JPanel();
	    window.setContentPane(panel);
	    panel.setLayout(new FlowLayout());
	    
	    JTextField textField = new JTextField();
	    panel.add(textField);
	    
	    JButton submitButton = new JButton("Submit");
	    panel.add(submitButton);
	    
	    JButton cancelButton = new JButton("Cancel");
	    panel.add(cancelButton);
	    
	    //window.pack();
	    window.setVisible(true);
	}

}
