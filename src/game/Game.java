package game;
import java.util.*;

import exceptions.AutoProcessingException;
import exceptions.BigProblemException;
import exceptions.SizeLimitExceededException;
import game.action.Deploy;
import game.action.Donothing;
import game.action.ExchangeResourcesToGoldO;
import game.action.FeedCharacters;
import game.action.RemunarateWorker;
import game.board.*;
import game.board.cell.Cell;
import game.board.cell.DesertCell;
import game.board.cell.ForestCell;
import game.board.cell.MountainCell;
import game.board.cell.PlainCell;
import game.personnage.Ouvrier;

public class Game {

	protected List<Player> thePlayers;
	protected Board board;

	/**
	* Creates a new game
	* @param board le plateau du jeu
	* @param players liste des joueur
	*/
	public Game(Board board, List<Player> players){
		this.board=board;
		this.thePlayers = players;
		
		
	}
	
	public Game(int lon, int la,int nbPlayer, String game){
		this.board = new Board(lon,la);
		System.out.println(board.getFreeTuile().size());
		ArrayList <Player>players = new ArrayList<Player>();
		for(int i = 0; i < nbPlayer; i++) {
			players.add(new Player(i+"", game, this.board));
		}
		this.thePlayers = players;	
	}
	
	/** 
	 * to play the war's game
	 * @throws BigProblemException BigProblemException
	 * @throws AutoProcessingException AutoProcessingException
	 */
	public void playWar() throws BigProblemException, AutoProcessingException {
		int nbTerritory = board.getFreeTuile().size();
		System.out.println("Demarrage du jeu");
		int cpt = 0;
		Deploy deploy = new Deploy(0, null,null);
		FeedCharacters feeder = new FeedCharacters(null);
		while(cpt < 10 ) {
			System.out.println("Tour numero "+cpt);
			for(Player player: thePlayers) {
				if(player.getPlayerCell().size() == nbTerritory) {
					System.out.println(player.getName()+" Vous avez conquis tous les territoires");
					return;
					
				}
				System.out.println(player.getName()+" Veuilez mener une action");
				System.out.println("(Deployer une armee(1) - Ne rien faire(2 ou autre)");
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);//object for scanner
				int no = sc.nextInt();
				
				if(no == 1 ) {
					System.out.println("choisissez le nombre de gerrier a deployer:(Max 5)");
					sc = new Scanner(System.in);
					no = sc.nextInt();
					Cell c = board.getFreeTuile().get(0);//reflechir a amliore le choix de la cellule a deployer
					deploy.setAttributes(no,player, c);
					//board.getFreeTuile().remove(0);
					try {
						deploy.executeWar();
					}catch (SizeLimitExceededException e) {
						System.out.println("vous avez essayer de deployer " +no +" guerrier " +e.getMessage());
						sc = new Scanner(System.in);//object for scanner
						no = sc.nextInt();
						deploy.setAttributes(no,player, c);
						player.getPlayerCell().add(c);
						try {
							deploy.executeWar();
						} catch (SizeLimitExceededException | AutoProcessingException e1) {
							System.out.println("Deuxieme mauvaise action: (choix par defaut-> ne rien faire)");
						}
						
					}
					//nourrir ses guerriers
					feeder.setPlayer(player);
					feeder.execute();
				}else {
					System.out.println("Action ne rien faire");
					deploy.recolte();}
				
			}
			
			cpt++;
		}
		System.out.println("Fin de la partie");
		
	}
	
	
	public void playWarAuto() throws BigProblemException, AutoProcessingException {
		int nbTerritory = board.getFreeTuile().size();
		System.out.println("Demarrage du jeu");
		int cpt = 0;
		Deploy deploy = new Deploy(0, null,null);
		FeedCharacters feeder = new FeedCharacters(null);
		while(cpt < 10 ) {
			System.out.println("Tour numero "+cpt);
			for(Player player: thePlayers) {
				if(player.getPlayerCell().size() == nbTerritory) {
					System.out.println(player.getName()+" Vous avez conquis tous les territoires");
					return;
					
				}
				System.out.println(player.getName()+" Veuilez mener une action");
				System.out.println("(Deployer une armee(1) - Ne rien faire(2 ou autre)");
				
				int no = (int)(Math.random() * 2) + 1;
				
				if(no == 1 ) {
					System.out.println("choisissez le nombre de gerrier a deployer:(Max 5)");
					no = (int)(Math.random() * 5) + 1;
					int range = board.getFreeTuile().size();
					int indice = (int)(Math.random() * range);
					Cell c = board.getFreeTuile().get(indice);//reflechir a amliore le choix de la cellule a deployer
					deploy.setAttributes(no,player, c);
					//board.getFreeTuile().remove(0);
					try {
						deploy.executeWar();
					}catch (SizeLimitExceededException e) {
						System.out.println("vous avez essayer de deployer " +no +" guerrier " +e.getMessage());
						no = (int)(Math.random() * 3) + 1;
						deploy.setAttributes(no,player, c);
						player.getPlayerCell().add(c);
						try {
							deploy.executeWar();
						} catch (SizeLimitExceededException | AutoProcessingException e1) {
							System.out.println("Deuxieme mauvaise action: (choix par defaut-> ne rien faire)");
						}
						
					}
					//nourrir ses guerriers
					feeder.setPlayer(player);
					feeder.execute();
				}else {
					System.out.println("Action ne rien faire");
					deploy.recolte();}
				
			}
			
			cpt++;
		}
		System.out.println("Fin de la partie");
		
	}
	
	
	public void playOuvrier(){
		System.out.println("Demarrage du jeu");
		int cpt = 0;
		Deploy deploy = new Deploy(null);
		while(cpt < 6 ) {
			System.out.println("Tour numero "+cpt);
			if(board.getFreeTuile().size() == 0) {
				System.out.println("Plus de territoire disponbile");
				return;
				
			}
			for(Player player: thePlayers) {
				System.out.println(player.getName()+" Veuilez mener une action");
				System.out.println("(Deployer une armee(1) - echanger vous ressources(2)- Ne rien faire(3  ou autre)");
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);//object for scanner
				int no = sc.nextInt();
				deploy.setPlayer(player);
				if(no == 1 ) {
					Cell c = board.getFreeTuile().get(0);
					deploy.executeOuvrier(c);
					//board.getFreeTuile().remove(0);
				}
				if(no == 2 ) {
					new ExchangeResourcesToGoldO(player).execute();
				}
				if(no != 1 && no !=2) {
					new Donothing(player).execute();
				}
				System.out.println(player.getName()+ " Recolte des ressources");
				deploy.recolte();
				new RemunarateWorker(player).execute();	
			}
			cpt++;
		}
		
		
	}
	
	public void playOuvrierAuto(){
		System.out.println("Demarrage du jeu");
		int cpt = 0;
		Deploy deploy = new Deploy(null);
		while(cpt < 6 ) {
			System.out.println("Tour numero "+cpt);
			if(board.getFreeTuile().size() == 0) {
				System.out.println("Plus de territoire disponbile");
				return;
				
			}
			for(Player player: thePlayers) {
				System.out.println(player.getName()+" Veuilez mener une action");
				System.out.println("(Deployer une armee(1) - echanger vous ressources(2)- Ne rien faire(3  ou autre)");
				
				int no = (int)(Math.random() * 3) + 1;
				deploy.setPlayer(player);
				if(no == 1 ) {
					int range = board.getFreeTuile().size();
					int indice = (int)(Math.random() * range);
					Cell c = board.getFreeTuile().get(indice);
					deploy.executeOuvrier(c);
					//board.getFreeTuile().remove(0);
				}
				if(no == 2 ) {
					new ExchangeResourcesToGoldO(player).execute();
				}
				if(no != 1 && no !=2) {
					new Donothing(player).execute();
				}
				System.out.println(player.getName()+ " Recolte des ressources");
				deploy.recolte();
				new RemunarateWorker(player).execute();	
			}
			cpt++;
		}
		
		
	}
	
	public Player decompteOuvrier() {
		int nbPoint =0;
		Player winner =null;
		for(Player p: thePlayers) {
			int tmp = 0;
			for(Ouvrier ouvrier: p.ouvriers) {
				tmp+= ouvrier.gold;
			}
			if (tmp > nbPoint) {
				nbPoint = tmp;
				winner = p;
			}
		}
		System.out.println("le gagnant est: " +winner.getName() + " Score: "+nbPoint);
		return winner;
	}
	
	
	
	public Player decompteWar(){
		int nbPoint = 0;
		Player winner =null;
		for(Player p: thePlayers) {
			int tmp = p.getGold();
			for(Cell c: p.getPlayerCell()) {
				if(c instanceof MountainCell || c instanceof DesertCell) tmp+=4;
				if(c instanceof PlainCell) tmp+=1;
				if(c instanceof ForestCell) tmp+=2;
			}
			if (tmp > nbPoint) {
				nbPoint = tmp;
				winner = p;
			}
		}
		System.out.println("le gagnant est: " +winner.getName() + " Score: "+nbPoint);
		return winner;
		
	}
	
      
}

