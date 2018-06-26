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
	
	public void mousePressed(java.awt.event.MouseEvent evt){
		if((!end) && game.howToMove){
			int y = tab.rowAtPoint(evt.getPoint());
			int x = tab.columnAtPoint(evt.getPoint());
			xOr=x;
			yOr=y;
		}
	}
	
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
	/*
	 * Fait jouer les IA
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
