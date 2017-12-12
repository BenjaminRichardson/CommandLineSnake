package gamepieces;

import java.util.List;
import board.Location;

public class Apple extends Fruit{
	public static final int APPLE_VALUE = 1;
	
	public Apple(Location location) {
		super(location, APPLE_VALUE);
	}
	
	public List<Location> getPossibleMoves() {
		return this.location.getBoard().getAllOpenLocations();
	}
	
	public void move() {
		this.setLocation(this.location.getBoard().getRandomOpenLocation());
	}
	
	public String toString() {
		return "A";
	}
}
