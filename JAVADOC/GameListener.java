package arcanor;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/**
 * Describe what to do when a mouse release on the grid on the panel
 */
public class GameListener implements MouseListener{
	private JPanel cards, board;
	private ParamMenu params;
	final static String GAMEBOARD = "Gameboard";
	Game game;
	SaveMenu sav;
	
	/**
     * Constructor of GameListener
     */
	public GameListener(ParamMenu params, JPanel cards, SaveMenu sav){
		this.sav=sav;
		if(params==null){
			System.out.println("GameListener() ERROR : params is null");
			params= new ParamMenu(cards);
		}
		this.params=params;
		if(cards==null){
			System.out.println("GameListener() ERROR : cards is null");
			cards = new JPanel(new CardLayout());
		}
		this.cards=cards;
	}
	
	/**
     * Describe what to do when a mouse click on the panel
     */
	public void mouseClicked(MouseEvent e){
	}
	
	/**
     * Describe what to do when a mouse enter the panel
     */
	public void mouseEntered(MouseEvent e){}
	
	/**
     * Describe what to do when a mouse exit the panel
     */
	public void mouseExited(MouseEvent e){}
	
	/**
     * Describe what to do when a mouse press on the panel
     */
	public void mousePressed(MouseEvent e){
		this.game=new Game(params, cards, sav);
	}
	
	/**
     * Describe what to do when a mouse release on the panel
     */
	public void mouseReleased(MouseEvent e){
		game.start();
	}
}

