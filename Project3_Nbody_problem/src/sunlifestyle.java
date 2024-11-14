import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class sunlifestyle { //begin class

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {

		double big_t = Double.parseDouble(args[0]); //total time
		double delta_t = Double.parseDouble(args[1]);  //change in time for each step

		String resourceFolder = "resources/"; //where text file and images are stored
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

		//declare all of the arrays from the text file
		double[] posX = new double[numBodies];
		double[] posY = new double[numBodies];
		double[] velX = new double[numBodies];
		double[] velY = new double[numBodies];
		double[] Mass = new double[numBodies];
		String[] pictures = new String[numBodies];

		//actually create the arrays
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
		StdDraw.picture(0, 0, "resources/starfield.jpg");

		//initialize constants used for calculations
		double G = 6.674 * (Math.pow(10, -11)); //gravitational constant
		double Massrg = 1.592E31; //mass of red giant
		double Masssrg = 6.967E31; //mass of super red giant
		double Masswd = 3.545E30; //mass of white dwarf
		
		//initialize step count for while loop
		double step = 0;
	
		//while loop creates each step
		while (step < big_t) { // start while

			//draw background
			StdDraw.picture(0, 0, "resources/starfield.jpg");

			//outer loop to calculate forces
			for (int i = 0; i < numBodies; i++) { // start i loop
				double fx = 0; // force x-direction
				double fy = 0; // force y-direction
				
				//inner loop calculates each bodies relationship with other bodies
				for (int j = 0; j < numBodies; j++) { // start j loop
					double f = 0; //force
					if (i != j) { // start if-statement
						double dx = posX[j] - posX[i]; // delta x
						double dy = posY[j] - posY[i]; // delta y
						double r = Math.sqrt(dx * dx + dy * dy); // calculate r
						
						//calculates force for normal sun depending on step
						if (step < 10000000) {
							f = (Mass[i] * Mass[j] * G) / (r * r);
							System.out.println("Normal sun"); //prints current state
			
						}
						//calculates force for red giant sun after certain amount of time
						//the sun is at index 3
						else if (step < 20000000) {f = (Mass[i] * Mass[j] * G) / (r * r);
		
							System.out.println("red giant"); //prints red giant state
							if (i == 3)  f = (Massrg * Mass[j] * G) / (r * r); //uses mass of red giant
							if (j == 3)  f = (Mass[i] * Massrg * G) / (r * r);
						}
						//calculates force for red super giant after more time
						else if (step < 21500000) {f = (Mass[i] * Mass[j] * G) / (r * r);
							System.out.println("super red giant"); //prints super red giant state
							if (i == 3)  f = (Masssrg * Mass[j] * G) / (r * r);
							if (j == 3)  f = (Mass[i] * Masssrg * G) / (r * r);	

						}
						//calculates force for a white dwarf after the step reaches 21500000
						else { f = (Mass[i] * Mass[j] * G) / (r * r); // prints white dwarf
						System.out.println("white dwarf");
						if (i == 3)  f = (Masswd * Mass[j] * G) / (r * r);
						if (j == 3)  f = (Mass[i] * Masswd * G) / (r * r);
						}
						
						//calculate x and y compontents of force
						fx += f * (dx / r);
						fy += f * (dy / r);

					} // end if-statement
				} // end j loop

				// calculate acceleration components
				double ax = fx / Mass[i];
				double ay = fy / Mass[i];
				
				//calculate the new velocity
				velX[i] = velX[i] + delta_t * ax;
				velY[i] = velY[i] + delta_t * ay;
				// calculate new position components
				posX[i] = posX[i] + delta_t * velX[i];
				posY[i] = posY[i] + delta_t * velY[i];

				
				
				
				//draws each planet and sun (normal sun)
				if (step < 10000000) {
					StdDraw.picture(posX[i], posY[i], "Resources/" + pictures[i]);

	
				}
				//draws red giant instead of sun when index is at 3
				else if (step < 20000000) {
					if (i ==3) StdDraw.picture(posX[i], posY[i], "Resources/redgiant.png");
					else StdDraw.picture(posX[i], posY[i], "Resources/" + pictures[i]);


				}
				//draws super red giant after more time
				else if (step < 21500000) {
					if (i==3) StdDraw.picture(posX[i], posY[i], "Resources/superredgiant.png");
					else StdDraw.picture(posX[i], posY[i], "Resources/" + pictures[i]);

				}
				//draws white dwarf after step = 21500000
				else { 
					if (i==3) StdDraw.picture(posX[i], posY[i], "Resources/uranus.gif");
					else StdDraw.picture(posX[i], posY[i], "Resources/" + pictures[i]);
				}
				
				
			} // end i loop
				// end of one iteration
				// now there is a new position for x and y for each body
				

			StdDraw.show(5); // shows for 5 ms
			
			//increase step
			step = step + delta_t;
		} // end while

	}// end main
} // end class