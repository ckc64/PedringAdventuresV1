package pedringAdventures.main.utils;

import pedringAdventures.main.Handler;

public class Timer {
	
	private Handler handler;
	
	
	public Timer(Handler handler) {
		this.handler=handler;
	}
	
	public int timerLoad() {
		int numOfSeconds=5;
		long globalTime = System.nanoTime();
		float currentTime=0;
		numOfSeconds+=1;
		while(currentTime<numOfSeconds) {
			currentTime=(int)((System.nanoTime()-globalTime)/1000000000f);
				if(currentTime==numOfSeconds-1) {
					return (int)currentTime;
				}
			}
		return 1;
	}
	

}
