

import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Toolkit;
import javax.swing.*;



public class IsometricMap extends JApplet  {
	
	private int MAX_X = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int MAX_Y = Toolkit.getDefaultToolkit().getScreenSize().height;
	IsometricSquare square ;
	Point p;
	Image image;
	Graphics buffer;
  

        public IsometricMap() {
       
        	this.setPreferredSize(new Dimension(MAX_X,MAX_Y));
        
        	Refresh refresh = new Refresh();
        	refresh.start();
        }

        public void paint(Graphics g) {
        	
        	image = createImage (getWidth(),getHeight());
        	buffer = image.getGraphics();
            
        	p = getMousePosition();
                for (int line = 0 ; line<100 ; line++) {
                	for (int row = 100; row > 0; row --) {
               			square = new IsometricSquare (line,row);
               			if (p != null){
               				if (square.contains(p)) {
               					square.setHighlighted(true);
               				}
               				
               			}
               			square.paintSquare(buffer);
                	}
                }
                g.drawImage(image, 0,0,this);
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