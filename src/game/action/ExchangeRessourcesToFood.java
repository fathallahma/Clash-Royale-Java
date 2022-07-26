package game.action;
import game.Player;
import game.board.cell.*;


/**
 * class to exchange resources to food
 */
public  class ExchangeRessourcesToFood implements Action{
	private int food;
	private Player player;

	/**
	 * class constructor
	 * @param cell the cell
	 * @param player the player
	 */
	public ExchangeRessourcesToFood(Cell cell,Player player){
		this.player = player;
		food=0;
	}

	/**
	 * method to execute the action
	 */
	public void execute(){
		food = player.getBle() * 5;
		food += player.getBois();
		player.setBle(0);
		player.setBois(0);
	}

	/**
	 * returning food
	 * @return amount of food
	 */
	public int getFood(){
		int tmp = food;
		food = 0;
		return tmp;
	}

}
