package arcanor;

public class Player{

   private boolean human;
   private String name;

   public Player(boolean type, String name){
	   this.human=type;
	   if(name==null){
		   name="";
		   Sytem.out.println("Player() ERROR : name is null");
	   }
	   this.name=name;
   }
   
   
   abstract public int[] playTurn();
      
}
