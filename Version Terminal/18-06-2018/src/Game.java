package arcanor;
import java.util.*;
import java.io.*;
import java.text.*;
public class Game implements Serializable{
	private Board board;
	private int nbTours;
	private boolean turnOf;
	private Player player1;
	private Player player2;
	private final int DEFAULT_HEIGHT=7;
	private final int DEFAULT_WIDTH=3;
	public Game(ParamMenu params){
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
			if(nbHumans>1){
				this.player2= new HumanPlayer(params.getTabParams()[4], false, this.board);
			}
			else{
				this.player2= new AIPlayer(params.getTabParams()[4], false, this.board);
			}
		}
		else{
			this.player1= new AIPlayer(params.getTabParams()[3], true, this.board);
		}
		this.nbTours=1;
		this.turnOf=true;
	}
	
	public boolean start(){
		int winner=0;
		while(winner==0){
			if(turnOf){
				this.player1.playTurn(nbTours);
			}
			else{
				this.player2.playTurn(nbTours);
				this.nbTours++;
			}
			this.turnOf=!turnOf;
			winner=this.board.checkWin();
			Scanner in= new Scanner(System.in);
			String inp="";
			while(!(inp.equalsIgnoreCase("y") || inp.equalsIgnoreCase("n"))){
				System.out.println("Save ? y/n");
				inp=in.nextLine();
			}
			if(inp.equalsIgnoreCase("y")){
				save();
			}
		}
		endOfGame(winner);
		return true;
	}
	
	public void save(){
		int numSave=0;
		Scanner in = new Scanner(System.in);
		while(numSave<1 || numSave>6){
			System.out.println("Save in space number ? 1-6");
			numSave=in.nextInt();
		}
		String f = numSave+".savebin";
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
			String inp=br.readLine();
			for(int i=0;i<6;i++){
				int nSave= Integer.parseInt(br.readLine());
				saves[nSave*2-1]=br.readLine();
			}
		}
		catch(Exception e){
		}
		saves[numSave*2-1]=dateFormat.format(date);
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
	
	public void endOfGame(int winner){
		switch(winner){
			case 1:
				System.out.println(this.board.toString());
				System.out.println(player1.getName()+" wins");
				break;
			case -1:
				System.out.println(this.board.toString());
				System.out.println(player2.getName()+" wins");
				break;
			default :
				System.out.println(this.board.toString());
				System.out.println("Game.endOfGame() ERROR : Winner invalid");
				break;
		}
		Scanner in = new Scanner(System.in);
		System.out.println("ENTER to end the game");
		String input = in.nextLine();
	}
}
