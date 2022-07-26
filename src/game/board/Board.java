package game.board;

import java.util.ArrayList;
import java.util.Random;
import game.board.cell.*;

/**
 * class for the construction of the board
 */
public class Board {
	public final Cell[][] theCells;
	private Cell[][] onBoard;
	private Cell[][] cellFree;
	private int nbCellDesert = 0;
	private int nbCellForest = 0;
	private int nbCellMountain = 0; 
	private int nbCellPlain = 0 ;
	private int numberOfRows, numberOfColumns;
	private ArrayList<Cell> freeTuiles;
	private int sizeBoard;
     
	
	/** 
	 * class constructor
	 * @param numberOfRows the number of rows
	 * @param numberOfColumns the number of columns
	 */
	public Board(int numberOfRows,int numberOfColumns){

		this.numberOfRows =numberOfRows;
		this.numberOfColumns =numberOfColumns;

		cellFree = new Cell[numberOfRows][numberOfColumns];
		onBoard = new Cell[numberOfRows][numberOfColumns];
		sizeBoard = (int) numberOfColumns*numberOfRows ;
		freeTuiles = new ArrayList<Cell>();

		//initialisation du board
		for(int i=0 ; i< numberOfRows ; i++) {
			for(int j = 0; j < numberOfColumns; j++) {
				onBoard[i][j] = new OceanCell(i,j, this);
				int type =new Random().nextInt(4);
				cellFree[i][j] = createCell(i,j, type);
			}
		}

		fillBoard();
		theCells = onBoard;

		for(int i=0 ; i < numberOfRows ; i++) {
			for(int j = 0; j < numberOfColumns; j++) {
				theCells[i][j].print();
			}
			System.out.println();
		}

	}

	
	private void fillBoard() {
		int i =0;
		Cell cell;

		while(i < (sizeBoard *1/3)) {			
			//derniere tuile a ajouter
			if(i == (sizeBoard *1/3 )- 2){
				for(int j =0; j < freeTuiles.size();j++) {
					if(haveAdjacentFree(freeTuiles.get(j))) {
						cell = getFreeAdjacent(freeTuiles.get(j));
						onBoard[cell.getNumRow()][cell.getNumColumn()] = cell;
						freeTuiles.add(cell);
						cellFree[cell.getNumRow()][cell.getNumColumn()] = null;
						i++;
						break;
					}
				}
				break;
			}

			int x = new Random().nextInt(numberOfRows);
			int y = new Random().nextInt(numberOfColumns);
			do {
				x = new Random().nextInt(numberOfRows);
				y = new Random().nextInt(numberOfColumns);	
			}while(cellFree[x][y] == null);
			cell = cellFree[x][y]; 
			onBoard[x][y] = cell;
			freeTuiles.add(cell);
			i++;
			cellFree[cell.getNumRow()][cell.getNumColumn()] = null;
			
			
			if(haveAdjacentBoard(cell) == false) {
				Cell adjacent = getFreeAdjacent(cell);
				onBoard[adjacent.getNumRow()][adjacent.getNumColumn()] = adjacent;
				freeTuiles.add(adjacent);
				cellFree[adjacent.getNumRow()][adjacent.getNumColumn()] = null;
				i++;
			}


		}


	}

	public boolean haveAdjacentFree(Cell c){
		return getFreeAdjacent(c) != null;
	}

	public boolean haveAdjacentBoard(Cell c){
		return getBoardAdjacent(c) != null;
	}

	public Cell getBoardAdjacent(Cell c){
		Cell cell =getLeftOfCell(c.getNumRow(), c.getNumColumn());
		if(cell != null && cell.getType().equals("Ocean") == false) return cell;
		cell =getTopOfCell(c.getNumRow(), c.getNumColumn());
		if(cell != null && cell.getType().equals("Ocean") == false) return cell;
		cell =getRightOfCell(c.getNumRow(), c.getNumColumn());
		if(cell != null && cell.getType().equals("Ocean") == false) return cell;
		cell =getDownOfCell(c.getNumRow(), c.getNumColumn());
		if(cell != null && cell.getType().equals("Ocean") == false) return cell;
		return null;

	}
	
	public ArrayList<Cell> getAllBoardAdjacent(Cell c){
		ArrayList<Cell> liste = new ArrayList<>();
		Cell cell =getLeftOfCell(c.getNumRow(), c.getNumColumn());
		if(cell != null && cell.getType().equals("Ocean") == false) liste.add(cell);
		cell =getTopOfCell(c.getNumRow(), c.getNumColumn());
		if(cell != null && cell.getType().equals("Ocean") == false) liste.add(cell);
		cell =getRightOfCell(c.getNumRow(), c.getNumColumn());
		if(cell != null && cell.getType().equals("Ocean") == false) liste.add(cell);
		cell =getDownOfCell(c.getNumRow(), c.getNumColumn());
		if(cell != null && cell.getType().equals("Ocean") == false) liste.add(cell);
		return liste;

	}

