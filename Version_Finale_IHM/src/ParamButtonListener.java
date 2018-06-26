package arcanor;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class ParamButtonListener implements MouseListener{
	private JLabel aff;
	private String[] params;
	private int index;
	private ParamBouton origin;
	final static String QUIT = "Quit";
	public ParamButtonListener(ParamBouton origin, String[] params, int index, JLabel aff){
		if(origin==null){
			System.out.println("MenuListener() ERROR : origin is null");
			origin= new ParamBouton("",0,0);
		}
		this.origin=origin;
		if(aff==null){
			System.out.println("MenuListener() ERROR : aff is null");
			aff = new JLabel("0");
		}
		this.aff=aff;
		if(params==null){
			System.out.println("MenuListener() ERROR : params is null");
			params = new String[6];
		}
		this.params=params;
		if(index<0 || index>=params.length){
			System.out.println("MenuListener() ERROR : index is invalid");
			index = 0;
		}
		this.index=index;
	}
		
	public void mouseClicked(MouseEvent e){
		int newValue= Integer.parseInt(params[index])+origin.getValue();
		if(newValue>=origin.getValMin()){
			aff.setText(newValue+"");
			params[index]=newValue+"";
		}
	}
	
	public void mouseEntered(MouseEvent e){}
	
	public void mouseExited(MouseEvent e){}
	
	public void mousePressed(MouseEvent e){}
	
	public void mouseReleased(MouseEvent e){}
}
