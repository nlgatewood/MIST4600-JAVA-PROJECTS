package games.war;

import java.util.*;
import games.GamesInterface;

/**
 * WarGame driver class.  Handles the cards game rules and the logic of the gameplay.  In card terms,
 * it acts as the 'dealer'
 * 
 * @author Nathaniel Gatewood 
 * @version 02/28/2017
 */
public class GameDriver implements GamesInterface{
	
    // instance variables
    private Dealer dealer;
    private Player player1;
    private Player player2;
    private GameProperties gameProperties;
    Scanner scan = new Scanner(System.in);
    int roundCnt;

	/*----------------------------------------------------------
	 * GameDriver(). CONSTRUCTOR
	 *----------------------------------------------------------*/
    public GameDriver(){
 
        dealer = new Dealer();
        gameProperties = new GameProperties();
        roundCnt = 0;
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
        
        dealer.shuffleDeck(3);     				//Shuffle the game deck
        dealer.dealCards(player1, player2);     //Deal the cards out to each player
        
        playGame();
    }
    
	/*----------------------------------------------------------
	 * playGame(). Begin a game of war.
	 *----------------------------------------------------------*/
    private void playGame(){
    	
        Player winner = null;
        String userInput = " ";
        
        do{
            userInput = userInput.toLowerCase();
            
            //Display Score with userinput of 's'
            if(userInput.equals("s")){
            	
                System.out.println("\nGame Score:\n"+
                                    player1.getName()+"(P1): "+player1.getDeckSize()+"    "+player2.getName()+"(P2): "+
                                    player2.getDeckSize()+"\n");
            }
            //Play another round with user input of 'd'
            else if(userInput.equals("")){
                
                playRound(); //Play a round of War!
                
                int player1Score = player1.getDeckSize();
                int player2Score = player2.getDeckSize();
            
                //Check to see if anyone has won the game
                if(player1Score == 0 || player2Score == 0){
                	
                	winner = (player1Score > 0) ? player1 : player2;
                	
                    System.out.println("\n"+winner.getName()+" wins the game!");
                }
            }
           
            //Get user input to quit or continue to the next round
            if(winner == null){
            	
                System.out.print("[Draw([Enter]), View Score(s), or Quit(q)> ");
                userInput = scan.nextLine();
            }
    
        } while(winner == null && !userInput.equals("q"));
        
        System.out.println("\nTHANKS FOR PLAYING WAR!  Have a nice day!");
    }
    
	/*----------------------------------------------------------
	 * playRound(). Play a round of War.  Each person draws a card.
	 * 			    The highest wins.
	 *----------------------------------------------------------*/
    private void playRound(){
    	
        //Create a round deck to hold the cards the winner will take
        CardDeck roundDeck = new CardDeck();
        roundCnt++;
        
        //Get Player1's deck and set their variables
        int player1Rank = 0;
        Card player1Card = player1.drawCard();
        player1Rank = gameProperties.getCardRank(player1Card);
        
        //Get player2's deck and set their variables
        int player2Rank = 0;
        Card player2Card = player2.drawCard();
        player2Rank = gameProperties.getCardRank(player2Card);
        
        //Add the two cards to the round's deck
        roundDeck.addCard(player1Card);
        roundDeck.addCard(player2Card);
        
        //Print out the card draw message
        System.out.println("\n==============================================================\nRound "+ roundCnt+"\n");
        System.out.println(player1.getName()+ getDrawMessage(player1Card, player1Rank));
        System.out.println(player2.getName()+ getDrawMessage(player2Card, player2Rank)+"\n");
        
        //If both cards have the same rank, go to war!
        if(player1Rank == player2Rank){
        	
            System.out.println("You drew cards with the same rank!  This is War!\n");
            
            do{
                //Get player 1 cards, rank, and add to roundDeck
                roundDeck.addCard(player1.drawCard()); // burn card
                player1Card = player1.drawCard();
                player1Rank = gameProperties.getCardRank(player1Card);
                roundDeck.addCard(player1Card);
                
                //Get player 2 cards, rank, and add to roundDeck
                roundDeck.addCard(player2.drawCard()); // burn card
                player2Card = player2.drawCard();
                player2Rank = gameProperties.getCardRank(player2Card);
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
            	
                player1.addCard(roundCard);    
            }
        }
        //If Player 2 wins the round, add the round's deck to their deck
        else if(player1Rank < player2Rank){
        	
            System.out.println(player2.getName()+"(P2) wins the round!");
            
            for(Card roundCard : roundDeck.getDeck()){
            	
                player2.addCard(roundCard);    
            }
        }
        
        System.out.println("--------------------------------------------------------------");
    }
    
	/*----------------------------------------------------------
	 * getDrawMessage(Card playerCard, int cardRank). Get the 
	 * 				  		specified card's game rank.  If a
	 * 				  		null card is passed, keep the rank at 0
	 *----------------------------------------------------------*/
    private static String getDrawMessage(Card playerCard, int cardRank){
    	
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
}
