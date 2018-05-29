package arcanor;

/**
 * Cette classe abstraite sert de modèle au autres menus
 */
public abstract class Menu{

	/**
	 * titre du menu
	 */
	private String title;

	/**
	 * Le constructeur
	 * @param title titre a afficher
	 */
	public Menu(String title){
		this.title=title;
	}
	
	/**
	 * Fonction d'affichage
	 */
	public abstract void display();

	/**
	 * Fonction de retour arrière du menu
	 */
	public abstract void back();

}
