package arcanor;
import System.out;

/**
 * This class is the main entry, the game launcher
 */
public class Arcanor{

   /**
    * The main entry of the program that launch the game
    * @param arg optionnal arguments
    */
   public static void main(String[] arg) {
      mm = new MainMenu();
      mm.display();
   }
}
