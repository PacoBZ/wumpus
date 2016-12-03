package main.java.Objects;

public class Gold {
	private int positionX;
	private int positionY;

	public Gold(Wumpus wumpus) {
		super();
		while (positionX == 0 && positionY == 0 || itsWumpusPosition(wumpus)) {
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

	public boolean itsWumpusPosition(Wumpus wumpus) {
		return (wumpus.getPositionX() == positionX && wumpus.getPositionY() == positionY);
	}

}
