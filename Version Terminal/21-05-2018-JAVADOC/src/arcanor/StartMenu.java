package arcanor;
import java.util.Scanner;

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
	 * @param nbJoueurs Number of Human's Player
	 */
	public StartMenu(int nbJoueurs){
		super("Nouvelle Partie");
		this.startParams= new ParamMenu();
		}
	
	public void display(){
		int in=0;
		boolean valid=false;
		while(!valid){
			System.out.println("Nouvelle Partie");
			System.out.println("1-Parametres");
			System.out.println("2-Commencer");
			System.out.println("0- Retour");
			Scanner sc = new Scanner(System.in);
			in= sc.nextInt();
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
	}

	/**
	 * Getter of startParams
	 * @return Settings's table
	 */
   public ParamMenu getStartParams(){ return this.startParams;}

}
