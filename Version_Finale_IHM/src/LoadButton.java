package arcanor;
import javax.swing.*;
public class LoadButton extends JButton{
	private Game game;
	
	public LoadButton(String text, Game game){
		super(text);
		this.game=game;
	}
	
	
	public void setGame(Game game){
		this.game=game;
	}
	
	
	public Game getGame(){return this.game;}
	
}
