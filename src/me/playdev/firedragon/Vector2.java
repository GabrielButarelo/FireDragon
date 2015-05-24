package me.playdev.firedragon;

public class Vector2 {

	public float xPos, yPos;
	public static float worldXPos, worldYPos;
	
	public Vector2(float xPos, float yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public Vector2() {
		this.xPos = 0.0F;
		this.yPos = 0.0F;
	}
	
	public static Vector2 zero(){
		return new Vector2(0,0);
	}
	
	public void normalize(){
		double lenght = Math.sqrt(xPos * xPos + yPos * yPos);
		if(lenght != 0.0){
			float s = 1.0F/(float)lenght;
			xPos = xPos * s;
			yPos = yPos * s;
		}
	}
	
	public boolean equals(Vector2 vec){
		return (this.xPos == vec.xPos && this.yPos == vec.yPos);
	}
	
	public Vector2 copy(Vector2 vec){
		this.xPos = vec.xPos;
		this.yPos = vec.yPos;
		return new Vector2(xPos, yPos);
	}
	
	public Vector2 add(Vector2 vec){
		xPos = xPos + vec.xPos;
		yPos = yPos + vec.yPos;
		return new Vector2(xPos, yPos);
	}
	
	public static void setWorldVariables(float xPos, float yPos){
		worldXPos = xPos;
		worldYPos = yPos;
	}
	
	public static double getDistanceOnScreen(Vector2 vec1, Vector2 vec2){
		float v1 = vec1.xPos - vec2.xPos;
		float v2 = vec1.yPos - vec2.yPos;
		return Math.sqrt(v1 * v1 + v2 * v2);
	}
	
	public Vector2 getScreenLocation(){
		return new Vector2(xPos, yPos);
	}

	public Vector2 getWorldLocation(){
		return new Vector2(xPos - worldXPos, yPos - worldYPos);
	}
	
	public double getDistanceBetweenWorldVectors(Vector2 vec){
		float dx = Math.abs(getWorldLocation().xPos - vec.getWorldLocation().xPos);
		float dy = Math.abs(getWorldLocation().yPos - vec.getWorldLocation().yPos);
		return Math.sqrt(dx * dx - dy * dy);
	}
	
}
