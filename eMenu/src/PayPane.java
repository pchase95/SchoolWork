import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

@SuppressWarnings("serial")
public class PayPane extends JPanel implements ActionListener
{
	private JFrame f;
	private JLabel totalLabel = new JLabel();
	private JButton ok = new JButton("OK");
	private JButton goBack = new JButton("Go Back");
	private NumberFormat money = NumberFormat.getCurrencyInstance();
	
	public PayPane(double d)
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		f = new JFrame("Pay");
		f.setSize(300, 200);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel p = new JPanel();
		p.setBackground(Main.bGroundColor);
		p.setLayout(new BorderLayout());
		
		GridLayout glay = new GridLayout(1, 2);
		JPanel grid = new JPanel();
		grid.setLayout(glay);
		
		grid.add(goBack);
		grid.add(ok);
		
		totalLabel.setText("Total: " + money.format(d));
		totalLabel.setFont(Main.font3);
		totalLabel.setPreferredSize(new Dimension(600, 300));
		totalLabel.setAlignmentY(CENTER_ALIGNMENT);
		
		p.add(grid, BorderLayout.SOUTH);
		p.add(totalLabel, BorderLayout.CENTER);
		
		ok.addActionListener(this);
		goBack.addActionListener(this);
		
		f.add(p);
	}
	
	
	public void actionPerformed(ActionEvent i)
	{
		if(i.getSource() == goBack)
		{
			new ItemCart();
			f.dispose();
		}
		if(i.getSource() == ok)
		{
			new StaffCheckout();
		}
	}
	
}
