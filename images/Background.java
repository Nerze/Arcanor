/**@author : Adrien Mazet */
package vaisselle;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.lang.Exception;
public class Background extends JPanel{

	private BufferedImage image;
	
	public Background(String chemin){
		try{
			image = ImageIO.read(new File(chemin));
			setPreferredSize(new Dimension(image.getWidth(),image.getHeight()));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(image,0,0,null);
	}
}
