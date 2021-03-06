import java.util.Scanner;

public class Huffman
{
	private Tree tree = new Tree();
	private IStack<Integer> stack = new StackLL<Integer>();
	private IStack<Integer> stack2 = new StackLL<Integer>();
	private boolean success = false;
	
	public Huffman()
	{
		System.out.println("Preorder Traversal");
		preorder(tree.root);
		
		System.out.println("\n\n\nInorder Traversal");
		inorderCode(tree.root);
		
		
		Scanner keys = new Scanner(System.in);
		
		
		while(!success)
		{
			try
			{
				System.out.println("\n\nEnter a string of binary digits: ");
				String input = keys.next();
				findNode(input);
			}
			catch(Exception e)
			{
				System.out.println("Node not found");
			}
		}
		
		keys.close();
	}
	
	public static void main(String[] args)
	{
		new Huffman();
	}
	
	
	public void preorder(Node n)
	{
		if(n != null)
		{
			System.out.println(n);
			preorder(n.leftChild);
			preorder(n.rightChild);
		}
	}
	
	public void inorderCode(Node n)
	{
		if(n.leftChild != null)
		{
			inorderCode(n.leftChild);
		}
		
		if(n.name.length() == 1)
		{
			getNode(n);
			System.out.print(n);
			
			while(!stack.isEmpty())
			{
				stack2.push(stack.pop());
			}
			System.out.print(stack2.toString());
			while(!stack2.isEmpty())
				stack2.pop();
			System.out.println();
		}
		
		if(n.rightChild != null)
		{
			inorderCode(n.rightChild);
		}
	}
	
	public void getNode(Node n)
	{
		Node r = tree.root;
		while(r != n)
		{
			if(r.leftChild.name.contains(n.name))
			{
				r = r.leftChild;
				stack.push(0);
			}
			else
			{
				r = r.rightChild;
				stack.push(1);
			}
		}
	}
	
	
	public void findNode(String s)
	{
		String[] digits = s.split("(?<=.)");
		
		for(int i = digits.length-1; i >= 0; i--)
		{
			stack.push(Integer.parseInt(digits[i]));
		}
		
		Node r = tree.root;
		while(!stack.isEmpty())
		{
			if(stack.pop() == 0)
				r = r.leftChild;
			else
				r = r.rightChild;
			
			if(r.leftChild == null && r.rightChild == null)
			{
				System.out.println(r.toString());
				r = tree.root;
			}
		}
		success = !success;
	}
}
