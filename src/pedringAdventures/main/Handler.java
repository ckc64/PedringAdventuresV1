package pedringAdventures.main;

import pedringAdventures.main.entities.Entity;
import pedringAdventures.main.gfx.GameCamera;
import pedringAdventures.main.input.KeyManager;
import pedringAdventures.main.input.MouseManager;
import pedringAdventures.main.worlds.World;
import pedringAdventures.main.worlds.houses.MapOneHouseOneWorld;

public class Handler {
	
	private Game game;
	private World world;
	private MapOneHouseOneWorld mapOneHouseOneWorld;
	private Entity entity;
	
	public Handler(Game game) {
		this.game=game;
	}
	
	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}
	
	public int getWidth() {
		return game.getWidth();
	}
	public int getHeight() {
		return game.getHeight();
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
	public void setHouseOneWorld(MapOneHouseOneWorld mapOneHouseOneWorld) {
		this.mapOneHouseOneWorld = mapOneHouseOneWorld;
	}
	
	public Entity getEntity() {
		return this.entity;
	}
	
//	public float getPlayerPositionX() {
//		return entity.getX();
//	}
//	public float getPlayerPositionY() {
//		return entity.getY();
//	}
	
	
}
