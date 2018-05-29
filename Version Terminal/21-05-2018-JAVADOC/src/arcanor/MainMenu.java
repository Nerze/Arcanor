package arcanor;

import java.util.Scanner;

/**
 * Cette classe est le menu principal du jeu
 */
public class MainMenu extends Menu{
	
	/**
	 * Fonction menant vers GameMenu
	 */
	public void lauchGame(){
		nouvMenu = new ScoreMenu();
		
	}

	/**
	 * Fonction menant vers ScoreMenu
	 */
	public void scoreMenu(){
		ScoreMenu nouvMenu = new ScoreMenu();
	}

	/**
     * Fonction d'affichage
     */
    public void display(){
		Runtime.getRuntime().exec("clear");
		System.out.println("==== Arcanor ====");
		System.out.println("=== 1. Start Game ===");
		System.out.println("=== 2. Scores ===");
		System.out.println("=== Other. Quitter le jeu ===");
		
	    Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		while (i > 3 || i < 0) {}
		
		if (i == 1) {
			gameMenu();
			
		} if (i == 2) {
			
			scoreMenu();
			
		}
	    else {
			back();
		}
		
	}

    /**
	 * Fonction de retour arrière du menu
	 */
    public void back(){
		
		
		
	}

}
