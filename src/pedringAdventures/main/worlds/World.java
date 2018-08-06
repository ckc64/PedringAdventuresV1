package pedringAdventures.main.worlds;

import java.awt.Graphics;

import pedringAdventures.main.Game;
import pedringAdventures.main.Handler;
import pedringAdventures.main.entities.EntityManager;
import pedringAdventures.main.entities.creatures.Player;
import pedringAdventures.main.entities.statics.Grass;
import pedringAdventures.main.tiles.Tile;
import pedringAdventures.main.utils.Utils;

public class World {
	
	private Handler handler;
	private int width,height;
	private int spawnX,spawnY;
	private int[][] tiles;
	
	//entities
	private EntityManager entityManager; 
	
	public World(Handler handler,String path) {
		this.handler=handler;
		entityManager= new EntityManager(handler, new  Player(handler, 100, 100));
		entityManager.addEntity(new Grass(handler,0,0));
		entityManager.addEntity(new Grass(handler,32,0));
		entityManager.addEntity(new Grass(handler,32*2,0));
		loadWorld(path);
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}
	


	public void tick() {
		entityManager.tick();
	}
	
	public void render(Graphics g) {
		for(int y=0;y<height;y++) {
			for(int x=0;x<width;x++) {
				getTile(x, y).render(g, (int) (x*Tile.TILEWIDTH-handler.getGameCamera().getxOffset()), (int)(y*Tile.TILEHEIGHT-handler.getGameCamera().getyOffset()));
			}
		}
		entityManager.render(g);
	}
	
	public Tile getTile(int x,int y) {
		
		if(x<0||y<0||x>=width||y>=height) {
			return Tile.grassTile;
		}
		
		Tile t= Tile.tiles[tiles[x][y]];
		if(t==null)
			return Tile.grassTile;
		return t;
	}
	
	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[]tokens=file.split("\\s+");
		width=Utils.parseInt(tokens[0]);
		height=Utils.parseInt(tokens[1]);
		spawnX=Utils.parseInt(tokens[2]);
		spawnY=Utils.parseInt(tokens[3]);
		
		tiles = new int [width][height];
		for(int y=0;y<height;y++) {
			for(int x=0;x<width;x++) {
				tiles[x][y]=Utils.parseInt(tokens[(x+y*width)+4]);
			}
		}
	}
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
}
