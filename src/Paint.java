
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.*;



public class Paint extends JFrame {

	private int MAX_X = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int MAX_Y = Toolkit.getDefaultToolkit().getScreenSize().height;
	private int TALK_VISIBLE_DURATION = 5000;
	private Image image;
	private Graphics buffer;
	private Walking walking;
	private Weather weather;
	private Talking talking;
	private Yelling yelling;
	private IsometricMap isometricMap;
	
	
	public static void main (String [] args){
		Paint paint = new Paint ();
        paint.setVisible(true);
        paint.setDefaultCloseOperation(EXIT_ON_CLOSE);
        paint.setSize(1280,720);
	}

    private void setGUI() {
        //talk panel
        JPanel talkPanel = new JPanel();
        final JTextField talkLabel = new JTextField();
        JButton submitTalk = new JButton("Submit Talk");
        submitTalk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sentence = talkLabel.getText();
                new Talking(sentence, TALK_VISIBLE_DURATION);
            }
        });
        talkPanel.add(talkLabel);
        talkPanel.add(submitTalk);
        add(talkPanel,BorderLayout.SOUTH);
    }

    public Paint () {
        setLayout(new BorderLayout());
        setGUI();
		walking = new Walking ();
		addMouseListener (walking);
		isometricMap = new IsometricMap ();
		weather = new Weather ();
		talking = new Talking ("prout prout prout", TALK_VISIBLE_DURATION);
		yelling = new Yelling ("WHAT THE FUCK");
		isometricMap = new IsometricMap();
		addMouseListener(isometricMap);
		addMouseMotionListener(isometricMap);
		addMouseWheelListener(isometricMap);
		this.setBackground(Color.WHITE);
		changeCursor("sword.gif");
		new Animator ();
		new Music ("music.wav");

	}
	
	public void paint (Graphics g) {
		
		image= createImage(getSize().width,getSize().height);
		buffer=image.getGraphics();
		
		isometricMap.paintMap(buffer,getWidth(),getHeight());
		walking.paintWalking(buffer);
		buffer.setColor(Color.WHITE);
		
		weather.paintWeather(buffer);
		
		talking.paintTalking (buffer, walking.getCharPositionX(), walking.getCharPositionY());
		yelling.paintYelling(buffer);
		g.drawImage(image,0,0,this);
		
	}
	
	public void changeCursor (String cursorFile) {
		  Toolkit toolkit = Toolkit.getDefaultToolkit();
		  Image image = toolkit.getImage(cursorFile);
		  Cursor c = toolkit.createCustomCursor(image , new Point(getX(),getY()), "img");
		  setCursor (c);
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
				thread.sleep(10);
			}catch (InterruptedException e) {}
			
			repaint ();
			}
		}
	}

}
