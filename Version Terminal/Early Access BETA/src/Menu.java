package arcanor;

/**
 * This abstract class allow you to create fast menu
 */
public abstract class Menu{

	/**
	 * Menu's title
	 */
	private String title;

	/**
	 * The constructor
	 * @param title the title to print
	 */
	public Menu(String title){ this.title = title; }
	
	/**
	 * Printing method
	 */
	public abstract void display();

}
