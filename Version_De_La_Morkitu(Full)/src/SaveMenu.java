package arcanor;
import java.io.*;
import javax.swing.*;
import java.awt.*;

/**
 * This class represent the menu to load saved game
 */
public class SaveMenu extends Menu{
	private String[] saves;
	private JPanel cards;
	final static String GAMEBOARD = "Gameboard";
	public Font font = new Font("Dialog", Font.BOLD, 20);

   /**
    * The constructor SaveMenu
    * @param cards the panel where SaveMenu is displayed 
    */
   public SaveMenu(JPanel cards){
	   super("savemenu");
	   this.cards=cards;
   }
   
   /**
	* Create a new save
	* @param panel the panel where all save are display
	* @param game the instance of game currently running
	*/
   public void paintMe(JPanel panel, Game game){
	   try{
			saves = new String[6];
			FileReader fileR= new FileReader("saves.savebin");
			BufferedReader br = new BufferedReader(fileR);
			for(int i=0;i<6;i++){
				saves[i]="Save "+br.readLine();
				String date= br.readLine();
				if(date.equals("null")){
					saves[i]+=" : No save";
				}
				else{
					saves[i]+=" : "+date;
				}
			}
		}
		catch(Exception e){
		e.printStackTrace();
		}
		JLabel[] savesLabel= new JLabel[6];
		
		JButton[] savesButtons = new JButton[6];
		
		JComponent[][] components= new JComponent[6][2];
		
		for(int i=0;i<saves.length;i++){
			savesLabel[i]=new JLabel(saves[i]);
			savesLabel[i].setFont(font);
			savesLabel[i].setOpaque(true);
			savesLabel[i].setBackground(Color.DARK_GRAY);
			savesLabel[i].setForeground(Color.ORANGE);
			
			savesButtons[i] = new JButton("Save");
			savesButtons[i].setFont(font);
			savesButtons[i].setBackground(Color.DARK_GRAY);
			savesButtons[i].setForeground(Color.ORANGE);
			savesButtons[i].setPreferredSize(new Dimension(230, 60));
			
			components[i]=new JComponent[]{savesLabel[i],savesButtons[i]};
			addComp(components[i]);
			savesButtons[i].addMouseListener(new SaveListener(cards, game, i, this));
		}
		ButtonMenu back = new ButtonMenu("Back",GAMEBOARD);
		back.setFont(font);
		back.setBackground(Color.DARK_GRAY);
		back.setForeground(Color.ORANGE);
		back.setPreferredSize(new Dimension(230, 60));
		back.addMouseListener(new MenuListener(back,panel));
		JComponent[] comps={back};
		addComp(comps);
	}   
}
