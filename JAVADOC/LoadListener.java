package arcanor;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/**
 * Listen the action action performed on the LoadMenu
 */
public class LoadListener implements MouseListener{
	
	private LoadButton origin;
	private JPanel board, cards;
	private SaveMenu sav;
	final static String GAMEBOARD = "Gameboard";
	
	/**
	 * The constructor of LoadListener
	 * @param origin the load button
	 * @param cards the panel where LoadMenu is displayed
	 * @param sav the current instance of SaveMenu
	 */
	public LoadListener(LoadButton origin, JPanel cards, SaveMenu sav){
		this.sav=sav;
		if(origin==null){
			System.out.println("MenuListener() ERROR : origin is null");
			origin= new LoadButton("",null);
		}
		this.origin=origin;
		if(cards==null){
			System.out.println("MenuListener() ERROR : cards is null");
			cards = new JPanel(new CardLayout());
		}
		this.cards=cards;
	}
	
	/**
	 * Describe what to do when the mouse click on the panel
	 * @param e the Mouse event
	 */
	public void mouseClicked(MouseEvent e){
		Game game= origin.getGame();
		if(game!=null){
			game.initializePanel(cards, sav);
			game.start();
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
