import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

@SuppressWarnings("serial")
public class StaffLogin extends JPanel implements ActionListener
{
	
	private JFrame f;
	private JTextField user = new JTextField("username");
	private JTextField pass = new JTextField("password");
	private String inUser = "";
	private String inPass = "";
	private String realUser = "";
	private String realPass = "";
	private JButton go = new JButton("ENTER");
	private JButton goBack = new JButton("Return");

	
	private boolean loggedIn;
	
	
	public StaffLogin()
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		f = new JFrame("Staff Login");
		f.setVisible(true);
		f.setSize(500, 225);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel p = new JPanel();
		p.setBackground(Main.bGroundColor);
		
		FlowLayout flay = new FlowLayout();
		p.setLayout(flay);
		
		user.setColumns(30);
		pass.setColumns(30);
		
		p.add(user);
		p.add(pass);
		p.add(go);
		p.add(goBack);
		
		go.addActionListener(this);
		goBack.addActionListener(this);
		f.add(p);
	}

	
	public void newPass()
	{
		try
		{
			PrintWriter makePass = new PrintWriter(Main.passFile);
			makePass.println(inUser + "; " + inPass);			
			makePass.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void getPass() throws Exception
	{
		String line = "";
		if(Main.passFile.exists())
		{
			@SuppressWarnings("resource")
			Scanner reader = new Scanner(Main.passFile);
			line = reader.nextLine();
			String[] part = line.split("; ");
			realUser = part[0];
			realPass = part[1];
		}
	}
	
	public boolean getLoggedIn()
	{
		return loggedIn;
	}
	
	public void actionPerformed(ActionEvent b)
	{
		if(b.getSource() == goBack)
		{
			new LoginMenu();
			f.dispose();
		}
		if(b.getSource() == go)
		{
			inUser = user.getText();
			inPass = pass.getText();
			if(!Main.passFile.exists())
			{
				newPass();
				JOptionPane.showMessageDialog(f, "Username and Password successfully created");
				loggedIn = true;
			}
			else
			{
				try
				{
					getPass();
				}
				catch (Exception e)
				{
					JOptionPane.showMessageDialog(f, "File not Found");
				}
				if(inUser.equals(realUser) && inPass.equals(realPass))
				{
					loggedIn = true;
				}
				else
				{
					loggedIn = false;
				}

			}
			if(getLoggedIn())
			{
				new StaffMenu();
				f.dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(f, "Wrong Username/Password");
			}
				
		}
	}
	
	
	
	
}
