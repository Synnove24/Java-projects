import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*************************************************************************
 *  Compilation:  javac IFS.java
 *  Execution:    java IFS N < input.txt
 *  Dependencies: StdDraw.java
 *
 *  Here are some sample data files:
 *  
 *  http://www.cs.princeton.edu/introcs/22library/barnsley.txt
 *  http://www.cs.princeton.edu/introcs/22library/binary.txt
 *  http://www.cs.princeton.edu/introcs/22library/culcita.txt
 *  http://www.cs.princeton.edu/introcs/22library/cyclosorus.txt
 *  http://www.cs.princeton.edu/introcs/22library/dragon.txt
 *  http://www.cs.princeton.edu/introcs/22library/fern-sedgewick.txt
 *  http://www.cs.princeton.edu/introcs/22library/fishbone.txt
 *  http://www.cs.princeton.edu/introcs/22library/floor.txt
 *  http://www.cs.princeton.edu/introcs/22library/koch.txt
 *  http://www.cs.princeton.edu/introcs/22library/sierpinski.txt
 *  http://www.cs.princeton.edu/introcs/22library/spiral.txt
 *  http://www.cs.princeton.edu/introcs/22library/swirl.txt
 *  http://www.cs.princeton.edu/introcs/22library/tree.txt
 *  http://www.cs.princeton.edu/introcs/22library/zigzag.txt
 *  
 *  Altered by Karl Knight to take input from text files in the resources
 *  directory and also to set the number of iterations in main().
 *
 *************************************************************************/

public class IFS {
    public static void main(String[] args) throws FileNotFoundException {
    	
    	// set it to read input from a data file
		String resourceFolder = "resources/";
		String fileName = resourceFolder + "koch.txt";
		FileInputStream fileInputStream = new FileInputStream(fileName);
		System.setIn(fileInputStream);
		
        // number of iterations
        int T = 100000;

        // probability distribution for choosing each rule
        double[] dist = StdArrayIO.readDouble1D();


        // update matrices
        double[][] cx = StdArrayIO.readDouble2D();
        double[][] cy = StdArrayIO.readDouble2D();

        // current value of (x, y)
        double x = 0.0, y = 0.0;

        // do T iterations of the chaos game
        for (int t = 0; t < T; t++) { 

            // pick a random rule according to the probability distribution
            int r = StdRandom.discrete(dist); 

            // do the update
            double x0 = cx[r][0]*x + cx[r][1]*y + cx[r][2]; 
            double y0 = cy[r][0]*x + cy[r][1]*y + cy[r][2]; 
            x = x0; 
            y = y0; 

            // draw the resulting point
            StdDraw.point(x, y); 

            // for efficiency, display only every 100 iterations
            if (t % 100 == 0) StdDraw.show(10);
        } 

        // ensure everything gets drawn
        StdDraw.show(0);
    } 
}