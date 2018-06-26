package arcanor;
import java.io.Serializable;
import javax.swing.*;
/**
 * This class represent a Player
 */
public abstract class Player implements Serializable{

	/**
	 * Player's name
	 */
	protected String name;

	/**
	 * Player's color
	 */
	protected boolean color;
	
	/**
	 * The game's board
	 */
	protected Board board;
		
	/**
	 * The constructor
	 * @param board The Game's board
	 * @param name The player's name
	 * @param color The player's color
	 */
	 
	public Player(String name, boolean color, Board board){
		if(name==null){
			name="";
			System.out.println("Player() ERROR : name is null");
		}
		if(board==null){
			board=new Board(-1,-1,-1);
			System.out.println("Player() ERROR : board is null");
		}
		this.name=name;
		this.color=color;
		this.board=board;
	}
	
	/**
	 * This return the color of the player
	 * @return the color
	 */
	public boolean getColor(){return this.color;}

	/**
	 * Method that ask input to the Player, Human or not
	 */
	public abstract boolean playTurn();
	
	/**
	 * This return the name of the player
	 * @return the name
	 */
	public String getName(){return  this.name;}

}
