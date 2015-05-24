package me.playdev.firedragon.world;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import me.playdev.firedragon.Vector2;

public class Block extends Rectangle{

	private static final long serialVersionUID = 1L;
	public Vector2 pos = new Vector2();
	private int blockSize = 32;
	public BlockType blockType;
	private BufferedImage block;
	private boolean isSolid;
	
	public Block(Vector2 pos, BlockType blockType) {
		setBounds((int) pos.xPos, (int) pos.yPos, blockSize, blockSize);
		this.pos = pos;
		this.blockType = blockType;
		init();
	}
	
	public void init(){
		switch (blockType) {
		case STONE_1:
			block = Assets.getStone_1();
			break;
		case GRASS_1:
			block = Assets.getGrass_1();
			break;
		}
	}
	
	public void tick(double deltaTime){
	}
	
	public void render(Graphics2D g){
		g.drawImage(block, (int)pos.getWorldLocation().xPos, (int)pos.getWorldLocation().yPos, blockSize, blockSize, null);
		if(isSolid){
			g.setColor(Color.BLUE);
			g.drawRect((int)pos.getWorldLocation().xPos, (int)pos.getWorldLocation().yPos, blockSize, blockSize);
		}
	}

	public Block isSolid(boolean isSolid){
		this.isSolid = isSolid;
		return this;
	}
	
	public boolean isSolid() {
		return isSolid;
	}
	
}
