package arcanor;

/**
 * Cette classe est le menu qui permet d'afficher les scores
 */
public class ScoreMenu extends Menu{

	/**
	 * le tableau contenant le nom des joueurs
	 */
	private Player[] playerList;

	/**
	 * le tableau contenant le score de chaque joueurs
	 */
	private int[] tabScores[];

	/**
	 * Le constructeur
	 */
   public ScoreMenu(){}

	/**
	 * Fonction permettant de charger depuis les fichiers
	 */
	public void loadScores(){}

	/**
	 * Getter de playerList
	 * @return le tableau des joueurs
	 */
	public Player[] getPlayerList(){}

	/**
	 * Getter de tabScores
	 * @return le tableau des scores
	 */
	public int[] getTabScores(){}

	/**
	 * Setter de tabScores
	 * @param tabScores le tableau des scores
	 */
	public void setTabScores(int[] tabScores){}

	/**
	 * Fonction d'affichage
	 */
	public void display(){}

	/**
	 * Fonction de retour arrière du menu
	 */
	public void back(){}

}
