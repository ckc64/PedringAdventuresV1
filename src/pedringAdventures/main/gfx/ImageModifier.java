package pedringAdventures.main.gfx;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class ImageModifier {
	
	public static float opacity=1;
	
	public static BufferedImage fadeImage(BufferedImage originalImage,int x,int y,int width,int height,int type,float rate) {
		BufferedImage newImage = null;
		while(opacity<=1) {
			opacity *=rate;
			newImage = new BufferedImage(width,height,type);
			Graphics2D g2d = newImage.createGraphics();
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,opacity));
			g2d.drawImage(originalImage,x,y,width,height,null);
			g2d.dispose();
			return newImage;
			
		}
		return newImage;
		
	}
}
