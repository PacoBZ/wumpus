package main.java.Objects;

public class Hole {
	private int positionX;
	private int positionY;

	public Hole(Wumpus wumpus, Gold gold) {
		super();
		while (positionX == 0 && positionY == 0 || itsWumpusPosition(wumpus) || itsGoldPosition(gold)) {
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

	public boolean itsGoldPosition(Gold gold) {
		return (gold.getPositionX() == positionX && gold.getPositionY() == positionY);
	}
}
