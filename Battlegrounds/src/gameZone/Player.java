package gameZone;

public class Player {
	
	private int xPos;
	private int yPos;
	private boolean alive;
	private int maxSpeed;
	
	Player(){
		xPos = 50;
		yPos = 50;
		alive = true;
		maxSpeed = 4;
	}
	
	public int getX() {
		return xPos;
	}
	
	public int getY() {
		return yPos;
	}
	
	public void addX(int n) {
		xPos += n;
	}
	
	public void addY(int n) {
		yPos += n;
	}
	
	public int getMaxSpeed() {
		return maxSpeed;
	}
}
