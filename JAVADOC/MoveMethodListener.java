package arcanor;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.Serializable;

/**
 * The class that listen the move for drag and drop
 */
public class MoveMethodListener implements ItemListener, Serializable{
	
	
	private Game game;
	private JComboBox origin;
	final static String QUIT = "Quit";
	
	/**
	 * The constructor of MoveMethodListener
	 * @param origin box that indicate if you want to empty a piece or not
	 * @param game the instance of game currently running
	 */
	public MoveMethodListener(JComboBox origin, Game game){
		if(origin==null){
			System.out.println("MoveMethodListener() ERROR : origin is null");
			origin= new JComboBox();
		}
		this.origin=origin;
		if(game==null){
			System.out.println("MoveMethodListener() ERROR : game is null");
			game = new Game(new ParamMenu(new JPanel()),new JPanel(new CardLayout()),new SaveMenu(new JPanel(new CardLayout())));
		}
		this.game=game;
	}
	
	/**
	 * Check if there is a change to the state of one item
	 * @param evt the item event
	 */
	public void itemStateChanged(ItemEvent evt) {
		String select =(String)(evt.getItem());
		if(select.equals("2 Clicks")){
			game.howToMove=false;
		}
		else{
			game.howToMove=true;
		}
		
	}
}
