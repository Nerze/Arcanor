package arcanor;
import javax.swing.*;
public class ParamBouton extends JButton{
	private int value;
	private int valMin;
	
	public ParamBouton(String text, int value, int valMin){
		super(text);
		this.value=value;
		this.valMin=valMin;
	}
	
	public void setValMin(int valMin){
		this.valMin=valMin;
	}
	
	
	public void setValue(int value){
		this.value=value;
	}
	
	public int getValMin(){return this.valMin;}
	
	public int getValue(){return this.value;}
	
}
