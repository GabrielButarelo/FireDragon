package me.playdev.firedragon.world;

import java.awt.image.BufferedImage;

import me.playdev.firedragon.images.LoadImage;

public class Assets {

	private SpriteSheet blocks = new SpriteSheet();
	public static BufferedImage stone_1, grass_1;
	
	public void init(){
		blocks.setSpriteSheet(LoadImage.loadImage(LoadImage.class, "spritesheet.png"));
		grass_1 = blocks.getTile(0, 0, 16, 16);
		stone_1 = blocks.getTile(32, 0, 16, 16);
	}

	public static BufferedImage getStone_1() {
		return stone_1;
	}
	
	public static BufferedImage getGrass_1() {
		return grass_1;
	}
}
