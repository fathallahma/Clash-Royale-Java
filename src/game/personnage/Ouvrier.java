package game.personnage;

import game.board.cell.Cell;

/**
 * worker's class
 */
public class Ouvrier extends Personnage{
	

    /**
     * class cosntructor
     * @param gold te amount of gold
     * @param size the size
     * @param c the current cell
     */
    public Ouvrier(int gold,int size, Cell c){
        super(gold,size,c);
    }

    /**
     * to get the amount of gold
     * @return the amount of gold
     */
    public int getQuantiteDor(){
        return super.getSizeGold() ;
    }


    /**
     * Function that returns the size
     * @return the size
     */
    public int getSize(){
        return super.getSize() ;
    }

    /**
     *  to change the current size of workers to half
     */
    public void changeSizeToHalf(){
        super.changeSizeToHalf();
    }

    /** 
     * to add someone to the current unity
     */
    public void changeSizeAddedUnity(){
        super.changeSizeAddedUnity();
    }

    /**
     * method winGold
     * @return the phrase under
     */
    public String winGold(int G){
        super.winGold(G);
        return "the worker win gold coins" ;
    }

    /** 
     * method toString
     * @return the amount of gold
     */
    public String toString(){
        return "the worker has " + this.getQuantiteDor() + " gold coins." ;
    }

    /**
     * method equals
     * @return True if this 2 objects are equals and false if not
     */
    public boolean equals(Object O){
        if (O instanceof Ouvrier) {
			Ouvrier Other = ((Ouvrier) O);
			return this.getQuantiteDor() == Other.getQuantiteDor() ;
		} else {
			return false;
		}
    }
    
    /*public Cell getTypeCell() {
    	return super.cell;
    }*/

    /** to get the cell
     * @return the cell
     */
    
	public Cell getCell() {
		// TODO Auto-generated method stub
		return super.cell;
	}

}
