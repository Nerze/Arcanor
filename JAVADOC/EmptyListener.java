package arcanor;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.Serializable;

/**
 * Describe what to do when a mouse act on empty part of the panel
 */
public class EmptyListener implements MouseListener, Serializable{
	Game game;
	JCheckBox box;
	
	/**
     * Constructor of EmptyListener
     * @param game the instance of Game that we run
     * @param box the box that you clickwhen you want to empty a piece
     */
	public EmptyListener(Game game,JCheckBox box){
		this.game=game;
		this.box=box;
		game.empty=box.isSelected();
	}
	
	/**
	 * Describe what to do when the mouse click on panel
	 * @param e the Mouse event
	 */
	public void mouseClicked(java.awt.event.MouseEvent evt) {
		game.empty=box.isSelected();
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
