package ctec.view;

import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class GraphPanel extends JPanel
{
	private int [] graphSource;
	private ArrayList<Rectangle> rectangleList;
	
	public GraphPanel()
	{
		//Initialize graphSource here
		rectangleList = new ArrayList<Rectangle>();
	}
	
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		for(int index = 0; index < graphSource.length; index++)
		{
			//Draw a rectangle for each value in the array
			//Height constant, width value array
			int xPosition = (int)(0);
			int yPosition = (int)(getHeight());
			int width = (int)(index * 100);
			int height = (int)(100);
			
			Rectangle rectangle = new Rectangle(xPosition, yPosition, width, height);
			rectangleList.add(rectangle);
		}
	}
}
