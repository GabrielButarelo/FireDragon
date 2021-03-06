package me.playdev.firedragon.system;

import java.awt.Graphics2D;
import java.util.Stack;

import me.playdev.firedragon.world.LevelLoader;

public class GameStateManager {

	public static Stack<GameState> states;
	
	public GameStateManager() {
		states = new Stack<GameState>();
		states.push(new LevelLoader(this));
	}
	
	public void init(){
		states.peek().init();
	}
	
	public void tick(double deltaTime){
		states.peek().tick(deltaTime);
	}
	
	public void render(Graphics2D g){
		states.peek().render(g);
	}
	
}
