import java.awt.*;
import javax.swing.*;
import arcanor.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.*;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;


public class Arcanor{
    JPanel cards; //a panel that uses CardLayout
    final static String GAMEMENU = "Main Menu";
    final static String STARTMENU = "New Game";
    final static String LOADMENU = "Load Menu";
    final static String PARAMMENU = "Parameters";
    final static String GAMEBOARD = "Gameboard";
    final static String SAVEMENU = "Save menu";
    
    public void addComponentToPane(JPanel pane) {
        //Create the panel that contains the menus.
		cards = new JPanel(new CardLayout());
		cards.setOpaque(false);
        
        //Create the menus
        SaveMenu save = new SaveMenu(cards);
        GameMenu game = new GameMenu(cards);
        LoadMenu load = new LoadMenu(cards, save);
        ParamMenu param = new ParamMenu(cards);
		StartMenu start = new StartMenu(cards, param, save);

        //Add them tho the cardLayout panel
        cards.add(game, GAMEMENU);
        cards.add(start, STARTMENU);
        cards.add(param, PARAMMENU);
        cards.add(load,LOADMENU);
        cards.add(save,SAVEMENU);
        
        pane.add(cards, BorderLayout.CENTER);
        CardLayout cl = (CardLayout)(cards.getLayout());
    }
    
    /**
     * Create the GUI and show it. For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
		//Create and set up the window.
		JFrame frame = new JFrame("Arcanor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("../songs/bgm.wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
		//Create and set up the content pane.
		Arcanor demo = new Arcanor();
		JPanel global = new JPanel();
		frame.setContentPane(global);
		frame.setResizable(false);
		global.setOpaque(false);
		JLabel background = new JLabel();;
		
		try{
			frame.setLayout(new BorderLayout());
			background = new JLabel(new ImageIcon("../images/background.gif"));
			frame.add(background);
			background.setLayout(new BorderLayout());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		JPanel panel = new JPanel();
		background.add(panel,BorderLayout.CENTER);
		panel.setOpaque(false);
		demo.addComponentToPane(panel);
		ImageIcon icon = new ImageIcon("../images/rigologo.png");
		frame.setIconImage(icon.getImage());
		
		//Display the window.
		frame.setPreferredSize(new Dimension(1280, 720));
		frame.pack();
		frame.setVisible(true);
    }
    
    /**
     * The main entry of the program
     * @param args Some arguments unused here !
     */
    public static void main(String[] args) {
        // Use an appropriate Look and Feel
        try {
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
