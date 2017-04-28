package games;

import java.util.InputMismatchException;
import java.util.Scanner;
import games.war.War;
import games.bingo.Bingo;

public class GamesTester {

	public static void main(String[] args) {
		
		GamesInterface game;
		boolean quitGames = false;
		Scanner input = new Scanner(System.in);
		int userInput = -1;
		
		printGameHeading();
		
		do{
			System.out.print("\n" +
							 "  Menu\n"+
							 "---------\n"+
							 " 1. Bingo\n" +
							 " 2. War!\n" +
							 " 9. Quit\n\n" +
				   	     	"Select your choice: ");

			try{
				userInput = input.nextInt();
				
			}catch(InputMismatchException e){
				
				input.nextLine();
			}
				
			switch(userInput){
				case 1: 
					game = new Bingo();
					game.startGame();
					printGameHeading();
					break;
				case 2:
					game = new War();
					game.startGame();
					printGameHeading();
				case 9:
					quitGames = true;
					break;
				default:
					System.out.println("Invalid Choice");
					break;
			}
			
		}while(!quitGames);
		
		System.out.println("Thank you for playing!  Goodbye!");
	}
	
	/*----------------------------------------------------------
	 * printGameHeading() -- Print's the game heading
	 *----------------------------------------------------------*/
	private static void printGameHeading(){
		
		System.out.println("\n--------------------------------------\n" +
	     		   		   "     Welcome to Gatewood games!\n"+
	     		   		   "--------------------------------------");
	}
}
