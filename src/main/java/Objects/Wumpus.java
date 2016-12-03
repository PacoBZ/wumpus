package main.java.Objects;


public class Wumpus {
	private int positionX;
	private int positionY;

	public Wumpus() {
		super();
		while (positionX == 0 && positionY == 0) {
			this.positionX = (int) (Math.random() * 3 + 1);
			this.positionY = (int) (Math.random() * 3 + 1);
		}
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
}
