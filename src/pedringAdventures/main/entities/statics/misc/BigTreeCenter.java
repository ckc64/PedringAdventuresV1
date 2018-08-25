package pedringAdventures.main.entities.statics.misc;

import java.awt.Graphics;

import pedringAdventures.main.Handler;
import pedringAdventures.main.entities.Entity;
import pedringAdventures.main.entities.statics.StaticEntity;
import pedringAdventures.main.gfx.Assets;

public class BigTreeCenter extends StaticEntity {

	public BigTreeCenter(Handler handler, float x, float y) {
		super(handler, x, y, 64*5, 64*5);
		//COORDINATES OF THE BOX
				bounds.x=105;
				bounds.y=210;
				
				//SIZE OF THE BOX
				bounds.width=40;
				bounds.height=40;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.BigTreeCenter,(int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()), width,height,null);
		//DISPLAYING BOX
//		g.setColor(Color.red);
//		g.fillRect((int)(x+bounds.x - handler.getGameCamera().getxOffset()), (int)(y+bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
		
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Entity clone() {
		// TODO Auto-generated method stub
		Entity e = new BigTreeCenter(handler, x, y);
		return e;
	}

}
