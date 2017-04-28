package games.war;

/**
 * Write a description of class Card here.
 * 
 * @author Nathaniel Gatewood
 * @version 02/28/2017
 */
public class Card{
	
    // instance variables - replace the example below with your own
    private String suit;
    private String face;

	/*----------------------------------------------------------
	 * Constructor
	 *----------------------------------------------------------*/
    public Card(String pSuit, String pFace){
    	
        suit = pSuit;
        face = pFace;
    }
    
	/*----------------------------------------------------------
	 * getSuit()
	 *----------------------------------------------------------*/
    public String getSuit(){
    	
        return suit;
    }
    
	/*----------------------------------------------------------
	 * getFace()
	 *----------------------------------------------------------*/
    public String getFace(){
    	
        return face;
    }
    
	/*----------------------------------------------------------
	 * printCard()
	 *----------------------------------------------------------*/
    public void printCard(){
    	
        System.out.println(face+" of "+suit);
    }
}
