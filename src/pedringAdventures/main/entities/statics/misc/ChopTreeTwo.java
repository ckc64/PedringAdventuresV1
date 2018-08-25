package pedringAdventures.main.entities.statics.misc;

import java.awt.Graphics;

import pedringAdventures.main.Handler;
import pedringAdventures.main.entities.Entity;
import pedringAdventures.main.entities.statics.StaticEntity;
import pedringAdventures.main.gfx.Assets;

public class ChopTreeTwo extends StaticEntity {

	public ChopTreeTwo(Handler handler, float x, float y) {
		super(handler, x, y, 32*2, 32*2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Assets.chopTreeTwo,(int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()), width,height,null);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Entity clone() {
		// TODO Auto-generated method stub
		Entity e = new ChopTreeTwo(handler, x, y);
		return e;
	}

}
