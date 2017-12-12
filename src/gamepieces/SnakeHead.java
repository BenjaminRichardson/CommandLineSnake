package gamepieces;

import java.util.List;
import board.Location;

public class SnakeHead extends SnakeNode{

	private int growthAmount;
	public SnakeHead(Location location,Location tailLocation) {
		super(location);
		growthAmount = 0;
		this.next = new SnakeNode(tailLocation);
	}
	
	public List<Location> getPossibleMoves(){
		List<Location> moves = this.location.getBoard().getAdjacentLocations(this.location);
		if(this.next != null) {
			moves.remove(next.getLocation());
		}
		return moves;
	}
	
	public void move() {
		super.move();
		if(this.growthAmount > 0) {
			this.grow();
			this.growthAmount--;
		}
	}
	
	public void addGrowth(int additionalGrowth) {
		this.growthAmount += additionalGrowth;
	}
	
	public String toString() {
		return "H";
	}
}
