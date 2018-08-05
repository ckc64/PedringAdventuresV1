package pedringAdventures.main.states;

import java.awt.Graphics;

import pedringAdventures.main.Game;
import pedringAdventures.main.Handler;
import pedringAdventures.main.entities.creatures.Player;
import pedringAdventures.main.gfx.Assets;
import pedringAdventures.main.tiles.Tile;
import pedringAdventures.main.worlds.World;

public class GameState extends State {
	
	
	private Player player;
	private World world;
	
	public GameState(Handler handler) {
		super(handler);
		
		world=new World(handler,"res/worlds/world1.txt");
		handler.setWorld(world);
		player = new Player(handler,65,150);
		
		
		
	}
	
	@Override
	public void tick() {
	
		world.tick();
		player.tick();
		
	}

	@Override
	public void render(Graphics g) {
		
		world.render(g);
		player.render(g);
	}

}
