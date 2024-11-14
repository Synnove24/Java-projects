import java.util.Arrays; //imports arrays
public class RingBuffer {
	//instance variables
	double[] queue; //array
	int capacity; //total capacity of array
	int first; //front of queue
	int size; //size of queue
	
	/*constructor*/
	public RingBuffer(int capacity) {
		this.capacity = capacity;
		queue = new double[capacity];
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
	public double peek() {
		return queue[first];
	}
	
	/**
	 * Enqueue takes an integer and inserts it into queue
	 * <p>
	 * @param: int, the item you want to insert into queue
	 */
	public void enqueue (double item) {
		//if queue is full (reaches capacity) throw an error
		if (isFull()) throw new RuntimeException ("Your queue is full");
		//wrap around mechanism
		queue[(first + size) % capacity] = item;
		size++;
	}
	
	/**
	* delete and return item from the front
	* <p>
	* @return item from the front
	*/
	public double dequeue(){
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
	
	/**
	 * toString function prints out all items
	 */
	
	public String toString() {
		//initialize a string
	    String queueString = "[";
	    //loops through queue
	    for (int i = 0; i < size; i++) {
	        int index = (first + i) % capacity; //wrap around mechanism
	        queueString += queue[index] + " ";
	    }
	    queueString += "]";
	    return queueString;
	}
	
	
	public static void main (String[] args) {
		//RingBuffer Test
		RingBuffer q1 = new RingBuffer(3);
		
		//Size Test
		System.out.println("Size: " + q1.size());
		q1.enqueue(1);
		System.out.println("Size: " + q1.size());
		
		//isEmpty Test
		RingBuffer q2 = new RingBuffer(3);
		System.out.println("Is it empty: " + q1.isEmpty());
		System.out.println("Is it empty: " + q2.isEmpty());
		
		//isFull Test
		q1.enqueue(2);
		q1.enqueue(3);
		System.out.println("Is it full: " + q1.isFull());
		System.out.println("Is it full: " + q2.isFull());
		
		//Peek Test
		System.out.println("First in line: " + q1.peek());
		
		//enqueue and dequeue Test
		System.out.println(q1);
		q1.dequeue();
		System.out.println(q1);
		q1.enqueue(2); 
		System.out.println(q1);
		



		


	}
}