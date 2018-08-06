package pedringAdventures.main.states;

import java.awt.Graphics;

import pedringAdventures.main.Game;
import pedringAdventures.main.Handler;
import pedringAdventures.main.entities.creatures.Player;
import pedringAdventures.main.entities.statics.Grass;
import pedringAdventures.main.entities.statics.TreeOne;
import pedringAdventures.main.gfx.Assets;
import pedringAdventures.main.tiles.Tile;
import pedringAdventures.main.worlds.World;

public class GameState extends State {
	
	

	private World world;

	
	public GameState(Handler handler) {
		super(handler);
		
		world=new World(handler,"res/worlds/map1.txt");
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
