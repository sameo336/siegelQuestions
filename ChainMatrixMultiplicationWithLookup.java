package siegelQuestions;

public class ChainMatrixMultiplicationWithLookup {
    
	int count1=0;
	int count2=0;
	public int minCalculations(int i, int j, Integer [][]lookup, Integer [][]intermediate1) 
	{
		if (lookup[i-1][j-1] != null) 
		{
			return lookup[i-1][j-1];
		}
		count1++;
		int calculations = Integer.MAX_VALUE;
		if (i == j) 
		{
			 calculations = 0;
		}
		else if (j == i+1) 
		{
			calculations =  i*(i+1)*(i+2);
		}
		else 
		{
			
			for (int k=i+1;k <=j;k++ ) 
			{
				
				int temp = minCalculations(i,k-1,lookup,intermediate1)+ i*k*(j+1) +
						minCalculations(k,j,lookup,intermediate1);
			
				if ((temp) < calculations)
				{
					intermediate1[i-1][j-1] = k-1;
					calculations = temp;
				}
			
			}
		}
		lookup[i-1][j-1] = calculations;
		return calculations;
	}
	
	public int maxCalculations(int i, int j, Integer [][] lookup, Integer [][] intermediate2) 
	{
		if (lookup[i-1][j-1] != null) 
		{
			return lookup[i-1][j-1];
		}
		count2++;
		int calculations = Integer.MIN_VALUE;
		if (i == j) 
		{
			 calculations = 0;
		}
		else if (j == i+1) 
		{
			calculations =  i*(i+1)*(i+2);
		}
		else 
		{
			
			for (int k=i+1;k <=j;k++ ) 
			{
				int temp = maxCalculations(i,k-1,lookup,intermediate2)+ i*k*(j+1) +
						maxCalculations(k,j,lookup,intermediate2);
			
				if ((temp) > calculations)
				{
					intermediate2[i-1][j-1] = k-1;
					calculations = temp;
				}
			}
		}
		lookup[i-1][j-1] = calculations;
		return calculations;
	}
	
	public static void main (String [] args) 
	{
		ChainMatrixMultiplicationWithLookup mult1 = new  ChainMatrixMultiplicationWithLookup();
		int i= 1;
		int j= 5;
		
		Integer [][] lookup1 = new Integer [j][j];
		Integer [][] lookup2 = new Integer [j][j];
		
		Integer [][] intermediate1 = new Integer [j][j];
		Integer [][] intermediate2 = new Integer [j][j];

		System.out.println("Min no of calculcations:" + mult1.minCalculations(i, j,lookup1,intermediate1));
		System.out.println("No of times min is called: " +mult1.count1);
		System.out.println("Max no of calculcations:" + mult1.maxCalculations(i, j,lookup2,intermediate2));
		System.out.println("No  of times max is called: "+ mult1.count2);
	 
		for (int i1=0; i1<intermediate1.length;i1++)
		{
			for (int j1=0; j1<intermediate1[0].length; j1++) 
			{
				System.out.printf(" ["+i1+"]"+"["+j1+"]" + intermediate1[i1][j1]);
			}
			System.out.println();
		}
		
		System.out.println();
		for (int i1=0; i1<intermediate2.length;i1++)
		{
			for (int j1=0; j1<intermediate2[0].length; j1++) 
			{
				System.out.printf(" ["+i1+"]"+"["+j1+"]" + intermediate2[i1][j1]);
			}
			System.out.println();
		}

	}
}
