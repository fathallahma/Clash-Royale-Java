package exceptions;



/**
 * l'exception SizeLimitExceededException
 */
public class SizeLimitExceededException extends Exception{


	private static final long serialVersionUID = 1L;

	/**
	 * constructeur de l'exception 
	 */
	public SizeLimitExceededException(String message){
        super(message) ;
    }


    
}
