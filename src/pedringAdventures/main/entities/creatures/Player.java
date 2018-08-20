package pedringAdventures.main.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import pedringAdventures.main.Handler;
import pedringAdventures.main.entities.Entity;
import pedringAdventures.main.gfx.Animation;
import pedringAdventures.main.gfx.Assets;
import pedringAdventures.main.inventory.Inventory;

public class Player extends Creature {
 
	//Animation
	private Animation animIdle,animUp,animDown,animLeft,animRight;
	//attacktimer
	private long lastAttackTimer,attackCooldown=500,attackTimer=attackCooldown;
	
	//inventory
	private Inventory inventory;
	
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
		
		inventory = new Inventory(handler);
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
		
		//attack
		checkAttacks();
		//inventory
		inventory.tick();
	}
	private void checkAttacks() {
		attackTimer+=System.currentTimeMillis()-lastAttackTimer;
		lastAttackTimer=System.currentTimeMillis();
		if(attackTimer<attackCooldown)
			return;
		
		if(inventory.isActive())
			return;
		System.out.println("Attack : "+attackTimer);
		
		Rectangle cb = getCollisionBounds(0, 0);
		Rectangle ar = new Rectangle();
		int arSize=20;
		
		ar.width = arSize;
		ar.height = arSize;
		
		if(handler.getKeyManager().attackKey) {
			if(handler.getKeyManager().up) {
				ar.x=cb.x+cb.width/2-arSize/2;
				ar.y=cb.y-arSize;
			}else if(handler.getKeyManager().down) {
				ar.x=cb.x+cb.width/2-arSize/2;
				ar.y=cb.y-cb.height;
			}else if(handler.getKeyManager().left) {
				ar.x=cb.x-arSize;
				ar.y=cb.y+cb.height/2-arSize/2;
			}else if(handler.getKeyManager().right) {
				ar.x=cb.x+cb.width;
				ar.y=cb.y+cb.height/2-arSize/2;
			}else {
				return;
			}
			
			attackTimer=0;
			for(Entity e : handler.getWorld().getEntityManager().getEntities()) {
				if(e.equals(this))
					continue;
				if(e.getCollisionBounds(0, 0).intersects(ar))
					e.hurt(1);
			}
			
		}
		
	}
	
	@Override
	public void die() {
		System.out.println("You lose");
	}
	private void getInput() {
		xMove=0;
		yMove=0;
		
		if(inventory.isActive())
				return;
		
		if(handler.getKeyManager().up)
			yMove= -speed;
		if(handler.getKeyManager().down)
			yMove= +speed;
		if(handler.getKeyManager().left)
			xMove= -speed;
		if(handler.getKeyManager().right)
			xMove= +speed;
		
		System.out.println("X Position : "+(int)getX());
		System.out.println("Y Position : "+(int)getY());
	}
	
	@Override
	public void render(Graphics g) {
				g.drawImage(getCurrentAnimationFrame(), (int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()), width,height,null);
//				g.setColor(Color.red);
//				g.fillRect((int)(x+bounds.x - handler.getGameCamera().getxOffset()), (int)(y+bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
				
	}
	
	public void postRender(Graphics g) {
		inventory.render(g);
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

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	

}
