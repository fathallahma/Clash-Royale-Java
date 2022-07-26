import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import game.board.Board ;
import game.board.cell.*;
import java.util.ArrayList;


/**
 * the boardtest's class
 */
public class BoardTest {

    
	/** 
	 * to test if we get the adjacents cell
	 */
    @Test
    public void getAllBoardAdjacentTest() {
        Board board = new Board(20,20);
        Cell cell = board.getCell(15, 15);
        ArrayList<Cell> l = board.getAllBoardAdjacent(cell);
        if(l.size()== 4){
            assertEquals(l.get(0) , board.getLeftOfCell(15,15));
            assertEquals(l.get(1) , board.getTopOfCell(15,15));
            assertEquals(l.get(2) , board.getRightOfCell(15,15));
            assertEquals(l.get(3) , board.getDownOfCell(15,15));
        }
        
    }

    /** 
     * to test if we get the cell at the top of the current cell
     */
    @Test
    public void getTopOfCellTest() {
        Board board = new Board(20,20);
        Cell cell = board.getTopOfCell(15, 15);
        assertEquals(cell, board.getCell(14, 15));

    }

    /** 
     * to test if we get the cell at the bottom of the current cell
     */
    @Test
    public void getDownOfCellTest() {
        Board board = new Board(20,20);
        Cell cell = board.getDownOfCell(15, 15);
        assertEquals(cell, board.getCell(16, 15));

    }

    /** 
     * to test if we get the cell at the left of the current cell
     */
    @Test
    public void getLeftOfCellTest() {
        Board board = new Board(20,20);
        Cell cell = board.getLeftOfCell(15, 15);
        assertEquals(cell, board.getCell(15, 14));

    }

    /** 
     * to test if we get the cell at the right of the current cell
     */
    @Test
    public void getRightOfCellTest() {
        Board board = new Board(20,20);
        Cell cell = board.getRightOfCell(15, 15);
        assertEquals(cell, board.getCell(15, 16));

    }

    /**
     * to test if we get the right numbers of cell
     */
    @Test
    public void getNbOfCellsTest() {
        Board board = new Board(20,20);
        assertEquals(board.getNbOfCells(), 400);
    }

    /** 
     * to test if we get the right number of rows
     */
    @Test
    public void nbOfRowTest() {
        Board board = new Board(20,20);
        assertEquals(board.nbOfRow(), 20);
    }

    /** 
     * to test if we get the right number of column
     */
    @Test
    public void nbOfColumnTest() {
        Board board = new Board(20,20);
        assertEquals(board.nbOfColumn(), 20);
    }

    /** 
     * to test if we can set the right number of desertcell
     */
    @Test
    public void setNbCellDesertTest() {
        Board board = new Board(20,20);
        board.setNbCellDesert(5);
        assertEquals( board.getNbCellDesert(), 5);
    }

    /** 
     * to test if we can set the right number of forestcell
     */
    @Test
    public void setNbCellForestTest() {
        Board board = new Board(20,20);
        board.setNbCellForest(5);
        assertEquals( board.getNbCellForest(), 5);
    }

    /** 
     * to test if we can set the right number of moutaincell
     */
    @Test
    public void setNbCellMountainTest() {
        Board board = new Board(20,20);
        board.setNbCellMountain(5);
        assertEquals( board.getNbCellMountain(), 5);
    }

    /**
     * to test if we can set the right number of plaincell
     */
    @Test
    public void setNbCellPlainTest() {
        Board board = new Board(20,20);
        board.setNbCellPlain(5);
        assertEquals( board.getNbCellPlain(), 5);
    
    }


    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(BoardTest.class);
    }
}
