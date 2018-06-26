package arcanor;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/**
 * Listen the action action performed on the resize button
 */
public class ParamButtonListener implements MouseListener{
	private JLabel aff;
	private String[] params;
	private int index;
	private ParamBouton origin;
	final static String QUIT = "Quit";
	
	/**
	 * Constructor of ParamButton
	 * @param origin button needed to resize the board
	 * @param params the list of param
	 * @param index the length of params
	 * @param aff the text of the button
	 */
	public ParamButtonListener(ParamBouton origin, String[] params, int index, JLabel aff){
		if(origin==null){
			System.out.println("MenuListener() ERROR : origin is null");
			origin= new ParamBouton("",0,0);
		}
		this.origin=origin;
		if(aff==null){
			System.out.println("MenuListener() ERROR : aff is null");
			aff = new JLabel("0");
		}
		this.aff=aff;
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
	 * Describe what to do when the mouse click on the panel
	 * @param e the Mouse event
	 */
	public void mouseClicked(MouseEvent e){
		int newValue= Integer.parseInt(params[index])+origin.getValue();
		if(newValue>=origin.getValMin()){
			aff.setText(newValue+"");
			params[index]=newValue+"";
		}
	}
	
	/**
	 * Describe what to do when the mouse enter the panel
	 * @param e the Mouse event
	 */
	public void mouseEntered(MouseEvent e){}
	
	/**
	 * Describe what to do when the mouse exit the panel
	 * @param e the Mouse event
	 */
	public void mouseExited(MouseEvent e){}
	
	/**
	 * Describe what to do when the mouse press on the panel
	 * @param e the Mouse event
	 */
	public void mousePressed(MouseEvent e){}
	
	/**
	 * Describe what to do when the mouse release on the panel
	 * @param e the Mouse event
	 */
	public void mouseReleased(MouseEvent e){}
}
