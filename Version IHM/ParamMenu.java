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

	/**
	 * The constructor
	 */
	public ParamMenu(JPanel panel){
		super("Parameters");
		this.tabParams = new String[6];
		this.tabParams[0] = "7";
		this.tabParams[1] = "3";
		this.tabParams[2] = "1";
		this.tabParams[3] = "Red";
		this.tabParams[4] = "Blue";
		this.tabParams[5] = "12";
		//Create the JPanels
		//The back button
		ButtonMenu back = new ButtonMenu("Back",STARTMENU);
		
		//Height of the board
		JLabel heightInf = new JLabel("Height :");
		ParamBouton minusHeight= new ParamBouton("-",-1,3);
		JLabel heightVal = new JLabel(tabParams[0]);
		ParamBouton plusHeight= new ParamBouton("+",1,3);
		
		//Width of the board
		JLabel widthInf = new JLabel("Width Factor :");
		ParamBouton minusWidth= new ParamBouton("-",-1,1);
		JLabel widthVal = new JLabel(tabParams[1]);
		ParamBouton plusWidth= new ParamBouton("+",1,1);
		
		//Score parameter
		JLabel scoreInf = new JLabel("Score limit :");
		ParamBouton minusScore= new ParamBouton("-",-1,1);
		JLabel scoreVal = new JLabel(tabParams[5]);
		ParamBouton plusScore= new ParamBouton("+",1,1);
		
		//Number of human players
		JLabel nbPlayerInf = new JLabel("Number of human players :");
		
		String[] nbPlayerList = {"0", "1", "2"};

		//Create the combo box, for the number of human player
		JComboBox nbPlayerVal = new JComboBox(nbPlayerList);
		nbPlayerVal.setSelectedIndex(1);
		
		//Player 1 name
		JLabel play1NameInf = new JLabel("Player 1 name : ");
		JTextField play1NameVal = new JTextField(tabParams[3],20);
		
		//Player 2 name
		JLabel play2NameInf = new JLabel("Player 2 name : ");
		JTextField play2NameVal = new JTextField(tabParams[4],20);
		
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
