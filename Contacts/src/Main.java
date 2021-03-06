import java.awt.Color;
import java.awt.Font;
import java.io.*;
import java.util.*;

public class Main
{
	public static ArrayList<Person> People = new ArrayList<Person>();
	
	public static Color bkgr_color = new Color(195, 238, 253);
	public static Font font = new Font("Arial", Font.PLAIN, 15);
	
	public static String userName = System.getProperty("user.name");

	public static String path_name = "C:\\Users\\" + userName + "\\Desktop\\Contacts/";
	public static File path = new File(path_name);
	public static String file_name = "C:\\Users\\" + userName + "\\Desktop\\Contacts/Contacts.bin";
	public static File file = new File(file_name);
	
	
	public static void main(String[] args) throws Exception
	{

		if(!file.exists())
			path.mkdir();
		else
			readFile();
		new Manager();
	}
	
	
	public static void writeFile()
	{
        try
        {
            FileOutputStream fout = new FileOutputStream(file_name);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(People);
            fout.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
	}
	
	public static void readFile() throws Exception
	{
		try
		{
			FileInputStream fin = new FileInputStream(file_name);
			ObjectInputStream ois = new ObjectInputStream(fin);
			@SuppressWarnings("unchecked")
			ArrayList<Person> PeopleFile = (ArrayList<Person>)ois.readObject();
			for(Person person : PeopleFile)
			{
			People.add(person);
			}
			ois.close();				
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}
