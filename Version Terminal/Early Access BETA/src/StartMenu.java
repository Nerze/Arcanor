package arcanor;
import java.util.Scanner;
import java.io.IOException;

/**
 * This class represent the menu that create a new game from void
 */
public class StartMenu extends Menu{

	/**
	 * Settings's table
	 */
	private ParamMenu startParams;

	/**
	 * The constructor
	 */
	public StartMenu(){
		super("New Game");
		this.startParams = new ParamMenu();
	}
	
	/**
	 * Printing method
	 */
	public void display(){
		try{
			Runtime.getRuntime().exec("clear");
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally{
			int in = 0;
			Scanner sc = new Scanner(System.in);
			boolean valid = false;
			
			while(!valid){
				System.out.println("==== New Game ====");
				System.out.println("= 1. Play");
				System.out.println("= 2. Settings");
				System.out.println("= 0. Back");
				in= sc.nextInt();
				if(in >= 0 && in <= 2){
					valid = true;
				}
			}
			
			switch(in){
				case 1 :
					Game game = new Game(startParams);
					game.start();
					break;
				case 2 :
					this.startParams.display();
					this.display();
					break;
			}
		}
	}

	/**
	 * Getter of startParams
	 * @return Settings's table
	 */
	public ParamMenu getStartParams(){ return this.startParams; }
}
