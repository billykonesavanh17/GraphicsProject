package ctec.view;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Rectangle;

public class GraphPanel extends JPanel
{
	private int [] graphSource;
	
	public GraphPanel()
	{
		//Initialize graphSource here
	}
	
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		for(int index = 0; index < graphSource.length; index++)
		{
			//Draw a rectangle for each value in the array
			//Height constant, width value array
		}
	}
}
