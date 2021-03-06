package me.playdev.firedragon.world;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class TileManager {

	public static ArrayList<Block> blocks = new ArrayList<Block>();
	
	public void init(){
		for(Block block : blocks){
			block.init();
		}
	}
	
	public void tick(double deltaTime){
		for(Block block : blocks){
			block.tick(deltaTime);
		}
	}
	
	public void render(Graphics2D g){
		for(Block block : blocks){
			block.render(g);
		}
	}

}
