import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Toolkit;


public class IsometricSquare {

	private int MAX_X = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int MAX_Y = Toolkit.getDefaultToolkit().getScreenSize().height;
	private int line, row, width, height;
	private Point origin;
	private Polygon poly;
	
	public IsometricSquare (int line, int row) {
		this.line = line;
		this.row = row;
		width = MAX_X/200;
     	height = MAX_Y/200;
        origin = new Point (MAX_X/2,height+(MAX_Y-height*241)/2);
	}
	
    


    public void paintSquare(Graphics g) {
        
            	int originLine = origin.x - line*width ; 
            	int originRow = origin.y + line*height;
            	int[] px = {originLine + width*row, originLine + width*(row+1), originLine+ width*row, originLine + width*(row-1) };
                int[] py = { originRow + height*(row-1), originRow + height*row, originRow + height*(row+1), originRow + height*row };
                poly = new Polygon(px, py, 4);
        		g.drawPolygon(poly);
            }
    
    public int getLine () {
    	return line;
    }
    
    public int getRow () {
    	return row;
    }
    
    }
