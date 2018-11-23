package siegelQuestions;
import java.util.*;

public class GreatestCommonLength {
	Integer [] [] lookUp;
	int count=0;
	ArrayList <String> sequence;
	public int gcl(ArrayList <String> A,ArrayList <String> B, int length)
	{
		this.count++;
 		int lengthA= A.size();
		int lengthB = B.size();
		
		if (lengthA == 0 || lengthB == 0)
		{
			return length;
		}
		if (this.lookUp[lengthA-1][lengthB-1] !=null)
		{
			return length + this.lookUp[lengthA-1][lengthB-1];
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
	
	public ArrayList<String> sequence (Integer [][] lookup, ArrayList <String> A)
	{
		int count = 2;
		int runner = 1;
		if (count ==0)
		{
			return null;
		}
		for (int row=0; row< lookup.length; row++) 
		{
			for (int col =0; col< lookup[0].length ; col++) 
			{
				try {
					if (lookup[row][col] == null) {
						continue;
					}
					if (lookup[row][col] == runner) 
					{
						runner++;
						this.sequence.add(A.get(row));
					}
				}
				catch (NullPointerException n) {
					System.out.println (n);
				}
			}
		}
		
		return this.sequence;
	}
	
	
	public static void main(String[] args) 
	{
		GreatestCommonLength gcl = new GreatestCommonLength();
		ArrayList <String> A= new ArrayList <String> ();
		ArrayList <String> B= new ArrayList <String> ();
		ArrayList <String> A1= new ArrayList <String> ();
		ArrayList <String> C1= new ArrayList <String> ();
		ArrayList <String> D1= new ArrayList <String> ();
		
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
		
		A1.add("A");
		A1.add("A");
		A1.add("d");
		A1.add("c");
		A1.add("A");
		A1.add("A");
		A1.add("A");
		A1.add("A");
		A1.add("e");
		A1.add("e");
		A1.add("e");
		A1.add("e");
		A1.add("e");
		A1.add("e");
		A1.add("e");
		
		
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
		
		C1.add("a");
		C1.add("b");
		
		D1.add("a");
		D1.add("a");
		D1.add("a");
		D1.add("a");
		D1.add("b");
		D1.add("b");
		D1.add("b");
		 
		
		
		gcl.lookUp = new Integer[C1.size()][D1.size()];
		gcl.sequence = new ArrayList<String> ();
		System.out.println(gcl.gcl(C1,D1,0));
		System.out.println("No of time GCl has been called: "+ gcl.count);
		
		for (int row = 0;row< gcl.lookUp.length ;row++) {
			for(int col =0; col<gcl.lookUp[0].length; col++) {
				System.out.printf(" ("+(row+1)+","+(col+1)+"):" + gcl.lookUp[row][col]);
			}
			System.out.println();
		}
		
		System.out.println(gcl.sequence(gcl.lookUp,D1));
		
	}
	 
}
