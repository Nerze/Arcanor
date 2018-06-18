package arcanor;
import java.util.Scanner;
public class Game{
	private Board board;
	Player player1;
	Player player2;
	private final int DEFAULT_HEIGHT=7;
	private final int DEFAULT_WIDTH=8;
	public Game(ParamMenu params){
		int width=Integer.parseInt(params.getTabParams()[1]);
		int height=Integer.parseInt(params.getTabParams()[0]);
		if(width<1){
			System.out.println("Game() ERROR : width invalid");
			width=DEFAULT_WIDTH;
		}
		if(height<1){
			System.out.println("Game() ERROR : height invalid");
			height=DEFAULT_HEIGHT;
		}
		width=DEFAULT_WIDTH;
		height=DEFAULT_HEIGHT;
		this.board= new Board(width,height);
		int nbHumans= Integer.parseInt(params.getTabParams()[2]);
		if(nbHumans>0){
			this.player1= new HumanPlayer(params.getTabParams()[3], true, this.board);
			if(nbHumans>1){
				this.player2= new HumanPlayer(params.getTabParams()[4], false, this.board);
			}
			else{
				this.player2= new AIPlayer(params.getTabParams()[4], false, this.board);
			}
		}
		else{
			this.player1= new AIPlayer(params.getTabParams()[3], true, this.board);
		}	
	}
	
	public boolean start(){
		int winner=0;
		int nbTours=1;
		while(winner==0){
			this.player1.playTurn();
			nbTours++;
			winner=this.board.checkWin();
			if(winner==0){
				this.player2.playTurn();
				nbTours++;
				winner=this.board.checkWin();
			}
		}
		endOfGame(winner);
		return true;
	}
	public String description(){return "";}
	public void endOfGame(int winner){
		switch(winner){
			case 1:
				System.out.println(this.board.toString());
				System.out.println(player1.getName()+" wins");
				break;
			case -1:
				System.out.println(this.board.toString());
				System.out.println(player2.getName()+" wins");
				break;
			default :
				System.out.println(this.board.toString());
				System.out.println("Game.endOfGame() ERROR : Winner invalid");
				break;
		}
		Scanner in = new Scanner(System.in);
		System.out.println("ENTER to end the game");
		String input = in.nextLine();
	}
}
