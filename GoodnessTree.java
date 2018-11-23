package siegelQuestions;

public class GoodnessTree {

	static int [] data = {-6,2,-6,-3,-1,-5,-2};
	int count=0;
	
	public int bestPreArbitaryTree(int i, int j, int value) 
	{
		if (i == j) 
		{
			System.out.println((count++)+" 1.A(" +i+","+j+")" +" Value:" +data[i]);
			return data[i];
		}
		else 
		{
			for (int k=(i+1);k<=j;k++) 
			{
				value = Math.max(value,this.bestPreArbitaryTree(i,k-1,Integer.MIN_VALUE)+
						2*(this.bestPreArbitaryTree(k,j,Integer.MIN_VALUE)));
			}
		}
		System.out.println((count++)+" 2.A(" +i+","+j+")" +" Value:" +value);
		return value;
	}
	

	public int bestPostArbitaryTree(int i, int j, int value) 
	{
		if (i == j) 
		{
			System.out.println((count++)+" 1.A(" +i+","+j+")" +" Value:" +data[i]);
			return data[i];
		}
		else 
		{
			for (int k=(i+1);k<=j;k++) 
			{
				value = Math.max(value,2*(this.bestPostArbitaryTree(i,k-1,Integer.MIN_VALUE))+
						this.bestPostArbitaryTree(k,j,Integer.MIN_VALUE));
			}
		}
		System.out.println((count++)+" 2.A(" +i+","+j+")" +" Value:" +value);
		return value;
	}

	
	
	public int bestBinaryTree(int i, int j, int value) 
	{
		if (i > j) 
		{
			System.out.println((count++)+" 1.A(" +i+","+j+")" +" Value:" +0);
			return 0;
		}
		else 
		{
			for (int k=i;k<=j;k++) 
			{
				value = Math.max(value,
						2*(this.bestBinaryTree(i,k-1,Integer.MIN_VALUE))+
						2*(this.bestBinaryTree(k+1,j,Integer.MIN_VALUE))+ data[k]);
			}
		}
		System.out.println((count++)+" 2.A(" +i+","+j+")" +" Value:" +value);
		return value;
	}
	
	public static void main (String [] args) 
	{
		GoodnessTree tree = new GoodnessTree();
		System.out.println("Highest Pre Order Arbitary Value: "+tree.bestPreArbitaryTree(0, 6, Integer.MIN_VALUE));
	
		System.out.println("Highest Post Order Arbitary Value: "+tree.bestPostArbitaryTree(0, 6, Integer.MIN_VALUE));

		System.out.println("Highest Binary Value: "+tree.bestBinaryTree(0, 6, Integer.MIN_VALUE));

	
	}
	
}
