package game.board.resources;
/** 
 * rock's class
 */
public class roche extends resource{
	
	/**
	 * class constructor
	 * @param r the number of rock
	 */

    public roche(int r){
        super(r);
    }
    
    /** method toString
     * @return the number of rock
     */
    public String toString(){
        return "there is " + super.resource +  "resources of 'roche' " ;
    }
    
}
