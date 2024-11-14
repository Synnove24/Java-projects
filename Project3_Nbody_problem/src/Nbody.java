import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Nbody { //start class

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {

		//gather time parameters
		double big_t = Double.parseDouble(args[0]);
		double delta_t = Double.parseDouble(args[1]);

		
		String resourceFolder = "resources/";
		String fileName = resourceFolder + args[2];
		FileInputStream fileInputStream = new FileInputStream(fileName);
		System.setIn(fileInputStream);

		// Use StdIn to read from the file.
		int numBodies = StdIn.readInt();
		double universeRadius = StdIn.readDouble();

		// Print out the values read in (remove all this from your final version)
		StdOut.println("big_t          = " + big_t);
		StdOut.println("delta_t        = " + delta_t);
		StdOut.println("numBodies      = " + numBodies);
		StdOut.println("universeRadius = " + universeRadius);

		//declare arrays for positions, velocities, masses, and pictures
		double[] posX = new double[numBodies];
		double[] posY = new double[numBodies];
		double[] velX = new double[numBodies];
		double[] velY = new double[numBodies];
		double[] Mass = new double[numBodies];
		String[] pictures = new String[numBodies];

		//creates the arrays from the text file
		for (int i = 0; i < numBodies; i++) {
			posX[i] = StdIn.readDouble();
			posY[i] = StdIn.readDouble();
			velX[i] = StdIn.readDouble();
			velY[i] = StdIn.readDouble();
			Mass[i] = StdIn.readDouble();
			pictures[i] = StdIn.readString();
		}

		// put up a picture of background sky
		StdDraw.setXscale(-universeRadius, universeRadius);
		StdDraw.setYscale(-universeRadius, universeRadius);
		// put up a picture of starry night
		

		//define constants
		double G = 6.674 * (Math.pow(10, -11)); // gravitational constant

		double step = 0; //initialize step for while loop
		while (step < big_t) { // start while

			//draw background again
			StdDraw.picture(0, 0, "resources/starfield.jpg");

			//outer loop to calculate forces
			for (int i = 0; i < numBodies; i++) { // start i loop
				double fx = 0; // force x-direction
				double fy = 0; // force y-direction
				//inner loop for calculating the affect from each other body
				for (int j = 0; j < numBodies; j++) { // start j loop
					double f = 0; //force
					if (i != j) { // start if-statement
						double dx = posX[j] - posX[i]; // delta x
						double dy = posY[j] - posY[i]; // delta y
						double r = Math.sqrt(dx * dx + dy * dy); // calculate r
						f = (Mass[i] * Mass[j] * G) / (r * r); // calculate f 
						//calculate force components
						fx += f * (dx / r);
						fy += f * (dy / r);

					} // end if-statement
				} // end j loop

				// calculate acceleration components
				double ax = fx / Mass[i];
				double ay = fy / Mass[i];
				//calculate current velocity components
				velX[i] = velX[i] + delta_t * ax;
				velY[i] = velY[i] + delta_t * ay;
				// calculate position components to be used for drawing the pictures
				posX[i] = posX[i] + delta_t * velX[i];
				posY[i] = posY[i] + delta_t * velY[i];
				
				//prints the current positions for each body
				if (i == 0)
					System.out.println("x-position of earth: " + posX[i] + "y-position of earth: " + posY[i]);
				else if (i == 1)
					System.out.println("x-position of sun 1: " + posX[i] + "y-position of sun 1: " + posY[i]);
				else if (i == 2)
					System.out.println("x-position of sun 2: " + posX[i] + "y-position of sun 2: " + posY[i]);
				//draws the planets
				StdDraw.picture(posX[i], posY[i], "Resources/" + pictures[i]);
			} // end i loop
				// end of one iteration
				// now there is a new position for x and y for each body
				

			StdDraw.show(5); // shows for 5 ms

			//add time for each step
			step = step + delta_t;
		} // end while

	}// end main
} // end class