package pedringAdventures.main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import pedringAdventures.main.display.Display;

public class Game implements Runnable {
	
	private Display display;
	
	public int width, height;
	public String title;
	
	private Thread thread;
	private boolean running=false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title=title;
	}
	
	private void init() {
		display = new Display(title, width, height);
	}
	//can be name as update
	private void tick() {
		
	}
	private void render() {
		
		//to prevent flickering of a game
		bs=display.getCanvas().getBufferStrategy();
		if(bs==null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		//act as a paint brush
		g=bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		//you can draw here
		//end of drawing
		bs.show();
		g.dispose();
	}
	
	public void run() {
		
		init();
		while(running) {
			tick();
			render();
		}
		
		stop();
		
	}
	
	//this method here will call the run method by default
	public synchronized void start() {
		if(running)
			return;
		running =true;
		thread = new Thread(this);
		thread.start();
	}
	public synchronized void stop() {
		if(!running)
			return;
		running=false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
