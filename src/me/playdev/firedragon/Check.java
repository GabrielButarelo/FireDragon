package me.playdev.firedragon;

import java.awt.Point;

import me.playdev.firedragon.world.Block;
import me.playdev.firedragon.world.TileManager;

public class Check {

	public static boolean collisionPlayerBlock(Point p1, Point p2){
		for(Block block : TileManager.blocks){
			if(block.isSolid()){
				if(block.contains(p1) || block.contains(p2)){
					return true;
				}
			}
		}
		return false;
	}
	
}
