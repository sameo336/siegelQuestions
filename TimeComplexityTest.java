package siegelQuestions;

public class TimeComplexityTest {

	public void printNumbers(int N) {
		int count = 0;
		for (int i = N; i > 0; i /= 2) 
		    for (int j = 0; j < i; j++) 
		        System.out.println(count++);
	}
	
	public static void main(String [] args)
	{
		TimeComplexityTest example1 = new TimeComplexityTest();
		example1.printNumbers(8 );
	}
}
