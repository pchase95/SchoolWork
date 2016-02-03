import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ColorToggle extends JPanel implements ActionListener
{
	private JComboBox combo = new JComboBox();
	private JPanel p = new JPanel();
	
	
	public ColorToggle()
	{
		JFrame f = new JFrame("Color Toggle");
		f.setVisible(true);
		f.setSize(600, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.add(p);
		
		combo.addItem("Red");
		combo.addItem("Green");
		combo.addItem("Blue");
		combo.addActionListener(this);
		
		FlowLayout layout = new FlowLayout();
		setLayout(layout);
		p.add(combo);
		p.setBackground(Color.red);
	}
	
	public static void main(String[] args)
	{
		new ColorToggle();
	}

	public void actionPerformed(ActionEvent e)
	{
		if(combo.getSelectedItem().equals("Red"))
			p.setBackground(Color.red);
		if(combo.getSelectedItem().equals("Green"))
			p.setBackground(Color.green);
		if(combo.getSelectedItem().equals("Blue"))
			p.setBackground(Color.blue);		
	}
}
