package models;

public class Point implements Movable {
	private int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point() {
		this(0, 0);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void moveX(int deltaX) {
		this.x = this.x + deltaX;
	}

	public void moveY(int deltaY) {
		this.y = this.y + deltaY;
	}

	public int xAxisDist() {
		return Math.abs(this.x);
	}

	public int yAxisDist() {
		return Math.abs(this.y);
	}

	public int xDiff(Point a) {
		return this.x - a.x;
	}

	public int yDiff(Point a) {
		return this.y - a.y;
	}

	public int x0(Point a) {
		if (a.x < this.x)
			return a.x;
		return this.x;
	}

	public int y0(Point a) {
		if (a.y < this.y)
			return a.y;
		return this.y;
	}

	public String toString() {
		return "(" + x + ", " + y + ");";
	}
}
