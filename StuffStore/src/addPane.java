import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

@SuppressWarnings("serial")
public class addPane extends JPanel implements ActionListener
{
	private int fileSize = 0;
	
	private JFrame fadd;
	private JPanel p = new JPanel();
	private JTextField titleField = new JTextField();
	private JLabel titleLabel = new JLabel("Title");
	
	private JTextField yearField = new JTextField();
	private JLabel yearLabel = new JLabel("Year");
	
	private JTextField ratingField = new JTextField();
	private JLabel ratingLabel = new JLabel("Rating");
	
	private JTextField directorField = new JTextField();
	private JLabel directorLabel = new JLabel("Director");
	
	private JButton save = new JButton("Save");
	
	private String[] tAry = new String[100];
	private String[] yAry = new String[100];
	private String[] rAry = new String[100];
	private String[] dAry = new String[100];
	
	private String user = System.getProperty("user.name");
	private String fileName = "C:\\Users\\" + user + "\\Documents/StuffStored.txt";
	private File file = new File(fileName);
	
	
	
	public addPane() throws IOException
	{
		readFile();
		fadd = new JFrame("Add");
		
		fadd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fadd.setSize(400, 400);
		fadd.setVisible(true);
		p.setBackground(Main.back);
		
		BorderLayout layout = new BorderLayout();
		p.setLayout(layout);
		
		GridLayout gr = new GridLayout(0, 2, 0, 50);
		JPanel grid = new JPanel();
		grid.setLayout(gr);
		
		
		titleField.setColumns(10);
		grid.add(titleField);
		grid.add(titleLabel);
		
		yearField.setColumns(10);
		grid.add(yearField);
		grid.add(yearLabel);	
		
		ratingField.setColumns(10);
		grid.add(ratingField);
		grid.add(ratingLabel);
	
		directorField.setColumns(10);
		grid.add(directorField);
		grid.add(directorLabel);
		
		grid.add(save);
		save.addActionListener(this);
		p.add(grid, BorderLayout.CENTER);
		
		fadd.add(p);
	}
	
	public void actionPerformed(ActionEvent a)
	{
		if(a.getSource() == save)
		{
			tAry[fileSize] = titleField.getText();
			yAry[fileSize] = yearField.getText();
			rAry[fileSize] = ratingField.getText();
			dAry[fileSize] = directorField.getText();
			fileSize++;
			writeFile();
			fadd.dispose();
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
	}
	
	private void writeFile()
	{
		try
		{
			PrintWriter printFile = new PrintWriter(file);
			for(int i = 0; i < fileSize; i++)
			{
				printFile.println(tAry[i] + "; " + yAry[i] + "; " + rAry[i] + "; " + dAry[i]);
			}
			printFile.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
}
