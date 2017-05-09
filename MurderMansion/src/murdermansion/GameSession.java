package murdermansion;

import murdermansion.characters.Player;
import murdermansion.characters.Character;
import murdermansion.characters.SuspectCharacters;
import murdermansion.command.*;
import murdermansion.items.*;
import murdermansion.map.*;

import java.util.Scanner;

/**
 * Game Session class is the driver of the game. Each game is encapsulated in one session object.  The session keeps track of all of the 
 * important game variables and objects.  All methods in the class are private except 'startGame()'.
 * 
 * @author Nathaniel Gatewood and Donna Mobley
 * @date 04/15/2017
 */

public abstract class GameSession
{
    private Parser parser;
    private Player player;
    private GameMap gameMap;
    private MapZone currentZone;
    
    private SuspectCharacters suspectCharacters;
    private WeaponItems weaponItems;
    private Character murdererCharacter;
    private Item murderItem;
    private MapZone murderZone;
    
    private Scanner scan;
    
    /**-------------------------------------------------------------------------------*
     * .Session(). Constructor 
     **-------------------------------------------------------------------------------*/
    public GameSession(){
        
         parser = new Parser();
         gameMap = new GameMap();
         suspectCharacters = new SuspectCharacters();
         weaponItems = new WeaponItems();
         scan = new Scanner(System.in);
    }
    
    /**-------------------------------------------------------------------------------*
     * .startGame(). Begin a game.  Create the map, grab the murder weapon, zone, and 
     *               murderer, and initialize the player object.
     **-------------------------------------------------------------------------------*/
     public void startGame(){
         
         currentZone = gameMap.buildMap();       						//Build the map - return the current zone
         murdererCharacter = suspectCharacters.getMurdererCharacter();	// Randomly get the murderer
         murderItem = weaponItems.getMurderItem(); 						// Randomly return the murder weapon
         murderZone = gameMap.getMurderRoom();   						// Randomly return the Murder room
         
         gameMap.addGameMapCharacters(suspectCharacters);				// Add Characters to the map
         gameMap.addGameMapItems(weaponItems);     						// Add the other items to the map
         
         System.out.println("---------------------------------------------------------------------------------------------------------\n"+
                            "*\n"+
                            "*                                          Welcome to Murder Mansion!\n"+
                            "*\n"+
                            "---------------------------------------------------------------------------------------------------------\n"+
                            "*A classic detective game!  There's been an awful crime at Darling manor.  A party guest, Mr. Beard, has\n"+
                            "*turned up dead!  The murderer is likely in hiding with the weapon.  It's up to you to determine who the\n"+
                            "*murderer is, what the murder weapon is, and where the murder took place. Players must move from room to\n"+ 
                            "*room gathering items and talking with other house guests. Once you think you have figured out the case,\n"+
                            "*try and solve it!  It's up to you to make sure a murderer doesn't go free.\n"+
                            "---------------------------------------------------------------------------------------------------------\n");
         
         //Get the player name and create the new player Object
         System.out.print("Enter Player Name: ");
         player = new Player(scan.nextLine());
         
         play();
     }
    
