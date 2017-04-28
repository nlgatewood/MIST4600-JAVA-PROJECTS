package games.war;

import java.util.ArrayList;
import java.util.Random;

/**
 * Write a description of class Player here.
 * 
 * @author Nathaniel Gatewood
 * @version 02/28/2017
 */
public class Dealer {
	
    private CardDeck gameDeck;

	/*----------------------------------------------------------
	 * Dealer(). CONSTRUCTOR
	 *----------------------------------------------------------*/
	public Dealer(){
		
		gameDeck = new CardDeck();
		gameDeck.buildDeck();
	}
	
	/*----------------------------------------------------------
	 * shuffleDeck(int times). Shuffle the main game deck a 
	 * 						   specified number of times
	 *----------------------------------------------------------*/
    public void shuffleDeck(int times){
    	
        ArrayList<Card> tempDeck;
        Random rand = new Random();
        
        //Shuffle however many times was specified
        for(int cnt=0; cnt<times; cnt++){
        	
            int cardCnt = gameDeck.getDeckSize();
            //tempDeck = new CardDeck();
            tempDeck = new ArrayList<Card>();
            
            //Loop through the deck and randomly select cards.  Add to the temp deck
            for(int i=0; i<cardCnt; i++){
            	
                int  randN = rand.nextInt(gameDeck.getDeckSize());
                
                tempDeck.add(gameDeck.getCardByIndex(randN));
            }
            
            //Add the randomized cards back to the main deck
            cardCnt = tempDeck.size();
            
            for(int x=0; x<cardCnt; x++){
            	
            	gameDeck.addCard(tempDeck.get(x));    
            }
        }

        System.out.println("\nShuffled deck "+times+" times.\n");
    }
    
	/*----------------------------------------------------------
	 * dealCards(). Deal out the cards to each of the players. 
	 * 				Each player should get 26 cards each
	 *----------------------------------------------------------*/
    public void dealCards(Player player1, Player player2){
    	
        int deckSize = gameDeck.getDeckSize();
        
        for(int i=0; i<deckSize; i++){
        	
            Card nextCard = gameDeck.drawCard();
            
            //Give player1 even cards
            if(i%2 == 0){
            	
                player1.addCard(nextCard);    
            }
            //Give player2 odd cards
            else{
            	
               player2.addCard(nextCard);   
            }
        }
    }
}
