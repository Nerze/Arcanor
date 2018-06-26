package arcanor;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class TextFieldParamListener implements FocusListener{
	String[] params;
	int index;
	JTextField origin;
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
	
	public void focusGained(FocusEvent e) {
    }

    public void focusLost(FocusEvent e) {
        params[index]=origin.getText();
        System.out.println("tabParam["+index+"] set to "+params[index]);
    }
}
