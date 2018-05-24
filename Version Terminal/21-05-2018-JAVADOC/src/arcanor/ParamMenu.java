package arcanor;

import java.util.Scanner;

/**
 * Cette classe est le menu permettant de modifier les paramètres de la partie
 */
public class ParamMenu extends Menu{

	/**
     * tableau de paramètres codés
     * 1er emplacement difficulté
     * 2ème emplacement nb joueur
     */
    private String[] tabParams;

    /**
     * Le contructeur
     */
    public ParamMenu(){
	
		this.tabParams = ["0", "0"]
	   
	}

    /**
     * Getter de tabParams
     * @return le tableau de paramètres
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

    public void setDifficulte(int niveau){
		
		this.tabParams[0] = "1";
		
	}
    
    /**
     * Fonction d'affichage
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
     * Fonction de retour arrière du menu
     */
    public void back(){
		
		Runtime.getRuntime().exec("clear");
		
	}
      
}
