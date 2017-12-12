package gamepieces;

import board.Location;

public abstract class Fruit extends MovablePiece {
	
	protected int growAmount;
	
	public Fruit(Location location, int growAmount) {
		this.setLocation(location);
		this.growAmount = growAmount;
	}
	public abstract void move();
	public int getGrowAmount() {
		return this.growAmount;
	}
	

}
