package pedringAdventures.main.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	//static variables
	
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile=new GrassTile(0);
	public static Tile sandTile=new SandTile(1);
	public static Tile sandTileUpperLeft=new SandTileUpperLeft(2);
	public static Tile sandTileUpperRight=new SandTileUpperRight(3);
	public static Tile sandTileUpperBottomLeft=new SandTileBottomLeft(4);
	public static Tile sandTileBottomRight=new SandTileBottomRight(5);
	
	//class
	public static final int TILEWIDTH=64,TILEHEIGHT=64;
	
	protected BufferedImage texture;
	protected final int id;
	public Tile(BufferedImage texture,int id) {
		this.texture=texture;
		this.id=id;
		
		tiles[id]=this;
	}
	
	public void tick() {
		
	}
	public void render(Graphics g,int x,int y) {
		g.drawImage(texture, x,y, TILEWIDTH,TILEHEIGHT, null);
	}
	
	public boolean isSolid() {
		return false;
	}
	
	public int getId() {
		return id;
	}
}
