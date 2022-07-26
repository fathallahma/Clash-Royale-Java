package game.board.resources;

/** 
 * wood's class
 */
public class bois extends resource{
	
	/** 
	 * class constructor
	 * @param r the number of wood
	 */

    public bois(int r){
        super(r);
    }
    
    /** method toString
     * @return the number of wood
     */
    
    public String toString(){
        return "there is " + super.resource +  "resources of 'bois' " ;
    }
    
    
}
