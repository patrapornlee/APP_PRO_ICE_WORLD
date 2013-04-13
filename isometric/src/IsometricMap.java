

import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Toolkit;
import javax.swing.*;



public class IsometricMap extends JApplet  {
	
	paintMiniMap paint ;
	Graphics g;
	
//	private int MAX_X = Toolkit.getDefaultToolkit().getScreenSize().width;
//	private int MAX_Y = Toolkit.getDefaultToolkit().getScreenSize().height;
	IsometricSquare square ;
	Point p;
	Image image;
	Graphics buffer;
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	Dimension screensize = toolkit.getScreenSize();
  
		public void init(){

        	setSize(screensize);
		}
        public IsometricMap() {
       

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

            	paint = new paintMiniMap((int) Math.floor((Math.random()*100)+1),(int) Math.floor((Math.random()*100)+1));   			
                paint.paintMiniMap(g);
            	
           	}
        
        class Refresh extends Thread{
        	public void run(){
        		while(true){
	        			try{
	        				sleep(20);
	        			}catch(InterruptedException e){
	        				
	        			}
        		repaint();
        		}
        	}
        }
        
}