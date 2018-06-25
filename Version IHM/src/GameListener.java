package arcanor;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class GameListener implements MouseListener{
	private JPanel cards, board;
	private ParamMenu params;
	final static String GAMEBOARD = "Gameboard";
	Game game;
	SaveMenu sav;
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
		
	public void mouseClicked(MouseEvent e){
	}
	
	public void mouseEntered(MouseEvent e){}
	
	public void mouseExited(MouseEvent e){}
	
	public void mousePressed(MouseEvent e){
		this.game=new Game(params, cards, sav);
	}
	
	public void mouseReleased(MouseEvent e){
		game.start();
	}
}

