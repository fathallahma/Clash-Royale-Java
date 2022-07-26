package game.action;
import game.*;
//import game.personnage.Personnage;


/**
 * class to exchange resources for gold
 */
public class ExchangeResourcesToGoldO implements Action{
    private  Player player;
   

	/**
	 * class constructor
	 * @param player the player in the constructor
	 */
    public ExchangeResourcesToGoldO(Player player){
        this.player = player;
        
    }

	/**
	 * method of execution
	 */
    @Override
    public void execute(){
    	System.out.println("Echange de vos ressources pour de l'or");
    	 int piece = 0;
    	 piece += player.getBle() * 2;
    	 piece += player.getRoche() * 8;
    	 piece += player.getBois() * 2;
    	 piece += player.getSable() * 5;
    	 player.setBle(0);
    	 player.setBois(0);
    	 player.setRoche(0);
    	 player.setSable(0);
    	
    	System.out.println("vous gagnez "+piece+" piece d'or");
        player.winGold(piece);


    }

    
}
