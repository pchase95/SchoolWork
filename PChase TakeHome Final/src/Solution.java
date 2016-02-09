import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution
{
	// Heap used to sort customers based on priority number
	private IHeap<Integer> heap = new Heap<Integer>();
	
	//LinkedList used to store all customers
	private LinkedList<Customer> customers = new LinkedList<Customer>();
	
	public static void main(String[] args)
	{
		Solution solution = new Solution();
		solution.buildHeap();
		solution.printWinners();
	}

	// adds all customers to heap
	public void buildHeap() 
	{
		readFile();
		for(Customer cust : customers)
		{
			heap.insert(cust.getPriority());
		}		
	}
	
	// Prints the 5 customers with highest priority to console
	public void printWinners()
	{
		System.out.println("This year's 5 award winners are: \n\n");
		for(int i = 0; i < 5; i++)
		{
			System.out.println(getWinner(heap.removeTop()));
		}		
	}
	
	 // reads 'customers.txt' and stores info on each customer in an object called 'Customer'
	 // These customers are stored in an ArrayList called 'customers'
	public void readFile()
	{
	  String line;
	  String[] part;
	  try
	  {
         @SuppressWarnings("resource")
         Scanner sr = new Scanner(new File("customers.txt"));
         while (sr.hasNextLine())
         {
        	 line = sr.nextLine();
        	 part = line.split(", ");
        	 customers.add(new Customer(part[0], Integer.parseInt(part[1]), Integer.parseInt(part[2]), Integer.parseInt(part[3])));
         }       
      }
	  
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	}
	
	// matches up customer with their priority number then returns that customer
	public Customer getWinner(Integer n)
	{
		Customer winner = null;
		for(Customer cust : customers)
		{
			if(n == cust.getPriority())
				winner = cust;
		}
		return winner;
	}
	
	
	// Object with info for each Customer.  All customers are stored in the ArrayList 'customers'
	private class Customer
	{
		String name;
		int money;
		int years;
		int order;
		int priority;
		
		private Customer(String a, int b, int c, int d)
		{
			name = a;
			money = b;
			years = c;
			order = d;
			priority = (money / 1000) + years - order;
		}
		
		public int getPriority()
		{
			return priority;
		}
		
		//How each Customer object is printed as
		public String toString()
		{
			return "Customer: " + name + "\nPriority Number: " + priority + "\n";
		}
	}
}




