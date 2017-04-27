package games.bingo;

import java.util.*;

public class Caller {

	private ArrayList<String> calledSquares;
	private CardProperties cardProperties;
	
	/*----------------------------------------------------------
	 * Constructor
	 *----------------------------------------------------------*/
	public Caller(){
		
		calledSquares = new ArrayList<String>();
		cardProperties = new CardProperties();
	}
	
	/*----------------------------------------------------------
	 * generateCallerNumber()
	 *----------------------------------------------------------*/
	public String generateCallerNumber(){
		
		Random rand = new Random();
		ArrayList<String> cardLetters = cardProperties.getCardLetters();
		String thisSquare = null;
		boolean alreadyCalled;
		
		do{
			//Get a random letter
			alreadyCalled = false;
			int randLetterN = rand.nextInt(cardLetters.size());
			thisSquare = cardLetters.get(randLetterN);
		
			//get a random number
			thisSquare += rand.nextInt( (cardProperties.getLetterMax(thisSquare)-cardProperties.getLetterMin(thisSquare)) )
					      +cardProperties.getLetterMin(thisSquare);
			
			//Check to see if the square has already been called
			for(String square : calledSquares){
			
				if(thisSquare.equals(square)){
				
					alreadyCalled = true;
					break;
				}
			}
			
		}while(alreadyCalled == true);
		
		System.out.println("And the number is..."+thisSquare+"!");
		
		//Add square to the list, return the square
		calledSquares.add(thisSquare);
		return thisSquare;
	}
}
