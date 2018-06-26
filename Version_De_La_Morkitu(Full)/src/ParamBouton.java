package arcanor;
import javax.swing.*;

/**
 * Build the button needed to resize the board
 */
public class ParamBouton extends JButton{
	
	/**
	 * The value of the size
	 */
	private int value;
	
	/**
	 * Minimal value
	 */
	private int valMin;
	
	/**
	 * The constructor of ParamBouton
	 * @param text the name of the button
	 * @param value update this.value
	 */
	public ParamBouton(String text, int value, int valMin){
		super(text);
		this.value=value;
		this.valMin=valMin;
	}
	
	/**
	 * Set the minimal value
	 * @param valMin the minimal value
	 */
	public void setValMin(int valMin){
		this.valMin=valMin;
	}
	
	/**
	 * Set value
	 * @param value the value
	 */
	public void setValue(int value){
		this.value=value;
	}
	
	/**
	 * Get the minimal value
	 * @return valMin the minimal value
	 */
	public int getValMin(){return this.valMin;}
	
	/**
	 * Get value
	 * @return value the value
	 */
	public int getValue(){return this.value;}
	
}
