import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MouseFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MouseFrame frame = new MouseFrame();
					frame.setVisible(true);
					frame.setTitle("Boxy");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MouseFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		setContentPane(contentPane);
		
		//Adds panels to contain the boxes at the top and labels describing the coords of the mouse pointer at the bottom
		JPanel topPanel = new JPanel();
		topPanel.setLayout(null);
		contentPane.add(topPanel);
		JPanel botPanel = new JPanel();
		botPanel.setLayout(new GridLayout(2,4));
		contentPane.add(botPanel);
		
		//paints 8 random sized panels in blue,in random positions
		Random myRand = new Random();
		for(int i = 0; i < 8; i++) {
			JPanel myPanel = new JPanel();
			myPanel.setOpaque(true);
			myPanel.setBackground(Color.BLUE);
			topPanel.add(myPanel);
			myPanel.setBounds(myRand.nextInt(600), myRand.nextInt(300), myRand.nextInt(200), myRand.nextInt(200));
			JLabel myLabel = new JLabel("x,y");
			myLabel.setHorizontalAlignment(SwingConstants.CENTER);
			myLabel.setVerticalAlignment(SwingConstants.CENTER);
			//This label will display the coords of the mouse pointer when it is inside the panel
			botPanel.add(myLabel);
			myPanel.addMouseMotionListener(new LabelMouseListener(myLabel));
		}
		

	}

}
