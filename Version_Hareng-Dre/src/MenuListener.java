package arcanor;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/**
 * Listen the action action performed on the menu button
 */
public class MenuListener implements MouseListener{
	
	/**
	 * The Panel where a menu is display
	 */
	private JPanel cards;
	
	/**
	 * The instance of ButtonMenu  that indicate which menu is display on cards
	 */
	private ButtonMenu origin;
	
	/**
	 * The name of the button use to go back or quit the game
	 */
	final static String QUIT = "Quit";
	
	/**
	 * The constructor of MenuListener
	 * @param origin the menu button
	 * @param cards the panel where the Menu is displayed
	 */
	public MenuListener(ButtonMenu origin, JPanel cards){
		if(origin==null){
			System.out.println("MenuListener() ERROR : origin is null");
			origin= new ButtonMenu("","1");
		}
		this.origin=origin;
		if(cards==null){
			System.out.println("MenuListener() ERROR : cards is null");
			cards = new JPanel(new CardLayout());
		}
		this.cards=cards;
	}
	
	/**
	 * Describe what to do when the mouse click on panel
	 * @param e the Mouse event
	 */
	public void mouseClicked(MouseEvent e){
		if(origin.getToMenu().equals(QUIT)){
			System.exit(0);
		}
		else{
			CardLayout cl = (CardLayout)(cards.getLayout());
			cl.show(cards, origin.getToMenu());
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
