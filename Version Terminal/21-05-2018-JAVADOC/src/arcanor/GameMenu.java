package arcanor;
import java.util.ArrayList;
import System.out;

/**
 * Cette classe est le menu permettant de rediriger vers les pages de lancement de parties
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
	 * Fonction menant vers StartMenu
	 */
	public void startPlay(){}

	/**
	 * Fonction menant vers LoadMenu
	 */
	public void loadMenu(){}

	/**
	 * Fonction d'affichage
	 */
	public void display(){}

	/**
	 * Fonction de retour arrière du menu
	 */
	public void back(){}

}
