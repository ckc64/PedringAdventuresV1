package pedringAdventures.main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

import pedringAdventures.main.display.Display;
import pedringAdventures.main.gfx.Assets;
import pedringAdventures.main.gfx.FurnitureAssets;
import pedringAdventures.main.gfx.GameCamera;
import pedringAdventures.main.gfx.MiscAssets;
import pedringAdventures.main.input.KeyManager;
import pedringAdventures.main.input.MouseManager;
import pedringAdventures.main.states.GameState;
import pedringAdventures.main.states.LoadingState;
import pedringAdventures.main.states.MenuState;
import pedringAdventures.main.states.State;
import pedringAdventures.main.states.MapOneHouseStates.MapOneHouseOneStates;

public class Game implements Runnable {
	
	private Display display;
	
	private int width, height;
	private Random rand;
	public String title;
	
	private Thread thread;
	private boolean running=false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	public State gameState,loadingState,houseOneState;
	public State menuState;
	
	//input
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	//camera
	private GameCamera gameCamera;
	
	//handler
	private Handler handler;
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title=title;
		keyManager=new KeyManager();
		mouseManager = new MouseManager();
		
	}
	
	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();
		MiscAssets.init();
		FurnitureAssets.init();
		handler = new Handler(this);
		gameCamera=new GameCamera(handler,0, 0);
		
		gameState = new GameState(handler);
		loadingState=new LoadingState(handler);
		menuState=new MenuState(handler);
		
		//house States
		houseOneState=new MapOneHouseOneStates(handler);
		State.setState(menuState);
		
	}
	//can be name as update

	private void tick() {
		keyManager.tick();
		
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
	
	@Override
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
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public MouseManager getMouseManager() {
		return mouseManager;
	}
	
	public GameCamera getGameCamera() {
		return gameCamera;
	}
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
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
