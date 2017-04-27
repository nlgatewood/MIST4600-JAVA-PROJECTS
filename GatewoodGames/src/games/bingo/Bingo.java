package games.bingo;

import games.GamesInterface;

public class Bingo implements GamesInterface {

	/*----------------------------------------------------------
	 * Constructor
	 *----------------------------------------------------------*/
	public Bingo(){
		
	}
	
	/*----------------------------------------------------------
	 * startGame()
	 *----------------------------------------------------------*/
	public void startGame(){
		
		GameDriver bingo = new GameDriver();
		bingo.startGame();
	}
}
