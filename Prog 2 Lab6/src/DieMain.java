
public class DieMain {

	public static void main(String[] args) throws InterruptedException {
		SynchRollDie die = new SynchRollDie();
		System.out.println("SIDE: " + die.getValue());
		new Thread(die).start();
		System.out.println("SIDE: " + die.getValue());
		Thread.sleep(1000);
		System.out.println("SIDE: " + die.getValue());
	}

}
