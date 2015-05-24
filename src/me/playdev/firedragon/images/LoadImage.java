package me.playdev.firedragon.images;

import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

public class LoadImage {

	public static BufferedImage loadImage(Class<?> classFile, String path) {
		try{
			URL url = classFile.getResource(path);
			BufferedImage img = ImageIO.read(url);
			return img;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
}
