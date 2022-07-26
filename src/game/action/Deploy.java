package game.action;
import java.util.ArrayList;
import exceptions.AutoProcessingException;
import exceptions.BigProblemException;
import exceptions.SizeLimitExceededException;
import game.Player;
import game.board.cell.Cell;
import game.board.cell.MountainCell;
import game.personnage.Ouvrier;

/**
 * class to deploy characters
 */
public class Deploy{
	private Cell c;
	private int nbPersonnage;
	private Player player;
	private Ouvrier ouvrier;

	/**
	 * class constructor
	 * @param nbPersonnage number of characters to deploy
	 * @param c the action's cell
	 * @param player the player who will do the action
	 */
	public Deploy(int nbPersonnage, Cell c, Player player) {
		this.c = c;
		this.nbPersonnage = nbPersonnage;
		this.player = player;

	}
	/**
	 * second constructor
	 * @param player the player who will do the action
	 */
	public Deploy(Player player) {
		this.player = player;
	}


	/**
	 * method of execution
	 * @throws BigProblemException BigProblemException
	 * @throws SizeLimitExceededException SizeLimitExceededException
	 * @throws AutoProcessingException AutoProcessingException
	 */
	public void executeWar() throws BigProblemException, SizeLimitExceededException,AutoProcessingException   {
		System.out.println();
		if (c.isOccupied()) {
			System.out.println("Case deja occupee");
			System.out.println("Error: please contact ");
			throw new BigProblemException("end game");
		}
		c.setOccupied(true);
		if (player.getNbCharacter() < nbPersonnage) {
			System.out.println("vous n'avez pas assez de joeur deployable: " +player.getNbCharacter());
			throw new SizeLimitExceededException(" veuillez choisir un nombre inferieur a 6");
		}

		try {
			c.setFirsPlayer(player);
			c.setPersonnage(nbPersonnage);
			player.removeCharacter(nbPersonnage);
		} catch (AutoProcessingException e) {
			System.out.println(e.getMessage()+ " Deployement par defaut du max autorise sur cette tuile " + c.MAX);
			c.setPersonnage(c.MAX);
			player.removeCharacter(c.MAX);

		}
		finally{
			player.setACellToThePlayer(c);
			player.removeFreeFromBoard(c);
			ArrayList<Cell> liste = c.getBoard().getAllBoardAdjacent(c);
			for(Cell adjacent : liste) {
				if(adjacent.isOccupied()) {
					Player otherPlayer = adjacent.getPlayer();
					//affecter l'ennemie
					if(!otherPlayer.equals(player)) {
						int enemySize = adjacent.getnbPersonnage();
						if(adjacent instanceof MountainCell) enemySize+=2;{}
						if(enemySize < c.getnbPersonnage()) {
							System.out.println("Taille de l'armee ennemie reduite de moitie");
							adjacent.changeSizeToHalf();
							if(adjacent.getnbPersonnage() < 1) {
								//Territoire conquis
								System.out.println("Nouveau Terrtoire conquis");
								player.setACellToThePlayer(adjacent);
								adjacent.setPlayer(player);
								c.addGold(2);
							}
						}

					}else {//armee allie
						if(adjacent.getnbPersonnage() < c.getnbPersonnage()) {
							c.addGold(1);
							adjacent.addPersonnage(1);	
						}
					}
				
				}//fin cell ocuppied
				System.out.println("Debut de la recolte des ressources pour joeur "+player.getName());
				recolte();
				


			}
		}

	}


	/**
	 * collect the resources
	 */
	public void recolte() {
		if(player == null) {
			return;
		}
		ArrayList<Cell> listCell = player.getPlayerCell();
		for(Cell cell:listCell) {
			player.recolteBois(cell.recolteBois());
			player.recolteBle(cell.recolteBle());
			player.recolteRoche(cell.recolteRoche());
			player.recolteSable(cell.recolteSable());
			player.recolteGold(cell.recolteGold());
		}
	}


	/**
	 * execution for the worker game
	 * @param c the action's cell
	 */
	public void executeOuvrier(Cell c) {
		System.out.println("Deploiement de l'ouvrier sur tuile " + c.getType());
		this.c = c;
		player.getPlayerCell().add(c);
		ouvrier = new Ouvrier(10,10,c);
		player.ouvriers.add(ouvrier);
		player.removeFreeFromBoard(c);
	}

	/**
	 * adding attributes
	 * @param nb of characters to add
	 * @param p player � ajouter 
	 * @param c updated cell
	 */
	public void setAttributes(int nb, Player p, Cell c) {
		this.nbPersonnage = nb;
		this.c =c;
		player = p;
	}

	/**
	 * adding player
	 * @param player the player to add
	 */
	public void setPlayer(Player player) {
		// TODO Auto-generated method stub
		this.player = player;

	}





}
