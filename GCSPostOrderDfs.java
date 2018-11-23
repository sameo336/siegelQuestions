package siegelQuestions;
import java.util.*;

public class GCSPostOrderDfs {
	Integer [] [] lookUp;
	int count=0;
	public int gcl(ArrayList <String> A,ArrayList <String> B, int length)
	{
		this.count++;
 		int lengthA= A.size();
		int lengthB = B.size();
		
		if (lengthA == 0 || lengthB == 0)
		{
			return length;
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
		GCSPostOrderDfs gcl = new GCSPostOrderDfs();
		ArrayList <String> A= new ArrayList <String> ();
		ArrayList <String> B= new ArrayList <String> ();
		/*
		A.add("A");
		A.add("A");
		A.add("d");
		A.add("c");
		A.add("A");
		A.add("A");
		A.add("A");
		A.add("A");
		A.add("e");
		A.add("e");
		A.add("e");
		A.add("e");
		A.add("e");
		A.add("e");
		A.add("e");
		
		
		B.add("A");
		B.add("A");
		B.add("d");
		B.add("f");
		B.add("d");
		B.add("A");
		B.add("A");
		B.add("A");
		B.add("A");
		B.add("d");
		B.add("e");
		B.add("e");
		B.add("e");
		B.add("e");
		B.add("e");
		B.add("e");
		B.add("e");
		B.add("a");
		B.add("a");
		B.add("a");
		B.add("a");
		*/ 
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
				System.out.printf(" ("+(row+1)+","+(col+1)+"):" + gcl.lookUp[row][col]);
			}
			System.out.println();
		}
		
	}
	
}
