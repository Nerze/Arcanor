package arcanor;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.Serializable;

public class EmptyListener implements MouseListener, Serializable{
	Game game;
	JCheckBox box;
	public EmptyListener(Game game,JCheckBox box){
		this.game=game;
		this.box=box;
		game.empty=box.isSelected();
	}
	public void mouseClicked(java.awt.event.MouseEvent evt) {
		game.empty=box.isSelected();
	}
	
	public void mouseEntered(MouseEvent e){}
	
	public void mouseExited(MouseEvent e){}
	
	public void mousePressed(MouseEvent e){}
	
	public void mouseReleased(MouseEvent e){}
}
