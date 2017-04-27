package murdermansion;
import java.util.*;

/**
 * Encapsulates the properties of a 'Character'.  It is a sub-class of the class 'Person'.  Characters are Non-playable players in the game.  They
 * may have dialogue and other attributes that human players may not have.
 * 
 *
 * @author Nathaniel Gatewood
 * @date 04/15/2017
 */
public class Character extends Person
{
    private String characterDescription;
    public ArrayList<String> dialogue;

    /**-------------------------------------------------------------------------------*
     * CONSTRUCTOR
     **-------------------------------------------------------------------------------*/
    public Character(String characterName, String characterDescription, ArrayList<String> dialogue)
    {
        super(characterName);
        this.characterDescription = characterDescription;
        this.dialogue = dialogue;
    }
    
    /**-------------------------------------------------------------------------------*
     * .printDescription(). Print the characters description
     **-------------------------------------------------------------------------------*/
    public void printCharacterDescription()
    {
        String[] words = characterDescription.split("\\s");
        int lineLength = 0;
        
        System.out.println();
        
        for(String word : words){
            
            if((lineLength+word.length()) > 80){
                
                System.out.println();
                lineLength = 0;
            }

            System.out.print(" "+word);
            lineLength += word.length();
        }
        
        System.out.println("\n");
    }
    
    /**-------------------------------------------------------------------------------*
     * .pringDialogue(). Retrieve a list of murder room zone objects
     **-------------------------------------------------------------------------------*/
    public void printDialogue()
    {
        Random rand = new Random();
        int randNum = rand.nextInt(dialogue.size());
        
        System.out.println("\n"+super.getPlayerName()+" says: \""+dialogue.get(randNum)+"\"\n");
    }
}

