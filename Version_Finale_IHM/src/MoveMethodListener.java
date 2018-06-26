package arcanor;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.Serializable;
public class MoveMethodListener implements ItemListener, Serializable{
	private Game game;
	private JComboBox origin;
	final static String QUIT = "Quit";
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
