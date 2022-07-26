package game.board.resources;
/** 
 * the resource's class
 */
public abstract class resource {
    
	/** 
	 * the attribute of the class
	 */
    protected int resource ;
    
    /**
     * class constructor
     * @param r the number of resources
     */
    public resource(int r){
        this.resource = r ;
    }


   
    /**
     * method to get the number of resources
     * @return the number of resources
     */
    public int getResources(){
       return this.resource;
    }

}