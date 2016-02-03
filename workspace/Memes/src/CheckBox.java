import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CheckBox extends JPanel implements ActionListener
{
	private JCheckBox toggle;
	private JTextField textfield;
	private JTextArea area;
	private JScrollPane pane;
	
	public CheckBox()
	{
		toggle = new JCheckBox("Toggle Colors");
		FlowLayout layout = new FlowLayout();
		setLayout(layout);
		setBackground(Color.black);
		toggle.addActionListener(this);
		add(toggle);
		
		textfield = new JTextField();
		textfield.setColumns(40);
		add(textfield);
		
		area = new JTextArea();
		area.setColumns(20);
		area.setRows(8);
		area.setLineWrap(true);
		pane = new JScrollPane(area);
		add(pane);
	}
	
	public static void main(String[] args)
	{
		JFrame f = new JFrame();
		f.setSize(500, 400);
		f.add(new CheckBox());
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == toggle)
		{
			if(toggle.isSelected())
				setBackground(Color.white);
			else
				setBackground(Color.black);
		}
	}
}
