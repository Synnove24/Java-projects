public class genericStack <Synnove> {
	// these are my instance variables of type stack
	protected Synnove [] stack;
	private int capacity; // the size of your array
	protected int size; // the size of your stack. i.e., the elements you
	                  // are currently paying attention to. 
    /*constructor*/	
	public genericStack (int initialCapacity){
		stack = (Synnove[]) new Object [initialCapacity]; // create an array of size initialCapacity
		capacity = initialCapacity;
		size = 0; // nothing in my stack yet
	}
	
	/*
	 * This is the toSTring function, returns a String representation of the stack object
	 * @return String, the String representation of the stack object
	 */
	public String toString(){
		String s = "";
		for (int i = size-1; i>=0; i--){
			s = s + stack[i] + " ";
			
		}
		return s;
		
	}

	/* return if the stack is empty or not 
	 * @return: boolean, indicating if the stack is empty or not. 
	 * */
	public boolean isEmpty(){
		return size ==0;
	}
	
	public boolean isFull(){
		return size == capacity;
	}
	
	
	 /* 
	  * allows the user to push in an element
	  * @param:, int, the item the user is allowed to push in
	  * */
	public void push (Synnove item){
		size = size + 1;
		stack[size-1] = item;
	}
	

	
	
	/*
	 * This function returns the top item of your stack
	 * @return: int, the top item of the stack which is an integer
	 */
	public Synnove top(){
		return stack[size-1];
	}
	
	public Synnove pop (){
		if (isEmpty()) throw new RuntimeException ("Trying to pop an empty stack");
		Synnove item = stack[size-1];
		size--;
		return item;
	}
	
	
	/* unit testing for Integer Stack class */
	public static void main(String[] args) {
		genericStack<Integer> intStack = new genericStack<Integer>(10);
		intStack.push(4);
		intStack.push(5);
		intStack.push(12);
		intStack.pop();
		System.out.println(intStack);
		genericStack<String> stringStack =  new genericStack<String>(20);
		stringStack.push("Hello");
		stringStack.push(" World");
		stringStack.push("Chris");
		stringStack.pop();
		System.out.println(stringStack);
		genericStack<Boolean> booleanStack = new genericStack<Boolean>(20);
		booleanStack.push(false);
		booleanStack.push(true);
	
		
		
		

	}
}