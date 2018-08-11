package pedringAdventures.main.entities.statics.misc;

import java.awt.Graphics;

import pedringAdventures.main.Handler;
import pedringAdventures.main.entities.statics.StaticEntity;
import pedringAdventures.main.gfx.Assets;

public class FlowerOne extends StaticEntity {

	public FlowerOne(Handler handler, float x, float y) {
		super(handler, x, y, 32, 32);

		//COORDINATES OF THE BOX
		bounds.x=0;
		bounds.y=0;
		
		//SIZE OF THE BOX
		bounds.width=0;
		bounds.height=0;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Assets.flowerOne,(int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()), width,height,null);
	}

}
