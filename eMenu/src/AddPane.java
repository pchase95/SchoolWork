import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

@SuppressWarnings("serial")
public class AddPane extends JPanel implements ActionListener
{
	private Item item = new Item(null, null, null);
	private JFrame f;
	private JTextField nameArea = new JTextField("");
	private JLabel nameLabel = new JLabel("Name (Required)");

	private JTextField priceArea = new JTextField("Dollars.Cents");
	private JLabel priceLabel = new JLabel("Price (Required)");
	
	private JTextArea descArea = new JTextArea("");
	private JLabel descLabel = new JLabel("Description (Required)");
	private JScrollPane scroll = new JScrollPane(descArea);
	
	private JButton save = new JButton("Save");
	
	private JButton uploadButton = new JButton("Upload Image");
	private JButton cancel = new JButton("Canel");
	private JFileChooser fileChooser;
	private File imageFile;
	private int returnVal;
	private JTextArea fileNameArea = new JTextArea("");
	private String imageFileName;
	private FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "tif");
	
	private String newName;
	private String newDesc;
	private double newPrice;
	private Integer itemIndex = null;
	
	
	public AddPane(Integer n)
	{
		AddPane pane = new AddPane();
		pane.itemIndex = n;
		pane.nameArea.setText(Main.items.get(n).getName());
		pane.descArea.setText(Main.items.get(n).getDesc());
		pane.priceArea.setText(Double.toString(Main.items.get(n).getPrice()));
	}
	
	public AddPane()
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		f = new JFrame("Add");
		f.setVisible(true);
		f.setSize(600, 600);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.setBackground(Main.bGroundColor);
		
		GridLayout glay = new GridLayout(8, 1);
		JPanel g = new JPanel();
		g.setLayout(glay);
		
		g.add(nameLabel);
		g.add(nameArea);
		nameArea.setPreferredSize(new Dimension(550, 50));
		nameArea.setColumns(50);
		
		g.add(priceLabel);
		g.add(priceArea);
		priceArea.setPreferredSize(new Dimension(150, 50));
		priceArea.setColumns(10);
		
		g.add(descLabel);
		descArea.setColumns(50);
		descArea.setRows(5);
		descArea.setLineWrap(true);
		g.add(scroll);
		
		g.add(uploadButton);
		fileChooser = new JFileChooser();
		fileChooser.removeChoosableFileFilter(fileChooser.getFileFilter());
		fileChooser.setFileFilter(filter);
		fileChooser.addChoosableFileFilter(filter);
		fileChooser.setMultiSelectionEnabled(false);
		
		fileNameArea.setEditable(false);
		g.add(fileNameArea);
		
		JPanel g2 = new JPanel();
		g2.setLayout(new GridLayout(1, 2));
		g2.add(save);
		g2.add(cancel);
		
		save.addActionListener(this);
		uploadButton.addActionListener(this);
		cancel.addActionListener(this);
		
		p.add(g, BorderLayout.CENTER);
		p.add(g2, BorderLayout.SOUTH);
		f.add(p);
	}
	
	private void setNewName(String s)
	{
		newName = s;
	}
	private String getNewName()
	{
		return newName;
	}
	
	private void setNewDesc(String s)
	{
		newDesc = s;
	}
	private String getNewDesc()
	{
		return newDesc;
	}
	
	private void setNewPrice(String s)
	{
		try
		{
			newPrice = Double.parseDouble(s);
		}
		catch(Exception notDouble)
		{
			JOptionPane.showMessageDialog(f, "Please enter a double for price");
			System.exit(0);
		}
	}
	private double getNewPrice()
	{
		return newPrice;
	}
	
	private void setImageFileName(String s)
	{
		imageFileName = s;
	}
	private String getImageFileName()
	{
		return imageFileName;
	}
	
	private Integer getItemIndex()
	{
		return itemIndex;
	}
	
	public void actionPerformed(ActionEvent d)
	{
		if(d.getSource() == cancel)
		{
			new StaffMenu();
			f.dispose();
		}
		if(d.getSource() == save)
		{
			if(!nameArea.getText().isEmpty())
				setNewName(nameArea.getText());
			else
			{
				JOptionPane.showMessageDialog(f, "Please enter a name");
				System.exit(0);
			}
			setNewDesc(descArea.getText());
			if(!descArea.getText().isEmpty())
				setNewDesc(descArea.getText());
			else
			{
				JOptionPane.showMessageDialog(f, "Please enter a description");
				System.exit(0);
			}
			setNewPrice(priceArea.getText());
			item.setName(getNewName());
			item.setDesc(getNewDesc());
			item.setPrice(getNewPrice());

			if(getItemIndex() == null)
			{
				Main.items.add(item);
				Main.WriteFile();
			}
			else
			{
				int index = itemIndex;
				Main.items.remove(index);
				Main.items.add(index, item);
				Main.WriteFile();

			}		
			f.dispose();
			new StaffMenu();
		}
		
		if(d.getSource() == uploadButton)
		{
			returnVal = fileChooser.showOpenDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION)
			{
				imageFile = fileChooser.getSelectedFile();
				imageFile.renameTo(new File(Main.pathName + imageFile.getName()));
				fileNameArea.setText(imageFile.getName());
				setImageFileName(imageFile.getName());
				item.setItemImage(getImageFileName());
			}
			
		}
	}


}
