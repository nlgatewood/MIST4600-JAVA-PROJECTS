package murdermansion;

/**
 * Class 'Item'. Encapsulates the properties of an 'item'.  Items can be used, exist in a map zone, or exist in a player's inventory.
 * 
 * @author Nathaniel Gatewood and Donna Mobley
 * @date 04/15/2017
 */
public class Item
{
    private String itemName;
    private String itemDescription;
    private String itemActionDescription;
    private Command itemCommand;
    private CommandWords commandWords;

    /**-------------------------------------------------------------------------------*
     * .Item(). Constructor 
     **-------------------------------------------------------------------------------*/
    public Item(String itemName, String itemDescription, String itemActionDescription, String cWord1, String cWord2)
    {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemActionDescription = itemActionDescription;
        commandWords = new CommandWords();
        
        if(!commandWords.isItemCommand(cWord1)){
            
            cWord1 = null;
        }
        
        itemCommand = new Command(cWord1, cWord2);
    }
    
    /**-------------------------------------------------------------------------------*
     * .getItemCommand(). The action of the item
     **-------------------------------------------------------------------------------*/
     public Command getItemCommand(){
         
        return itemCommand;    
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
     * .printItemActionDescription(). print's the item's action Description
     **-------------------------------------------------------------------------------*/
    public void printItemActionDescription(){
        
        if(itemActionDescription != null){
            
            System.out.println("\n"+itemActionDescription);
        }
    }
}