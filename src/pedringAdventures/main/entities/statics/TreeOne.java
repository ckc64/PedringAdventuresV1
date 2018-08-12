package pedringAdventures.main.entities.statics;

import java.awt.Graphics;

import pedringAdventures.main.Handler;
import pedringAdventures.main.gfx.Assets;
import pedringAdventures.main.items.Item;

public class TreeOne extends StaticEntity {

	public TreeOne(Handler handler, float x, float y) {
		super(handler, x, y, 64, 64*2);
		
		//COORDINATES OF THE BOX
		bounds.x=20;
		bounds.y=90;
		
		//SIZE OF THE BOX
		bounds.width=20;
		bounds.height=28;
	}

	@Override
	public void tick() {
		
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.treeOne,(int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()), width,height,null);
		//DISPLAYING BOX
//		g.setColor(Color.red);
//		g.fillRect((int)(x+bounds.x - handler.getGameCamera().getxOffset()), (int)(y+bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
		
	}

	@Override
	public void die() {
		handler.getWorld().getItemManager().addItem(Item.treeItem.createNew((int)x, (int)y));
	}

}
