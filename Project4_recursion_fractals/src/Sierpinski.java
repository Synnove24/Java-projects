public class Sierpinski { //begin class
	/*
	 * Function triangle takes three ordered pairs to be the three corners of the triangle
	 * Returns a filled triangle
	 * @param x and y coordinates
	 */
	public static void triangle(double x0, double y0, double x1, double y1, double x2, double y2) {
		//declare x and y array
		double [] x; 
		double [] y;
		//create arrays with size 3
		x = new double[3]; 
		y = new double[3];
		//add coordinates to the two arrays
		x[0] = x0; 
		x[1] = x1; 
		x[2] = x2;
		y[0] = y0;
		y[1] = y1;
		y[2] = y2;
		//fill polygon
		StdDraw.filledPolygon(x, y);
	}
	/*
	 * Function sierpinski takes in the 6 coordinates and a level argument
	 * Calls the triangle function and uses recursion to draw a triangular fractal
	 * @return sierpinski triangle
	 * @param x and y coordinates and level
	 */
	public static void sierpinski(double x0, double y0, double x1, double y1, double x2, double y2, int n) {
		if (n==0) {  //base case
			triangle(x0,y0,x1,y1,x2,y2);	
		}
		//calls the function again with new coordinates
	    else{     
            sierpinski(x0, y0, (x0+x1)/2, (y0+y1)/2, (x0+x2)/2, (y0+y2)/2, n - 1); //bottom left triangle
            sierpinski(((x0+x1)/2), (y0+y1)/2, x1, y1, (x1+x2)/2, (y1+y2)/2, n - 1); //bottom right triangle
            sierpinski((x0+x2)/2, (y0+y2)/2, (x1+x2)/2, (y1+y2)/2, x2, y2, n - 1); //top triangle
     	    	
	    }
		
		
	}

	public static void main(String[] args) { //begin main
		sierpinski(0,0,1,0,.5,1,1); //equilateral triangle (doesn't have to be)
		
	} //end main
} //end class