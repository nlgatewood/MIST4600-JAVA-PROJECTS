package games.bingo;

import java.util.*;
import java.util.Scanner;

public class GameDriver {
	
	private ArrayList<Player> players;
	private NPCPlayers npcPlayers;
	private Caller caller;
	private Scanner input;
	
	/*----------------------------------------------------------
	 * Constructor
	 *----------------------------------------------------------*/
	public GameDriver(){
		
		npcPlayers = new NPCPlayers();
		caller = new Caller();
		input = new Scanner(System.in);
	}

	/*----------------------------------------------------------
	 * startGame()
	 *----------------------------------------------------------*/
	public void startGame(){
		
		String playerName = null;
		
		//Get the player's name
		System.out.println("Welcome to bingo!");
		System.out.print("Enter your name: ");
		playerName = input.nextLine();
		
		System.out.print("How many do you want to play against?: ");
		int numberPlayers = input.nextInt();
		
		//Get the npc players, add to players array
		players = npcPlayers.getNPCPlayers(numberPlayers);
		players.add(new Player(playerName));
		
		//Create a new gamecard for each of the players
		for(Player thisPlayer : players){
			
			thisPlayer.setPlayerGameCard(new GameCard());
		}
		
		//play game
		play();
	}
	
	/*----------------------------------------------------------
	 * play()
	 *----------------------------------------------------------*/
	private void play(){
		
		ArrayList<Player> winners = new ArrayList<Player>();
		String userInput = null;
		boolean quitGame = false;
		
		printPlayerCards();
		
		do{
			System.out.println("Next([n]) or Quit(q)>");
			userInput = input.next().toLowerCase();
			
			//Next round
			if(userInput.equals("n")){
				
				//generate a called number
				String calledSquare = caller.generateCallerNumber();

				//Loop through each player, mark squares, check cards, print
				for(Player thisPlayer : players){
			
					thisPlayer.markSquare(calledSquare);
					boolean bingo = thisPlayer.checkGameCard();
					
					thisPlayer.printGameCard();
					
					//If a winner, add to the winner array
					if(bingo){
						
						winners.add(thisPlayer);
					}
				}
			}
			//Quit the game
			else if(userInput.equals("q")){
				
				quitGame = true;
			}
			//Invalid input
			else{
				System.out.println("Invalid input");
			}
			
		}while(!quitGame && winners.size() == 0);
		
		//Print out the winners
		for(Player thisWinner : winners){
			
			System.out.println("\nBINGO! "+thisWinner.getPlayerName()+" has gotten a Bingo!\n");
		}
		
		System.out.println("Thank you for playing Gatewood Bingo!");
	}
	
	/*----------------------------------------------------------
	 * printPlayerCards()
	 *----------------------------------------------------------*/
	private void printPlayerCards(){
		
		for(Player thisPlayer : players){
			
			System.out.println("\n"+thisPlayer.getPlayerName());
			thisPlayer.getPlayerGameCard().printCard();
		}
	}
}
