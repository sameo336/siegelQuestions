package siegelQuestions;
import siegelQuestions.LinkedList.Node;

public class LinkedListKthLastElement {

	public int getKLastElement(LinkedList example, int k){
	
		Node front = example.head;
		int count=k;
		while(count >0){
				front = front.next;
				count --;
				if (front == null && count!=0){
					System.out.println("Size of the LinkedList is smaller than k");
					return 0;
				}
		}
		
		Node back = example.head;
		
		while (front!=null){
			front= front.next;
			back = back.next;
		}
		System.out.println(  k + "" +"th last element is :" + back.data);
		return back.data;
		
	}
	
	public static void main(String args[]) {
		LinkedList test = new LinkedList();
		LinkedListKthLastElement element = new LinkedListKthLastElement();
		test.head= new Node(10);
		Node second = new Node(20);
		Node third = new Node(30);
		Node fourth = new Node(40);
		Node fifth = new Node(50);
		
		test.head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		
		element.getKLastElement(test,6);
	}
	
}
