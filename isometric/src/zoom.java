import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class zoom extends JApplet{
//	private ImageIcon image;
	private JButton zoomIn, zoomOut;
	private JPanel drawingPanel, buttonPanel;
//	private int imageWidth, imageHeight;

	int[] px = {0, 40, 40, 0};
	int[] py = {0, 0, 40, 40};

	private Polygon poly;
// set up GUI, initialize variables
	public void init(){
//		final int[] px = {0, 40, 40, 0};
//		final int[] py = {0, 0, 40, 40};
		poly = new Polygon(px, py, 4);
		
//		image = new ImageIcon( "123.png" );

		buttonPanel = new JPanel();
		zoomIn = new JButton( "Zoom In" );
		zoomIn.addActionListener(

				new ActionListener() {
					public void actionPerformed( ActionEvent event ){
// zoom in
//						imageWidth *= 2;
//						imageHeight *= 2;
						for(int i=0;i<4;i++){
							px[i] +=px[i];
							py[i] +=py[i];
						}

					
				
// refresh image
					repaint();
				}
				}
				);
		buttonPanel.add( zoomIn );

		zoomOut = new JButton( "Zoom Out" );
		zoomOut.addActionListener(

				new ActionListener() {

					public void actionPerformed( ActionEvent event ){
						// zoom out
//						imageWidth /= 2;
//						imageHeight /= 2;
						for(int i=0;i<4;i++){
							px[i] = px[i]/2;
							py[i] = py[i]/2;
						}

						// refresh image
						repaint();
					}
				}
				);
		buttonPanel.add( zoomOut );

//imageWidth = image.getIconWidth();
//imageHeight = image.getIconHeight();

drawingPanel = new JPanel();
drawingPanel.setSize( 800, 200 );

// add components to content pane
Container container = getContentPane();
container.add( drawingPanel, BorderLayout.CENTER );
container.add( buttonPanel, BorderLayout.SOUTH );

} // end method init
// draw image with appropriate dimensions
public void paint( Graphics g )
{
super.paint( g );

//g.drawImage( image.getImage(), 0, 0, imageWidth,imageHeight, drawingPanel );
g.setColor(Color.BLACK);
g.drawPolygon(poly);

buttonPanel.repaint();
}

} // end class Zoom