package arcanor;
import java.util.Scanner;

/**
 * Create a human player
 */
public class HumanPlayer extends Player{
	
	/**
	 * Constructor of HumanPlayer
	 * @param name the name of the player
	 * @param color the side of the player
	 * @param board the board where the game is played
	 */
	public HumanPlayer(String name, boolean color, Board board){
		super(name, color, board);
	}
	
	/**
	 * return false because he is a human
	 */
	public boolean playTurn(){
		return false;
	}
}
