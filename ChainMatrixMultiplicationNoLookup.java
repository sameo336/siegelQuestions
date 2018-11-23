package siegelQuestions;

public class ChainMatrixMultiplicationNoLookup {
    
	int count1=0;
	int count2=0;
	public int minCalculations(int i, int j, Integer [][]lookup) 
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
				calculations =  Math.min(calculations,minCalculations(i,k-1,lookup)+ i*k*(j+1) +
						minCalculations(k,j,lookup));
			}
		}
		return calculations;
	}
	
	public int maxCalculations(int i, int j, Integer [][] lookup) 
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
				calculations =  Math.max(calculations,
						maxCalculations(i,k-1,lookup)+ i*k*(j+1) +
						maxCalculations(k,j,lookup));
			}
		}
		return calculations;
	}
	
	public static void main (String [] args) 
	{
		ChainMatrixMultiplicationNoLookup mult1 = new  ChainMatrixMultiplicationNoLookup();
		int i= 1;
		int j= 10;
		
		Integer [][] lookup = new Integer [j][j];
		System.out.println("Min no of calculcations:" + mult1.minCalculations(i, j,lookup));
		System.out.println("No of times min is called: " +mult1.count1);
		System.out.println("Max no of calculcations:" + mult1.maxCalculations(i, j,lookup));
		System.out.println("No  of times max is called: "+ mult1.count2);
	}
}
