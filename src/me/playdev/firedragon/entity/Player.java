package me.playdev.firedragon.entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import me.playdev.firedragon.Check;
import me.playdev.firedragon.FireDragon;
import me.playdev.firedragon.Vector2;
import me.playdev.firedragon.system.Game;
import me.playdev.firedragon.system.GameLoop;
import me.playdev.firedragon.world.Block;
import me.playdev.firedragon.world.TileManager;

public class Player implements KeyListener {

	//Player Variables
	public Vector2 pos;
	public int width = 42;
	public int height = 42;
	
	//Player Movement
	private static boolean up, down, left, right;
	private float speedUp = 0;
	private float speedDown = 0;
	private float speedLeft = 0;
	private float speedRight = 0;
	private float maxSpeed = 3*32F;
	private float slowMove = 4.093F;
	private float fixDeltaTime = 1F/60F;
	private boolean mapMove = false;
	
	private double deltaTimeDS;
	
	//Constructor
	public Player() {
		pos = new Vector2(FireDragon.width / 2 - width /2, FireDragon.height / 2 - height /2);
	}
	
	//Game Loop Methods
	public void init() {}

	public void tick(double deltaTime) {
		deltaTimeDS = deltaTime;
		if(!mapMove){
			playerMove();
		}else{
			mapMove();
		}
	}

	public void render(Graphics2D g) {
		debugScreen(g);
		g.fillRect((int) pos.xPos, (int) pos.yPos, width, height);
	}

