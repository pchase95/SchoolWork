

public class Tree<T extends Comparable<T>> 
{
	private Tree<T> lChild;
	private Tree<T> rChild;
	private Tree<T> parent;
	private int level;
	private T data;
	
	public Tree(T dat)
	{
		lChild = null;
		rChild = null;
		parent = null;
		level = 0;
		data = dat;		
	}

	public Tree(T dat, Tree<T> par)
	{
		this(dat);
		parent = par;		
	}
	
	
	public void add(T dat)
	{
		for(int i = 0; i < 14; i++)
		{
			
		}
	}
	
	
	
	
	
	public void inOrderPrint()
	{
		if (getLeft() != null)
			getLeft().inOrderPrint();
		System.out.print(getData() + " ");
		if (getRight() != null)
			getRight().inOrderPrint();		
	}
	
	
	
	
	public Tree<T> getLChild()
	{ return lChild; };
	
	public Tree<T> getLeft()
	{ return lChild; }

	public Tree<T> getRight()
	{ return rChild; }
	
	public Tree<T> getParent()
	{ return parent; }
	
	public int getLevel()
	{ return level; }
	
	public T getData()
	{ return data; }
	
	public String toString()
	{
		return getData().toString();
	}
	
	private void setLeft(Tree<T> tree)
	{ lChild = tree; }

	private void setRight(Tree<T> tree)
	{ rChild = tree; }

	private void setParent(Tree<T> tree)
	{ parent = tree; }

	private void setData(T d)
	{ data = d; }
	
	private void setLevel(int k)
	{ level = k; }
}
