import java.util.Scanner; 
public class BattleshipGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ocean ocean = new Ocean();
		ocean.placeAllShipsRandomly();
		Scanner sc = new Scanner(System.in);
		// Create a Scanner object
		while (true) {
			System.out.println("Enter shots: ");
			String inp = sc.nextLine();
			String[] getshots = inp.split(";");
			String[][] shots = new String[5][2];
			for (int i = 0; i < 5; i ++) {
				shots[i][0] = getshots[i].split(",")[0];
				shots[i][1] = getshots[i].split(",")[1];
			}
			for (String[] k: shots) {
				ocean.shootAt(Integer.parseInt(k[0]), Integer.parseInt(k[1]));
			}
			ocean.print();
			if (ocean.isGameOver()) {
				break;
			}
			System.out.println("Continue? (yes or no): ");
			if (sc.nextLine().equals("no")) {
				break;
			}
		}
		System.out.println("Final Result: ");
		System.out.println("ShotFired: " + ocean.shotsFired);
		System.out.println("ShipsSunk: " + ocean.shipsSunk);
		System.out.println("HitCount: " + ocean.hitCount);
		sc.close();
	}

}
