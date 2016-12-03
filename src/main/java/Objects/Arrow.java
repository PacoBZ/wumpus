package main.java.Objects;

public class Arrow {

	private int positionX;
	private int positionY;
	private int quantity;

	public Arrow(int quantity) {
		super();
		this.quantity = quantity;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean StrikesWall(Arrow arrow, Room room) {
		if (arrow.getPositionX() == 3 || arrow.getPositionY() == 3) {
			if (room != null) {
				if (room.getWumpus() == null) {
					return true;
				} else {
					return false;
				}
			} else {
				return true;
			}
		} else {
			return false;
		}

	}
}
