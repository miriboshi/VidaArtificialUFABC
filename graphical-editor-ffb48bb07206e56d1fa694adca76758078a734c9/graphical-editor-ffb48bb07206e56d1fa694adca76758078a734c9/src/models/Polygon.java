package models;

import java.awt.Graphics;
import java.util.ArrayList;

public class Polygon implements Drawable, Movable {
	ArrayList<Point> vertices = new ArrayList<Point>();
	
	public Polygon(ArrayList<Point> vertices){
		for (Point vertex : vertices) {
			this.vertices.add(vertex);
		}
	}
	
	@Override
	public void moveX(int deltaX) {
		for (Point vertex : vertices) {
			vertex.moveX(deltaX);
		}

	}

	@Override
	public void moveY(int deltaY) {
		for (Point vertex : vertices) {
			vertex.moveY(deltaY);
		}
	}

	@Override
	public void draw(Graphics g) {
		int[] x = new int[vertices.size()];
		int[] y = new int[vertices.size()];
		
		
		for (int i = 0; i < vertices.size(); i++) {
			x[i] = vertices.get(i).getX();
			y[i] = vertices.get(i).getY();
		}
		g.drawPolygon(x, y, vertices.size());
	}

}
