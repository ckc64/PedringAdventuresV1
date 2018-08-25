package pedringAdventures.main.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import pedringAdventures.main.Handler;

public class UIImageButtonKeyboard extends UIObjectKeyboard {
	
	
	private BufferedImage [] images;
	private KeyListener press;
	private Handler handler;
	public UIImageButtonKeyboard(Handler handler,float x, float y,
			BufferedImage [] images, KeyListener press) {
		super(handler,x, y);
		this.images=images;
		this.press=press;
		this.handler=handler;
	
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		if(selected) {
			if(!isAtStartGame) {
				g.drawImage(images[0], (int)x, (int)y, null);
			}else if(!isAtLoadSaveGame) {
				g.drawImage(images[1], (int)x, (int)y, null);
			}else if(!isAtQuitGame) {
				g.drawImage(images[2], (int)x, (int)y, null);
			}
				
			
//			if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_W)) {
//				g.drawImage(images[0], (int)x, (int)y, null);
//			}else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_S)){
//				g.drawImage(images[1], (int)x, (int)y, null);
//			}
		}
		
	}

	@Override
	public void onPress() {
		// TODO Auto-generated method stub
		
	}
	
	
}
