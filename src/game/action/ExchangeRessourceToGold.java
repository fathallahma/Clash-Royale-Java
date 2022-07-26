package game.action;
import game.*;
import game.board.cell.*;

//import game.personnage.Personnage;


/**
 * class to exchange resources for gold
 */
public class ExchangeRessourceToGold implements Action{
    public  Player player;
   

    /**
     * class constructor
     * @param player the player
     */
    public ExchangeRessourceToGold(Player player){
        this.player = player;
        
    }

    /**
     * method to execute the action
     */
    @Override
    public void execute(){
    	 int piece = 0;
    	for(Cell c : player.getPlayerCell()) {
    		if (c instanceof DesertCell) piece += 5;
    		if(c instanceof ForestCell || c instanceof PlainCell) piece += 2;
    		if(c instanceof MountainCell) piece += 8;
    	}
    	System.out.println("vous gagnez "+piece+" piece d'or");
        player.winGold(piece);


    }

    
}
