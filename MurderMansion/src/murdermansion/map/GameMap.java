package murdermansion.map;

import murdermansion.characters.Character;
import murdermansion.characters.SuspectCharacters;
import murdermansion.items.Item;
import murdermansion.items.WeaponItems;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

/**
 * Encapsulates the attributes of the Game Map.  Builds the game map using map zones.  Also contains methods to add items and characters to 
 * certain map zones.
 * 
 * @author Nathaniel Gatewood
 * @date 04/15/2017
 */
public class GameMap
{
    private Hashtable<String,MapZone> map;
    Random rand;
    
    /**-------------------------------------------------------------------------------*
     * .GameMap(). Constructor - create and build the map     
     **-------------------------------------------------------------------------------*/
    public GameMap(){
        
        map = new Hashtable<String,MapZone>();
        rand = new Random();
    }
    
    /**---------------------------------------------------------------------/----------*
     * .buildMap(). Populate the map hashmap with the map zones. 
     *              ('key'=coordinate string, 'value'=MapZone object)               
     **-------------------------------------------------------------------------------*/
    public MapZone buildMap(){
        
        //Front lawn and front door areas
        map.put("1-4", new MapZone("1-4", "Front Green-North", "You stand on the north-side of the front lawn of Darling Manor. A mischievous "+
                                          " looking gargoyle stares down at you from the roof of the manor.  You see the curtains shift from "+
                                          "the second floor window.  Is someone watching you?"));
        map.put("1-3", new MapZone("1-3", "Front Door", "You stand at the front door of Darling Manor. Two statues stand on either side of the "+
                                          "door.  Your partner, Wohn Jatson is bent over staring at the ground through his magnifying glass. "+
                                          "He seems to be focused on something important."));
        map.put("1-2", new MapZone("1-2", "Front Green-South", "You stand on the south-side of the front lawn of Darling Manor. A winged "+
                                          "gargoyle stares down at you from the roof of the manor.  To the south sits a beautiful fountain in "+
                                          "the distance."));     
        
        //Hall Ways                                 
        map.put("2-3", new MapZone("2-3", "Foyer", "You enter through the front door of Darling Manor into a large foyer. The floor creaks as you "+ 
                                          "walk across it. A faint acidic smell hangs in the air.  On the North side of the foyer stands a large "+ 
                                          "pedestal with a guest book sitting on top.  It seems they recently had a party in the house."));
        map.put("3-3", new MapZone("3-3", "Foyer Hall", "You are standing in the middle of the foyer.  To the East, you see an opening "+
                                          "to a large Hallway. To the West is the front door to the mansion. To the North and South, there are"+
                                          "doors to other rooms. You peak in the North doorway. There seems to be a lot of books in the room."));
        map.put("4-3", new MapZone("4-3", "Foyer Hall", "You are standing at the East end of the foyer hall. Two large paints of cats dressed in "+
                                          "military garb hang on the North and South walls. That seems a bit odd... To the east, you see an opening "+
                                          "to a large Hallway. The front door to the mansion lies West from here."));
        map.put("5-3", new MapZone("5-3", "Main Hall-East", "You exit the foyer into a grand hall.  Pictures of long dead socialites hang on the wall "+
                                          "all through the hall. You see what looks like a storage closest to the East. The door seems to be cracked open. "+
                                          "The Main Hall continues North and South.  To the West is the foyer and Mansion entrance/exit."));                                      
        map.put("5-4", new MapZone("5-4", "Main Hall-Northwest", "An old vase sits on a pedalstool in the corner of the Main Hall.  A large crack "+
                                          "splits the it in half. It seems this vase has been glued together. Old paintings continue to line the walls. "+
                                          "To the north lies the entrance to the Hall. To the west is the Lounge. The Main Hall continues to the east and South."));
        map.put("6-4", new MapZone("6-4", "Main Hall-North", "You continue down the vast Main Hall. Pictures of..cats?  Cats dressed in dresses? "+
                                          "Their eyes pierce your soul. You feel the need to run but your feet feel like stone! You finally snap out " +
                                          "of it. The Main Hall continues East and West."));
        map.put("7-4", new MapZone("7-4", "Main Hall-Northeast", "You continue down the vast Main Hall.  You come across another entrance to the north. "+
                                          "Strange music permeates from the room.  Who would ever listen to that music?  A vase sit in the Northeast corner "+
                                          "of the room.  It looks Oriental in origin.  The Main Hall continues South and West."));
        map.put("7-3", new MapZone("7-3", "Main Hall-East", "You find yourself in the East section of the Main hall.  The candles that line the wall flicker. "+
                                          "It seems rather dark in this portion of the Main Hall. To the East you smell what seems like fresh baking bread. "+  
                                          "To the North and South, the Main Hall continues."));
        map.put("8-3", new MapZone("8-3", "Kitchen Hall", "The smell of bread permeates throughout the hall.  The floor in this hall seems to be well worn. "+
                                          ", probably due to heavy foot-traffic from the kitchen staff. A dried red substance covers the baseboards. Is it "+
                                          "just spilled sauce?  Or is it something else?"));
        map.put("7-2", new MapZone("7-2", "Main Hall-Southeast", "An old bust of a man sits in the corner of the hall. The inscription on below the face "+
                                          "'Jeffery Darling'. It's eyes seem to be following you as you move across the hall. To the south lies the ballroom. "+ 
                                          "The hallway continues to the North and West."));
        map.put("6-2", new MapZone("6-2", "Main Hall-South", "You continue walking down the Main Hall. Large flowering pots line the walls on both sides, "+
                                          "filled with thorning roses and cacti.  What a weird coupling of house plants, you think to yourself.  The Main Hall "+
                                          "continues to the East and West."));
        map.put("5-2", new MapZone("5-2", "Main Hall-Southwest", "You stand at the Southwest corner of the Main hallway.  To the south sits a doorway to "+
                                          "the billards room.  The faint scent of cigar smoke hangs in the air.  To the west lies the conservatory. To the "+ 
                                          "North and East, the Main Hall continues."));
        map.put("6-3", new MapZone("6-3", "Storage Closet", "You walk into a large storage closet.  What a wreck!  Old lamps, couches, and other nic-nacs "+
                                          "litter the room. There seems to be generations worth of items in here.  Hanging on a nail by the door is a "+
                                          "clipboard.  Maybe it has some useful information?"));
                                          
        //library                                  
        map.put("3-4", new MapZone("3-4", "Library", "You enter the Library.  All four walls, from ceiling to floor, are covered in books.  Stacks of books "+
                                          "sit in the corners of the room.A ladder leans against the North wall.  In the middle of the room sits a large desk "+
                                          "with a large lamp on top of it.  It's rather clean considering the rest of the room. A doorway to the East leads to "+
                                          "another room.  To the South lies the Foyer."));  
        //Lounge                  
        map.put("4-4", new MapZone("4-4", "Lounge", "You enter the Lounge. You instantly become relaxed.  A fireplace is in the middle of the North wall "+
                                          "with a warm bed of coals lightly glowing. Two chairs and a table sit in fron of fireplace.  On the South wall "+
                                          "sits a desk with stacks of papers on top. To the West is the entrance to the Library.  To the East is the exit "+
                                          "to the Main Hall"));
        //Study
        map.put("3-2", new MapZone("3-2", "Study", "You are standing in the Study. On the South wall sits a large oak desk. The desk seems old; very old. names "+
                                          "and dates pepper the desk top.  A giant elk head hangs above it ominously.  A small bookshelf sits on the West side "+
                                          "of the room.  However, it's only half full.  To the North is the exit to the Foyer.  To the East lies the "+
                                          "Conservatory."));
        //Conservatory
        map.put("4-2", new MapZone("4-2", "Conversatory", "You are standing in the Conversatory.  Something feels a bit off in here. A fowl smell permeates "+
                                          "throughout the room.  Musical instraments line the North wall.  Several chairs are aligned in the middle of the room "+
                                          "You admire the cello leaned against one of the chairs. You begin thinking back to your childhood lessons and how "+
                                          "you hated the cello.  To the West lies the Study.  To the East is the Main Hall."));
        //Hall
        map.put("5-5", new MapZone("5-5", "Hall", "You stand in the middle of a grand Hall. It's a large circular room with four large windows lined with red "+
                                          "colored curtains. The shiny marble floor is adorned with intricate patterns. A small stages sits on the North wall. "+
                                          "Several rows of chairs sit in the middle of the Hall. wonder who spoke here? To the South is the Exit back out to "+
                                          "the Main Hallway."));                             
        //Dining Room
        map.put("7-5", new MapZone("7-5", "Dining Room", "A large table sits in the middle of the dining room. You are amazed by it's size. It could easily "+
                                          "sit 100 guests!  Large bowls of fruits sit on top of the table, along with silver platters. The air still smells of "+
                                          "fresh meats and sweet wine. It seems it was last used not long ago.  A record player plays a very abnoxious tune on"+
                                          "the back wall. to the South lies the exit back to the Main Hallway."));                  
        //Kitchen
        map.put("9-3", new MapZone("9-3", "Kitchen", "A large wooden table sits in the middle of the room.  It's covered in metal bowls, wooden spoons, and "+
                                          "other cookware.  On the south wall lies 3 large oven with fires roaring.  Next to the ovens, two large loaves of "+
                                          "bread sit on the counter.  The smell begins to make your mouth water. The kitchen staff are working tireless "+
                                          "preparing the next meal. They don't even seem to notice your presence."));
        //Kitchen
        map.put("7-1", new MapZone("7-1", "Ballroom", "You enter a large ballroom.  Above you in the middle of the room sits a large crystal chandelier. "+
                                          "As you gaze at it's beauty you wonder how much it may have cost.  Large windows like the South and East walls; "+
                                          "lined with billowy white curtains. A small stage sits in the Northwest corner of the room. To the North lies the "+
                                          "exit to the Main Hallway."));
        //Kitchen
        map.put("5-1", new MapZone("5-1", "Billard Room", "You enter the Billard Room.  Two large billard tables sit in the middle of the room.  A record "+
                                          "play sits on the South wall of the room.  In the Northeast corner sits a bar.  Thirty or so bottles line the wall "+ 
                                          "behind the bar and two unfinished drinks sit on the counter-top. To the North lies the exit into the Main Hallway."));
        
        //Set the Room exits                                  
        map.get("1-4").addZoneExits("south", map.get("1-3"));
        
        map.get("1-3").addZoneExits("north", map.get("1-4"));
        map.get("1-3").addZoneExits("south", map.get("1-2"));
        map.get("1-3").addZoneExits("east", map.get("2-3"));
        
        map.get("1-2").addZoneExits("north", map.get("1-3"));
        
        map.get("2-3").addZoneExits("east", map.get("3-3"));
        map.get("2-3").addZoneExits("west", map.get("1-3"));
        
        map.get("3-3").addZoneExits("north",map.get("3-4"));
        map.get("3-3").addZoneExits("south",map.get("3-2"));
        map.get("3-3").addZoneExits("east",map.get("4-3"));
        map.get("3-3").addZoneExits("west",map.get("2-3"));
        
        map.get("4-3").addZoneExits("east", map.get("5-3"));
        map.get("4-3").addZoneExits("west",map.get("3-3"));
        
        map.get("3-4").addZoneExits("south",map.get("3-3"));
        map.get("3-4").addZoneExits("east",map.get("4-4"));
        
        map.get("4-4").addZoneExits("east",map.get("5-4"));
        map.get("4-4").addZoneExits("west",map.get("3-4"));
        
        map.get("3-2").addZoneExits("north",map.get("3-3"));
        map.get("3-2").addZoneExits("east", map.get("4-2"));
        
        map.get("4-2").addZoneExits("east", map.get("5-2"));
        map.get("4-2").addZoneExits("west", map.get("3-2"));
        
        map.get("5-3").addZoneExits("north",map.get("5-4"));
        map.get("5-3").addZoneExits("south",map.get("5-2"));
        map.get("5-3").addZoneExits("east", map.get("6-3"));
        map.get("5-3").addZoneExits("west", map.get("4-3"));
        
        map.get("5-4").addZoneExits("north", map.get("5-5"));
        map.get("5-4").addZoneExits("south", map.get("5-3"));
        map.get("5-4").addZoneExits("east",  map.get("6-4"));
        map.get("5-4").addZoneExits("west",  map.get("4-4"));
        
        map.get("5-5").addZoneExits("south", map.get("5-4"));
        
        map.get("6-4").addZoneExits("east",  map.get("7-4"));
        map.get("6-4").addZoneExits("west",  map.get("5-4"));
        
        map.get("7-4").addZoneExits("north",  map.get("7-5"));
        map.get("7-4").addZoneExits("south",  map.get("7-3"));
        map.get("7-4").addZoneExits("west",  map.get("6-4"));
        
        map.get("7-5").addZoneExits("south",  map.get("7-4"));
        
        map.get("7-3").addZoneExits("north",  map.get("7-4"));
        map.get("7-3").addZoneExits("south",  map.get("7-2"));
        map.get("7-3").addZoneExits("east",  map.get("8-3"));
        
        map.get("8-3").addZoneExits("east",map.get("9-3"));
        map.get("8-3").addZoneExits("west",map.get("7-3"));
        
        map.get("9-3").addZoneExits("west",map.get("8-3"));
        
        map.get("7-2").addZoneExits("north",  map.get("7-3"));
        map.get("7-2").addZoneExits("south",  map.get("7-1"));
        map.get("7-2").addZoneExits("west",  map.get("6-2"));
        
        map.get("7-1").addZoneExits("north",  map.get("7-2"));
        
        map.get("6-2").addZoneExits("east",map.get("7-2"));
        map.get("6-2").addZoneExits("west",map.get("5-2"));
        
        map.get("5-2").addZoneExits("north", map.get("5-3"));
        map.get("5-2").addZoneExits("south", map.get("5-1"));
        map.get("5-2").addZoneExits("east",  map.get("6-2"));
        map.get("5-2").addZoneExits("west",  map.get("4-2"));
        
        map.get("5-1").addZoneExits("north", map.get("5-2"));
        
        map.get("6-3").addZoneExits("west", map.get("5-3"));
        
        //set certain rooms to the murder rooms
        map.get("3-4").setIsMurderRoomTrue();
        map.get("4-4").setIsMurderRoomTrue();
        map.get("3-2").setIsMurderRoomTrue();
        map.get("4-2").setIsMurderRoomTrue();
        map.get("5-5").setIsMurderRoomTrue();
        map.get("7-5").setIsMurderRoomTrue();
        map.get("9-3").setIsMurderRoomTrue();
        map.get("7-1").setIsMurderRoomTrue();
        map.get("5-1").setIsMurderRoomTrue();
        
        //Return this zone
        return map.get("1-3");
    }
    
