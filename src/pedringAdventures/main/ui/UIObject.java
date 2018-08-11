package pedringAdventures.main.ui;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import pedringAdventures.main.input.KeyManager;

public abstract class UIObject {
	
	protected float x,y;
	protected int width,height;
	protected boolean back=false,forward=false,selected=false;
	private KeyManager keyManager;
	
	public UIObject(float x,float y, int width,int height) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract void onPressed();
	public void onKeypressed(KeyEvent e) {
		if(keyManager.left) {
			back=true;
		}else if(keyManager.right) {
			forward=true;
		}else if(keyManager.enterKey) {
			selected=true;
		}else {
			return;
		}
	}
	
	public void onKeyReleased(KeyEvent e) {
		if(selected)
			onPressed();
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

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
}
