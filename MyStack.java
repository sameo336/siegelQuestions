package siegelQuestions;

import java.util.EmptyStackException;

public class MyStack<T> {

	StackNode<T> top;
	
	private static class StackNode<T>{
		
		T data;
		StackNode<T> next;
	
		public StackNode(T data){
			this.data =  data;
		}
		
	}
	
	public void push (T data){
		StackNode<T> node  = new StackNode<T> (data);
		node.next = top;
		top = node;
	}
	
	public T pop () {
		
		if (top == null) {
			throw new EmptyStackException();
		}
		T data = top.data;
		top = top.next;
		return data;
	}
	
	public void printStackandSize() {
		int count=0;
		StackNode<T> pointer = this.top;
		while (pointer!=null) {
			System.out.println("Element number: "+ count + ": " + pointer.data);
			pointer = pointer.next;
			count++;
		}
		System.out.println("Size of the Stack: " + count);
	}
	public T peek() {
		
		if (top == null) {
			throw new EmptyStackException();
		}
		T data = top.data;
		return data;
	}
	
	public boolean isEmpty() {
		
		return top == null;
	}
	
}
