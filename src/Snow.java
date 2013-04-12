import java.applet.Applet;
import java.awt.*;
import java.util.LinkedList;

import javax.swing.*;


public class Snow extends JApplet{
	private int MAX_X = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int MAX_Y = Toolkit.getDefaultToolkit().getScreenSize().height;
	private LinkedList<Flocon> flocons;
	//private int NUMBER_FLOCONS;
	private Image image;
	private Graphics buffer;
	
	
	public Snow () {
		this.setBackground(Color.BLUE);
		flocons = new LinkedList<Flocon> ();
		generateWeather();
		new AnimatorSnow ();
	}

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/
	
	class Flocon {
		private int VX;
		private int VY;
		private int x,y;
		
		public Flocon (int x, int y , int VX, int VY){
			this.x = x;
			this.y = y;
			this.VX = VX;
			this.VY = VY;
		}
		
		public int getX () {
			return x;
		}
		
		public int getY () {
			return y;
		}
		
		public void move () {
			x=x+VX;
			y=y+VY;
			if (x>=MAX_X){
				x=0;
			}
			else if (y>=MAX_Y){
				y=0;
			}
			else if (x<0) {
				x=MAX_X;
			}
		}
	}
	
	class AnimatorSnow implements Runnable {
		private Thread thread;
		
		public AnimatorSnow () {
			thread = new Thread (this);
			thread.start();
		}
		
		public void run () {
			while (true) {
			for (Flocon f : flocons){
				f.move();
			}
			try {
				thread.sleep(40);
			}catch (InterruptedException e) {}
			
			repaint ();
			}
		}
	}
	

	
	public void paint (Graphics g) {
		
		image= createImage(getSize().width,getSize().height);
		buffer=image.getGraphics();
		buffer.setColor(Color.WHITE);
		for (Flocon f : flocons){
			buffer.fillOval(f.getX(),f.getY(), 10, 10);
		}
		g.drawImage(image, 0,0,this);
	}

	public void generateWeather () {
		int NUMBER_FLOCONS = 200;
		int x,y,VX,VY;
		for (int i=0; i<NUMBER_FLOCONS; i++) {
			x=((int)(Math.random()*MAX_X));
			y=((int)(Math.random()*MAX_Y));
			VX=((int)(Math.random()*(6)-3));
			VY=((int)(Math.random()*2+1));
			flocons.add(new Flocon (x,y,VX,VY));
		}
	}
}
