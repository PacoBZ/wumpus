package main.java.Objects;

public class Hunter {
	private static final String YOUR_ARROW_HIT_A_WALL = "Your arrow hit a wall";
	private static final String YOU_KILLED_THE_WUMPUS = "You killed the Wumpus";
	private static final String YOU_TAKE_THE_GOLD_GO_TO_THE_EXIT_NOW = "You take the Gold! Go to the exit now";
	private static final String YOU_ARE_DEAD = "You are dead...";
	private static final String YOU_HAVE_A_WALL_TO_YOUR_RIGTH = "You have a wall to your rigth";
	private static final String YOU_HAVE_A_WALL_IN_THE_TOP_POSITION = "You have a wall in the top position";
	private static final String YOU_HAVE_A_WALL_TO_YOUR_LEFT = "You have a wall to your left";
	private static final String YOU_PERCEIVE_A_STRONG_SHINE = "You perceive a strong shine";
	private static final String YOU_PERCEIVE_A_LIGHT_BREEZE = "You perceive a light breeze";
	private static final String YOU_PERCEIVE_A_STRONG_SMELL_NEAR_YOU = "You perceive a strong smell near you";
	private static final String YOU_HIT_A_WALL = "You hit a wall";
	private static final String YOU_HAVE_A_WALL_BELOW_YOU = "You have a wall below you";
	private int positionX;
	private int positionY;
	private int direction;
	private Gold gold;
	private boolean isDead;

	public Hunter(int positionX, int positionY, int direction) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
		this.direction = direction;
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

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	public void turnRight() {
		if (direction == 0) {
			direction = 4;
		}
		direction--;

		System.out.println("You turn righth");
	}

	public void turnLeft() {
		if (direction == 3) {
			direction = -1;
		}
		direction++;
		System.out.println("You turn left");
	}

	public void move() {
		switch (direction) {
		case 0:
			if (positionX < 3) {
				positionX++;
			} else {
				System.out.println(YOU_HIT_A_WALL);
			}
			break;
		case 1:
			if (positionY < 3) {
				positionY++;
			} else {
				System.out.println(YOU_HIT_A_WALL);
			}
			break;
		case 2:
			if (positionX > 0) {
				positionX--;
			} else {
				System.out.println(YOU_HIT_A_WALL);
			}
			break;
		case 3:
			if (positionY > 0) {
				positionY--;
			} else {
				System.out.println(YOU_HIT_A_WALL);
			}
			break;

		default:
			break;
		}

	}

	public void takeGold(Gold gold) {
		this.gold = gold;
	}

	public boolean canTakeGold(Gold gold) {
		if (gold != null) {
			return (gold.getPositionX() == this.getPositionX() && gold.getPositionY() == this.getPositionY());
		} else {
			return false;
		}
	}

	public boolean isCatched(Wumpus wumpus) {
		if (wumpus != null) {
			return (wumpus.getPositionX() == this.getPositionX() && wumpus.getPositionY() == this.getPositionY());
		} else {
			return false;
		}
	}

	public boolean isInAHole(Hole hole) {
		if (hole != null) {
			return (hole.getPositionX() == this.getPositionX() && hole.getPositionY() == this.getPositionY());
		} else {
			return false;

		}
	}

	public boolean hasGold() {
		if (gold == null) {
			return false;
		} else {
			return true;
		}
	}

	public boolean isAtExit() {
		return (this.positionX == 0 && this.positionY == 0);
	}

	public void checkPerceptions(Room nearRoom) {
		if (hasWumpusNear(nearRoom)) {
			System.out.println(YOU_PERCEIVE_A_STRONG_SMELL_NEAR_YOU);
		}
		if (isNearToHole(nearRoom)) {
			System.out.println(YOU_PERCEIVE_A_LIGHT_BREEZE);

		}
		if (isNearToGold(nearRoom)) {
			System.out.println(YOU_PERCEIVE_A_STRONG_SHINE);

		}

	}

	public boolean isNearToGold(Room nearRoom) {
		boolean nearToGold = false;

		if (nearRoom.getGold() != null) {
			nearToGold = true;
		} else {
			nearToGold = false;
		}
		return nearToGold;
	}

	public boolean isNearToHole(Room nearRoom) {
		boolean nearToHole = false;

		if (nearRoom.getHole() != null) {
			nearToHole = true;
		} else {
			nearToHole = false;
		}
		return nearToHole;

	}

