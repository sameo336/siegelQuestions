package siegelQuestions;
import java.util.*;
class IntPair {
	  // Ideally, name the class after whatever you're actually using 
	  // the int pairs *for.*
	  final int x;
	  final int y;
	  IntPair(int x, int y) {this.x=x;this.y=y;}
	  
	  // depending on your use case, equals? hashCode?  More methods?
	  @Override
	  public String toString() {
		     return("(" + Integer.toString(x) + "," + Integer.toString(y) + ")" );
		  }
	  public static void main (String [] args) 
	  {
		  IntPair [] [] decisionTree = new IntPair[10][10];
		  decisionTree[9][9]=new IntPair(8,7);
		  
		  System.out.println(decisionTree[9][9]);
		  
		  IntPair a =decisionTree[9][9];
		  System.out.println(a.x);
		  
		  ArrayList <String> B = new ArrayList ();
		  B.add("A");
		  System.out.println(B.get(0));
		  
	  }

}