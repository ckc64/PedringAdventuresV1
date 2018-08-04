package pedringAdventures.main.gfx;

import java.awt.image.BufferedImage;

public class Assets {
private static final int tileWidth = 64, tileHeight = 64;
private static final int charWidth=32, charHeight=32;
	
	//Main Character
	
	public static BufferedImage[] player_up, player_down, player_left, player_right,player_idle;
	
	//houses
	public static BufferedImage main_map_house_one, main_map_house_two, main_map_house_three, main_map_house_four;
	
	//trees&grass
	public static BufferedImage BigTreeCenter, treeOne,treeTwo,
	noLeavesTree,grass,grassTwo,bigRock,rockOne,rockTwo,logOne,logTwo,
	flowerOne,flowerTwo,flowerThree,chopTreeOne,chopTreeTwo,manyLogs;

	public static BufferedImage bigPond;
	
	//Ground Tiles
	
	public static BufferedImage grassTile,sandTile,sandUpperTileLeft,sandUpperTileRight,
	sandBottomTileLeft,sandTileBottomRight;
	
	
	public static void init() {
		
		try {
				SpriteSheet sheet=new SpriteSheet(ImageLoader.loadImage("/textures/ground_tiles.png"));
			
			 //coordinates x,y and the width and height
				grassTile = sheet.crop(0, 0, tileWidth, tileHeight);
				sandTile = sheet.crop(0, tileHeight, tileWidth, tileHeight);
				
				sandUpperTileLeft= sheet.crop(tileWidth,0,tileWidth,tileHeight);
				sandUpperTileRight= sheet.crop(tileWidth*2,0,tileWidth,tileHeight);
				sandBottomTileLeft= sheet.crop(tileWidth,tileHeight,tileWidth,tileHeight);
				sandTileBottomRight= sheet.crop(tileWidth*2,tileHeight,tileWidth,tileHeight);
		}catch(Exception e) {
			System.out.println("No Image : "+e);
			e.printStackTrace();
		}
	
		
	}
}
