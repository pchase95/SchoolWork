import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Calculator extends JPanel implements ActionListener
{
	private JFrame f;
	
	private JButton b0 = new JButton("0");
	private JButton b1 = new JButton("1");
	private JButton b2 = new JButton("2");
	private JButton b3 = new JButton("3");
	private JButton b4 = new JButton("4");
	private JButton b5 = new JButton("5");
	private JButton b6 = new JButton("6");
	private JButton b7 = new JButton("7");
	private JButton b8 = new JButton("8");
	private JButton b9 = new JButton("9");
	
	private JButton add = new JButton("+");
	private JButton sub = new JButton("-");
	private JButton mult = new JButton("x");
	private JButton div = new JButton("÷");
	
	private JButton equal = new JButton("=");
	private JButton clear = new JButton("C");
	
	private Font font = new Font("Calibri", Font.PLAIN, 40);
	private Font font2 = new Font("ARIAL", Font.PLAIN, 35);
	
	private String nums = "";
	private Integer var1 = null;
	private Integer var2 = null;
	private Integer func = null;
	private JTextField hud;
	private int width = 550;
	private int height = 350;
	
	
	public Calculator()
	{
		JPanel p = new JPanel();
		f = new JFrame("Snazzy Calc");
		f.setSize(width, height);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		

		hud = new JTextField(nums);
		
		BorderLayout layout = new BorderLayout();
		p.setLayout(layout);
		
		GridLayout glay = new GridLayout(3, 0, 3, 3);
		JPanel g = new JPanel();
		GridLayout glay2 = new GridLayout(2, 2);
		JPanel g2 = new JPanel();
		GridLayout glay3 = new GridLayout(1, 2);
		JPanel g3 = new JPanel();
		g3.setLayout(glay3);
		
		g.setLayout(glay);
		g.add(b1);
		g.add(b2);
		g.add(b3);
		g.add(b4);
		g.add(b5);
		g.add(b6);
		g.add(b7);
		g.add(b8);
		g.add(b9);
		
		
		g2.setLayout(glay2);
		g2.add(add);
		g2.add(sub);
		g2.add(div);
		g2.add(mult);
		g2.setPreferredSize(new Dimension(200, height));
		
		hud.setPreferredSize(new Dimension(width, 50));
		hud.setEditable(false);
		hud.setFont(font);
		hud.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		//equal.setPreferredSize(new Dimension(width, 100));
		
		g3.add(b0);
		g3.add(clear);
		g3.add(equal);
		
		g3.setPreferredSize(new Dimension(width, 100));
		
		p.add(g, BorderLayout.CENTER);
		p.add(hud, BorderLayout.NORTH);
		p.add(g2, BorderLayout.EAST);
		p.add(g3, BorderLayout.SOUTH);
		
		
		f.add(p);
		f.pack();
		
		b0.setFont(font2);
		b1.setFont(font2);
		b2.setFont(font2);
		b3.setFont(font2);
		b4.setFont(font2);
		b5.setFont(font2);
		b6.setFont(font2);
		b7.setFont(font2);
		b8.setFont(font2);
		b9.setFont(font2);
		add.setFont(font2);
		sub.setFont(font2);
		mult.setFont(font2);
		div.setFont(font2);
		equal.setFont(font2);
		clear.setFont(font2);
		
		b0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		add.addActionListener(this);
		sub.addActionListener(this);
		mult.addActionListener(this);
		div.addActionListener(this);
		equal.addActionListener(this);
		hud.addActionListener(this);
		clear.addActionListener(this);
	}
	
	
	
	
	public void reString()
	{
		hud.setText(nums);
	    if(hud.getText().length()>=27)
	    {
	        hud.setText(hud.getText().substring(0, 27));
	    }		
	   
	}
	
	
	
	public void actionPerformed(ActionEvent e)
	{
		if(true)
		{
			if(e.getSource() == b0)
			{
				nums += "0";
			}
			if(e.getSource() == b1)
			{
				nums += "1";
			}
			if(e.getSource() == b2)
			{
				nums += "2";
			}
			if(e.getSource() == b3)
			{
				nums += "3";
			}
			if(e.getSource() == b4)
			{
				nums += "4";
			}
			if(e.getSource() == b5)
			{
				nums += "5";
			}
			if(e.getSource() == b6)
			{
				nums += "6";
			}
			if(e.getSource() == b7)
			{
				nums += "7";
			}
			if(e.getSource() == b8)
			{
				nums += "8";
			}
			if(e.getSource() == b9)
			{
				nums += "9";
			}
			reString();
		}
		
		if(e.getSource() == add)
		{
			if(var1 == null)
			{
				var1 = Integer.parseInt(nums);
			}
			hud.setText("+");
			nums = "";
			getFunc(0);
		}
		
		if(e.getSource() == sub)
		{
			if(var1 == null)
			{
				var1 = Integer.parseInt(nums);
			}
			hud.setText("-");
			nums = "";
			getFunc(1);
		}
		
		if(e.getSource() == mult)
		{
			if(var1 == null)
			{
				var1 = Integer.parseInt(nums);
			}
			hud.setText("*");
			nums = "";
			getFunc(2);
		}
		
		if(e.getSource() == div)
		{
			if(var1 == null)
			{
				var1 = Integer.parseInt(nums);
			}
			hud.setText("÷");
			nums = "";
			getFunc(3);
		}
		
		if(e.getSource() == equal)
		{
			var2 = Integer.parseInt(nums);
			nums = Integer.toString(calculate());
			hud.setText(nums);
		}
		
		if(e.getSource() == clear)
		{
			var1 = null;
			var2 = null;
			nums = "";
			hud.setText("");
		}
	}
	
	
	public void getFunc(int n)
	{
		func = n;
	}
	
	public int calculate()
	{
		Integer answer = 0;
		if(func == 0)
			answer = var1 + var2;
		if(func == 1)
			answer = var1 - var2;
		if(func == 2)
			answer = var1 * var2;
		if(func == 3)
			answer = var1 / var2;
		return answer;
	}
}
