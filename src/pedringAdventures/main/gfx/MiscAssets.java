package pedringAdventures.main.gfx;

import java.awt.image.BufferedImage;

public class MiscAssets {
	
	private static final int width=32,height=32;
	
	public static BufferedImage pressEnterText,startGameBtn,loadSaveGameBtn,quitGameBtn[];
	public static BufferedImage [] leftArrow,rightArrow;
	public static BufferedImage [] bground,gameMenusBtn,loading;
	public static BufferedImage logoPedring;
	public static void init() {
		
		SpriteSheet gameMenus=new SpriteSheet(ImageLoader.loadImage("/bgmenus/main-menu-selection.png"));
		SpriteSheet background=new SpriteSheet(ImageLoader.loadImage("/bgmenus/bg.png"));
		SpriteSheet logo=new SpriteSheet(ImageLoader.loadImage("/bgmenus/LogoPedring.png"));
		SpriteSheet loadingGUI=new SpriteSheet(ImageLoader.loadImage("/bgmenus/loading.png"));
		
		loading = new BufferedImage[2];
		loading[0]=loadingGUI.crop(0,0,width*9,height);
		loading[1]=loadingGUI.crop(0,height,width*9,height);
		
//		startGameBtn=new BufferedImage[1];
//		loadSaveGameBtn=new BufferedImage[1];
//		quitGameBtn=new BufferedImage[1];
		gameMenusBtn = new BufferedImage[3];
		
		gameMenusBtn[0]=gameMenus.crop(0,0,width*4,height);
		gameMenusBtn[1]=gameMenus.crop(0,height,width*5,height);
		gameMenusBtn[2]=gameMenus.crop(0,height*2,width*3,height);
		
//		startGameBtn=gameMenus.crop(0,0,width*4,height);
//		loadSaveGameBtn=gameMenus.crop(0,height,width*5,height);
//		quitGameBtn[0]=gameMenus.crop(0,height*2,width*2,height);
		
		logoPedring=logo.crop(0, 0, width*15, height*7);
		
		pressEnterText=gameMenus.crop(width*5, height, width*4, height);
		
		
		
		leftArrow=new BufferedImage[2];
		rightArrow=new BufferedImage[2];
		
		leftArrow[0]=gameMenus.crop(width*5,0,width,height);
		leftArrow[1]=gameMenus.crop(width*6,0,width,height);
		
		rightArrow[0]=gameMenus.crop(width*7,0,width,height);
		rightArrow[1]=gameMenus.crop(width*8,0,width,height);
		
		bground = new BufferedImage[3];
		bground[0] = background.crop(0, 0, width*23, height*18);
		bground[1] = background.crop(width*25, 0, width*23, height*18);
		bground[2] = background.crop(width*50, 0, width*23, height*18);
	}
	
	
}
