package Main;

import exceptions.AutoProcessingException;
import exceptions.BigProblemException;
import game.Game;

/** 
 * the mainwar's class
 */
public class MainWar {
	
	public static void main(String [] args) throws AutoProcessingException {

		Game game = new Game(10,10,2,"war");
		try {
			game.playWarAuto();
			game.decompteWar();
		} catch (BigProblemException e) {
			e.printStackTrace();
			return ;
		}
	}

}
