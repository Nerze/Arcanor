package arcanor;

import javax.swing.*;
import java.awt.*;

/**
 * This class represent the settings menu
 */
public class ParamMenu extends Menu{

	/**
	 * Coded settings into a table
	 * tab[0] - (HEIGHT) Vertical dimension of GameBoard
	 * tab[1] - (WIDTH) Horizontal dimension of GameBoard
	 * tab[2] - Number of Human Player
	 * tab[3] - Player 1 name
	 * tab[4] - Player 2 name
	 * tab[5] - Number of points to win the game
	 */
	private String[] tabParams;
    final static String STARTMENU = "New Game";
    public Font font = new Font("Dialog", Font.BOLD, 20);

	/**
	 * The constructor of ParamMenu
	 * @param panel the panel where ParamMenu is displayed
	 */
	public ParamMenu(JPanel panel){
		super("parameters");
		this.tabParams = new String[6];
		this.tabParams[0] = "7";
		this.tabParams[1] = "3";
		this.tabParams[2] = "1";
		this.tabParams[3] = "Black";
		this.tabParams[4] = "White";
		this.tabParams[5] = "12";
		//Create the JPanels
		//The back button
		ButtonMenu back = new ButtonMenu("Back",STARTMENU);
		back.setFont(font);
		back.setBackground(Color.DARK_GRAY);
		back.setForeground(Color.ORANGE);
		back.setPreferredSize(new Dimension(230, 60));
		
		//Height of the board
		JLabel heightInf = new JLabel("Height :");
		heightInf.setFont(font);
		heightInf.setForeground(Color.DARK_GRAY);
		ParamBouton minusHeight= new ParamBouton("-",-1,3);
		minusHeight.setFont(font);
		minusHeight.setBackground(Color.DARK_GRAY);
		minusHeight.setForeground(Color.ORANGE);
		JLabel heightVal = new JLabel(tabParams[0]);
		heightVal.setFont(font);
		heightVal.setForeground(Color.DARK_GRAY);
		ParamBouton plusHeight= new ParamBouton("+",1,3);
		plusHeight.setFont(font);
		plusHeight.setBackground(Color.DARK_GRAY);
		plusHeight.setForeground(Color.ORANGE);

		//Width of the board
		JLabel widthInf = new JLabel("Width Factor :");
		widthInf.setFont(font);
		widthInf.setForeground(Color.DARK_GRAY);
		ParamBouton minusWidth= new ParamBouton("-",-1,1);
		minusWidth.setFont(font);
		minusWidth.setBackground(Color.DARK_GRAY);
		minusWidth.setForeground(Color.ORANGE);
		JLabel widthVal = new JLabel(tabParams[1]);
		widthVal.setFont(font);
		widthVal.setForeground(Color.DARK_GRAY);
		ParamBouton plusWidth= new ParamBouton("+",1,1);
		plusWidth.setFont(font);
		plusWidth.setBackground(Color.DARK_GRAY);
		plusWidth.setForeground(Color.ORANGE);

		//Score parameter
		JLabel scoreInf = new JLabel("Score limit :");
		scoreInf.setFont(font);
		scoreInf.setForeground(Color.DARK_GRAY);
		ParamBouton minusScore= new ParamBouton("-",-1,1);
		minusScore.setFont(font);
		minusScore.setBackground(Color.DARK_GRAY);
		minusScore.setForeground(Color.ORANGE);
		JLabel scoreVal = new JLabel(tabParams[5]);
		scoreVal.setFont(font);
		scoreVal.setForeground(Color.DARK_GRAY);
		ParamBouton plusScore= new ParamBouton("+",1,1);
		plusScore.setFont(font);
		plusScore.setBackground(Color.DARK_GRAY);
		plusScore.setForeground(Color.ORANGE);

		//Number of human players
		JLabel nbPlayerInf = new JLabel("Number of human players :");
		nbPlayerInf.setFont(font);
		nbPlayerInf.setForeground(Color.DARK_GRAY);
		String[] nbPlayerList = {"0", "1", "2"};

		//Create the combo box, for the number of human player
		JComboBox nbPlayerVal = new JComboBox(nbPlayerList);
		nbPlayerVal.setSelectedIndex(1);
		nbPlayerVal.setFont(font);
		nbPlayerVal.setBackground(Color.DARK_GRAY);
		nbPlayerVal.setForeground(Color.ORANGE);
		nbPlayerVal.setPreferredSize(new Dimension(230, 60));
		
		//Player 1 name
		JLabel play1NameInf = new JLabel("Player 1 name : ");
		play1NameInf.setFont(font);
		play1NameInf.setForeground(Color.DARK_GRAY);
		JTextField play1NameVal = new JTextField(tabParams[3],20);
		play1NameVal.setFont(font);
		play1NameVal.setBackground(Color.DARK_GRAY);
		play1NameVal.setForeground(Color.ORANGE);
		play1NameVal.setPreferredSize(new Dimension(230, 60));
		
		//Player 2 name
		JLabel play2NameInf = new JLabel("Player 2 name : ");
		play2NameInf.setFont(font);
		play2NameInf.setForeground(Color.DARK_GRAY);
		JTextField play2NameVal = new JTextField(tabParams[4],20);
		play2NameVal.setFont(font);
		play2NameVal.setBackground(Color.DARK_GRAY);
		play2NameVal.setForeground(Color.ORANGE);
		play2NameVal.setPreferredSize(new Dimension(230, 60));
		
		//adds the components to the panel
		JComponent[] comps= {heightInf, minusHeight, heightVal, plusHeight};
		addComp(comps);
		comps=new JComponent[]{widthInf, minusWidth, widthVal, plusWidth};
		addComp(comps);
		comps=new JComponent[]{scoreInf, minusScore, scoreVal, plusScore};
		addComp(comps);
		comps=new JComponent[]{nbPlayerInf, nbPlayerVal};
		addComp(comps);
		comps = new JComponent[]{play1NameInf, play1NameVal};
		addComp(comps);
		comps = new JComponent[]{play2NameInf, play2NameVal};
		addComp(comps);
		
		//adds the listeners
		back.addMouseListener(new MenuListener(back,panel));
		
		minusHeight.addMouseListener(new ParamButtonListener(minusHeight,tabParams,0,heightVal));
		plusHeight.addMouseListener(new ParamButtonListener(plusHeight,tabParams,0,heightVal));
		
		minusWidth.addMouseListener(new ParamButtonListener(minusWidth,tabParams,1,widthVal));
		plusWidth.addMouseListener(new ParamButtonListener(plusWidth,tabParams,1,widthVal));
		
		minusScore.addMouseListener(new ParamButtonListener(minusScore,tabParams,5,scoreVal));
		plusScore.addMouseListener(new ParamButtonListener(plusScore,tabParams,5,scoreVal));
		
		play1NameVal.addFocusListener(new TextFieldParamListener(play1NameVal,tabParams,3));
		play2NameVal.addFocusListener(new TextFieldParamListener(play2NameVal,tabParams,4));
		
		nbPlayerVal.addItemListener(new nbHumanListener(nbPlayerVal,tabParams,2));
		
		comps=new JComponent[]{back};
		addComp(comps);
		
	}

	/**
	 * Getter of tabParams
	 * @return settings table
	 */
    public String[] getTabParams(){
		return this.tabParams;
	}

    /**
     * Setter de tabParams
     * @param tabParams le tableau de paramètres
     */
    public void setTabParams(String[] newTab){
	    if (newTab.length >= tabParams.length){
			this.tabParams = newTab;
		}else{
			System.err.println("ERROR - setTabParams() : newTab.legnth < tabParams.length");
		}
	}
}
