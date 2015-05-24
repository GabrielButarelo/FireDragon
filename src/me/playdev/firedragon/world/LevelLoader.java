package me.playdev.firedragon.world;

import java.awt.Graphics2D;

import me.playdev.firedragon.system.GameState;
import me.playdev.firedragon.system.GameStateManager;

public class LevelLoader extends GameState{

	private Map map;
	
	public LevelLoader(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		map = new Map();
		map.init();
	}

	@Override
	public void tick(double deltaTime) {
		map.tick(deltaTime);
	}

	@Override
	public void render(Graphics2D g) {
		map.render(g);
	}

}
