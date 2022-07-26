package Main;
import exceptions.AutoProcessingException;
import exceptions.BigProblemException;
import exceptions.SizeLimitExceededException;
import game.Game;

public class Main {

public static void main(String[] args) throws AutoProcessingException {
/*
  Game game = new Game(4,5,2,"war");
  try {
    game.playWar();
    game.decompteWar();
  } catch (BigProblemException e) {
    e.printStackTrace();
    return ;
  }
*/

  Game games = new Game(4,5,2,"Ouvrier");
  games.playOuvrier();


 }
}