package game.action;
//import game.personnage.Personnage;
import java.util.ArrayList;
import game.Player;
import game.board.cell.Cell;
import game.board.cell.DesertCell;


/**
 *  class to feed the characters
 */
public class FeedCharacters implements Action{

	private Player player;



	/**
	 * class constructor
	 * @param player the player
	 */
	public FeedCharacters(Player player){
		this.player = player;
	}

	/**
	 * method to execute the action
	 */
	public void execute() {
		ArrayList<Cell> tmp = new ArrayList<>();
		for(Cell cell : player.getPlayerCell()) {
			System.out.println("Feed Army "+cell.getType());
			int ressourcesNeeded= cell.getnbPersonnage();//taille de l'armee sur la cellule
			if(cell instanceof DesertCell){
				System.out.println("Armee deployee sur un teuile Desert necessite 2 fois plus de resources");
				ressourcesNeeded=2*ressourcesNeeded;
			}
			ExchangeRessourcesToFood exFood = new ExchangeRessourcesToFood(cell,player);
			exFood.execute();
			int nbfood=exFood.getFood();
			player.recolteFood(nbfood);
			//pas assez de nourriture pour l'armee
			if(player.takeFood(ressourcesNeeded) == false){
				System.out.println("Pas assez de nourriture pour cette armee");
				System.out.println("Territoire perdu, vous gagner 1 piece d'or");
				player.winGold(1);
				tmp.add(cell);
			}
		}
		for(Cell c: tmp) {
			player.removeTerritory(c);

		}
	}
	
	/**
	 * add player 
	 * @param p the added player
	 */
	public void setPlayer(Player p) {
		player = p;
	}
	


}
