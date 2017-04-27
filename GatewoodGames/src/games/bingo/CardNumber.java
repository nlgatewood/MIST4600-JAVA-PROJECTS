package games.bingo;

public class CardNumber {
	
	private int number;
	private boolean isCalled;
	
	/*----------------------------------------------------------
	 * Constructor
	 *----------------------------------------------------------*/
	public CardNumber(){
		
		number = -1;
		isCalled = false;
	}
	
	/*----------------------------------------------------------
	 * setCardNumber()
	 *----------------------------------------------------------*/
	public void setCardNumber(int number){
		
		this.number = number;
	}
	
	/*----------------------------------------------------------
	 * getCardNumber()
	 *----------------------------------------------------------*/
	public int getCardNumber(){
		
		return number;
	}
	
	/*----------------------------------------------------------
	 * setIsCalled()
	 *----------------------------------------------------------*/
	public void setIsCalled(){
		
		isCalled = true;
	}
	
	/*----------------------------------------------------------
	 * isCalled()
	 *----------------------------------------------------------*/
	public boolean isCalled(){
		
		return isCalled;
	}
}
