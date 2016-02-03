import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

@SuppressWarnings("serial")
public class viewPane extends JPanel implements ActionListener
{
	private JFrame fview;
	private JPanel p = new JPanel();
	
	private int fileSize;
	private String[] tAry = new String[100];
	private String[] yAry = new String[100];
	private String[] rAry = new String[100];
	private String[] dAry = new String[100];
	
	private String user = System.getProperty("user.name");
	private String fileName = "C:\\Users\\" + user + "\\Documents/StuffStored.txt";
	private File file = new File(fileName);
	
	private JTextArea area1 = new JTextArea();
	private JTextArea area2 = new JTextArea();
	private JTextArea area3 = new JTextArea();
	private JTextArea area4 = new JTextArea();
	
	private JButton close = new JButton("CLOSE");
	
	public viewPane()
	{
		fileSize = 0;
		try {
			readFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FlowLayout layout = new FlowLayout();
		setLayout(layout);
		fview = new JFrame("View");
		fview.setSize(590, 440);
		fview.setVisible(true);
		fview.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel grid = new JPanel();
		GridLayout glay = new GridLayout(0, 4, 100, 5);
		grid.setLayout(glay);
		
		JLabel a = new JLabel("Title");
		JLabel b = new JLabel("Year");
		JLabel c = new JLabel("Rating");
		JLabel d = new JLabel("Director");
		grid.add(a);
		grid.add(b);
		grid.add(c);
		grid.add(d);
		
		area1.setColumns(12);
		area1.setRows(20);
		area1.setLineWrap(true);
		area1.setEditable(false);
		
		area2.setColumns(12);
		area2.setRows(20);
		area2.setLineWrap(true);
		area2.setEditable(false);
		
		area3.setColumns(12);
		area3.setRows(20);
		area3.setLineWrap(true);
		area3.setEditable(false);	
		
		area4.setColumns(12);
		area4.setRows(20);
		area4.setLineWrap(true);
		area4.setEditable(false);
		
		JScrollPane pane1 = new JScrollPane(area1);
		JScrollPane pane2 = new JScrollPane(area2);
		JScrollPane pane3 = new JScrollPane(area3);
		JScrollPane pane4 = new JScrollPane(area4);
		p.add(grid);
		p.add(pane1);
		p.add(pane2);
		p.add(pane3);
		p.add(pane4);
		p.add(close);
		close.addActionListener(this);
		
		p.setBackground(Main.back);
		
		fview.add(p);
	}
	
	public void actionPerformed(ActionEvent b)
	{
		if(b.getSource() == close)
		{
			fview.dispose();
		}
	}
	
	private void readFile() throws IOException
	{
		String line = "";
		if(file.exists())
		{
			@SuppressWarnings("resource")
			Scanner reader = new Scanner(file);
			while(reader.hasNextLine())
			{
				line = reader.nextLine();
				String[] part = line.split("; ");
				tAry[fileSize] = part[0];
				yAry[fileSize] = part[1];
				rAry[fileSize] = part[2];
				dAry[fileSize] = part[3];
				fileSize++;
			}
		}
		for(int i = 0; i < fileSize; i++)
		{
			area1.append(tAry[i] + "\n---------------------------------");
			area2.append(yAry[i] + "\n---------------------------------");
			area3.append(rAry[i] + "\n---------------------------------");
			area4.append(dAry[i] + "\n---------------------------------");
		}
	}
}
