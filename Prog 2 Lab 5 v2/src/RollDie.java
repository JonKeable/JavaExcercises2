import java.util.Random;

public class RollDie implements Runnable{

	Die d;
	
	public RollDie(Die d) {
		this.d = d;
	}
	
	@Override
	public void run() {
		Random r = new Random();
		int noRolls = r.nextInt(10) + 10;
		//rolls the die a random number of times
		for(int i = noRolls; i >= 0; i--) {
			//this increases polynomialy, so the die rolls slow down over time
			long sleepTime = 2 * ((long) Math.pow((20-i),2));
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				System.out.println(e.getLocalizedMessage());
			}
			//The die rolls itself
			d.roll();
			//Prints the current side of the die
			System.out.println(d.getCurrentSide());
		}
	}

}
