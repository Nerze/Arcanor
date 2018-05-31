package arcanor;
import System.out;

/**
 * This class represent a piece of the game
 */
public class Piece{

	/**
	 * Piece's color
	 */
	private boolean color;

	/**
	 * Piece's value
	 */
	private int value;

	/**
	 * Piece's content
	 */
	private Piece contain;

	/**
	 * The constructor
	 * @param color Piece's color
	 * @param value Piece's value
	 * @param contain Piece's content
	 */
	public Piece(boolean color, int value, Piece contain){
	   
	   this.color = color;
	   this.value = value;
	   this.contain = contain;
	   
	}

	/**
	 * Getter of color
	 * @return Piece's color
	 */
	public boolean getColor(){return this.color;}

	/**
	 * Setter of color
	 * @param color the new color
	 */
	public void setColor(boolean color){
	
		this.color = color;
	
	}

	/**
	 * Getter of value
	 * @return Piece's value
	 */
	public int getValue(){return this.value;}

	/**
	 * Setter of value
	 * @param value the new value
	 */
	public void setValue(int value){
		
		if(value<=4 && value>=1){
			this.value = value;
		}
		else{
			println("Piece.setValue() : ERROR value invalid");
		}
		
	}

	/**
	 * Getter of contain
	 * @return Piece's content
	 */
	public Piece getContain(){return this.contain;}

	/**
	 * Setter of contain
	 * @param contain the new content
	 */
	public void setContain(Piece contain){
		
		this.contain = contain;
		
	}
	  
}
