package arcanor;
import System.out;
import java.util.Scanner;

/**
 * This class represent the settings menu
 */
public class ParamMenu extends Menu{

	/**
	 * Coded settings into a table
	 * tab[0] - (WIDTH) Vertical dimension of GameBoard
	 * tab[1] - (HEIGHT) Horizontal dimension of GameBoard
	 * tab[2] - Number of Human Player
	 * tab[3] - Player 1 name
	 * tab[4] - Player 2 name
	 */
	private String[] tabParams;

	/**
	 * The constructor
	 */
	public ParamMenu(){
		this.tabParams = new String[5];
		this.tabParams[0] = "7";
		this.tabParams[1] = "8";
		this.tabParams[2] = "1";
		this.tabParams[3] = "Red";
		this.tabParams[4] = "Blue";
		this.display();
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
    public void setTabParams(String[] newTab){
	    if (newTab.length() == tabParams.length()){
			this.tabParams = tabParams;
		}else{
			System.err.println("ERROR - setTabParams - newTab.legnth() != tabParams.length()");
		}
	}
    
    /**
     * Printing method
     */
	public void display(){
		Scanner sc = new Scanner(System.in);

	   	Runtime.getRuntime().exec("clear");
		System.out.println("==== Arcanor V0.1 ====");
		System.out.println("= 1. Change Board dimensions");
		System.out.println("= 2. Change Player's number");
		System.out.println("= 3. Change Player 1 name");
		System.out.println("= 4. Change Player 2 name");
		System.out.println("= 0. Back");
		
		int i = sc.nextInt();
		while (i != 0) {
			if (i == 1) {
			   	Runtime.getRuntime().exec("clear");
				System.out.println("==== Arcanor V0.1 ====");
				System.out.println("= Set Width : (8 by default)");
				
				int j = sc.nextInt();
				while (j <= 0) {
					System.err.println("Humm. It seems to be a number under 0, try with a positive one.");
					j = sc.nextInt();
				}
				this.tabParams[0] = Integer.toString(j);

				System.out.println("= Set Height : (7 by default)");
				j = sc.nextInt();
				while (j <= 0) {
					System.err.println("Humm. It seems to be a number under 0, try with a positive one.");
					j = sc.nextInt();
				}
				this.tabParams[1] = Integer.toString(j);
			
			}else if (i == 2) {
				Runtime.getRuntime().exec("clear");
				System.out.println("==== Arcanor V0.1 ====");
				System.out.println("= Set number of players :");
			
				int j = sc.nextInt();
				while ((j < 0) && (j > 2)) {
					System.err.println("Humm. You can't play without at least 1 player and at last 2 players.");
					j = sc.nextInt();
				}
				this.tabParams[2] = Integer.toString(j);
			
			}else if (i == 3) {
				Runtime.getRuntime().exec("clear");
				System.out.println("==== Arcanor V0.1 ====");
				System.out.println("= Set Player 1 name :");
				this.tabParams[3] = sc.nextLine();
			
			}else if (i == 4) {
				Runtime.getRuntime().exec("clear");
				System.out.println("==== Arcanor V0.1 ====");
				System.out.println("= Set Player 2 name :");
				this.tabParams[4] = sc.nextLine();
			
			}else if (i == 0) {
				//~ this.back();
			
			}else{
				System.err.println("Humm. It seems like you wrote a wrong input. Try again please");
			}
		}
	}

	//~ /**
	 //~ * Method to get back to the previous menu
	 //~ */
	//~ public void back(){
		//~ this.return;
	//~ }
}
