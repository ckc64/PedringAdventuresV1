package pedringAdventures.main.states;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import pedringAdventures.main.Handler;
import pedringAdventures.main.gfx.Animation;
import pedringAdventures.main.gfx.MiscAssets;
import pedringAdventures.main.ui.UIManager;

public class MenuState extends State {
	
	private UIManager uiManager;
	
	
	private Animation animate,startGame,loadSaveGame,quitGame,leftArrow,rightArrow;
	private Animation timerAnimation;
	private LoadingState loadState;
	private int menuXPos,menuYpos;
	private ArrayList<BufferedImage> gameMenus;
	private boolean isAtStartGame=false,isAtLoadSaveGame=false,isAtQuitGame=false;
	private int selectedItem=0;


	public MenuState(Handler handler) {
		super(handler);
		
		// TODO Auto-generated constructor stub
		animate = new Animation(2000,MiscAssets.bground);
		leftArrow=new Animation(200,MiscAssets.leftArrow);
		rightArrow=new Animation(200,MiscAssets.rightArrow);
		
		gameMenus = new ArrayList<BufferedImage>();
		for(int i=0;i<MiscAssets.gameMenusBtn.length;i++) {
			gameMenus.add(MiscAssets.gameMenusBtn[i]);
		}
		
	}
	
	
	@Override
	public void tick() {
		
		animate.tick();
		leftArrow.tick();
		rightArrow.tick();
	
		
//		uiManager.tick();
		
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_A)) {
			selectedItem--;
		}
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_D)) {
			selectedItem++;
		}
		
		if(selectedItem<0)
			selectedItem=gameMenus.size()-1;
		else if(selectedItem>=gameMenus.size())
			selectedItem=0;
			
		if(selectedItem==0) {
			isAtLoadSaveGame=false;
			isAtQuitGame=false;
			isAtStartGame=true;
		}else if(selectedItem==1) {
			isAtStartGame=false;
			isAtQuitGame=false;
			isAtLoadSaveGame=true;
		}else if(selectedItem==2) {
			isAtStartGame=false;
			isAtLoadSaveGame=false;
			isAtQuitGame=true;
		}
		
		if(handler.getKeyManager().enterKey) {
			if(isAtStartGame==true) {
				
						State.setState(handler.getGame().loadingState);

			}else if(isAtLoadSaveGame==true) {
				System.out.println("No Save Game");
			}else if(isAtQuitGame==true) {
				System.exit(0);
			}
		}
		
	}
	
	
	@Override
	public void render(Graphics g) {
		
	
		g.drawImage(animateBground(), 0,0, 750,600, null);
		g.drawImage(MiscAssets.logoPedring, 110, 100,null);
		g.drawImage(MiscAssets.pressEnterText,320,390,null);

	
			g.drawImage(animateLeftArrow(), 250, 350, null);
			g.drawImage(animateRightArrow(), 451, 350, null);
//			uiManager.render(g);
			
			int len = gameMenus.size();
			menuXPos=310;
			menuYpos=350;
			if(len==0)
				return;
			
			//slot of inventory
			for(int i=-1;i<3;i++) {
				if(selectedItem+i<0 || selectedItem+i>=len)
						continue;
				if(i==0) {
					menuXPos=310;
					if(selectedItem==1)
						menuXPos=292;
					if(selectedItem==2)
						menuXPos=315;
					g.drawImage(gameMenus.get(selectedItem+i), menuXPos, menuYpos, null);
				}
				
			}
	}
	
	
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
