package arcanor;
import java.util.Scanner;
import java.io.IOException;

/**
 * This class represent the settings menu
 */
public class ParamMenu extends Menu{

	/**
	 * Coded settings into a table
	 * tab[0] - (HEIGHT) Vertical dimension of GameBoard
	 * tab[1] - (WIDTH) Horizontal dimension of GameBoard
	 * tab[2] - Number of Human Player
	 * tab[3] - Player 1 name
	 * tab[4] - Player 2 name
	 * tab[5] - Number of points to win the game
	 */
	private String[] tabParams;

	/**
	 * The constructor
	 */
	public ParamMenu(){
		super("Parameters");
		this.tabParams = new String[6];
		this.tabParams[0] = "7";
		this.tabParams[1] = "3";
		this.tabParams[2] = "1";
		this.tabParams[3] = "Red";
		this.tabParams[4] = "Blue";
		this.tabParams[5] = "12";
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
	    if (newTab.length >= tabParams.length){
			this.tabParams = newTab;
		}else{
			System.err.println("ERROR - setTabParams() : newTab.legnth < tabParams.length");
		}
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
				System.out.println("==== Parameters ====");
				System.out.println("= 1. Change Board dimensions");
				System.out.println("= 2. Change Player's number");
				System.out.println("= 3. Change Players name");
				System.out.println("= 4. Change The number of points to win");
				System.out.println("= 0. Back");
				in = sc.nextInt();
				if(in>=0 && in <=4){
					valid=true;
				}
			}
			switch(in){
				case 1 :
					this.modifDims();
					break;
				case 2 :
					this.modifPlayNb();
					break;
				case 3 :
					this.modifName();
					break;
				case 4 :
					this.modifPoints();
					break;
			}
			if(in!=0){
				this.display();
			}
		}
		catch(Exception io){
		}
	}
	
	
	public void modifDims(){
		Scanner sc = new Scanner(System.in);
		try{
			Runtime.getRuntime().exec("clear");
		}
		catch(IOException io){
		}
		finally{
			System.out.println("==== Parameters ====");
			System.out.println("= Set Width Factor : (3 by default)");
			int j = sc.nextInt();
			while (j <= 0) {
				System.err.println("Humm. It seems to be a number under 1, try with a higher one.");
				j = sc.nextInt();
			}
			this.tabParams[0] = Integer.toString(j);

			System.out.println("= Set Height : (7 by default)");
			j = sc.nextInt();
			while (j <= 2) {
				System.err.println("Humm. It seems to be a number under 3, try with a higher one.");
				j = sc.nextInt();
			}
			this.tabParams[1] = Integer.toString(j);
		}
	}
	
	public void modifPlayNb(){
		Scanner sc = new Scanner(System.in);
		try{
			Runtime.getRuntime().exec("clear");
		}
		catch(IOException io){
		}
		finally{
			System.out.println("==== Parameters ====");
			System.out.println("= Set number of human players :");
		
			int j = sc.nextInt();
			while ((j < 0) && (j > 2)) {
				System.err.println("Humm. You can't play with this number of human players.");
				j = sc.nextInt();
			}
			this.tabParams[2] = Integer.toString(j);
		}
	}
	
	public void modifName(){
		Scanner sc = new Scanner(System.in);
		try{
			Runtime.getRuntime().exec("clear");
		}
		catch(IOException io){
		}
		finally{
			System.out.println("==== Parameters ====");
			System.out.println("= Set Player 1 name :");
			this.tabParams[3] = sc.nextLine();
			System.out.println("= Set Player 2 name :");
			this.tabParams[4] = sc.nextLine();
		}
	}
	
	public void modifPoints(){
		Scanner sc = new Scanner(System.in);
		try{
			Runtime.getRuntime().exec("clear");
		}
		catch(IOException io){
		}
		finally{
			System.out.println("==== Parameters ====");
			System.out.println("= Set number of human players :");
		
			int j = sc.nextInt();
			while ((j < 1)) {
				System.err.println("Humm. You can't play with this number of points.");
				j = sc.nextInt();
			}
			this.tabParams[5] = Integer.toString(j);
		}
	}

	//~ /**
	 //~ * Method to get back to the previous menu
	 //~ */
	//~ public void back(){
		//~ this.return;
	//~ }
}
