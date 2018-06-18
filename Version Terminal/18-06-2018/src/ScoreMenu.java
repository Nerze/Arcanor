package arcanor;
import System.out.*;

/**
 * This class represent the menu that show Scores to the user
 */
public class ScoreMenu extends Menu{

	/**
	 * The table that contain Player's name
	 */
	private Player[] playerList;

	/**
	 * The table that contain Player's scores
	 */
	private int[] tabScores[];

	/**
	 * The constructor
	 */
	public ScoreMenu(){}

	/**
	 * Method that load scores from an external file
	 */
	public void loadScores(){}

	/**
	 * Getter of playerList
	 * @return Players's table
	 */
	public Player[] getPlayerList(){}

	/**
	 * Getter of tabScores
	 * @return Scores's table
	 */
	public int[] getTabScores(){}

	/**
	 * Setter of tabScores
	 * @param tabScores the new table
	 */
	public void setTabScores(int[] tabScores){}

	/**
	 * Printing method
	 */
	public void display(){}

	/**
	 * Method to get back to the previous menu
	 */
	public void back(){}

}
