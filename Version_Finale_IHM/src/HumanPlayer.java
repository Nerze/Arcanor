package arcanor;
import java.util.Scanner;
public class HumanPlayer extends Player{
	
	public HumanPlayer(String name, boolean color, Board board){
		super(name, color, board);
	}
	
	
	public boolean playTurn(){
		return false;
	}
}
