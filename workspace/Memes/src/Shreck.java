import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Shreck extends JPanel implements ActionListener
{
	private JFrame f;
	private JPanel p;
	private JRadioButton but;
	private boolean bool;
	
	public Shreck()
	{
		bool = true;
		
		f = new JFrame("I Love Shreck");
		f.setVisible(true);
		f.setSize(600, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p = new JPanel();
		p.setBackground(Color.white);
		
		but = new JRadioButton("Color Sitch");
		p.add(but);
		but.addActionListener(this);
		f.add(p);
	}
	
	public static void main(String[] args)
	{
		new Shreck();
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == but)
		{
			bool = !bool;
			if(bool)
				p.setBackground(Color.white);
			else
				p.setBackground(Color.black);
		}
	}
}