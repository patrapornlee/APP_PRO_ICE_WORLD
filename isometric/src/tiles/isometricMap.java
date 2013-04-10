package tiles;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


import gui.addon.drawable;

public class isometricMap implements drawable {
        

        private final int HEIGHT = 800;
        private final int WIDTH = 800;
        
        private final int MAX_TILES_X = 10;
        private final int MAX_TILES_Y = 20;
        
        private HashMap<Point, IsometricPoint> pointMap = null;
        private int last_x, total_rows;
        private Point mousePoint = null;
        private Point midPoint = null;

        public isometricMap() {
                generateBlankMap(20);
        }

        @Override
        public void draw(Graphics g) {
                if (pointMap == null)
                        return;
                
                int firstRow = 0;
                int firstPoint = 0;
                
                if (midPoint != null) {
                        firstRow = Math.max(0, midPoint.y - MAX_TILES_Y);
                        firstPoint = Math.max(0, midPoint.x - MAX_TILES_X);
                }
                
                int lastRow = Math.min(total_rows, firstRow + 2 * MAX_TILES_Y);
                int lastPoint = Math.min(last_x, firstPoint + 2 * MAX_TILES_X);
                
                Point center = calculatePos(midPoint);
                
                for (int y = firstRow; y < lastRow; y++) {
                        for (int x = lastPoint; x >= firstPoint; x--) {
                                IsometricPoint ip = pointMap.get(new Point(x, y));
                                if (ip != null) {
                                        if (mousePoint != null && ip.contains(mousePoint)) {
                                                ip.setHighlight(true);
                                        } else if (mousePoint != null) {
                                                ip.setHighlight(false);
                                        }
                                        ip.draw(g, center);
                                }
                        }
                }
        }
        
        private Point calculatePos(Point mid) {
                IsometricPoint ip = pointMap.get(mid);
                Point tmp = ip.getCenter();
                int tmp_x = WIDTH/2 - tmp.x;
                int tmp_y = HEIGHT/2 - tmp.y;
                return new Point(tmp_x, tmp_y);
        }

        private void generateBlankMap(int rows) {
                pointMap = new HashMap<Point, IsometricPoint>();

                int tmp_backwards = rows + 1;

                int tileRows = (rows * 2) - 1; // 9 rida kokku kui on 5x5 maatriks.
                int lastX = rows - 1;

                boolean decrease = false;

                for (int y = 0; y < tileRows; y++) {

                        if (y + 1 >= rows) {
                                decrease = true;
                                tmp_backwards--;
                        }

                        int tilesInRow = (y < rows - 1 ? y + 1 : (y + 1 == rows ? rows
                                        : tmp_backwards));

                        for (int x = 0; x < tilesInRow; x++) {
                                int tmp_x = lastX + 2 * x;
                                
                                last_x = Math.max(tmp_x, last_x);
                                
                                Point tmp_point = new Point(tmp_x, y);
                                IsometricPoint tmp_ip = new IsometricPoint(tmp_x, y);
                                pointMap.put(tmp_point, tmp_ip);
                                if (y+1 == rows && x == tilesInRow/2) {
                                        midPoint = tmp_point;
                                        tmp_ip.setJoy(true);
                                        
                                }
                        }
                        if (!decrease)
                                lastX--;
                        else
                                lastX++;
                }
                total_rows = tileRows;
                System.out.println("DONE! " + total_rows);
        }

        public void setMousePoint(Point mouse) {
                mousePoint = mouse;
        }
}