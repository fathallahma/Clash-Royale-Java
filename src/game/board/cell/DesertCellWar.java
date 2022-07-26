package game.board.cell;

import exceptions.AutoProcessingException;
import game.board.Board;

/** 
 * the desertcellwar's class
 */

public class DesertCellWar extends DesertCell{

	/** 
	 * class constructor
	 * @param nbOfRow the number of the row
	 * @param nbOfColumn the number of the column
	 * @param board the board
	 */
	public DesertCellWar(int nbOfRow, int nbOfColumn, Board board) {
		super(nbOfRow, nbOfColumn, board);
		super.MAX = 3;

	}

	@Override
	/**to set characters
	 * @param nbPersonnage the number of characters you want to set
	 */
	
	public void setPersonnage(int nbPersonnage) throws AutoProcessingException{
		if(nbPersonnage > 3 || nbPersonnage < 0) throw new AutoProcessingException("to much person:(Max 3)");
		this.nbPersonnage = nbPersonnage ;
	}

}
