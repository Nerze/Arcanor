package arcanor;
import java.util.Random;

/**
 * This class represent the random IA to play with
 */
public class AIPlayer extends Player{
	
	/**
	 * The constructor
	 * @param name His name
	 * @param color His color
	 * @param board His board
	 */
	public AIPlayer(String name, boolean color, Board board){
		super(name, color, board);
	}
	
	/**
	 * The main thread to play
	 */
	public void playTurn(){
		System.out.println(this.board.displayGrid());
		boolean valid = false, played = false;
		Random r = new Random();
		int width, height, choosen;
		Piece cho;
		while(!played){
			width = r.nextInt(this.board.getWidth());
			height = r.nextInt(this.board.getHeight());
			if((this.board.getPiece(width, height) != null) && (this.board.getPiece(width, height).getColor == this.color){
				System.out.println(name + " take the piece : " + width + "," + height);
				while(!valid){
					choosen = r.nextInt(8);
					switch(choosen){
						case 1 :
							valid = movePiece(width, height, width, height+1, this.color, r.nextBoolean());
						case 2 :
							valid = movePiece(width, height, width+1, height+1, this.color, r.nextBoolean());
						case 3 :
							valid = movePiece(width, height, width+1, height, this.color, r.nextBoolean());
						case 4 :
							valid = movePiece(width, height, width+1, height-1, this.color, r.nextBoolean());
						case 5 :
							valid = movePiece(width, height, width, height-1, this.color, r.nextBoolean());
						case 6 :
							valid = movePiece(width, height, width-1, height-1, this.color, r.nextBoolean());
						case 7 :
							valid = movePiece(width, height, width-1, height, this.color, r.nextBoolean());
						case 0 :
							valid = movePiece(width, height, width-1, height+1, this.color, r.nextBoolean());
					}
				}
			}
		}
	}
}
