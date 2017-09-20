import java.util.Random;
import java.util.Vector;

public class PrimesMain {

	public static void main(String[] args) {
		Random r = new Random();
		Vector<Integer> v = new Vector<Integer>();
		for(int i = 0; i < 100; i++) {
			v.addElement(r.nextInt(100));
		}
		TestPrimes tp = new TestPrimes(v);
	}

}
