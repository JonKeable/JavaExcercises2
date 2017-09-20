import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DieRollFrame extends JFrame{
	
	public DieRollFrame() {
		init();
	}
	
	private Die d;

	private void init() {
		JFrame frame = new JFrame("Rolly");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(600, 400);
		Container panel = frame.getContentPane();
		panel.setLayout(new GridLayout(1,2));
		
		d = new Die();
		panel.add(d);

		frame.setVisible(true);
	}
	
	public Die getDie(){
		return this.d;
	}
	

}
