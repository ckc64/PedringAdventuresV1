package pedringAdventures.main.states;

import java.awt.Graphics;

import pedringAdventures.main.Handler;

public abstract class State {
	
	public static State currentState = null;
//	public boolean isNewGame = true;
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() { return currentState; }

	
	//class
	protected Handler handler;
	
	public State(Handler handler) {
		this.handler=handler;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
}
