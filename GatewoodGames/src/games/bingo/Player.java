package games.bingo;

public class Player {
	
	private String playerName;
	private GameCard playerGameCard;
	private CardProperties cardProperties;
	
	/*----------------------------------------------------------
	 * Constructor
	 *----------------------------------------------------------*/
	public Player(String playerName){
	
		this.playerName = playerName;
		playerGameCard = new GameCard();
		cardProperties = new CardProperties();
	}
	
	/*----------------------------------------------------------
	 * getPlayerName()
	 *----------------------------------------------------------*/
	public String getPlayerName(){
		
		return playerName;
	}
	
	/*----------------------------------------------------------
	 * setPlayerGameCard()
	 *----------------------------------------------------------*/
	public void setPlayerGameCard(GameCard playerGameCard){
		
		this.playerGameCard = playerGameCard;
	}
	
	/*----------------------------------------------------------
	 * getPlayerGameCard()
	 *----------------------------------------------------------*/
	public GameCard getPlayerGameCard(){
		
		return playerGameCard;
	}

	/*----------------------------------------------------------
	 * markSquare()
	 *----------------------------------------------------------*/
	public void markSquare(String calledSquare){
		
		String thisLetter = calledSquare.substring(0,1);
		int thisNumber = Integer.parseInt(calledSquare.substring(1));
		
		for(CardNumber cardNumber : playerGameCard.getCardRowByLetter(thisLetter)){
			
			if(thisNumber == cardNumber.getCardNumber()){

				cardNumber.setIsCalled();
				break;
			}
		}
	}
	/*----------------------------------------------------------
	 * checkGameCard()
	 *----------------------------------------------------------*/
	public boolean checkGameCard(){
	
    	boolean isAllCalled = true;
    	
		// Check Vertical
    	//----------------
        for(String letter : cardProperties.getCardLetters()){
        	
        	isAllCalled = true;
        	
        	//Loop through each vertical row
        	for(int i=0; i<5; i++){
        		
        		if(!playerGameCard.getCardRowByLetter(letter).get(i).isCalled()){
        			
        			isAllCalled = false;
        			break;
        		}
        	}
        	
        	//break the loop if the row has been called
    		if(isAllCalled){
    			break;
    		}
        }
        
        // Check Horizontal
        //------------------
        if(!isAllCalled){
        	
        	for(int i=0; i<5; i++){
        		
            	isAllCalled = true;
            	
            	//Loop through each horizontal row
                for(String letter : cardProperties.getCardLetters()){
            		
            		if(!playerGameCard.getCardRowByLetter(letter).get(i).isCalled()){
            			
            			isAllCalled = false;
            			break;
            		}
            	}
            	
            	//break the loop if the row has been called
        		if(isAllCalled){
        			break;
        		}
            }
        }
        
        // Check Diagnonal-Foreward
        //----------------
        if(!isAllCalled){
        	
        	int[] indexList = {0,-4};
        	
        	for(int i=0; i<indexList.length; i++){
        		
            	isAllCalled = true;
        		int index = indexList[i];
        		
        		for(String letter : cardProperties.getCardLetters()){
            
        			if(!playerGameCard.getCardRowByLetter(letter).get(Math.abs(index)).isCalled()){
        			
        				isAllCalled = false;
        				break;
        			}
            	
        			index++;
        		}
        	}
        }
        
		return isAllCalled;
	}
	
	/*----------------------------------------------------------
	 * printGameCard()
	 *----------------------------------------------------------*/
	public void printGameCard(){
		
		System.out.println("\n"+getPlayerName());
		playerGameCard.printCard();
	}
}
