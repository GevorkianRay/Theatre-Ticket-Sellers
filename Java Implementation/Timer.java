public class Timer {
	int minutesElapsed=0;
	double startTime;
	public Timer() {
		startTime=System.currentTimeMillis();
	}
	public int getTime() {
		// TODO Auto-generated method stub
		/*
			double elapsed = System.currentTimeMillis();
			int seconds = (int) ((elapsed - startTime) / 1000);
			int minutes = (int)(seconds)/60;
			minutesElapsed = minutes;
			return minutesElapsed;*/
		double elapsed = System.currentTimeMillis();
		int seconds = (int) ((elapsed - startTime) / 1000);
		int minutes = (int)(seconds)/60;
		minutesElapsed = seconds;
		return minutesElapsed;
	}
	

	
}