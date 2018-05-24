package arcanor;

/**
 * Cette classe est le menu principal du jeu
 */
public class MainMenu extends Menu{
	
	/**
	 * Fonction menant vers GameMenu
	 */
	public void lauchGame(){
		
		Runtime.getRuntime().exec("clear");
		nouvMenu = new ScoreMenu();
		
	}

	/**
	 * Fonction menant vers ScoreMenu
	 */
	public void scoreMenu(){
		
		Runtime.getRuntime().exec("clear");
		ScoreMenu nouvMenu = new ScoreMenu();
		
	}

	/**
     * Fonction d'affichage
     */
    public void display(){
		
		System.out.println("1. Lancer le jeu");
		System.out.println("2. Menu des Scores");
		System.out.println("3. Quitter le jeu");
		
		int i = System.in;
		while (i > 3 || i < 0) {}
		
		if (i == 3) {
			
			back();
			
		} if (i == 2) {
			
			scoreMenu();
			
		} if (i == 3) {
			
			gameMenu();
			
		}
		
	}

    /**
	 * Fonction de retour arrière du menu
	 */
    public void back(){
		
		
		
	}

}
