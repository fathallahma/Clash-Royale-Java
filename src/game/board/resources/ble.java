package game.board.resources;
/**
 * corn's class
 */
public class ble extends resource{
    
	/** class constructor
	 * @param r the number of corn
	 */
    public ble(int r){
        super(r);
    }
    
    /** method toString
     * @return the number of corn 
     */
    
    public String toString(){
        return "there is " + super.resource +  "resources of 'ble' " ;
    }

    
}
