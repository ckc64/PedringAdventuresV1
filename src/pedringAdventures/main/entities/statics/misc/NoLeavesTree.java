package pedringAdventures.main.entities.statics.misc;

import java.awt.Graphics;

import pedringAdventures.main.Handler;
import pedringAdventures.main.entities.Entity;
import pedringAdventures.main.entities.statics.StaticEntity;
import pedringAdventures.main.gfx.Assets;

public class NoLeavesTree extends StaticEntity {

	public NoLeavesTree(Handler handler, float x, float y) {
		super(handler, x, y, 64*2, 64*2);
		//COORDINATES OF THE BOX
		bounds.x=55;
		bounds.y=95;
		
		//SIZE OF THE BOX
		bounds.width=20;
		bounds.height=28;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.noLeavesTree,(int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()), width,height,null);
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
		Entity e = new NoLeavesTree(handler, x, y);
		return e;
	}
	
	
	
}
