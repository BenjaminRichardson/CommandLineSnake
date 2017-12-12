package board;

import gamepieces.GamePiece;

public class Location {
	private Board board;
	private GamePiece piece;
	private int x;
	private int y;
	public Location(Board board, int x, int y) {
		if(board == null || x<0 || y<0) {throw new IllegalArgumentException("Invalid param passed to location constructor.");}
		this.board = board;
		setX(x);
		setY(y);
		piece = null;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public GamePiece getItem() {
		return piece;
	}
	public void setItem(GamePiece item) {
		this.piece = item;
	}
	public Board getBoard() {
		return this.board;
	}
	public boolean isOccupied() {
		return this.piece != null;
	}
}