	/**
	 * to get a cell adjacent to c for the construction of the board
	 * @param c the current cell
	 * @return c the adjacent cell
	 * */
	private Cell getFreeAdjacent(Cell c){
		Cell cell =getLeftOfCellFree(c.getNumRow(), c.getNumColumn());
		if(cell != null ) return cell;
		cell =getTopOfCellFree(c.getNumRow(), c.getNumColumn());
		if(cell != null) return cell;
		cell =getRightOfCellFree(c.getNumRow(), c.getNumColumn());
		if(cell != null) return cell;
		cell =getDownOfCellFree(c.getNumRow(), c.getNumColumn());
		if(cell != null) return cell;
		return null;

	}
	
	/** 
	 * to create a cell
	 * @param i the row
	 * @param j the column
	 * @param type the type of the cell
	 * @return c the created cell
	 */
	private Cell createCell(int i, int j, int type) {
		Cell c = null;
		if(type == 0) {
			setNbCellDesert(getNbCellDesert() + 1);
			c = new DesertCellWar(i,j,this);
		}
		if(type == 1) {
			setNbCellMountain(getNbCellMountain() + 1);
			c = new MountainCellWar(i,j,this);
		}
		if(type == 2){
			setNbCellForest(getNbCellForest() + 1);
			c = new ForestCell(i,j,this);
		}
		if(type == 3){
			setNbCellPlain(getNbCellPlain() + 1);
			c = new PlainCell(i,j,this);
		}
		return c;
	}



	/**
	 * initializes the board
	 */
	//abstract protected void initBoard();

	/**
	 *  to get a cell
	 * @param numberOfRow the number of the row
	 * @param numberOfColumn the number of the column
	 * @return the cell 
	 */
	
	public Cell getCell(int numberOfRow,int numberOfColumn){
		return this.theCells[numberOfRow][numberOfColumn];
	}

	/**
	 * to change a cell to ocean
	 * @param i the number of the row
	 * @param j the number of the column
	 */
	
	@SuppressWarnings("unused")
	private void changeCelltoOcean(int i,int j){
		this.theCells[i][j] = new OceanCell(i,j,this);
	}
	
	/**
	 * to change a cell to desert
	 * @param i the number of the row
	 * @param j the number of the column
	 */
	
	@SuppressWarnings("unused")
	private void changeCelltoDesert(int i,int j){
		this.theCells[i][j] = new DesertCell(i,j,this);
	}
	
	/** to change a cell to forest
	 * @param i the number of the row
	 * @param j the number of the column
	 */
	
	@SuppressWarnings("unused")
	private void changeCelltoForest(int i,int j){
		this.theCells[i][j] = new ForestCell(i,j,this);
	}

	/** to change a cell to mountain
	 * @param i the number of the row
	 * @param j the number of the column
	 */
	
	@SuppressWarnings("unused")
	private void changeCelltoMountain(int i,int j){
		this.theCells[i][j] = new MountainCell(i,j,this);
	}
	
	/** to change a cell to plain
	 * @param i the number of the row
	 * @param j the number of the column
	 */
	
	@SuppressWarnings("unused")
	private void changeCellPlain(int i,int j){
		this.theCells[i][j] = new PlainCell(i,j,this);
	}


	/** to get the cell at the top of the current cell
	 * @param numberOfRow the number of the row
	 * @param numberOfColumn the number of the column
	 * @return the cell at the top of the current cell
	 */
	private Cell getTopOfCellFree(int numberOfRow,int numberOfColumn){
		if (numberOfRow == 0 ) {
			return null;
		}
		if(this.cellFree[numberOfRow-1][numberOfColumn] == null) {
			return null;
		}
		return this.cellFree[numberOfRow-1][numberOfColumn];
	}

	/** to get the cell at the bottom of the current cell
	 * @param numberOfRow the number of the row
	 * @param numberOfColumn the number of the column
	 * @return the cell at the bottom of the current cell
	 */
	
	private Cell getDownOfCellFree(int numberOfRow,int numberOfColumn){
		if (this.numberOfRows-1 == numberOfRow ) {
			return null;
		}
		if(this.cellFree[numberOfRow+1][numberOfColumn] == null) {
			return null;
		}
		return this.cellFree[numberOfRow+1][numberOfColumn];
	}

	/** to get the cell to the left of the current cell
	 * @param numberOfRow the number of the row
	 * @param numberOfColumn the number of the column
	 * @return the cell to the left of the current cell
	 */
	
	private Cell getLeftOfCellFree(int numberOfRow,int numberOfColumn){
		if (numberOfColumn == 0) {
			return null;
		}
		if(cellFree[numberOfRow][numberOfColumn-1] == null) {
			return null;
		}
		return this.cellFree[numberOfRow][numberOfColumn-1];
	}

	/** to get the cell to the right of the current cell
	 * @param numberOfRow the number of the row
	 * @param numberOfColumn the number of the column
	 * @return the cell to the right of the current cell
	 */
	
