package arcanor;

/**
 * Cette classe représente un joueur
 */
public class Player{

   /**
    * variable d'humanité, true si humain
    */
   private boolean human;

   /**
    * nom du joueur
    */
   private String name;

   /**
    * Le constructeur
    * @param type humain ou non
    * @param name nom du joueur
    */
   public Player(boolean type, String name){}

   /**
    * Fonction demandant les entrées clavier pour jouer
    * @return le tableau d'actions a effectuer
    */
   public int[][] playTurn(){}

}
