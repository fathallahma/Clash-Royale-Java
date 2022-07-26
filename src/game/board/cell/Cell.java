package game.board.cell;
import game.board.Board;
import exceptions.AutoProcessingException;
import game.Player;

/**
 * the cell class
 */
public abstract class Cell {
     
	/**
	 * the attributes of the class
	 */
	
	protected final int numColumn;
	protected final int numRow;
	protected Player player;
	protected Board board;
	protected boolean isOccupied;
	protected int nbPersonnage;
	private int gold,ble,bois,roche,sable;
	public int MAX = 5; 
	
	/**
	 * constructor
	 * @param numRow the number of the row
	 * @param numColumn the number of the column
	 * @param board the board
	 */
	public Cell(int numRow,int numColumn,Board board){
		this.board = board;
		this.numColumn = numColumn;
		this.numRow = numRow ;
		this.player=null;
		isOccupied = false;
		nbPersonnage = 0;
		gold = 0;
		ble=0;
		roche = 0;
		bois = 0;
		sable = 0;
	}



	/**
	 * return true if the cell is occupied
	 * @return boolean true/false
	 */
	public boolean isOccupied(){
		return isOccupied;
	}
	
	/**
	 * to set an occupied cell
	 * @param b true/false
	 */
	
	public void setOccupied(boolean b) {
		isOccupied = b;
	}

	/**
	 * set the character
	 * @param nbPersonnage the number of character you want to set
	 * @throws AutoProcessingException AutoProcessingException
	 */
	
	public void setPersonnage(int nbPersonnage) throws AutoProcessingException{
		if(nbPersonnage > 5 || nbPersonnage < 0) throw new AutoProcessingException("to much person:(Max 5)");
		this.nbPersonnage = nbPersonnage ;
	}
	
	/** to add a character
	 * @param nb number of character you want to add
	 * @return number of character added
	 */
	
	public int addPersonnage(int nb) {
		int tmp = nbPersonnage + nb;
		if(tmp > 5) {
			nbPersonnage = 5;
		}else {
			nbPersonnage = tmp;
		}
		return nbPersonnage;
		
		
	}
	
	/** to get the number of character
	 * @return the number of character
	 */
	
	public int getnbPersonnage(){
		return nbPersonnage;
	}
    
	/** to get the board
	 * @return the board
	 */
	
	public Board getBoard() {
		return board;
	}



	/** to get the number of column
	 *
	 * @return the number of column
	 */
	
	public int getNumColumn(){
		return this.numColumn;
	}

	/** to get the number of row
	 *
	 * @return the number of row
	 */
	
	public int getNumRow(){
		return this.numRow;
	}

	/**
	 * to get the cell at the top of the current cell
	 * @return the cell in the top of the current cell
	 */

	public Cell topOfCell(){
		//return new Cell(getNbOfRow()-1,getNbOfColumn());
		if(getNumRow() == 0) return null;
		return board.getTopOfCell(numRow, numColumn);
	}

	/**
	 *  to get the cell at the bottom of the current cell
	 * @return the cell at the bottom of the current cell
	 */
	
	public Cell downOfCell(){//Gerer le cas ou la cell est deja 
		return board.getDownOfCell(numRow, numColumn);
	}

	/**
	 * to get the cell to the left of the current cell
	 * @return the cell to the left of the current cell
	 */
	
	public Cell leftOfCell(){
		return board.getLeftOfCell(numRow, numColumn);
	}

	/**
	 * to get the cell to the right of the current cell
	 * @return the cell to the right of the current cell
	 */
	
	public Cell rightOfCell(){
		return board.getRightOfCell(numRow, numColumn);
	}

	/**
	 * to get the player
	 * @return the player
	 */
	
	public Player getPlayer(){
		return this.player;
	}
	
	/**
	 * to set the first player
	 * @param player the player you want to set first
	 */
	
	public void setFirsPlayer(Player player) {
		this.player = player;
	}

	/** to set a player
	 * 
	 * @param player the player you want to set
	 */
	
	public void setPlayer(Player player){
		//retire cell de la liste de l'ancien proprietaire
		this.player.getPlayerCell().remove(this);
		this.player = player;
		//ajoute a la liste du nouveau
		this.player.getPlayerCell().add(this);
	}
	
	/** to change the current size of characters to half
	 */
	
	public void changeSizeToHalf(){
    	this.nbPersonnage = (int)this.nbPersonnage/2;
    }
	
	/** to add gold to the current amount
	 * @param g the number of gold you want to add
	 * @return the amount of gold
	 */
	
	public int addGold(int g) {
		gold+= g;
		System.out.println("Vous avez "+gold+" pieces d'or");
		return gold;
	}
	
	/** to harvest the gold
	 * @return the number of gold collected
	 */
	
	public int recolteGold() {
		int tmp = gold;
		gold = 0;
		return tmp;
	}
	
	/** to harvest sand
	 * @return the number of sand collected
	 */
	
	public int recolteSable() {
		int tmp = sable;
		sable = 0;
		return tmp;
	}
	
	/** to harvest wood
	 * @return the number of wood collected
	 */
	
	public int recolteBois() {
		int tmp = bois;
		bois = 0;
		return tmp;
	}
	
	/** to harvest rock
	 * @return the number of rock collected
	 */
	
	public int recolteRoche() {
		int tmp = roche;
		roche = 0;
		return tmp;
	}
	
	/** to harvest corn
	 * @return the number of corn collected
	 */
	
	public int recolteBle() {
		int tmp = ble;
		ble = 0;
		return tmp;
	}



	/**
	 * method toString
	 * @return String The index of the cell
	 */
	public String toString(){
		return "Cell (" + this.numRow + "," + this.numColumn + ")"; 
		//exmeple : Cell(4,5)
	}
	public abstract void print(); 
	public abstract String getType();


}

