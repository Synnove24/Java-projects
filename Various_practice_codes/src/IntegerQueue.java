public class IntegerQueue implements Structure{
	//instance variables
	int[] queue;
	int capacity;
	int first; //front of queue
	int size; //size of queue
	
	public IntegerQueue(int capacity) {
		this.capacity = capacity;
		queue = new int[capacity];
		size = 0;
		first = 0;		
	}
	
	/**
	 * return size of queue
	 * <p>
	 * @return: int, the size of queue
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Return true if queue is empty
	 * <p>
	 * @return: boolean, true is queue is empty
	 */
	public boolean isEmpty() {
		return size==0;
	}
	
	/**
	 * Return true if queue is full
	 * <p>
	 * @return: boolean, true is queue is full
	 */
	public boolean isFull() {
		return size==capacity;
	}
	
	/**
	 * Peek allows you to look at the start of the queue
	 * <p>
	 * @return: int, the first item of your queue
	 */
	public int top() {
		return queue[first];
	}
	
	/**
	 * Enqueue takes an integer and inserts it into queue
	 * <p>
	 * @param: int, the item you want to insert into queue
	 */
	public void push (int item) {
		//if queue is full (reaches capacity) throw an error
		if (isFull()) throw new RuntimeException ("Your queue is full");
		//wrap around mechanism
		else {
			queue[(first + size) % capacity] = item;
			size++;
		}
		
	}
	
	/**
	* delete and return item from the front
	* <p>
	* @return item from the front
	*/
	public int pop(){
		//run time error if queue is empty
		if (isEmpty()) throw new RuntimeException("Your Queue is empty");
		else{
			int oldfirst = first; // remembers the index
			first++;
			size--; //shortens the array by one
			if (first == queue.length) first = 0; // if the new first is the length, then its 0
			return queue[oldfirst]; //returns oringial first
		}
	}
	
	public int poplast(){
		//run time error if queue is empty
		if (isEmpty()) throw new RuntimeException("Your Queue is empty");
		else{
			int item = queue[size -1];
			size--;
			return item;
		}
	}
	
	public int popindex(int index) {
	    // Check if the specified index is valid
	    if (index < 0 || index >= size) {
	        throw new RuntimeException("Index out of bounds");
	    }
	    
	    // Get the index in the array based on the current 'first' index
	    int arrayIndex = (first + index) % capacity;
	    int item = queue[arrayIndex]; // Get the item at the specified index
	    
	    // Shift all elements after the specified index towards the beginning of the queue
	    for (int i = index; i < size - 1; i++) {
	        int currentArrayIndex = (first + i) % capacity;
	        int nextArrayIndex = (first + i + 1) % capacity;
	        queue[currentArrayIndex] = queue[nextArrayIndex];
	    }
	    
	    // Update 'first' index and decrease the size of the queue
	    size--;
	    
	    return item; // Return the item at the specified index
	}

	
	/**
	 * toString function prints out all items
	 */
	
	public String toString() {
		//initialize a string
	    String queueString = "";
	    //loops through queue
	    for (int i = 0; i < size; i++) {
	        int index = (first + i) % capacity; //wrap around mechanism
	        queueString += queue[index] + " ";
	    }
	    return queueString;
	}
	
	
	public static void main (String[] args) {
		IntegerQueue q1 = new IntegerQueue(5);
		q1.push(1);
		System.out.println(q1);
		q1.push(2);
		System.out.println(q1);
		q1.push(3);
		System.out.println(q1);
		q1.push(4);
		System.out.println(q1);
		//q1.push(5);
		System.out.println(q1);
		//q1.push(6);
		System.out.println(q1);
		//q1.pop();
		System.out.println(q1);
		//q1.popbottom();
		System.out.println(q1);
		q1.popindex(1);
		System.out.println(q1);
		q1.push(5);
		System.out.println(q1);
		
	}
}