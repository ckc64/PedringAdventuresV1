package pedringAdventures.main.entities.statics.houses;

import java.awt.Graphics;

import pedringAdventures.main.Handler;
import pedringAdventures.main.entities.Entity;
import pedringAdventures.main.entities.statics.StaticEntity;
import pedringAdventures.main.gfx.Assets;

public class MainMap_HouseOne extends StaticEntity {


	public MainMap_HouseOne(Handler handler, float x, float y) {
		super(handler, x, y, 32*12, 32*12);
		// TODO Auto-generated constructor stub
		
		//COORDINATES OF THE BOX
		bounds.x=-10;
		bounds.y=73;
		
		//SIZE OF THE BOX
		bounds.width=365;
		bounds.height=283;
		
	
	}
	//boxsmall
	
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.main_map_house_one,(int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()), width,height,null);
		//DISPLAYING BOX
//				g.setColor(Color.red);
//				g.fillRect((int)(x+bounds.x - handler.getGameCamera().getxOffset()), (int)(y+bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
	}


	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Entity clone() {
		// TODO Auto-generated method stub
		Entity e = new MainMap_HouseOne(handler, x, y);
		return e;
	}

	
}
