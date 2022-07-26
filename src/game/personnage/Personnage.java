package game.personnage;

import game.board.cell.Cell;

/**
 * character's class
 */
public abstract class Personnage {
    //protected int stockPerso ;
    //protected int stockNourriture;

    /**
     * attributes of the class
     */
    public int gold ;
    public int size;
	protected int stockNourriture;
	protected int stockPerso;
	protected Cell cell;

    /**
     * class constructor
     * @param gold the amount of gold
     * @param size the size
     */
    public Personnage(int gold,int size) {
        this.gold = gold;
        this.size = size;
    }
    
    /**
     * second class constructor
     * @param gold the amount of gold
     * @param size the size
     * @param c the cell
     */
    public Personnage(int gold,int size, Cell c) {
    	this(gold,size);
    	this.cell = c;
    }

    /**
     * to get the amount of gold
     * @return the current amount of gold
     */
    public int getSizeGold(){
        return this.gold ;
    }

    
    /** 
     * to get the current size of characters
     * @return the size
     */
    
    public int getSize(){
        return this.size ;
    }

    /** 
     * to change to change the current size of the people to half
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

    /** to set the stock of characters
     * @param stockPerso the number of characters you want to stock
     */
    
    public void setStockPerso(int stockPerso ){
      this.stockPerso=stockPerso;
    }

    /** to get the stock of characters
     * @return the number of stockPerso
     */
    
    public int getStockPerso( ){
      return this.stockPerso;
    }
    
    /** to set the stock of food
     * @param stockNourriture the number of food you want to stock
     */
    
    public void setstockNourriture(int stockNourriture ){
      this.stockNourriture=stockNourriture;
    }

    /** to get the stock of food
     * @return the number of stockNourriture
     */
    
    public int getstockNourriture( ){
      return this.stockNourriture;
    }


    /** to make someone win gold
     * @param G the amount of gold you want to add
     * @return the sentence under
     */
    
    public String winGold(int G){
        this.gold += G ;
        return "win the gold" ;
    }




    /** */
    public abstract String toString() ;


}
