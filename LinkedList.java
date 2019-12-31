package siegelQuestions;

public class LinkedList{
	 
	Node head;
	
	 static class Node {
		 
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			next = null;	
		}
	}
	 
	 
	public int listSizeAndPrint(LinkedList example) {
		
		Node pointer = example.head;
		int count = 0;
		
		while (pointer != null) {
			System.out.println("Element number " + count+" : "+ pointer.data );
			count++;
			pointer= pointer.next;
		}
		
		System.out.println("Size of the list: " + count);
		
		return count;
		
	}

	public static void main (String args []) {
	
		LinkedList test = new LinkedList();
		Node second = new  Node(2);
		Node third = new Node(3);
		
		test.head = new Node(1);
		test.head.next = second;
		second.next =  third;
		test.listSizeAndPrint(test);
		
	}
}
