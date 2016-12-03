package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import main.java.Objects.Arrow;
import main.java.Objects.Gold;
import main.java.Objects.Hole;
import main.java.Objects.Hunter;
import main.java.Objects.Room;
import main.java.Objects.Wumpus;

public class HuntTheWumpus {
	private static final String YOU_HAVE_NOT_GOT_MORE_ARROWS = "You have not got more arrows!";
	private static Hunter hunter;
	private static Wumpus wumpus;
	private static Gold gold;
	private static ArrayList<Hole> holes;
	private static boolean gameEnd;
	private static Arrow arrow;

	public static void main(String[] args) {
		hunter = new Hunter(0, 0, 0);
		wumpus = new Wumpus();
		gold = new Gold(wumpus);
		holes = createHoles();
		arrow = new Arrow(3);
		gameEnd = false;

		Room[][] gameBoard = new Room[4][4];

		addElements(gameBoard);

		System.out.println("Game starts");

		while (gameEnd == false) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				String s = br.readLine();

				switch (s) {
				case "left":
					hunter.turnLeft();
					break;
				case "right":
					hunter.turnRight();
					break;
				case "go":
					advance(gameBoard);
					break;
				case "shoot":
					if (arrow.getQuantity() != 0) {
						hunter.shotArrow(arrow, gameBoard);
						arrow.setQuantity(arrow.getQuantity() - 1);
					} else {
						System.out.println(YOU_HAVE_NOT_GOT_MORE_ARROWS);
					}

					break;
				case "exit":
					gameFinish();
					break;

				default:
					System.out.println("Try another option");
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	private static void gameFinish() {
		if (hunter.hasGold() && hunter.isAtExit()) {
			gameEnd = true;
			System.out.println("Congratulations, you did it!");
		}
		if (hunter.hasGold() == false && hunter.isAtExit()) {
			gameEnd = false;
			System.out.println("You have to get the gold before exit!");
		}
		if (hunter.hasGold() && hunter.isAtExit() == false) {
			gameEnd = false;
			System.out.println("Sorry, but now you have to look for the exit!");
		}
		if (hunter.hasGold() == false && hunter.isAtExit() == false) {
			gameEnd = false;
			System.out.println("You have to get the gold, then look for the exit!");
		}
	}

	private static void addElements(Room[][] gameBoard) {
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard.length; j++) {
				if (wumpus.getPositionX() == i && wumpus.getPositionY() == j) {
					if (gameBoard[i][j] == null) {
						gameBoard[i][j] = new Room(i, j);
						gameBoard[i][j].addWumpusToRoom(wumpus);
					} else {
						gameBoard[i][j].addWumpusToRoom(wumpus);
					}
				}
				if (gold.getPositionX() == i && gold.getPositionY() == j) {
					if (gameBoard[i][j] == null) {
						gameBoard[i][j] = new Room(i, j);
						gameBoard[i][j].addGoldToRoom(gold);
					} else {
						gameBoard[i][j].addGoldToRoom(gold);
					}
				}
				for (int t = 0; t < holes.size(); t++) {
					if (holes.get(t).getPositionX() == i && holes.get(t).getPositionY() == j) {
						if (gameBoard[i][j] == null) {
							gameBoard[i][j] = new Room(i, j);
							gameBoard[i][j].addHoleToRoom(holes.get(t));
						} else {
							gameBoard[i][j].addHoleToRoom(holes.get(t));
						}
					}
				}

			}
		}
	}

	private static ArrayList<Hole> createHoles() {
		ArrayList<Hole> holes = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Hole hole = new Hole(wumpus, gold);
			holes.add(hole);
		}
		return holes;
	}

	private static void advance(Room[][] gameboard) {
		hunter.move();
		hunter.whatAreAtRoom(gameboard);
		gameEnd = hunter.isDead();
		if (gameEnd == false) {
			hunter.whatIsNear(gameboard);
		}
	}

}
