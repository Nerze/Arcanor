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
	 * 
	 */
	private boolean isFree(int w, int h){
		boolean ret;
		if ((w > 0) && (h > 0) && (w < this.board.getWidth()-2) && (h < this.board.getHeight)
		//TO DO
	}
	
	/**
	 * The main thread to play
	 */
	public void playTurn(int turn){
		System.out.println(this.board.displayGrid());
		boolean valid = false, played = false;
		Random r = new Random();
		int width, height, choosen;

		while(!played){
			width = r.nextInt(this.board.getWidth());
			height = r.nextInt(this.board.getHeight());
			boolean free = this.isFree(width, height);
			if((this.board.getPiece(width, height) != null) && (this.board.getPiece(width, height).getColor() == this.color) && (free)){
				System.out.println(name + " took the piece : Row " + (width+1) + ", Line " + (height+1));
				while(!valid){
					choosen = r.nextInt(8);
					switch(choosen){
						case 1 :
							if (this.board.movePiece(width, height, width, height+1, this.color, r.nextBoolean())){
								valid = true;
								played = true;
								System.out.println(valid+" "+played);
								System.out.println("And play it in : Row " + (width+1) + ", Line " + (height+2));
							}
							break;
						case 2 :
							if (this.board.movePiece(width, height, width+1, height+1, this.color, r.nextBoolean())){
								valid = true;
								played = true;
								System.out.println(valid+" "+played);
								System.out.println("And play it in : Row " + (width+2) + ", Line " + (height+2));
							}
							break;
						case 3 :
							if (this.board.movePiece(width, height, width+1, height, this.color, r.nextBoolean())){
								valid = true;
								played = true;
								System.out.println(valid+" "+played);
								System.out.println("And play it in : Row " + (width+2) + ", Line " + (height+1));
							}
							break;
						case 4 :
							if (this.board.movePiece(width, height, width+1, height-1, this.color, r.nextBoolean())){
								valid = true;
								played = true;
								System.out.println(valid+" "+played);
								System.out.println("And play it in : Row " + (width+2) + ", Line " + (height));
							}
							break;
						case 5 :
							if (this.board.movePiece(width, height, width, height-1, this.color, r.nextBoolean())){
								valid = true;
								played = true;
								System.out.println(valid+" "+played);
								System.out.println("And play it in : Row " + (width+1) + ", Line " + (height));
							}
							break;
						case 6 :
							if (this.board.movePiece(width, height, width-1, height-1, this.color, r.nextBoolean())){
								valid = true;
								played = true;
								System.out.println(valid+" "+played);
								System.out.println("And play it in : Row " + (width) + ", Line " + (height));
							}
							break;
						case 7 :
							if (this.board.movePiece(width, height, width-1, height, this.color, r.nextBoolean())){
								valid = true;
								played = true;
								System.out.println(valid+" "+played);
								System.out.println("And play it in : Row " + (width) + ", Line " + (height+1));
							}
							break;
						case 0 :
							if (this.board.movePiece(width, height, width-1, height+1, this.color, r.nextBoolean())){
								valid = true;
								played = true;
								System.out.println(valid+" "+played);
								System.out.println("And play it in : Row " + (width) + ", Line " + (height+2));
							}
							break;
					}
				}
			}
		}
	}
}
