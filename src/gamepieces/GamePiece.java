package gamepieces;

import board.Location;

public abstract class GamePiece {
	protected Location location;
	public Location getLocation() {
		return this.location;
	}
	protected void setLocation(Location newLocation) {
		if(newLocation != null) {
			if(newLocation.isOccupied()) {throw new IllegalArgumentException("Cannot occupy a location that is already occupied");}
			newLocation.setItem(this);
		}
		if(this.location != null) {
			this.location.setItem(null);//Emptying current location
		}
		this.location = newLocation;
	}

}
