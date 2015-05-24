package me.playdev.firedragon.system;

import me.playdev.firedragon.Vector2;
import me.playdev.firedragon.world.Assets;

public class Game extends GameLoop{

	private static final long serialVersionUID = 1L;
	private GameStateManager gsm;
	public static Assets assets = new Assets();
	public static Vector2 map = new Vector2();
	
	public Game(int width, int height) {
		super(width, height);
	}

	@Override
	public void init() {
		assets.init();
		Vector2.setWorldVariables(map.xPos, map.yPos);
		gsm = new GameStateManager();
		gsm.init();
		super.init();
	}
	
	@Override
	public void tick(double deltaTime) {
		Vector2.setWorldVariables(map.xPos, map.yPos);
		gsm.tick(deltaTime);
	}

	@Override
	public void render() {
		super.render();
		gsm.render(graphics2D);
		clear();
	}

	@Override
	public void clear() {
		super.clear();
	}
	
}
