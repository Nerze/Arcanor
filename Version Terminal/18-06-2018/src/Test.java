import arcanor.*;
public class Test{
	public static void main(String[] args){
		for(int i=0;i<11;i++){
			Board board=new Board(i,i*3,1);
			board.movePiece(0,0,1,1,true,true);
			System.out.println(board.displayGrid());
		}
	}
}
