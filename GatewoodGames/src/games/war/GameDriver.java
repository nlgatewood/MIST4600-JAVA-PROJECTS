package games.war;

import java.util.*;

/**
 * WarGame driver class.  Handles the cards game rules and the logic of the gameplay.  In card terms,
 * it acts as the 'dealer'
 * 
 * @author Nathaniel Gatewood 
 * @version 02/28/2017
 */
public class GameDriver{
	
    // instance variables
    private CardDeck deck;
    private Player player1;
    private Player player2;
    private HashMap<String,Integer> cardRanks;
    Scanner scan = new Scanner(System.in);
    int roundCnt;

	/*----------------------------------------------------------
	 * GameDriver(). CONSTRUCTOR
	 *----------------------------------------------------------*/
    public GameDriver(){
    	
        deck = new CardDeck();
        deck.buildDeck();
        roundCnt = 0;
        
        // initialise the Card Ranks.  Used to score each players draw
        cardRanks = new HashMap<String,Integer>();
        cardRanks.put("Two", 1);
        cardRanks.put("Three", 2);
        cardRanks.put("Four", 3);
        cardRanks.put("Five", 4);
        cardRanks.put("Six", 5);
        cardRanks.put("Seven", 6);
        cardRanks.put("Eight", 7);
        cardRanks.put("Nine", 8);
        cardRanks.put("Ten", 9);
        cardRanks.put("Jack", 10);
        cardRanks.put("Queen", 11);
        cardRanks.put("King", 12);
        cardRanks.put("Ace", 13);
    }
    
	/*----------------------------------------------------------
	 * startGame(). Begin a game of war.
	 *----------------------------------------------------------*/
    public void startGame(){
    	
        System.out.println("<========================================>\n"+
                " ########################################\n"+
                "                                         \n"+
                "                    WAR!                 \n"+
                "                                         \n"+
                "          By: Nathaniel Gatewood         \n"+
                "                                         \n"+
                " ########################################\n"+
                "<========================================>\n");
        
        String playerName = null;
        
        //Add player1
        System.out.print("Enter name for Player 1: ");
        playerName = scan.nextLine();
        player1 = new Player(playerName);
            
        //Add player2
        System.out.print("Enter name for Player 2: ");
        playerName = scan.nextLine();
        player2 = new Player(playerName);
        
        shuffleDeck(3);     //Shuffle the game deck
        dealCards();        //Deal the cards out to each player
        
        playGame();
    }
    
	/*----------------------------------------------------------
	 * playGame(). Begin a game of war.
	 *----------------------------------------------------------*/
    public  void playGame(){
    	
        CardDeck player1Deck = player1.getDeck();
        CardDeck player2Deck = player2.getDeck();
        boolean winFlag = false;
        String userInput = " ";
        
        do{
            userInput = userInput.toLowerCase();
            
            //Display Score with userinput of 's'
            if(userInput.equals("s")){
            	
                System.out.println("\nGame Score:\n"+
                                    player1.getName()+"(P1): "+player1Deck.getSize()+"    "+player2.getName()+"(P2): "+
                                    player2Deck.getSize()+"\n");
            }
            //Play another round with user input of 'd'
            else if(userInput.equals("")){
            	
                roundCnt++;
                System.out.println("\n==============================================================\nRound "+ roundCnt+"\n");
            
                //Play a round of War!
                playRound();
            
                //Check to see if anyone has won the game
                if(getScore(1) == 0 || getScore(2) == 0){
                	
                    String winner = null;
                
                    //If player 1s score is > 0, they win
                    if(getScore(1) > 0){
                    	
                        winner = player1.getName()+"(P1)";
                    }
                    else if(getScore(2) > 0){
                    	
                        winner = player2.getName()+"(P2)";
                    }
                
                    System.out.println("\n"+winner+" wins the game!");
                    winFlag = true;
                }
            }
           
            //Get user input to quit or continue to the next round
            if(!winFlag){
            	
                System.out.print("[Draw([Enter]), View Score(s), or Quit(q)> ");
                userInput = scan.nextLine();
            }
    
        } while(!winFlag && !userInput.equals("q"));
        
        System.out.println("\nTHANKS FOR PLAYING WAR!  Have a nice day!");
    }
    
