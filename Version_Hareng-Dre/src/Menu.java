package arcanor;
import javax.swing.*;
import java.awt.*;


/**
 * This abstract class allow you to create fast menu
 */
public abstract class Menu extends JPanel{

	/**
	 * Menu's title
	 */
	protected String title;
	/**
	 * The constructor
	 * @param title the title to print
	 */
	public Menu(String title){ 
		this.setOpaque(false);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.title=title;
		JComponent[] comps = {new JLabel(new ImageIcon("../images/" + title + ".png"))};
		addComp(comps);
	}
	
	/**
     * The method that get wich Menu to display
     * @param comps the panel that contain the Menu
     */
	public void addComp(JComponent[] comps){
		JPanel pan = new JPanel();
		pan.setOpaque(false);
		for(int i=0;i<comps.length;i++){
			pan.add(comps[i]);
		}
		this.add(pan);
	}
}
