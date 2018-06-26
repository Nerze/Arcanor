package arcanor;
import java.io.*;
import javax.swing.*;
import java.awt.*;
/**
 * This class represent the menu to load saved game
 */
public class LoadMenu extends Menu{
	final static String GAMEMENU = "Main Menu";
	private String[] saves;
	private Game[] savedGames;




   

   /**
    * The constructor
    */
   public LoadMenu(JPanel panel, SaveMenu save){
	   super("Load");
	   try{
			saves = new String[6];
			FileReader fileR= new FileReader("saves.savebin");
			BufferedReader br = new BufferedReader(fileR);
			savedGames=new Game[6];
			for(int i=0;i<6;i++){
				saves[i]="Save "+br.readLine();
				String date= br.readLine();
				if(date.equals("null")){
					saves[i]+=" : No save";
				}
				else{
					saves[i]+=" : "+date;
					ObjectInputStream ois = new ObjectInputStream (new FileInputStream ((i+1)+".savebin"));
					savedGames[i] = (Game) ois.readObject();
					ois.close();
				}
			}
		}
		catch(Exception e){
		e.printStackTrace();
		}
		JLabel[] savesLabel= new JLabel[6];
		LoadButton[] savesButtons = new LoadButton[6];
		JComponent[][] components= new JComponent[6][2];
		for(int i=0;i<saves.length;i++){
			savesLabel[i]=new JLabel(saves[i]);
			savesButtons[i] = new LoadButton("Load",savedGames[i]);
			components[i]=new JComponent[]{savesLabel[i],savesButtons[i]};
			addComp(components[i]);
			savesButtons[i].addMouseListener(new LoadListener(savesButtons[i], panel,save));
		}
		ButtonMenu back = new ButtonMenu("Back",GAMEMENU);
		back.addMouseListener(new MenuListener(back,panel));
		JComponent[] comps={back};
		addComp(comps);
	}

   
      
}
