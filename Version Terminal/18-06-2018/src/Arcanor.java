import arcanor.GameMenu;
/**
 * This class is the main entry, the game launcher
 */
public class Arcanor{

   /**
    * The main entry of the program that launch the game
    * @param arg optionnal arguments
    */
   public static void main(String[] arg) {
      GameMenu mm = new GameMenu();
      mm.display();
   }
}
