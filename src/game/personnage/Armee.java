package game.personnage;

import exceptions.SizeLimitExceededException;
import game.Player;

/** 
 * the army class
 */

public class Armee{

    /** 
     * the attributes of the class
     */
    private int size,gold;
    
    /** class constructor
     * @param gold the amount of gold
     * @param size the size of the army
     * @param player the player 
     * @throws SizeLimitExceededException SizeLimitExceededException
     */
    public Armee(int gold, int size, Player player) throws SizeLimitExceededException{
        this.size = size;
        this.gold = gold;
    }
                                                                                        
    /**
     * Function that returns the size
     * @return the size
     */
    public int getSize(){
        return size ;
    }

    /** 
     * to change the current size of the army to half
     */
    public void changeSizeToHalf(){
    	this.size = (int)this.size/2;
    }

    /** 
     * to add someone to the current unity
     */
    public void changeSizeAddedUnity(){
    	if (this.size==5){
            System.out.println("nothing to add");
          }
          else {
            this.size += 1;
          }
    }

    /**
     * to get the amount of gold
     * @return the amount of gold
     */
    public int getQuantiteDor(){
        return gold ;
    }

    /** 
     * to add gold to the current amount
     * @param G the number of gold you want to add
     * @return string
     */
    public String winGold(int G){
    	this.gold += G ;
        return "win the gold" ;
    }

    /**
     * method toString
     * @return the size and the amount of gold
     */
    public String toString(){
        return "this armee has " + this.size + " soldat, and " + this.getQuantiteDor() + " gold coins"  ;
    }

    /**
     * method equals return true if the objects are equal
     * @return boolean true/false
     */
    public boolean equals(Object O){
        if (O instanceof Armee) {
			Armee Other = ((Armee) O);
			return this.size == Other.getSize()
					&& this.getQuantiteDor() == Other.getQuantiteDor() ;
		} else {
			return false;
		}
    }

}
