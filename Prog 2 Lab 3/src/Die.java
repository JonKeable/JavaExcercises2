import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class Die extends JPanel {

	private int currentSide;
	
	/**
	 * Create the panel.
	 */
	public Die() {
		currentSide = (new Random().nextInt(5)) +1;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		this.setBackground(Color.WHITE);
		g.setColor(Color.BLACK);
		//paints the 'outside' of the die
		g.drawRect(50, 50, 100, 100);
		paintDots(currentSide, g);
	}

	private void paintDots(int k, Graphics g) {
		
		//paints different dot patterns depending on the value of the current side
		switch(k) {
			case 1:	paint_1(g);
					break;
			case 2:	paint_2(g);
					break;
			case 3: paint_3(g);
					break;
			case 4: paint_4(g);
					break;
			case 5: paint_5(g);
					break;
			case 6: paint_6(g);
					break;
			default: break;
		}
	}


	/*
	 *  O	O	O
	 *  	
	 *  O	O	O
	 */
	private void paint_6(Graphics g) {
		paint_4(g);
		drawDot(100, 125, g);
		drawDot(100, 75, g);
		
	}
	
	/*
	 *  O		O
	 *  	O
	 *  O		O
	 */
	private void paint_5(Graphics g) {
		paint_4(g);
		paint_1(g);
		
	}

	/*
	 *  O		O
	 *  	
	 *  O		O
	 */
	private void paint_4(Graphics g) {
		drawDot(75, 125, g);
		drawDot(125, 75, g);
		drawDot(75, 75, g);
		drawDot(125, 125, g);
		
	}

	/*
	 *  		O
	 *  	O
	 *  O		
	 */
	private void paint_3(Graphics g) {
		paint_1(g);
		paint_2(g);
		
	}

	/*
	 *  		O
	 *  	
	 *  O		
	 */
	private void paint_2(Graphics g) {
		drawDot(75, 125, g);
		drawDot(125, 75, g);
		
	}

	/*
	 *  		
	 *  	O
	 *  		
	 */
	private void paint_1(Graphics g) {
		drawDot(100, 100, g);
		
	}
	
	//paints a small circle centered on the specified point
	private void drawDot(int x, int y, Graphics g) {
		g.setColor(Color.BLACK);
		g.fillOval(x-10, y-10, 20, 20);
	}

	public int getCurrentSide() {
		return currentSide;
	}

	public void setCurrentSide(int currentSide) {
		this.currentSide = currentSide;
	}

}
