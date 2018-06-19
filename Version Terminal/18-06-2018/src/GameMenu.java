package arcanor;
import java.util.ArrayList;

/**
 * This class represent the menu that redirect to launcher menu, New Game or Load Game
 */
public class GameMenu extends Menu{
	
	/**
	 * The constructor
	 */
	public GameMenu(){
		super("Game Menu");
		this.display();
   	}
	
	/**
	 * Method that redirect to StartMenu
	 */
	public void startMenu(){
		StartMenu sm = new StartMenu();
	}

	/**
	 * Method that redirect to LoadMenu
	 */
	public void loadMenu(){
		LoadMenu lm = new LoadMenu();
	}

	/**
	* Printing method
	*/
	public void display(){
		try{
			int in=0;
			Scanner sc = new Scanner(System.in);
			boolean valid=false;
			while(!valid){
				Runtime.getRuntime().exec("clear");
				System.out.println("==== Play Menu ====");
				System.out.println("= 1. New Game");
				System.out.println("= 2. Load Game");
				System.out.println("= 0. Back");
				in = sc.nextInt();
				if(in>=0 && in <=2){
					valid=true;
				}
			}
			switch(in){
				case 1 :
					this.startMenu();
					break;
				case 2 :
					this.loadMenu();
					break;
			}
		}
		catch(IOException io){
		}
	}
}
