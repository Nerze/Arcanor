package arcanor
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class GridListener implements MouseAdapter{
	Game game;
	public GridListener(Game game){
		this.game=game;
	}
	public void mouseClicked(java.awt.event.MouseEvent evt) {
		int row = tab.rowAtPoint(evt.getPoint());
		int col = tab.columnAtPoint(evt.getPoint());
		System.out.println("Clicked "+row +" "+col);
	}
}
