package pedringAdventures.main.entities.statics.misc;

import java.awt.Graphics;

import pedringAdventures.main.Handler;
import pedringAdventures.main.entities.statics.StaticEntity;
import pedringAdventures.main.gfx.Assets;

public class LogTwo extends StaticEntity {

	public LogTwo(Handler handler, float x, float y) {
		super(handler, x, y, 32*2, 32*3);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Assets.logTwo,(int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()), width,height,null);
	}

}
