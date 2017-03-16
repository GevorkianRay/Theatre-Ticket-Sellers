
public class Timer implements Runnable {
	int minutesElapsed=0;
	double startTime;
	public Timer() {
		startTime=System.currentTimeMillis();
	}
	public void run() {
		// TODO Auto-generated method stub
		while(minutesElapsed<1) {
			double elapsed = System.currentTimeMillis();
			float seconds = (float) ((elapsed - startTime) / 1000F);
			int minutes = (int)(seconds)/60;
			minutesElapsed=minutes;
			System.out.println(minutesElapsed);
		}
		
	}
	
	public static void main(String[] args) {
		new Thread(new Timer()).start();
	}
}