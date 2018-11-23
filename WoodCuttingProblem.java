package siegelQuestions;
import java.util.*;

public class WoodCuttingProblem {

	public Integer [][] value;
	public Integer []decisions;

	
	
	public int MaxValue(Integer [] [] value, int i, int j) {
		int price = 0;
		System.out.println("price: "+price);
		System.out.println("j: "+j);
		System.out.println("i: "+i);


		if (i == j || i <0 || j <0) 
		{
			return 0;
		}
		this.decisions[j] = 0;

		for (int k = i;k<j; k++) 
		{
 			int temp =MaxValue(value, i, k) + value[k][j] + Cost(k,j,i);
 			System.out.println("temp: "+temp);
 			if (temp > price) 
 			{
 				price =temp;
 				this.decisions[j] = k;
 				
  			}

 			

		} 
		System.out.println("final price: " +i + "," +j+ " "+price);
		return price;
	}
	
	public int Cost(int k, int j, int i) 
	{
		if (i == k) 
		{
			return 0;
		}
		return -1;
	}
	
	
	public static void main(String [] args) 
	{
		WoodCuttingProblem example =new WoodCuttingProblem();
		example.value = new Integer [8][8];
		example.decisions = new Integer [8];
		example.initializeValues();
		int result =example.MaxValue(example.value, 0, 7);
		System.out.println("Result:"+result);
		for (int i=0; i< example.decisions.length;i++) 
		{

				System.out.printf(" ("+(i)+"):" +example.decisions[i]);

		}
		
		System.out.println("\n EXIT!");
	}
	
	public void initializeValues() 
	{
		this.value[0][1]=2;
		this.value[0][2]=1;
		this.value[0][3]=1;
		this.value[0][4]=2;
		this.value[0][5]=2;
		this.value[0][6]=3;
		this.value[0][7]=4;
		

		this.value[1][2]=0;
		this.value[1][3]=1;
		this.value[1][4]=2;
		this.value[1][5]=2;
		this.value[1][6]=3;
		this.value[1][7]=5;


		this.value[2][3]=2;
		this.value[2][4]=5;
		this.value[2][5]=8;
		this.value[2][6]=12;
		this.value[2][7]=16;


		this.value[3][4]=2;
		this.value[3][5]=5;
		this.value[3][6]=8;
		this.value[3][7]=12;
		
		this.value[4][5]=2;
		this.value[4][6]=5;
		this.value[4][7]=8;
		
		this.value[5][6]=2;
		this.value[5][7]=5;
		this.value[6][7]=2;
		
		
	}

}
