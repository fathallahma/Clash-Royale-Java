package game;
import java.util.ArrayList;

import game.personnage.Ouvrier;
import game.board.Board;
import game.board.cell.Cell;

/**
 * player's class
 */
public class Player {

	/** 
	 * the attributes of the class
	 */
    private ArrayList<Cell> playercell;
    private int gold, sable,ble,roche,bois,food;
    public final String playername;
    int nbPersonnage;
    private Board  board;
    public ArrayList<Ouvrier> ouvriers;
 
    

    /**
     * class constructor
     * @param Name the name of the player
     * @param typeGame the type of the game
     * @param board the current board
     */

    public Player(String Name, String typeGame,Board board){
    	ouvriers = new ArrayList<>();
    	this.board = board;
        this.playername = Name;
        this.gold = 0;
        food = 0;
        sable = 0;
        roche = 0;
        gold = 0;
        ble = 0;
        this.playercell = new ArrayList<>();
        if (typeGame == "war") {
        	System.out.println("Vous partez avec une armarda de 35 guerriers");
        	nbPersonnage = 35;
        	food = 10;
        }else {
        	System.out.println("Solde de depart GOLD 15 pieces d'or");
        	gold = 15;
        	
        }
    }
    
    /**
     * to get the name of the player
     * @return the name of the player
     */

    public String getName(){
        return this.playername;
    }

    /**
	  * give a cell to the player
	  * @param cellToGive the cell you want to give
	  */
    public void setACellToThePlayer(Cell cellToGive){
        this.playercell.add(cellToGive);
    }

    /**
    * return list of player cell
    * @return ArrayList player's cell
    */
    public ArrayList<Cell> getPlayerCell(){
        return this.playercell;
    }

    /**
     * give gold to the player
     * @param income the amount of gold you want to give
     */

    public void winGold(int income){
        this.gold = this.gold + income;
    }

    /**
    * to get the amount of gold of the player
    * @return the player's gold quantity 
    */

    public int getGold(){
        return this.gold;
    }

    /**
     * method equals
     * @param o the object
     * @return true if the 2 object are equals
     */
    public boolean equals(Object o){
        return this.getClass() == o.getClass();
    }
    /**
    * method toString
    * @return the player's name, the gold of the player and the cell of the player
    */

    public String toString(){
        return "The player " + this.playername +" have " + this.gold + " gold and owns " + this.playercell +".";
    }

    /** to harvest the wood indicated in parameters
     * @param recolteBois the number of wood you want to collect
     */
    
	public void recolteBois(int recolteBois) {
		// TODO Auto-generated method stub
		bois+= recolteBois;
		
	}

	/** to harvest the corn indicated in parameters
     * @param recolteBle the number of corn you want to collect
     */
	
	public void recolteBle(int recolteBle) {
		// TODO Auto-generated method stub
		ble += recolteBle;
		
	}

	/** to harvest the rock indicated in parameters
     * @param recolteBle the number of ble you want to collect
     */
	
	public void recolteRoche(int recolteBle) {
		// TODO Auto-generated method stub
		roche += recolteBle;
		
	}
	
	/** to harvest the sand indicated in parameters
	 * @param recolteSable the number of sand you want to collect
	 */
	
	public void recolteSable(int recolteSable) {
		// TODO Auto-generated method stub
		sable += recolteSable;
		
	}

	/** to add gold to the current amount
     * @param recolteGold the amount of gold you want to collect
     */
	
	public void recolteGold(int recolteGold) {
		// TODO Auto-generated method stub
		gold += recolteGold;
		
	}
	
	/** to remove gold from the current amount
	 * @param nb the amount of gold you want to remove
	 */
	
	public void looseGold(int nb) {
		gold -= nb;
	}
	
	/** to add food to the current amount
	 * @param food the amount of good you want to add
	 */
	
	public void recolteFood(int food) {
		this.food += food;
	}
	
	/** to know if you can take food or not
	 * @param food the number of food you want to take
	 * @return boolean
	 */
	
	public boolean takeFood(int food) {
		if(this.food < food) {
			return false;
		}
		this.food = this.food - food;
		return true;
	}
	
	/** to remove a territory
	 * @param c a cell
	 */
	
	public void removeTerritory(Cell c) {
		//retire la cellule de la liste des cellules du joeur
		playercell.remove(c);
		System.out.println("Tuile retiree de votre armada");
		//rajoute la cellule a la liste des cellule libre du board
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.setOccupied(false);
		board.getBackFree(c);
		
	}
	
	/** to get the amount of corn
	 * @return the amount of corn
	 */
	
	public int getBle() {
		return ble;
	}
	
	/** to set the amount of corn
	 * @param nb the amount of corn you want to set
	 */
	
	public void setBle(int nb) {
		ble = nb;
	}
	
	/** to get the amount of wood
	 * @return the amount of wood
	 */
	
	public int getBois() {
		return bois;
	}
	
	/** to set the amount of wood
	 * @param nb the amount of wood you want to set
	 */
	
	public void setBois(int nb){
		bois = nb;
	}
	
	/** to get the amount of rock
	 * @return the amount of rock
	 */
	
	public int getRoche() {
		return roche;
	}
	
	/** to set the amount of rock
	 * @param nb the amount of rock you want to set
	 */
	
	public void setRoche(int nb) {
		roche = nb;
	}
	
	/** to set the amount of sand
	 * @param nb the amount of sand you want to set
	 */
	
	public void setSable(int nb) {
		sable = nb;
	}
	
	/** to get the amount of sand
	 * @return the amount of sand
	 */
	
	public int getSable() {
		return sable;
	}

	/** to remove a character
     * @param nb the number of character you want to remove
     */
	
	public void removeCharacter(int nb) {
		// TODO Auto-generated method stub
		nbPersonnage -= nb;
		
	}

	/** to get the number of character
     * @return the number of character
     */
	
	public int getNbCharacter() {
		// TODO Auto-generated method stub
		return nbPersonnage;
	}

	/** to remove from the board
     * @param c a cell
     */
	
	public void removeFromBoard(Cell c) {
		board.removeCellFree(c);
		
	}
	
	/** to get the free cell
	 * @return the free cell of the board
	 */
	
	public ArrayList<Cell> getFreeTuiles(){
		return board.getFreeTuile();
	}
	
	/** to remove a free cell from the board
	 * @param c the free cell you want to remove from the board
	 */
	
	public void removeFreeFromBoard(Cell c) {
		board.getFreeTuile().remove(c);
		
	}
	
	
}
