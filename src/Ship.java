
public abstract class Ship {
	// Attributes
    private int bowRow;
    private int bowColumn;
    private int length;
    private boolean horizontal;
    private boolean[] hit;
    
    //Getter and Setter
    public int getBowRow() {
        return bowRow;
    }

    public void setBowRow(int bowRow) {
        this.bowRow = bowRow;
    }

    public int getBowColumn() {
        return bowColumn;
    }

    public void setBowColumn(int bowColumn) {
        this.bowColumn = bowColumn;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    public boolean[] getHit() {
        return hit;
    }

    public void setHit(boolean[] hit) {
        this.hit = hit;
    }
    
    
    
    
    //Methods
    abstract String getShipType();
    
    public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
    	if (horizontal) {
    		for (int i = 0; i < length; i++) {
    			if (!ocean.ships[row][column + i].getShipType().equals("empty")) {
    				return false;
    			}
    		}
    	} else {
    		for (int i = 0; i < length; i++) {
    			if (!ocean.ships[row + i][column].getShipType().equals("empty")) {
    				return false;
    			}
    		}
    	}
    	return true;
    }
    
    void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
    	if (horizontal) {
    		for (int i = 0; i < length; i++) {
    			ocean.ships[row][column + i] = this;
    		}
    	} else {
    		for (int i = 0; i < length; i++) {
    			ocean.ships[row + i][column] = this;
    		}
    	}
    }
    
    boolean shootAt(int row, int column) {
    	if (!ocean.ships[row][column].getShipType().equals("empty"))
    }
    
}
