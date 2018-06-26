package arcanor;
import javax.swing.*;

/**
 * The class that implements the button for LoadMenu
 */
public class LoadButton extends JButton{
	private Game game;
	
	/**
	 * The constructor of LoadButton
	 * @param text the name of the button
	 * @param game the save loaded
	 */
	public LoadButton(String text, Game game){
		super(text);
		this.game=game;
	}
	
	/**
	 * Set the game to Load
	 * @param game
	 */
	public void setGame(Game game){
		this.game=game;
	}
	
	/**
	 * Return the game currently Load
	 * @return game
	 */
	public Game getGame(){return this.game;}
	
}
