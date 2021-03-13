
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
    public abstract String getShipType();
    
    public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
    	if (horizontal) {
    		for (int i = -1; i < 2; i++) {
    			for (int j = -1; j < 2; j++) {
    				try {
    					if (!ocean.ships[row + i][column + j].getShipType().equals("empty")) {
    						return false;
    					}
    				} catch (ArrayIndexOutOfBoundsException e) {
    					continue;
    				}
    				
    				try {
    					if (!ocean.ships[row + i][column + j + length].getShipType().equals("empty")) {
    						return false;
    					}
    				} catch (ArrayIndexOutOfBoundsException e) {
    					continue;
    				}
    			}
    		}
    		for (int i = 0; i < length; i++) {
    			try {
    				if (!ocean.ships[row][column + i].getShipType().equals("empty")) {
    					return false;
    				}
    			} catch (ArrayIndexOutOfBoundsException e) {
    				return false;
    			}
    		}
    	} else {
    		for (int i = -1; i < 2; i++) {
    			for (int j = -1; j < 2; j++) {
    				try {
    					if (!ocean.ships[row + i][column + j].getShipType().equals("empty")) {
    						return false;
    					}
    				} catch (ArrayIndexOutOfBoundsException e) {
    					continue;
    				}
    				
    				try {
    					if (!ocean.ships[row + i + length][column + j].getShipType().equals("empty")) {
    						return false;
    					}
    				} catch (ArrayIndexOutOfBoundsException e) {
    					continue;
    				}
    			}
    		}
    		for (int i = 0; i < length; i++) {
    			try {
    				if (!ocean.ships[row + i][column].getShipType().equals("empty")) {
    					return false;
    				}
    			} catch (ArrayIndexOutOfBoundsException e) {
    				return false;
    			}
    		}
    	}
    	return true;
    }
    
    public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
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
    
    public boolean shootAt(int row, int column) {
    	if (horizontal && (row == bowRow)) {
    		for (int i = 0; i < length; i++) {
    			if (bowColumn + i == column) {
    				if (!this.isSunk()) {
    					hit[i] = true;
    					return true;
    				}
    			}
    		}
    		
    	} else if (!horizontal && (column == bowColumn)){
    		for (int i = 0; i < length; i++) {
    			if (bowRow + i == row) {
    				if (!this.isSunk()) {
    					hit[i] = true;
    					return true;
    				}
    			}
    		}
    	}
    	return false;
    }
    
    
    public boolean isSunk() {
    	for (boolean i: hit) {
    		if (!i) {
    			return false;
    		}
    	}
    	return true;
    }
    
    @Override
    public String toString() {
    	if (isSunk()) {
    		return "x";
    	} else {
    		return "S";
    	}
    }
}
