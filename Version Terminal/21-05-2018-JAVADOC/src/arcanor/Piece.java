package arcanor;

/**
 * Cette classe représente une pièce du jeu
 */
public class Piece{

   /**
    * la couleur de la pièce
    */
   private int color;

   /**
    * la valeur de la pièce
    */
   private int value;

   /**
    * le contenu de la pièce
    */
   private Piece contain;

   /**
    * le Contructeur
    * @param color la couleur de la pièce
    * @param value la valeur de la pièce
    * @param contain le contenu de la pièce
    */
   public Piece(int color, int value, Piece contain){}

   /**
    * Getter de color
    * @return la couleur de la pièce
    */
   public int getColor(){}

   /**
    * Setter de color
    * @param color la couleur a attribuer
    */
   public void setColor(int color){}

   /**
    * Getter de value
    * @return la valeur de la pièce
    */
   public int getValue(){}

   /**
    * Setter de value
    * @param value la valeur a attribuer
    */
   public void setValue(int value){}

   /**
    * Getter de contain
    * @return le contenu de la pièce
    */
   public Piece getContain(){}

   /**
    * Setter de contain
    * @param contain le contenu a attribuer
    */
   public void setContain(Piece contain){}
      
}
