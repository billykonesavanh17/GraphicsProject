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
import ctec.view.GraphPanel;

public class DrawingPanel extends JPanel
{
	private GraphicsController baseController;
	private ShapePanel shapePanel;
	private GraphPanel graphPanel;
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
		graphPanel = new GraphPanel();
		graphPanel.setBackground(Color.GRAY);
		this.add(graphPanel);
	}
	
	public void setupLayout()
	{		
	baseLayout.putConstraint(SpringLayout.SOUTH, graphPanel, -114, SpringLayout.SOUTH, this);
	baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 6, SpringLayout.EAST, graphPanel);
	baseLayout.putConstraint(SpringLayout.NORTH, graphPanel, 10, SpringLayout.NORTH, this);
	baseLayout.putConstraint(SpringLayout.WEST, graphPanel, 10, SpringLayout.WEST, this);
	baseLayout.putConstraint(SpringLayout.EAST, graphPanel, -221, SpringLayout.EAST, this);
	baseLayout.putConstraint(SpringLayout.EAST, drawPolygonButton, 0, SpringLayout.EAST, shapePanel);
	baseLayout.putConstraint(SpringLayout.NORTH, drawRectangleButton, 6, SpringLayout.SOUTH, shapePanel);
	baseLayout.putConstraint(SpringLayout.WEST, drawRectangleButton, 0, SpringLayout.WEST, shapePanel);
	baseLayout.putConstraint(SpringLayout.WEST, drawEllipseButton, 0, SpringLayout.WEST, shapePanel);
	baseLayout.putConstraint(SpringLayout.WEST, drawTriangleButton, 0, SpringLayout.WEST, shapePanel);
	baseLayout.putConstraint(SpringLayout.EAST, shapePanel, -10, SpringLayout.EAST, this);
	baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, -114, SpringLayout.SOUTH, this);
	baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 10, SpringLayout.NORTH, this);
	baseLayout.putConstraint(SpringLayout.NORTH, drawCircleButton, 0, SpringLayout.NORTH, drawRectangleButton);
	baseLayout.putConstraint(SpringLayout.WEST, drawCircleButton, 6, SpringLayout.EAST, drawRectangleButton);
	baseLayout.putConstraint(SpringLayout.NORTH, drawTriangleButton, 6, SpringLayout.SOUTH, drawRectangleButton);
	baseLayout.putConstraint(SpringLayout.NORTH, drawSquareButton, 0, SpringLayout.NORTH, drawTriangleButton);
	baseLayout.putConstraint(SpringLayout.WEST, drawSquareButton, 0, SpringLayout.WEST, drawPolygonButton);
	baseLayout.putConstraint(SpringLayout.NORTH, clearButton, 0, SpringLayout.NORTH, drawPolygonButton);
	baseLayout.putConstraint(SpringLayout.EAST, clearButton, -6, SpringLayout.WEST, drawEllipseButton);
	baseLayout.putConstraint(SpringLayout.NORTH, drawPolygonButton, 0, SpringLayout.NORTH, drawEllipseButton);
	baseLayout.putConstraint(SpringLayout.NORTH, drawEllipseButton, 5, SpringLayout.SOUTH, drawTriangleButton);
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
		
		drawCircleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addCircle();
				repaint();
			}
		});
		
	}
	
	@Override
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		Graphics2D mainGraphics = (Graphics2D)currentGraphics;
		
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
