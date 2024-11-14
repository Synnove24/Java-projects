import java.util.Arrays;

public class GuitarString {
	
	//instances
	double frequency;
	double[] init; //array with doubles
	int size; //size of queue
	int count; //count of tics
	int capacity; //total capacity of array
	RingBuffer rb; //initialize a ringbuffer
	
	
	/**
	 * constructor
	 * create a guitar string of the given frequency, using a sampling rate of 44,100
	 * @param frequency
	 */
	public GuitarString(double frequency ) {
		this.frequency = frequency;
		//sampling rate divided by frequency
		int N = (int) (44100.0 / frequency);
		rb = new RingBuffer(N); //creates a ringbuffer with frequency
		//fills queue with zeros
		for (int i=0; i<N;i++) {
			rb.enqueue(0);
		}
		//System.out.println(Arrays.toString(rb.queue)); //test

	}
	
	/**
	 * constructor
	 * create a guitar string whose size and initial values are given by the array
	 * @param init
	 */
	public GuitarString(double[] init) {
		this.init = init;
		int N = init.length; //length
		rb = new RingBuffer(N); //creates ringbuffer
		//initial values giden by init 
		for (int i=0; i<N; i++) {
			rb.enqueue(init[i]);
		}
		//System.out.println(Arrays.toString(rb.queue)); //test
	}
	
	/**
	 * set the buffer to white noise
	 * Pluck. Replace the N items in the ring buffer with N random values between -0.5 and +0.5.
	 */
	
	public void pluck() {
		size = rb.size(); 
		double N; //initalize for random variable
		//empties the queue
		for (int i=0; i<size; i++) {
			rb.dequeue();
		}
		//refills the queue with random doubles
		for (int i=0; i<size; i++) {
			double r = Math.random();
			N = r -.5;
			rb.enqueue(N);
		}
		
	}
	
	/**
	 * advance the simulation one time step
	 */
	public void tic() {
		double energyDecayFactor = .994;
		// first value in queue
		double firstSample = rb.peek();
		rb.dequeue();
		//second value in queue
		double secondSample = rb.peek();
		//creates new sample to be enqueued at the end
		double newSample = energyDecayFactor * .5 * (firstSample + secondSample );
		rb.enqueue(newSample);
		//counts tics
		count++;
	}
	
	/**
	 * return the current sample
	 * @return
	 */
	public double sample() {
		return rb.peek();
	}
	/**
	 * return number of tics
	 * @return
	 */
	public int time() {
		return count;
	}
	
	/**
	 * print prints out the current Ring Buffer Queue (for testing)              
	 */
	

	
	public static void main (String[] args) {
		//First GuitarString Test (need to uncomment test in function)
		GuitarString q1 = new GuitarString(4440); //guitar string test
		
		//Second GuitarString Test (need to uncomment test in function)
		double [] array = new double [4];
		for (int i = 0; i<4;i++) {
			array[i] = i+1;
			
		}
		GuitarString q2 = new GuitarString(array); //guitar string array test
		
		//Pluck test
		q2.pluck();
		q1.pluck();
		
		//Tic Test
		q1.tic();
		q2.tic();
		
		//Sample Test
		System.out.println("Sample: " + q1.sample());
		System.out.println("Sample: " + q2.sample());
		
		//Time Test
		System.out.println("Number of tics: " + q1.time());
		System.out.println("Number of tics: " + q2.time());
		q1.tic();
		q2.tic();
		System.out.println("Number of tics: " + q1.time());
		System.out.println("Number of tics: " + q2.time());
		
		
		
		
	}
}