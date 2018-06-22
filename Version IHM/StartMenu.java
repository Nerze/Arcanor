package arcanor;

import javax.swing.*;
import java.awt.*;

/**
 * This class represent the menu that create a new game from void
 */
public class StartMenu extends Menu{
    final static String GAMEBOARD = "Gameboard";
    final static String GAMEMENU = "Main Menu";
    final static String PARAMMENU = "Parameters";
    
	/**
	 * Settings's table
	 */
	private ParamMenu startParams;

	/**
	 * The constructor
	 * @param nbJoueurs Number of Human's Player
	 */
	public StartMenu(JPanel panel){
		super("Start Menu");
		ButtonMenu gameboard = new ButtonMenu("Start New Game",GAMEBOARD);
		ButtonMenu param = new ButtonMenu("Parameters",PARAMMENU);
		ButtonMenu back = new ButtonMenu("Back",GAMEMENU);
		JComponent[] comps= {gameboard};
		addComp(comps);
		comps=new JComponent[]{param};
		addComp(comps);
		comps=new JComponent[]{back};
		addComp(comps);
		gameboard.addMouseListener(new MenuListener(gameboard,panel));
		param.addMouseListener(new MenuListener(param,panel));
		back.addMouseListener(new MenuListener(back,panel));
		
   	}
	
	
	/**
	 * Getter of startParams
	 * @return Settings's table
	 */
	public ParamMenu getStartParams(){ return this.startParams; }
}
