package arcanor;
import java.util.ArrayList;
import java.io.*;
import javax.swing.*;
import java.awt.*;

/**
 * This class represent the menu that redirect to launcher menu, New Game or Load Game
 */
public class GameMenu extends Menu{
	final static String STARTMENU = "New Game";
	final static String LOADMENU = "Load Menu";
	final static String QUIT = "Quit";
    public Font font = new Font("Dialog", Font.BOLD, 20);

	/**
	 * The constructor
	 * @param panel the panel where the game Menu is displayed
	 */
	public GameMenu(JPanel panel){
		super("mainmenu");
		ButtonMenu start = new ButtonMenu("New Game",STARTMENU);
		start.setBackground(Color.DARK_GRAY);
		start.setForeground(Color.ORANGE);
		start.setFont(font);
		start.setPreferredSize(new Dimension(230, 60));
		
		ButtonMenu load = new ButtonMenu("Load Game",LOADMENU);
		load.setFont(font);
		load.setBackground(Color.DARK_GRAY);
		load.setForeground(Color.ORANGE);
		load.setPreferredSize(new Dimension(230, 60));
		
		ButtonMenu quit = new ButtonMenu("Quit",QUIT);
		quit.setFont(font);
		quit.setBackground(Color.DARK_GRAY);
		quit.setForeground(Color.ORANGE);
		quit.setPreferredSize(new Dimension(230, 60));
		
		JComponent[] comps= {start};
		addComp(comps);
		comps=new JComponent[]{load};
		addComp(comps);
		comps=new JComponent[]{quit};
		addComp(comps);
		load.addMouseListener(new MenuListener(load,panel));
		start.addMouseListener(new MenuListener(start,panel));
		quit.addMouseListener(new MenuListener(quit,panel));
		
   	}
}
