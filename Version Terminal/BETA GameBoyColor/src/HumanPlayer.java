package arcanor;
import java.util.Scanner;

/**
 * This class represent a Human Player
 */
public class HumanPlayer extends Player{
	
	/**
	 * The constructor
	 * @param name Player's name
	 * @param color Player's color
	 * @param board Player's board
	 */
	public HumanPlayer(String name, boolean color, Board board){
		super(name, color, board);
	}
	
	/**
	 * The main thread to play
	 * @param numTour the current turn
	 */
	public void playTurn(int numTour){
		
		System.out.println("Turn " + numTour);
		Scanner in = new Scanner(System.in);
		boolean valid = false;
		String col;
		
		if(this.color){
			col = "(O) ";
		}else{
			col = "(X) ";
		}
		
		while(!valid){
			System.out.println("Your turn to play, " + col + this.name + " !");
			System.out.println(this.board.displayGrid());
			System.out.println("Move from row ?");
			int xOr = in.nextInt()-1;
			
			System.out.println("Move from line ?");
			int yOr = in.nextInt()-1;
			
			System.out.println("Move to row ?");
			int xDest = in.nextInt()-1;
			
			System.out.println("Move to line ?");
			int yDest = in.nextInt()-1;
			
			String empt = "";
			boolean empty = false;
			System.out.print("");
			empt = in.nextLine();
			
			while(!empt.equalsIgnoreCase("y") && !empt.equalsIgnoreCase("n")){
				System.out.println("Empty piece ? y/n");
				empt = in.nextLine();
			}
			
			if(empt.equalsIgnoreCase("y")){
				empty = true;
			}
			
			valid = this.board.movePiece(xOr, yOr, xDest, yDest, this.color, empty);
			if(!valid){
				System.out.println("You cannot perform that move !");
			}
		}
	}
}