    /**-------------------------------------------------------------------------------*
     * .addGameMapItems(). Add the game items to the main rooms randomly
     **-------------------------------------------------------------------------------*/
    public void addGameMapCharacters(SuspectCharacters suspectCharacters){
         
        //Add the murder suspects to the game map
        ArrayList<Character> suspectCharacterList = suspectCharacters.getSuspectCharacters();
        ArrayList<MapZone> murderRooms = getMurderRoomsList();
        int roomListSize = murderRooms.size();
         
        for(int i=0; i<roomListSize; i++){
         
            if(suspectCharacterList.size() > 0){
                 
                int randRoom = rand.nextInt(murderRooms.size());
                int randCharacter = rand.nextInt(suspectCharacterList.size());
                 
                murderRooms.get(randRoom).addZoneCharacter(suspectCharacterList.get(randCharacter));
                suspectCharacterList.remove(randCharacter);
                murderRooms.remove(randRoom);
            }
        }
         
        //Add any additional Characters that aren't Murderer Characters here...
        ArrayList<String> dialogue = new ArrayList<String>();
        dialogue.add("I bet the killer has left the mansion with the murder weapon.\n"+ 
                     "Account for all of the potential murder weapons and guests in the mansion and\n"+ 
                     "determine who and what are missing. Also, look in the rooms to look for any\n"+
                     "suspicous items lying around You may be able to find some guest and item list\n"+
                     "somewhere. When you're ready to solve the case, come to me and say 'solve case'.\n"+
                     "You can do it!");
        map.get("1-3").addZoneCharacter(new Character("Wohn Jatson", "Strongly built, of a stature either average or slightly above average, "+
                                                      "with a thick, strong neck and a small moustache.  Out of all of the partners you've had "+
                                                      "he is certainly the most competent.", dialogue));
    }
    