    /**-------------------------------------------------------------------------------*
     * .play(). Play the game
     **-------------------------------------------------------------------------------*/
    private void play()
    {      
        boolean finished = false;
        
        //Print the zone information
        currentZone.printInfo();
        
        //Start off by talking to your partner
        processCommand(new Command("talk", "Wohn Jatson"));
        
        // Continue playing until 'finished' marker is true
        while(!finished){
            
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        
        System.out.println("Thank you for playing.  Good bye.");
    }
    
    /**-------------------------------------------------------------------------------*
     * .processCommand(Command command). Process the command.  Check if the command word
     *                          passed is a valid command.  If it is, process accordingly
     **-------------------------------------------------------------------------------*/
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        
        // Command 'help' - Prints help screen
        if(commandWord.equals("help")) {
            
            printHelp(command);
        }
        // Command 'go' - Moves the character across zones
        else if(commandWord.equals("go")) {
            goRoom(command);
        }
        // Command 'inspect' - view item/area/character details
        else if(commandWord.equals("inspect")){
        
            inspect(command);
        }
        // Command 'use' - use an item
        else if(commandWord.equals("use")) {
        
            use(command);
        }
        // Command 'take' - Take an item from the area and put it in your inventory
        else if(commandWord.equals("take")) {
        
            take(command);
        }
        // Command 'drop' - Drop an item from your inventory into the area
        else if(commandWord.equals("drop")) {
            
            drop(command);
        }
        // Command 'talk' - Talk to the specified character
        else if(commandWord.equals("talk")) {
        
            talk(command);
        }
        // Command 'solve' - Solve the case
        else if(commandWord.equals("solve")) {
        
            solve(command);
        }
        // Command 'drink' - Drink an item
        else if(commandWord.equals("drink")){
        
            drink(command);
        }
        // Command 'quit' - Quit the game
        else if(commandWord.equals("quit")) {
            
            wantToQuit = quit(command);
        }
        //Item commands below
        //-------------------
        // Command 'warp' - warp across the map
        else if(commandWord.equals("warp")){
        
            warp(command);
        }
        else{
            System.out.println(commandWord+" is an invalid command.");
        }
        
        // else command not recognised.
        return wantToQuit;
    }
    
    /**-------------------------------------------------------------------------------*
     * .printHelp(). Print the help information
     **-------------------------------------------------------------------------------*/
    private void printHelp(Command pCommand)
    {
        if(pCommand.hasSecondWord()){
            
            String secondWord = pCommand.getSecondWord();      
            
            System.out.println("You can't help "+secondWord);
            return;
        }
  
        System.out.println("\nHelp: Controls\n"+
                           "----------------------------------------------------------------------------------------------------------------\n"+
                           "go <north|south|east|west>                                   Move across the map\n"+
                           "quit                                                         Quit the game\n"+
                           "help                                                         Display the help screen\n"+
                           "inspect <area|inventory|[item name]|[character name]>        Inspect details about an area or item\n"+
                           "use [item name]                                              Use an item.  Must be in possession of that item\n"+
                           "take [item name]                                             Take an item from the area and put it in your inventory\n"+
                           "drop [item name]                                             Drop and item from your inventory into the area\n"+
                           "talk [character name]                                        Talk to a character in an area\n"+
                           "solve case                                                   Solve the case.  Must be in the same area as Wohn Jatson\n"+
                           "drink [item name]                                            Drink the specified item\n"+
                           "----------------------------------------------------------------------------------------------------------------\n");               
    }
    
    /**-------------------------------------------------------------------------------*
     * .goRoom(). When command word 'go' is typed.  If a direction is given (north,south,
     *            east,west), move to the new zone if it exists
     **-------------------------------------------------------------------------------*/
    private void goRoom(Command pCommand)
    {
        if(!pCommand.hasSecondWord()){
            
            System.out.println("Go where?");
            return;
        }
        
        //Get the 2nd word and the coordinates of the current zone
        String secondWord = pCommand.getSecondWord();        
        MapZone zoneExit = currentZone.getZoneExit(secondWord);
        
        if(zoneExit != null){
            
            setCurrentZone(zoneExit);
            currentZone.printInfo();
        }
        else{
            System.out.println("Can't go that way");
        }
    }
    
