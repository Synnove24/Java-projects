public class IntegerPeekStack extends IntegerStack implements Structure{

	//It is its own object
	//but it inherits all of the public functions and instance from Stack
	//children class or subclass of Integer Stack
	//IntegerStack is the parent class or superclass
	
	public String message;
	
	
	/*constructor*/
	public IntegerPeekStack(int capacity) {
		//can use parents instructor
		super(capacity);
		message = "This is my welcome message";
	}
	
	/**
	 * Peek will look at ith member in the stack and return it
	 */
	
	public int peek(int i) {
		if (isEmpty()) throw new RuntimeException("Can't peek at empty stack");
		else if (i > size -1) throw new RuntimeException("Trying to look at a member that is not there");
		else {
			return stack[i];
		}
	}

	
	//What if we don't like one of the parents function
	//we can overwrite it
	public int pop() {
		return 2;
	}
}