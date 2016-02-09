
public class Huffman implements Comparable<Huffman>
{
	private int key;
	private String name;
	
	public Huffman()
	{
		addNodes();
	}
	
	public Huffman(int key, String name)
	{
		this.key = key;
		this.name = name;
	}
		
	public String toString()
	{
		return name + " (" + key + ")";
	}
		
	public int compareTo(Huffman otherNode) 
	{
		if (key > otherNode.key)
			return 1;
		else if (key < otherNode.key)
			return -1;
		else 
			return 0;
	}
	

	
	


	public static void main(String[] args)
	{
		new Huffman();
	}
	
	public void addNodes()
	{
		Huffman n1 = new Huffman(12, "T");
		Huffman n2 = new Huffman(2, "K");
		Huffman n3 = new Huffman(2, "G");
		Huffman n4 = new Huffman(3, "C");
		Huffman n5 = new Huffman(3, "M");
		Huffman n6 = new Huffman(6, "N");
		Huffman n7 = new Huffman(7, "R");
		Huffman n8 = new Huffman(15, "E");
		Huffman n9 = new Huffman(4, "D");
		Huffman n10 = new Huffman(4, "I");
		Huffman n11 = new Huffman(5, "U");
		Huffman n12 = new Huffman(5, "S");
		Huffman n13 = new Huffman(8, "O");
		Huffman n14 = new Huffman(10, "A");
		
		
		
		Tree<Huffman> tree = new Tree<Huffman>(n1);
		tree.add(n2);
		//tree.add(n3);
		//tree.add(n4);
		//tree.add(n5);
		//tree.add(n6);
		//tree.add(n7);
		//tree.add(n8);
		//tree.add(n9);
		//tree.add(n10);
		//tree.add(n11);
		//tree.add(n12);
		//tree.add(n13);
		//tree.add(n14);		
		
		
		tree.inOrderPrint();
	}

}