	//Player Movement
	private void playerMove(){
		float moveAmountUp = (float) (speedUp*fixDeltaTime);
		float moveAmountDown = (float) (speedDown*fixDeltaTime);
		float moveAmountLeft = (float) (speedLeft*fixDeltaTime);
		float moveAmountRight = (float) (speedRight*fixDeltaTime);
		
		if(up){
			if(!Check.collisionPlayerBlock(new Point((int)(pos.xPos + Game.map.xPos),(int)(pos.yPos + Game.map.yPos - moveAmountUp)), new Point((int)(pos.xPos + Game.map.xPos + width) ,(int)(pos.yPos + Game.map.yPos - moveAmountUp)))){
				if(speedUp < maxSpeed){
					speedUp += slowMove;
				}else{
					speedUp = maxSpeed;
				}
				pos.yPos -= moveAmountUp;
			}else{
				speedUp = 0;
			}
		}else{
			if(!Check.collisionPlayerBlock(new Point((int)(pos.xPos + Game.map.xPos),(int)(pos.yPos + Game.map.yPos - moveAmountUp)), new Point((int)(pos.xPos + Game.map.xPos + width) ,(int)(pos.yPos + Game.map.yPos - moveAmountUp)))){
				if(speedUp != 0){
					speedUp -= slowMove;
					if(speedUp < 0){
						speedUp = 0;
					}
				}
				pos.yPos -= moveAmountUp;
			}else{
				speedUp = 0;
			}
		}
		if(down){
			if(!Check.collisionPlayerBlock(new Point((int)(pos.xPos + Game.map.xPos),(int)(pos.yPos + Game.map.yPos + height + moveAmountDown)), new Point((int)(pos.xPos + Game.map.xPos + width) ,(int)(pos.yPos + Game.map.yPos + height + moveAmountDown)))){
				if(speedDown < maxSpeed){
					speedDown += slowMove;
				}else{
					speedDown = maxSpeed;
				}
				pos.yPos += moveAmountDown;
			}else{
				speedDown = 0;
			}
		}else{
			if(!Check.collisionPlayerBlock(new Point((int)(pos.xPos + Game.map.xPos),(int)(pos.yPos + Game.map.yPos + height + moveAmountDown)), new Point((int)(pos.xPos + Game.map.xPos + width) ,(int)(pos.yPos + Game.map.yPos + height + moveAmountDown)))){
				if(speedDown != 0){
					speedDown -= slowMove;
					if(speedDown < 0){
						speedDown = 0;
					}
				}
				pos.yPos += moveAmountDown;
			}else{
				speedDown = 0;
			}
		}
		if(left){
			if(!Check.collisionPlayerBlock(new Point((int)(pos.xPos + Game.map.xPos - moveAmountLeft),(int)(pos.yPos + Game.map.yPos + height)), new Point((int)(pos.xPos + Game.map.xPos - moveAmountLeft) ,(int)(pos.yPos + Game.map.yPos + height)))){
				if(speedLeft < maxSpeed){
					speedLeft += slowMove;
				}else{
					speedLeft = maxSpeed;
				}
				pos.xPos -= moveAmountLeft;
			}else{
				speedLeft = 0;
			}
		}else{
			if(!Check.collisionPlayerBlock(new Point((int)(pos.xPos + Game.map.xPos - moveAmountLeft),(int)(pos.yPos + Game.map.yPos + height)), new Point((int)(pos.xPos + Game.map.xPos - moveAmountLeft) ,(int)(pos.yPos + Game.map.yPos + height)))){
				if(speedLeft != 0){
					speedLeft -= slowMove;
					if(speedLeft < 0){
						speedLeft = 0;
					}
				}
				pos.xPos -= moveAmountLeft;
			}else{
				speedLeft = 0;
			}
		}
		if(right){
			if(!Check.collisionPlayerBlock(new Point((int)(pos.xPos + Game.map.xPos + width + 2 + moveAmountLeft),(int)(pos.yPos + Game.map.yPos)), new Point((int)(pos.xPos + Game.map.xPos + width + 2 + moveAmountLeft) ,(int)(pos.yPos + Game.map.yPos + height)))){
				if(speedRight < maxSpeed){
					speedRight += slowMove;
				}else{
					speedRight = maxSpeed;
				}
				pos.xPos += moveAmountRight;
			}else{
				speedRight = 0;
			}
		}else{
			if(!Check.collisionPlayerBlock(new Point((int)(pos.xPos + Game.map.xPos + width + 2 + moveAmountLeft),(int)(pos.yPos + Game.map.yPos)), new Point((int)(pos.xPos + Game.map.xPos + width + 2 + moveAmountLeft) ,(int)(pos.yPos + Game.map.yPos + height)))){
				if(speedRight != 0){
					speedRight -= slowMove;
					if(speedRight < 0){
						speedRight = 0;
					}
				}
				pos.xPos += moveAmountRight;
			}else{
				speedRight = 0;
			}
		}
	}
	private void mapMove(){
		float moveAmountUp = (float) (speedUp*fixDeltaTime);
		float moveAmountDown = (float) (speedDown*fixDeltaTime);
		float moveAmountLeft = (float) (speedLeft*fixDeltaTime);
		float moveAmountRight = (float) (speedRight*fixDeltaTime);
		
		if(up){
			if(!Check.collisionPlayerBlock(new Point((int)(pos.xPos + Game.map.xPos),(int)(pos.yPos + Game.map.yPos - moveAmountUp)), new Point((int)(pos.xPos + Game.map.xPos + width) ,(int)(pos.yPos + Game.map.yPos - moveAmountUp)))){
				if(speedUp < maxSpeed){
					speedUp += slowMove;
				}else{
					speedUp = maxSpeed;
				}
				Game.map.yPos -= moveAmountUp;
			}else{
				speedUp = 0;
			}
		}else{
			if(!Check.collisionPlayerBlock(new Point((int)(pos.xPos + Game.map.xPos),(int)(pos.yPos + Game.map.yPos - moveAmountUp)), new Point((int)(pos.xPos + Game.map.xPos + width) ,(int)(pos.yPos + Game.map.yPos - moveAmountUp)))){
				if(speedUp != 0){
					speedUp -= slowMove;
					if(speedUp < 0){
						speedUp = 0;
					}
				}
				Game.map.yPos -= moveAmountUp;
			}else{
				speedUp = 0;
			}
		}
		
		if(down){
			if(!Check.collisionPlayerBlock(new Point((int)(pos.xPos + Game.map.xPos),(int)(pos.yPos + Game.map.yPos + height + moveAmountDown)), new Point((int)(pos.xPos + Game.map.xPos + width) ,(int)(pos.yPos + Game.map.yPos + height + moveAmountDown)))){
				if(speedDown < maxSpeed){
					speedDown += slowMove;
				}else{
					speedDown = maxSpeed;
				}
				Game.map.yPos += moveAmountDown;
			}else{
				speedDown = 0;
			}
		}else{
			if(!Check.collisionPlayerBlock(new Point((int)(pos.xPos + Game.map.xPos),(int)(pos.yPos + Game.map.yPos + height + moveAmountDown)), new Point((int)(pos.xPos + Game.map.xPos + width) ,(int)(pos.yPos + Game.map.yPos + height + moveAmountDown)))){
				if(speedDown != 0){
					speedDown -= slowMove;
					if(speedDown < 0){
						speedDown = 0;
					}
				}
				Game.map.yPos += moveAmountDown;
			}else{
				speedDown = 0;
			}
		}
		
		if(left){
			if(!Check.collisionPlayerBlock(new Point((int)(pos.xPos + Game.map.xPos - moveAmountLeft),(int)(pos.yPos + Game.map.yPos + height)), new Point((int)(pos.xPos + Game.map.xPos - moveAmountLeft) ,(int)(pos.yPos + Game.map.yPos + height)))){
				if(speedLeft < maxSpeed){
					speedLeft += slowMove;
				}else{
					speedLeft = maxSpeed;
				}
				Game.map.xPos -= moveAmountLeft;
			}else{
				speedLeft = 0;
			}
		}else{
			if(!Check.collisionPlayerBlock(new Point((int)(pos.xPos + Game.map.xPos - moveAmountLeft),(int)(pos.yPos + Game.map.yPos + height)), new Point((int)(pos.xPos + Game.map.xPos - moveAmountLeft) ,(int)(pos.yPos + Game.map.yPos + height)))){
				if(speedLeft != 0){
					speedLeft -= slowMove;
					if(speedLeft < 0){
						speedLeft = 0;
					}
				}
				Game.map.xPos -= moveAmountLeft;
			}else{
				speedLeft = 0;
			}
		}
		
		if(right){
			if(!Check.collisionPlayerBlock(new Point((int)(pos.xPos + Game.map.xPos + width + 2 + moveAmountLeft),(int)(pos.yPos + Game.map.yPos)), new Point((int)(pos.xPos + Game.map.xPos + width + 2 + moveAmountLeft) ,(int)(pos.yPos + Game.map.yPos + height)))){
				if(speedRight < maxSpeed){
					speedRight += slowMove;
				}else{
					speedRight = maxSpeed;
				}
				Game.map.xPos += moveAmountRight;
			}else{
				speedRight = 0;
			}
		}else{
			if(!Check.collisionPlayerBlock(new Point((int)(pos.xPos + Game.map.xPos + width + 2 + moveAmountLeft),(int)(pos.yPos + Game.map.yPos)), new Point((int)(pos.xPos + Game.map.xPos + width + 2 + moveAmountLeft) ,(int)(pos.yPos + Game.map.yPos + height)))){
				if(speedRight != 0){
					speedRight -= slowMove;
					if(speedRight < 0){
						speedRight = 0;
					}
				}
				Game.map.xPos += moveAmountRight;
			}else{
				speedRight = 0;
			}
		}
	}
	
