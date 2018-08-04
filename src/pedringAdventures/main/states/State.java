package pedringAdventures.main.states;

import java.awt.Graphics;

import pedringAdventures.main.Game;

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
	
	//class
	protected Game game;
	
	public State(Game game) {
		this.game=game;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
}
