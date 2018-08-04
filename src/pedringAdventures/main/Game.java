package pedringAdventures.main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import pedringAdventures.main.display.Display;
import pedringAdventures.main.gfx.Assets;
import pedringAdventures.main.states.GameState;
import pedringAdventures.main.states.MenuState;
import pedringAdventures.main.states.State;

public class Game implements Runnable {
	
	private Display display;
	
	public int width, height;
	public String title;
	
	private Thread thread;
	private boolean running=false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	private State gameState;
	private State menuState;
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title=title;
		
		gameState = new GameState();
		menuState=new MenuState();
		State.setState(gameState);
	}
	
	private void init() {
		display = new Display(title, width, height);
		Assets.init();
	}
	//can be name as update

	private void tick() {
		if(State.getState()!=null) {
			State.getState().tick();
		}
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
		if(State.getState()!=null) {
			State.getState().render(g);
		}
		//end of drawing
		bs.show();
		g.dispose();
	}
	
	public void run() {
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1) { 
				tick(); 
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000){
				System.out.println("frames: " + ticks);
//				normal = frames;
				ticks = 0;
				timer = 0;
			}
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
