/*
*https://rosettacode.org/wiki/Sierpinski_triangle/Graphical#Java
*/

import javax.swing.*;
import java.awt.*;
 
/**
* SierpinskyTriangle.java
* Draws a SierpinskyTriangle in a JFrame
* The order of complexity is given from command line, but
* defaults to 3
*
* @author Istarnion
*/ 
 
class SierpinskiTriangle 
{ 
	public static void main(String[] args) {
		int i = 20;		// Default to 3
		final int level = i;
 
		JFrame frame = new JFrame("Sierpinsky Triangle - Java");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
		JPanel panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				g.setColor(Color.BLACK);
				drawSierpinskyTriangle(level, 20, 20, 360, (Graphics2D)g);
			}
		};
 
		panel.setPreferredSize(new Dimension(400, 400));
 
		frame.add(panel);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
 
	private static void drawSierpinskyTriangle(int level, int x, int y, int size, Graphics2D g) {
		if(level <= 0) return;
		
		/**
	     * Draws a line, using the current color, between the points
	     * <code>(x1,&nbsp;y1)</code> and <code>(x2,&nbsp;y2)</code>
	     * in this graphics context's coordinate system.
	     * @param   x1  the first point's <i>x</i> coordinate.
	     * @param   y1  the first point's <i>y</i> coordinate.
	     * @param   x2  the second point's <i>x</i> coordinate.
	     * @param   y2  the second point's <i>y</i> coordinate.
	     */
		
 
		//desenho do quadrado com linhas
			g.drawLine(x, y, x+size, y); //linha superior horizontal
			g.drawLine(x, y+size, x, y); //linha vertical esquerda
			g.drawLine(x, y+size, x+size, y+size); // linha horizontal inferior
			g.drawLine(x+size, y+size, x+size, y); //linha vertical direita
		
		drawSierpinskyTriangle(level-1, x+size/2, y+size/2, size/2, g);
		//drawSierpinskyTriangle(level-1, x, y, size/2, g);
		
																																
	}
}