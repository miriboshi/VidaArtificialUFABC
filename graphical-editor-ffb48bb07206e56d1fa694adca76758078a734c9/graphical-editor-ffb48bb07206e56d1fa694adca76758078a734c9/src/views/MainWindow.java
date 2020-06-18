package views;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.DrawingEventHandler;
import controller.DrawingTool;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	private DrawingBoard drawingBoard;
	private DrawingEventHandler handler;
	private JMenuBar menuBar;
	private JMenu tools, edit;
	private JMenuItem selectRectangle, selectOval, selectLine, selectGourmetRay, selectPolygon, selectSG, clear, undo,
			redo;

	public MainWindow() {
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.addKeyListener(new KeyboardManager());
		
		drawingBoard = new DrawingBoard();
		drawingBoard.addMouseListener(handler = new DrawingEventHandler(drawingBoard));
		drawingBoard.addMouseMotionListener(handler);
		drawingBoard.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		
		
		setContentPane(drawingBoard);

		menuBar = new JMenuBar();
		tools = new JMenu("Tools");
		{ // Tools components
			{ // Rectangle tool
				selectRectangle = new JMenuItem("Rectangle");
				selectRectangle.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						handler.setDrawingTool(DrawingTool.TOOL_RECTANGLE);
						System.out.println("Drawing rectangles");
					}
				});
			}
			tools.add(selectRectangle);

			{ // Oval tool
				selectOval = new JMenuItem("Oval");
				selectOval.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						handler.setDrawingTool(DrawingTool.TOOL_OVAL);
						System.out.println("Drawing ovals");
					}
				});
			}
			tools.add(selectOval);

			{ // Line tool/
				selectLine = new JMenuItem("Line");
				selectLine.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						handler.setDrawingTool(DrawingTool.TOOL_LINE);
						System.out.println("Drawing lines");
					}
				});
			}
			tools.add(selectLine);

			{ // Gourmet Ray tool
				selectGourmetRay = new JMenuItem("Gourmet Ray");
				selectGourmetRay.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						handler.setDrawingTool(DrawingTool.TOOL_GOURMETRAY);
						System.out.println("Drawing gourmet rays");
					}
				});
			}
			tools.add(selectGourmetRay);

			{ // Polygon tool
				selectPolygon = new JMenuItem("Polygon");
				selectPolygon.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						handler.setDrawingTool(DrawingTool.TOOL_POLYGON);
						System.out.println("Drawing polygons");
					}
				});
			}
			tools.add(selectPolygon);

			{ // SierpinskiGasket tool
				selectSG = new JMenuItem("Sierpinski Gasket");
				selectSG.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						handler.setDrawingTool(DrawingTool.TOOL_SG);
						System.out.println("Drawing Sierpinski Gaskets");
					}
				});
			}
			tools.add(selectSG);

		}
		menuBar.add(tools);

		edit = new JMenu("Edit");
		{
			{ // Clear function
				clear = new JMenuItem("Clear");
				clear.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						drawingBoard.clear();
					}
				});
			}
			edit.add(clear);

			{ // Undo function
				undo = new JMenuItem("Undo");
				undo.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						drawingBoard.undo();
					}
				});

				// AbstractAction undoAction = new AbstractAction() {
				// @Override
				// public void actionPerformed(ActionEvent e) {
				// drawingBoard.undo();
				// }
				// };
				// undo.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_Z,
				// 0), "undo");
				// undo.getActionMap().put("undo", undoAction);
			}
			edit.add(undo);

			{ // Redo function
				redo = new JMenuItem("Redo");
				redo.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						drawingBoard.redo();
					}
				});
			}
			edit.add(redo);

		}
		menuBar.add(edit);

		setJMenuBar(menuBar);

	}

	private class KeyboardManager implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			switch (e.getKeyCode()) {
			case KeyEvent.VK_Z:
				drawingBoard.undo();
				repaint();
				break;

			case KeyEvent.VK_Y:
				drawingBoard.redo();
				repaint();
				break;

			case KeyEvent.VK_N:
				drawingBoard.clear();
				repaint();
				break;
	
			default:
				break;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
