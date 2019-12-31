package siegelQuestions;
import java.util.HashSet;
import siegelQuestions.LinkedList;
import siegelQuestions.LinkedList.Node;

public class LinkedListDups {



	public void removeDups(LinkedList example){
	
		Node pointer = example.head;
		Node previous = null;
		HashSet<Integer> count = new  HashSet<Integer>();
		
		
		while (pointer != null){
		
			if (count.contains(pointer.data)){
				previous.next = pointer.next;				
			
			}
			else {
				count.add(pointer.data);
				previous = pointer;				
			}
				pointer = pointer.next;
		}
	}

	public void removeDupsTwoPointers(LinkedList example){
		
		if (example == null) {
			return;
		}
		
		Node front = null;
		Node behind = example.head;
		Node previous= null;
		
		while (behind !=null){
			front=behind.next;
			previous = behind;
			while (front !=null){
				
				if(behind.data == front.data){
					
					previous.next = front.next;
				
				}
				else
					previous = front;
				front = front.next;
			}
		
			behind = behind.next;
		}
	}
	
	public static void main (String args []){
	
		LinkedList example = new LinkedList();
		LinkedListDups test = new LinkedListDups();
		example.head = new Node(10);
		Node second = new Node(20);
		Node third = new Node(10);
		Node fourth = new Node(30);

		
		example.head.next = second;
		second.next = third;
		third.next = fourth;
		
		example.listSizeAndPrint(example);
		//test.removeDups(example);
		test.removeDupsTwoPointers(example);
		example.listSizeAndPrint(example);

	
	}

}
