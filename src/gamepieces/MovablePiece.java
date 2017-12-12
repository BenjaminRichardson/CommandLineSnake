package gamepieces;

import java.util.List;
import java.util.LinkedList;
import board.Location;

public abstract class MovablePiece extends GamePiece{
	abstract void move() ;
	public List<Location> getPossibleMoves(){
		return new LinkedList<Location>();
	}
}
