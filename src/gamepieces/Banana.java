package gamepieces;

import java.util.List;
import board.Location;

public class Banana extends Fruit{
	public static final int BANANA_VALUE = 2;
	
	public Banana(Location location) {
		super(location, BANANA_VALUE);
	}
	
	public List<Location> getPossibleMoves() {
		return this.location.getBoard().getAllOpenLocations();
	}
	
	public void move() {
		this.setLocation(this.location.getBoard().getRandomOpenLocation());
	}
	
	public String toString() {
		return "B";
	}
}
