package main.java.Objects;

public class Room {
	private int positionX;
	private int positionY;
	private Wumpus wumpus;
	private Hole hole;
	private Gold gold;

	public Room(int positionX, int positionY) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
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

	public void addHoleToRoom(Hole hole) {
		this.hole = hole;
	}

	public void addWumpusToRoom(Wumpus wumpus) {
		this.wumpus = wumpus;
	}

	public void addGoldToRoom(Gold gold) {
		this.gold = gold;
	}

	public Wumpus getWumpus() {
		return wumpus;
	}

	public void setWumpus(Wumpus wumpus) {
		this.wumpus = wumpus;
	}

	public Hole getHole() {
		return hole;
	}

	public void setHole(Hole hole) {
		this.hole = hole;
	}

	public Gold getGold() {
		return gold;
	}

	public void setGold(Gold gold) {
		this.gold = gold;
	}
}
