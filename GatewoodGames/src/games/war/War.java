package games.war;

import games.GamesInterface;

/**
 * Write a description of class WarGame here.
 * 
 * @author Nathaniel Gatewood
 * @version 02/28/2017
 */
public class War implements GamesInterface{
	
	private GameDriver warGame;
	
	/*----------------------------------------------------------
	 * War(). CONSTRUCTOR
	 *----------------------------------------------------------*/
    public War(){
    	
    	warGame = new GameDriver();
    }
    
	/*----------------------------------------------------------
	 * startGame().. Begin a game of War!
	 *----------------------------------------------------------*/
    public void startGame()
    {
        //Play game
        warGame.startGame();
    }
}
