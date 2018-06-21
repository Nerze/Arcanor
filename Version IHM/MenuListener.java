import java.awt.event.*;
import javax.swing.*;
import java.awt.*;


public class MenuListener implements MouseListener{
	private JPanel cards;
	private ButtonMenu origin;
	public MenuListener(ButtonMenu origin, JPanel cards){
		if(origin==null){
			System.out.println("MenuListener() ERROR : origin is null");
			origin= new ButtonMenu("",1);
		}
		this.origin=origin;
	}
		
	public void mouseClicked(MouseEvent e){
		
	}
	
	public void mouseEntered(MouseEvent e){}
	
	public void mouseExited(MouseEvent e){}
	
	public void mousePressed(MouseEvent e){}
	
	public void mouseReleased(MouseEvent e){}
}
