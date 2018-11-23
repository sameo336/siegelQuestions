package siegelQuestions;
import java.util.*;

public class GreatestCommonSubsequenceLookupTest {
	Integer [] [] lookUp;
	int count=0;
	public int gcl(ArrayList <String> A,ArrayList <String> B, int length)
	{
		this.count++;
 		int lengthA= A.size();
		int lengthB = B.size();
		
		if (lengthA == 0 || lengthB == 0)
		{
			/*if (lengthA == 0 && lengthB!=0) 
			{
				this.lookUp[0][lengthB-1] = length;
			}
			else if (lengthB ==0 && lengthA!=0) 
			{
				this.lookUp[lengthA-1][0] = length;
			}
			else 
			{
				this.lookUp[0][0] = length;

			}*/
			return length;
		}
		if (this.lookUp[lengthA-1][lengthB-1] !=null)
		{
			return this.lookUp[lengthA-1][lengthB-1];
		}
		if  (A.get(lengthA-1)==B.get(lengthB-1)) 
		{
			
			A.remove(lengthA-1);
			B.remove(lengthB-1);
			length = gcl(A,B,length);
			length = length +1;
		}
		else 
		{
			ArrayList<String> A1 = new ArrayList<String>(A.subList(0,lengthA-1));
			ArrayList<String> B1 = new ArrayList<String>(B.subList(0,lengthB-1));

			length = Math.max(length, Math.max(gcl(A1,B,length),gcl(A,B1,length)));
		}
		this.lookUp[lengthA-1][lengthB-1] = length;
		return length;
	}
	
	public static void main(String[] args) 
	{
		GreatestCommonSubsequenceLookupTest gcl = new GreatestCommonSubsequenceLookupTest();
		ArrayList <String> A= new ArrayList <String> ();
		ArrayList <String> B= new ArrayList <String> ();
		A.add("A");
		A.add("A");
		A.add("d");
		A.add("c");
		
		
		B.add("A");
		B.add("A");
		B.add("d");
		B.add("f");
		B.add("c");
		
		
		gcl.lookUp = new Integer[A.size()][B.size()];
		System.out.println(gcl.gcl(A,B,0));
		System.out.println("No of time GCl has been called: "+ gcl.count);
		
		for (int row = 0;row< gcl.lookUp.length ;row++) {
			for(int col =0; col<gcl.lookUp[0].length; col++) {
				System.out.printf(" ("+row+","+col+"):" + gcl.lookUp[row][col]);
			}
			System.out.println();
		}
		
	}
	
}
