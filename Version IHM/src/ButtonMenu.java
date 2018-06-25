package arcanor;
import javax.swing.*;
public class ButtonMenu extends JButton{
	private String toMenu;
	final static String QUIT = "Quit";
	
	public ButtonMenu(String text, String toMenu){
		super(text);
		if(toMenu==null){
			System.out.println("ButtonMenu() ERROR : toMenu is null");
			toMenu=QUIT;
		}
		this.toMenu=toMenu;
	}
	
	
	public void setToMenu(String toMenu){
		if(toMenu==null){
			System.out.println("setToMenu() ERROR : toMenu is null");
		}
		else{
			this.toMenu=toMenu;
		}
	}
	
	
	public String getToMenu(){return this.toMenu;}
	
}
