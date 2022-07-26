package game.board.cell;

import game.board.Board;

/**
 * the oceancell's class
 */
public class OceanCell extends Cell{

	/**
	 * class constructor
	 * @param nbOfRow the number of the row
	 * @param nbOfColumn the number of the column
	 * @param board the board
	 */
    public OceanCell(int nbOfRow,int nbOfColumn, Board board){
		super(nbOfRow,nbOfColumn, board);
	}

	/**
	 * method toString
	 * @return the type and the index of the cell
	 */
	public String toString(){
		return "OceanCell(" + this.numRow + "," + this.numColumn + ")"; 
		//exmeple : OceanCell(4,5)
	}
	public void print() {
		System.out.print("O");
	}
	
	/** to get the type
	 * @return the type of the cell
	 */
	
	public String getType() {
		return "Ocean";
	}
    
}