	private Cell getRightOfCellFree(int numberOfRow,int numberOfColumn){
		if (this.numberOfColumns -1 == numberOfColumn) {
			return null;
		}
		if(this.cellFree[numberOfRow][numberOfColumn+1] == null) {
			return null;
		}
		return this.cellFree[numberOfRow][numberOfColumn+1];
	}
    
	/** to get the cell at the top of the current cell
	 * @param numberOfRow the number of the row
	 * @param numberOfColumn the number of the column
	 * @return the cell at the top of the current cell
	 */
	
	public Cell getTopOfCell(int numberOfRow,int numberOfColumn){
		if (numberOfRow == 0 ) {
			return null;
		}
		if(this.onBoard[numberOfRow-1][numberOfColumn] == null) {
			return null;
		}
		return this.onBoard[numberOfRow-1][numberOfColumn];
	}
	
	/** to get the cell to the right of the current cell
	 * @param numberOfRow the number of the row
	 * @param numberOfColumn the number of the column
	 * @return the cell to the right of the current cell
	 */
	
	public Cell getRightOfCell(int numberOfRow,int numberOfColumn){
		if (this.numberOfColumns -1 == numberOfColumn) {
			return null;
		}
		if(this.onBoard[numberOfRow][numberOfColumn+1] == null) {
			return null;
		}
		return this.onBoard[numberOfRow][numberOfColumn+1];
	}


	/** to get the cell at the bottom of the current cell
	 * @param numberOfRow the number of the row
	 * @param numberOfColumn the number of column
	 * @return the cell at the bottom of the current cell
	 */
	
	public Cell getDownOfCell(int numberOfRow,int numberOfColumn){
		if (this.numberOfRows - 1 == numberOfRow ) {
			return null;
		}
		if(this.onBoard[numberOfRow+1][numberOfColumn] == null) {
			return null;
		}
		return this.onBoard[numberOfRow+1][numberOfColumn];
	}

	/** to get the cell to the left of the current cell
	 * @param numberOfRow the number of the row
	 * @param numberOfColumn the number of the column
	 * @return the cell to the left of the current cell
	 */
	
	public Cell getLeftOfCell(int numberOfRow,int numberOfColumn){
		if (numberOfColumn == 0) {
			return null;
		}
		if(onBoard[numberOfRow][numberOfColumn-1] == null) {
			return null;
		}
		return this.onBoard[numberOfRow][numberOfColumn-1];
	}

	/**
	 * Returns the number of cells in the board (not counting the start cell)
	 *  @return the number of cells in the board
	 */
	
	public int getNbOfCells(){
		return this.theCells.length * this.theCells[0].length ;
	}

	/** to get the number of row in the board
	 * @return the number of row in the board
	 */
	
	public int nbOfRow(){
		return this.theCells.length ;
	}

	/** to get the number of column in the board
	 * @return the number of column in the board
	 */
	
	public int nbOfColumn(){
		return this.theCells[0].length ;
	}

	/** to get the number of desert cells in the board
	 * @return the number of desert cells in the board
	 */
	
	public int getNbCellDesert() {
		return nbCellDesert;
	}
    
	/** to set the number of desert cells in the board
	 * @param nbCellDesert number of desert cells you want to set in the board
	 */
	
	public void setNbCellDesert(int nbCellDesert) {
		this.nbCellDesert = nbCellDesert;
	}

	/** to get the number of mountain cells in the board
	 * @return the number of mountain cells in the board
	 */
	
	public int getNbCellMountain() {
		return nbCellMountain;
	}

	/** to set the number of mountain cells in the board
	 * @param nbCellMountain the number of mountain cells you want to set in the board
	 */
	
	public void setNbCellMountain(int nbCellMountain) {
		this.nbCellMountain = nbCellMountain;
	}

	/**
	 * to get the number of forest cells in the board
	 * @return the number of forest cells in the board
	 */
	
	public int getNbCellForest() {
		return nbCellForest;
	}
	
	/**
	 * to set the number of forest cells in the board
	 * @param nbCellForest number of forest cells you want to set in the board
	 */
	
	public void setNbCellForest(int nbCellForest) {
		this.nbCellForest = nbCellForest;
	}

	/**
	 * to get the number of plain cells in the board
	 * @return the number of plain cells in the board
	 */
	
	public int getNbCellPlain() {
		return nbCellPlain;
	}

	/**
	 * to set the number of plain cells in the board
	 * @param nbCellPlain number of plain cells you want to set in the board
	 */
	
	public void setNbCellPlain(int nbCellPlain) {
		this.nbCellPlain = nbCellPlain;
	}

	
	
	public ArrayList<Cell> getFreeTuile(){
		return freeTuiles;
	}
    
	/** 
	 * to remove a free cell
	 * @param c the current cell you want to remove
	 */
	
	public void removeCellFree(Cell c) {
		// TODO Auto-generated method stub
		freeTuiles.remove(c);
		
	}
	
	/** 
	 * to add a cell to the free cell list
	 * @param c the current cell
	 */
	public void getBackFree(Cell c) {
		// TODO Auto-generated method stub
		freeTuiles.add(c);
		
	}
	


}

