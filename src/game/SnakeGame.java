package game;

import java.util.List;
import board.*;
import gamepieces.*;

public class SnakeGame {
	private static final int ROCK_COUNT = 3;
	
	private Board board;
	private SnakeHead snake;
	public boolean gameOver;
	public enum Move {
		UP,DOWN,LEFT,RIGHT
	};
	
	public SnakeGame() {
		board = new Board();
		gameOver = false;
		//Place rocks
		for(int i=0; i<ROCK_COUNT; i++) {
			List<Location> rockBlock;
			do {
				rockBlock = board.getRandomOpenBlock(2, 2);
			}while(rockBlock == null);
			//place single rock
			for(Location loc : rockBlock){
				new Rock(loc);
			}
		}
		//place 1 apple
		Location randomLocation = board.getRandomOpenLocation();
		new Apple(randomLocation);
		//place 1 banana
		randomLocation = board.getRandomOpenLocation();
		new Banana(randomLocation);
		//place snake and body
		List<Location> snakeLocations;
		do {
			snakeLocations = board.getRandomOpenBlock(2,1);
		}while(snakeLocations == null);
		snake = new SnakeHead(snakeLocations.get(0),snakeLocations.get(1));
	}
	
	//prompt for input, should only be up down left or right
	public void playerMove(Move move) {
		Location moveDest;
		switch(move) {
			case UP:
				moveDest = board.getLocationByOffset(snake.getLocation(), -1, 0);
				break;
			case DOWN:
				moveDest = board.getLocationByOffset(snake.getLocation(), 1, 0);
				break;
			case LEFT:
				moveDest = board.getLocationByOffset(snake.getLocation(), 0, -1);
				break;
			case RIGHT:
				moveDest = board.getLocationByOffset(snake.getLocation(), 0, 1);
				break;
			default:
				moveDest = null;
		}
		if(moveDest == null) {
			this.gameOver = true;
		}else {
			this.handleMove(moveDest);
		}
	}
	
	private void handleMove(Location moveDest) {
		if(moveDest.isOccupied()) {
			if(moveDest.getItem() instanceof Fruit) {
				Fruit fruit = (Fruit) moveDest.getItem();
				snake.addGrowth(fruit.getGrowAmount());
				fruit.move();
				snake.setNextLocation(moveDest);
				snake.move();
			}else {
				this.gameOver = true;
			}
		}else {
			snake.setNextLocation(moveDest);
			snake.move();
		}
		
	}

	public String display() {
		if(this.gameOver) {
			return "GAME OVER";
		}else {
			return board.toString();
		}
	}
	
}
