import java.io.*;
import java.util.Scanner;



public class Main
{
	private File current_dir = new File(System.getProperty("user.dir"));
	
	private Scanner keys = new Scanner(System.in);
	private boolean exit = false;

	public static void main(String[] args) throws Exception
	{
		Main main = new Main();
		main.init();
	}

	private void init() throws Exception
	{
		while(getExit() == false)
		{
			response(prompt());
		}
		System.out.println("Thank you for using petershell");
	}

	private String prompt()
	{
		System.out.print("petershell> ");
		String input = keys.nextLine();
		return input;
	}


	private void response(String s) throws Exception
	{
		if(s.equals("e"))
			setExit(true);
		else if(s.equals("l"))
			listDir();
		else if(s.startsWith("d"))
			changeDir(s);
		else if(s.equals("u"))
			upDir();
		else if(s.equals("w"))
			printDir();
		else
			printHelp();
	}

	
	private void changeDir(String s)
	{
		String dir  = System.getProperty("user.dir");
		if(s.length() > 2)
		{
			String newDir = dir + "\\" + s.substring(2);
	
			File f = new File(newDir);
			if(f.exists())
			{
				System.setProperty("user.dir", newDir);
				setDir(newDir);
				printDir();
			}
			else
			{
				System.out.println("Sorry, directory does not exist");
			}
		}
		else
		{
			System.out.println("Please enter a directory name");
		}
	}
	
	private void upDir()
	{
		File dir = new File(System.getProperty("user.dir"));
		String parent = dir.getParent();
		System.setProperty("user.dir", parent);
		setDir(parent);
		printDir();
	}
	
	private void listDir() throws Exception
	{
		File dir = new File(getDir().toString());
		File[] contents = dir.listFiles();
	
		for(int i = 0; i < contents.length; i++)
		{
			if(contents[i].isFile())
			{
				System.out.println("(f) " + contents[i].getName());
			}
			else if (contents[i].isDirectory())
			{
				System.out.println("(d) " + contents[i].getName());
			}
		}		
	}
	
	private void printDir()
	{
		 System.out.println(getDir());
	}
	
	private void printHelp()
	{
		System.out.println("(l): lists contents of current directory");
		System.out.println("(d) [dir]: moves into the specified child directory");
		System.out.println("(u): moves to the parent directory");
		System.out.println("(w): prints the current directory");
		System.out.println("(e): exits the shell");
		System.out.println("(h): prints a list of the supported commands");
	}

	
	private void setDir(String f)
	{
		current_dir = new File(f);
	}
	private File getDir()
	{
		return current_dir;
	}
	

	private void setExit(boolean b)
	{
		exit = b;
	}
	private boolean getExit()
	{
		return exit;
	}
}