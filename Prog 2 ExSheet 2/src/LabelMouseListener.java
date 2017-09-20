import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class LabelMouseListener extends MouseAdapter {

	private JLabel label;
	
	public LabelMouseListener(JLabel label) {
		this.label = label;
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		//displays the coords of the mouse in the label
		label.setText(Integer.toString((int) e.getPoint().getX()) + "," + Integer.toString((int) e.getPoint().getY()));
	}
}
