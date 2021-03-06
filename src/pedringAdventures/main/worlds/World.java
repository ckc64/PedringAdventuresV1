package pedringAdventures.main.worlds;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import pedringAdventures.main.Handler;
import pedringAdventures.main.entities.Entity;
import pedringAdventures.main.entities.EntityManager;
import pedringAdventures.main.entities.creatures.Player;
import pedringAdventures.main.entities.statics.Grass;
import pedringAdventures.main.entities.statics.TreeOne;
import pedringAdventures.main.entities.statics.houses.MainMap_HouseFour;
import pedringAdventures.main.entities.statics.houses.MainMap_HouseOne;
import pedringAdventures.main.entities.statics.houses.MainMap_HouseThree;
import pedringAdventures.main.entities.statics.houses.MainMap_HouseTwo;
import pedringAdventures.main.entities.statics.misc.BigPond;
import pedringAdventures.main.entities.statics.misc.BigRock;
import pedringAdventures.main.entities.statics.misc.BigTreeCenter;
import pedringAdventures.main.entities.statics.misc.ChopTreeOne;
import pedringAdventures.main.entities.statics.misc.ChopTreeTwo;
import pedringAdventures.main.entities.statics.misc.FlowerOne;
import pedringAdventures.main.entities.statics.misc.FlowerThree;
import pedringAdventures.main.entities.statics.misc.FlowerTwo;
import pedringAdventures.main.entities.statics.misc.GrassThree;
import pedringAdventures.main.entities.statics.misc.GrassTwo;
import pedringAdventures.main.entities.statics.misc.LogOne;
import pedringAdventures.main.entities.statics.misc.LogThree;
import pedringAdventures.main.entities.statics.misc.LogTwo;
import pedringAdventures.main.entities.statics.misc.NoLeavesTree;
import pedringAdventures.main.entities.statics.misc.RockOne;
import pedringAdventures.main.entities.statics.misc.RockThree;
import pedringAdventures.main.entities.statics.misc.TreeTwo;
import pedringAdventures.main.items.ItemManager;
import pedringAdventures.main.states.State;
import pedringAdventures.main.tiles.Tile;
import pedringAdventures.main.utils.Utils;

public class World {
	
	private Handler handler;
	private int width,height;
	private int spawnX,spawnY;
	private int[][] tiles;
	
	
	//entities
	private ArrayList<Entity>worldObject;
	private Player player;
	private EntityManager entityManager; 
	//item
	private ItemManager itemManager;
	public World(Handler handler,String path) {
		this.handler=handler;
						
		worldObject = new ArrayList<Entity>();	
		//map coordinates
		entityManager= new EntityManager(handler, new  Player(handler, 100, 100));
		itemManager=new ItemManager(handler);

		addGroundItems();
		copyObjectsToEntityManager();
		
			//end misc
			
		loadWorld(path);
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
		
		
//		
//		System.out.println("X Position : "+player.getX());
		
		
	}
	

	public void copyObjectsToEntityManager() {
		Iterator<Entity> it = worldObject.iterator();
		
		while(it.hasNext()) {
			entityManager.addEntity(it.next());
		}

	}
	
