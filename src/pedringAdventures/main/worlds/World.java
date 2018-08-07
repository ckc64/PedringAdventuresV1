package pedringAdventures.main.worlds;

import java.awt.Graphics;

import pedringAdventures.main.Game;
import pedringAdventures.main.Handler;
import pedringAdventures.main.entities.EntityManager;
import pedringAdventures.main.entities.creatures.Player;
import pedringAdventures.main.entities.statics.Grass;
import pedringAdventures.main.entities.statics.TreeOne;
import pedringAdventures.main.entities.statics.houses.MainMap_HouseOne;
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
		
		//grassTOP
		for(int i=1;i<83;i++) {entityManager.addEntity(new Grass(handler,32*i,32));}
		entityManager.addEntity(new Grass(handler,32,0));
		for(int i=1;i<=100;i++){entityManager.addEntity(new Grass(handler,32*i,0));}
		
		//grassLeft
		entityManager.addEntity(new Grass(handler,0, 0));
		for(int i=1;i<=100;i++){entityManager.addEntity(new Grass(handler,0,32*i));}
		//grassbottom
		entityManager.addEntity(new Grass(handler,32, 32*50));
		for(int i=1;i<=100;i++){entityManager.addEntity(new Grass(handler,32*i,32*50));}
		for(int i=1;i<=100;i++){entityManager.addEntity(new Grass(handler,32*i,32*51));}
		//grassRight
		entityManager.addEntity(new Grass(handler,32*83, 0));
		for(int i=1;i<=29;i++){entityManager.addEntity(new Grass(handler,32*83,32*i));}
		for(int i=34;i<=50;i++){entityManager.addEntity(new Grass(handler,32*83,32*i));}
		//after right
		for(int i=1;i<=29;i++){entityManager.addEntity(new Grass(handler,32*84,32*i));}
		for(int i=34;i<=50;i++){entityManager.addEntity(new Grass(handler,32*84,32*i));}
		for(int i=1;i<=29;i++){entityManager.addEntity(new Grass(handler,32*85,32*i));}
		for(int i=34;i<=50;i++){entityManager.addEntity(new Grass(handler,32*85,32*i));}
		
		//treescattered
		
		//trees left side
		entityManager.addEntity(new TreeOne(handler,32*17, 32*14));
		entityManager.addEntity(new TreeOne(handler,32*17, 32*20));
		entityManager.addEntity(new TreeOne(handler,32*36, 32*22));
		entityManager.addEntity(new TreeOne(handler,32*29, 32*8));
		entityManager.addEntity(new TreeOne(handler,32*25, 32*14));
		
		
	
		entityManager.addEntity(new TreeOne(handler,32*6, 32*26));
		entityManager.addEntity(new TreeOne(handler,32*12, 32*26));
		entityManager.addEntity(new TreeOne(handler,32*20, 32*26));

		
		entityManager.addEntity(new TreeOne(handler,32*15, 32*32));
		
		entityManager.addEntity(new TreeOne(handler,32*20, 32*35));
		entityManager.addEntity(new TreeOne(handler,32*20, 32*40));
		entityManager.addEntity(new TreeOne(handler,32*26, 32*34));
		entityManager.addEntity(new TreeOne(handler,32*26, 32*39));
		entityManager.addEntity(new TreeOne(handler,32*36, 32*32));
		
		entityManager.addEntity(new TreeOne(handler,32*28, 32*30));
		//end left side trees
		
		//trees right side
		entityManager.addEntity(new TreeOne(handler,32*42, 32*22));
		entityManager.addEntity(new TreeOne(handler,32*56, 32*20));
		entityManager.addEntity(new TreeOne(handler,32*60, 32*31));
		entityManager.addEntity(new TreeOne(handler,32*60, 32*26));
		entityManager.addEntity(new TreeOne(handler,32*66, 32*26));
		entityManager.addEntity(new TreeOne(handler,32*72, 32*26));
		
		entityManager.addEntity(new TreeOne(handler,32*60, 32*3));
		entityManager.addEntity(new TreeOne(handler,32*56, 32*7));
		entityManager.addEntity(new TreeOne(handler,32*60, 32*10));
		entityManager.addEntity(new TreeOne(handler,32*63, 32*13));
		//end trees right side
		
		//end trees scattered
		
		//houses
			entityManager.addEntity(new MainMap_HouseOne(handler, 150, 120));
			
		//end houses
		
		
		
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
