import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class CSLauncher extends JPanel implements ActionListener, MouseListener
{
	private Paddle paddle = new Paddle();
	private Ball ball = new Ball();
	private int x = -20; int y = 0;
	private Brick[] brix = new Brick[15];
	private maps map = new maps();
	private ImageIcon background = new ImageIcon(getClass().getResource("background.jpg"));
	private ImageIcon menu = new ImageIcon(getClass().getResource("menu.jpg"));
	private ImageIcon playButton = new ImageIcon(getClass().getResource("playButton.jpg"));
	private ImageIcon quitButton = new ImageIcon(getClass().getResource("quitButton.png"));
	private ImageIcon defeat = new ImageIcon(getClass().getResource("defeat.jpg"));
	private ImageIcon victory = new ImageIcon(getClass().getResource("victory.jpg"));
	
	private AudioClip menuTheme = Applet.newAudioClip(getClass().getResource("menu.wav"));
	private AudioClip preRound= Applet.newAudioClip(getClass().getResource("preRound.wav"));
	private AudioClip ezpz= Applet.newAudioClip(getClass().getResource("ezpz.wav"));
	
	private Font myFont = new Font("AR ESSENCE", Font.PLAIN, 40);
	public static JFrame f = new JFrame("CSGO Simulator");
	private boolean quit = false;
	private int play = 1;
	private int x1 = 25, y1 = 80;
	private int x2 = 25, y2 = 150;
	private int x3 = 25, y3 = 20;
	private int x4 = 25, y4 = 90;
	private int x5 = 250, y5 = 30;
	private int x6 = 350, y6 = 745;


	public static void main(String[] args)
	{
		f.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		f.setSize(772, 856); //750 * 850
		f.add(new CSLauncher());
		f.setVisible(true);
	}
              
	public CSLauncher()
	{
		int k = 0;
		for(int i = 0; i < 3; i++)
		{
			x = -20;
			for(int j = 0; j < 5; j++)
			{
				brix[k] = new Brick(x, y);
				k++;
				x = x + 150;
			}
			y = y + 100;
		}
		ball.addBrickArray(brix);
		
		setFocusable(true);
		addMouseListener(this);
		addKeyListener(paddle);
		addKeyListener(ball);
		ball.addPaddle(paddle);
		addBall(ball);
		Timer t = new Timer(16, this);
		t.start();
		menuTheme.loop();
	}
		
	private void addBall(Ball b)
	{
		ball = b;
	}

	
	public void paintComponent(Graphics g)
	{
		int a = 0;
		if(play == 2)
		{
			g.setFont(myFont);
			g.setColor(Color.red);
			menuTheme.stop();
			background.paintIcon(this, g, 0, 0);

			if(ball.getStart() == 1)
			{
				preRound.stop();
			}
			
			for(int i = 0; i < 3; i++)
			{
				for(int j = 0; j < 5; j++)
				{
					if(ball.getHit1(a) > 0)
						brix[a].paintBrick(g, map.getLvl1(i , j));
					a++;
				}
			}	

			paddle.paintPaddle(g);
			if(ball.getStart() != 2)
			{
				if(ball.getBalls() > 0)
					g.drawString("Money: $" + ball.getBalls() + "0", 30, 750);
				else
					g.drawString("Last Key!", 30, 750);
				ball.paintBall(g);
			}
			if(ball.getStart() == 0)
			{
				g.drawString("Press Space to Start", 30, 420);
			}
			if(ball.getStart() == 2)
			{
				play = 3;
			}
			
			if(ball.getBrix1() == 30)
			{
				ezpz.play();
				play = 4;
			}
		}
		
		if(play == 4)
		{
			victory.paintIcon(this, g, 0, 0);
			g.setColor(Color.red);
			g.setFont(myFont);
			g.drawString("EZ PZ Lemon SqueeZ", 210, 150);
			quitButton.paintIcon(this, g, x6, y6);
		}
		
		if(play == 3)
		{
			defeat.paintIcon(this, g, 0, 0);
			g.setColor(Color.red);
			g.setFont(myFont);
			g.drawString("GG EZ Scrubs", 500, 350);
			quitButton.paintIcon(this, g, x4, y4);
		}
		
		if(play == 1)
		{
			menu.paintIcon(this, g, 0, 0);
			g.setColor(Color.red);
			g.setFont(myFont);
			g.drawString("Welcome to CSGO Simulator", 25, 50);
			playButton.paintIcon(this, g, x1, y1);
			quitButton.paintIcon(this, g, x2, y2);
		}
	}

	public void actionPerformed(ActionEvent e)
	{
		repaint();
		if(quit == true)
		{
			System.exit(0);
		}
	}
	
	public void mousePressed(MouseEvent e)
	{
		if(play == 1)
		{
			//play
			if(e.getX() >= x1 && e.getX() <= x1+239 &&
			e.getY() >= y1 && e.getY() <= y1+55)
			{
				play = 2;
				preRound.play();
			}
			
			//quit
			if(e.getX() >= x2 && e.getX() <= x2+70 &&
			e.getY() >= y2 && e.getY() <= y2+55)
			{
				quit = true;
			}
		}
		
		if(play == 3)
		{
			
			//quit
			if(e.getX() >= x4 && e.getX() <= x4+70 &&
			e.getY() >= y4 && e.getY() <= y4+55)
			{
				quit = true;
			}
		}
		
		if(play == 4)
		{
			
			//quit
			if(e.getX() >= x6 && e.getX() <= x6+70 &&
			e.getY() >= y6 && e.getY() <= y6+55)
			{
				quit = true;
			}
		}
	}
	public void mouseReleased(MouseEvent e){}
	public void mouseClicked(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
}