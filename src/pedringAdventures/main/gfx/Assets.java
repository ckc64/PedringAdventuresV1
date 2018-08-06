package pedringAdventures.main.gfx;

import java.awt.image.BufferedImage;

public class Assets {
private static final int tileWidth = 32, tileHeight = 32;
	
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
			//coordinates x,y and the width and height
				SpriteSheet groundTiles=new SpriteSheet(ImageLoader.loadImage("/textures/ground_tiles16px.png"));
				SpriteSheet player=new SpriteSheet(ImageLoader.loadImage("/textures/pedring.png"));
				SpriteSheet groundAssets= new SpriteSheet(ImageLoader.loadImage("/textures/ground_assets.png"));
			
				//ground assets i.e trees,rock
				treeOne=groundAssets.crop(0, 0, tileWidth, tileHeight+tileHeight);
				grass=groundAssets.crop(tileWidth*4,tileHeight*2,tileWidth,tileHeight);
				//ground tiles
				grassTile = groundTiles.crop(0, 0, tileWidth, tileHeight);
				sandTile = groundTiles.crop(0, tileHeight, tileWidth, tileHeight);
				
				sandUpperTileLeft= groundTiles.crop(tileWidth,0,tileWidth,tileHeight);
				sandUpperTileRight= groundTiles.crop(tileWidth*2,0,tileWidth,tileHeight);
				sandBottomTileLeft= groundTiles.crop(tileWidth,tileHeight,tileWidth,tileHeight);
				sandTileBottomRight= groundTiles.crop(tileWidth*2,tileHeight,tileWidth,tileHeight);
				
				//player
				samplePlayer = player.crop(0, 0, tileWidth, tileHeight);
				
				player_idle = new BufferedImage[3];
				player_up = new BufferedImage[3];
				player_down = new BufferedImage[3];
				player_left = new BufferedImage[3];
				player_right = new BufferedImage[3];
				
				player_down[0]=player.crop(0, 0, tileWidth, tileHeight);
				player_down[1]=player.crop(tileWidth, 0, tileWidth, tileHeight);
				player_down[2]=player.crop(tileWidth*2, 0, tileWidth, tileHeight);

				player_left[0]=player.crop(0, tileHeight, tileWidth, tileHeight);
				player_left[1]=player.crop(tileWidth, tileHeight, tileWidth, tileHeight);
				player_left[2]=player.crop(tileWidth*2, tileHeight, tileHeight, tileHeight);
				
				player_right[0]=player.crop(0, tileHeight*2, tileWidth, tileHeight);
				player_right[1]=player.crop(tileWidth, tileHeight*2, tileWidth, tileHeight);
				player_right[2]=player.crop(tileWidth*2, tileHeight*2, tileHeight, tileHeight);
				
				player_up[0]=player.crop(0, tileHeight*3, tileWidth, tileHeight);
				player_up[1]=player.crop(tileWidth, tileHeight*3, tileWidth, tileHeight);
				player_up[2]=player.crop(tileWidth*2, tileHeight*3, tileWidth, tileHeight);
				
				player_idle[0]=player.crop(0, tileHeight*4, tileWidth, tileHeight);
				player_idle[1]=player.crop(tileWidth, tileHeight*4, tileWidth, tileHeight);
				player_idle[2]=player.crop(tileWidth*2, tileHeight*4, tileWidth, tileHeight);
				
		}catch(Exception e) {
			System.out.println("No Image : "+e);
			e.printStackTrace();
		}
	
		
	}
}
