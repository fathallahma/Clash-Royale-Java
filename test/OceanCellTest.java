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
 * the oceancelltest's class
 */
public class OceanCellTest{

	
	/**
	 * to test if we can get the type of the cell
	 */
	@Test
	public void getTypeTest() {
		Board m = new Board(5,5);
	    OceanCell a = new OceanCell(1,2, m);
	    assertEquals("Ocean", a.getType());
		
	    
	}
	
	public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(DesertCellTest.class);
    }
}