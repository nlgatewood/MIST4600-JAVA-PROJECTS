package games.war;

import java.util.*;

/**
 * Write a description of class Card here.
 * 
 * @author Nathaniel Gatewood
 * @version 02/28/2017
 */
public class Card
{
    // instance variables - replace the example below with your own
    private String suit;
    private String face;

    /**
     * Constructor for objects of class Card
     */
    public Card(String pSuit, String pFace)
    {
        suit = pSuit;
        face = pFace;
    }
    
    /**
     * .getSuit().
     * Return the value in the instance variable 'suit'
     */
    public String getSuit()
    {
        return suit;
    }
    
    /**
     * .getFace().
     * Return the value in the instance variable 'face'
     */
    public String getFace()
    {
        return face;
    }
    
    /**
     * .printCard().
     * Print the face and the suit of the card
     */
    public void printCard()
    {
        System.out.println(face+" of "+suit);
    }
}
