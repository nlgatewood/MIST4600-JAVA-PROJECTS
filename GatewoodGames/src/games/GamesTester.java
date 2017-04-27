package games;

import games.bingo.Bingo;
import games.war.War;

public class GamesTester {

	public static void main(String[] args) {

		//GamesInterface game = new Bingo();
		//game.startGame();
		
		GamesInterface game = new War();
		game.startGame();
	}

}
