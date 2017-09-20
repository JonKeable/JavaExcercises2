
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OLDWindow2{

	private JFrame frame;

	public OLDWindow2() {

		JFrame window = new JFrame("Simple Submit Cancel Form");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(400, 300);
	    
	    JPanel panel = new JPanel();
	    window.setContentPane(panel);
	    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
	    
	    JTextField textField = new JTextField();
	    panel.add(textField);
	    
	    JButton submitButton = new JButton("Submit");
	    //panel.add(submitButton);
	    
	    JButton cancelButton = new JButton("Cancel");
	    //panel.add(cancelButton);
	    
	    JPanel bottomPanel = new JPanel();
	    bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.LINE_AXIS));
	    bottomPanel.add(submitButton);
	    bottomPanel.add(cancelButton);
	    panel.add(bottomPanel);
	    
	    
	    //window.pack();
	    window.setVisible(true);
	}

}
