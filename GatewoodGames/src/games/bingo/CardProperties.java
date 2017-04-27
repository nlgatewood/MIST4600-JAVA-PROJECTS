package games.bingo;

import java.util.ArrayList;
import java.util.HashMap;

public class CardProperties {

    private ArrayList<String> cardLetters;
    private HashMap<String, Integer> letterMin;
    private HashMap<String, Integer> letterMax;
    
	/*----------------------------------------------------------
	 * Constructor
	 *----------------------------------------------------------*/
	public CardProperties(){
		
        cardLetters = new ArrayList<String>();
        cardLetters.add("B");
        cardLetters.add("I");
        cardLetters.add("N");
        cardLetters.add("G");
        cardLetters.add("O");
        
        letterMin = new HashMap<String, Integer>();
        letterMax = new HashMap<String, Integer>();
        int min = 1;
        int max = 15;
        
        for(String letter : cardLetters){
    		
            letterMin.put(letter, min);
            letterMax.put(letter, max);
            
            min += 15;
            max += 15;
        }
	}
	
	/*----------------------------------------------------------
	 * getCardLetters()
	 *----------------------------------------------------------*/
	public ArrayList<String> getCardLetters(){
		
		return cardLetters;
	}
	
	/*----------------------------------------------------------
	 * getLetterMin()
	 *----------------------------------------------------------*/
	public int getLetterMin(String letter){
		
		return letterMin.get(letter);
	}
	
	/*----------------------------------------------------------
	 * getLetterMax()
	 *----------------------------------------------------------*/
	public int getLetterMax(String letter){
		
		return letterMax.get(letter);
	}
}
