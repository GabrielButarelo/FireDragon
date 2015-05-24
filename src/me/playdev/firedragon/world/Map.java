package me.playdev.firedragon.world;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import me.playdev.firedragon.Vector2;
import me.playdev.firedragon.entity.Player;
import me.playdev.firedragon.images.LoadImage;

public class Map {

	public TileManager tiles = new TileManager();
	public Player player = new Player();
	
	public void init(){
		try{
			player.init();
			BufferedImage map;
			map = LoadImage.loadImage(LoadImage.class, "map1.png");
			for(int x = 0; x < 100; x++){
				for(int y = 0; y < 100; y++){
					int color = map.getRGB(x, y);
					switch (color & 0xFFFFFF) {
					case 0x808080:
						TileManager.blocks.add(new Block(new Vector2(x*32,y*32), BlockType.GRASS_1).isSolid(false));
						break;
					case 0x606060:
						TileManager.blocks.add(new Block(new Vector2(x*32,y*32), BlockType.STONE_1).isSolid(true));
						break;
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		tiles.init();
	}
	
	public void tick(double deltaTime) {
		tiles.tick(deltaTime);
		player.tick(deltaTime);
	}

	public void render(Graphics2D g) {
		tiles.render(g);
		player.render(g);
	}

}
