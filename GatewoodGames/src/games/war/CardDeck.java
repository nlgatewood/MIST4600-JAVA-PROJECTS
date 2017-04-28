package games.war;

import java.util.*;

/**
 * Write a description of class CardDeck here.
 * 
 * @author Nathaniel Gatewood
 * @version 02/28/2017
 */
public class CardDeck{
	
    // instance variables - replace the example below with your own
    private ArrayList<Card> deck;
    private ArrayList<String> faces;
    private ArrayList<String> suits;

	/*----------------------------------------------------------
	 * Constructor
	 *----------------------------------------------------------*/
    public CardDeck(){
    	
        //Initialize and populate the faces array
        faces = new ArrayList<String>();
        suits = new ArrayList<String>();
        deck = new ArrayList<Card>();
    }
    
	/*----------------------------------------------------------
	 * buildDeck()
	 *----------------------------------------------------------*/
    public void buildDeck(){
    	
        //Initialize and populate the faces array
        faces.add("Two");
        faces.add("Three");
        faces.add("Four");
        faces.add("Five");
        faces.add("Six");
        faces.add("Seven");
        faces.add("Eight");
        faces.add("Nine");
        faces.add("Ten");
        faces.add("Jack");
        faces.add("Queen");
        faces.add("King");
        faces.add("Ace");
        
        //Initialize and populate the suits array
        suits.add("Spades");
        suits.add("Hearts");
        suits.add("Clubs");
        suits.add("Diamonds");
        
        //Create the card deck.  Loop through suits
        for(int sIndex=0; sIndex < suits.size(); sIndex++){
        	
            //Loop through faces
            for(int fIndex=0; fIndex < faces.size(); fIndex++){
            	
                //Add the new card to the deck
                deck.add(new Card(suits.get(sIndex), faces.get(fIndex)));
            }
        }
    }
    
	/*----------------------------------------------------------
	 * getDeck(). Return the deck Arraylist
	 *----------------------------------------------------------*/
    public ArrayList<Card> getDeck(){
    	
        return deck;
    }
    
	/*----------------------------------------------------------
	 * addCard(Card pCard). Add a card to the end of the Deck
	 *----------------------------------------------------------*/
    public void addCard(Card pCard){
    	
        if(deck.size() == 0){
        	
            deck.add(pCard);
        }
        else if(pCard != null){
            
            deck.add(0,pCard);
        }
    }
    
	/*----------------------------------------------------------
	 * drawCard(). Draw a card from the top of the deck (highest index)
	 *----------------------------------------------------------*/
    public Card drawCard(){
    	
        Card selCard = null;
        int deckSize = deck.size();
        
        //If there's a card to draw, draw it
        if(deckSize > 0){
            
            int cardIndex = deckSize-1;
            selCard = deck.get(cardIndex);
            
            deck.remove(cardIndex);
        }
            
        return selCard;
    }
    
	/*----------------------------------------------------------
	 * getCardByIndex(int index). Returns the card of the specified index
	 *----------------------------------------------------------*/
    public Card getCardByIndex(int index){
    	
    	Card thisCard = deck.get(index);
    	deck.remove(index);
    	
        return thisCard;
    }
    
	/*----------------------------------------------------------
	 * getDeckSize(). Returns the size of the deck
	 *----------------------------------------------------------*/
    public int getDeckSize(){
    	
        return deck.size();    
    }
    
	/*----------------------------------------------------------
	 * printDeck(). Print all the cards in the deck
	 *----------------------------------------------------------*/
    public void printDeck(){
    	
        for(Card card : deck){
        	
            card.printCard();
        }
    }
}
