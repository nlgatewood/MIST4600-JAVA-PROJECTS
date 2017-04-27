package murdermansion;
import java.util.*;

/**
 * Encapsulates the attributes of a 'Game Zone'.  Each room is contained in a 'GameZone' object.  Attributes include the zone name, zone characters, and 
 * zone exits.
 * 
 * @author Nathaniel Gatewood and Donna Mobley
 * @date 04/15/2017
 */
public class MapZone
{
    private String zoneCoords;
    private String zoneName;
    private String zoneDescription;
    private boolean isMurderRoom;
    private LinkedHashMap<String,MapZone> zoneExits;
    private ArrayList<Character> zoneCharacters;
    private ArrayList<Item> zoneItems;
    
    /**-------------------------------------------------------------------------------*
     * .MapZone(). Constructor - Sets the zone's coordinate string, name, and description
     **-------------------------------------------------------------------------------*/
    public MapZone(String zoneCoords, String zoneName, String zoneDescription)
    {
        this.zoneCoords = zoneCoords;
        this.zoneName = zoneName;
        this.zoneDescription = zoneDescription;
        this.isMurderRoom = false;
        
        zoneExits = new LinkedHashMap<String,MapZone>();
        zoneExits.put("north", null);
        zoneExits.put("south", null);
        zoneExits.put("east", null);
        zoneExits.put("west", null);
        
        zoneCharacters = new ArrayList<Character>();
        zoneItems = new ArrayList<Item>();
    }
    
    /**-------------------------------------------------------------------------------*
     * .getZoneCoords(). Returns the zone's coordinate string
     **-------------------------------------------------------------------------------*/
    public String getZoneCoords(){
        
        return zoneCoords;
    }
    
    /**-------------------------------------------------------------------------------*
     * .getZoneName(). Returns the zone's name
     **-------------------------------------------------------------------------------*/
    public String getZoneName(){
        
        return zoneName;
    }
    
    /**-------------------------------------------------------------------------------*
     * .getZoneDescription(). Returns the zone's description
     **-------------------------------------------------------------------------------*/
    public String getZoneDescription(){
        
        return zoneDescription;
    }
    
    /**-------------------------------------------------------------------------------*
     * .addZoneExits(MapZone exitZone,MapZone southExit,MapZone eastExit,MapZone westExit). 
     **-------------------------------------------------------------------------------*/
    public void addZoneExits(String direction, MapZone exit){
        
        zoneExits.put(direction, exit);
    }
    
    /**-------------------------------------------------------------------------------*
     * .getZoneExit(String direction). 
     **-------------------------------------------------------------------------------*/
    public MapZone getZoneExit(String direction){
        
        return zoneExits.get(direction);
    }
    
    /**-------------------------------------------------------------------------------*
     * .printZoneExits(). Given a zone, print the zone's exits in directions 
     *                    (north, south, east, west)
     **-------------------------------------------------------------------------------*/
    public void printZoneExits(){
        
        ArrayList<String> exitsList = new ArrayList<String>();
        
        //Loop through the exit directions
        for(String dir : zoneExits.keySet()){
        
            if(getZoneExit(dir) != null){
           
                exitsList.add(dir);
            }
        }
        
        //Return a joined list
        System.out.println("(Exits: "+String.join(", ", exitsList)+")");
    }
    
    /**-------------------------------------------------------------------------------*
     * .addZoneCharacter(Character newZoneCharacter). Add new zone Character to the zone 
     *                                          Character array list
     **-------------------------------------------------------------------------------*/
     public void addZoneCharacter(Character newZoneCharacter){
         
        zoneCharacters.add(newZoneCharacter);    
     }
    
    /**-------------------------------------------------------------------------------*
     * .addZoneItem(Item newZoneItem). Add new zone item to the zone item array list
     **-------------------------------------------------------------------------------*/
     public void addZoneItem(Item newZoneItem){
         
        zoneItems.add(newZoneItem);    
     }
    
