package games.bingo;

import java.util.ArrayList;
import java.util.Random;

public class NPCPlayers {
	
	private ArrayList<Player> npcPlayers;
	
	/*----------------------------------------------------------
	 * Constructor
	 *----------------------------------------------------------*/
	public NPCPlayers(){
		
		npcPlayers = new ArrayList<Player>();
		npcPlayers.add(new Player("Katniss Everdeen"));
		npcPlayers.add(new Player("Sarah Conner"));
		npcPlayers.add(new Player("John Conner"));
		npcPlayers.add(new Player("Ellen Ripley"));
		npcPlayers.add(new Player("Anakin Skywalker"));
		npcPlayers.add(new Player("Han Solo"));
		npcPlayers.add(new Player("Spock"));
		npcPlayers.add(new Player("Marty McFly"));
		npcPlayers.add(new Player("Fox Mulder"));
		npcPlayers.add(new Player("Optimus Prime"));
	}

	/*----------------------------------------------------------
	 * getNPCPlayersNumber(int number)
	 *----------------------------------------------------------*/
	public ArrayList<Player> getNPCPlayers(int number){
		
		Random rand = new Random();
		
		//Remove random people, return remaining list
		for(int i=npcPlayers.size(); i> number; i--){
			
			int randNum = rand.nextInt(npcPlayers.size());
			npcPlayers.remove(randNum);
		}
		
		return npcPlayers;
	}
	
	/*----------------------------------------------------------
	 * getNPCPlayers()
	 *----------------------------------------------------------*/
	public ArrayList<Player> getNPCPlayers(){
		
		return npcPlayers;
	}
}
