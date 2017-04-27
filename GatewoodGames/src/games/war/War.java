package games.war;

import games.GamesInterface;
import java.util.*;

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

    /**
     * Constructor for objects of class WarGame
     */
    public War()
    {
        
    }
    
    /**
     * .startGame().
     * Begin a game of War!
     */
    public void startGame()
    {
      
        System.out.println("<========================================>\n"+
                           " ########################################\n"+
                           "                                         \n"+
                           "                    WAR!                 \n"+
                           "                                         \n"+
                           "          By: Nathaniel Gatewood         \n"+
                           "                                         \n"+
                           " ########################################\n"+
                           "<========================================>\n"
                           );
        

        gameDriver = new GameDriver(); //Create a new Game object
        
        gameDriver.addPlayers();       //Add the players who are playing
        gameDriver.shuffleDeck(3);     //Shuffle the game deck
        gameDriver.dealCards();        //Deal the cards out to each player
        
        //Play game
        gameDriver.playGame();
    }
}
