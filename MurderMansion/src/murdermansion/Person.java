package murdermansion;

/**
 * Write a description of class Person here.
 * 
 * @author Nathaniel Gatewood and Donna Mobley
 * @date 04/15/2017
 */
public class Person
{
    private String playerName;
    
    /**-------------------------------------------------------------------------------*
     * .Person(). Constructor 
     **-------------------------------------------------------------------------------*/
    public Person(String playerName)
    {
        this.playerName = playerName;
    }
    
    /**-------------------------------------------------------------------------------*
     * .getPlayerName(). return the player's name
     **-------------------------------------------------------------------------------*/
    public String getPlayerName(){
   
        return playerName;
    }
}