    /**-------------------------------------------------------------------------------*
     * .addGameMapItems(). Add the game items to the main rooms randomly
     **-------------------------------------------------------------------------------*/
    public void addGameMapItems(WeaponItems weaponItems){
        
        //Add the Weapon items to the zones
        ArrayList<Item> itemsList = weaponItems.getWeaponItems();
        ArrayList<MapZone> murderRooms = getMurderRoomsList();
        int roomListSize = murderRooms.size();
        
        for(int i=0; i<roomListSize; i++){
       
            if(itemsList.size() > 0){
                
                int randRoom = rand.nextInt(murderRooms.size());
                int randItem = rand.nextInt(itemsList.size());
            
                murderRooms.get(randRoom).addZoneItem(itemsList.get(randItem));
                itemsList.remove(randItem);
                murderRooms.remove(randRoom);
            }
        }
        
        //Add other Items not Weapons Items here...
        map.get("2-3").addZoneItem(new Item("Guest Log", "Guest Log\n--------\nMiss Redding\nColonel Lugar\n"+
                                            "Mrs. Maroon\nMr. Mauve\nMrs. Chicken\nProfessor Plunk\n--------",
                                            new String[] {"use", "inspect", "Guest Log", null}));
        map.get("2-3").addZoneItem(new Item("Black Mirror", "An old black mirror.  Something seems odd about it...", 
        									new String[] {"use", "warp", "1-4","Woosh! You get swept away across the mansion!"}));
        map.get("6-3").addZoneItem(new Item("Inventory List", 
        									"Inventory\n----------\nCandlestick\nKnife\nRope\nWrench\nRevolver\nLead Pipe\n----------", 
        									new String[] {"use", "inspect", "Inventory List", null}));
     }
     
