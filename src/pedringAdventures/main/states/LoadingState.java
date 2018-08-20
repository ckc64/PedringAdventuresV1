package pedringAdventures.main.states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import pedringAdventures.main.Handler;
import pedringAdventures.main.gfx.Animation;
import pedringAdventures.main.gfx.MiscAssets;
import pedringAdventures.main.loading.Loading;
import pedringAdventures.main.utils.Timer;

public class LoadingState extends State {
	
	
	private Animation animateLoading;
	public static final int loadingSpeed = 500;
	private Timer timer;
	
	public Loading loadScreen = new Loading(handler,this);
	public boolean isLoading=false;
	
	public LoadingState(Handler handler) {
		super(handler);
		timer = new Timer(handler);
		animateLoading = new Animation(loadingSpeed, MiscAssets.loading);
		
	}
	

	@Override
	public void tick() {
		loadScreen.load();
		animateLoading.tick();
	}

	@Override
	public void render(Graphics g) {
	
			
		
		g.fillRect(0, 0, handler.getWidth(), handler.getWidth());
//			g.drawImage(animateLoading(), 210,300,null);
		if(State.getState()==handler.getGame().loadingState) {
			loadScreen.render(g);
		}
		
	
	}
	
	public BufferedImage animateLoading() {
		return animateLoading.getCurrentFrame();
	}
	
	
	public int getTimeAnimation() {
		return loadingSpeed;
	}
}
