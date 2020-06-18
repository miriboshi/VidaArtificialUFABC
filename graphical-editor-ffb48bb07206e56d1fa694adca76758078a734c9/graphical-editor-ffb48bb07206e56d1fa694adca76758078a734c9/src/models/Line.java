package models;

import java.awt.Graphics;

public class Line implements Drawable, Movable{
	private Point a, b;
	
	public Line(Point a, Point b){
		this.a = a;
		this.b = b;
	}

	@Override
	public void moveX(int deltaX) {
		a.moveX(deltaX);
		b.moveX(deltaX);
	}

	@Override
	public void moveY(int deltaY) {
		a.moveY(deltaY);
		b.moveY(deltaY);
	}

	@Override
	public void draw(Graphics g) {
		g.drawLine(a.x0(a), a.y0(a), b.x0(b), b.y0(b));
	}
	
	
}
