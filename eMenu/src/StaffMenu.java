import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

@SuppressWarnings("serial")
public class StaffMenu extends JPanel implements ActionListener
{
	private JFrame f;
	private JButton add = new JButton("Add");
	private JButton edit = new JButton("Edit");
	private JButton delete = new JButton("Delete");
	private JButton goBack = new JButton("Go Back");
	private JSplitPane splitPane = new JSplitPane();
	private JLabel label = new JLabel();
	private JLabel label2 = new JLabel();
	private JTextArea label4 = new JTextArea();
	private JScrollPane sPane = new JScrollPane(label4);
	private JLabel imageLabel = new JLabel();
	private NumberFormat money = NumberFormat.getCurrencyInstance();
	
	private JList<Item> list;
	
	public StaffMenu()
	{	
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		f = new JFrame("Staff Menu");
		f.setVisible(true);
		f.setSize(1600, 900);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		label.setFont(Main.font3);
		label2.setFont(Main.font3);
		label4.setFont(Main.font3);
		
		JPanel p = new JPanel();
		p.setBackground(Main.bGroundColor);
		p.setLayout(new BorderLayout());
		
		GridLayout glay = new GridLayout(1, 3);
		JPanel g = new JPanel();
		g.setLayout(glay);
		g.add(add);
		g.add(edit);
		g.add(delete);
		
		list = new JList<>();
		list.setFont(Main.font2);
		DefaultListModel<Item> model = new DefaultListModel<>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(model);
		for(int i = 0; i < Main.items.size(); i++)
		{
			model.addElement(Main.items.get(i));
		}
		
		JPanel splitPanel = new JPanel();
		splitPanel.setBackground(Main.bGroundColor);
		splitPane.setLeftComponent(new JScrollPane(list));
		GridLayout glay2 = new GridLayout(0, 1);
		splitPanel.setLayout(glay2);
		splitPanel.add(label);
		splitPanel.add(label2);
		splitPanel.add(sPane);
		
		
		
		splitPane.setRightComponent(splitPanel);
		
		list.getSelectionModel().addListSelectionListener(e -> {
			Item i = list.getSelectedValue();
			label.setText("Price: " + money.format(i.getPrice()));
			if(i.getRating() != 0)
				label2.setText("Rating: " + i.getRating() + " / 5");
			else
				label2.setText("Item not yet rated");
			if(i.getItemImage() != null)
			{
				imageLabel.setText("");
				imageLabel.setIcon(new ImageIcon(Main.pathName + i.getItemImage()));
			}
			else
			{
				imageLabel.setIcon(null);
				imageLabel.setText("No Image");
			}
			
			label4.setText("Description: " + i.getDesc());
				});
		
		label4.setLineWrap(true);
		label4.setColumns(20);
		label4.setRows(5);
		label4.setBackground(Main.bGroundColor);
		label4.setWrapStyleWord(true);
		
		p.add(imageLabel, BorderLayout.CENTER);
		p.add(splitPane, BorderLayout.WEST);
		p.add(g, BorderLayout.NORTH);
		p.add(goBack, BorderLayout.SOUTH);
		
		add.addActionListener(this);
		edit.addActionListener(this);
		delete.addActionListener(this);
		goBack.addActionListener(this);
		
		f.add(p);
	}
	
	public void actionPerformed(ActionEvent c)
	{
		if(c.getSource() == add)
		{
			new AddPane();
			f.dispose();
		}
		
		if(c.getSource() == edit)
		{
			if(list.getSelectedValue() != null)
			{
				new AddPane(list.getSelectedIndex());
				f.dispose();
			}
			else
				JOptionPane.showMessageDialog(f, "Please select an item to edit");
		}
		
		if(c.getSource() == delete)
		{
			if(list.getSelectedValue() != null)
			{
				Main.items.remove(list.getSelectedIndex());
				Main.WriteFile();
				JOptionPane.showMessageDialog(f, "Your item has been deleted");
				new StaffMenu();
				f.dispose();
			}
			else
				JOptionPane.showMessageDialog(f, "Please select an item to delete.");
		}
		
		if(c.getSource() == goBack)
		{
			new LoginMenu();
			f.dispose();
		}
	}
}
