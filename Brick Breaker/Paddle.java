import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Paddle implements KeyListener
{
	private int x = 0;
	private int y = 0;
	private int xVel = 0;
	private ImageIcon wallet = new ImageIcon(getClass().getResource("wallet.jpg"));
	
	public Paddle()
	{
		x = 305;
		y = 740;
	}
	
	public int getX()
	{
		return x;
	}

	public void paintPaddle(Graphics g)
	{
		updatePosition();
		wallet.paintIcon(CSLauncher.f, g, x, y);
	}

	private void updatePosition()
	{
		x = x + xVel;

		if(x > 630)
		{
			x = 630;
		}
		if(x < 0)
		{
			x = 0;
		}
	}

	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			xVel = -20;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			xVel = 20;
		}
	}
	public void keyReleased(KeyEvent e)
	{
		xVel = 0;
	}
	public void keyTyped(KeyEvent e)
	{}
}