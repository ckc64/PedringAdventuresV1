package pedringAdventures.main.entities.statics;

import java.awt.Graphics;

import pedringAdventures.main.Handler;
import pedringAdventures.main.gfx.Assets;

public class Grass extends StaticEntity {

	public Grass(Handler handler, float x, float y) {
		super(handler, x, y, 32, 32);
		
	}

	@Override
	public void tick() {
		
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.grass,(int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()), width,height,null);
		
	}

}
