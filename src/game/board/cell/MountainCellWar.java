package game.board.cell;

import exceptions.AutoProcessingException;
import game.board.Board;

/** the mountaincellwar's class
 */
public class MountainCellWar extends MountainCell {
	
	/**
	 * class constructor
	 * @param nbOfRow the number of the row
	 * @param nbOfColumn the number of the column
	 * @param board the board
	 */

	public MountainCellWar(int nbOfRow, int nbOfColumn, Board board) {
		super(nbOfRow, nbOfColumn, board);
		super.MAX = 3;
		// TODO Auto-generated constructor stub
	}

	@Override
	
	/** to set a characters
	 * @param nbPersonnage the number of characters you want to set
	 * @throws AutoProcessingException AutoProcessingException
	 */
	public void setPersonnage(int nbPersonnage) throws AutoProcessingException{
		if(nbPersonnage > 3 || nbPersonnage < 0) throw new AutoProcessingException("to much person:(Max 3)");
		this.nbPersonnage = nbPersonnage ;
	}
}
