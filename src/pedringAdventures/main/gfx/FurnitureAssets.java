package pedringAdventures.main.gfx;

import java.awt.image.BufferedImage;

public class FurnitureAssets {
	
	private static final int tileWidth=32,tileHeight=32;
	
	public static BufferedImage woodTile;
	public static BufferedImage houseWall;
	
	
	public static void init() {
		
		SpriteSheet houseAssets=new SpriteSheet(ImageLoader.loadImage("/textures/houseOneAssets/house_one_tileset.png"));
		
		woodTile=houseAssets.crop(0, 0, tileWidth*2, tileHeight);
	}
		
		
}
