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
	private JButton drawSquareButton;
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
		clearButton = new JButton("clear");
		drawSquareButton = new JButton("Square");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	public void setupPanel()
	{
		this.setLayout(baseLayout);
		drawRectangleButton = new JButton("Rectangle");
		this.add(drawRectangleButton);
		shapePanel = new ShapePanel();
		shapePanel.setBackground(Color.WHITE);
		this.add(shapePanel);
		this.add(drawPolygonButton);
		this.add(clearButton);
		this.add(drawEllipseButton);
		this.add(drawTriangleButton);
		this.add(drawCircleButton);
		this.add(drawSquareButton);
	}
	
	public void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, drawTriangleButton, 0, SpringLayout.NORTH, clearButton);
		baseLayout.putConstraint(SpringLayout.WEST, drawCircleButton, 41, SpringLayout.EAST, clearButton);
		baseLayout.putConstraint(SpringLayout.WEST, clearButton, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, drawCircleButton, 35, SpringLayout.SOUTH, shapePanel);
		baseLayout.putConstraint(SpringLayout.NORTH, clearButton, 23, SpringLayout.SOUTH, shapePanel);
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 37, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, -136, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, -66, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, drawPolygonButton, 6, SpringLayout.SOUTH, drawRectangleButton);
		baseLayout.putConstraint(SpringLayout.NORTH, drawRectangleButton, 0, SpringLayout.NORTH, clearButton);
		baseLayout.putConstraint(SpringLayout.WEST, drawRectangleButton, 17, SpringLayout.EAST, drawTriangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, drawPolygonButton, 62, SpringLayout.EAST, drawCircleButton);
		baseLayout.putConstraint(SpringLayout.WEST, drawTriangleButton, 6, SpringLayout.EAST, drawCircleButton);
		baseLayout.putConstraint(SpringLayout.NORTH, drawEllipseButton, 7, SpringLayout.SOUTH, drawCircleButton);
		baseLayout.putConstraint(SpringLayout.WEST, drawEllipseButton, 104, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, drawSquareButton, 2, SpringLayout.EAST, drawPolygonButton);
		baseLayout.putConstraint(SpringLayout.NORTH, drawSquareButton, 6, SpringLayout.SOUTH, drawRectangleButton);
	}
	
	public void setupListeners()
	{
		drawTriangleButton.addActionListener(new ActionListener()
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
				repaint();
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
		
		drawRectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addRectangle();
				repaint();
			}
		});
		
		drawSquareButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addSquare();
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
