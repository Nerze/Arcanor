package arcanor;
import System.out.*;
import java.util.Scanner;

/**
 * This class represent the main menu
 */
public class MainMenu extends Menu{
	
	/**
	 * Method that redirect to GameMenu
	 */
	public void lauchGame(){
		GameMenu gm = new GameMenu();
	}

	/**
	 * Method that redirect to ScoreMenu
	 */
	public void scoreMenu(){
		ScoreMenu sm = new ScoreMenu();
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
				System.out.println("==== Arcanor V0.1 ====");
				System.out.println("= 1. Play");
				System.out.println("= 2. Scores");
				System.out.println("= 0. Quit");
				in = sc.nextInt();
				if(in>=0 && in <=2){
					valid=true;
				}
			}
			switch(in){
				case 1 :
					this.launchGame();
					break;
				case 2 :
					this.scoreMenu();
					break;
			}
		}
		catch(IOException io){
		}
	}
}
