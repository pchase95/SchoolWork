import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.AudioClip;
import java.applet.Applet;

public class CellPanel extends JPanel implements MouseListener
{
	private int a1 = 0;
	private int a2 = 0;
	private int a3 = 0;
	private int b1 = 0;
	private int b2 = 0;
	private int b3 = 0;
	private int c1 = 0;
	private int c2 = 0;
	private int c3 = 0;
	private int x = 0;
	private int y = 0;
	private boolean turn = true;
	private boolean victory = false;
	private String victor = "";
	private Font myFont = new Font("SansSerif", Font.ITALIC, 30);
	private ImageIcon hotDog = new ImageIcon(getClass().getResource("america.png"));
	private ImageIcon bernieWins = new ImageIcon(getClass().getResource("bernieWins.jpg"));
	private ImageIcon trumpWins = new ImageIcon(getClass().getResource("trumpWins.jpg"));
	private ImageIcon trump2016 = new ImageIcon(getClass().getResource("trump2016.jpg"));
	private ImageIcon bernieFlag = new ImageIcon(getClass().getResource("bernieFlag.jpg"));
	private ImageIcon trumpFlag = new ImageIcon(getClass().getResource("trumpFlag.jpg"));
	private ImageIcon feelBurn = new ImageIcon(getClass().getResource("feelBurn.png"));
	private ImageIcon donkey = new ImageIcon(getClass().getResource("donkey.png"));
	private ImageIcon playButton = new ImageIcon(getClass().getResource("playButton.jpg"));
	private ImageIcon elephant = new ImageIcon(getClass().getResource("elephant.png"));
	private ImageIcon donkeyBig = new ImageIcon(getClass().getResource("donkeyBig.png"));
	private ImageIcon elephantBig = new ImageIcon(getClass().getResource("elephantBig.png"));
	private ImageIcon bernie = new ImageIcon(getClass().getResource("bernieFace.png"));
	private ImageIcon trump = new ImageIcon(getClass().getResource("trumpFace.png"));
	private ImageIcon berniePose = new ImageIcon(getClass().getResource("berniePose.jpg"));
	private ImageIcon trumpPose = new ImageIcon(getClass().getResource("trumpPose.jpg"));
	private AudioClip wall = Applet.newAudioClip(getClass().getResource("BUILD A WALL.wav"));
	private AudioClip youth = Applet.newAudioClip(getClass().getResource("youth.wav"));
	private AudioClip bernieTheme = Applet.newAudioClip(getClass().getResource("bernieTheme.wav"));
	private AudioClip trumpTheme = Applet.newAudioClip(getClass().getResource("trumpTheme.wav"));
	private boolean start = false;

	public CellPanel()
	{
		addMouseListener(this);
	}

