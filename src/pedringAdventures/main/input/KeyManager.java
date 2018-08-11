package pedringAdventures.main.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import pedringAdventures.main.entities.EntityManager;
import pedringAdventures.main.entities.creatures.Player;

public class KeyManager implements KeyListener {

	private boolean []keys,isKeyReleased;
	public boolean up,down,left,right,enterKey,escKey;
	private EntityManager entityManager;
	
	public KeyManager() {
		keys=new boolean[256];
	}
	
	public void tick() {
		up=keys[KeyEvent.VK_W];
		down=keys[KeyEvent.VK_S];
		left=keys[KeyEvent.VK_A];
		right=keys[KeyEvent.VK_D];
		enterKey=keys[KeyEvent.VK_ENTER];
		escKey=keys[KeyEvent.VK_ESCAPE];
		
	}
	
	public boolean[] getKeys() {
		return keys;
	}


	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()]= true;
		System.out.println("Pressed");
	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()]= false;
	}
	
	public boolean isReleased(int keyCode) {
		return isKeyReleased[keyCode]=true;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
