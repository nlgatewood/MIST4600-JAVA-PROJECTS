package games.war;

import java.util.HashMap;

/**
 * Write a description of class CardDeck here.
 * 
 * @author Nathaniel Gatewood
 * @version 02/28/2017
 */
public class GameProperties {
	
    private HashMap<String,Integer> cardRanks;
    
	/*----------------------------------------------------------
	 * CardProperties(). CONSTRUCTOR
	 *----------------------------------------------------------*/
    public GameProperties(){
    	
        // initialise the Card Ranks.  Used to score each players draw
        cardRanks = new HashMap<String,Integer>();
        cardRanks.put("Two", 1);
        cardRanks.put("Three", 2);
        cardRanks.put("Four", 3);
        cardRanks.put("Five", 4);
        cardRanks.put("Six", 5);
        cardRanks.put("Seven", 6);
        cardRanks.put("Eight", 7);
        cardRanks.put("Nine", 8);
        cardRanks.put("Ten", 9);
        cardRanks.put("Jack", 10);
        cardRanks.put("Queen", 11);
        cardRanks.put("King", 12);
        cardRanks.put("Ace", 13);
    }
    
	/*----------------------------------------------------------
	 * getCardRank(). Get the specified card's game rank.  If a
	 * 				  null card is passed, keep the rank at 0
	 *----------------------------------------------------------*/
    public int getCardRank(Card playerCard){
    	
        return ( (playerCard != null) ? cardRanks.get(playerCard.getFace()) : 0 );
    }
}
