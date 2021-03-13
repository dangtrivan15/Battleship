import java.util.ArrayList;
import java.util.Random;

public class Ocean {
	Ship[][] ships = new Ship[20][20];
	int shotsFired;
	int hitCount;
	int shipsSunk;
	
	public Ocean() {
	    for (int i = 0; i < ships.length; i++) {
	        // tiny change 1: proper dimensions
	        for (int j = 0; j < ships[i].length; j++) { 
	            // tiny change 2: actually store the values
	        	EmptySea Empsea = new EmptySea();
	        	Empsea.setBowRow(i);
	        	Empsea.setBowColumn(j);
	        	ships[i][j] = Empsea;
	        }
	    }
	}
	
	public void placeAllShipsRandomly() {
		Random rand = new Random();
		BattleShip[] BList = {new BattleShip()};
		BattleCruiser[] BCList = {new BattleCruiser()};
		Cruiser[] CList = {new Cruiser(),new Cruiser()};
		LightCruiser[] LCList = {new LightCruiser(),new LightCruiser()};
		Destroyer[] DList = {new Destroyer(),new Destroyer(),new Destroyer()};
		Submarine[] SList = {new Submarine(),new Submarine(),new Submarine(),new Submarine()};
		Ship[][] shiplist = {BList,BCList,CList,LCList,DList,SList};
		ArrayList<Ship> finalshiplist = new ArrayList<Ship>();
	    for (int i = 0; i < shiplist.length; i++) {
	        // tiny change 1: proper dimensions
	        for (int j = 0; j < shiplist[i].length; j++) { 
	            // tiny change 2: actually store the values
	        	finalshiplist.add(shiplist[i][j]);
	        }
	    
	    }
	    while (finalshiplist.size() > 0) {
	    	int row = rand.nextInt(19);
	    	int col = rand.nextInt(19);
	    	boolean horizontal = rand.nextBoolean();
	    	if (finalshiplist.get(0).okToPlaceShipAt(row,col,horizontal,this)) {
	    		Ship placedship = finalshiplist.get(0);
	    		placedship.setBowRow(row);
	    		placedship.setBowColumn(col);
	    		placedship.setHorizontal(horizontal);
	    		placedship.placeShipAt(row,col,horizontal,this);
	    		finalshiplist.remove(0);
	    	}
	    }
	}
	
	public boolean isOccupied(int row, int column) {
		if (ships[row][column].getShipType().equals("empty")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean shootAt(int row, int column) {
		shotsFired++;
		if (ships[row][column].shootAt(row, column)) {
			hitCount ++;
			if (ships[row][column].isSunk()) {
				shipsSunk++;
			}
			return true;
		} else {
			return false;
		}
	}
	
	public int getShotsFired() {
		return shotsFired;
	}
	
	public int getHitCount() {
		return hitCount;
	}
	
	public int getShipsSunk() {
		return shipsSunk;
	}
	
	public boolean isGameOver() {
	    for (int i = 0; i < ships.length; i++) {
	        for (int j = 0; j < ships[i].length; j++) { 
	        	if (!ships[i][j].getShipType().equals("empty") && !ships[i][j].isSunk()) {
	        		return false;
	        	}
	        }
	    }
	    return true;
	}
	
	public Ship[][] getShipArray() {
		return ships;
	}
	
	public String Status(int row, int col) {
		if (ships[row][col].getHit()[col - ships[row][col].getBowColumn() + row - ships[row][col].getBowRow()]) {
			return ships[row][col].toString();
		} else return ".";
	}
	
	public void print() {
		System.out.printf("%2s ", "I");
		for(int i = 0; i < 20; i++) {
			System.out.printf("%2s ", i);
		}
		System.out.println();
		for(int i = 0; i < 20; i++) {
			System.out.printf("%2s ", i);
			for(int j = 0; j < 20; j++) {
				System.out.printf("%2s ", Status(i,j));
			}
			System.out.println();
		}
	}

}
