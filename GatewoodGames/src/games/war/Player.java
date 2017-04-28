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
    
	/*----------------------------------------------------------
	 * drawCard(). Draw a card from the player's deck
	 *----------------------------------------------------------*/
    public Card drawCard(){
    	
        Card selCard = null;
        int deckSize = playerDeck.getDeckSize();
        
        //If there's a card to draw, draw it
        if(deckSize > 0){
            
            int cardIndex = deckSize-1;
            selCard = playerDeck.getCardByIndex(cardIndex);
        }
            
        return selCard;
    }
    
	/*----------------------------------------------------------
	 * addCard(). Add a card to a player's deck
	 *----------------------------------------------------------*/
    public void addCard(Card pCard){
    	
    	playerDeck.addCard(pCard);
    }
    
	/*----------------------------------------------------------
	 * getDeckSize(). Return the player's deck size
	 *----------------------------------------------------------*/
    public int getDeckSize(){
    	
    	return playerDeck.getDeckSize();
    }
}