	//Key Events
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_W){
			up = true;
		}
		if(key == KeyEvent.VK_S){
			down = true;
		}
		if(key == KeyEvent.VK_A){
			left = true;
		}
		if(key == KeyEvent.VK_D){
			right = true;
		}
		
		if(key == KeyEvent.VK_F3){
			if(GameLoop.debugScreenVisible == false){
				GameLoop.debugScreenVisible = true;
			}else if(GameLoop.debugScreenVisible == true){
				GameLoop.debugScreenVisible = false;
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_W){
			up = false;
		}
		if(key == KeyEvent.VK_S){
			down = false;
		}
		if(key == KeyEvent.VK_A){
			left = false;
		}
		if(key == KeyEvent.VK_D){
			right = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	//Debug Screen
	@SuppressWarnings("static-access")
	private void debugScreen(Graphics2D g){
		if(GameLoop.debugScreenVisible){
			g.setColor(Color.black);
			g.setFont(FireDragon.debugTitleFont);
			g.drawString("Game Debug", 10, 20);
			g.setFont(FireDragon.debugParameterFont);
			g.drawString("Map Move: " + mapMove, 10, 20*2);
			g.drawString("Map X Pos: " + pos.worldXPos + " | " + (int) pos.worldXPos, 10, 20*3);
			g.drawString("Map Y Pos: " + pos.worldYPos+ " | " + (int) pos.worldYPos, 10, 20*4);
			g.drawString("Player X Pos: " + pos.xPos + " | " + (int) pos.xPos, 10, 20*5);
			g.drawString("Player Y Pos: " + pos.yPos+ " | " + (int) pos.yPos, 10, 20*6);
			g.drawString("FPS: " + GameLoop.getFps(), 10, 20*7);
			g.drawString("TICK: " + GameLoop.getTps(), 10, 20*8);
			g.drawString("Blocks Renderized: " + TileManager.blocks.size(), 10, 20*9);
			int blocksSolids = 0;
			int blocksNotSolids = 0;
			for(Block b : TileManager.blocks){
				if(b.isSolid()){
					blocksSolids++;
				}else{
					blocksNotSolids++;
				}
			}
			g.drawString("Solid Blocks: " + blocksSolids, 10, 20*10);
			g.drawString("Not Solid Blocks: " + blocksNotSolids, 10, 20*11);
			g.drawString("Delta Time: " + deltaTimeDS, 10, 20*12);
		}
	}
	
}
