package game.action;
import game.Player;
import game.board.cell.DesertCell;
import game.board.cell.ForestCell;
import game.board.cell.MountainCell;
import game.board.cell.PlainCell;
import game.personnage.Ouvrier;

/**
 * class for workers compensation
 */
public class RemunarateWorker implements Action{
	private Player player;

	/**
	 * class constructor
	 * @param p the player
	 */
	public RemunarateWorker(Player p) {
		this.player = p;
	}
	
	/**
	 * method to execute the action
	 */
	@Override
	public void execute() {
		System.out.println("Remuneration de vous ouvriers");
		for(Ouvrier ouvrier: player.ouvriers) {
			int salaire = 0;
			if(ouvrier.getCell() instanceof DesertCell)salaire = 3;
			if(ouvrier.getCell() instanceof MountainCell)salaire = 5;
			if(ouvrier.getCell() instanceof ForestCell || ouvrier.getCell() instanceof PlainCell)salaire = 1;
			System.out.println("Solde "+player.getGold());
			if(player.getGold() < salaire) {
				System.out.println("vous n'avez pas assez d'or: vous perdez un terroire");
				player.ouvriers.remove(ouvrier);
				player.getPlayerCell().remove(ouvrier.getCell());
				player.getFreeTuiles().add(ouvrier.getCell());
				return;
			}
			System.out.println("Vous avez payer "+salaire+" piece d'or");
			ouvrier.winGold(salaire);
			player.looseGold(salaire);
			System.out.println("Votre solde "+ player.getGold() + " piece d'or");
			
		}
		
	}

}
