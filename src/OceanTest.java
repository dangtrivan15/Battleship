import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OceanTest {
	Ocean ocean;
	@BeforeEach
	void setUp() throws Exception {
		ocean = new Ocean();
	}

	@Test
	void testPlaceAllShipsRandomly() {
		Ocean ocean = new Ocean();
		ocean.print();
		ocean.placeAllShipsRandomly();
		
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 15; j++) {
				ocean.shootAt(i, j);
			}
		}
		ocean.print();
		
		System.out.println(ocean.shotsFired);
		System.out.println(ocean.hitCount);
		System.out.println(ocean.shipsSunk);
		System.out.println(ocean.isGameOver());
	}

}
