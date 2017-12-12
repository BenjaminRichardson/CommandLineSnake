package gamepieces;

import java.util.LinkedList;
import java.util.List;

import board.Location;

public class SnakeNode extends MovablePiece{

	protected SnakeNode next;
	private Location nextLocation;
	private boolean growOnMove;
	public SnakeNode(Location location) {
		this.setLocation(location);
		this.next = null;
		growOnMove = false;
	}
	
	public List<Location> getPossibleMoves() {
		if(nextLocation == null) {
			return null;
		}else {
			List<Location> temp = new LinkedList<Location>();
			temp.add(nextLocation);
			return temp;
		}
	}
	
	public void setNextLocation(Location nextLocation) {
		this.nextLocation = nextLocation;
	}
	
	public void move() {
		if(this.nextLocation == null) {throw new IllegalStateException("Have not specified where you would like to move this");}
		if(this.next != null) {
			this.next.setNextLocation(this.location);
			this.setLocation(nextLocation);
			this.next.move();
		}else if(growOnMove) {
			//Can only grow when next is null
			Location oldLocation = this.getLocation();
			this.setLocation(nextLocation);
			SnakeNode newTail = new SnakeNode(oldLocation);
			this.next = newTail;
			growOnMove = false;
		}else {
			this.setLocation(nextLocation);
		}
		this.nextLocation = null;
	}
	
	public void grow() {
		if(next == null) {
			growOnMove = true;
		}else {
			next.grow();
		}
	}
	
	public String toString() {
		return "S";
	}
}
