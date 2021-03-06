
public class Tree
{
	public Node root;
	
	private int nodeTotal = 0;
	private IStack<Node> stack = new StackLL<Node>();
	private IStack<Node> stack2 = new StackLL<Node>();
	
	public Tree()
	{
		add("N", 6);
		add("T", 12);
		add("U", 5);
		add("A", 10);
		add("S", 5);
		add("K", 2);
		add("G", 2);
		add("E", 15);
		add("C", 3);
		add("M", 3);
		add("R", 7);
		add("D", 4);
		add("I", 4);
		add("O", 8);
		
		build();
	}
	
	
	public void add(String s, int n)
	{
		Node newNode = new Node(s, n, null, null, null);
		nodeTotal += newNode.key;
		stack.push(newNode);
	}
	
	public void build()
	{
		Node focus1 = getMin();
		Node focus2 = getMin();
			
		Node newNode = new Node(focus1.name + focus2.name, focus1.key + focus2.key, focus1, focus2, null);
		stack.push(newNode);
		focus1.parent = newNode;
		focus2.parent = newNode;
		if(newNode.key == nodeTotal)
			root = newNode;
		else
			build();
	}
	
	
	public Node getMin()
	{
		Node n = null;
		Node temp;
		
		n = stack.pop();
		while(!stack.isEmpty())
		{
			temp = stack.pop();
			if(temp.key < n.key)
			{
				stack2.push(n);
				n = temp;
			}
			else
			{
				stack2.push(temp);
			}
		}
		
		while(!stack2.isEmpty())
			stack.push(stack2.pop());
		
		return n;
	}
}

class Node
{
	int key;
	String name;
	
	Node leftChild;
	Node rightChild;
	Node parent;
	
	Node(String name, int key, Node leftChild, Node rightChild, Node parent)
	{
		this.name = name;
		this.key = key;
		
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.parent = parent;
	}
	
	public String toString()
	{
		if(name.length() > 1)
			return "*" + " (" + key + ")";
		else
			return name + " (" + key + ")";
	}
}