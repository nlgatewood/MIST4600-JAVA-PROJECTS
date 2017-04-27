package games.bingo;

import java.util.*;

/**
 * 
 * @author ngate
 *
 */

public class GameCard {
	
	private CardProperties cardProperties;
	private LinkedHashMap<String, ArrayList<CardNumber>> gameCard;
	
	/*----------------------------------------------------------
	 * Constructor
	 *----------------------------------------------------------*/
	public GameCard(){
		
		Random rand = new Random();
		cardProperties = new CardProperties();
        gameCard = new LinkedHashMap<String, ArrayList<CardNumber>>();

        // Loop through each of the card letters: B I N G O
        for(String letter : cardProperties.getCardLetters()){
            
        	//Create and empty card
    		gameCard.put(letter, new ArrayList<CardNumber>());
            
            //Create a list of 5 numbers
            for(int i=0; i<5; i++){
                
                int randN;
                boolean numExists;
                CardNumber thisCardNumber = new CardNumber();
                

                // Check for existing numbers.  If it exists, re-run it again until you get one that doesn't
                do{
                    numExists = false;
                    randN = rand.nextInt( (cardProperties.getLetterMax(letter)-cardProperties.getLetterMin(letter)) )
                    					   +cardProperties.getLetterMin(letter);
                    
                    for(int x=0; x < gameCard.get(letter).size(); x++){
            
                        if(gameCard.get(letter).get(x).getCardNumber() == randN){

                            numExists = true;
                        }
                    }
                    
                }while(numExists == true);
 
                //Add the new number to the gameCard
                thisCardNumber.setCardNumber(randN);
                gameCard.get(letter).add(thisCardNumber);
            }
        }
	}
	
	/*----------------------------------------------------------
	 * getCardRowByLetter()
	 *----------------------------------------------------------*/
	public ArrayList<CardNumber> getCardRowByLetter(String thisLetter){
		
		return gameCard.get(thisLetter);
	}
	
	
	/*----------------------------------------------------------
	 * printCard()
	 *----------------------------------------------------------*/
    public void printCard(){
    	
    	ArrayList<String> cardLetters = cardProperties.getCardLetters();
    	System.out.println(" -----------------------");
    	System.out.print(" |");
    	
    	for(String letter : cardLetters){
    		
    		System.out.print(String.format("%1$4s", letter));
    	}
    	
    	System.out.println(" |");
    	System.out.println(" -----------------------");
    	
    	for(int i=0; i<5; i++){
    		
        	System.out.print(" |");
    		
    		for(String letter : cardLetters){
    			
    			String squareNumber = null;
    			
    			if(gameCard.get(letter).get(i).isCalled()){
    				
    				squareNumber = "X";
    			}
    			else{
    				squareNumber = Integer.toString(gameCard.get(letter).get(i).getCardNumber());
    			}
    			
    			System.out.print(String.format("%1$4s",squareNumber));
    		}
    		
        	System.out.println(" |");
    	}
    	
    	System.out.println(" -----------------------");
    }
}
