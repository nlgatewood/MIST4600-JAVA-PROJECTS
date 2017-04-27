package games.war;

/**
 * Write a description of class Player here.
 * 
 * @author Nathaniel Gatewood
 * @version 02/28/2017
 */
public class Player{
	
    // instance variables - replace the example below with your own
    private CardDeck playerDeck;
    private String playerName;

	/*----------------------------------------------------------
	 * Player(String pName). CONSTRUCTOR
	 *----------------------------------------------------------*/
    public Player(String pName){
    	
        playerDeck = new CardDeck();
        playerName = pName;
    }
    
	/*----------------------------------------------------------
	 * getName(). Get the player's name
	 *----------------------------------------------------------*/
    public String getName(){
    	
        return playerName;    
    }
    
	/*----------------------------------------------------------
	 * getDeck(). Returns a player's deck
	 *----------------------------------------------------------*/
    public CardDeck getDeck(){
    	
        return playerDeck;
    }
}