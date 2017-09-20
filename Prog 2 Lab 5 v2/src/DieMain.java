
public class DieMain {

	public static void main(String[] args) {
		//a frame containing a die object which is displayed on screen
		DieRollFrame frame = new DieRollFrame();
		//rolls the die object of the frame
		new Thread(new RollDie(frame.getDie())).start();
	}

}
