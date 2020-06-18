package models;

import java.awt.Graphics;

public class Rectangle implements Drawable, Movable {

	private Point a, b;

	public Rectangle(Point a, Point b) {
		this.a = a;
		this.b = b;
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

	public void moveX(int deltaX) {
		a.moveX(deltaX);
		b.moveX(deltaX);
	}

	public void moveY(int deltaY) {
		a.moveY(deltaY);
		b.moveY(deltaY);
	}

	public void draw(Graphics g) {
		g.drawRect(x0(), y0(), width(), height());
	}
	
	public String toString(){
		return a.toString() + "\n" + b.toString();
	}
}
