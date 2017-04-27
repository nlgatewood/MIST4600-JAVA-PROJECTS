package games.war;

import games.GamesInterface;

/**
 * Write a description of class WarGame here.
 * 
 * @author Nathaniel Gatewood
 * @version 02/28/2017
 */
public class War implements GamesInterface
{
    // instance variables - replace the example below with your own
    private GameDriver gameDriver;

	/*----------------------------------------------------------
	 * War(). CONSTRUCTOR
	 *----------------------------------------------------------*/
    public War(){
    	
        gameDriver = new GameDriver();
    }
    
	/*----------------------------------------------------------
	 * startGame().. Begin a game of War!
	 *----------------------------------------------------------*/
    public void startGame()
    {
        //Play game
        gameDriver.startGame();
    }
}
