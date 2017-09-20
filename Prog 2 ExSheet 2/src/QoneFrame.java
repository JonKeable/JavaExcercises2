import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class QoneFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QoneFrame frame = new QoneFrame();
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
	public QoneFrame() {
		//basic setup of the frame and content pane
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());
		setContentPane(contentPane);
		
		//creates the components of the panel
		JButton incButton = new JButton("Increment");
		contentPane.add(incButton);
		JButton resetButton = new JButton("Reset");
		contentPane.add(resetButton);
		JTextField textField = new JTextField("0", 3);
		textField.setEditable(false);
		textField.setHorizontalAlignment(textField.CENTER);
		contentPane.add(textField);
		
		//Adds listeners to increment and reset the value in the field
		incButton.addActionListener(new IncListener(textField));
		resetButton.addActionListener(new ResetListener(textField));
	}

}
