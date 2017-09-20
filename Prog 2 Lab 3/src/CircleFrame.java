import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CircleFrame extends JFrame {

	private JPanel contentPane;
	private Circle c1, c2, c3;
	private Rectangle r1, r2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CircleFrame frame = new CircleFrame();
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
	public CircleFrame() {
		//basic init of frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setBackground(Color.WHITE);

		//creates the objects in the frame
		c1 = new Circle(100, 50, 80);
		c2 = new Circle(200, 50, 50);
		c3 = new Circle(300, 70, 60);
		r1 = new Rectangle(150, 150, 100, 200);
		r2 = new Rectangle(250, 200, 150, 50);
	}
	
	//paints the shapes on the frame
	public void paint(Graphics g) {
		super.paint(g);
		c1.draw(g);
		c2.draw(g);
		c3.draw(g);
		r1.draw(g);
		r2.draw(g);
	}
	
	//If the mouse is clicked inside a circle, change that circles colour
	private class CircleListener extends MouseAdapter  {
		public CircleListener(int x, int y, int r, Circle c) {
			this.x = x;
			this.y = y;
			this.r = r;
			circle = c;
		}
		
		private Circle circle;
		private int x, y, r;
		@Override
		public void mouseClicked(MouseEvent e) {
			//This checks if the cursor position is within the circle
			if(Math.pow(e.getX()- x, 2) + Math.pow(e.getY() - y, 2) < Math.pow(r, 2)) {
				circle.setColour(getRandColour());
				repaint();
			}
		}
	}
	
	//If the mouse is clicked inside a rectangle, change that rectangles colour
	private class RectangleListener extends MouseAdapter  {
		public RectangleListener(int x, int y, int w, int h, Rectangle r) {
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			rectangle = r;
		}
		
		private Rectangle rectangle;
		private int x, y, w, h;
		@Override
		public void mouseClicked(MouseEvent e) {
			//If the mouse poitner is within the rectangle
			if( (e.getX() >= x) && (e.getX() <= (x+w)) && (e.getY() >= y) && (e.getY() <= (y+h)) ) {
				rectangle.setColour(getRandColour());
				repaint();
			}
		}
	}
	
	//This is extended by all shapes that need to be painted
	private abstract class Shape {
		
		protected int x;
		protected int y;
		protected Color col;
		
		public Shape(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public Color getColour() {
			return col;
		}
		 
		public void setColour(Color c) {
			col = c;
		}
	}
	
	private class Circle extends Shape{
		
		//radius, and centre point coords
		private int r, x0, y0;
		
		public Circle(int x, int y, int r) {
			super(x, y);
			this.r = r;
			//if x and y are the top LH corner of the circle's rectangle, 
			//then adding the radius of the circle to these coordinates gives the centre point
			x0 = x + r;
			y0 = y + r;
			contentPane.addMouseListener(new CircleListener(x0,y0,r, this));
			setColour(getRandColour());
		}
		
		//draws the circle
		 public void draw(Graphics g) {
			 g.setColor(col);
			 g.fillOval(x, y, r*2, r*2);
		 }
		 
	}
	
	private class Rectangle extends Shape {

		private int width, height;
		
		public Rectangle(int x, int y, int w, int h) {
			super(x, y);
			width = w;
			height = h;
			contentPane.addMouseListener(new RectangleListener(x,y,w,h, this));
			setColour(getRandColour());
		}
		
		//draws the rectangle
		public void draw(Graphics g) {
			g.setColor(col);
			g.fillRect(x, y, width, height);
		}
		
	}

	//generates a random colour by using the float constructor of Color and random floats that generate between 0 and 1
	public Color getRandColour() {
		Random rand = new Random();
		return new Color(rand.nextFloat(),rand.nextFloat(),rand.nextFloat());
	}

}
