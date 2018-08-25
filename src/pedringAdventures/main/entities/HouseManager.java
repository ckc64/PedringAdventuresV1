package pedringAdventures.main.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import pedringAdventures.main.Handler;
import pedringAdventures.main.entities.creatures.Player;

public class HouseManager {
	
	private Handler handler;
	private Player player;
	private ArrayList<Entity> houseEntities;
	
	private Comparator<Entity> renderSorter = new Comparator<Entity>() {

		@Override
		public int compare(Entity a, Entity b) {
			if(a.getY()+a.getHeight() < b.getY()+b.getHeight()){
				return -1;
			}
			return 1;
		}
	
	};
	
	
	public HouseManager(Handler handler, Player player) {
		this.handler = handler;
		this.player=player;
		houseEntities = new ArrayList<Entity>();
		addEntity(player);
	}
	
	public void tick() {
		Iterator<Entity> it = houseEntities.iterator();
		while(it.hasNext()) {
			Entity e = it.next();
			e.tick();
			if(!e.isActive())
				it.remove();;
		}
		houseEntities.sort(renderSorter);
	}
	public void render(Graphics g) {
		for(Entity e : houseEntities) {
			e.render(g);
		}
		player.postRender(g);
	}
	public void addEntity(Entity e) {
		houseEntities.add(e);
	}
	
	public void removeAllEntity() {
		houseEntities.clear();
	}
	
	//getters setters
	
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Entity> getEntities() {
		return houseEntities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.houseEntities = entities;
	}
}
