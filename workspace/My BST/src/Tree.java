

public class Tree
{
	Node root;
	
	public Tree()
	{
		experiment();
	}
	
	public static void main(String[] args)
	{
		new Tree();
	}
	
	public void experiment()
	{
		
		insert(10, "A");
		insert(3, "C");
		insert(4, "D");
		insert(15, "E");
		insert(2, "G");
		insert(4, "I");
		insert(2, "K");
		insert(3, "M");
		insert(6, "N");
		insert(8, "O");
		insert(7, "R");
		insert(5, "S");
		insert(12, "T");
		insert(5, "U");
		
		inorder(root);
		//t.preorder(t.root);
		//t.postorder(t.root);
		
		delete(8);
		System.out.println("\n\n\n");
		
		inorder(root);
		//System.out.println("At node 12 we have character: " + t.findNode(12));		
		
	}

	public boolean insert(int key, String name)
	{
		Node newNode = new Node(key, name);
		boolean ret = true;
		
		if(root == null)
			root = newNode;
		else
		{
			Node focusNode = root;
			Node parent;
			while(true)
			{
				parent = focusNode;
				if(key < focusNode.key)
				{
					focusNode = focusNode.leftChild;
					
					if(focusNode == null)
					{
						parent.leftChild = newNode;
						return ret;
					}
				}
				else
				{
					focusNode = focusNode.rightChild;
					
					if(focusNode == null)
					{
						parent.rightChild = newNode;
						return ret;
					}
				}	
			}
		}
		return ret;
	}
	
	
	public boolean delete(int key)
	{
		Node focusNode = root;
		Node parent = root;
		
		boolean isLeft = true;
		
		while(focusNode.key != key)
		{
			parent = focusNode;
			
			if(key < focusNode.key)
			{
				isLeft = true;
				focusNode = focusNode.leftChild;
			}
			else
			{
				isLeft = false;
				focusNode = focusNode.rightChild;
			}
			
			if(focusNode == null)
				return false;
		}
		
		if(focusNode.leftChild == null && focusNode.rightChild == null)
		{
			if(focusNode == root)
				root = null;
			else if(isLeft)
				parent.leftChild = null;
			else
				parent.rightChild = null;
		}
		else if(focusNode.rightChild == null)
		{
			if(focusNode == root)
				root = focusNode.leftChild;
			else if(isLeft)
				parent.leftChild = focusNode.leftChild;
			else
				parent.rightChild = focusNode.leftChild;	
		}
		else if(focusNode.leftChild == null)
		{
			if(focusNode == root)
				root = focusNode.rightChild;
			else if(isLeft)
				parent.leftChild = focusNode.rightChild;
			else
				parent.rightChild = focusNode.leftChild;
		}
		
		else
		{
			Node replacement = getReplacementNode(focusNode);
			
			if(focusNode == root)
				root = replacement;
			else if(isLeft)
				parent.leftChild = replacement;
			else
				parent.rightChild = replacement;
			
			replacement.leftChild = focusNode.leftChild;
		}
		
		return true;
	}
	
	
	public Node getReplacementNode(Node replacedNode)
	{
		Node replacementParent = replacedNode;
		Node replacement = replacedNode;
		
		Node focusNode = replacedNode.rightChild;
		
		while(focusNode != null)
		{
			replacementParent = replacement;
			replacement = focusNode;	
			focusNode = focusNode.leftChild;
		}
		
		if(replacement != replacedNode.rightChild)
		{
			replacementParent.leftChild = replacement.rightChild;
			replacement.rightChild = replacedNode.rightChild;
		}
		
		return replacement;
	}
	
	
	
	public Node findNode(int key)
	{
		Node focusNode = root;
		
		while(focusNode.key != key)
		{
			if(key < focusNode.key)
				focusNode = focusNode.leftChild;
			else
				focusNode = focusNode.rightChild;
			
			if(focusNode == null)
				return null;
		}
		
		return focusNode;
	}
	
	
	
	public void inorder(Node focusNode)
	{
		if(focusNode != null)
		{
			inorder(focusNode.leftChild);
			System.out.println(focusNode);
			inorder(focusNode.rightChild);
		}
	}
	

	public void preorder(Node focusNode)
	{
		if(focusNode != null)
		{
			System.out.println(focusNode);
			preorder(focusNode.leftChild);
			preorder(focusNode.rightChild);
		}
	}
	
	public void postorder(Node focusNode)
	{
		if(focusNode != null)
		{
			postorder(focusNode.leftChild);
			postorder(focusNode.rightChild);
			System.out.println(focusNode);
		}
	}
	
}

class Node implements Comparable<Node>
{
	int key;
	String name;
	
	Node leftChild;
	Node rightChild;
	
	Node(int key, String name)
	{
		this.key = key;
		this.name = name;
	}
	
	public String toString()
	{
		return name + " (" + key + ")";
	}
	
	public int compareTo(Node otherNode) 
	{
		if (key > otherNode.key)
			return 1;
		else if (key < otherNode.key)
			return -1;
		else 
			return 0;
	}
}