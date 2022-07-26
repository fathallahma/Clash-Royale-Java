import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import junit.framework.JUnit4TestAdapter;
import static org.junit.Assert.*;
import javax.naming.SizeLimitExceededException;
import org.junit.Test;
import game.board.cell.*;
import game.board.*;
import exceptions.*;

/**
 * the plaincelltest's class
 */
public class PlainCellTest{
	
	
	/**
	 * to test if we can put characters on a cell and get the number of characters in the cell
	 */
	@Test
	public void setPersonnageTest() {
		try{
			Board m = new Board(5,5);
		    PlainCell a = new PlainCell(1,2, m);
		    a.setPersonnage(3);
		    assertEquals(3, a.getnbPersonnage());
		} catch (exceptions.AutoProcessingException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * to test if we can get the type of the cell
	 */
	@Test
	public void getTypeTest() {
		Board m = new Board(5,5);
	    PlainCell a = new PlainCell(1,2, m);
	    assertEquals("Plain", a.getType());
		
	    
	}
	
	public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(PlainCellTest.class);
    }
}