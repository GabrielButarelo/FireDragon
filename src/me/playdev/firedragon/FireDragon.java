package me.playdev.firedragon;

import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import me.playdev.firedragon.system.GameWindow;

public class FireDragon {

	public static Font debugTitleFont = new Font("Arial", Font.BOLD, 20);
	public static Font debugParameterFont = new Font("Arial", Font.BOLD, 15);
	public static GraphicsDevice graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	public GameWindow gameWindow;
	public static int width = graphicsDevice.getDisplayMode().getWidth();
	public static int height = graphicsDevice.getDisplayMode().getHeight();
	
	public FireDragon() {
		gameWindow = new GameWindow(width, width);
		gameWindow.setFullScreen(true);
		gameWindow.frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new FireDragon();
	}
	
}
