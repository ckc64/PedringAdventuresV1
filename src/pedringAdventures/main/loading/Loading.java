package pedringAdventures.main.loading;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import pedringAdventures.main.Handler;
import pedringAdventures.main.gfx.ImageModifier;
import pedringAdventures.main.states.LoadingState;
import pedringAdventures.main.states.MenuState;
import pedringAdventures.main.states.State;
import pedringAdventures.main.utils.Colors;

public class Loading {
	LoadingState loadingState1;
	Handler handler;
	public int loadTime=300;
	public boolean doneLoading=false;
	BufferedImage endSplash;
	
	public Loading(Handler handler, LoadingState loadingState1) {
		this.handler=handler;
		this.loadingState1=loadingState1;
	}
	public void loading() {
		doneLoading=true;
		loadTime=500;
		
	}
	
	public void render(Graphics g) {
		endSplash=ImageModifier.fadeImage(loadingState1.animateLoading(), 0, 0, 32*9, 32, Colors.ARGB, 0.9987f);
		g.drawImage(endSplash,210,300,null);
		
	}
	
	public void load() {
		
		if(State.getState()==handler.getGame().loadingState) {
			
			if(loadTime>-1)
				loadTime--;
			if(loadTime<0)
				doneLoading=true;
			if(loadTime<=0 && doneLoading)
				State.setState(handler.getGame().gameState);
			if(loadingState1.isLoading && loadTime<0) {
				loading();
				loadingState1.isLoading=true;
			}
			
		}
		System.out.println("Done loading "+doneLoading);
		System.out.println("Is loading "+loadingState1.isLoading);
	}
	
}
