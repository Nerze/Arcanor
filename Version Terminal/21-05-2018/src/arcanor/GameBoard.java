package arcanor;
import java.util.ArrayList;
import System.out;

public class GameBoard{

   private int turn;
   private ParamMenu gameParams;
   private ArrayList<Player> playerList;
   private Piece[][] board;

   public GameBoard(ParamMenu params, ArrayList<Player> list){
	   if(params==null){
		   println("GameBoard() ERROR : params is null");
		   params= new ParamMenu();
	   }
	   if(list==null){
		   println("GameBoard() ERROR : list is null");
		   list=new ArrayList<Player>();
		   list.add(new Player(true,"Player"));
		   list.add(new Player(false,"AI"));
	   }
   }
   public void save(){}
   public int getTurn(){return this.turn;}
   public void setTurn(int turn){
		if(turn>0){
			this.turn=turn;
		}
		else{
			println("setTurn() ERROR : turn invalid");
		}
   }
   public void play(){}
   public void display(){
	   println("Turn "+this.turn);
	   for(int i=0;i<this.board[0].length;i++){
		   for(int j=0;j<this.board.length;j++){
			   print(this.board[j][i].toString());
		   }
		   print("\n");
	   }
   }

}
