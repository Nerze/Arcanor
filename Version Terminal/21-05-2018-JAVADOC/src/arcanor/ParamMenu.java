package arcanor;
import System.out.*;
import java.util.Scanner;

/**
 * This class represent the settings menu
 */
public class ParamMenu extends Menu{

	/**
	 * Coded settings into a table
	 * tab[0] - Vertical dimension of GameBoard
	 * tab[1] - Horizontal dimension of GameBoard
	 * tab[2] - Number of Human Player
	 * tab[3] - Player 1 name
	 * tab[4] - Player 2 name
	 */
	private String[] tabParams;

	/**
	 * The constructor
	 */
	public ParamMenu(){
		this.tabParams = ["0", "0"]
	}

	/**
	 * Getter of tabParams
	 * @return settings table
	 */
    public String[] getTabParams(){
		return this.tabParams;
	}

    /**
     * Setter de tabParams
     * @param tabParams le tableau de paramètres
     */
    public void setTabParams(String[] tabParams){
		this.tabParams = tabParams;
	}
    
    /**
     * Printing method
     */
	public void display(){
	   
		System.out.println("1. changer de difficulté (non accessible en version beta)");
		System.out.println("2. changer le nombre de joueur (non accessible en version beta)");
		System.out.println("3. Retour au menu de lancement");
		
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		while (i != 3) {}
		
		if (i = 3) {
			
			back();
			
		}
	   
	}

	/**
	 * Method to get back to the previous menu
	 */
	public void back(){
		Runtime.getRuntime().exec("clear");
	}
      
}
