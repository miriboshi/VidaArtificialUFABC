package models;

import java.awt.Graphics;
import java.util.ArrayList;

public class GourmetRay implements Drawable, Movable {
	ArrayList<Point> points = new ArrayList<>();
	
	public GourmetRay(ArrayList<Point> points) {
		for (Point point : points) {
			this.points.add(point);
		}
	}

	@Override
	public void moveX(int deltaX) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveY(int deltaY) {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics g) {
		for (int i = 1; i < points.size(); i++) {
			g.drawLine(points.get(0).getX(), points.get(0).getY(), points.get(i).getX(), points.get(i).getY());
		}
	}

}
