package arcanor;
import java.awt.*;
import javax.swing.*;


public class Arcanor{
    JPanel cards; //a panel that uses CardLayout
    final static String BUTTONPANEL = "Card with JButtons";
    final static String TEXTPANEL = "Card with JTextField";
    
    public void addComponentToPane(Container pane) {
        //Put the JComboBox in a JPanel to get a nicer look.
        JPanel buttonPane = new JPanel(); //use FlowLayout
        ButtonMenu button1 = new ButtonMenu("Buttons",BUTTONPANEL);
        buttonPane.add(button1);
        ButtonMenu button2 = new ButtonMenu("TextFields",TEXTPANEL);
        buttonPane.add(button2);
        
        //Create the "cards".
        JPanel card1 = new JPanel();
        card1.add(new JButton("Button 1"));
        card1.add(new JButton("Button 2"));
        card1.add(new JButton("Button 3"));
        
        JPanel card2 = new JPanel();
        card2.add(new JTextField("TextField", 20));
        
        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(card1, BUTTONPANEL);
        cards.add(card2, TEXTPANEL);
        
        pane.add(buttonPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
        button1.addMouseListener(new MenuListener(button1, cards));
        button2.addMouseListener(new MenuListener(button2, cards));
        CardLayout cl = (CardLayout)(cards.getLayout());
    }
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("CardLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create and set up the content pane.
        CardLayoutDemo demo = new CardLayoutDemo();
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
