package games;

import games.bingo.Bingo;

public class GamesTester {

	public static void main(String[] args) {

		GamesInterface game = new Bingo();
		
		game.startGame();
	}

}
