package arcanor;
public class Board{
	int width, height;
	private final int DEFAULT_HEIGHT = 7;
	private final int DEFAULT_WIDTH = 8;
	Piece[][] grid;
	public Board(int width, int height){
		if(width<1){
			width=DEFAULT_WIDTH;
		}
		if(height<1){
			height=DEFAULT_HEIGHT;
		}
		this.width=width;
		this.height=height;
		grid = new Piece[width][height];
	}
	
	public int checkWin(){
		int ret=0;
		int player1Points=0;
		int player2Points=0;
		for(int i=0; i<this.width;i++){
			if(this.grid[i][height-1]!=null){
				if(this.grid[i][height-1].getColor()){
					player1Points+=this.grid[i][height-1].getValue();
				}
			}
			if(this.grid[i][0]!=null){
				if(!this.grid[i][0].getColor()){
					player2Points+=this.grid[i][0].getValue();
				}
			}
		}
		if(player1Points>=12){
			ret=1;
		}
		else if(player2Points>=12){
			ret=-1;
		}
		return ret;
			
	}
	
	
	public boolean movePiece(int xOr,int yOr, int xDest, int yDest, boolean colorPlayer){
		boolean ret=false;
		if(xOr-xDest<=1 && xDest-xOr<=1 && yOr-yDest<=1 && yDest-yOr<=1 && yDest<this.height && yDest>=0 && yOr<this.height && yOr>=0 && xDest<this.width && xDest>=0 && xOr<this.width && xOr>=0){
			if(this.grid[xOr][yOr]!=null){
				if(this.grid[xOr][yOr].color==colorPlayer){//The player tries to move its own piece
					if(this.grid[xDest][yDest]==null){//There is no piece at the destination
						this.grid[xDest][yDest]=this.grid[xOr][yOr];
						this.grid[xOr][yOr]=null;
						ret=true;
					}
					else{//There is a piece at the destination
						if(this.grid[xDest][yDest].getValue()==this.grid[xOr][yOr].getValue()-1 && this.grid[xDest][yDest].getColor()!=this.grid[xOr][yOr].getColor()){
							//If you can eat the piece
							Piece or = this.grid[xOr][yOr];
							this.grid[xOr][yOr]=or.getContain();//The inside of the moving piece is the new piece on this spot
							or.setContain(this.grid[xDest][yDest]);//put the piece in the bigger one
							this.grid[xDest][yDest]=or;//Move it to the destination
							ret=true;
						}
					}
				}
			}
		}
		return ret;
	}
	
	public int getHeight(){return height;}
	public int getWidth(){return width;}
	
	public String toString(){
		String ret= "Width : "+width+"\n";
		ret+="Height : "+height+"\n";
		ret+="Grid : \n";
		ret+=displayGrid();
		return ret;
	}
	
	public String displayGrid(){
		String ret="";
		for(int y=height-1;y>=0;y--){
			for(int x=0;x<width;x++){
				ret+=("| ");
				if(grid[x][y]==null){
					ret+="  ";
				}
				else{
					if(grid[x][y].getColor()){
						ret+="O";
					}
					else{
						ret+="X";
					}
					ret+=+grid[x][y].getValue();
				}
			}
			ret+=" |"+"\n";
		}
		return ret;
	}

}
