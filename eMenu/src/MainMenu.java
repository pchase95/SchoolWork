import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.Collections;
import java.util.Comparator;

@SuppressWarnings("serial")
public class MainMenu extends JPanel implements ActionListener
{
	private JFrame f;
	private JButton goBack = new JButton("Go Back");
	private JButton date = new JButton("Date");
	private JButton title = new JButton("Name");
	private JButton rating = new JButton("Rating");
	private JButton price = new JButton("Price");
	private JSplitPane splitPane = new JSplitPane();
	
	private JButton order = new JButton("Add to Cart");
	private JButton rate = new JButton("Leave Rating");
	private JButton goToCart = new JButton("Checkout");
	
	private JLabel label = new JLabel();
	private JLabel label2 = new JLabel();
	private JTextArea label4 = new JTextArea();
	private JScrollPane sPane = new JScrollPane(label4);
	private JLabel imageLabel = new JLabel();
	private NumberFormat money = NumberFormat.getCurrencyInstance();
	private JList<Item> list;
	
	
	public MainMenu(Integer n)
	{
		if(n == 0)
			sortDate();
		if(n == 1)
			sortName();
		if(n == 2)
			sortPrice();
		if(n == 3)
			sortRating();
		new MainMenu();
	}

	
	
	public MainMenu()
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
		
		GridLayout glay = new GridLayout(1, 4);
		JPanel g = new JPanel();
		g.setLayout(glay);
		g.add(date);
		g.add(title);
		g.add(rating);
		g.add(price);
		
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
		
		GridLayout grid = new GridLayout(3, 1);
		JPanel g1 = new JPanel();
		g1.setLayout(grid);
		g1.add(goToCart);
		g1.add(order);
		g1.add(rate);
		
		p.add(imageLabel, BorderLayout.CENTER);
		p.add(g1, BorderLayout.EAST);
		p.add(splitPane, BorderLayout.WEST);
		p.add(g, BorderLayout.NORTH);
		p.add(goBack, BorderLayout.SOUTH);
		
		date.addActionListener(this);
		title.addActionListener(this);
		rating.addActionListener(this);
		price.addActionListener(this);
		order.addActionListener(this);
		rate.addActionListener(this);
		goToCart.addActionListener(this);
		goBack.addActionListener(this);
		
		f.add(p);
	}
	
	public void sortDate()
	{
		Collections.sort(Main.items, new Comparator<Item>() {
	        public int compare(Item item1, Item item2)
	        {
	        	return item1.getDate().compareTo(item2.getDate());
	        }
	    });
	}
	
	public void sortName()
	{
		Collections.sort(Main.items, new Comparator<Item>() {
	        public int compare(Item item1, Item item2)
	        {
	        	return item1.getName().compareTo(item2.getName());
	        }
	    });
	}
	
	public void sortPrice()
	{
		Collections.sort(Main.items, new Comparator<Item>() {
	        public int compare(Item item1, Item item2)
	        {
	        	return item1.getPriceDouble().compareTo(item2.getPriceDouble());
	        }
	    });		
	}
	
	public void sortRating()
	{
		Collections.sort(Main.items, new Comparator<Item>() {
	        public int compare(Item item1, Item item2)
	        {
	        	return item1.getRating().compareTo(item2.getRating());
	        }
	    });		
	}
	
	public void actionPerformed(ActionEvent g)
	{
		if(g.getSource() == goBack)
		{
			new LoginMenu();
			f.dispose();
		}
		if(g.getSource() == date)
		{
			new MainMenu(0);
			f.dispose();
		}
		if(g.getSource() == title)
		{
			new MainMenu(1);
			f.dispose();
		}
		if(g.getSource() == price)
		{
			new MainMenu(2);
			f.dispose();
		}
		if(g.getSource() == rating)
		{
			new MainMenu(3);
			f.dispose();
		}
		
		if(g.getSource() == order)
		{
			if(!list.isSelectionEmpty())
			{
				Main.cart.add(list.getSelectedValue());
				JOptionPane.showMessageDialog(f, "'" + Main.items.get(list.getSelectedIndex()).getName() + "' added to cart");
			}
			else
				JOptionPane.showMessageDialog(f, "Please Select an item");
		}
		if(g.getSource() == rate)
		{
			if(!list.isSelectionEmpty())
				new RatePane(Main.items.get(list.getSelectedIndex()));
			else
				JOptionPane.showMessageDialog(f, "Please Select an item");
		}
		if(g.getSource() == goToCart)
		{
			new ItemCart();
			f.dispose();
		}
		
	}
}
