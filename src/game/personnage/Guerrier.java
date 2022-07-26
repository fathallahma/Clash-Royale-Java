package game.personnage;
/** 
 * the warrior's class
 */
public class Guerrier extends Personnage{
	
	/** 
	 * the attributes of the class
	 */
	public static int i = 1;
	public final int id;
	
	/** 
	 * class constructor
	 */
	public Guerrier() {
		super(0,0);
		id = i++;
	}

	@Override
	/** 
	 * method toString
	 * @return warrior and the id
	 */
	public String toString() {
		
		return "Guerrier" + id;
	}

}
