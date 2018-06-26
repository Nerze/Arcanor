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
    public Font font = new Font("Dialog", Font.BOLD, 20);
   
    /**
     * The constructor
     * @param panel the panel were the Menu is display
     * @param save the list of the save
     */
   public LoadMenu(JPanel panel, SaveMenu save){
	   super("loadmenu");
	   try{
			saves = new String[6];
			savedGames=new Game[6];
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
					ObjectInputStream ois = new ObjectInputStream (new FileInputStream ((i+1)+".savebin"));
					savedGames[i] = (Game) ois.readObject();
					ois.close();
				}
			}
		}
		catch(FileNotFoundException e){
			String[] saves= new String[12];
			for(int i=0;i<6;i++){
				saves[i*2]=(i+1)+"";
				saves[i*2+1]="null";
			}
			String output="";
			for(int i=0;i<11;i=i+2){
				if(i!=0){
					output+="\n";
				}
				output+=saves[i]+"\n"+saves[i+1];
			}
			try{
				PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("saves.savebin")));
				out.println(output);
				out.close();
			}
			catch(Exception ex){
				ex.printStackTrace();
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
			savesLabel[i].setFont(font);
			savesLabel[i].setForeground(Color.DARK_GRAY);
			savesButtons[i] = new LoadButton("Load",savedGames[i]);
			savesButtons[i].setFont(font);
			savesButtons[i].setPreferredSize(new Dimension(230, 60));
			savesButtons[i].setBackground(Color.DARK_GRAY);
			savesButtons[i].setForeground(Color.ORANGE);
			components[i]=new JComponent[]{savesLabel[i],savesButtons[i]};
			addComp(components[i]);
			savesButtons[i].addMouseListener(new LoadListener(savesButtons[i], panel,save));
		}
		ButtonMenu back = new ButtonMenu("Back",GAMEMENU);
		back.setFont(font);
		back.setPreferredSize(new Dimension(230, 60));
		back.setBackground(Color.DARK_GRAY);
		back.setForeground(Color.ORANGE);
		
		back.addMouseListener(new MenuListener(back,panel));
		JComponent[] comps={back};
		addComp(comps);
	} 
}
