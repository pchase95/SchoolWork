import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

import javax.swing.*;

@SuppressWarnings("serial")
public class ItemCart extends JPanel implements ActionListener
{
	private JButton pay = new JButton("Pay");
	private JButton removeItem = new JButton("Remove From Cart");
	private JButton shop = new JButton("Back to Shopping");
	private JLabel priceLabel = new JLabel();
	private double priceTotal = 0.0;
	
	private JSplitPane splitPane = new JSplitPane();
	private JLabel label = new JLabel();
	private JLabel label2 = new JLabel();
	private JTextArea label4 = new JTextArea();
	private JScrollPane sPane = new JScrollPane(label4);
	private JLabel imageLabel = new JLabel();
	private NumberFormat money = NumberFormat.getCurrencyInstance();
	
	private JFrame f;
	private JList<Item> list;
	
	public ItemCart()
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		f = new JFrame("Checkout");
		f.setSize(1200, 800);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel p = new JPanel();
		p.setBackground(Main.bGroundColor);
		BorderLayout blay = new BorderLayout();
		p.setLayout(blay);
		
		GridLayout glay = new GridLayout(3, 1);
		JPanel grid = new JPanel();
		grid.setLayout(glay);
		grid.add(removeItem);
		grid.add(shop);
		grid.add(pay);
		
		list = new JList<>();
		list.setFont(Main.font2);
		DefaultListModel<Item> model = new DefaultListModel<>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(model);
		for(int i = 0; i < Main.cart.size(); i++)
		{
			model.addElement(Main.cart.get(i));
			setPriceTotal(Main.cart.get(i).getPrice());
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
		
		label.setFont(Main.font3);
		label2.setFont(Main.font3);
		label4.setFont(Main.font3);
		
		list.getSelectionModel().addListSelectionListener(e -> {
			Item i = list.getSelectedValue();
			label.setText(money.format(i.getPrice()));
			if(i.getRating() != null)
				label2.setText("Rating: " + i.getRating() + " / 5");
			else
				label2.setText("Item not yet rated");
			if(i.getItemImage() != null)
			{
				imageLabel.setText("");
				imageLabel.setIcon(new ImageIcon(Main.pathName + i.getItemImage()));
			}
			else
				imageLabel.setText("No Image");
			label4.setText("Description: " + i.getDesc());
				});
		
		label4.setLineWrap(true);
		label4.setColumns(20);
		label4.setRows(5);
		label4.setBackground(Main.bGroundColor);
		label4.setWrapStyleWord(true);
		
		priceLabel.setText(money.format(priceTotal));
		priceLabel.setFont(Main.font);
		
		pay.addActionListener(this);
		removeItem.addActionListener(this);
		shop.addActionListener(this);
		
		p.add(imageLabel, BorderLayout.CENTER);
		p.add(splitPane, BorderLayout.WEST);
		p.add(grid, BorderLayout.EAST);
		p.add(priceLabel, BorderLayout.SOUTH);
		
		f.add(p);
	}
	
	public void setPriceTotal(double d)
	{
		priceTotal += d;
	}
	public double getPriceTotal()
	{
		return priceTotal;
	}
	
	public void actionPerformed(ActionEvent h)
	{
		if(h.getSource() == pay)
		{
			if(!Main.cart.isEmpty())
				new PayPane(priceTotal);
			else
				JOptionPane.showMessageDialog(f, "Nothing to Checkout");
		}
		
		if(h.getSource() == removeItem)
		{
			if(!list.isSelectionEmpty())
			{
				Main.cart.remove(list.getSelectedIndex());
				new ItemCart();
				f.dispose();
			}
			else
				JOptionPane.showMessageDialog(f, "Please Select an item");
		}
		
		if(h.getSource() == shop)
		{
			new MainMenu();
			f.dispose();
		}
	}
	
}
