
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.*;



public class Paint extends JApplet {

	private int MAX_X = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int MAX_Y = Toolkit.getDefaultToolkit().getScreenSize().height;
	private int TALK_VISIBLE_DURATION = 5000;
	private BufferedImage image;
	private Graphics buffer;
	private Walking walking;
	private Weather weather;
	private Talking talking;
	private Yelling yelling;
	private IsometricMap isometricMap;
	
	public Paint () {

		walking = new Walking ();
		addMouseListener (walking);
		isometricMap = new IsometricMap ();
		weather = new Weather ();
		talking = new Talking ("prout prout prout", TALK_VISIBLE_DURATION);
		yelling = new Yelling ("WHAT THE FUCK");
		this.setBackground(Color.BLUE);
		new Animator ();
		new Music ("fat.au");

	}
	
	public void paint (Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		image= new BufferedImage(getSize().width,getSize().height,BufferedImage.TYPE_INT_RGB);
		buffer=image.getGraphics();
		isometricMap.paintMap(buffer);
		walking.paintWalking(buffer);
		buffer.setColor(Color.WHITE);
		
		weather.paintWeather(buffer);
		
		talking.paintTalking (buffer, walking.getCharPositionX(), walking.getCharPositionY());
		yelling.paintYelling(buffer);
		AffineTransform transformationZoom = AffineTransform.getScaleInstance(1f, 1f);
		//image = image.getScaledInstance(MAX_X, MAX_Y, 10);
		g2.drawImage(image, transformationZoom,this);
		
	}
	
	class Animator implements Runnable {
		private Thread thread;

		
		public Animator () {
			thread = new Thread (this);
			thread.start();
		}
		
		public void run () {
			while (true) {
			try {
				thread.sleep(weather.getDelay());
			}catch (InterruptedException e) {}
			
			repaint ();
			}
		}
	}

}
