import game.personnage.Armee;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import game.personnage.*;
import junit.framework.JUnit4TestAdapter;
import game.board.*;
import static org.junit.Assert.*;

import javax.naming.SizeLimitExceededException;

import org.junit.Test;
import game.*;


public class ArmeeTest{
    
    public int size;
    
    /**
     * to test the creation of an army
     */
    @Test
    public void testArmeeCreation(){
	    Armee a;
		try {
			Board q = new Board(4,5);
			Player three = new Player("Joffrey", "WarGame", q);
			a = new Armee(0,5, three);
			assertEquals(0,a.getQuantiteDor());
	        assertEquals(5,a.getSize());
	    } catch (exceptions.SizeLimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
 
    
    @Test
    
    /** 
     * to test the size of the army
     */
    public void testGetSize(){
        Armee a;
		try {
			Board s = new Board(4,3);
            Player eight = new Player("Jason", "OuvrierGame",s);
            a = new Armee(0,4, eight);
			//a = new Armee(0,4);
			assertEquals(4,a.getSize());
		} catch (exceptions.SizeLimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @Test
    
    /** 
     * to test the amount of gold of the army
     */
    public void testGetQuantiteDor(){
        Armee a;
		try {
			Board o =  new Board(4,3);
			Player five = new Player("Cameron", "OuvrierGame", o);
			a = new Armee(14,5, five);
			assertEquals(14,a.getQuantiteDor());
		} catch (exceptions.SizeLimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    /**
     * to test the method when someone win gold
     */
    @Test
    public void testWinGold(){
        Armee a;
		try {
			Board s = new Board(4,3);
			Player four = new Player("Jimmy", "WarGame", s);
			a = new Armee(5,2, four);
			assertEquals(5,a.getQuantiteDor());
	        a.winGold(10);
	        assertEquals(15,a.getQuantiteDor());
		} catch (exceptions.SizeLimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }  
    
    /** 
     * to test the method who someone change the size of an army
     */
    @Test
    public void testSize(){
    	try {
    		Board j = new Board(5,4);
    		Player six = new Player("Kamel", "WarGame", j);
    		Armee r = new Armee(4,4, six);
    		assertEquals(4, r.getSize());
    		r.changeSizeToHalf();
    		assertEquals(2, r.getSize());
    		r.changeSizeAddedUnity();
    		assertEquals(3, r.getSize());
    	} catch (exceptions.SizeLimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
          }
    }

    /**
     * to test if two people are equals or not
     */
    @Test
    public void testEquals(){
		try {
			Board v = new Board(5, 6);
			Board p = new Board(7,3);
			Player one = new Player("Joe", "MainOuvrier", v);
			Player two = new Player("Tyler","MainOuvrier", p);
			Armee v1 = new Armee(5,3, one);
			Armee v2 = new Armee(5,3, one);
	        Armee v3 = new Armee(6,3, two);
	        Armee v4 = new Armee(5,4, two);
	        Armee v5 = new Armee(32,14, two);
			assertTrue(v1.equals(v2));
	        assertFalse(v1.equals(v3));
	        assertFalse(v1.equals(v4));
	        assertFalse(v1.equals(v5));
		} catch (exceptions.SizeLimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }

    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(ArmeeTest.class);
    }
    
    }
