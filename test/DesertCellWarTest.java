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
 * the desertcellwartest's class
 */
public class DesertCellWarTest{
	
	/**
	 * to test if we can put characters on a cell and get the number of characters in the cell
	 */
	@Test
	public void setPersonnageTest() {
		try{
			Board m = new Board(5,5);
		    DesertCellWar a = new DesertCellWar(1,2, m);
		    a.setPersonnage(2);
		    assertEquals(2, a.getnbPersonnage());
		} catch (exceptions.AutoProcessingException e) {
			e.printStackTrace();
		}
	}
	
		
	    
	
	public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(DesertCellWarTest.class);
    }
}