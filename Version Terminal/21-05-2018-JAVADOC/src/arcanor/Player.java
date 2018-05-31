package arcanor;
import java.out.*;

/**
 * This class represent a Player
 */
public abstract class Player{
	
	/**
	 * Turing's test,
	 * True if Human
	 * False if IA
	 */
	private boolean human;

	/**
	 * Player's name
	 */
	private String name;

	/**
	 * The constructor
	 * @param type Human or not
	 * @param name Player's name
	 */
	public Player(boolean type, String name){
		this.human=type;
		if(name==null){
			name="";
			Sytem.out.println("Player() ERROR : name is null");
		}
		this.name=name;
	}

	/**
	 * Method that ask input to the Player, Human or not
	 * @return a table that represent the action to perform
	 */
	public abstract int[][] playTurn();

}
