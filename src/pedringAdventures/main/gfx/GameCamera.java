package pedringAdventures.main.gfx;

import pedringAdventures.main.Handler;
import pedringAdventures.main.entities.Entity;
import pedringAdventures.main.tiles.Tile;

public class GameCamera {
	//i.e if you have 10 xOffset you can have -10
	//offset mean how many pixel away from your original offset
	private float xOffset,yOffset;
	
	private Handler handler;
	
	public GameCamera(Handler handler,float xOffset,float yOffset) {
		this.handler=handler;
		this.xOffset=xOffset;
		this.yOffset=yOffset;
		
	}
	
	public void checkIfBlankSpace() {
		if(xOffset<0) {
			xOffset=0;
		}else if(xOffset>handler.getWorld().getWidth()*Tile.TILEWIDTH-handler.getWidth()) {
			xOffset=handler.getWorld().getWidth()*Tile.TILEWIDTH-handler.getWidth();
		}
		if(yOffset<0) {
			yOffset=0;
		}else if(yOffset>handler.getWorld().getHeight()*Tile.TILEHEIGHT-handler.getHeight()) {
			yOffset=handler.getWorld().getHeight()*Tile.TILEHEIGHT-handler.getHeight();
		}
	}
	
	public void centerOnEntity(Entity e) {
		xOffset=e.getX()-handler.getWidth()/2+e.getWidth();
		yOffset=e.getY()-handler.getHeight()/2+e.getHeight();
		checkIfBlankSpace();
	}
	
	public void move(float xAmt, float yAmt) {
		xOffset+=xAmt;
		yOffset+=yAmt;
		checkIfBlankSpace();
	}
	public float getxOffset() {
		return xOffset;
	}
	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}
	public float getyOffset() {
		return yOffset;
	}
	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
}
