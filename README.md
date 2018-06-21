# Arcanor

TO-DO General :
- Modifier diagramme de classe : Ajouter save dans Game
Pre-Partiels :
  
- Les classes
- Les tests
- L'interface
- La javaDoc

Post-Partiels :
  
- La partie graphique
- ...

TO-DO Rapide :

- playTurn(int numTour) de IAPlayer (GG)
-Adapter pour ajouter une IHM
Remplacer in.nextInt() par
try{
  in = sc.nextInt();
}
catch(InputMismatchException e){
  System.out.println("Please enter an integer");
  this.display();
}
import java.util.InputMismatchException;
Tâches fini :
- Avoir un environnement propre et fonctionel pour les test Junit

FAIT - à Tester :
- Tout sauf IAPlayer

FINI (point à la ligne) :
