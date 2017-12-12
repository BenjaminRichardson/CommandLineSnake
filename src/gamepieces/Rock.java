package gamepieces;

import board.Location;

public class Rock extends GamePiece {
	
	
	//TODO: enforce rock takes up 4 spaces 
	public Rock(Location location) {
		this.setLocation(location);
	}

	//purely for display purposes
	public String toString() {
		return "R";
	}
	
}
