package pedringAdventures.main.states;

import java.awt.Graphics;

public abstract class State {
	
	public static State currentState = null;
//	public boolean isNewGame = true;
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() { return currentState; }
//	protected Handler handler;
//	protected Transition tran;
//	public State(Handler handler, Transition tran){
//		this.handler = handler; this.tran = tran;
//	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
}
