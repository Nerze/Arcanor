package arcanor;
import javax.swing.*;
import java.awt.event.*;

/**
 * The class that listen the actions performed by human players
 */
public class nbHumanListener implements ItemListener{
	private String[] params;
	private int index;
	private JComboBox origin;
	final static String QUIT = "Quit";
	
	/**
	 * The constructor of nbHumanListener
	 * @param origin the box that you click to empty or not a piece
	 * @param params the list of param needed to know how many player are human
	 * @param index the legnth of params
	 */
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
	
	/**
	 * Describe what to do when the state of one item change
	 * @param evt the Item event
	 */
	public void itemStateChanged(ItemEvent evt) {
		params[index] = (String)evt.getItem();
	}
}
