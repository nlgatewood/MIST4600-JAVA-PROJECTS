package murdermansion;
import java.util.*;

/**
 * Class containing a list of the game's murder weapons.  Used to determine the murder weapon and populate the map zones with the items.
 * 
 * @author Nathaniel Gatewood and Donna Mobley
 * @date 04/15/2017
 */
public class WeaponItems
{
    private ArrayList<Item> weaponItems;
    
    /**-------------------------------------------------------------------------------*
     * .WeaponItems(). Constructor
     **-------------------------------------------------------------------------------*/
    public WeaponItems()
    {
        weaponItems = new ArrayList<Item>();
        weaponItems.add(new Item("Candlestick", "An old, golden candlestick with a heavy base. It seems it hasn't been used in a while", 
                                 "You try to light the candle but the wick is stuck in the wax.", null, null));
        weaponItems.add(new Item("Knife", "A bone-handle knife with a silver blade. It seems to have been kept very sharp.", 
                                 "You pull a slim jim out of your pocket.  Finally, I can cut this open!", null, null));
        weaponItems.add(new Item("Rope", "A long hemp rope fraying on each end.", 
                                 "You began jump-roping with the rope.  This is so much fun!", null, null));
        weaponItems.add(new Item("Lead Pipe", "A thin, but long, lead pipe. It is surprisingly heavy.  Is that blood on the end?", 
                                 "You lift the lead pipe to your mouth and began playing it like a trumpet. What's wrong with you?", null, null));
        weaponItems.add(new Item("Revolver", "An old 6-round revolver.  Three rounds still remain.  The barrel smells like it has recently been fired.", 
                                 "You aim at the lamp in the corner of the room.  *click* *BOOM!*", null, null));
        weaponItems.add(new Item("Wrench", "A long, red monkey wrench.  It's covered in oils and grease up and down the handle.",
                                 "You lift the wrench above your head, pointing it like a wand; 'Expecto Patronum!' you yell...nothing", null, null));
    }

    /**-------------------------------------------------------------------------------*
     * .getWeaponItems(). Return the weaponItems arrayList
     **-------------------------------------------------------------------------------*/
    public ArrayList<Item> getWeaponItems(){
    
        return weaponItems;
    }
    
    /**-------------------------------------------------------------------------------*
     * .getMurderItem(). Return a random weapon.  Used to choose the murder weapon
     **-------------------------------------------------------------------------------*/
    public Item getMurderItem(){
    
        Random rand = new Random();
        int randNum = rand.nextInt(weaponItems.size());
        
        Item thisItem = weaponItems.get(randNum);
        weaponItems.remove(randNum);
        
        return thisItem;
    }
}
