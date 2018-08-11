package pedringAdventures.main.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import pedringAdventures.main.gfx.MiscAssets;

public class UIImageButton extends UIObject {
	
	private BufferedImage image;
	private KeyListener pressed;
	
	public UIImageButton(float x, float y, int width, int height, 
			BufferedImage image, KeyListener pressed) {
		super(x, y, width, height);
		this.image=image;
		this.pressed=pressed;
	}

	@Override
	public void tick() {
	}

//	@Override
//	public void render(Graphics g) {
//		if(back) {
//			g.drawImage(MiscAssets.quitGameBtn, 150, 150, null);
//		}else if(forward){
//			g.drawImage(MiscAssets.quitGameBtn, 150, 150, null);
//		}else if(selected) {
//			
//		}
//	}

	@Override
	public void onPressed() {
		// TODO Auto-generated method stub
		pressed.OnPressed();
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
