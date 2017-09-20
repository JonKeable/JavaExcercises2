import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class IncLocal extends JFrame {

	private JPanel contentPane;
	private JTextField textField = new JTextField("0", 3);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IncLocal frame = new IncLocal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IncLocal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());
		setContentPane(contentPane);
		
		JButton incButton = new JButton("Increment");
		contentPane.add(incButton);
		JButton resetButton = new JButton("Reset");
		contentPane.add(resetButton);
		
		textField.setEditable(false);
		textField.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(textField);
		
		incButton.addActionListener(new IncListener());
		resetButton.addActionListener(new ResetListener());
	}

	private class IncListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try{
				//Increment the value int the textField by 1
				textField.setText(Integer.toString(Integer.parseInt(textField.getText())+1));
			}
			catch(NumberFormatException nfe) {
				//If the value in the textField is not a valid number, display an error and set the value to 0
				JOptionPane.showMessageDialog(null, "The text field was not in int format, resetting to 0");
				textField.setText(Integer.toString(0));
			}
			
		}

	}
	
	private class ResetListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			textField.setText(Integer.toString(0));
		}
	}



}
