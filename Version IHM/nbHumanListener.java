package arcanor;
import javax.swing.*;
import java.awt.event.*;
public class nbHumanListener implements ItemListener{
	private String[] params;
	private int index;
	private JComboBox origin;
	final static String QUIT = "Quit";
	public nbHumanListener(JComboBox origin, String[] params, int index){
		if(origin==null){
			System.out.println("MenuListener() ERROR : origin is null");
			origin= new JComboBox();
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
	
	
	public void itemStateChanged(ItemEvent evt) {
		params[index] = (String)evt.getItem();
		
	}
}
