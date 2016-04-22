package ctec.view;

import javax.swing.JFrame;

import ctec.controller.GraphicsController;

public class ShapeFrame extends JFrame
{
	private GraphicsController baseController;
	private DrawingPanel basePanel;
	
	public ShapeFrame(GraphicsController baseController)
	{
		this.baseController = baseController;
		basePanel = new DrawingPanel(baseController);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(575,400);
		this.setTitle("Graphics");
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public GraphicsController getBaseController()
	{
		return baseController;
	}

}