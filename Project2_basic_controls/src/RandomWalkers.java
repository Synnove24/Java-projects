public class RandomWalkers{ //begin class
	public static void main (String[] args) { //begin main
		//simulates many drunken walkers taking steps in random directions
		//prints out mean squared distance of each walker at the end
		int n = Integer.parseInt(args[0]); //takes step number as argument
		int t = Integer.parseInt(args[1]); //takes the number of people as an argument
		//initializes x and y
		int x = 0;
		int y = 0;
		double total = 0; //total acts as the total squared distance before dividing
		//by t to get average
		for (int j =1; j<=t; j++) { //begin t for loop
			//resets x and y to 0
			x = 0;
			y = 0;
			//loop that simulates each step
			for (int i = 1; i<=n; i++) { //begin n for loop
				//takes a random float between 0 and 1
				double step = Math.random();
				//if statement separates the step into 4 random possibilities
				if (step < 0.25) x-=1;
				else if (step < 0.5) x+=1;
				else if (step < 0.75) y-=1;
				else y+=1;	
			} // end n for loop
			//calculates the squared distance for each walker
			int square = x*x + y*y;
			//keeps track of total squared distance
			total = total + square;
		}
		double meansquared = total/t; //calculates the mean squared distance
		//prints out the squared distance
		System.out.println("Mean Squared Distance: " + meansquared);	
	} //end main
	
} //end class