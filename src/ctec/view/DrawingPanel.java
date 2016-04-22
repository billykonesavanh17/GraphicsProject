package ctec.view;

import javax.swing.*;

import ctec.controller.GraphicsController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class DrawingPanel extends JPanel
{
	private GraphicsController baseController;
	private ShapePanel shapePanel;
	private JButton drawCircleButton;
	private JButton drawEclipseButton;
	private JButton drawRectangleButton;
	private JButton drawTriangleButton;
	private JButton drawPentagonButton;
	private SpringLayout baseLayout;
	private ArrayList<Rectangle> rectangleList;
	
	public DrawingPanel(GraphicsController baseController)
	{
		this.baseController = baseController;
		rectangleList = new ArrayList<Rectangle>();
		baseLayout = new SpringLayout();
		drawCircleButton = new JButton("Circle");
		drawEclipseButton = new JButton("Eclipse");
		drawRectangleButton = new JButton("Rectangle");
		drawTriangleButton = new JButton("Triangle");
		drawPentagonButton = new JButton("Pentagon");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	public void setupPanel()
	{
		this.add(drawRectangleButton);
	}
	
	public void setupLayout()
	{
		
	}
	
	public void setupListeners()
	{
		drawRectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				int xPosition = (int)(Math.random() * 600);
				int yPosition = (int)(Math.random() * 600);
				int width = (int)(Math.random() * 50);
				int height = (int)(Math.random() * 50);
				
				rectangleList.add(new Rectangle(xPosition, yPosition, width, height));
				repaint();
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		Graphics2D mainGraphics = (Graphics2D)currentGraphics;
		mainGraphics.setColor(Color.cyan);
		mainGraphics.setStroke(new BasicStroke(15));
		mainGraphics.draw(new Rectangle(90,10,20,40));
		
		for(Rectangle current : rectangleList)
		{
			int randomStroke = (int)(Math.random() * 7);
			int red = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(randomStroke));
			
			mainGraphics.fill(current);
		}
	}

}
