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
		boolean ret = false;
		
		if (((w >= 0) && (h+1 >= 0) && (w <= this.board.getWidth()-1) && (h+1 <= this.board.getHeight()-1)) && (this.board.getPiece(w, h+1) == null)){ ret = true; }
		
		if (((w+1 >= 0) && (h+1 >= 0) && (w+1 <= this.board.getWidth()-1) && (h+1 <= this.board.getHeight()-1)) && (this.board.getPiece(w+1, h+1) == null)){ ret = true; }
		
		if (((w+1 >= 0) && (h >= 0) && (w+1 <= this.board.getWidth()-1) && (h <= this.board.getHeight()-1)) && (this.board.getPiece(w+1, h) == null)){ ret = true; }
		
		if (((w+1 >= 0) && (h-1 >= 0) && (w+1 <= this.board.getWidth()-1) && (h-1 <= this.board.getHeight()-1)) && (this.board.getPiece(w+1, h-1) == null)){ ret = true; }
		
		if (((w >= 0) && (h-1 >= 0) && (w <= this.board.getWidth()-1) && (h-1 <= this.board.getHeight()-1)) && (this.board.getPiece(w, h-1) == null)){ ret = true; }
		
		if (((w-1 >= 0) && (h-1 >= 0) && (w-1 <= this.board.getWidth()-1) && (h-1 <= this.board.getHeight()-1)) && (this.board.getPiece(w-1, h-1) == null)){ ret = true; }
		
		if (((w-1 >= 0) && (h >= 0) && (w-1 <= this.board.getWidth()-1) && (h <= this.board.getHeight()-1)) && (this.board.getPiece(w-1, h) == null)){ ret = true; }
		
		if (((w-1 >= 0) && (h+1 >= 0) && (w-1 <= this.board.getWidth()-1) && (h+1 <= this.board.getHeight()-1)) && (this.board.getPiece(w-1, h+1) == null)){ ret = true; }

		return ret;
	}
	
	/**
	 * 
	 */
	private boolean isMarked(int h, boolean color){
		boolean ret = false;
		if(((color == true) && h == this.board.getHeight()-1) || ((color == false) && h == 0)){
			ret = true;
		}
		return ret;
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
			if((this.board.getPiece(width, height) != null) && (this.board.getPiece(width, height).getColor() == this.color) && (this.isFree(width, height)) && !(isMarked(height, this.color))){
				System.out.println(name + " took the piece : Row " + (width+1) + ", Line " + (height+1));
				while(!valid){
					choosen = r.nextInt(8);
					switch(choosen){
						case 1 :
							if (this.board.movePiece(width, height, width, height+1, this.color, r.nextBoolean())){
								valid = true;
								played = true;
								System.out.println("And play it in : Row " + (width+1) + ", Line " + (height+2));
							}
							break;
						case 2 :
							if (this.board.movePiece(width, height, width+1, height+1, this.color, r.nextBoolean())){
								valid = true;
								played = true;
								System.out.println("And play it in : Row " + (width+2) + ", Line " + (height+2));
							}
							break;
						case 3 :
							if (this.board.movePiece(width, height, width+1, height, this.color, r.nextBoolean())){
								valid = true;
								played = true;
								System.out.println("And play it in : Row " + (width+2) + ", Line " + (height+1));
							}
							break;
						case 4 :
							if (this.board.movePiece(width, height, width+1, height-1, this.color, r.nextBoolean())){
								valid = true;
								played = true;
								System.out.println("And play it in : Row " + (width+2) + ", Line " + (height));
							}
							break;
						case 5 :
							if (this.board.movePiece(width, height, width, height-1, this.color, r.nextBoolean())){
								valid = true;
								played = true;
								System.out.println("And play it in : Row " + (width+1) + ", Line " + (height));
							}
							break;
						case 6 :
							if (this.board.movePiece(width, height, width-1, height-1, this.color, r.nextBoolean())){
								valid = true;
								played = true;
								System.out.println("And play it in : Row " + (width) + ", Line " + (height));
							}
							break;
						case 7 :
							if (this.board.movePiece(width, height, width-1, height, this.color, r.nextBoolean())){
								valid = true;
								played = true;
								System.out.println("And play it in : Row " + (width) + ", Line " + (height+1));
							}
							break;
						case 0 :
							if (this.board.movePiece(width, height, width-1, height+1, this.color, r.nextBoolean())){
								valid = true;
								played = true;
								System.out.println("And play it in : Row " + (width) + ", Line " + (height+2));
							}
							break;
					}
				}
			}
		}
	}
}
