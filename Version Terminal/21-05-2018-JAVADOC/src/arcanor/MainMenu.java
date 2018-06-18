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
		nouvMenu = new ScoreMenu();
	}

	/**
	 * Method that redirect to ScoreMenu
	 */
	public void scoreMenu(){
		ScoreMenu nouvMenu = new ScoreMenu();
	}

	/**
    	 * Printing method
    	 */
	public void display(){
		Runtime.getRuntime().exec("clear");
		System.out.println("==== Arcanor V0.1 ====");
		System.out.println("=== 1. Start Game ===");
		System.out.println("=== 2. Scores ===");
		System.out.println("=== Other. Quitter le jeu ===");
	
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		while (i > 2 || i < 0) {
			if (i == 1) {
				gameMenu();
			}else if (i == 2) {
				scoreMenu();
			}else {
				back();
			}
		}
	}

    /**
     * Method to get back to the previous menu
     */
    public void back(){
		System.exit(0);
    }
}
