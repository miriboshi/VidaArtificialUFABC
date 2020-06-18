package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import models.GourmetRay;
import models.Line;
import models.Oval;
import models.Point;
import models.Polygon;
import models.Rectangle;
import models.SierpinskiGasket;
import views.DrawingBoard;

public class DrawingEventHandler implements MouseListener, MouseMotionListener {
	
	private int tempX, tempY;
	
	ArrayList<Point> vertices = new ArrayList<>();
	ArrayList<Point> points = new ArrayList<>();

	private DrawingBoard drawingBoard;

	private DrawingTool currentTool = DrawingTool.TOOL_NONE;

	public DrawingEventHandler(DrawingBoard drawingBoard){
		this.drawingBoard = drawingBoard;
	}
	
	public void setDrawingTool(DrawingTool newTool) {
		this.currentTool = newTool;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.tempX = e.getX();
		this.tempY = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		switch (currentTool) {		
		case TOOL_SG:
			drawingBoard.addFigure(new SierpinskiGasket(new Point(tempX, tempY), new Point(e.getX(), e.getY())));
			break;
			
		default:
			break;
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		switch (currentTool) {
		case TOOL_POLYGON:
			if (e.getButton() == MouseEvent.BUTTON1) {
				vertices.add(new Point(e.getX(), e.getY()));
				System.out.println("Press RMB to close your poly :D");

			} else if (e.getButton() == MouseEvent.BUTTON3) {
				drawingBoard.addFigure(new Polygon(vertices));
				System.out.println("What a wonderful poly!");
				vertices.clear();
			}
			break;

		default:
			break;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		switch (currentTool) {
		case TOOL_GOURMETRAY:
			points.add(new Point(e.getX(), e.getY()));
			break;

		default:
			break;
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}

}