	public void paintComponent(Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect(0, 0, 600, 900);
		x = 0;
		y = 0;
		g.setColor(Color.black);
		g.setFont(myFont);
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				hotDog.paintIcon(this, g, x, y);
				x = x + 200;
			}
			x = 0;
			y = y + 200;
		}

		if(a1 == 1)
		{
			g.setColor(Color.white);
			g.fillRect(0, 0, 200, 200);
			elephant.paintIcon(this, g, 0, 0);
		}
		if(a2 == 1)
		{
			g.setColor(Color.white);
			g.fillRect(200, 0, 200, 200);
			elephant.paintIcon(this, g, 200, 0);
		}
		if(a3 == 1)
		{
			g.setColor(Color.white);
			g.fillRect(400, 0, 200, 200);
			elephant.paintIcon(this, g, 400, 0);
		}
		if(b1 == 1)
		{
			g.setColor(Color.white);
			g.fillRect(0, 200, 200, 200);
			elephant.paintIcon(this, g, 0, 200);
		}
		if(b2 == 1)
		{
			g.setColor(Color.white);
			g.fillRect(200, 200, 200, 200);
			elephant.paintIcon(this, g, 200, 200);
		}
		if(b3 == 1)
		{
			g.setColor(Color.white);
			g.fillRect(400, 200, 200, 200);
			elephant.paintIcon(this, g, 400, 200);
		}
		if(c1 == 1)
		{
			g.setColor(Color.white);
			g.fillRect(0, 400, 200, 200);
			elephant.paintIcon(this, g, 0, 400);
		}
		if(c2 == 1)
		{
			g.setColor(Color.white);
			g.fillRect(200, 400, 200, 200);
			elephant.paintIcon(this, g, 200, 400);
		}
		if(c3 == 1)
		{
			g.setColor(Color.white);
			g.fillRect(400, 400, 200, 200);
			elephant.paintIcon(this, g, 400, 400);
		}

		if(a1 == 2)
		{
			g.setColor(Color.white);
			g.fillRect(0, 0, 200, 200);
			donkey.paintIcon(this, g, 0, 0);
		}
		if(a2 == 2)
		{
			g.setColor(Color.white);
			g.fillRect(200, 0, 200, 200);
			donkey.paintIcon(this, g, 200, 0);
		}
		if(a3 == 2)
		{
			g.setColor(Color.white);
			g.fillRect(400, 0, 200, 200);
			donkey.paintIcon(this, g, 400, 0);
		}
		if(b1 == 2)
		{
			g.setColor(Color.white);
			g.fillRect(0, 200, 200, 200);
			donkey.paintIcon(this, g, 0, 200);
		}
		if(b2 == 2)
		{
			g.setColor(Color.white);
			g.fillRect(200, 200, 200, 200);
			donkey.paintIcon(this, g, 200, 200);
		}
		if(b3 == 2)
		{
			g.setColor(Color.white);
			g.fillRect(400, 200, 200, 200);
			donkey.paintIcon(this, g, 400, 200);
		}
		if(c1 == 2)
		{
			g.setColor(Color.white);
			g.fillRect(0, 400, 200, 200);
			donkey.paintIcon(this, g, 0, 400);
		}
		if(c2 == 2)
		{
			g.setColor(Color.white);
			g.fillRect(200, 400, 200, 200);
			donkey.paintIcon(this, g, 200, 400);
		}
		if(c3 == 2)
		{
			g.setColor(Color.white);
			g.fillRect(400, 400, 200, 200);
			donkey.paintIcon(this, g, 400, 400);
		}

		if(turn == true)
		{
			trumpFlag.paintIcon(this, g, 0, 600);
			g.setColor(Color.orange);
			g.fillOval(170, 620, 260, 260);
			trump.paintIcon(this, g, 175, 625);
			if(victor == "Bernie")
			{
				g.setColor(Color.white);
				g.fillRect(0, 0, 600, 900);
				feelBurn.paintIcon(this, g, 0, 450);
				bernieWins.paintIcon(this, g, 0, 0);
			}
		}
		if(turn == false)
		{
			bernieFlag.paintIcon(this, g, 0, 600);
			g.setColor(Color.white);
			g.fillOval(170, 620, 260, 260);
			bernie.paintIcon(this, g, 175, 625);
			if(victor == "Trump")
			{
				g.setColor(Color.white);
				g.fillRect(0, 0, 600, 900);
				trump2016.paintIcon(this, g, 0, 450);
				trumpWins.paintIcon(this, g, 0, 0);
			}
		}

		if(start == false)
		{

			trumpPose.paintIcon(this, g, 0, 300);
			berniePose.paintIcon(this, g, 300, 300);
			g.setColor(Color.black);
			g.fillRect(0, 0, 600, 300);
			elephantBig.paintIcon(this, g, 0, 0);
			donkeyBig.paintIcon(this, g, 300, 0);
			playButton.paintIcon(this, g, 0, 600);
		}
		repaint();
	}


	public void mousePressed(MouseEvent e)
	{
		youth.stop();
		wall.stop();
		if(turn == true)
		{
			if(e.getX() >= 0 && e.getX() <= 200 &&
			e.getY() >= 0 && e.getY() <= 200)
			{
				a1 = 1;
			}
			if(e.getX() >= 200 && e.getX() <= 400 &&
			e.getY() >= 0 && e.getY() <= 200)
			{
				a2 = 1;
			}
			if(e.getX() >= 400 && e.getX() <= 600 &&
			e.getY() >= 0 && e.getY() <= 200)
			{
				a3 = 1;
			}
			if(e.getX() >= 0 && e.getX() <= 200 &&
			e.getY() >= 200 && e.getY() <= 400)
			{
				b1 = 1;
			}
			if(e.getX() >= 200 && e.getX() <= 400 &&
			e.getY() >= 200 && e.getY() <= 400)
			{
				b2 = 1;
			}
			if(e.getX() >= 400 && e.getX() <= 600 &&
			e.getY() >= 200 && e.getY() <= 400)
			{
				b3 = 1;
			}
			if(e.getX() >= 0 && e.getX() <= 200 &&
			e.getY() >= 400 && e.getY() <= 600)
			{
				c1 = 1;
			}
			if(e.getX() >= 200 && e.getX() <= 400 &&
			e.getY() >= 400 && e.getY() <= 600)
			{
				c2 =1;
			}
			if(e.getX() >= 400 && e.getX() <= 600 &&
			e.getY() >= 400 && e.getY() <= 600)
			{
				c3 = 1;
			}
			if(e.getX() >= 0 && e.getX() <= 600 &&
			e.getY() >= 600 && e.getY() <= 900)
			{
				start = true;
			}
		}

		if(turn == false)
		{
			if(e.getX() >= 0 && e.getX() <= 200 &&
			e.getY() >= 0 && e.getY() <= 200)
			{
				a1 = 2;
			}
			if(e.getX() >= 200 && e.getX() <= 400 &&
			e.getY() >= 0 && e.getY() <= 200)
			{
				a2 = 2;
			}
			if(e.getX() >= 400 && e.getX() <= 600 &&
			e.getY() >= 0 && e.getY() <= 200)
			{
				a3 = 2;
			}
			if(e.getX() >= 0 && e.getX() <= 200 &&
			e.getY() >= 200 && e.getY() <= 400)
			{
				b1 = 2;
			}
			if(e.getX() >= 200 && e.getX() <= 400 &&
			e.getY() >= 200 && e.getY() <= 400)
			{
				b2 = 2;
			}
			if(e.getX() >= 400 && e.getX() <= 600 &&
			e.getY() >= 200 && e.getY() <= 400)
			{
				b3 = 2;
			}
			if(e.getX() >= 0 && e.getX() <= 200 &&
			e.getY() >= 400 && e.getY() <= 600)
			{
				c1 = 2;
			}
			if(e.getX() >= 200 && e.getX() <= 400 &&
			e.getY() >= 400 && e.getY() <= 600)
			{
				c2 = 2;
			}
			if(e.getX() >= 400 && e.getX() <= 600 &&
			e.getY() >= 400 && e.getY() <= 580)
			{
				c3 = 2;
			}
		}
	}
	public void mouseReleased(MouseEvent e)
	{
		checkVictory();
		repaint();
		if(turn == false)
		{
			wall.play();
		}
		if(turn == true)
		{
			youth.play();
		}
		turn = !turn;

	}
	public void checkVictory()
	{
		if(a1 == 1 && a2 == 1 && a3 == 1
		|| b1 == 1 && b2 == 1 && b3 == 1
		|| c1 == 1 && c2 == 1 && c3 == 1
		|| a1 == 1 && b1 == 1 && c1 == 1
		|| a2 == 1 && b2 == 1 && c2 == 1
		|| a3 == 1 && b3 == 1 && c3 == 1
		|| a1 == 1 && b2 == 1 && c3 == 1
		|| a3 == 1 && b2 == 1 && c1 == 1)
		{
			victory = true;
			victor = "Trump";
			trumpTheme.play();
			System.out.println(victor + " wins");
		}
		if(a1 == 2 && a2 == 2 && a3 == 2
		|| b1 == 2 && b2 == 2 && b3 == 2
		|| c1 == 2 && c2 == 2 && c3 == 2
		|| a1 == 2 && b1 == 2 && c1 == 2
		|| a2 == 2 && b2 == 2 && c2 == 2
		|| a3 == 2 && b3 == 2 && c3 == 2
		|| a1 == 2 && b2 == 2 && c3 == 2
		|| a3 == 2 && b2 == 2 && c1 == 2)
		{
			victory = true;
			victor = "Bernie";
			bernieTheme.play();
			System.out.println(victor + " wins");
		}
	}
	public void mouseClicked(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
}
