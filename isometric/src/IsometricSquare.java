import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;


public class IsometricSquare {

	private int MAX_X = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int MAX_Y = Toolkit.getDefaultToolkit().getScreenSize().height;
	private int line, row, width, height;
	private Point origin;
	private Polygon poly;
	private Boolean highlighted;
	
	public IsometricSquare (int line, int row) {
		this.line = line;
		this.row = row;
		highlighted = false ;

		width = MAX_X/200;
     	height = MAX_Y/200;
        origin = new Point (MAX_X/2,height+(MAX_Y-height*241)/2);
        
    	int originLine = origin.x - line*width ; 
    	int originRow = origin.y + line*height;
    	int[] px = {originLine + width*row, originLine + width*(row+1), originLine+ width*row, originLine + width*(row-1) };
        int[] py = { originRow + height*(row-1), originRow + height*row, originRow + height*(row+1), originRow + height*row };
        poly = new Polygon(px, py, 4);
        
	}
	
    


    public void paintSquare(Graphics g) {
        		

                
                if (highlighted){
                g.setColor(Color.RED);
                g.fillPolygon(poly);}
                
                g.setColor(Color.BLACK);
        		g.drawPolygon(poly);
            }
    
    public int getLine () {
    	return line;
    }
    
    public int getRow () {
    	return row;
    }
    
    
    public boolean contains ( Point p) {
    	return poly.contains(p);
    }

    public void setHighlighted (boolean highlighted) {
    	this.highlighted = highlighted;
    }
    
    }
