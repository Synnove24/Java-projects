public class RandomWalker{ //begin class
	public static void main (String[] args) { //begin main
		//simulates a drunken walker taking a steps in random directions
		//prints out squared distance at the end
		int n = Integer.parseInt(args[0]); //takes step number as argument
		//initializes x and y
		int x = 0;
		int y = 0;
		//loop that simulates each step
		for (int i = 1; i<=n; i++) { //begin for loop
			//takes a random float between 0 and 1
			double step = Math.random();
			//if statement separates the step into 4 random possibilities
			if (step < 0.25) x-=1;
			else if (step < 0.5) x+=1;
			else if (step < .75) y-=1;
			else y+=1;
			//prints out the current position
			System.out.println("(" + x + "," + y + ")");			
		} // end for loop
		//calculates the squared distance
		int square = x*x + y*y;
		//prints out the squared distance
		System.out.println("Squared Distance: " + square);	
	} //end main
	
} //end class