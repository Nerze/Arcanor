package arcanor;
import java.io.Serializable;
import tools.Color;
/**
 * This class represent a game Board that contain Pieces
 */
public class Board implements Serializable{

	/**
	 * Main attributes of the class
	 */
	private int width, height, victoryPoints;
	
	/**
	 * Defaults values
	 */
	private final int DEFAULT_HEIGHT = 7;
	private final int DEFAULT_WIDTH = 3;
	
	/**
	 * The board, a 2D Piece's Table
	 */
	private Piece[][] grid;
	
	/**
	 * The constructor
	 * @param width Board's Width
	 * @param height Board's Height
	 * @param victoryPoints The needed points to win the game
	 */
	public Board(int width, int height, int victoryPoints){
		if(width < 1){
			width=DEFAULT_WIDTH;
		}
		
		if(height < 1){
			height=DEFAULT_HEIGHT;
		}
		
		if(victoryPoints < 1){
			victoryPoints = width*4;
		}
		
		this.width = width*3-1;
		this.height = height;
		this.victoryPoints = victoryPoints;
		grid = new Piece[width*3-1][height];
		initializeGrid();
	}
	
	/**
	 * This method initialize the grid
	 */
	public void initializeGrid(){
		for(int i = 0; i < (this.width+1)/3; i++){
			this.grid[i*3][0] = new Piece(true, 1, new Piece(true, 2, null));
			this.grid[i*3+1][0] = new Piece(true, 3, new Piece(true, 4, null));
			this.grid[i*3+1][this.height-1] = new Piece(false, 1, new Piece(false, 2, null));
			this.grid[i*3][this.height-1] = new Piece(false, 3, new Piece(false, 4, null));
		}
	}
			
	/**
	 * The method check if someone win
	 * @return 0 if no winner, -1 if Player 2 win, 1 if Player 1 win
	 */
	public int checkWin(){
		int ret = 0;
		int player1Points = 0;
		int player2Points = 0;
		
		for(int i = 0; i < this.width; i++){
			if(this.grid[i][height-1] != null){
				if(this.grid[i][height-1].getColor()){
					player1Points += this.grid[i][height-1].getValue();
				}
			}
			
			if(this.grid[i][0] != null){
				if(!this.grid[i][0].getColor()){
					player2Points += this.grid[i][0].getValue();
				}
			}
		}
		if(player1Points >= this.victoryPoints){
			ret = 1;
		}else if(player2Points >= this.victoryPoints){
			ret =- 1;
		}
		return ret;
			
	}
	
	/**
	 * This method move a Piece if the moove is available and return true if the moove has been done
	 * @param xOr Piece's X origin Coordonate
	 * @param yOr Piece's Y origin Coordonate
	 * @param xDest Piece's X destination Coordonate 
	 * @param yDest Piece's Y destination Coordonate
	 * @param colorPlayer Player's color
	 * @param empty true if the player want to empty the current Piece
	 * @return true if the moove has been done
	 */
	public boolean movePiece(int xOr,int yOr, int xDest, int yDest, boolean colorPlayer, boolean empty){
		boolean ret=false;
		
		if(xOr-xDest <= 1 && xDest-xOr <= 1 && yOr-yDest <= 1 && yDest-yOr <= 1 && yDest < this.height && yDest >= 0 && yOr < this.height && yOr >= 0 && xDest < this.width && xDest >= 0 && xOr < this.width && xOr >= 0){
			//Coordinates valids
			if(!(colorPlayer == false && yOr == 0) && !(colorPlayer == true && yOr == height-1)){//The piece is not on the arrival line
				if(this.grid[xOr][yOr] != null){
					if(this.grid[xOr][yOr].getColor() == colorPlayer){//The player tries to move its own piece
						if(this.grid[xDest][yDest] == null){//There is no piece at the destination
							this.grid[xDest][yDest] = this.grid[xOr][yOr];
							
							if(empty){
								this.grid[xOr][yOr] = this.grid[xDest][yDest].getContain();
								this.grid[xDest][yDest].setContain(null);
							}else{
								this.grid[xOr][yOr] = null;
							}
							
							ret = true;
						}else{//There is a piece at the destination
							if(this.grid[xDest][yDest].getValue() == this.grid[xOr][yOr].getValue()+1 && this.grid[xDest][yDest].getColor() != this.grid[xOr][yOr].getColor()){
								//If you can eat the piece
								if((!(colorPlayer == true && yDest == 0)) && (!(colorPlayer == false && yDest == height-1))){//The piece is not on the arrival line
									
									Piece or = this.grid[xOr][yOr];
									this.grid[xOr][yOr] = or.getContain();//The inside of the moving piece is the new piece on this spot
									or.setContain(this.grid[xDest][yDest]);//put the piece in the bigger one
									this.grid[xDest][yDest] = or;//Move it to the destination
									ret = true;
								}
							}
						}
					}
				}
			}
		}
		return ret;
	}
	
	/**
	 * Getter of height
	 * @return the Height
	 */
	public int getHeight(){ return this.height; }
	
	/**
	 * Getter of width
	 * @return the Width
	 */
	public int getWidth(){ return this.width; }
	
	/**
	 * This method convert data into printable string
	 * @return the String
	 */
	public String toString(){
		String ret = "Width : " + width + "\n";
		ret += "Height : " + height + "\n";
		ret += "Grid : \n";
		ret += displayGrid();
		return ret;
	}
	
	/**
	 * This method return a displayable String of the grid
	 * @return the grid
	 */
	public String displayGrid(){
		String ret = "";
		
		for(int y = height-1; y >= 0; y--){
			ret += Color.bBLACK + (y+1);
			for(int x = 0; x < width; x++){
				ret += (" | ");
				if(grid[x][y] == null){
					ret += "  ";
				}else{
					if(grid[x][y].getColor()){
						ret += Color.cRED + "O" + Color.cfin + Color.bBLACK;
					}else{
						ret += Color.cBLUE + "X" + Color.cfin + Color.bBLACK;
					}
					ret += Color.bBLACK + grid[x][y].getValue();
				}
			}
			ret += " |" + Color.cfin + "\n";
		}
		
		ret += Color.bBLACK + "  |";
		
		for(int i = 1; i <= width; i++){
			if(i < 10){
				ret += " " + i + " ";
			}else{
				ret += i;
			}
			ret += " |";
		}
		
		ret += Color.cfin + "\n";
		return ret;
	}
	
	/**
	 * This method return the Piece at coordonate [x][y]
	 * @param x the x coordonate
	 * @param y the y coordonate
	 * @return the Piece
	 */
	public Piece getPiece(int x, int y){
		Piece ret = null;
		
		if(x > -1 && y > -1 && x < width && y < height){
			ret = this.grid[x][y];
		}
		
		return ret;
	}
}
