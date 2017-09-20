import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DieFrame extends JFrame {

	private JPanel contentPane;
	private Die die;
	private JTextField sideField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DieFrame frame = new DieFrame();
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
	public DieFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(2,2));
		setContentPane(contentPane);

		die = new Die();
		sideField = new JTextField();
		sideField.setFont(sideField.getFont().deriveFont((float) 40));
		sideField.setHorizontalAlignment(JTextField.CENTER);
		sideField.setEditable(false);
		JButton rollButton = new JButton("Roll!");
		rollButton.addActionListener(new rollListener());
		
		contentPane.add(die);
		contentPane.add(sideField);
		contentPane.add(rollButton);
		
	}
	
	private class rollListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Random r = new Random();
			die.setCurrentSide(r.nextInt(5)+1);
			sideField.setText(Integer.toString(die.getCurrentSide()));
			repaint();
		}
		
	}

}
