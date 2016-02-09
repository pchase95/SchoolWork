import javax.swing.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class Ball implements KeyListener
{
	private AudioClip roundStart = Applet.newAudioClip(getClass().getResource("roundStart.wav"));
	private AudioClip roundEnd = Applet.newAudioClip(getClass().getResource("roundEnd.wav"));
	private AudioClip ak47 = Applet.newAudioClip(getClass().getResource("ak47.wav"));
	private AudioClip headshot = Applet.newAudioClip(getClass().getResource("headshot.wav"));
	private AudioClip bounce = Applet.newAudioClip(getClass().getResource("bounce.wav"));
	
	private maps map = new maps();
	
	private int x = 0;
	private int y = 0;
	private int xVel = 0;
	private int xVel2 = -10;
	private int yVel = 0;
	private int yVel2 = -10;
	private int xSpeed = 10;
	private int ySpeed = 10;
	private double balls = 7.50;
	private Paddle paddle;
	private Brick[] bricks;
	private ImageIcon key = new ImageIcon(getClass().getResource("key.png"));
	private int start = 0;
	private int hit1[] = new int[15];
	private int brix1 = 0;

	public Ball()
	{
		int a = 0;
		x = 175;
		y = 445;
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				if(map.getLvl1(i, j) == 1)
					hit1[a] = 1;
				if(map.getLvl1(i, j) == 2)
					hit1[a] = 2;
				if(map.getLvl1(i, j) == 3)
					hit1[a] = 3;
				a++;
			}
		}
	}
	
	public void addBrickArray(Brick[] b)
	{
		bricks = b;
	}
	
	public void addPaddle(Paddle p)
	{
		paddle = p;
	}
	
	public void paintBall(Graphics g)
	{
		updatePosition();
		key.paintIcon(CSLauncher.f, g, x - 25, y - 25);
	}
	
	public int getStart()
	{
		return start;
	}
	
	public double getBalls()
	{
		return balls;
	}
	
	public int getHit1(int k)
	{
		return hit1[k];
	}
	
	public int getBrix1()
	{
		return brix1;
	}

	private void updatePosition()
	{
		x = x + xVel;
		y = y + yVel;

		if(x < 10)
		{
			xVel = Math.abs(xVel);
			x = 10;
			bounce.play();
		}
		if(y < 18)
		{
			yVel = Math.abs(yVel);
			y = 18;
			bounce.play();
		}
		if(x > 740)
		{
			xVel = xVel2;
			x = 740;
			bounce.play();
		}
		if(y > 725)
		{
			if(x >= paddle.getX() - 20 && x < paddle.getX() + 170 && balls >= 0)
			{
				if(x >= paddle.getX() - 20 && x < paddle.getX() + 80)
				{
					xVel = xVel2;
				}
				else
				{
					xVel = xSpeed;
				}
				y = 725;
				{
					yVel = -Math.abs(yVel);
				}
				ak47.play();
			}
			else if(balls > 0)
			{
				x = 175;
				y = 445;
				xVel = 0;
				yVel = 0;
				balls = balls - 2.50;
				start = 0;
				roundStart.stop();
				roundEnd.play();
			}
			else
			{
				x = 100;
				y = 100;
				xVel = 0;
				yVel = 0;
				start = 2;
				roundStart.stop();
			}
		}
		for(int i = 0; i < bricks.length; i++)
		{
			if(x >= bricks[i].getX() && x <= bricks[i].getX() + 200
			&& y >= bricks[i].getY() && y <= bricks[i].getY() + 150
			&& hit1[i] > 0)
			{
				if(yVel == ySpeed)
					yVel = yVel2;
				else if(yVel == yVel2)
					yVel = ySpeed;
				if(xVel == xVel2)
					xVel = xSpeed;
				else if(xVel == xSpeed)
					xVel = xVel2;
				hit1[i]--;
				brix1++;
				headshot.play();
			}
		}
	}
	
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			if(start == 0)
			{
				xVel = 10;
				yVel = 10;
				start = 1;
				roundEnd.stop();
				roundStart.play();
			}
		}
	}
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}
}