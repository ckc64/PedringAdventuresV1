package pedringAdventures.main.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import pedringAdventures.main.entities.EntityManager;

public class KeyManager implements KeyListener {

	private boolean []keys,justPressed,cantPress;
	


	public boolean up,down,left,right,enterKey,escKey
	,attackKey,isKeyReleasedAndPressed=true;
	private EntityManager entityManager;
	public boolean upIsPressed,downIsPressed;
	
	public KeyManager() {
		keys=new boolean[256];
		justPressed=new boolean[keys.length];
		cantPress=new boolean[keys.length];
	}
	
	public void tick() {
		
		for(int i=0;i<keys.length;i++) {
			if(cantPress[i] &&  !keys[i]) {
				cantPress[i]=false;
			}else if(justPressed[i]) {
				cantPress[i]=true;
				justPressed[i]=false;
			}
			if(!cantPress[i] && keys[i]) {
				justPressed[i]=true;
			}
		}
		
		up=keys[KeyEvent.VK_W];
		down=keys[KeyEvent.VK_S];
		left=keys[KeyEvent.VK_A];
		right=keys[KeyEvent.VK_D];
		enterKey=keys[KeyEvent.VK_ENTER];
		escKey=keys[KeyEvent.VK_ESCAPE];
		
		attackKey=keys[KeyEvent.VK_I];
	}
	
	
	public boolean keyJustPressed(int keyCode) {
		if(keyCode < 0 || keyCode >= keys.length) return false;
		return justPressed[keyCode];
	}

	public boolean[] getKeys() {
		return keys;
	}


	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode()>=keys.length)
			return;
		keys[e.getKeyCode()]= true;
	
	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode()>=keys.length)
			return;
		keys[e.getKeyCode()]= !isKeyReleasedAndPressed;
	}
	


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public boolean isUpIsPressed() {
		return upIsPressed;
	}

	public void setUpIsPressed(boolean upIsPressed) {
		this.upIsPressed = upIsPressed;
	}

	public boolean isDownIsPressed() {
		return downIsPressed;
	}

	public void setDownIsPressed(boolean downIsPressed) {
		this.downIsPressed = downIsPressed;
	}

}
