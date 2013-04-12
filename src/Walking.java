import iceworld.given.ICEWorldImmigration;


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class Walking implements MouseListener {

	private int charPositionX,charPositionY,previousX,previousY,toMoveByX,toMoveByY,greaterDirectionMove;
	private double stepX,stepY;
	private double zoom;
	private int CHAR_WIDTH, CHAR_HEIGHT;
	private boolean stop;
	private Movement movement;
	Icetizen ice = new Icetizen ();
	ICEWorldImmigration immig = new ICEWorldImmigration (ice);

	
	public Walking () {
		charPositionX=200;
		charPositionY=200;
		CHAR_WIDTH = 30;
		CHAR_HEIGHT = 30;
		movement = new Movement ();
		//immig.loginAlien();
	}
	
	public void paintWalking (Graphics g){
		g.setColor(Color.BLACK);
		g.fillOval(charPositionX-30/2, charPositionY-30, 30, 30);
	}
	
	public int getCharPositionX () {
		return charPositionX;
	}
	
	public int getCharPositionY () {
		return charPositionY;
	}


	public void mousePressed(MouseEvent e) { 
		previousX=charPositionX;
		previousY = charPositionY;
		charPositionX = e.getX();
		charPositionY = e.getY();
		toMoveByX = charPositionX-previousX;
		toMoveByY = charPositionY-previousY;
		if (Math.abs(toMoveByX) > Math.abs(toMoveByY)){
			greaterDirectionMove = Math.abs(toMoveByX);	
		}
		else {
			greaterDirectionMove = Math.abs(toMoveByY);
		}
		stepX = ((double)toMoveByX)/((double)greaterDirectionMove);
		stepY = ((double)toMoveByY)/((double)greaterDirectionMove);		
		
		movement.stop();
		movement = new Movement ();
		movement.start();
		//immig.walk(charPositionX, charPositionY);
	}

	public void mouseClicked(MouseEvent arg0) {}

	public void mouseEntered(MouseEvent arg0) {}

	public void mouseExited(MouseEvent arg0) {}

	public void mouseReleased(MouseEvent arg0) {}
	
	class Movement extends Thread{
		
		
		public void run (){
			
			for (int i = 0; i<greaterDirectionMove; i++) {
				charPositionX=previousX + (int)(((double)i)*stepX);
				charPositionY=previousY + (int)(((double)i)*stepY);
				//repaint();
				
				try {
					sleep(5);
				}catch (InterruptedException e){}

			
		}
	}
	
}
	
}
