package pedringAdventures.main.states;

import java.awt.Graphics;

import pedringAdventures.main.Game;
import pedringAdventures.main.entities.creatures.Player;
import pedringAdventures.main.gfx.Assets;

public class GameState extends State {
	
	
	private Player player;
	
	public GameState(Game game) {
		super(game);
		player = new Player(game,100,100);
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		player.render(g);
		
	}

}
