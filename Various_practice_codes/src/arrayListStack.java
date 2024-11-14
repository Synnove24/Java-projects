import java.util.ArrayList;

public class arrayListStack implements Structure {
	//instance variables
	ArrayList<Integer> q1;
	int size; //don't need since its built in
	
	public arrayListStack() {
		q1 = new ArrayList<Integer>(1);
		size = 0;
	}
	
	public void push(int item) {
		q1.add(item);
		size++;
	}
	
	public int pop() {
		int removedItem = q1.remove(size-1);
		size--;
		return removedItem;
	}
	
	public String toString() {
		return q1.toString();
	}
	
	public boolean isEmpty() {
		return q1.isEmpty();
	}
	
	public int top() {
		return q1.get(size-1);
	}
	
	
	public static void main (String[] args) {
		arrayListStack s1 = new arrayListStack();
		s1.push(3);
		s1.push(2);
		System.out.print(s1);
	}
}