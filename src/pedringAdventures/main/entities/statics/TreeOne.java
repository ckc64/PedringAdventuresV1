package pedringAdventures.main.entities.statics;

import java.awt.Graphics;

import pedringAdventures.main.Handler;
import pedringAdventures.main.gfx.Assets;
import pedringAdventures.main.tiles.Tile;

public class TreeOne extends StaticEntity {

	public TreeOne(Handler handler, float x, float y) {
		super(handler, x, y, 32, 64);
		
	}

	@Override
	public void tick() {
		
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.treeOne,(int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()), width,height,null);
		
	}

}
