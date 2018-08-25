package pedringAdventures.main.worlds.houses;

import java.awt.Graphics;

import pedringAdventures.main.Handler;
import pedringAdventures.main.entities.Entity;
import pedringAdventures.main.entities.EntityManager;
import pedringAdventures.main.entities.HouseManager;
import pedringAdventures.main.entities.creatures.Player;
import pedringAdventures.main.items.ItemManager;
import pedringAdventures.main.states.State;
import pedringAdventures.main.tiles.Tile;
import pedringAdventures.main.utils.Utils;
import pedringAdventures.main.worlds.World;

public class MapOneHouseOneWorld {
	
	private Handler handler;
	private World world;
	private int width,height;
	private int spawnX,spawnY;
	private int[][] tiles;
	
	
	//entities
	private Player player;
	private HouseManager houseManager;
	private Entity entities;
	private EntityManager entityManager;
	//item
	private ItemManager itemManager;
	
	public MapOneHouseOneWorld(Handler handler,String path) {
		this.handler=handler;
		//map coordinates
		
	
		houseManager= new HouseManager(handler, new  Player(handler, 100, 100));
		
		itemManager=new ItemManager(handler);
		
		loadWorld(path);
		houseManager.getPlayer().setX(spawnX);
		houseManager.getPlayer().setY(spawnY);
	}
	
	
	public void tick() {
		itemManager.tick();
		houseManager.tick();
		//y=442 x=295
		System.out.println("Y Position : "+(int)houseManager.getPlayer().getY());
		System.out.println("X Position : "+(int)houseManager.getPlayer().getX());
		if((int)houseManager.getPlayer().getY()==1537 && (int)houseManager.getPlayer().getX()>1132
				&& (int)houseManager.getPlayer().getX()>1140 && handler.getKeyManager().down) {
		
			State.setState(handler.getGame().gameState);
		}
	}
	
	public void render(Graphics g) {
		for(int y=0;y<height;y++) {
			for(int x=0;x<width;x++) {
				getTile(x, y).render(g, (int) (x*Tile.TILEWIDTH-handler.getGameCamera().getxOffset()), (int)(y*Tile.TILEHEIGHT-handler.getGameCamera().getyOffset()));
			}
		}
		itemManager.render(g);
		houseManager.render(g);
		
	}
	
	public Tile getTile(int x,int y) {
		
		if(x<0||y<0||x>=width||y>=height) {
			return Tile.woodTile;
		}
		
		Tile t= Tile.tiles[tiles[x][y]];
		if(t==null)
			return Tile.woodTile;
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
	
	public HouseManager getHouseManager() {
		return houseManager;
	}




	public ItemManager getItemManager() {
		return itemManager;
	}




	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}
	
	
}
