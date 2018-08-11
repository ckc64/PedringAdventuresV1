package pedringAdventures.main.states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import pedringAdventures.main.Handler;
import pedringAdventures.main.gfx.Animation;
import pedringAdventures.main.gfx.MiscAssets;

public class MenuState extends State {
	
	protected static boolean isAtStartGame=false,isAtLoadSaveGame=false,isAtQuitGame=false;;
	private Animation animate,startGame,loadSaveGame,quitGame,leftArrow,rightArrow;

	public MenuState(Handler handler) {
		super(handler);
		// TODO Auto-generated constructor stub
		animate = new Animation(2000,MiscAssets.bground);
		leftArrow=new Animation(200,MiscAssets.leftArrow);
		rightArrow=new Animation(200,MiscAssets.rightArrow);
	}
	
	
	@Override
	public void tick() {
		animate.tick();
		leftArrow.tick();
		rightArrow.tick();
		if(handler.getKeyManager().enterKey) {
			State.setState(handler.getGame().gameState);
		}
	}
	
	
	@Override
	public void render(Graphics g) {
		
		
		g.drawImage(animateBground(), 0,0, 750,600, null);
		g.drawImage(MiscAssets.logoPedring, 110, 100,null);
		g.drawImage(MiscAssets.pressEnterText,320,390,null);
			g.drawImage(MiscAssets.startGameBtn,310,350,null);
			
			g.drawImage(animateLeftArrow(), 280, 350, null);
			g.drawImage(animateRightArrow(), 421, 350, null);
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
