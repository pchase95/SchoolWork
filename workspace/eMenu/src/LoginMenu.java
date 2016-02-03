import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class LoginMenu extends JPanel implements ActionListener
{
	private JLabel welcome = new JLabel("Welcome to eMenu");
	private JButton customer = new JButton("Browse/Order Now");
	private JButton login = new JButton("Staff Login");
	private JPanel pane;
	
	private JFrame f;
	
	public LoginMenu()
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		f = new JFrame("Login");
		f.setVisible(true);
		f.setSize(700, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		p.setBackground(Main.bGroundColor);
		
		pane = new JPanel();
		pane.setPreferredSize(new Dimension(450, 25));
		pane.setBackground(Main.bGroundColor);
		
		p.add(welcome);
		p.add(customer);
		p.add(pane);
		p.add(login);
		welcome.setFont(Main.font3);
		welcome.setPreferredSize(new Dimension(210, 50));
		customer.setPreferredSize(new Dimension(460, 200));
		login.setPreferredSize(new Dimension(460, 75));
		login.addActionListener(this);
		customer.addActionListener(this);
	
		f.add(p);
	}
	
	
	public void actionPerformed(ActionEvent a)
	{
		if(a.getSource() == customer)
		{
			new MainMenu();
			f.dispose();
		}
		if(a.getSource() == login)
		{
			new StaffLogin();
			f.dispose();
		}
	}
}
