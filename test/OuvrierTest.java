//package game.personnage;
import game.board.cell.OceanCell;
import game.board.cell.DesertCell;
import game.board.cell.MountainCell;
import game.personnage.Ouvrier;
import static org.junit.Assert.*;


import org.junit.Test;
import game.board.cell.Cell;
import game.board.*;

/**
 * the ouvriertest's class
 */
public class OuvrierTest{
    
	/** 
	 * attributes of the class
	 */
    public int gold;
    
    

    /**
     * to test if we can create a worker
     */
    @Test
    public void testOuvrierCreation(){
        Board p = new Board(4,3);
        MountainCell c = new MountainCell(2,2, p);
    	Ouvrier Mohamed = new Ouvrier(15,4, c);
        assertNotNull(Mohamed);
        assertEquals(15,Mohamed.getQuantiteDor());
    }
    
    /** 
     * to test if we can get the amount of gold of a worker
     */
    @Test 
    public void testGetQuantiteDor(){
    	Board p = new Board(4,3);
        OceanCell c = new OceanCell(2,2, p);
        Ouvrier Julien = new Ouvrier(10,4, c);
        assertEquals(10,Julien.getQuantiteDor());
        Ouvrier Tony = new Ouvrier(20,5,c);
        assertEquals(20,Tony.getQuantiteDor());
    }
    
    /**
     * to test if we can get the size of a worker and change his size too
     */
    @Test
    public void testSizeOuvrier(){
    	Board p = new Board(4,3);
    	OceanCell c = new OceanCell(2,2,p);
    	Ouvrier Jules = new Ouvrier(10, 4, c);
    	assertEquals(4, Jules.getSize());
    	Jules.changeSizeToHalf();
    	assertEquals(2, Jules.getSize());
    	Jules.changeSizeAddedUnity();
    	assertEquals(3, Jules.getSize());
    }
    

    /**
     * to test if we can make win gold to a worker
     */
    @Test 
    public void testWinGold(){
    	Board p = new Board(4,3);
        DesertCell c = new DesertCell(2,2, p);
        Ouvrier a = new Ouvrier(10,3, c);
        assertEquals(10,a.getQuantiteDor());
        a.winGold(5);
        assertEquals(15,a.getQuantiteDor());

    }

    
    /**
     * to test if two workers are equals
     */
    @Test
    public void testEquals(){
    	Board p = new Board(4,3);
        OceanCell c = new OceanCell(2,2, p);
        Board q = new Board(5,5);
        DesertCell o = new DesertCell(1, 2, q);
        Ouvrier v1 = new Ouvrier(5,3,c);
		Ouvrier v2 = new Ouvrier(5,3,c);
        Ouvrier v3 = new Ouvrier(8,3,o);
        Ouvrier v4 = new Ouvrier(0,3,o);
		assertTrue(v1.equals(v2));
        assertFalse(v1.equals(v3));
        assertFalse(v1.equals(v4));
    }


    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(OuvrierTest.class);
    }



 
    }
