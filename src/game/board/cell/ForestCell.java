package game.board.cell;
import exceptions.AutoProcessingException;
import exceptions.SizeLimitExceededException;
import game.board.Board;

/**
 * the forestcell's class
 */
public class ForestCell extends Cell{

	/**
	 * class constructor
	 * @param nbOfRow the number of the row
	 * @param nbOfColumn the number of the column
	 * @param board the board
	 */
    public ForestCell(int nbOfRow,int nbOfColumn, Board board){
		super(nbOfRow,nbOfColumn, board);
	}

    /** to set characters
	 * @param nbPersonnage the number of characters you want to set
	 * @throws AutoProcessingException AutoProcessingException 
	 */
	public void setPersonnage(int nbPersonnage) throws AutoProcessingException{
		super.setPersonnage(nbPersonnage) ;
	}

	/**
	 * method toString
	 * @return the type and the index of the cell
	 */
	public String toString(){
		return "ForestCell(" + this.numRow + "," + this.numColumn + ")"; 
		//exmeple : ForestCell(4,5)
	}
	public void print() {
		System.out.print("F");
	}
	
	/** to get the type
	 * @return the type of the cell
	 */
	
	public String getType() {
		return "Forest";
	}
    
    
}
