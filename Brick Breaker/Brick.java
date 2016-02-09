import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Brick
{
	private maps map = new maps();
	
	private int x = 0;
	private int y = 0;
	private int pos = 0;
	private ImageIcon case1;

					 
	public Brick(int xPos, int yPos)
	{
		x = xPos;
		y = yPos;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void paintBrick(Graphics g, int a)
	{
		pos = a;
		updatePosition();
		case1.paintIcon(CSLauncher.f, g, x, y);
	}
	
	public void updatePosition()
	{
		if(pos == 1)
			case1 = new ImageIcon(getClass().getResource("case1.png"));
		if(pos == 2)
			case1 = new ImageIcon(getClass().getResource("case2.png"));
		if(pos == 3)
			case1 = new ImageIcon(getClass().getResource("case3.png"));
	}
}