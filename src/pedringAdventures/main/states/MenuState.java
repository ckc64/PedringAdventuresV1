package pedringAdventures.main.states;

import java.awt.Graphics;
import java.awt.image.BufferedImage;


import pedringAdventures.main.Handler;
import pedringAdventures.main.gfx.Animation;
import pedringAdventures.main.gfx.MiscAssets;
import pedringAdventures.main.ui.ClickListener;
import pedringAdventures.main.ui.UIImageButton;
import pedringAdventures.main.ui.UIManager;

public class MenuState extends State {
	
	private UIManager uiManager;
	
	protected static boolean isAtStartGame=false,isAtLoadSaveGame=false,isAtQuitGame=false;;
	private Animation animate,startGame,loadSaveGame,quitGame,leftArrow,rightArrow;

	public MenuState(Handler handler) {
		super(handler);
		
		// TODO Auto-generated constructor stub
		animate = new Animation(2000,MiscAssets.bground);
		leftArrow=new Animation(200,MiscAssets.leftArrow);
		rightArrow=new Animation(200,MiscAssets.rightArrow);
		isAtStartGame=true;
		
		
		uiManager=new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		uiManager.addObject(new UIImageButton(250, 280, 128, 32, MiscAssets.gameMenusBtn, new ClickListener() {
			
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
				
			}
		}));
	}
	
	
	@Override
	public void tick() {
		animate.tick();
		leftArrow.tick();
		rightArrow.tick();
		
//		if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().isRightPressed())
//			State.setState(handler.getGame().gameState);
//		
//		if(handler.getKeyManager().enterKey) {
//			State.setState(handler.getGame().gameState);
//		}
		uiManager.tick();
	}
	
	
	@Override
	public void render(Graphics g) {
		
		
		g.drawImage(animateBground(), 0,0, 750,600, null);
		g.drawImage(MiscAssets.logoPedring, 110, 100,null);
		g.drawImage(MiscAssets.pressEnterText,320,390,null);
		
		g.drawImage(MiscAssets.startGameBtn,310,350,null);
		//g.drawImage(MiscAssets.loadSaveGameBtn,295,352,null);
			g.drawImage(animateLeftArrow(), 250, 350, null);
			g.drawImage(animateRightArrow(), 451, 350, null);
			uiManager.render(g);
	}
	
//	public void menuSelection(Graphics g) {
//		if(isAtStartGame) {
//			if(handler.getKeyManager().left) {
//				
//				handler.getKeyManager().setKeyReleasedAndPressed(true);
//				if(handler.getKeyManager().isKeyReleasedAndPressed()==true){
//					g.drawImage(MiscAssets.loadSaveGameBtn,310,350,null);
//				}
//			}
//		}
//	}
	
	public BufferedImage animateBground() {
		
			return animate.getCurrentFrame();
	}
	
	public BufferedImage animateLeftArrow() {
		return leftArrow.getCurrentFrame();
	}
	public BufferedImage animateRightArrow() {
		return rightArrow.getCurrentFrame();
	}
}
