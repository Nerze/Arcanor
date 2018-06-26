package arcanor;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.Serializable;

/**
 * Listen the action action performed on the save button
 */
public class SaveListener implements MouseListener, Serializable{
	
	private Game game;
	int numSave;
	private JPanel cards;
	private SaveMenu saves;
	final static String GAMEBOARD = "Gameboard";
	
	/**
	 * The constructor of Save Listenner
	 * @param cards panel where SaveMenu is displayed
	 * @param game the instance of game currently running
	 * @param numSave the number of the save
	 * @param saves the instance of SaveMenu that the class listen
	 */
	public SaveListener(JPanel cards, Game game, int numSave, SaveMenu saves){
		this.game=game;
		this.numSave=numSave;
		this.cards=cards;
		this.saves=saves;
	}
	
	/**
	 * Describe what to do when the mouse click on the panel
	 * @param evt the Mouse event
	 */
	public void mouseClicked(java.awt.event.MouseEvent evt) {
		game.save(numSave);
		CardLayout cl = (CardLayout)(cards.getLayout());
		cl.show(cards, GAMEBOARD);
		saves = new SaveMenu(cards);
		saves.paintMe(cards, game);
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
