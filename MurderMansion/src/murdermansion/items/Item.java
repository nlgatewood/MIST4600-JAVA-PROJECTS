package murdermansion.items;

import java.util.HashMap;
import murdermansion.command.Command;
import murdermansion.command.CommandWords;

/**
 * Class 'Item'. Encapsulates the properties of an 'item'.  Items can be used, exist in a map zone, or exist in a player's inventory.
 * 
 * @author Nathaniel Gatewood agnd Donna Mobley
 * @date 04/15/2017
 */
public class Item
{
    private String itemName;
    private String itemDescription;
    private HashMap<String,String> itemActionDescriptions;
    private HashMap<String,Command> itemCommands;
    private CommandWords commandWords;

    /**-------------------------------------------------------------------------------*
     * .Item(). Constructor 
     **-------------------------------------------------------------------------------*/
    public Item(String itemName, String itemDescription, String[] actionWords)
    {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        itemActionDescriptions = new HashMap<String,String>();
        itemCommands = new HashMap<String,Command>();
        commandWords = new CommandWords();
        
		for(int i=0; 4<=(actionWords.length-i); i+=4){
			
			String action = actionWords[i];
			String cWord1 = actionWords[i+1];
			String cWord2 = actionWords[i+2];
			String actionDesc = actionWords[i+3];
			
	        if(!commandWords.isItemCommand(cWord1)){
	            
	            cWord1 = null;
	        }
	        
	        itemCommands.put(actionWords[i], new Command(cWord1, cWord2));
	        itemActionDescriptions.put(action, actionDesc);
		}
    }
    

	/**-------------------------------------------------------------------------------*
     * .getItemCommand(). The actions of the item
     **-------------------------------------------------------------------------------*/
     public Command getItemCommand(String cWord){
         
        return itemCommands.get(cWord);    
     }
    
 	/**-------------------------------------------------------------------------------*
      * .hasCommandWord(String cWord). Returns 'true' if this item has a command for the
      * 							   give word
      **-------------------------------------------------------------------------------*/
     public boolean hasCommandWord(String cWord){
    	 
    	 boolean found = false;
    	 
    	 for(String itemCWord : itemCommands.keySet()){
    		 
    		 if(itemCWord.equals(cWord)){
    			 
    			 found = true;
    			 break;
    		 }
    	 }
    	 
    	 return found;
     }
     
    /**-------------------------------------------------------------------------------*
     * .getItemName(). Return the itemName as a String
     **-------------------------------------------------------------------------------*/
     public String getItemName(){
     
         return itemName;
     }
     
    /**-------------------------------------------------------------------------------*
     * .printItemDescription(). print's the item's description
     **-------------------------------------------------------------------------------*/
     public void printItemDescription(){
     
         System.out.println(itemDescription+"\n");
     }
    
    /**-------------------------------------------------------------------------------*
     * .printItemActionDescription(String cWord). print's the item's action Description
     **-------------------------------------------------------------------------------*/
    public void printItemActionDescription(String cWord){
        
        if(itemActionDescriptions.get(cWord) != null){
            
            System.out.println("\n"+itemActionDescriptions.get(cWord));
        }
    }
}