package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.Objects.Gold;
import main.java.Objects.Wumpus;

public class GoldTest {
	@Test
	public void itsWumpusPositionTest() {
		
		Wumpus wumpus = new Wumpus();
		wumpus.setPositionX(1);
		wumpus.setPositionY(1);

		Gold gold = new Gold(wumpus);
		gold.setPositionX(1);
		gold.setPositionY(1);

		assertTrue(gold.itsWumpusPosition(wumpus));
		gold.setPositionX(3);
		assertFalse(gold.itsWumpusPosition(wumpus));
	}
}
