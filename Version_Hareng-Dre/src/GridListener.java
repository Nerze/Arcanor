package arcanor;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.Serializable;

/**
 * Describe what to do when a mouse act on the grid
 */
public class GridListener extends MouseAdapter implements Serializable{
	
	Game game;
	int xOr, yOr;
	boolean end;
	JTable tab;
	
	/**
     * Constructor of GridListener
     * @param game the instance of game currently running
     * @param tab the table where the grid is displayed
     */
	public GridListener(Game game,JTable tab){
		this.game=game;
		xOr=-1;
		yOr=-1;
		end=false;
		this.tab=tab;
	}
	
	/**
     * Describe what to do when a mouse click the panel
     * @param evt the mouse event
     */
	public void mouseClicked(java.awt.event.MouseEvent evt) {
		if((!end) && (!game.howToMove)){
			int y = tab.rowAtPoint(evt.getPoint());
			int x = tab.columnAtPoint(evt.getPoint());
			if(xOr==-1 || yOr==-1){
				xOr=x;
				yOr=y;
			}
			else{
				if(game.board.movePiece(xOr,game.board.getHeight()-yOr-1,x,game.board.getHeight()-y-1,game.turnOf,game.empty)){
					game.empty=false;
					game.empt.setSelected(false);
					int winner=game.board.checkWin();
					if(winner!=0){
						endOfGame(winner);
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
		playIA();
		if(!end){
			String turnOfPlayer;
			if(game.turnOf){
				turnOfPlayer=game.player1.getName();
			}
			else{
				turnOfPlayer=game.player2.getName();
			}
			game.playerTurn.setText("Your time to play "+turnOfPlayer);
		}
	}
	
	/**
     * Describe what to do when a mouse press on the panel
     * @param evt the mouse event
     */
	public void mousePressed(java.awt.event.MouseEvent evt){
		if((!end) && game.howToMove){
			int y = tab.rowAtPoint(evt.getPoint());
			int x = tab.columnAtPoint(evt.getPoint());
			xOr=x;
			yOr=y;
		}
	}
	
	/**
     * Describe what to do when a mouse releanse on the panel
     * @param evt the mouse event
     */
	public void mouseReleased(java.awt.event.MouseEvent evt){
		if((!end) && game.howToMove){
			int y = tab.rowAtPoint(evt.getPoint());
			int x = tab.columnAtPoint(evt.getPoint());
			if(game.board.movePiece(xOr,game.board.getHeight()-yOr-1,x,game.board.getHeight()-y-1,game.turnOf,game.empty)){
				game.empty=false;
				game.empt.setSelected(false);
				int winner=game.board.checkWin();
				if(winner!=0){
					endOfGame(winner);
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
		playIA();
		if(!end){
			String turnOfPlayer;
			if(game.turnOf){
				turnOfPlayer=game.player1.getName();
			}
			else{
				turnOfPlayer=game.player2.getName();
			}
			game.playerTurn.setText("Your time to play "+turnOfPlayer);
		}
	}
	
	/**
     * Check if someone reach the number of point needed to win
     * @param winner indicate who win
     */
	public void endOfGame(int winner){
		switch(winner){
			case 1:
				game.playerTurn.setText(game.player1.getName()+" wins !");
				System.out.println(game.playerTurn.getText());
				break;
			case -1:
				game.playerTurn.setText(game.player2.getName()+" wins !");
				break;
			default :
				game.playerTurn.setText("Error : winner invalid");
				break;
		}
	}
	
	/**
	 * Make the IA plays
	 */
	public void playIA(){
		boolean nextPlay=true;
		while(nextPlay && (!end)){
			Player play;
			if(game.turnOf){
				play=game.player1;
			}else{
				play=game.player2;
			}
			if(play.playTurn()){
				nextPlay=true;
				game.turnOf=!game.turnOf;
			}
			else{
				nextPlay=false;
			}
			int winner=game.board.checkWin();
			if(winner!=0){
				endOfGame(winner);
				end=true;
			}
		}
	}
}
