package arcanor;
import java.io.*;
import java.util.Scanner;
/**
 * This class represent the menu to load saved game
 */
public class LoadMenu extends Menu{



	/**
	* The constructor
	*/
	public LoadMenu(){
		super("Load");
	}

   

   /**
    * Printing method
    */
   public void display(){
	   try{
			int in=0;
			Scanner sc = new Scanner(System.in);
			String[] saves = new String[6];
			FileReader fileR= new FileReader("saves.savebin");
			BufferedReader br = new BufferedReader(fileR);
			for(int i=0;i<6;i++){
				saves[i]="Save "+br.readLine();
				String date= br.readLine();
				if(date.equals("null")){
					saves[i]+=" - No save";
				}
				else{
					saves[i]+=" - Date : "+date;
				}
			}
			boolean valid=false;
			while(!valid){
				System.out.println("==== Load ====");
				System.out.println("= 1. "+saves[0]);
				System.out.println("= 2. "+saves[1]);
				System.out.println("= 3. "+saves[2]);
				System.out.println("= 4. "+saves[3]);
				System.out.println("= 5. "+saves[4]);
				System.out.println("= 6. "+saves[5]);
				System.out.println("= 0. Back");
				in = sc.nextInt();
				if(in>=0 && in <=6){
					valid=true;
				}
			}
			if(in>0){
				if(saves[in-1].endsWith("No save")){
					System.out.println("There is no save !");
					this.display();
				}
				else{
					ObjectInputStream ois = new ObjectInputStream (new FileInputStream (in+".savebin"));
					Game game = (Game) ois.readObject();
					ois.close();
					game.start();
				}
			}
		}
		catch(FileNotFoundException e){
			System.out.println("No saves !");
		}
		catch(Exception e){
		e.printStackTrace();
		}
	}

   
      
}
