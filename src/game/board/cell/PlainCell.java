package game.board.cell;
import exceptions.AutoProcessingException;
import exceptions.SizeLimitExceededException;
import game.board.Board;

/**
 * the plaincell's class
 */
public class PlainCell extends Cell{

	/**
	 * class constructor
	 * @param nbOfRow the number of the row
	 * @param nbOfColumn the number of the column
	 * @param board the board
	 */
    public PlainCell(int nbOfRow,int nbOfColumn, Board board){
		super(nbOfRow,nbOfColumn, board);
	}

    /** to set a characters
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
		return "PlainCell(" + this.numRow + "," + this.numColumn + ")"; 
		//exmeple : PlainCell(4,5)
	}
    
	public void print() {
		System.out.print("P");
	}
	
	/** to get the type
	 * @return the type of the cell
	 */
	
	public String getType() {
		return "Plain";
	}
    
}
