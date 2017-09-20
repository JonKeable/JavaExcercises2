import java.util.Vector;

public class TestPrimes {

	private Vector<Integer> intVector;
	private final static int noThreads = 10;
	
	public TestPrimes(Vector<Integer> v) {
		intVector = v;
		runThreads();
	}
	
	public void runThreads() {
		 // an array of the threads that will be created
		 PrimeThread[] threadArr = new PrimeThread[10];
		 //calculates how many elements each thread will need for an even split of the load, rounding up
		 int sizeThreads = 0;
		 double quotient = intVector.size() / noThreads;
		 if (intVector.size() % noThreads == 0) {
			 sizeThreads = (int) Math.floor(quotient);
		 }
		 else sizeThreads = (int) (Math.floor(quotient) + 1);
		 
		 int cnt = 0;
		 //Created threads, and distributes a portion of the int vector to each one
		 for (int i = 0; i < noThreads; i++){
			 Vector<Integer> newV = new Vector<Integer>();
			 for(int j = 0; j < sizeThreads; j++) {
				 if(cnt < intVector.size()) {
					 newV.addElement(intVector.get(cnt));
				 }
				 cnt++;
			 }
			 threadArr[i] = new PrimeThread(newV);
		 }
		 
		 //starts the threads
		 for(PrimeThread pt : threadArr) {
			 new Thread(pt).start();
		 }
	}
	
	//Uses the AePrime class to check primality, then outputs result
	private class PrimeThread implements Runnable {

		private Vector<Integer> vect;
		
		public PrimeThread(Vector<Integer> v) {
			vect = v;
		}
		
		@Override
		public void run() {
			for(Integer i : vect) {
				if(AePrime.checkPrime(i)) System.out.println("Int " + i + " is prime");
				else System.out.println("Int " + i + " is not prime");
			}
		}
		
	}
}
