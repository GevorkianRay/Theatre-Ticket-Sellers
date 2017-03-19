
public class Timer {
	int minutesElapsed=0;
	double startTime;
	public Timer() {
		startTime=System.currentTimeMillis();
	}
	public int getTime() {
		// TODO Auto-generated method stub
		
			double elapsed = System.currentTimeMillis();
			float seconds = (float) ((elapsed - startTime) / 1000F);
			int minutes = (int)(seconds)/60;
			minutesElapsed = minutes;
			return minutesElapsed;
	}
	

	
}