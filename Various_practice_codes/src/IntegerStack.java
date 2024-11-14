public class IntegerStack implements Structure{
	//instance variables
	//only child can use protected
	protected int [] stack; //the array to build stack
	//no other class can access private
	private int capacity; //array capacity
	public int size; //keep track of size and top of stack
	
	/*constructor*/
	
	public IntegerStack (int capacity) {
		this.capacity = capacity;
		stack = new int[capacity];
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
	
	/**
	 * overloading the push function that takes in 2 items
	 */
	public void push(int item1, int item2) {
		if(isFull()) doubleCapacity();
		stack[size] = item1;
		size++;
		stack[size] = item2;
		size++;
	}
	
	
	/*returns string representation of your stack*/
	
	public String toString (){
		String s = "";
		for (int i = size-1; i >= 0; i--)
			s = s + stack[i] + " ";
		return s;
	}
	
	/*pops an item out off the top and returns it back*/
	
	public int pop() {
		if (isEmpty()) throw new RuntimeException ("You are trying to pop a stack when its empty");
		int item = stack[size -1];
		size--;
		return item;
	}
	
	public int popbottom() {
	    if (isEmpty()) throw new RuntimeException ("You are trying to pop a stack when its empty");
	    int item = stack[0]; // Get the first element to return
	    // Shift all elements towards the beginning
	    for (int i = 0; i < size - 1; i++) {
	        stack[i] = stack[i + 1];
	    }
	    size--; // Decrease the size of the stack
	    return item; // Return the first element
	}
	
	public int popindex(int index) {
	    if (index < 0 || index >= size) {
	        throw new RuntimeException("Index out of bounds");
	    }
	    
	    if (isEmpty()) {
	        throw new RuntimeException("Stack is empty");
	    }
	    
	    int item = stack[index]; // Get the item at the specified index
	    
	    // Shift all elements after the index towards the beginning
	    for (int i = index; i < size - 1; i++) {
	        stack[i] = stack[i + 1];
	    }
	    
	    size--; // Decrease the size of the stack
	    return item; // Return the item at the specified index
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
		IntegerStack q1 = new IntegerStack(5);
		q1.push(1);
		System.out.println(q1);
		q1.push(2);
		System.out.println(q1);
		q1.push(3);
		System.out.println(q1);
		q1.push(4);
		System.out.println(q1);
		q1.push(5);
		System.out.println(q1);
		q1.push(6);
		System.out.println(q1);
		//q1.pop();
		System.out.println(q1);
		//q1.popbottom();
		System.out.println(q1);
		q1.popindex(5);
		System.out.println(q1);

	}
}