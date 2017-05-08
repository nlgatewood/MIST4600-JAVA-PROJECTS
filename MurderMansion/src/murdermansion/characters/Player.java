package murdermansion.characters;

import murdermansion.items.Item;
import java.util.ArrayList;

/**
 * Encapsulates the properties of a 'Player'.  It is a sub-class of the class 'Person'.  'players' are human playable players in the game.  They
 * may have attributes that non-human characters may not have.
 * 
 * @author Nathaniel Gatewood and Donna Mobley
 * @date 04/15/2017
 */
public class Player extends Person
{
    private ArrayList<Item> playerItems;
    
    /**-------------------------------------------------------------------------------*
     * .Player(). Constructor
     **-------------------------------------------------------------------------------*/
    public Player(String playerName){
        
        super(playerName);
        playerItems = new ArrayList<Item>();
    }
    
    /**-------------------------------------------------------------------------------*
     * .addPlayerItem(). Add an item to the player's inventory
     **-------------------------------------------------------------------------------*/
    public void addPlayerItem(Item newItem){
    
        playerItems.add(newItem);
    }
    
    /**-------------------------------------------------------------------------------*
     * .getPlayerItem(String itemName). return an item with the passed name
     **-------------------------------------------------------------------------------*/
    public Item getPlayerItem(String itemName){
    
        Item thisItem = null;
        
        for(int i=0; i<playerItems.size(); i++){
        
            if(playerItems.get(i).getItemName().equals(itemName)){
            
                thisItem = playerItems.get(i);
                break;
            }
        }
        
        return thisItem;
    }
    
    /**-------------------------------------------------------------------------------*
     * .removePlayerItem(Item thisItem). Remove an item from the Player's inventory
     **-------------------------------------------------------------------------------*/
    public void removePlayerItem(Item thisItem){
    
        
        for(int i=0; i<playerItems.size(); i++){
        
            if(thisItem == playerItems.get(i)){
            
                playerItems.remove(i);
                break;
            }
        }
    }
    
    /**-------------------------------------------------------------------------------*
     * .printPlayerItems(). prints the contents of the player's inventory.
     **-------------------------------------------------------------------------------*/
     public void printPlayerItems(){
         
         System.out.println("\nInventory\n"+
                            "----------------------");
                            
         for(Item thisItem : playerItems){
         
             System.out.println(thisItem.getItemName());
         }
         
         if(playerItems.size() == 0){
         
             System.out.println("**No Items in Inventory**");
         }
         
         System.out.println("----------------------");
     }
}

