
public class Huffman
{
	private Tree tree = new Tree();
	public static void main(String[] args)
	{
		new Huffman();
	}
	
	
	public Huffman()
	{
		tree.inorder(tree.root);
	}

}