	public boolean hasWumpusNear(Room nearRoom) {
		boolean nearToWumpus = false;

		if (nearRoom.getWumpus() != null) {
			nearToWumpus = true;
		} else {
			nearToWumpus = false;
		}
		return nearToWumpus;
	}

	public void whatIsNear(Room[][] gameboard) {

		// Left
		if (positionX - 1 >= 0) {
			Room leftRoom = gameboard[positionX - 1][positionY];
			if (leftRoom != null) {
				checkPerceptions(leftRoom);
			}
		} else {
			System.out.println(YOU_HAVE_A_WALL_TO_YOUR_LEFT);
		}
		// Up
		if (positionY + 1 <= 3) {
			Room upRoom = gameboard[positionX][positionY + 1];
			if (upRoom != null) {
				checkPerceptions(upRoom);
			}
		} else {
			System.out.println(YOU_HAVE_A_WALL_IN_THE_TOP_POSITION);
		}
		// Rigth
		if (positionX + 1 <= 3) {
			Room rightRoom = gameboard[positionX + 1][positionY];
			if (rightRoom != null) {
				checkPerceptions(rightRoom);
			}
		} else {
			System.out.println(YOU_HAVE_A_WALL_TO_YOUR_RIGTH);
		}
		// Down
		if (positionY - 1 >= 0) {
			Room downRoom = gameboard[positionX][positionY - 1];
			if (downRoom != null) {
				checkPerceptions(downRoom);
			}
		} else {
			System.out.println(YOU_HAVE_A_WALL_BELOW_YOU);
		}
	}

	public void shotArrow(Arrow arrow, Room[][] gameBoard) {
		arrow.setPositionX(this.positionX);
		arrow.setPositionX(this.positionY);
		int arrowX = arrow.getPositionX();
		int arrowY = arrow.getPositionY();

		switch (direction) {
		case 0:

			while (arrow.getPositionX() < 3) {

				arrow.setPositionX(arrowX);
				if (hitWumpus(gameBoard, arrowX, arrowY) == false) {
					if (arrow.StrikesWall(arrow, gameBoard[arrowX][arrowY])) {
						System.out.println(YOUR_ARROW_HIT_A_WALL);
					}
				}else{
					break;
				}

				arrowX++;

			}

			break;
		case 1:
			if (arrow.getPositionY() < 3) {

				arrow.setPositionY(arrowY);
				if (hitWumpus(gameBoard, arrowX, arrowY) == false) {
					if (arrow.StrikesWall(arrow, gameBoard[arrowX][arrowY])) {
						System.out.println(YOUR_ARROW_HIT_A_WALL);
					}
				}else{
					break;
				}

				arrowY++;

			}
			break;
		case 2:
			while (arrow.getPositionX() > 0) {
				arrow.setPositionX(arrowX);
				if (hitWumpus(gameBoard, arrowX, arrowY) == false) {
					if (arrow.StrikesWall(arrow, gameBoard[arrowX][arrowY])) {
						System.out.println(YOUR_ARROW_HIT_A_WALL);
					}
				}else{
					break;
				}

				arrowX--;

			}
			break;
		case 3:
			if (arrow.getPositionY() > 0) {
				arrow.setPositionY(arrowY);
				if (hitWumpus(gameBoard, arrowX, arrowY) == false) {
					if (arrow.StrikesWall(arrow, gameBoard[arrowX][arrowY])) {
						System.out.println(YOUR_ARROW_HIT_A_WALL);
					}
				}else{
					break;
				}

				arrowY--;
			}
			break;

		default:
			break;
		}

	}

	public void whatAreAtRoom(Room[][] gameBoard) {
		Room actualRoom = gameBoard[positionX][positionY];
		if (actualRoom != null) {
			if (isCatched(actualRoom.getWumpus()) || isInAHole(actualRoom.getHole())) {
				isDead = true;
				System.out.println(YOU_ARE_DEAD);
			}
			if (canTakeGold(actualRoom.getGold())) {
				this.gold = actualRoom.getGold();
				actualRoom.setGold(null);
				System.out.println(YOU_TAKE_THE_GOLD_GO_TO_THE_EXIT_NOW);
			}

		}

	}

	private boolean hitWumpus(Room[][] gameBoard, int arrowX, int arrowY) {
		if (gameBoard[arrowX][arrowY] != null) {
			if (gameBoard[arrowX][arrowY].getWumpus() != null) {
				gameBoard[arrowX][arrowY].setWumpus(null);
				System.out.println(YOU_KILLED_THE_WUMPUS);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}



}
