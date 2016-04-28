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
	private JButton drawEllipseButton;
	private JButton drawRectangleButton;
	private JButton drawTriangleButton;
	private JButton drawPolygonButton;
	private JButton clearButton;
	private SpringLayout baseLayout;
	
	private ArrayList<Rectangle> rectangleList;
	
	public DrawingPanel(GraphicsController baseController)
	{
		this.baseController = baseController;
		rectangleList = new ArrayList<Rectangle>();
		baseLayout = new SpringLayout();
		drawCircleButton = new JButton("Circle");
		drawEllipseButton = new JButton("Eclipse");
		drawTriangleButton = new JButton("Triangle");
		drawPolygonButton = new JButton("Polygon");
		baseLayout.putConstraint(SpringLayout.EAST, drawEllipseButton, -28, SpringLayout.WEST, drawPolygonButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, drawPolygonButton, -10, SpringLayout.SOUTH, this);
		clearButton = new JButton("clear");
		baseLayout.putConstraint(SpringLayout.NORTH, clearButton, 38, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, clearButton, 10, SpringLayout.WEST, this);
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	public void setupPanel()
	{
		this.setLayout(baseLayout);
		drawRectangleButton = new JButton("Rectangle");
		baseLayout.putConstraint(SpringLayout.NORTH, drawEllipseButton, 0, SpringLayout.NORTH, drawRectangleButton);
		baseLayout.putConstraint(SpringLayout.EAST, drawPolygonButton, -53, SpringLayout.WEST, drawRectangleButton);
		baseLayout.putConstraint(SpringLayout.NORTH, drawRectangleButton, 0, SpringLayout.NORTH, drawPolygonButton);
		baseLayout.putConstraint(SpringLayout.EAST, drawRectangleButton, -21, SpringLayout.EAST, this);
		this.add(drawRectangleButton);
		shapePanel = new ShapePanel();
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 33, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, -27, SpringLayout.NORTH, drawRectangleButton);
		shapePanel.setBackground(Color.WHITE);
		this.add(shapePanel);
		this.add(drawPolygonButton);
		this.add(clearButton);
		this.add(drawEllipseButton);
	}
	
	public void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 117, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, -103, SpringLayout.EAST, this);
	}
	
	public void setupListeners()
	{
		drawRectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addTriangle();
				repaint();
			}
		});
		
		drawPolygonButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addPolygon();
				repaint();
			}
		});
		
		clearButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.clear();
			}
		});
		
		drawEllipseButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addEllipse();
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