	/*----------------------------------------------------------
	 * playRound(). Play a round of War.  Each person draws a card.
	 * 			    The highest wins.
	 *----------------------------------------------------------*/
    public void playRound(){
    	
        //Create a round deck to hold the cards the winner will take
        CardDeck roundDeck = new CardDeck();
        
        //Get Player1's deck and set their variables
        int player1Rank = 0;
        CardDeck player1Deck = player1.getDeck();
        Card player1Card = null;
        
        //Get player2's deck and set their variables
        int player2Rank = 0;
        CardDeck player2Deck = player2.getDeck();
        Card player2Card = null;
        
        //Draw the cards and obtain their rank
        player1Card = player1Deck.drawCard();
        player2Card = player2Deck.drawCard();
        player1Rank = getCardRank(player1Card);
        player2Rank = getCardRank(player2Card);
        
        //Add the two cards to the round's deck
        roundDeck.addCard(player1Card);
        roundDeck.addCard(player2Card);
        
        //Print out the card draw message
        System.out.println(player1.getName()+ getDrawMessage(player1Card, player1Rank));
        System.out.println(player2.getName()+ getDrawMessage(player2Card, player2Rank)+"\n");
        
        //If both cards have the same rank, go to war!
        if(player1Rank == player2Rank){
        	
            System.out.println("You drew cards with the same rank!  This is War!\n");
            
            do{
                //Get player 1 cards, rank, and add to roundDeck
                roundDeck.addCard(player1Deck.drawCard()); // burn card
                player1Card = player1Deck.drawCard();
                player1Rank = getCardRank(player1Card);
                roundDeck.addCard(player1Card);
                
                //Get player 2 cards, rank, and add to roundDeck
                roundDeck.addCard(player2Deck.drawCard()); // burn card
                player2Card = player2Deck.drawCard();
                player2Rank = getCardRank(player2Card);
                roundDeck.addCard(player2Card);
                
                //Print out the card draw message
                System.out.println("**Burn Card**\n"+player1.getName()+ getDrawMessage(player1Card, player1Rank));
                System.out.println("**Burn Card**\n"+player2.getName()+ getDrawMessage(player2Card, player2Rank)+"\n");
                
            }while(player1Rank == player2Rank);
        }
        
        //If player 1 wins the round, add the round's deck to their deck
        if(player1Rank > player2Rank){
        
            System.out.println(player1.getName()+"(P1) wins the round!");
            
            for(Card roundCard : roundDeck.getDeck()){
            	
                player1Deck.addCard(roundCard);    
            }
            
        }
        //If Player 2 wins the round, add the round's deck to their deck
        else if(player1Rank < player2Rank){
        	
            System.out.println(player2.getName()+"(P2) wins the round!");
            
            for(Card roundCard : roundDeck.getDeck()){
            	
                player2Deck.addCard(roundCard);    
            }
        }
        
        System.out.println("--------------------------------------------------------------");
    }
    
	/*----------------------------------------------------------
	 * shuffleDeck(int times). Shuffle the main game deck a 
	 * 						   specified number of times
	 *----------------------------------------------------------*/
    public void shuffleDeck(int times){
    	
       deck.shuffleDeck(times);
    }
    
	/*----------------------------------------------------------
	 * dealCards(). Deal out the cards to each of the players. 
	 * 				Each player should get 26 cards each
	 *----------------------------------------------------------*/
    public void dealCards(){
    	
        int deckSize = deck.getSize();
        
        for(int i=0; i<deckSize; i++){
        	
            Card nextCard = deck.drawCard();
            
            //Give player1 even cards
            if(i%2 == 0){
            	
                player1.getDeck().addCard(nextCard);    
            }
            //Give player2 odd cards
            else{
            	
               player2.getDeck().addCard(nextCard);   
            }
        }
    }
    
	/*----------------------------------------------------------
	 * getCardRank(). Get the specified card's game rank.  If a
	 * 				  null card is passed, keep the rank at 0
	 *----------------------------------------------------------*/
    public int getCardRank(Card playerCard){
    	
        return ( (playerCard != null) ? cardRanks.get(playerCard.getFace()) : 0 );
    }
    
	/*----------------------------------------------------------
	 * getDrawMessage(Card playerCard, int cardRank). Get the 
	 * 				  		specified card's game rank.  If a
	 * 				  		null card is passed, keep the rank at 0
	 *----------------------------------------------------------*/
    public String getDrawMessage(Card playerCard, int cardRank){
    	
        String playerMessage = "";
        
        //If no cards are left
        if(cardRank == 0){
        	
            playerMessage = " has no more cards left!";    
        }
        //Else, print out the card face and suit
        else{
            playerMessage = " Draws a "+playerCard.getFace()+" of "+playerCard.getSuit();
        }
        
        return playerMessage;
    }
    
	/*----------------------------------------------------------
	 * getScores(int playerNum). Get the score (card count) of the 
	 * 							 specified player
	 *----------------------------------------------------------*/
    public int getScore(int playerNum){
    	
        int score = -1;
        
        if(playerNum == 1){
        	
            score = player1.getDeck().getSize();
        }
        else if(playerNum == 2){
        	
            score = player2.getDeck().getSize();
        }
        
        return score;
    }
}
