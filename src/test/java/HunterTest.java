package test.java;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.java.Objects.Gold;
import main.java.Objects.Hole;
import main.java.Objects.Hunter;
import main.java.Objects.Room;
import main.java.Objects.Wumpus;

public class HunterTest {

	@Test
	public void turnLeftTest() {

		Hunter hunter = new Hunter(0, 0, 0);

		hunter.setDirection(0);

		hunter.turnLeft();
		assertTrue(hunter.getDirection() == 1);
		hunter.turnLeft();
		assertTrue(hunter.getDirection() == 2);
		hunter.turnLeft();
		assertTrue(hunter.getDirection() == 3);
		hunter.turnLeft();
		assertTrue(hunter.getDirection() == 0);
	}

	@Test
	public void turnRigthTest() {

		Hunter hunter = new Hunter(0, 0, 0);

		hunter.setDirection(0);

		hunter.turnRight();
		assertTrue(hunter.getDirection() == 3);
		hunter.turnRight();
		assertTrue(hunter.getDirection() == 2);
		hunter.turnRight();
		assertTrue(hunter.getDirection() == 1);
		hunter.turnRight();
		assertTrue(hunter.getDirection() == 0);
	}

	@Test
	public void moveTest() {

		Hunter hunter = new Hunter(0, 0, 0);

		hunter.setDirection(0);

		hunter.move();
		assertTrue(hunter.getPositionX() == 1);
		hunter.setDirection(2);
		hunter.move();
		assertTrue(hunter.getPositionX() == 0);
		hunter.setDirection(1);
		hunter.move();
		assertTrue(hunter.getPositionY() == 1);
		hunter.setDirection(3);
		hunter.move();
		assertTrue(hunter.getPositionY() == 0);
	}

	@Test
	public void canTakeGoldTest() {

		Hunter hunter = new Hunter(0, 0, 0);

		Gold gold = new Gold(new Wumpus());
		gold.setPositionX(0);
		gold.setPositionY(0);
		assertTrue(hunter.canTakeGold(gold));
		gold.setPositionY(1);
		assertFalse(hunter.canTakeGold(gold));

	}

	@Test
	public void isCatchedTest() {

		Hunter hunter = new Hunter(0, 0, 0);

		Wumpus wumpus = new Wumpus();
		wumpus.setPositionX(0);
		wumpus.setPositionY(0);
		assertTrue(hunter.isCatched(wumpus));
		wumpus.setPositionY(1);
		assertFalse(hunter.isCatched(wumpus));

	}

	@Test
	public void isInAHoleTest() {

		Hunter hunter = new Hunter(0, 0, 0);
		Hole hole = new Hole(new Wumpus(), new Gold(new Wumpus()));
		hole.setPositionX(0);
		hole.setPositionY(0);
		assertTrue(hunter.isInAHole(hole));
		hole.setPositionY(1);
		assertFalse(hunter.isInAHole(hole));

	}

	@Test
	public void isAtExitTest() {

		Hunter hunter = new Hunter(0, 0, 0);

		assertTrue(hunter.isAtExit());
		hunter.setPositionX(1);
		assertFalse(hunter.isAtExit());

	}

	@Test
	public void isNearToGoldTest() {

		Hunter hunter = new Hunter(0, 0, 0);
		Room nearRoom = new Room(0, 0);
		assertFalse(hunter.isNearToGold(nearRoom));
		nearRoom.setGold(new Gold(new Wumpus()));
		assertTrue(hunter.isNearToGold(nearRoom));

	}

	@Test
	public void isNearToWumpusTest() {

		Hunter hunter = new Hunter(0, 0, 0);
		Room nearRoom = new Room(0, 0);
		assertFalse(hunter.isNearToHole((nearRoom)));
		nearRoom.setHole(new Hole(new Wumpus(), new Gold(new Wumpus())));
		assertTrue(hunter.isNearToHole(nearRoom));

	}
	
	@Test
	public void hasWumpusNearTest() {

		Hunter hunter = new Hunter(0, 0, 0);
		Room nearRoom = new Room(0, 0);
		assertFalse(hunter.hasWumpusNear(nearRoom));
		nearRoom.setWumpus(new Wumpus());
		assertTrue(hunter.hasWumpusNear(nearRoom));

	}
}
