package views;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import models.*;

@SuppressWarnings("serial")
public class DrawingBoard extends JPanel {
	private ArrayList<Drawable> figures = new ArrayList<Drawable>();
	private ArrayList<Drawable> undoList = new ArrayList<Drawable>();

	public DrawingBoard() {

	}

	public void addFigure(Drawable figure) {
		figures.add(figure);
		repaint();
	}

	public void undo() {
		if (figures != null) {
			undoList.add(figures.get(figures.size() - 1));
			figures.remove(figures.size() - 1);
			repaint();
		}
	}

	public void redo() {
		
		if (undoList != null) {
			figures.add(undoList.get(undoList.size()-1));
			undoList.remove(undoList.size()-1);
			repaint();				
		}
	}
	
	public void clear(){
		figures.clear();
		undoList.clear();
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		if (figures != null) {
			for (Drawable figure : figures) {
				figure.draw(g);
			}
		}

	}
}
