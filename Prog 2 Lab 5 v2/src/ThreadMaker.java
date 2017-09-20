
public class ThreadMaker {

	SleepyThread t1, t2, t3; 
	
	public static void main(String[] args) {
		ThreadMaker tm = new ThreadMaker();
		tm.createThreads();
		tm.startThreads();
	}

	//Create new SleepyThreads which  will should finish in order t3, t2, t1
	private void createThreads() {
		t1 = new SleepyThread(3);
		t2 = new SleepyThread(2);
		t3 = new SleepyThread(1);
	}
	
	//Start the threads in order t1, t2, t3
	private void startThreads() {
		new Thread(t1).start();
		new Thread(t2).start();
		new Thread(t3).start();
	}
	
	private class SleepyThread implements Runnable {

		//Time in seconds
		int sleepTime;
		
		public SleepyThread(int t) {
			sleepTime = t;
		}
		
		@Override
		public void run() {
			try {
				//multiply time by 1000 to get milliseconds
				Thread.sleep(sleepTime*1000);
				System.out.println(sleepTime);
			} catch (InterruptedException e) {
				System.out.println(e.getLocalizedMessage());
			}
		}
		
	}

}
