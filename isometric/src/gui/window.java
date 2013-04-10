package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class window extends JFrame {
        
        private gameCanvas canvas = null;
        
        private final int HEIGHT = 800;
        private final int WIDTH = 800;
        private final String TITLE = "AppPro Madness!";
        
        private JPanel jMain = null;

        public window() {
                setup();
                addItems();
        }
        
        private void setup() {
                setTitle(TITLE);
                setVisible(true);
                setSize(WIDTH, HEIGHT);
                setResizable(false);
                setVisible(true);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                setIgnoreRepaint(true);
                setContentPane(getMain());
        }
        
        private JPanel getMain() {
                if (jMain == null) {
                        jMain = new JPanel(true);
                        jMain.setLayout(new BorderLayout());
                }
                return jMain;
        }
        
        private void addItems() {
                getMain().add(getCanvas());
                getMain().validate();
                pack();
        }
        
        private gameCanvas getCanvas() {
                if (canvas == null) {
                        canvas = new gameCanvas();
                }
                return canvas;
        }
}