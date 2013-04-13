

import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.*;



public class IsometricMap implements MouseListener, MouseMotionListener, MouseWheelListener {
	
	private int MAX_X = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int MAX_Y = Toolkit.getDefaultToolkit().getScreenSize().height;
	private IsometricSquare square ;
	private Point pHilight, pCliqued;
	private int lineCliqued, rowCliqued, middleSquareLine, middleSquareRow ;
	private int zoomLevel;
	private boolean cliqued ;
	private Point middlePoint;

  

        public IsometricMap() {
        	

        	
        	middlePoint = new Point (MAX_X/2, MAX_Y/2);
        	cliqued = false;
        	middleSquareLine = 50;
        	middleSquareRow = 50;
        	zoomLevel = 1;
        }

        public void paintMap(Graphics g, int frameSizeX, int frameSizeY) {
        	
        	if (pHilight !=null){
        		if (pHilight.x <= 40){
        			if (middleSquareLine<100 && middleSquareRow >0){
        				middleSquareLine ++;
        				middleSquareRow--;
        			}
        			else if (middleSquareLine<100){
        				middleSquareLine ++;
        			}
        			else if (middleSquareRow >0) {
        				middleSquareRow--;
        			}
    			}
        		
    			else if (pHilight.y <= 65){
        			if (middleSquareLine>0 && middleSquareRow>0){
        				middleSquareLine --;
        				middleSquareRow--;
        			}
        			else if (middleSquareLine>0){
        				middleSquareLine --;
        			}
        			else if (middleSquareRow>0) {
        				middleSquareRow--;
        			}	
    			}
        		
    			else if (pHilight.x >= frameSizeX-40 ){
        			if ( middleSquareLine>0 && middleSquareRow<100){
        				middleSquareLine --;
        				middleSquareRow++;
        			}
        			else if (middleSquareLine>0){
        				middleSquareLine --;
        			}
        			else if (middleSquareRow<100) {
        				middleSquareRow++;
        			}
    			}
        		
    			else if (pHilight.y >= frameSizeY-40){
    				if (middleSquareLine<100 && middleSquareRow<100){
    					middleSquareLine ++;
        				middleSquareRow++;
        			}
        			else if (middleSquareLine<100){
        				middleSquareLine ++;
        			}
        			else if (middleSquareRow<100) {
        				middleSquareRow++;
        			}    				
    			}
        	}
        	
            
                for (int line = 1 ; line<=100 ; line++) {
                	for (int row = 100; row > 0; row --) {
               			square = new IsometricSquare (line,row,middleSquareLine,middleSquareRow,zoomLevel);
               			
               			if (square.contains(middlePoint)){
               				middleSquareLine = square.getLine();
               				middleSquareRow = square.getRow();
               			}
               			
               			if (pHilight != null){
               				if (square.contains(pHilight)) {
               					square.setHighlighted(true);
               				}
               			}
               			
               			if (pCliqued != null){
               				if (cliqued){
               					if (square.contains(pCliqued)) {
                   					lineCliqued = square.getLine();
                   					rowCliqued = square.getRow();
                   					cliqued = false;
                   				}
               				}
               				if (lineCliqued ==square.getLine() && rowCliqued ==square.getRow()){
               					square.setCliqued(true);
               				}
               			}
               		
               			
               			square.paintSquare(g);
                	}
                }
           	}

		public void mousePressed(MouseEvent e) {
			pCliqued = e.getPoint();
			cliqued = true;
		}

		public void mouseMoved(MouseEvent e) {
			pHilight = e.getPoint ();
		}
		
		public void mouseWheelMoved(MouseWheelEvent e) {
	        int notches = e.getWheelRotation();
	        if (notches < 0 && zoomLevel < 10) {
	             zoomLevel++;
	        } else if (notches > 0 && zoomLevel > 1) {
	             zoomLevel--;
	        }
	    }
        public void mouseClicked(MouseEvent e) {}

		public void mouseEntered(MouseEvent e) {}
		
		public void mouseExited(MouseEvent e) {}
		
		public void mouseReleased(MouseEvent e) {}

		public void mouseDragged(MouseEvent e) {}
}