import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Circles extends JFrame {

	private JPanel contentPane;
	//the width of the imaginary line
	private int width = 1200;
	//the height of the imaginary line
	private int lineHeight = 300;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Circles frame = new Circles();
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
	public Circles() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	public void paint(Graphics g) {
		setBackground(Color.WHITE);
		//g.drawLine(0, 200, width, lineHeight);  -- Used to check where the imaginary line is on the frame
		//draws circles 25 from the left
		drawCircles(width, 25, 0, g);
	}

	private void drawCircles(int width, int offset, int depth, Graphics g) {
		if (depth < 6) {
			
			//makes the green darker for samller circles
			g.setColor(new Color(0,255-40*depth,0));
			//the radius of the circle is 1/6 of the width of the line
			int radius = (int)width/6;
			//fills and oval centered around the centre of the specified line, taking into acount the line's offset from the left of the panel
			g.fillOval(width/2 - radius + offset, lineHeight - radius, radius*2, radius*2);
			
			//draw circle patterns for the 3 smaller lines we get by cutting the line into 3 equal parts
			drawCircles(width/3, 0 + offset, depth+1, g);
			drawCircles(width/3, width/3 + offset, depth+1, g);
			drawCircles(width/3, 2*width/3 + offset, depth+1, g);
		}
	}

}
