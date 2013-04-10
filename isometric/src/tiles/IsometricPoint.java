package tiles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Rectangle2D;

import gui.addon.drawable;

public class IsometricPoint {


        private int width = 40;
        private int height = 20;

        private boolean highlighted = false;
        private boolean joy = false;

        private Polygon poly;
        private Rectangle rect;

        private int x, y;

        public IsometricPoint(int x, int y) {

                this.x = x;
                this.y = y;

                int[] px = { x * width + width, x * width, x * width - width, x * width };
                int[] py = { y * height, y * height + height, y * height,
                                y * height - height };

                poly = new Polygon(px, py, 4);
        }

        public void draw(Graphics g, Point transform) {
                transformPoly(transform);

                g.setColor(Color.black);
                if (highlighted) {
                        g.setColor(Color.orange);
                        g.fillPolygon(poly);
                } else {
                        if (joy) {
                                g.setColor(Color.pink);
                                g.fillPolygon(poly);
                        } else {
                                g.drawPolygon(poly);
                        }
                }
                rect = poly.getBounds();
                g.setColor(Color.black);
                g.drawString("(" + x + "," + y + ")", rect.x + width - 12, rect.y
                                + height + 5);
        }

        public String toString() {
                return "x=" + x + ", y=" + y + ", height=" + height + ", width="
                                + width;
        }

        public void setHighlight(boolean highlighted) {
                this.highlighted = highlighted;
        }

        public boolean contains(Point p) {
                return poly.contains(p);
        }

        private void transformPoly(Point trans) {
                if (trans == null)
                        return;
                
                poly.translate(trans.x, trans.y);
        }

        public void setJoy(boolean joy) {
                this.joy = joy;
        }
        
        public Point getCenter() {
                rect = poly.getBounds();
                return new Point((int) rect.getCenterX(), (int) rect.getCenterY());
        }
}