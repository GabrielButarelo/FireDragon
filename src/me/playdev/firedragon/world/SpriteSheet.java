package me.playdev.firedragon.world;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	private BufferedImage spriteSheet;
	
	public BufferedImage getTile(int xTile, int yTile, int width, int height){
		BufferedImage sprite = spriteSheet.getSubimage(xTile, yTile, width+16, height+16);
		return sprite;
	}
	
	public void setSpriteSheet(BufferedImage spriteSheet) {
		this.spriteSheet = spriteSheet;
	}
	
}
