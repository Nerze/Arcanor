package arcanor;
import java.util.ArrayList;

public class GameBoard{

   private int turn;
   private ParamMenu gameParams;
   private ArrayList<Player> playerList;
   private Piece[][] board;

   public GameBoard(ParamMenu params, ArrayList<Player> list){
	   if(params==null){
		   System.out.println("GameBoard() ERROR : params is null");
		   params= new ParamMenu();
	   }
	   if(list==null){
		   System.out.println("GameBoard() ERROR : list is null");
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
			System.out.println("setTurn() ERROR : turn invalid");
		}
   }
   public void play(){}
   public void display(){
	   System.out.println("Turn "+this.turn);
	   for(int i=0;i<this.board[0].length;i++){
		   for(int j=0;j<this.board.length;j++){
			   System.out.print(this.board[j][i].toString());
		   }
		   System.out.print("\n");
	   }
   }

}
