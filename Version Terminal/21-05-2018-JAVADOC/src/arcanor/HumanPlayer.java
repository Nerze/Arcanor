package arcanor;
import java.util.Scanner;
public class HumanPlayer extends Player{
	
	public HumanPlayer(String name, boolean color, Board board){
		super(name, color, board);
	}
	
	
	public void playTurn(){
		Scanner in = new Scanner(System.in);
		boolean valid=false;
		while(!valid){
			System.out.println(this.board.displayGrid());
			System.out.println("Move from row ?");
			int xOr= in.nextInt();
			System.out.println("Move from line ?");
			int yOr= in.nextInt();
			System.out.println("Move to row ?");
			int xDest= in.nextInt();
			System.out.println("Move to line ?");
			int yDest= in.nextInt();
			valid=this.board.movePiece(xOr,yOr, xDest, yDest,this.color);
			if(!valid){
				System.out.println("You cannot perform that move !");
			}
		}
	}
}
