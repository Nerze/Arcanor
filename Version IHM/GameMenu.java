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
	/**
	 * The constructor
	 */
	public GameMenu(JPanel panel){
		super("Main Menu");
		ButtonMenu start = new ButtonMenu("New Game",STARTMENU);
		ButtonMenu load = new ButtonMenu("Load Game",LOADMENU);
		ButtonMenu quit = new ButtonMenu("Quit",QUIT);
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
