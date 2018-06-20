package arcanor;
import java.io.Serializable;

/**
 * Cette classe représente une pièce du jeu
 */
public class Piece implements Serializable{

    /**
     * la couleur de la pièce
     */
	private boolean color;

    /**
     * la valeur de la pièce
     */
	private int value;

    /**
     * le contenu de la pièce
     */
	private Piece contain;

    /**
     * le Contructeur
     * @param color la couleur de la pièce
     * @param value la valeur de la pièce
     * @param contain le contenu de la pièce
     */
	public Piece(boolean color, int value, Piece contain){
	   
	   this.color = color;
	   this.value = value;
	   this.contain = contain;
	   
	}

    /**
     * Getter de color
     * @return la couleur de la pièce
     */
	public boolean getColor(){return this.color;}

	/**
	 * Setter de color
     * @param color la couleur a attribuer
     */
	public void setColor(boolean color){
	
		this.color = color;
	
	}

    /**
     * Getter de value
     * @return la valeur de la pièce
     */
	public int getValue(){return this.value;}

    /**
     * Setter de value
     * @param value la valeur a attribuer
     */
	public void setValue(int value){
		
		if(value<=4 && value>=1){
			this.value = value;
		}
		else{
			System.out.println("Piece.setValue() : ERROR value invalid");
		}
		
	}

    /**
     * Getter de contain
     * @return le contenu de la pièce
     */
	public Piece getContain(){return this.contain;}

    /**
     * Setter de contain
     * @param contain le contenu a attribuer
     */
	public void setContain(Piece contain){
		
		this.contain = contain;
		
	}
      
}
