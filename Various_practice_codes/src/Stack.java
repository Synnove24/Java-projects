public class Stack {
	//instance variables
	public int [] stack; //the array to build stack
	public int capacity; //array capacity
	public int size; //keep track of size and top of stack
	
	/*constructor*/
	
	public Stack (int capacity1) {
		capacity = capacity1;
		stack = new int[capacity1];
		size = 0; //initially its empty
	}
	
	/*return if stack if empty
	 * true if empty
	 */
	
	public boolean isEmpty() {
		return (size ==0);
	}
	
	/* return true if stack is full*/
	
	public boolean isFull() {
		return (size ==capacity);
	}

	/* return the top of the stack*/
	
	public int top() {
		if (isEmpty()) throw new RuntimeException ("Stack is empty");
		return stack[size-1];
	}
	
	/*takes an integer and puts it onto the stack*/
	
	public void push(int item) {
		if(isFull()) doubleCapacity();
		stack[size] = item;
		size++;
	}
	
	
	/*returns string representation of your stack*/
	
	public String toString() {
		String s = "[";
		for (int i = size-1; i>=0; i--) {
			s = s + stack[i] + " ";
		}
		s = s + "]";
		return s;
	}
	
	/*pops an item out off the top and returns it back*/
	
	public int pop() {
		if (isEmpty()) throw new RuntimeException ("You are trying to pop a stack when its empty");
		int item = stack[size -1];
		size--;
		return item;
	}
	
	/*if stack is full, create a new array twice the size of old array, 
	 * migrate previous stack into this new array
	 */
	
	public void doubleCapacity() {
		int[] newStack = new int[2*capacity];
		for (int i = 0; i< capacity; i++) {
			newStack[i] = stack[i];
		}
		stack = newStack;
		capacity = 2* capacity;
		
	}
	
	
	public static void main(String[] args) {
		//test 1, exception cases
		Stack s2 = new Stack(1);
		s2.push(12);
		s2.push(13);
		s2.push(14);
		System.out.println(s2.top());
		System.out.println(s2);
		
		Stack s1 = new Stack(10);
		s1.push(5);
		s1.push(10);
		s1.push(20);
		System.out.println(s1);
		s1.pop();
		System.out.println(s1);
	}
}