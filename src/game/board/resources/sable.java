package game.board.resources;
/** 
 * the sand's class
 */
public class sable extends resource{
    
	/**
	 * class constructor
	 * @param r the number of sand
	 */
	
    public sable(int r){
        super(r);
    }
    
    /** method toString
     * @return the number of sand 
     */
    public String toString(){
        return "there is " + super.resource +  "resources of 'sables' " ;
    }
}
