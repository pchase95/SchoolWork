import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class RatePane extends JPanel implements ActionListener
{
	private JFrame f;
	private Item item;
	
	private JButton rate = new JButton("Leave Rating");
	
	private ButtonGroup group = new ButtonGroup();
	private JRadioButton pepe1 = new JRadioButton("1 Pepe");
	private JRadioButton pepe2 = new JRadioButton("2 Pepes");
	private JRadioButton pepe3 = new JRadioButton("3 Pepes");
	private JRadioButton pepe4 = new JRadioButton("4 Pepes");
	private JRadioButton pepe5 = new JRadioButton("5 Pepes");
	
	public RatePane(Item i)
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		item = i;
		f = new JFrame("Leave a Rating");
		f.setVisible(true);
		f.setSize(400, 600);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel p = new JPanel();
		p.setBackground(Main.bGroundColor);
		p.setLayout(new BorderLayout());
		
		GridLayout glay = new GridLayout(5, 1);
		JPanel g = new JPanel();
		g.setLayout(glay);
		
		group.add(pepe1);
		group.add(pepe2);
		group.add(pepe3);
		group.add(pepe4);
		group.add(pepe5);
		
		g.add(pepe1);
		g.add(pepe2);
		g.add(pepe3);
		g.add(pepe4);
		g.add(pepe5);
		
		pepe1.setFont(Main.font3);
		pepe2.setFont(Main.font3);
		pepe3.setFont(Main.font3);
		pepe4.setFont(Main.font3);
		pepe5.setFont(Main.font3);
		rate.setFont(Main.font2);
		
		pepe1.addActionListener(this);
		pepe2.addActionListener(this);
		pepe3.addActionListener(this);
		pepe4.addActionListener(this);
		pepe5.addActionListener(this);
		rate.addActionListener(this);
		
		p.add(g, BorderLayout.CENTER);
		p.add(rate, BorderLayout.SOUTH);
		
		f.add(p);
	}
	
	
	
	public void actionPerformed(ActionEvent h)
	{
		if(h.getSource() == rate)
		{
			if(pepe1.isSelected())
			{
				item.setRating(1);
			}
			if(pepe2.isSelected())
			{
				item.setRating(2);
			}
			if(pepe3.isSelected())
			{
				item.setRating(3);
			}
			if(pepe4.isSelected())
			{
				item.setRating(4);
			}
			if(pepe5.isSelected())
			{
				item.setRating(5);
			}
			Main.WriteFile();
			f.dispose();
		}
	}
}
