package arcanor;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/**
 * The class that manage the JTextField
 */
public class TextFieldParamListener implements FocusListener{
	
	String[] params;
	int index;
	JTextField origin;
	
	/**
	 * The constructor of TextFieldParamListener
	 * @param origin the the default content
	 * @param params the list of param
	 * @param index the length of params
	 */
	public TextFieldParamListener(JTextField origin, String[] params, int index){
		if(origin==null){
			System.out.println("MenuListener() ERROR : origin is null");
			origin= new JTextField("");
		}
		this.origin=origin;
		if(params==null){
			System.out.println("MenuListener() ERROR : params is null");
			params = new String[6];
		}
		this.params=params;
		if(index<0 || index>=params.length){
			System.out.println("MenuListener() ERROR : index is invalid");
			index = 0;
		}
		this.index=index;
	}
	
	/**
	 * Describe what to do when we gaine focus
	 * @param e the focus event
	 */
	public void focusGained(FocusEvent e) {
    }
	
	/**
	 * Describe what to do when we lost focus
	 * @param e the focus event
	 */
    public void focusLost(FocusEvent e) {
        params[index]=origin.getText();
        System.out.println("tabParam["+index+"] set to "+params[index]);
    }
}
