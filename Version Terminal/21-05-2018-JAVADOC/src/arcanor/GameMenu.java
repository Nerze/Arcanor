package arcanor;
import java.util.ArrayList;
import System.out;

/**
 * This class represent the menu that redirect to launcher menu, New Game or Load Game
 */
public class GameMenu extends Menu{
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
	
	/**
	 * Method that redirect to StartMenu
	 */
	public void startPlay(){}

	/**
	 * Method that redirect to LoadMenu
	 */
	public void loadMenu(){}

	/**
	 * Printing method
	 */
	public void display(){
		println("===== ARCANOR =====");
		println("=== 1 : New game ===");
		println("=== 2 : Load Game ===");
		println("=== Other : Exit ===");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		if(i==1){
			startPlay();
		}
		else if(i==2){
			loadMenu();
		}	
    	 }

	/**
	 * Method that get back to the previous menu
	 */
	public void back(){}

}
