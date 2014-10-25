package SinglePlayer;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageSheet {
	
	String ref = null;
	int coloms, rows;
	int width, height;
	Image bigImg = null;
	
	public ImageSheet(String ref, int rows, int coloms, int width, int height){
		this.ref = ref;
		this.rows = rows;
		this.width = width;
		this.height = height;
		this.coloms = coloms;
		
		try{
			bigImg = ImageIO.read(new File(ref));
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public BufferedImage getBufferedImage(int getX, int getY){
		BufferedImage img = ((BufferedImage) bigImg).getSubimage(getX, getY, width, height);
		return img;
	}
	
	public Image getImage(int getX, int getY){
		BufferedImage img = ((BufferedImage) bigImg).getSubimage(getX, getY, width, height);
		return img;
	}
	
	public Image getImageSize(int getX, int getY, int gWidth, int gHeight){
		BufferedImage img = ((BufferedImage) bigImg).getSubimage(getX, getY, gWidth, gHeight);
		return img;
	}
	
	public void drawScaledImage(Graphics g, int getX, int getY, int newW, int newH, int drawX, int drawY){
        Image img = getImage(getX, getY);
		Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(img, drawX, drawY, newW, newH, null);
    }
	
	public void drawImage(Graphics g, int getX, int getY, int drawX, int drawY){
		BufferedImage img = ((BufferedImage) bigImg).getSubimage(getX, getY, width, height);
		g.drawImage(img, drawX, drawY, null);
	}
	
	public void draw(Graphics g, int drawX, int drawY, int getX, int getY, int w, int h){
		BufferedImage img = ((BufferedImage) bigImg).getSubimage(getX, getY, w, h);
		g.drawImage(img, drawX, drawY, null);
	}

}
