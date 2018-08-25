package pedringAdventures.main.entities.statics.misc;

import java.awt.Graphics;

import pedringAdventures.main.Handler;
import pedringAdventures.main.entities.Entity;
import pedringAdventures.main.entities.statics.StaticEntity;
import pedringAdventures.main.entities.statics.houses.MainMap_HouseFour;
import pedringAdventures.main.gfx.Assets;

public class BigPond extends StaticEntity {

	public BigPond(Handler handler, float x, float y) {
		super(handler, x, y, 32*10, 32*10);
		
			
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.bigPond,(int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()), width,height,null);
		
		
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Entity clone() {
		// TODO Auto-generated method stub
		Entity e = new BigPond(handler, x, y);
		return e;
	}
	

}
