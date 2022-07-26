package game.action;
import game.Player;
import game.board.cell.Cell;
import game.board.cell.DesertCell;
import game.board.cell.ForestCell;
import game.board.cell.PlainCell;

/**
 * donothing action class
 */
public class Donothing implements Action{

    public Player player;
    //public int gold;
    
   

    /**
     * class constructor
     * @param player the player
     */
    public Donothing(Player player){
    	this.player = player;
    }
    
    /**
     * method of execution
     */
    @Override
    public void execute(){
        System.out.println(this.player + " a passé son tour !" );
        for (Cell c: player.getPlayerCell()) {
        	if(c instanceof DesertCell)	player.winGold(2);
        	if(c instanceof PlainCell || c instanceof ForestCell) player.winGold(1);
        }
        	
        
        //this.player.winGold(getNbForestCell() + getNbPlainCell() + (getNbDesertCell()*2));
        //il faut qu'on donne un porte monnai au joueur dans la classe player.java afin de lui faire gagner de l'argent et faire une methode wingold dedans
    }

	
	
}