    /**-------------------------------------------------------------------------------*
     * .getMurderRoomsList(). Retrieve a list of murder room zone objects
     **-------------------------------------------------------------------------------*/
    public ArrayList<MapZone> getMurderRoomsList(){
        
        ArrayList<MapZone> murderRooms = new ArrayList<MapZone>();
        
        for(String coords : map.keySet()){
        
            if(map.get(coords).getIsMurderRoom()){
           
                murderRooms.add(map.get(coords));
            }
        }
        
        return murderRooms;
    }
    
    /**-------------------------------------------------------------------------------*
     * .getMurderRoom(). Randomly retrieve the murder room; the room the murder too place
     **-------------------------------------------------------------------------------*/
    public MapZone getMurderRoom(){
        
        ArrayList<MapZone> murderRooms = getMurderRoomsList();
        int randRoom = rand.nextInt(murderRooms.size());
        
        murderRooms.get(randRoom).addZoneItem(new Item("Bottle of Bleach", 
        										"Why is there a bottle of bleach here?!  It's all over the floor.  Was somebody trying to clean something up?", 
                                                new String[] {"drink", "quit", null," Well, that was stupid...You black out and stumble over...you dead"}));
        
        murderRooms.get(randRoom).addZoneItem(new Item("Bloody Rag", 
        											   "This rag is soaked in blood! It also has a monogramed 'B' in one of the corners.  Could this be Mr. Beard's?", 
                                                       new String[] {}));
        
        return murderRooms.get(randRoom);
    }
    
    /**-------------------------------------------------------------------------------*
     * .getMapZone(). Retrieve the map zone using the coordinate paramaters and return
     *                the ZoneMape object
     **-------------------------------------------------------------------------------*/
    public MapZone getMapZone(String mapCoords)
    {
        return map.get(mapCoords);
    }
    
    /**-------------------------------------------------------------------------------*
     * .getZoneCoords(). Given a MapZone object, find the object in the map and return
     *                   the zone's coordinates in an int[] array.
     **-------------------------------------------------------------------------------*/
    public int[] getZoneCoords(MapZone mapZone){
        
        int[] zoneCoords = new int[2];
    
        for(String key : map.keySet()){
        
            if(map.get(key) == mapZone){
                
                String[] coords = key.split("-");
                zoneCoords[0] = Integer.parseInt(coords[0]);
                zoneCoords[1] = Integer.parseInt(coords[1]);
                break;
            }
        }
        
        return zoneCoords;
    }
}