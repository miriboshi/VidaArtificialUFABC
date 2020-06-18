//TODO fix positioning problems

package models;

import java.awt.Graphics;
import java.util.ArrayList;

public class SierpinskiGasket implements Drawable, Movable {
	Point a, b;
	ArrayList<Rectangle> recursions = new ArrayList<Rectangle>();

	public SierpinskiGasket(Point a, Point b) {
		this.a = a;
		this.b = b;

		generateRecursions(a, Math.abs(a.getX() - b.getX()));
	}

	private void generateRecursions(Point a, int length) {
		recursions.add(new Rectangle(a, new Point(a.getX() + length, a.getY() + length))); // Quadrado
																							// principal
		if (length >= 2) {
			generateRecursions(a, length / 2); // Quadrado superior esquerdo
			generateRecursions(new Point(a.getX() + length / 2, a.getY()), length / 2); // Quadrado
																						// superior
																						// direito
			generateRecursions(new Point(a.getX() + length / 2, a.getY() + length / 2), length / 2); // Quadrado
																										// inferior
																										// direito
		}
	}

	@Override
	public void moveX(int deltaX) {
		a.moveX(deltaX);
	}

	@Override
	public void moveY(int deltaY) {
		a.moveY(deltaY);
	}

	@Override
	public void draw(Graphics g) {
		for (Rectangle rectangle : recursions) {
			rectangle.draw(g);
		}
	}
}
