

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Toolkit;



public class IsometricMap  {
        
	IsometricSquare square ;
  

        public IsometricMap() {

        }

        public void paintMap(Graphics g) {
            
                for (int line = 0 ; line<100 ; line++) {
                	for (int row = 100; row > 0; row --) {
               			square = new IsometricSquare (line,row);
               			square.paintSquare(g);
                
                	}
                }
           	}
        
}