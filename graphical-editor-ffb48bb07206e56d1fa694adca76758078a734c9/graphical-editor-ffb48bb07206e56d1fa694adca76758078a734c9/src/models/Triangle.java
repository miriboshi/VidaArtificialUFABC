package models;

import java.awt.Graphics;

public class Triangle implements Drawable, Movable {

	private Point a, b, c;

	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public void moveX(int deltaX) {
		a.moveX(deltaX);
		b.moveX(deltaX);
		c.moveX(deltaX);
	}

	@Override
	public void moveY(int deltaY) {
		a.moveY(deltaY);
		b.moveY(deltaY);
		c.moveY(deltaY);
	}

	@Override
	public void draw(Graphics g) {
		g.drawLine(a.x0(a), a.y0(a), b.x0(b), b.y0(b)); // a to b
		g.drawLine(b.x0(b), b.y0(b), c.x0(c), c.y0(c)); // b to c
		g.drawLine(c.x0(c), c.y0(c), a.x0(a), a.y0(a)); // c to a
	}

	public String toString(){
		return a.toString() + "\n" + b.toString() + "\n" + c.toString();
	}
}
