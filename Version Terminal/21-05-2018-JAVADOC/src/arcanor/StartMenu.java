package arcanor;
import java.util.Scanner;

/**
 * This class represent the menu that create a new game from void
 */
public class StartMenu extends Menu{

	/**
	 * Number of Human's Player
	 */
	private int playerNb;

	/**
	 * Settings's table
	 */
	private ParamMenu startParams;

	/**
	 * The constructor
	 * @param nbJoueurs Number of Human's Player
	 */
	public StartMenu(int nbJoueurs){
		this.startParams= new ParamMenu();
		}

	/**
	 * Getter of playerNb
	 * @return Number of Human's Player
	 */
	public int getPlayerNb(){}
	
	public boolean display(){
		boolean valid=false;
			while(!valid){
			System.out.println("Nouvelle Partie");
			System.out.println("1-Parametres");
			System.out.println("2-Commencer");
			System.out.println("0- Retour");
			Scanner scan = new Scanner(System.in);
			int in= Scanner.nextInt();
			if(in>=0 && in <=2){
				valid=true;
			}
		}
		boolean ret=false;
		switch(in){
			case 1 :
				this.startParams.display();
				this.display();
				break;
			case 2 :
				Game game= new Game(startParams);
				ret = game.start();
				if(!ret){
					this.display();
				}
				break;
		}
		return ret;
	}
		

	/**
	 * Setter of playerNb
	 * @param playerNb the new number
	 */
	public void setPlayerNb(int playerNb){}

	/**
	 * Setter of nomJoueurs
	 * @param nomJoueurs the new Players's name table
	 */
	public void setNomJoueurs(String[] nomJoueurs){}

	/**
	 * Getter of startParams
	 * @return Settings's table
	 */
   public ParamMenu getStartParams(){}

}
