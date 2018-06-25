package arcanor;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class LoadListener implements MouseListener{
	private LoadButton origin;
	private JPanel board, cards;
	final static String GAMEBOARD = "Gameboard";

	public LoadListener(LoadButton origin, JPanel cards){
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
		
	public void mouseClicked(MouseEvent e){
		Game game= origin.getGame();
		if(game!=null){
			game.initializePanel(cards);
			game.start();
		}
	}
	
	public void mouseEntered(MouseEvent e){}
	
	public void mouseExited(MouseEvent e){}
	
	public void mousePressed(MouseEvent e){}
	
	public void mouseReleased(MouseEvent e){}
}
