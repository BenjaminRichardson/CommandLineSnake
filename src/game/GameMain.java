package game;

import java.util.Scanner;

public class GameMain {

	public static void main(String[] args) {
		SnakeGame sg = new SnakeGame();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Key:\tH = Snake Head\n"
							+ "\tS=Snake body\n"
							+ "\tR=Rock\n"
							+"\tA=Apple\n"
							+"\tB=Banana");
		System.out.println(sg.display());
		String input;
		while(true) {
			System.out.println("Type \"up\", \"down\", \"left\", or \"right\" to move snake.");
			input = scanner.nextLine();
			if(input.equalsIgnoreCase("up")) {
				sg.playerMove(SnakeGame.Move.UP);
			}else if(input.equalsIgnoreCase("down")){
				sg.playerMove(SnakeGame.Move.DOWN);
			}else if(input.equalsIgnoreCase("left")) {
				sg.playerMove(SnakeGame.Move.LEFT);
			}else if(input.equalsIgnoreCase("right")) {
				sg.playerMove(SnakeGame.Move.RIGHT);
			}else {
				continue;
			}
			
			System.out.println(sg.display());
			
			if(sg.gameOver) {
				System.out.println("NEW GAME");
				sg = new SnakeGame();
				System.out.println(sg.display());
			}
		}
	}
	
}
