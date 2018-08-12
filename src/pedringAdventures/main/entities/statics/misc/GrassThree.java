package pedringAdventures.main.entities.statics.misc;

import java.awt.Color;
import java.awt.Graphics;

import pedringAdventures.main.Handler;
import pedringAdventures.main.entities.statics.StaticEntity;
import pedringAdventures.main.gfx.Assets;

public class GrassThree extends StaticEntity {

	public GrassThree(Handler handler, float x, float y) {
		super(handler, x, y, 32, 32);
		// TODO Auto-generated constructor stub
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
		g.drawImage(Assets.grassThree,(int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()), width,height,null);
//		DISPLAYING BOX
		g.setColor(Color.red);
		g.fillRect((int)(x+bounds.x - handler.getGameCamera().getxOffset()), (int)(y+bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}

}
