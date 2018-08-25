package pedringAdventures.main.ui;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import pedringAdventures.main.Handler;

public abstract class UIObjectKeyboard {
	protected float x,y;
	protected int width,height;
	protected boolean selected=false;
	protected boolean isAtStartGame=false,isAtLoadSaveGame=false,isAtQuitGame=false;
	private Handler handler;
	
	public UIObjectKeyboard(Handler handler,float x,float y) {

		this.handler=handler;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract void onPress();
	
	public void onKeyPress(KeyEvent e) {
		if(!isAtStartGame)
			selected=true;
		else if(!isAtLoadSaveGame)
			selected=true;
		else if(!isAtQuitGame)
			selected=true;
	}
	
	public void onKeyRelease(KeyEvent e) {
		if(selected) {
			onPress();
		}
			
	}

	//getters setters
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
