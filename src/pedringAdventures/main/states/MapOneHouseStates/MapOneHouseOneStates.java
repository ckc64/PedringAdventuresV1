package pedringAdventures.main.states.MapOneHouseStates;

import java.awt.Graphics;

import pedringAdventures.main.Handler;
import pedringAdventures.main.states.State;
import pedringAdventures.main.worlds.houses.MapOneHouseOneWorld;

public class MapOneHouseOneStates extends State {
	
private MapOneHouseOneWorld mapHouseOneWorld;
	
	public MapOneHouseOneStates(Handler handler) {
		super(handler);
		
		mapHouseOneWorld=new MapOneHouseOneWorld(handler,"res/worlds/HouseOneMap.txt");
		handler.setHouseOneWorld(mapHouseOneWorld);

	}
	
	@Override
	public void tick() {
		mapHouseOneWorld.tick();
		
		
	}

	@Override
	public void render(Graphics g) {
		
		mapHouseOneWorld.render(g);
		
	}
}
