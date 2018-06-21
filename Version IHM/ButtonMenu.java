import javax.swing.*;

public class ButtonMenu extends JButton{
	private int toMenu;
	
	public ButtonMenu(String text, int toMenu){
		super(text);
		if(toMenu<0){
			System.out.println("ButtonMenu() ERROR : toMenu invalid");
			toMenu=0;
		}
		this.toMenu=toMenu;
	}
	
	
	public void setToMenu(int toMenu){
		if(toMenu<1){
			System.out.println("setToMenu() ERROR : toMenu invalid");
		}
		else{
			this.toMenu=toMenu;
		}
	}
	
	
	public int getToMenu(){return this.toMenu;}
	
}
