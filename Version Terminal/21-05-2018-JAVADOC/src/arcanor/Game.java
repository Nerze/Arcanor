package arcanor;
public class Game implements IGame{
	private Board board;
	Player player1;
	Player player2;
	private final int DEFAULT_HEIGHT=7;
	private final int DEFAULT_WIDTH=8;
	public Game(String playerName1, String playerName2, boolean mode, int width, int height){
		if(width<1){
			System.out.println("Game() ERROR : width invalid");
			width=DEFAULT_WIDTH;
		}
		if(height<1){
			System.out.println("Game() ERROR : height invalid");
			height=DEFAULT_HEIGHT;
		}
		this.board= new Board(width,height);
		if(mode){
			
		}
		else{
			
		}
			
	}
	
	public void start(){
		int winner=0;
		int nbTours=0;
		while(winner==0){
			this.player1.play();
			nbTours++;
			winner=this.board.checkWin();
			if(winner==0){
				this.player2.play();
				nbTours++;
				winner=this.board.checkWin();
			}
		}
		endOfGame(winner);
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
	}
}
