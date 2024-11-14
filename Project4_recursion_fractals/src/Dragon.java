public class Dragon { //start class
	
	/*
	 * Function Dragon takes 5 arguments
	 * The first four define the size, and the last argument is for the level
	 * It draws a fractal that looks like a dragon
	 * @return dragon
	 * @param x and y values for line and level
	 * 
	 */
	public static void Dragon(double x0, double y0, double x1, double y1, int level) {
		if (level == 0) { //base case
			StdDraw.line(x0, y0, x1, y1); //draws line
		} else {
			double dx = x1 - x0; //calculates the difference in x and y
			double dy = y1 - y0;
			double xm = (x0 + x1) / 2; //finds the midpoint between each x and each y
			double ym = (y0 + y1) / 2;
			double xNew = xm - dy/2; //calculates the new x and y values for the line end points
			double yNew = ym + dx/2;
			Dragon(x0, y0, xNew, yNew, level - 1); //recursive step calls Dragon function with new points
			Dragon(x1, y1, xNew, yNew, level - 1); // switches the orientation for the second function
		}
	}

	public static void main(String[] args) { //begin main
		//define size and level
		int level = 1;
		double x0 = .5;
		double y0 = 0.25;
		double x1 = .5;
		double y1 = .75;
		//calls the function to begin
		Dragon(x0, y0, x1, y1, level);
	}
} //end class