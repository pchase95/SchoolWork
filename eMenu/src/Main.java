import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Main
{
	public static ArrayList<Item> items = new ArrayList<Item>();
	public static ArrayList<Item> cart = new ArrayList<Item>();
	private static Item item;
	
	public static Color bGroundColor = new Color(218, 251, 255);
	
	public static Font font = new Font("Calibri", Font.PLAIN, 35);
	public static Font font2 = new Font("Arial", Font.PLAIN, 20);
	public static Font font3 = new Font("Liberation Serif", Font.PLAIN, 25);
	
	public static String userName = System.getProperty("user.name");
	public static String fileName = "C:\\Users\\" + userName + "\\Documents\\eMenu/Entries.txt";
	public static String passFileName = "C:\\Users\\" + userName + "\\Documents\\eMenu/Password.txt";
	public static String pathName = "C:\\Users\\" + userName + "\\Documents\\eMenu/";
	
	public static File passFile = new File(passFileName);
	public static File file = new File(fileName);
	public static File path = new File(pathName);
	public static Integer itemCount = 0;

	

	
	public static void main(String[] args)
	{
		path.mkdirs();
		try {
			readFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		new LoginMenu();
		
	}
	
	public static void refreshList()
	{
		items = new ArrayList<Item>();
	}

	public static void WriteFile()
	{
		try
		{
			PrintWriter printFile = new PrintWriter(Main.file);
			for(int i = 0; i < Main.items.size(); i++)
			{
				Main.items.get(i).setDate(itemCount++);
				printFile.println(Main.items.get(i).getName() + "; " + Main.items.get(i).getDesc() + "; " + 
				Main.items.get(i).getPrice() + "; " + Main.items.get(i).getRating() + "; " +
				Main.items.get(i).getDate() + "; " + Main.items.get(i).getItemImage());
			}
			printFile.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}		
	}	
	
	public static void readFile() throws IOException
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
				item = new Item(null, null, null);
				item.setName(part[0]);
				item.setDesc(part[1]);
				item.setPrice(part[2]);
				if(part[3].equals("0"))
					item.setRating(0);
				else
					item.setRating(Integer.parseInt(part[3]));
				
				item.setDate(Integer.parseInt(part[4]));
				
				if(part[5].equals("null"))
					item.setItemImage(null);
				else
					item.setItemImage(part[5]);
				
				items.add(item);
			}
		}
	}
	
}
