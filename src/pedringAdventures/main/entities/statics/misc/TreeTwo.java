package pedringAdventures.main.entities.statics.misc;

import java.awt.Color;
import java.awt.Graphics;

import pedringAdventures.main.Handler;
import pedringAdventures.main.entities.statics.StaticEntity;
import pedringAdventures.main.gfx.Assets;
import pedringAdventures.main.tiles.Tile;

public class TreeTwo extends StaticEntity {

	public TreeTwo(Handler handler, float x, float y) {
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
		
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.treeTwo,(int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()), width,height,null);
		//DISPLAYING BOX
		g.setColor(Color.red);
		g.fillRect((int)(x+bounds.x - handler.getGameCamera().getxOffset()), (int)(y+bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
		
	}

}
