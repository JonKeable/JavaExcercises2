import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;

public class TriangleButton extends JButton{

	public TriangleButton(String label) {
		super(label);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setVisible(true);
	}
	
	  	@Override
	    protected void paintComponent(Graphics g) {
	  		Graphics2D g2 = (Graphics2D) g.create();

	        Dimension size = super.getPreferredSize();

	        g.setColor(Color.YELLOW);
	        int[] xPoints = {0,getWidth(),getWidth()/2};
	        int[] yPoints = {getHeight(),getHeight(),0};
	        g.fillPolygon(xPoints, yPoints, 3);
	        g2.drawString(getText(), getWidth()/2 -getWidth()/4, getHeight()/2+getHeight()/4);
	        //super.paintComponent(g);
	  	}
	  	
	  	private class CustomListener() {
	  		
	  	}

}
