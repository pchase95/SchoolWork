import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.awt.*;

@SuppressWarnings("serial")
public class GUI extends JPanel implements ActionListener
{
	private JFrame f;
	private JPanel p = new JPanel();
	private JPanel grid = new JPanel();
	private JButton add = new JButton("Add");
	private JButton	view = new JButton("View");
	private JButton quit = new JButton("QUIT");
	private JLabel intro = new JLabel("WELCOME TO MOVIE DATABASE");
	
	public GUI()
	{
		GridLayout flay = new GridLayout(0, 3);
		grid.setLayout(flay);
		BorderLayout layout = new BorderLayout();
		p.setLayout(layout);
		
		f = new JFrame("StuffStore");
		f.setVisible(true);
		f.setSize(600, 150);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		grid.add(add);
		grid.add(view);
		grid.add(quit);
		
		p.add(intro, BorderLayout.NORTH);
		p.add(grid, BorderLayout.CENTER);
		p.setBackground(Main.back);
		f.add(p);
		add.addActionListener(this);
		view.addActionListener(this);
		quit.addActionListener(this);
	}

	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == add)
		{
			try
			{
				new addPane();
			}
			catch (IOException e1){
				e1.printStackTrace();
			}
		}
		
		if(e.getSource() == view)
		{
			new viewPane();
		}
		
		if(e.getSource() == quit)
		{
			f.dispose();
		}
	}
}

