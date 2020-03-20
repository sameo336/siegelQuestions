package siegelQuestions;
import java.util.Iterator;
import java.util.LinkedList;

interface MyLambda{
	
	String checkDogCat(Integer x);
}

public class AnimalShelterQueue {
	
	static  LinkedList<Integer> shelter = new LinkedList<Integer>();
	
	private void enqueue(Integer animal) {
			shelter.add(animal);		
	}
	
	private Integer dequeueAny() {
		if (shelter.isEmpty()) {
			 throw new IllegalArgumentException("List is empty");
		}
		return shelter.remove();
	}
	
	private Integer dequeueDog() {
		Integer data = null;
		if (shelter.isEmpty()) {
			 throw new IllegalArgumentException("List is empty");
		}
		for (int i=0;i<shelter.size();i++) {
			data = shelter.get(i);
			if (data ==1) {
				shelter.remove(i);
			}
		}
		return data;
		
	}
	
	private Integer dequeueCat() {
		Integer data = null;
		if (shelter.isEmpty()) {
			 throw new IllegalArgumentException("List is empty");
		}
		for (int i=0;i<shelter.size();i++) {
			data = shelter.get(i);
			if (data ==0) {
				shelter.remove(i);
			}
		}
		return data;
		
	}
	
	MyLambda isDogOrCat = (Integer x)->{
		if (x ==1) {
			return "Dog";
		}
		else
			return "Cat";
	};
	
	public void printShelter() {
		for (int i=0;i<shelter.size();i++) {
				System.out.println("Animal at index :" +i+ " is a " + isDogOrCat.checkDogCat(shelter.get(i)));
			
			}
	}
	
	public static void main(String args[]) {
		
		AnimalShelterQueue test = new AnimalShelterQueue();
		shelter.add(1);
		shelter.add(0);
		shelter.add(1);
		shelter.add(1);
		shelter.add(0);
		test.printShelter();
		test.dequeueAny();
		test.dequeueDog();
		test.printShelter();
		
	}
}

