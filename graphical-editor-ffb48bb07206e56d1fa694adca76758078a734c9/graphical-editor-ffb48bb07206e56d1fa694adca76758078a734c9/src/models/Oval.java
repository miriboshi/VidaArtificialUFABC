package models;

import java.awt.Graphics;

public class Oval implements Drawable, Movable {
	private Point a, b;

	public Oval(Point a, Point b) {
		this.a = a;
		this.b = b;
	}

	public void moveX(int deltaX) {
		a.moveX(deltaX);
		b.moveX(deltaX);
	}

	public void moveY(int deltaY) {
		a.moveY(deltaY);
		b.moveY(deltaY);
	}
	
	public int x0() {
		return a.x0(b);
	}

	public int y0() {
		return a.y0(b);
	}

	public int height() {
		return Math.abs(a.yDiff(b));
	}

	public int width() {
		return Math.abs(a.xDiff(b));
	}


	public void draw(Graphics g) {
		g.drawOval(x0(), y0(), width(), height());
	}

}
