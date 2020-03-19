package siegelQuestions;
 
public class StackSort<T extends Comparable<T>>{
	MyStack<T> tempStack;
	
	public StackSort() {
		tempStack = new MyStack<T>();
	}
	
	public int size(MyStack<T> s1) {
		int count=0;
		while (!s1.isEmpty()) {
			s1.pop();
			count++;
		}
		return count;
		
	}
	private MyStack<T> StackSortFn (MyStack<T> s1) {
		T temp;
		while (!s1.isEmpty()) {
		    
			if (tempStack.isEmpty()) { 
            	tempStack.push(s1.pop());
            }
		    
			temp =s1.pop();
			
			if (temp.compareTo(tempStack.peek()) == -1||temp.compareTo(tempStack.peek()) ==  0 ) {
				while (!tempStack.isEmpty() && tempStack.peek().compareTo(temp) ==1) {
	            	s1.push(tempStack.pop());
	           
				}
			}
			tempStack.push(temp);

	
		}
		
		while (!tempStack.isEmpty()) {
			s1.push(tempStack.pop());
		}
	return s1;
	}
	
	public static void main (String args[]) {
		StackSort<Integer> test = new StackSort<Integer>();
		MyStack<Integer> s1 = new MyStack<Integer>();
		s1.push(2);
		s1.push(0);
		s1.push(6);
		s1.push(5);
		s1.push(1);
		s1.printStackandSize();
		test.StackSortFn(s1);
		s1.printStackandSize();
		
		
	}
}