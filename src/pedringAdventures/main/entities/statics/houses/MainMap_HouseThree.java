package pedringAdventures.main.entities.statics.houses;

import java.awt.Graphics;

import pedringAdventures.main.Handler;
import pedringAdventures.main.entities.statics.StaticEntity;
import pedringAdventures.main.gfx.Assets;

public class MainMap_HouseThree extends StaticEntity {


	public MainMap_HouseThree(Handler handler, float x, float y) {
		super(handler, x, y, 32*10, 32*13);
		// TODO Auto-generated constructor stub
		
		//COORDINATES OF THE BOX
		bounds.x=-10;
		bounds.y=140;
		
		//SIZE OF THE BOX
		bounds.width=340;
		bounds.height=250;
		
	
	}
	//boxsmall
	
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	//fix the bounding box;
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.main_map_house_three,(int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()), width,height,null);
//		DISPLAYING BOX
//				g.setColor(Color.red);
//				g.fillRect((int)(x+bounds.x - handler.getGameCamera().getxOffset()), (int)(y+bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
	}


	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}

	
}
