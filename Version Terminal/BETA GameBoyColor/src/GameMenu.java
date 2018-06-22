package arcanor;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * This class represent the menu that redirect to launcher menu, New Game or Load Game
 */
public class GameMenu extends Menu{
	
	/**
	 * The constructor
	 */
	public GameMenu(){
		super("Game Menu");
   	}
	
	/**
	 * Method that redirect to StartMenu
	 */
	public void startMenu(){
		StartMenu sm = new StartMenu();
		sm.display();
	}

	/**
	 * Method that redirect to LoadMenu
	 */
	public void loadMenu(){
		LoadMenu lm = new LoadMenu();
		lm.display();
	}

	/**
	 * Printing method
	 */
	public void display(){
		try{
			int in = 0;
			Scanner sc = new Scanner(System.in);
			boolean valid = false;
			while(!valid){
				Runtime.getRuntime().exec("clear");
				System.out.println("==== Play Menu ====");
				System.out.println("= 1. New Game");
				System.out.println("= 2. Load Game");
				System.out.println("= 0. Quit");
				try{
					in = sc.nextInt();
				}
				catch(InputMismatchException e){
					System.out.println("Please enter an integer");
					this.display();
				}
				if(in >= 0 && in <= 2){
					valid = true;
				}
			}
			switch(in){
				case 1 :
					this.startMenu();
					this.display();
					break;
				case 2 :
					this.loadMenu();
					this.display();
					break;
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
