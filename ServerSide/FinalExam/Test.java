

public class Test {
	public static void main(String[] args) {
		Test test = new Test();
		System.out.println(test.prob1());
		System.out.println(test.prob2());
		System.out.println(test.prob3());
		System.out.println(test.prob4());
		System.out.println(test.prob5());
	}

	private int prob1() {
		int r = 2;
		int i = 5;

		if(i > 3) {
			return r-1;
		} else {
			return r;
		}
	}

	private int prob2()
	{
	  	int r = 0;
	  	for (int i = 0; i < 3; i++)
		{
			r = r + i;
		}

		for (int i = 0; i < 5; i++)
		{
			r = r + i;
		}

		return r;
	}

	private int prob3()
	{
	  	int r = 0;
	  	for (int i = 0; i < 2; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				r = r + 5;
			}
		}
		return r;
	}

	private int prob4()
	{
	  	int r = 0;
	  	for (int i = 0; i < 6; i++)
		{
			if (i > 2)
			{
				r = r + i;
			}

			if (i > 0)
			{
				r = r + 2;
			}
		}
		return r;
	}


	private int prob5()
	{
	  int [] x = {6, 4, 3, 2, 0};
	  for (int i = 0; i < x.length; i++)
	  {
	    if (i != x[i])
		{
			x[i] = 12;
		}
	  }
	  return x[0] + x[2];
	}

}