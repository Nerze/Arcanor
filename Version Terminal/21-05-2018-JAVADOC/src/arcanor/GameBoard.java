package arcanor;
import java.util.ArrayList;
import System.out.*;

/**
 * This class represent a game board
 */
public class GameBoard{

   /**
    * The current turn
    */
   private int turn;

   /**
    * This table contains main game settings
    */
   private ParamMenu gameParams;

   /**
    * Players list in the game
    */
   private ArrayList<Player> playerList;

   /**
    * The board that contain pieces
    */
   private Piece[][] board;

   /**
    * The constructor
    * @param params settings table
    * @param list players list
    */
   public GameBoard(ParamMenu params, ArrayList<Player> list){}

   /**
    * Method to save the game in an external binary file
    */
   public void save(){}

   /**
    * Getter of turn
    * @return the current turn
    */
   public int getTurn(){}

   /**
    * Setter of turn
    * @param turn the new turn
    */
   public void setTurn(int turn){}

   /**
    * Method that represent a game turn (each player play 1 time)
    */
   public void play(){}

   /**
    * Printing method
    */
   public void display(){}

}
