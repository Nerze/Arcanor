import java.awt.*;
import javax.swing.*;
import arcanor.*;


public class Arcanor{
    JPanel cards; //a panel that uses CardLayout
    final static String GAMEMENU = "Main Menu";
    final static String STARTMENU = "New Game";
    final static String LOADMENU = "Load Menu";
    final static String PARAMMENU = "Parameters";
    final static String GAMEBOARD = "Gameboard";
    
    public void addComponentToPane(Container pane) {
        
        //Create the panel that contains the menus.
        cards = new JPanel(new CardLayout());
        
        //Create the menus
        GameMenu game = new GameMenu(cards);
        StartMenu start = new StartMenu(cards);
        ParamMenu param = new ParamMenu(cards);
        
        //Add them tho the cardLayout panel
        cards.add(game, GAMEMENU);
        cards.add(start, STARTMENU);
        cards.add(param, PARAMMENU);
        
        pane.add(cards, BorderLayout.CENTER);
        CardLayout cl = (CardLayout)(cards.getLayout());
    }
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Arcanor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create and set up the content pane.
        Arcanor demo = new Arcanor();
        demo.addComponentToPane(frame.getContentPane());
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
