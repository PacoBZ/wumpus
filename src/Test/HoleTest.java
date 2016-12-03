package Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.java.Objects.Gold;
import main.java.Objects.Hole;
import main.java.Objects.Wumpus;

public class HoleTest {
	@Test
	public void itsWumpusPositionTest() {
		
		Wumpus wumpus = new Wumpus();
		wumpus.setPositionX(1);
		wumpus.setPositionY(1);

		Gold gold = new Gold(wumpus);
		gold.setPositionX(1);
		gold.setPositionY(1);
		
		Hole hole = new Hole(wumpus,gold );
		hole.setPositionX(1);
		hole.setPositionY(1);

		assertTrue(hole.itsWumpusPosition(wumpus));
		
		hole.setPositionX(3);
		
		assertFalse(hole.itsWumpusPosition(wumpus));
		
	}
	@Test
	public void itsGoldPositionTest() {
		
		Wumpus wumpus = new Wumpus();
		wumpus.setPositionX(1);
		wumpus.setPositionY(1);

		Gold gold = new Gold(wumpus);
		gold.setPositionX(1);
		gold.setPositionY(1);
		
		Hole hole = new Hole(wumpus,gold );
		hole.setPositionX(1);
		hole.setPositionY(1);

		assertTrue(hole.itsGoldPosition(gold));
		
		hole.setPositionX(3);
		
		assertFalse(hole.itsGoldPosition(gold));
	}
}
