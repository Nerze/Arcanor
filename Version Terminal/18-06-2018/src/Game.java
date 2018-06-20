package arcanor;
import java.util.Scanner;

/**
 * This class represent the game logic, thread
 */
public class Game{
	
	/**
	 * The board object that contain pieces
	 */
	private Board board;
	
	/**
	 * The player one
	 */
	private Player player1;
	
	/**
	 * The player two
	 */
	private Player player2;
	
	/**
	 * This constant represent the default height for each board
	 */
	private final int DEFAULT_HEIGHT=7;
	
	/**
	 * This constant represent the default width for each board
	 */
	private final int DEFAULT_WIDTH=3;
	
	/**
	 * The constructor 
	 */
	public Game(ParamMenu params){
		int width = Integer.parseInt(params.getTabParams()[1]);
		int height = Integer.parseInt(params.getTabParams()[0]);
		int vict = Integer.parseInt(params.getTabParams()[5]);
		
		if(width < 1){
			System.err.println("ERROR - Game() - width invalid");
			width=DEFAULT_WIDTH;
		}
		
		if(height < 1){
			System.err.println("ERROR - Game() - height invalid");
			height=DEFAULT_HEIGHT;
		}
		
		if(vict < 1){
			System.err.println("ERROR - Game() - points to victory invalid");
			vict=width*4;
		}
		
		this.board = new Board(width,height,vict);
		int nbHumans = Integer.parseInt(params.getTabParams()[2]);
		
		if(nbHumans>0){
			this.player1 = new HumanPlayer(params.getTabParams()[3], true, this.board);
			if(nbHumans > 1){
				this.player2 = new HumanPlayer(params.getTabParams()[4], false, this.board);
			}else{
				this.player2 = new AIPlayer(params.getTabParams()[4], false, this.board);
			}
		}else{
			this.player1= new AIPlayer(params.getTabParams()[3], true, this.board);
		}	
	}
	
	/**
	 * The main thread of the game
	 */
	public boolean start(){
		int winner = 0;
		int nbTours = 1;
		
		while(winner == 0){
			this.player1.playTurn();
			nbTours++;
			winner = this.board.checkWin();
			if(winner == 0){
				this.player2.playTurn();
				nbTours++;
				winner=this.board.checkWin();
			}
		}
		endOfGame(winner);
		return true;
	}
	
	/**
	 * The method to end the game
	 */
	public void endOfGame(int winner){
		switch(winner){
			case 1:
				System.out.println(this.board.toString());
				System.out.println(player1.getName() + " wins");
				break;
			case -1:
				System.out.println(this.board.toString());
				System.out.println(player2.getName() + " wins");
				break;
			default:
				System.out.println(this.board.toString());
				System.out.println("ERROR - Game.endOfGame() - Winner invalid");
				break;
		}
		
		Scanner in = new Scanner(System.in);
		System.out.println("ENTER to end the game");
		String input = in.nextLine();
	}
}
