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
    final static String BOARD = "Board";
    private JPanel board;
    public Font font = new Font("Dialog", Font.BOLD, 20);

	/**
	 * Settings's table
	 */
	private ParamMenu startParams;

	/**
	 * The constructor
	 * @param nbJoueurs Number of Human's Player
	 */
	public StartMenu(JPanel panel, ParamMenu startParams, SaveMenu sav){
		super("startmenu");
		this.startParams = startParams;
		ButtonMenu gameboard = new ButtonMenu("Start New Game",GAMEBOARD);
		gameboard.setFont(font);
		gameboard.setBackground(Color.DARK_GRAY);
		gameboard.setForeground(Color.ORANGE);
		gameboard.setPreferredSize(new Dimension(230, 60));
		
		ButtonMenu param = new ButtonMenu("Parameters",PARAMMENU);
		param.setFont(font);
		param.setBackground(Color.DARK_GRAY);
		param.setForeground(Color.ORANGE);
		param.setPreferredSize(new Dimension(230, 60));
		
		ButtonMenu back = new ButtonMenu("Back",GAMEMENU);
		back.setFont(font);
		back.setBackground(Color.DARK_GRAY);
		back.setForeground(Color.ORANGE);
		back.setPreferredSize(new Dimension(230, 60));
		
		JComponent[] comps= {gameboard};
		addComp(comps);
		comps=new JComponent[]{param};
		addComp(comps);
		comps=new JComponent[]{back};
		addComp(comps);
		gameboard.addMouseListener(new GameListener(startParams,panel, sav));
		param.addMouseListener(new MenuListener(param,panel));
		back.addMouseListener(new MenuListener(back,panel));
		this.board=board;
		
   	}
	
	
	/**
	 * Getter of startParams
	 * @return Settings's table
	 */
	public ParamMenu getStartParams(){ return this.startParams; }
}
