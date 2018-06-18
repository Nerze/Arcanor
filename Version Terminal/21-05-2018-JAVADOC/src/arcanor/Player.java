package arcanor;

/**
 * This class represent a Player
 */
public abstract class Player{

	/**
	 * Player's name
	 */
	private String name;

	/**
	 * Player's color
	 */
	private boolean color;
		
	/**
	 * The constructor
	 * @param type Human or not
	 * @param name Player's name
	 * @param color the player's color
	 */
	 
	public Player(String name, boolean color){
		if(name==null){
			name="";
			System.out.println("Player() ERROR : name is null");
		}
		this.name=name;
		this.color=color;
	}
	
	public boolean getColor(){return this.color;}

	/**
	 * Method that ask input to the Player, Human or not
	 */
	public abstract void playTurn();
	
	
	public String getName(){return  this.name;}

}
