package pedringAdventures.main.gfx;

import java.awt.image.BufferedImage;

public class Assets {
private static final int tileWidth = 64, tileHeight = 64;
private static final int charWidth=32, charHeight=32;
	
	//Main Character
	
	public static BufferedImage[] player_up, player_down, player_left, player_right,player_idle;
	public static BufferedImage samplePlayer;
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
				SpriteSheet groundTiles=new SpriteSheet(ImageLoader.loadImage("/textures/ground_tiles.png"));
				SpriteSheet player=new SpriteSheet(ImageLoader.loadImage("/textures/pedring.png"));
			 //coordinates x,y and the width and height
				grassTile = groundTiles.crop(0, 0, tileWidth, tileHeight);
				sandTile = groundTiles.crop(0, tileHeight, tileWidth, tileHeight);
				
				sandUpperTileLeft= groundTiles.crop(tileWidth,0,tileWidth,tileHeight);
				sandUpperTileRight= groundTiles.crop(tileWidth*2,0,tileWidth,tileHeight);
				sandBottomTileLeft= groundTiles.crop(tileWidth,tileHeight,tileWidth,tileHeight);
				sandTileBottomRight= groundTiles.crop(tileWidth*2,tileHeight,tileWidth,tileHeight);
				
				//player
				samplePlayer = player.crop(0, 0, charWidth, charHeight);
				
				player_idle = new BufferedImage[3];
				player_up = new BufferedImage[3];
				player_down = new BufferedImage[3];
				player_left = new BufferedImage[3];
				player_right = new BufferedImage[3];
				
				player_down[0]=player.crop(0, 0, charWidth, charHeight);
				player_down[1]=player.crop(charWidth, 0, charWidth, charHeight);
				player_down[2]=player.crop(charWidth*2, 0, charWidth, charHeight);

				player_left[0]=player.crop(0, charHeight, charWidth, charHeight);
				player_left[1]=player.crop(charWidth, charHeight, charWidth, charHeight);
				player_left[2]=player.crop(charWidth*2, charHeight, charHeight, charHeight);
				
				player_right[0]=player.crop(0, charHeight*2, charWidth, charHeight);
				player_right[1]=player.crop(charWidth, charHeight*2, charWidth, charHeight);
				player_right[2]=player.crop(charWidth*2, charHeight*2, charHeight, charHeight);
				
				player_up[0]=player.crop(0, charHeight*3, charWidth, charHeight);
				player_up[1]=player.crop(charWidth, charHeight*3, charWidth, charHeight);
				player_up[2]=player.crop(charWidth*2, charHeight*3, charWidth, charHeight);
				
				player_idle[0]=player.crop(0, charHeight*4, charWidth, charHeight);
				player_idle[1]=player.crop(charWidth, charHeight*4, charWidth, charHeight);
				player_idle[2]=player.crop(charWidth*2, charHeight*4, charWidth, charHeight);
				
		}catch(Exception e) {
			System.out.println("No Image : "+e);
			e.printStackTrace();
		}
	
		
	}
}