    /**-------------------------------------------------------------------------------*
     * .inspect(). When the command word 'inspect' is typed.  Used for inspecting items,
     *             people, and areas.
     **-------------------------------------------------------------------------------*/
    private void inspect(Command pCommand){
        
        if(!pCommand.hasSecondWord()){
            
            System.out.println("Inspect What?");
            return;
        }
        
        String secondWord = pCommand.getSecondWord();
        
        //If Inspecting the 'area', print the zone information
        if(secondWord.equals("area")){
        
            currentZone.printInfo();
        }
        //If inspecting the 'inventory', print the player's inventory information
        else if(secondWord.equals("inventory")){
       
            player.printPlayerItems();
        }
        //Else, check inventory, map, and person items
        else{
            Item thisPlayerItem = null;
            Item thisZoneItem = null;
            Character thisCharacter = null;
            
            //check player inventory for an item.  If it exists, print the description
            if((thisPlayerItem = player.getPlayerItem(secondWord)) != null){
                
                thisPlayerItem.printItemDescription();
            }
            // If no player item was found, check the zone inventory
            else if((thisZoneItem = currentZone.getZoneItem(secondWord)) != null){             
               
                thisZoneItem.printItemDescription();
            }
            //Check the characters in the zone.  if one exists, print the character's description
            else if((thisCharacter = currentZone.getZoneCharacter(secondWord)) != null){
                
                thisCharacter.printCharacterDescription();
            }
            //Else, nothing was found.
            else{
                System.out.println("A "+secondWord+" was not found");   
            }
        }
    }
    
    /**-------------------------------------------------------------------------------*
     * .use(). When the command word 'use' is typed.
     **-------------------------------------------------------------------------------*/
     private void use(Command pCommand){
     
        if(!pCommand.hasSecondWord()){
            
            System.out.println("Use What?");
            return;
        }
        
        String secondWord = pCommand.getSecondWord();
        
        //Get the items from the person's bag and process the command
        Item thisItem = player.getPlayerItem(secondWord);
        
        if(thisItem != null){
            
            thisItem.printItemActionDescription();
            
            if(thisItem.getItemCommand().getCommandWord() != null){
                
                processCommand(thisItem.getItemCommand());
            }
        }
        else{
            System.out.println("Item "+secondWord+" not found in inventory");
        }
     }
     
    /**-------------------------------------------------------------------------------*
     * .take(). When the command word 'take' is typed.
     **-------------------------------------------------------------------------------*/
     private void take(Command pCommand){
         
        if(!pCommand.hasSecondWord()){
            
            System.out.println("Take What?");
            return;
        }
        
        String secondWord = pCommand.getSecondWord();
        Item thisItem = currentZone.removeZoneItem(secondWord);
        
        if(thisItem != null){
        
            player.addPlayerItem(thisItem);
            System.out.println("You pick-up the "+thisItem.getItemName());
        }
        else{
            System.out.println("Can't find a "+secondWord+" in zone");
        }
     }
     
    /**-------------------------------------------------------------------------------*
     * .drop(). When the command word 'drop' is typed.
     **-------------------------------------------------------------------------------*/
     private void drop(Command command){
         
         if(!command.hasSecondWord()){
         
             System.out.println("drop what?");
             return;
         }
         
         String secondWord = command.getSecondWord();
         Item thisItem = player.getPlayerItem(secondWord);
         
         if(thisItem != null){
             
             player.removePlayerItem(thisItem);
             currentZone.addZoneItem(thisItem);
             System.out.println("You dropped the "+thisItem.getItemName());
         }
         else{
            System.out.println("You don't have a "+secondWord+" to drop");    
         }
         
     }
        
    /**-------------------------------------------------------------------------------*
     * .talk(). When the command word 'quit' is typed.  Quits the game
     **-------------------------------------------------------------------------------*/
     private void talk(Command command){
     
         if(!command.hasSecondWord()){
         
             System.out.println("Talk to whom?");
             return;
         }
         
         String secondWord = command.getSecondWord();
         Character thisCharacter = currentZone.getZoneCharacter(secondWord);
         
         if(thisCharacter != null){
             
             thisCharacter.printDialogue();
         }
         else{
            System.out.println(secondWord+" is not here.");    
         }
     }
     
