
public class EmptySea extends Ship {
	public EmptySea() {
		setLength(1);
		setHit(new boolean[getLength()]);
	}
	
	@Override
	public boolean shootAt(int row, int column) {
		setHit(new boolean[]{true});
		return false;
	}
	
	@Override 
	public boolean isSunk() {
		return false;
	}
	
	@Override
	public String toString() {
		if (getHit()[0]) {
			return "-";
		}
		return ".";
	}
	
	@Override
	public String getShipType() {
		return "empty";
	}
}
