package arcanor;
import javax.swing.*;

/**
 * The class that implements the buttons of Menu the button
 */
public class ButtonMenu extends JButton{
	private String toMenu;
	final static String QUIT = "Quit";
	
	/**
	 * The constructor of ButtonMenu
	 */
	public ButtonMenu(String text, String toMenu){
		super(text);
		if(toMenu==null){
			System.out.println("ButtonMenu() ERROR : toMenu is null");
			toMenu=QUIT;
		}
		this.toMenu=toMenu;
	}
	
	/**
	 * Set the name of the menu that need those button
	 */
	public void setToMenu(String toMenu){
		if(toMenu==null){
			System.out.println("setToMenu() ERROR : toMenu is null");
		}
		else{
			this.toMenu=toMenu;
		}
	}
	
	/**
	 * Get the name of the menu that need those button
	 */
	public String getToMenu(){return this.toMenu;}
	
}
