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
		JComponent[] comps = {new JLabel(title)};
		addComp(comps);
		//~ Image background = Toolkit.getDefaultToolkit().createImage("../images/wallpaper.png");
		//~ this.drawImage(background, 0, 0, null);
	}
	
	public void addComp(JComponent[] comps){
		JPanel pan = new JPanel();
		pan.setOpaque(false);
		for(int i=0;i<comps.length;i++){
			pan.add(comps[i]);
		}
		this.add(pan);
	}
}
