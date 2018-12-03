package siegelQuestions;
import java.util.*;
import siegelQuestions.IntPair;

public class GCS_with_proper_decisionTree {
	Integer [] [] lookUp;
	IntPair [] [] decisionTree;
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
			this.decisionTree[lengthA-1][lengthB-1] = new IntPair(A.size()-1,B.size()-1);
			length = gcl(A,B,length);
			length = length +1;
		}
		else 
		{
			ArrayList<String> A1 = new ArrayList<String>(A.subList(0,lengthA-1));
			ArrayList<String> B1 = new ArrayList<String>(B.subList(0,lengthB-1));
			
			int lengthA1 = A1.size();
			int lengthB1 = B1.size();
			//length = Math.max(length, Math.max(gcl(A1,B,length),gcl(A,B1,length)));
			int temp1 =gcl(A1,B,length);
			int temp2 =gcl(A,B1,length);
			
			if (temp1 > temp2) {
				length =temp1;
				this.decisionTree[lengthA-1][lengthB-1] = new IntPair(lengthA1-1,lengthB-1);

			}
			else {
				length =temp2;
				this.decisionTree[lengthA-1][lengthB-1] = new IntPair(lengthA-1,lengthB1-1);

			}
		}
		this.lookUp[lengthA-1][lengthB-1] = length; 
		return length;
	}
	
	public void printSequence(int i,int j, ArrayList<String> B)
	{
		if (i != -1 & j !=-1) {
			
			IntPair pair= this.decisionTree[i][j];
			int g = pair.x;
			int k = pair.y;
			printSequence( g, k, B);
			if (g == i-1 & k == j-1) 
			{
				System.out.println("A[" + i +"] equals B[" + j +"]" +  B.get(j));
			}
			
		}
		
	}
	
	public static void main(String[] args) 
	{
		GCS_with_proper_decisionTree gcl = new GCS_with_proper_decisionTree();
		ArrayList <String> A= new ArrayList <String> ();
		ArrayList <String> B= new ArrayList <String> ();
		ArrayList <String> B1= new ArrayList <String> ();
		ArrayList <String> A1= new ArrayList <String> ();
		ArrayList <String> C1= new ArrayList <String> ();
		ArrayList <String> D1= new ArrayList <String> ();
		ArrayList <String> D2= new ArrayList <String> ();

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
		
		B1.add("A");
		B1.add("A");
		B1.add("d");
		B1.add("f");
		B1.add("d");
		B1.add("A");
		B1.add("A");
		B1.add("A");
		B1.add("A");
		B1.add("d");
		B1.add("e");
		B1.add("e");
		B1.add("e");
		B1.add("e");
		B1.add("e");
		B1.add("e");
		B1.add("e");
		B1.add("a");
		B1.add("a");
		B1.add("a");
		B1.add("a");
		

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
		
		
		C1.add("a");
		C1.add("b");
		
		D1.add("a");
		D1.add("a");
		D1.add("a");
		D1.add("a");
		D1.add("b");
		D1.add("b");
		D1.add("b");
		
		D2.add("a");
		D2.add("a");
		D2.add("a");
		D2.add("a");
		D2.add("b");
		D2.add("b");
		D2.add("b");
		
		
		gcl.lookUp = new Integer[A.size()][B.size()];
		gcl.decisionTree = new IntPair[A.size()][B.size()];
		gcl.sequence = new ArrayList<String> ();
		System.out.println(gcl.gcl(A,B,0));
		System.out.println("No of time GCl has been called: "+ gcl.count);
 
		System.out.println("Decisions Table");
		for (int i=0; i< gcl.decisionTree.length;i++) 
		{
			for (int j=0; j <gcl.decisionTree[i].length;j++) 
			{
				System.out.printf(" ("+(i)+","+(j)+"):" +gcl.decisionTree[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("Lookup Table");
		for (int row = 0;row< gcl.lookUp.length ;row++) {
			for(int col =0; col<gcl.lookUp[0].length; col++) {
				System.out.printf(" ("+row+","+col+"):" + gcl.lookUp[row][col]);
			}
			System.out.println();
		}
		
		for (int i=0; i< A1.size();i++) 
		{
			
			System.out.println(A1.get(i));
		}
				
		gcl.printSequence(14,19, B1);
		
		System.out.println("EXIT!");
	}
	 
}