    /**-------------------------------------------------------------------------------*
     * .getZoneItem(String itemName). Return the item object from the zones item arraylist.
     **-------------------------------------------------------------------------------*/
     public Item getZoneItem(String itemName){
     
         Item thisItem = null;
         
         //Loop through each of the zone items
         for(int i=0; i<zoneItems.size(); i++){
         
             //Find the item with the specified name
             if(zoneItems.get(i).getItemName().equals(itemName)){
             
                 thisItem = zoneItems.get(i);
                 break;
             }
         }
         
         return thisItem;
     }
     
    /**-------------------------------------------------------------------------------*
     * .removeZoneItem(String itemName). Return the item object and remove it from
     *                                   the zones item arraylist.
     **-------------------------------------------------------------------------------*/
     public Item removeZoneItem(String itemName){
     
         Item thisItem = null;
         
         //Loop through each of the zone items
         for(int i=0; i<zoneItems.size(); i++){
         
             //Find the item with the specified name
             if(zoneItems.get(i).getItemName().equals(itemName)){
             
                 thisItem = zoneItems.get(i);
                 zoneItems.remove(i);
                 break;
             }
         }
         
         return thisItem;
     }
     
    /**-------------------------------------------------------------------------------*
     * .printZoneItem(). Print out all the zone items in this zone
     **-------------------------------------------------------------------------------*/
     public void printZoneItems(){
        
        //Loop through the exit directions
        for(Item thisItem : zoneItems){
       
            System.out.println("You see a '"+thisItem.getItemName()+"' lying there");
        }  
     }
     
    /**-------------------------------------------------------------------------------*
     * .printZoneCharacters(). Print out all the zone items in this zone
     **-------------------------------------------------------------------------------*/
     public Character getZoneCharacter(String characterName){
     
         Character thisCharacter = null;
         
         //Loop through and find a character
         for(int i=0; i<zoneCharacters.size(); i++){
             
             if(zoneCharacters.get(i).getPlayerName().equals(characterName)){
                 
                thisCharacter = zoneCharacters.get(i);
                break;
             }
         }
         
         return thisCharacter;
     }
     
    /**-------------------------------------------------------------------------------*
     * .printZoneCharacters(). Print out all the zone items in this zone
     **-------------------------------------------------------------------------------*/
     public void printZoneCharacters(){
        
        //Loop through the exit directions
        for(Character thisCharacter : zoneCharacters){
       
            System.out.println("You see a '"+thisCharacter.getPlayerName()+"' standing there");
        }  
     }
     
    /**-------------------------------------------------------------------------------*
     * .printInfo(). Prints the zone's information; including the coordinates, zone
     *               name, and zone description
     **-------------------------------------------------------------------------------*/
    public void printInfo()
    {
        System.out.println("\n------------------------------------\n"+
                            getZoneCoords()+" "+getZoneName()+
                           "\n------------------------------------");
                           
        String zoneDescription = getZoneDescription();
        String[] words = zoneDescription.split("\\s");
        int lineLength = 0;
        
        for(String word : words){
            
            if((lineLength+word.length()) > 80){
                
                System.out.println();
                lineLength = 0;
            }

            System.out.print(" "+word);
            lineLength += word.length();
        }
        
        System.out.println("\n");
        printZoneCharacters();
        printZoneItems();                    
        printZoneExits();
        //System.out.println();
    }
    
    /**-------------------------------------------------------------------------------*
     * .setIsMurderRoomTrue(). Sets the murder room as true
     **-------------------------------------------------------------------------------*/
     public void setIsMurderRoomTrue(){
     
         isMurderRoom = true;
     }
     
    /**-------------------------------------------------------------------------------*
     * .getIsMurderRoom(). Retrieved the isMurderRoom variable
     **-------------------------------------------------------------------------------*/
     public boolean getIsMurderRoom(){
     
         return isMurderRoom;
     }
}
