package pedringAdventures.main.ui;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import pedringAdventures.main.Handler;

public class UIManagerKeyBoard {
	
	private Handler handler;
	private ArrayList<UIObjectKeyboard> objects;
	
	public UIManagerKeyBoard(Handler handler) {
		this.handler=handler;
		objects = new ArrayList<UIObjectKeyboard>();
	}
	
	public void tick() {
		for(UIObjectKeyboard o : objects) {
			o.tick();
		}
	}
	
	public void render(Graphics g) {
		for(UIObjectKeyboard o : objects) {
			o.render(g);
		}
	}
	public void onKeyRelease(KeyEvent e) {
		for(UIObjectKeyboard o : objects) {
			o.onKeyRelease(e);
		}
	}
	
	public void addObject(UIObjectKeyboard o) {
		objects.add(o);
	}
	public void removeObject(UIObjectKeyboard o) {
		objects.remove(o);
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ArrayList<UIObjectKeyboard> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<UIObjectKeyboard> objects) {
		this.objects = objects;
	}
}
