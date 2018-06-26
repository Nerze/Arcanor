package arcanor;
import java.util.*;
import java.io.*;
import java.text.*;
import java.util.InputMismatchException;
import javax.swing.*;
import java.awt.*;
public class Game implements Serializable{
	public Board board;
	public int nbTours;
	public boolean turnOf;
	public Player player1;
	public Player player2;
	public boolean howToMove;
	public JLabel playerTurn;
	public JCheckBox empt;
	private final int DEFAULT_HEIGHT=7;
	private final int DEFAULT_WIDTH=3;
	final static String GAMEBOARD = "Gameboard";
    final static String SAVEMENU = "Save menu";
    final static String GAMEMENU = "Main Menu";
    
	public boolean empty;
	JPanel cards,panel;
	public Game(ParamMenu params, JPanel cards, SaveMenu saveMen){
		this.howToMove=false;
		int width=Integer.parseInt(params.getTabParams()[1]);
		int height=Integer.parseInt(params.getTabParams()[0]);
		int vict = Integer.parseInt(params.getTabParams()[5]);
		if(width<1){
			System.out.println("Game() ERROR : width invalid");
			width=DEFAULT_WIDTH;
		}
		if(height<1){
			System.out.println("Game() ERROR : height invalid");
			height=DEFAULT_HEIGHT;
		}
		if(vict<1){
			System.out.println("Game() ERROR : points to victory invalid");
			vict=width*4;
		}
		this.board= new Board(width,height,vict);
		int nbHumans= Integer.parseInt(params.getTabParams()[2]);
		if(nbHumans>0){
			this.player1= new HumanPlayer(params.getTabParams()[3], true, this.board);
			
		}
		else{
			this.player1= new AIPlayer(params.getTabParams()[3], true, this.board);
		}
		if(nbHumans>1){
			this.player2= new HumanPlayer(params.getTabParams()[4], false, this.board);
		}
		else{
			this.player2= new AIPlayer(params.getTabParams()[4], false, this.board);
		}
		this.nbTours=1;
		this.turnOf=true;
		initializePanel(cards, saveMen);
		
	}
	
	public void initializePanel(JPanel cards, SaveMenu saveMen){
		GridTableModel otmodel = new GridTableModel(this.board.getGrid());
		JTable tab = new JTable(otmodel);
		// to adjust some parameters
		tab.setShowGrid(true);
		// color for the grid lines
		tab.setGridColor(Color.BLACK);
		tab.setRowHeight(64);
		
		this.panel= new JPanel();
		panel.setOpaque(false);
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
		String turnOfPlayer;
		if(turnOf){
			turnOfPlayer=player1.getName();
		}
		else{
			turnOfPlayer=player2.getName();
		}
		playerTurn = new JLabel("Your time to play "+turnOfPlayer);
		
		ButtonMenu quit = new ButtonMenu("Quit", GAMEMENU);
		quit.addMouseListener(new MenuListener(quit,cards));
		
		empt = new JCheckBox("Empty your piece");
		empt.addMouseListener(new EmptyListener(this,empt)); 
		
		ButtonMenu sav = new ButtonMenu("Save", SAVEMENU);
		sav.addMouseListener(new MenuListener(sav,cards));
		
		String[] moveList = {"2 Clicks", "Drag and Drop" };
		JComboBox moveMethod = new JComboBox(moveList);
		moveMethod.addItemListener(new MoveMethodListener(moveMethod, this));
		moveMethod.setSelectedIndex(0);
		
		JPanel buttons = new JPanel();
		buttons.setOpaque(false);
		buttons.add(sav);
		buttons.add(empt);
		buttons.add(moveMethod);
		buttons.add(quit);
		panel.add(playerTurn);
		panel.add(tab);
		panel.add(buttons);
		cards.add(panel, GAMEBOARD);
		this.cards=cards;
		tab.addMouseListener(new GridListener(this, tab));
		saveMen.paintMe(cards, this);
	}
	
	public void start(){
		CardLayout cl = (CardLayout)(cards.getLayout());
		cl.show(cards, GAMEBOARD);																			
	}
	
	public void save(int numSave){
		String f = (numSave+1)+".savebin";
		try
		{
			ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream (f));
			oos.writeObject (this);
			oos.close();
		}
		catch (IOException exception)
		{
			System.out.println ("Erreur lors de l'écriture : " + exception.getMessage());
		}
		//Write the save datas for future loading
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String[] saves= new String[12];
		for(int i=0;i<6;i++){
			saves[i*2]=(i+1)+"";
		}
		try{
			FileReader fileR= new FileReader("saves.savebin");
			BufferedReader br = new BufferedReader(fileR);
			for(int i=0;i<6;i++){
				int nSave= Integer.parseInt(br.readLine());
				saves[nSave*2-1]=br.readLine();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		saves[numSave*2+1]=dateFormat.format(date);
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
		catch(Exception e){}
	}
	
}
