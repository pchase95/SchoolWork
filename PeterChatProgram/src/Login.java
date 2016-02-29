import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.InetAddress;

public class Login extends JPanel implements ActionListener
{
	String ipAddress = "";
	String portNumber = "";
	String name = "";
//	public try{InetAddress IP=InetAddress.getLocalHost();}catch{}
	public JTextField ip = new JTextField(18);
	public JTextField port = new JTextField(2);
	public JTextField nickName = new JTextField(10);
	public JButton login = new JButton("Login");
	private JFrame frame;


	public Login() throws Exception
	{
		//try{InetAddress IP=InetAddress.getLocalHost();}catch{System.out.println("you fucked up");}
		InetAddress IP = InetAddress.getLocalHost();
		frame = new JFrame("Login");
		frame.setResizable(false);
		JPanel panel = new JPanel();
		frame.setSize(350,250);
		frame.add(this);
		frame.setVisible(true);
		this.setFocusable(true);

		setLayout(null);
                setBackground(Main.back_ground);
		add(ip);
		ip.setText(IP.getHostAddress());
		add(port);
		port.setText("21");
		add(nickName);
		nickName.setText("NickName");
		add(login);
		ip.setBounds(120,70,100,20);
		port.setBounds(220,70,20,20);
		nickName.setBounds(120,95,100,20);
		login.setBounds(140,130,70,20);
		login.addActionListener(this);

		//System.out.println("IP of my system is := "+IP.getHostAddress());
	}

	public void actionPerformed(ActionEvent e)
	{
            if(e.getSource() == login)
            {
		ipAddress = ip.getText();
		portNumber = port.getText();
		name = nickName.getText();
                Person p = new Person();
                p.setName(name);
                p.setIP(ipAddress);
                Main.People.add(p);
		//logmein();
		frame.dispose();
                new Chat();
            }

	}

	/*public void logmein()
	{

	}*/
}