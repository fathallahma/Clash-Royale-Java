package Main;

import game.Game;
/**
 * the mainouvrier's class
 */
public class MainOuvrier {
	
	public static void main(String[] args) {
		Game games = new Game(10,10,3,"Ouvrier");
		games.playOuvrierAuto();
		games.decompteOuvrier();
	}

}
