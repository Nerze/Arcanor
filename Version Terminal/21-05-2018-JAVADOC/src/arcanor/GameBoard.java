package arcanor;
import java.util.ArrayList;
import System.out.*;

/**
 * Cette classe représente un plateau de jeu avec son déroulement
 */
public class GameBoard{

   /**
    * le numero du tour courrant
    */
   private int turn;

   /**
    * le tableau de paramètres de la partie
    */
   private ParamMenu gameParams;

   /**
    * la liste de joueurs dans la partie
    */
   private ArrayList<Player> playerList;

   /**
    * le tableau de jeu (plateau)
    */
   private Piece[][] board;

   /**
    * Le constructeur
    * @param params le tableau de paramètres
    * @param list la liste de joueurs
    */
   public GameBoard(ParamMenu params, ArrayList<Player> list){}

   /**
    * Fonction qui permet la sauvegarde
    */
   public void save(){}

   /**
    * Getter de turn
    * @return tour courrant
    */
   public int getTurn(){}

   /**
    * Setter de turn
    * @param turn le nouveau tour
    */
   public void setTurn(int turn){}

   /**
    * Fonction qui est un tour du jeu
    */
   public void play(){}

   /**
    * Fonction d'affichage
    */
   public void display(){}

}
