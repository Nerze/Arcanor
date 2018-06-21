package arcanor;
public class AIPlayer extends Player{
	
	public AIPlayer(String name, boolean color, Board board){
		super(name,color, board);
	}
	
	
	public void playTurn(int numTour){
		System.out.println(numTour);
		System.out.println("AI turn");
	}
}
