package pedringAdventures.main.states;

import java.awt.Color;
import java.awt.Graphics;

import pedringAdventures.main.Handler;
import pedringAdventures.main.worlds.World;


public class GameState extends State {
	
	

	private World world;
	
	public GameState(Handler handler) {
		super(handler);
		
		world=new World(handler,"res/worlds/VisaiyanVillage.txt");
		handler.setWorld(world);

	}
	
	@Override
	public void tick() {
		world.tick();
		
		
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		
	}

}
