package pedringAdventures.main.tiles;


import pedringAdventures.main.gfx.Assets;

public class GrassTile extends Tile {

	public GrassTile(int id) {
		super(Assets.grassTile, id);
	}
	
	//you can override the isSolid method if you want to be solid
}
