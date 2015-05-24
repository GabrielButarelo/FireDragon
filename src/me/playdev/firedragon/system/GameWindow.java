package me.playdev.firedragon.system;

import java.awt.GraphicsDevice;

import javax.swing.JFrame;

import me.playdev.firedragon.FireDragon;
import me.playdev.firedragon.entity.Player;

public class GameWindow {

	public JFrame frame;
	private boolean fullScreenEnable = false;
	private GraphicsDevice graphicsDevice;
	
	public GameWindow(int WIDTH, int HEIGHT) {
		if(frame == null){
			graphicsDevice = FireDragon.graphicsDevice;
			frame = new JFrame();
			frame.setTitle("FireDragon");
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(WIDTH/2, HEIGHT/3);
			frame.setIgnoreRepaint(true);
			frame.setResizable(false);
			frame.addKeyListener(new Player());
			frame.add(new Game(WIDTH, HEIGHT));
		}
	}
	
	public void setFullScreen(boolean enable){
		if(enable){
			fullScreenEnable = true;
			frame.setUndecorated(true); 
			graphicsDevice.setFullScreenWindow(frame);
		}else{
			fullScreenEnable = false;
			frame.setUndecorated(false); 
			frame.dispose();  
			graphicsDevice.setFullScreenWindow(null); 
		}
	}

	public boolean isFullScreenEnable() {
		return fullScreenEnable;
	}
	
}