	public void addGroundItems() {
		
		//grassTOP
				for(int i=1;i<83;i++) {worldObject.add(new Grass(handler,32*i,32));}
				worldObject.add(new Grass(handler,32,0));
				for(int i=1;i<=100;i++){worldObject.add(new Grass(handler,32*i,0));}
				
				//grassLeft
				worldObject.add(new Grass(handler,0, 0));
				for(int i=1;i<=100;i++){worldObject.add(new Grass(handler,0,32*i));}
				//grassbottom
				worldObject.add(new Grass(handler,32, 32*50));
				for(int i=1;i<=100;i++){worldObject.add(new Grass(handler,32*i,32*50));}
				for(int i=1;i<=100;i++){worldObject.add(new Grass(handler,32*i,32*51));}
				//grassRight
				worldObject.add(new Grass(handler,32*83, 0));
				for(int i=1;i<=29;i++){worldObject.add(new Grass(handler,32*83,32*i));}
				for(int i=34;i<=50;i++){worldObject.add(new Grass(handler,32*83,32*i));}
				//after right
				for(int i=1;i<=29;i++){worldObject.add(new Grass(handler,32*84,32*i));}
				for(int i=34;i<=50;i++){worldObject.add(new Grass(handler,32*84,32*i));}
				for(int i=1;i<=29;i++){worldObject.add(new Grass(handler,32*85,32*i));}
				for(int i=34;i<=50;i++){worldObject.add(new Grass(handler,32*85,32*i));}
				
				//treescattered
				
				//trees left side
				worldObject.add(new TreeOne(handler,32*17, 32*14));
				worldObject.add(new TreeOne(handler,32*17, 32*20));
				worldObject.add(new TreeOne(handler,32*36, 32*22));
				worldObject.add(new TreeOne(handler,32*29, 32*8));
				worldObject.add(new TreeOne(handler,32*25, 32*14));
				
				
			
				worldObject.add(new TreeOne(handler,32*6, 32*26));
				worldObject.add(new TreeOne(handler,32*12, 32*26));
				worldObject.add(new TreeOne(handler,32*20, 32*26));

				
				worldObject.add(new TreeOne(handler,32*15, 32*32));
				
				worldObject.add(new TreeOne(handler,32*20, 32*35));
				worldObject.add(new TreeOne(handler,32*20, 32*40));
				worldObject.add(new TreeOne(handler,32*26, 32*34));
				worldObject.add(new TreeOne(handler,32*26, 32*39));
				worldObject.add(new TreeOne(handler,32*36, 32*32));
				
				worldObject.add(new TreeOne(handler,32*28, 32*30));
				//end left side trees
				
				//trees right side
				worldObject.add(new TreeOne(handler,32*42, 32*22));
				worldObject.add(new TreeOne(handler,32*56, 32*20));
				worldObject.add(new TreeOne(handler,32*60, 32*31));
				worldObject.add(new TreeOne(handler,32*60, 32*26));
				worldObject.add(new TreeOne(handler,32*66, 32*26));
				worldObject.add(new TreeOne(handler,32*72, 32*26));
				
				worldObject.add(new TreeOne(handler,32*60, 32*3));
				worldObject.add(new TreeOne(handler,32*56, 32*7));
				worldObject.add(new TreeOne(handler,32*60, 32*10));
				worldObject.add(new TreeOne(handler,32*63, 32*13));
				
				worldObject.add(new TreeOne(handler, 1340, 1010));
				//end trees right side
				worldObject.add(new TreeOne(handler, 1020, 710));
				//end trees scattered
				
				//houses
			
					worldObject.add(new MainMap_HouseOne(handler, 120, 120));
					worldObject.add(new MainMap_HouseTwo(handler, 1131, 285));
					worldObject.add(new MainMap_HouseThree(handler, 2080, 280));
					worldObject.add(new MainMap_HouseFour(handler, 167, 1023));
					
				//end houses
				
				//grassscattered and flowers
					for(int i=1;i<200;i+=32) {worldObject.add(new GrassTwo(handler, 32, 64+i));}
					for(int i=1;i<250;i+=32) {worldObject.add(new GrassTwo(handler, 32*2, 64+i));}
					for(int i=1;i<200;i+=32) {worldObject.add(new GrassTwo(handler, 32*3, 92+i));}
					
					for(int i=1;i<1096;i+=32) {worldObject.add(new GrassTwo(handler, 32, (32*15)+i));}
					for(int i=1;i<250;i+=32) {worldObject.add(new GrassTwo(handler, 32*2, (32*12)+i));}
					for(int i=1;i<200;i+=32) {worldObject.add(new GrassTwo(handler, 32*3, (32*17)+i));}
					
					for(int i=1;i<270;i+=32) {worldObject.add(new GrassTwo(handler, (32*6)+i, (32*34)));}
					for(int i=1;i<500;i+=32) {worldObject.add(new GrassTwo(handler, (32*6)+i, (32*35)));}
					
					for(int i=1;i<250;i+=32) {worldObject.add(new GrassTwo(handler, 32*5, (32*15)+i));}
					for(int i=1;i<250;i+=32) {worldObject.add(new GrassTwo(handler, 32*6, (32*16)+i));}
					for(int i=1;i<250;i+=32) {worldObject.add(new GrassTwo(handler, 32*7, (32*18)+i));}
					
					for(int i=1;i<250;i+=32) {worldObject.add(new GrassTwo(handler, 32*12, (32*18)+i));}
					for(int i=1;i<250;i+=32) {worldObject.add(new GrassTwo(handler, 32*13, (32*16)+i));}
					for(int i=1;i<100;i+=32) {worldObject.add(new GrassTwo(handler, 32*14, (32*16)+i));}
					
					for(int i=1;i<100;i+=32) {worldObject.add(new GrassTwo(handler, 32*22, (32*21)+i));}
					for(int i=1;i<100;i+=32) {worldObject.add(new GrassTwo(handler, 32*23, (32*22)+i));}
					for(int i=1;i<100;i+=32) {worldObject.add(new GrassTwo(handler, 32*21, (32*23)+i));}
					
					for(int i=1;i<100;i+=32) {worldObject.add(new GrassTwo(handler, (32*15)+i, (32*4)));}
					for(int i=1;i<100;i+=32) {worldObject.add(new GrassTwo(handler, (32*16)+i, (32*3)));}
					
					for(int i=1;i<100;i+=32) {worldObject.add(new GrassTwo(handler, (32*21)+i, (32*2)));}
					for(int i=1;i<100;i+=32) {worldObject.add(new GrassTwo(handler, (32*22)+i, (32*3)));}
					
					for(int i=1;i<100;i+=32) {worldObject.add(new GrassTwo(handler, (32*36)+i, (32*2)));}
					for(int i=1;i<100;i+=32) {worldObject.add(new GrassTwo(handler, (32*34)+i, (32*3)));}
					for(int i=1;i<100;i+=32) {worldObject.add(new GrassTwo(handler, (32*35)+i, (32*4)));}
					
					for(int i=1;i<100;i+=32) {worldObject.add(new GrassTwo(handler, (32*55)+i, (32*2)));}
					for(int i=1;i<100;i+=32) {worldObject.add(new GrassTwo(handler, (32*57)+i, (32*3)));}
					
					for(int i=1;i<100;i+=32) {worldObject.add(new GrassTwo(handler, (32*49)+i, (32*13)));}
					for(int i=1;i<100;i+=32) {worldObject.add(new GrassTwo(handler, (32*51)+i, (32*14)));}
					for(int i=1;i<100;i+=32) {worldObject.add(new GrassTwo(handler, (32*49)+i, (32*15)));}
					
					for(int i=1;i<100;i+=32) {worldObject.add(new GrassTwo(handler, (32*67)+i, (32*3)));}
					for(int i=1;i<100;i+=32) {worldObject.add(new GrassTwo(handler, (32*69)+i, (32*2)));}
					
					
					for(int i=1;i<100;i+=32) {worldObject.add(new GrassTwo(handler, (32*73)+i, (32*7)));}
					for(int i=1;i<100;i+=32) {worldObject.add(new GrassTwo(handler, (32*74)+i, (32*8)));}
					
					for(int i=1;i<100;i+=32) {worldObject.add(new GrassTwo(handler, (32*73)+i, (32*24)));}
					for(int i=1;i<100;i+=32) {worldObject.add(new GrassTwo(handler, (32*74)+i, (32*25)));}
					for(int i=1;i<100;i+=32) {worldObject.add(new GrassTwo(handler, (32*75)+i, (32*26)));}
					
					for(int i=1;i<100;i+=32) {worldObject.add(new GrassTwo(handler, (32*73)+i, (32*34)));}
					for(int i=1;i<100;i+=32) {worldObject.add(new GrassTwo(handler, (32*74)+i, (32*35)));}
					for(int i=1;i<100;i+=32) {worldObject.add(new GrassTwo(handler, (32*77)+i, (32*36)));}
					
					for(int i=1;i<350;i+=32) {worldObject.add(new GrassTwo(handler, (32*72)+i, (32*48)));}
					for(int i=1;i<350;i+=32) {worldObject.add(new GrassTwo(handler, (32*72)+i, (32*49)));}
					for(int i=1;i<300;i+=32) {worldObject.add(new GrassTwo(handler, (32*66)+i, (32*47)));}
					for(int i=1;i<300;i+=32) {worldObject.add(new GrassTwo(handler, (32*66)+i, (32*46)));}
					for(int i=1;i<300;i+=32) {worldObject.add(new GrassTwo(handler, (32*67)+i, (32*45)));}
					for(int i=1;i<300;i+=32) {worldObject.add(new GrassTwo(handler, (32*65)+i, (32*44)));}
					for(int i=1;i<300;i+=32) {worldObject.add(new GrassTwo(handler, (32*65)+i, (32*43)));}
					for(int i=1;i<250;i+=32) {worldObject.add(new GrassTwo(handler, (32*70)+i, (32*42)));}
					for(int i=1;i<250;i+=32) {worldObject.add(new GrassTwo(handler, (32*70)+i, (32*41)));}
					for(int i=1;i<250;i+=32) {worldObject.add(new GrassTwo(handler, (32*70)+i, (32*40)));}
					for(int i=1;i<250;i+=32) {worldObject.add(new GrassTwo(handler, (32*70)+i, (32*39)));}
					for(int i=1;i<250;i+=32) {worldObject.add(new GrassTwo(handler, (32*70)+i, (32*38)));}
					for(int i=1;i<350;i+=32) {worldObject.add(new GrassTwo(handler, (32*72)+i, (32*37)));}
					
					for(int i=1;i<350;i+=32) {worldObject.add(new GrassTwo(handler, (32*60)+i, (32*48)));}
					for(int i=1;i<350;i+=32) {worldObject.add(new GrassTwo(handler, (32*55)+i, (32*49)));}
					
					for(int i=1;i<100;i+=32) {worldObject.add(new GrassTwo(handler, (32*58)+i, (32*46)));}
					for(int i=1;i<100;i+=32) {worldObject.add(new GrassTwo(handler, (32*55)+i, (32*47)));}
					
					for(int i=1;i<300;i+=32) {worldObject.add(new GrassTwo(handler, (32*36)+i, (32*46)));}
					for(int i=1;i<300;i+=32) {worldObject.add(new GrassTwo(handler, (32*30)+i, (32*47)));}
					for(int i=1;i<300;i+=32) {worldObject.add(new GrassTwo(handler, (32*27)+i, (32*48)));}
					
					for(int i=1;i<300;i+=32) {worldObject.add(new GrassTwo(handler, (32*44), (32*36)+i));}
					for(int i=1;i<350;i+=32) {worldObject.add(new GrassTwo(handler, (32*45), (32*37)+i));}
					for(int i=1;i<350;i+=32) {worldObject.add(new GrassTwo(handler, (32*46), (32*38)+i));}
					for(int i=1;i<350;i+=32) {worldObject.add(new GrassTwo(handler, (32*47), (32*38)+i));}
					for(int i=1;i<300;i+=32) {worldObject.add(new GrassTwo(handler, (32*48), (32*38)+i));}
					for(int i=1;i<250;i+=32) {worldObject.add(new GrassTwo(handler, (32*49), (32*38)+i));}
					
					for(int i=1;i<500;i+=32) {worldObject.add(new GrassTwo(handler, (32*43)+i, (32*39)));}
					for(int i=1;i<300;i+=32) {worldObject.add(new GrassTwo(handler, (32*42)+i, (32*40)));}
					
					worldObject.add(new FlowerOne(handler,92, 64));
					worldObject.add(new FlowerOne(handler,92, 300));
					worldObject.add(new FlowerOne(handler,1200, 96));
					worldObject.add(new FlowerOne(handler,1800, 96));
					worldObject.add(new FlowerOne(handler,170, 445));
					worldObject.add(new FlowerOne(handler,92, 500));
					worldObject.add(new FlowerOne(handler,225, 545));
					worldObject.add(new FlowerOne(handler,64, 640));
					worldObject.add(new FlowerOne(handler,170, 745));
					worldObject.add(new FlowerOne(handler,92, 850));
					worldObject.add(new FlowerOne(handler,64, 947));
					
					worldObject.add(new GrassThree(handler,380, 645));
					worldObject.add(new GrassThree(handler,1080, 800));
					worldObject.add(new GrassThree(handler,1120, 800));
					worldObject.add(new GrassThree(handler,2300, 745));
					
					worldObject.add(new FlowerTwo(handler,380, 745));
					worldObject.add(new FlowerTwo(handler,500, 96));
					worldObject.add(new FlowerTwo(handler,800, 64));
					worldObject.add(new FlowerTwo(handler,2200, 64));
					worldObject.add(new FlowerTwo(handler,2400, 200));
					worldObject.add(new FlowerTwo(handler,680, 745));
					worldObject.add(new FlowerTwo(handler,1600, 445));
					worldObject.add(new FlowerTwo(handler,1350, 1220));
					worldObject.add(new FlowerTwo(handler,1750, 1420));
					worldObject.add(new FlowerTwo(handler,1750, 1520));
					
					worldObject.add(new FlowerThree(handler,410, 770));
					worldObject.add(new FlowerThree(handler,680, 700));
					worldObject.add(new FlowerThree(handler,1570, 450));
					worldObject.add(new FlowerThree(handler,1730, 1450));
					worldObject.add(new FlowerThree(handler,2400, 800));
					
					worldObject.add(new RockThree(handler,1790, 1420));
					worldObject.add(new RockThree(handler,580, 580));
					
					
				//end grassscattered
					//misc
					worldObject.add(new BigTreeCenter(handler, 1650, 700));
					worldObject.add(new TreeTwo(handler, 800, 710));
					worldObject.add(new TreeTwo(handler, 600, 300));
					worldObject.add(new TreeTwo(handler, 1950, 710));
					worldObject.add(new TreeTwo(handler, 1300, 1400));
					worldObject.add(new TreeTwo(handler, 2050, 1200));
					worldObject.add(new LogOne(handler, 900, 1157));
					worldObject.add(new LogTwo(handler, 1334, 1125));
					worldObject.add(new LogThree(handler, 2530, 1080));
					worldObject.add(new BigPond(handler,  2350, 1200));
					worldObject.add(new NoLeavesTree(handler, 800, 300));
					worldObject.add(new NoLeavesTree(handler, 2500, 650));
					worldObject.add(new NoLeavesTree(handler, 1600, 1300));
					worldObject.add(new NoLeavesTree(handler, 1030, 1088));
					worldObject.add(new BigRock(handler, 1150, 1150));
					worldObject.add(new BigRock(handler, 1080, 830));
					worldObject.add(new BigRock(handler, 1472, 769));
					worldObject.add(new BigRock(handler, 1600, 1153));
					
					worldObject.add(new RockOne(handler, 1150, 830));
					worldObject.add(new RockOne(handler, 1400, 1085));
					worldObject.add(new RockOne(handler, 2450, 1090));
					worldObject.add(new ChopTreeOne(handler, 600, 1410));
					worldObject.add(new ChopTreeTwo(handler, 830, 1410));
					
					//temporary
					worldObject.add(new BigRock(handler, 126, 64));
		
	}
	

	public void tick() {
		itemManager.tick();
		entityManager.tick();
	
		//y=442 x=295
		System.out.println("Y Position : "+(int)entityManager.getPlayer().getY());
		System.out.println("X Position : "+(int)entityManager.getPlayer().getX());
		if((int)entityManager.getPlayer().getY()==442 && (int)entityManager.getPlayer().getX()==295
				&& handler.getKeyManager().up) {
//				entityManager.removeAllEntity();
				State.setState(handler.getGame().houseOneState);
		}
	}
	
	public void render(Graphics g) {
		for(int y=0;y<height;y++) {
			for(int x=0;x<width;x++) {
				getTile(x, y).render(g, (int) (x*Tile.TILEWIDTH-handler.getGameCamera().getxOffset()), (int)(y*Tile.TILEHEIGHT-handler.getGameCamera().getyOffset()));
			}
		}
		itemManager.render(g);
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




	public ItemManager getItemManager() {
		return itemManager;
	}




	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}
	
}
