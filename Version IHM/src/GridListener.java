package arcanor;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.Serializable;

public class GridListener extends MouseAdapter implements Serializable{
	Game game;
	int xOr, yOr;
	boolean end;
	JTable tab;
	public GridListener(Game game,JTable tab){
		this.game=game;
		xOr=-1;
		yOr=-1;
		end=false;
		this.tab=tab;
	}
	public void mouseClicked(java.awt.event.MouseEvent evt) {
		if(!end){
			int y = tab.rowAtPoint(evt.getPoint());
			int x = tab.columnAtPoint(evt.getPoint());
			if(xOr==-1 || yOr==-1){
				xOr=x;
				yOr=y;
			}
			else{
				if(game.board.movePiece(xOr,game.board.getHeight()-yOr-1,x,game.board.getHeight()-y-1,game.turnOf,game.empty)){
					int winner=game.board.checkWin();
					if(winner!=0){
						game.endOfGame(winner);
						end=true;
					}
					else{
						if(!game.turnOf){
							game.nbTours++;
						}
						game.turnOf=!game.turnOf;
					}
				}
				xOr=-1;
				yOr=-1;
			}
		}
	}
}
