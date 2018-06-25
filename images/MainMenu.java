/**@author : Adrien Mazet */
package vaisselle;
import java.awt.*;
import javax.swing.*;

public class MainMenu extends JFrame{
	
	//attributes that will be used
	
	private JButton vaisselleButton;
	private JButton tutoButton;
    private JButton paramButton;
    
    private ImageIcon vaisselleIcon;
    
    private Background b;
    
    private Tutoriels t;
    
    private Parametres p;
    
    private Vaisselle v;
     
	public MainMenu(){ 
		//Call the super constructor
		super("Vaisselle Companion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// create the Tutoriels and Parametres frame
		t = new Tutoriels();		
		p = new Parametres();
		v = new Vaisselle();	
		// set the wallpaper and the layouts
		b = new Background("../images/wallpaper.png");	
		GridLayout g = new GridLayout(4,4,10,10);
		b.setLayout(g);
		setContentPane(b);

		// set the icon
		vaisselleIcon = new ImageIcon("../images/icon.png");
		setIconImage(vaisselleIcon.getImage());

		// initialize the void that will fill the grid
		JLabel[] vide = new JLabel[13];
		for( int i = 0; i < vide.length; i++){
			vide[i] = new JLabel("");
		}

		
		// initialize the JButtons
		ImageIcon imageVaisselle = new ImageIcon("../images/vaisselleButton.png");
		vaisselleButton = new JButton("Faire la vaisselle",imageVaisselle);
		ImageIcon imageTuto = new ImageIcon("../images/tutoButton.png");
		tutoButton = new JButton("Tutoriels vidéos",imageTuto);
		ImageIcon imageParam = new ImageIcon("../images/paramButton.png");
		paramButton = new JButton("Paramètres",imageParam);
		
		// add the Actionlistener to the JButtons
		ActionMainMenu a = new ActionMainMenu(this);
		vaisselleButton.addActionListener(a);
		paramButton.addActionListener(a);
		tutoButton.addActionListener(a);
		
		// add the components to the layout
		for(int j = 0; j < 13; j++){
			add(vide[j]);
		}
		add(vaisselleButton);
		add(tutoButton);
		add(paramButton);
		
		pack();
		setVisible(true);
	}
	// Run the application
	public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				 MainMenu m = new MainMenu(); 
			}
		});
	}
	
	
	public JButton getVaisselleButton(){
		return this.vaisselleButton;
	}
	
	public JButton getTutoButton(){
		return this.tutoButton;
	}
	
	public JButton getParamButton(){
		return this.paramButton;
	}
	
	public Tutoriels getTutoriels(){
		return this.t;
	}
	
	public Parametres getParam(){
		return this.p;
	}
	
	public Vaisselle getVaisselle(){
		return this.v;
	}
	 
}
