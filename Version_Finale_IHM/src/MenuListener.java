package arcanor;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class MenuListener implements MouseListener{
	private JPanel cards;
	private ButtonMenu origin;
	final static String QUIT = "Quit";
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
		
	public void mouseClicked(MouseEvent e){
		if(origin.getToMenu().equals(QUIT)){
			System.exit(0);
		}
		else{
			CardLayout cl = (CardLayout)(cards.getLayout());
			cl.show(cards, origin.getToMenu());
		}
	}
	
	public void mouseEntered(MouseEvent e){}
	
	public void mouseExited(MouseEvent e){}
	
	public void mousePressed(MouseEvent e){}
	
	public void mouseReleased(MouseEvent e){}
}
