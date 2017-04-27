package games.war;

import java.util.*;

/**
 * Write a description of class CardDeck here.
 * 
 * @author Nathaniel Gatewood
 * @version 02/28/2017
 */
public class CardDeck
{
    // instance variables - replace the example below with your own
    private ArrayList<Card> deck;
    private ArrayList<String> faces;
    private ArrayList<String> suits;

    /**
     * Constructor for objects of class CardDeck
     */
    public CardDeck()
    {
        //Initialize and populate the faces array
        faces = new ArrayList<String>();
        suits = new ArrayList<String>();
        deck = new ArrayList<Card>();
    }
    
    /**
     * .buildDeck().
     * Create a standard deck of 52 cards and shuffle it twice
     */
    public void buildDeck()
    {
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
        for(int sIndex=0; sIndex < suits.size(); sIndex++)
        {
            //Loop through faces
            for(int fIndex=0; fIndex < faces.size(); fIndex++)
            {
                //Add the new card to the deck
                deck.add(new Card(suits.get(sIndex), faces.get(fIndex)));
            }
        }
    }
    
    /**
     * .shuffleDeck(int times).
     * Shuffle the main game deck a specified number of times
     */
    public void shuffleDeck(int times)
    {
        ArrayList<Card> tempDeck;
        Random rand = new Random();
        
        //Shuffle however many times was specified
        for(int cnt=0; cnt<times; cnt++)
        {
            int cardCnt = getSize();
            //tempDeck = new CardDeck();
            tempDeck = new ArrayList<Card>();
            
            //Loop through the deck and randomly select cards.  Add to the temp deck
            for(int i=0; i<cardCnt; i++)
            {
                int  randN = rand.nextInt(getSize());
                
                tempDeck.add(getCardByIndex(randN));
                removeCardByIndex(randN);
            }
            
            //Add the randomized cards back to the main deck
            cardCnt = tempDeck.size();
            
            for(int x=0; x<cardCnt; x++)
            {
                addCard(tempDeck.get(x));    
            }
        }

        System.out.println("\nShuffled deck "+times+" times.\n");
    }
    
    /**
     * .getDeck().
     * Return the deck Arraylist
     */
    public ArrayList<Card> getDeck()
    {
        return deck;
    }
    
    /**
     * .drawCard().
     * Draw a card from the top of the deck (highest index)
     */
    public Card drawCard()
    {
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
    
    /**
     * .addCard(Card pCard).
     * Add a card to the end of the Deck
     */
    public void addCard(Card pCard)
    {
        if(deck.size() == 0)
        {
            deck.add(pCard);
        }
        else if(pCard != null){
            
            deck.add(0,pCard);
        }
    }
    
    /**
     * .getCardByIndex(int index).
     * Returns the card of the specified index
     */
    public Card getCardByIndex(int index)
    {
        return deck.get(index);
    }
    
    /**
     * .removeCardByIndex(int index).
     * Removes the card of the specified index
     */
    public void removeCardByIndex(int index)
    {
        deck.remove(index);    
    }
    
    /**
     * .getSize().
     * Returns the size of the deck
     */
    public int getSize()
    {
        return deck.size();    
    }
    
    /**
     * .printDeck().
     * Print all the cards in the deck
     */
    public void printDeck()
    {
        for(Card card : deck)
        {
            card.printCard();
        }
    }
}
