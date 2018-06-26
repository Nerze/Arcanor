package arcanor;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.Serializable;

public class SaveListener implements MouseListener, Serializable{
	private Game game;
	int numSave;
	private JPanel cards;
	private SaveMenu saves;
	final static String GAMEBOARD = "Gameboard";
	public SaveListener(JPanel cards, Game game, int numSave, SaveMenu saves){
		this.game=game;
		this.numSave=numSave;
		this.cards=cards;
		this.saves=saves;
	}
	public void mouseClicked(java.awt.event.MouseEvent evt) {
		game.save(numSave);
		CardLayout cl = (CardLayout)(cards.getLayout());
		cl.show(cards, GAMEBOARD);
		saves = new SaveMenu(cards);
		saves.paintMe(cards, game);
	}
	
	public void mouseEntered(MouseEvent e){}
	
	public void mouseExited(MouseEvent e){}
	
	public void mousePressed(MouseEvent e){}
	
	public void mouseReleased(MouseEvent e){}
}
