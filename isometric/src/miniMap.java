
import java.applet.Applet;
import java.util.Random;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Toolkit;
import javax.swing.*;



public class miniMap extends JApplet  {
	
//	private int MAX_X = Toolkit.getDefaultToolkit().getScreenSize().width;
//	private int MAX_Y = Toolkit.getDefaultToolkit().getScreenSize().height;
	paintMiniMap paint ;
	Point p;
	Image image;
	Graphics g;
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	Dimension screensize = toolkit.getScreenSize();
	public int x,y ;
  
        public miniMap() {

            Refresh refresh = new Refresh();
          	refresh.start();
        	
        }

        public void paint(Graphics g) {
        	
            paint = new paintMiniMap((int) Math.floor((Math.random()*100)+1),(int) Math.floor((Math.random()*100)+1));   			
            paint.paintMiniMap(g);
            
           	}
        
        class Refresh extends Thread{

			public void run(){
        		while(true){
	        			try{
	        				sleep(40);
	        			}catch(InterruptedException e){
	        				
	        			}
        		repaint();
        		}
        	}
        }
        
}

