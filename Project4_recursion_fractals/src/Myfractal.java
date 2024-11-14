public class Myfractal { //begin class
	
	/*
	 * Draws circles instead of lines for the dragon function
	 * @return circles in a dragon shape
	 * @param x and y coordinates of the center of the circle and level
	 * 
	 */
	public static void circledragon(double x0, double y0, double x1, double y1, double r, int level) {
		if (level == 0) { //base case
			//draws a circle with center at (xo,yo) and radius r 
			StdDraw.circle(x0,y0,r);
		} else {

			double dx = x1 - x0; //calculates the difference in x and y
			double dy = y1 - y0;		
			double xm = (x0 + x1) / 2; //finds the midpoint between each x and each y
			double ym = (y0 + y1) / 2;
			double xNew = xm - dy/2; //calculates the new x and y values for the line end points
			double yNew = ym + dx/2;
			double Newr = r*.8; //makes the radius smaller depending on the level
			circledragon(x0, y0, xNew, yNew, Newr, level - 1); //creates the dragon curve
			circledragon(x1, y1, xNew, yNew, Newr, level - 1);
		}
	}

	public static void main(String[] args) { //begin main
		//define parameters
		int level = 10;
		double x0 = .5;
		double y0 = 0.25;
		double x1 = .5;
		double y1 = .75;
		double r = .1;
		//call the function to draw the fractal
		circledragon(x0, y0, x1, y1, r, level);
	} //end main
} //end class