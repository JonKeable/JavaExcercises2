import java.util.Random;

public class SynchRollDie implements Runnable{

	
	public SynchRollDie() {
	}
	
	private int currentSide;
	
	@Override
	public void run() {
		roll();
	}

	private void roll() {
		Random r = new Random();
		int noRolls = r.nextInt(10) + 10;
		synchronized(this) {
			for(int i = noRolls; i >= 0; i--) {
				long sleepTime = 2 * ((long) Math.pow((20-i),2));
				try {
					Thread.sleep(sleepTime);
				} catch (InterruptedException e) {
					System.out.println(e.getLocalizedMessage());
				}
				currentSide = (new Random().nextInt(5)) +1;
				System.out.println(currentSide);
			}
			
		}
	}
	
	public int getValue() {
		synchronized(this) {
			return currentSide;
		}
	}

}