    /**-------------------------------------------------------------------------------*
     * .solve(). When the command word 'solve' is typed.  Let's you guess who, where, and
     *           and with what
     **-------------------------------------------------------------------------------*/
     private void solve(Command command){
     
         if(!command.hasSecondWord()){
         
             System.out.println("Solve what?");
             return;
         }
         
         String secondWord = command.getSecondWord();
         
         if(secondWord.equals("case")){
             
             Character thisCharacter = currentZone.getZoneCharacter("Wohn Jatson");
             
             if(thisCharacter != null){
                 
                 String roomGuess = null;
                 String weaponGuess = null;
                 String characterGuess = null;
                 
                 System.out.print("Ah! Splendid!  So, who do you think is the murderer?:");
                 characterGuess = scan.nextLine();
                 
                 System.out.print("Oh, I see!  Well, what weapon did they use?:");
                 weaponGuess = scan.nextLine();
                 
                 System.out.print("And where?:");
                 roomGuess = scan.nextLine();
                 
                 System.out.println("\nWohn Jatson says: \"Mmmm, let me look over everything here....");
                 
                 if(characterGuess.equals(murdererCharacter.getPlayerName()) && 
                    weaponGuess.equals(murderItem.getItemName()) &&
                    roomGuess.equals(murderZone.getZoneName())){
                        
                        System.out.println("\nBy Golly, I think you did it, "+player.getPlayerName()+"!  All of this evidence fits perfectly!  We can\n"+
                                           "definitely say Mr. Beard was killed by "+characterGuess+" with the "+weaponGuess+
                                           "in the "+roomGuess+"!\"\n");
                                           
                        processCommand(new Command("quit",null));
                 }
                 else{
                     System.out.println("Well, I've looked at this carefully...and I just don't think this fits, "+player.getPlayerName()+
                                        ".\nThere's something we've got to be missing....\"");
                 }
             }
             else{
                 System.out.println("You must go to your partner, Wohn Jatson, to solve the case.");
             }
         }
         else{
             System.out.println("You can not solve "+secondWord);
         }
     }
     
    /**-------------------------------------------------------------------------------*
     * .drink(). When the command word 'drink' is typed.
     **-------------------------------------------------------------------------------*/
     private void drink(Command command){
     
        if(!command.hasSecondWord()){
         
             System.out.println("Drink what?");
             return;
        }
         
        String secondWord = command.getSecondWord();
        Item thisItem = player.getPlayerItem(secondWord);
        
        if(thisItem != null){
            
            thisItem.printItemActionDescription();
            boolean toQuit = processCommand(thisItem.getItemCommand());
            
            if(toQuit == true){
            
                System.out.println("Thank you for playing.  Good bye.");
                System.exit(0);
            }
        }
        else{
            System.out.println("Item "+secondWord+" not found");
        }
     }
    /**-------------------------------------------------------------------------------*
     * .quit(). When the command word 'quit' is typed.  Quits the game
     **-------------------------------------------------------------------------------*/
    private boolean quit(Command pCommand)
    {
        if(pCommand.hasSecondWord()){
            
            System.out.println(">>"+pCommand.getSecondWord()+"Quit What?");
            return false;
        }
        else{
            return true;
        }
    }
    
    /**-------------------------------------------------------------------------------*
     * .warp(Command command). Item command.  Warp to the specified coordinates
     **-------------------------------------------------------------------------------*/
     private void warp(Command command){
     
         if(!command.hasSecondWord()){
         
             System.out.println("Warp where?");
             return;
         }
         
         String secondWord = command.getSecondWord();
         
         MapZone newMapZone = gameMap.getMapZone(secondWord);
         
         if(newMapZone != null){
         
            setCurrentZone(newMapZone);
            currentZone.printInfo();
         }
         else{
             System.out.println(secondWord+" does not exist in the map.");
         }
     }
    
    /**-------------------------------------------------------------------------------*
     * .setCurrentZone(). Set's the class variable 'currentZone'
     **-------------------------------------------------------------------------------*/
    public void setCurrentZone(MapZone currentZone){
    
        this.currentZone = currentZone;
    }
}