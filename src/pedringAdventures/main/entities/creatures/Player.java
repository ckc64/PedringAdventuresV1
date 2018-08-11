package pedringAdventures.main.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import pedringAdventures.main.Handler;
import pedringAdventures.main.gfx.Animation;
import pedringAdventures.main.gfx.Assets;

public class Player extends Creature {
 
	//Animation
	private Animation animIdle,animUp,animDown,animLeft,animRight;
	
	public Player(Handler handler,float x, float y) {
		super(handler,x, y,Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x=15;// x coordinate of a player
		bounds.y=34;//y coordinate of a player
		
		bounds.width=25;
		bounds.height=29;
		
		animIdle=new Animation(500,Assets.player_idle);
		animUp=new Animation(100,Assets.player_up);
		animDown=new Animation(100,Assets.player_down);
		animLeft=new Animation(100,Assets.player_left);
		animRight=new Animation(100,Assets.player_right);
	}

	@Override
	public void tick() {
		//animation
		animIdle.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();
		animDown.tick();
		//movement
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}
	
	private void getInput() {
		xMove=0;
		yMove=0;
		
		if(handler.getKeyManager().up)
			yMove= -speed;
		if(handler.getKeyManager().down)
			yMove= +speed;
		if(handler.getKeyManager().left)
			xMove= -speed;
		if(handler.getKeyManager().right)
			xMove= +speed;
		
		System.out.println("X Position : "+getX());
		System.out.println("Y Position : "+getY());
	}
	
	@Override
	public void render(Graphics g) {
				g.drawImage(getCurrentAnimationFrame(), (int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()), width,height,null);
//				g.setColor(Color.red);
//				g.fillRect((int)(x+bounds.x - handler.getGameCamera().getxOffset()), (int)(y+bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
	}
	
	public BufferedImage getCurrentAnimationFrame() {
		if(xMove<0) {
			return animLeft.getCurrentFrame();
		}else if(xMove>0) {
			return animRight.getCurrentFrame();
		}else if(yMove<0) {
			return animUp.getCurrentFrame();
		}else if(yMove>0) {
			return animDown.getCurrentFrame();
		}else {
			return animIdle.getCurrentFrame();
		}
	}
	

}
