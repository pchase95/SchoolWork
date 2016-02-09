public class maps
{
	private int[][] stage1 = {{3, 3, 3, 3, 3},
							  {2, 2, 2, 2, 2},
							  {1, 1, 1, 1, 1},};
	
	public maps()
	{

	}
	
	
	public int getLvl1(int x, int y)
	{
		return stage1[x][y];
	}
}