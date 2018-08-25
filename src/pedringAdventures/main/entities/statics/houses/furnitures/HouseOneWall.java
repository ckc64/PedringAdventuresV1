package pedringAdventures.main.entities.statics.houses.furnitures;

import java.awt.Graphics;

import pedringAdventures.main.Handler;
import pedringAdventures.main.entities.Entity;
import pedringAdventures.main.entities.statics.StaticEntity;

public class HouseOneWall extends StaticEntity {

	public HouseOneWall(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Entity clone() {
		// TODO Auto-generated method stub
		Entity e = new HouseOneWall(handler, x, y, width, height);
		return e;
	}
	
	
	
}
