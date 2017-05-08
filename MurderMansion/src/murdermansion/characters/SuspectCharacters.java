package murdermansion.characters;
import java.util.*;

/**
 * Class containing a list of the game's murder suspects.  Used to determine the murderer and populate the map zones with the different characters
 * 
 * @author Nathaniel Gatewood and Donna Mobley
 * @date 04/15/2017
 */
public class SuspectCharacters
{
    // instance variables - replace the example below with your own
    private ArrayList<Character> suspectCharacters;

    /**-------------------------------------------------------------------------------*
     * .CONSTRUCTOR. 
     **-------------------------------------------------------------------------------*/
    public SuspectCharacters()
    {
        suspectCharacters = new ArrayList<Character>();
        
        /* Miss Scarlet 
         ---------------*/
        ArrayList<String> dialogue1 = new ArrayList<String>();
        dialogue1.add("I love the color red, but I can't stand the sight of blood.");
        dialogue1.add("How dare you, sir!  I barely knew Mr. Beard.  Why on earth would I murder him?");
        dialogue1.add("Would you like a cupcake?  I can't get enough of them.");
        suspectCharacters.add(new Character("Miss Scarlet", "Even though she's young, cunning, and highly attractive you get the sense she's not what "+
                                            "she claims to be.  Perhaps she is hiding something.", dialogue1));
        
        /* Col. Mustard
         ---------------*/
        ArrayList<String> dialogue2 = new ArrayList<String>();
        dialogue2.add("Mr. Beard was a local nuisance.  He would have never survived in the trenches.");
        dialogue2.add("I'm too old to go to jail.");
        dialogue2.add("Eh?  Speak up!  Too many years on the battlefield has left my hearing in tatters.");
        suspectCharacters.add(new Character("Col. Mustard", "Quite the dapper military man.  Wearing a tweed suit and sporting white fuzzy mutton chops, "+
                                            "you can't help but like the guy.  His thick gray hair and wrinkles hint that he may have a "+
                                            "lot to share about life.", dialogue2));
        /* Mrs. White
         ---------------*/
        ArrayList<String> dialogue3 = new ArrayList<String>();
        dialogue3.add("How dare you accuse me of murder!");
        dialogue3.add("Did you see what Mr. Beard was wearing? Dreadful!");
        dialogue3.add("What??  That's not blood!  I spilled spaghetti sauce on my shirt.");
        suspectCharacters.add(new Character("Mrs. White", "Wearing the traditional house-maid garb, she appears to be a servant.  The first thing you "+
                                            "notice about her is she seems timid; very timid.  Maybe she has something to hide?", dialogue3));
        /* Mr. Green
         ---------------*/
        ArrayList<String> dialogue4 = new ArrayList<String>();
        dialogue4.add("Mr. Body and I were best friends so I would never had murdered him.");
        dialogue4.add("How could anyone do that?  Who am I going to play chess with now?");
        dialogue4.add("As far as I know, he lived alone.  Make sure someone feeds his cats.");
        suspectCharacters.add(new Character("Mr. Green", "Judging from his collar, he appears to be a man of the cloth.  His demeanor is very pleasant, "+
                                            "however, you get the feeling part of it is an act.  His ", dialogue4));
        /* Mrs. Peacock
         ---------------*/
        ArrayList<String> dialogue5 = new ArrayList<String>();
        dialogue5.add("I only met Mr. Broddy for the first time tonight.");
        dialogue5.add("He seemd to have quite a bit to drink.  Maybe this was an accident?");
        dialogue5.add("I did see a face in the window of the Ballroom.");
        suspectCharacters.add(new Character("Mrs. Peacock", "An elderly, yet elegant aristocrat.  She bears a Queen-like resemblance with the diamond "+
                                            "tiara on her head.  A hat of peacock feathers sits on top of her head.  You chuckle under your breath. "+
                                            "It looks ridiculous.", dialogue5));
        /* Professor Plum
         ---------------*/
        ArrayList<String> dialogue6 = new ArrayList<String>();
        dialogue6.add("I am too smart to get caught red handed.");
        dialogue6.add("That's a nice magnifying glass.  Quite ametropic and completely refractable!");
        dialogue6.add("Mr. Beard seemed like a nice chap.  He would have made a good lab assistant.");
        suspectCharacters.add(new Character("Professor Plum", "A youthful pontificating scientist, he quickly gets on your nerves.  His thick glasses "+
                                            "magnify his eyes to twice their size and his hair looks like a greasier versions of Einstein's.", dialogue6));
    }
    
    /**-------------------------------------------------------------------------------*
     * .getSuspectCharacters(). Return the arraylist of Character players
     **-------------------------------------------------------------------------------*/
    public ArrayList<Character> getSuspectCharacters(){
    
        return suspectCharacters;
    }
    
    /**-------------------------------------------------------------------------------*
     * .getMurdererCharacter(). Randomly returns the murderer
     **-------------------------------------------------------------------------------*/
     public Character getMurdererCharacter(){
         
        Random rand = new Random();
        int randNum = rand.nextInt(suspectCharacters.size());
        
        Character thisCharacter = suspectCharacters.get(randNum);
        suspectCharacters.remove(randNum);
        
        return thisCharacter;
     }
}
