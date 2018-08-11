package pedringAdventures.main.gfx;

import java.awt.image.BufferedImage;

public class Assets {
private static final int tileWidth = 32, tileHeight = 32;
private static final int charWidth = 32, charHeight = 32;	
	//Main Character
	
	public static BufferedImage[] player_up, player_down, player_left, player_right,player_idle;
	public static BufferedImage samplePlayer;
	//houses
	public static BufferedImage main_map_house_one, main_map_house_two, main_map_house_three, main_map_house_four;
	
	//trees&grass
	public static BufferedImage BigTreeCenter, treeOne,treeTwo,
	noLeavesTree,grass,grassTwo,grassThree,bigRock,rockOne,rockTwo,rockThree,logOne,logTwo,logThree,
	flowerOne,flowerTwo,flowerThree,chopTreeOne,chopTreeTwo;

	public static BufferedImage bigPond;
	
	//Ground Tiles
	
	public static BufferedImage grassTile,sandTile,sandUpperTileLeft,sandUpperTileRight,
	sandBottomTileLeft,sandTileBottomRight,blackTile;
	
	
	public static void init() {
		
		try {
			//coordinates x,y and the width and height
				SpriteSheet groundTiles=new SpriteSheet(ImageLoader.loadImage("/textures/ground_tiles16px.png"));
				SpriteSheet player=new SpriteSheet(ImageLoader.loadImage("/textures/pedring.png"));
				SpriteSheet groundAssets= new SpriteSheet(ImageLoader.loadImage("/textures/ground_assets.png"));
				SpriteSheet map1House=new SpriteSheet(ImageLoader.loadImage("/textures/map1_house.png"));
				
				//ground assets i.e trees,rock
					treeOne=groundAssets.crop(0, 0, tileWidth, tileHeight*2);
					grass=groundAssets.crop(tileWidth*4,tileHeight*2,tileWidth,tileHeight);
					grassTwo=groundAssets.crop(tileWidth*3, tileHeight*2, tileWidth, tileHeight);
					BigTreeCenter=groundAssets.crop(tileWidth*13, 0, tileWidth*4, tileHeight*5);
					treeTwo=groundAssets.crop(tileWidth*6, tileHeight, tileWidth*2, tileHeight*2);
					logOne=groundAssets.crop(tileWidth*6, 0, tileWidth*2, tileHeight);
					logTwo=groundAssets.crop(tileWidth*4, 0, tileWidth, tileHeight*2);
					bigRock=groundAssets.crop(tileWidth, 0, tileWidth, tileHeight);
					logThree=groundAssets.crop(tileWidth*8, 0, tileWidth*2, tileHeight);
					bigPond=groundAssets.crop(0, tileHeight*3, tileWidth*7, tileHeight*6);
					noLeavesTree=groundAssets.crop(tileWidth*10, 0,tileWidth*3, tileHeight*2);
				
					rockOne=groundAssets.crop(tileWidth*2, 0, tileWidth, tileHeight);
					chopTreeOne=groundAssets.crop(tileWidth, tileHeight*2, tileWidth, tileHeight);
					chopTreeTwo=groundAssets.crop(tileWidth, tileHeight, tileWidth, tileHeight);
					flowerOne=groundAssets.crop(tileWidth*3, 0, tileWidth, tileHeight);
					grassThree=groundAssets.crop(tileWidth*5,tileHeight*2,tileWidth,tileHeight);
					flowerTwo=groundAssets.crop(tileWidth*5,0,tileWidth,tileHeight);
					flowerThree=groundAssets.crop(tileWidth*2, tileHeight, tileWidth, tileHeight);
					rockThree=groundAssets.crop(tileWidth*5,tileHeight,tileWidth,tileHeight);
				//ground tiles
				grassTile = groundTiles.crop(0, 0, tileWidth, tileHeight);
				sandTile = groundTiles.crop(0, tileHeight, tileWidth, tileHeight);
				blackTile = groundTiles.crop(tileWidth*3, 0, tileWidth, tileHeight);
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
//				
				player_idle[0]=player.crop(0, charHeight*4, charWidth, charHeight);
				player_idle[1]=player.crop(charWidth, charHeight*4, charWidth, charHeight);
				player_idle[2]=player.crop(charWidth*2, charHeight*4, charWidth, charHeight);
				
				//end player
				
				//main map houses
				
				main_map_house_one=map1House.crop(0, 0, tileWidth*8, tileHeight*7);
				main_map_house_two=map1House.crop(tileWidth*8, 0, tileWidth*10, tileHeight*8);
				main_map_house_three=map1House.crop(0, tileHeight*8, tileWidth*6, tileHeight*9);
				main_map_house_four=map1House.crop(tileWidth*7, tileHeight*8, tileWidth*9, tileHeight*9);
				//end main map houses
				
				
		}catch(Exception e) {
			System.out.println("No Image : "+e);
			e.printStackTrace();
		}
	
		
	}
}
