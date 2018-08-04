package pedringAdventures.main.entities.creatures;

import pedringAdventures.main.entities.Entity;

public abstract class Creature extends Entity {

	protected int health;
	
	public Creature(float x, float y) {
		super(x, y);
		health=10;
	}
	
	
	
}
