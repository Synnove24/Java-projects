import java.util.Arrays; //imports arrays
import java.io.FileInputStream; // put this at the top of your source code outside the class definition
public class EditDistance { //begin class
	
	



	public static void main(String[] args) { //begin main

	    try {
	        System.setIn(new FileInputStream("resources/" + args[0])); //grabs string from resource text file
	    } catch (Exception e) {
	        System.err.printf("Exception caught: %s\n", e.toString()); //makes sure its a string
	        System.exit(0);
	    }
	    String x = StdIn.readLine();
	    String y = StdIn.readLine();
	    printEditDistance(x, y);
		
		//String x = "AACAGTTACC"; //test example
		//String y = "TAAGGTCA";
	    //String x = randomDNAString(12);
	    //String y = randomDNAString(12);
		timeRecursiveEditDistance(x,y);
		timeEditDistance(x,y);
		//System.out.println(randomDNAString(7));
		
		
		//printEditDistance(x,y);
	}

	
	/**
	 * @param x a non-null String
	 * @param y a non-null String
	 * @return the the edit distance between x and y
	 * 
	 * This procedure should use a recursive, not dynamic programming, approach
	 * to compute the edit distance
	 */

	private static int recursiveEditDistance(String x, String y) { //begin function
		int m = x.length();  //m is the length of string x
		int n = y.length();  //n is the length of string y
		if (n==0) { //base case 1
			return m*2; //all gaps for n
		}
		else if (m==0) { //base case 1
			return n*2; // all gaps for m
		}
		else if (x.charAt(0) == y.charAt(0)) { //if they equal you can remove them
	        return recursiveEditDistance(x.substring(1), y.substring(1));
		}
		else { //begin else
			//recursive cases
			int option1 = recursiveEditDistance(x.substring(1),y.substring(1)); //removes first letter from both strings
			int option2 = recursiveEditDistance(x,y.substring(1)); //removes first letter from y string
			int option3 = recursiveEditDistance(x.substring(1),y); //removes first letter from x string
			
			return Math.min((Math.min(option2 + 2, option3 + 2)),option1 +1); //finds the minimum edit distance

			} // end else 
		}// end function

	
	



	/**
	 * @param x a non-null String
	 * @param y a non-null String
	 * @return the the edit distance between x and y
	 * 
	 * This procedure should dynamic programming to compute the edit distance
	 */

	private static int editDistance(String x, String y) { //begin function
		int[][]opt = new int [x.length()+1][y.length()+1]; //creates table
		for (int i = x.length(); i>=0; i--){ // start big for
			for (int j = y.length(); j>=0; j--){ // start small for
				if (i == x.length()){ // base case 1
					opt [i][j] = 2*(y.length()-j); //all gaps
				}
				else if (j == y.length()){ // base case 2
					opt[i][j] = 2*(x.length()-i); //all gaps
				}
				else{ // recursive cases
					int option1 = opt[i+1][j+1]; //diagonal cell
					int option2 = opt [i][j+1]; // right cell
					int option3 = opt[i+1][j]; //below cell 
					//if characters match we subtract 1 from diagonal
					if (x.charAt(i) == y.charAt(j))
						option1 = option1 - 1;
					opt[i][j] = Math.min(option1 + 1, Math.min(option2 + 2, option3 + 2)); //calculates minimum edit distance
				}						
			} // end small for
		} // end big for
		return opt[0][0]; //returns edit distance
	} //end function



	/**
	 * @param x a non-null String
	 * @param y a non-null String
	 * 
	 * This procedure should use dynamic programming to compute the edit distance
	 * and print it and an optimal alignment in the vertical format shown in the
	 * project assignment.
	 * NOTE: There may be multiple optimal alignments.
	 *       This procedure needs to print one optimal alignment.
	 */

	private static void printEditDistance(String x, String y) { //begin function
		StringBuilder str1 = new StringBuilder(); //first string initialization
		StringBuilder str2 = new StringBuilder(); //second string initialization
		StringBuilder str3 = new StringBuilder(); //first string initialization
		int[][]opt = new int [x.length()+1][y.length()+1]; //creates table
		for (int i = x.length(); i>=0; i--){ // start big for
			for (int j = y.length(); j>=0; j--){ // start small for
				if (i == x.length()){ // base case 1
					opt [i][j] = 2*(y.length()-j);
				}
				else if (j == y.length()){ // base case 2
					opt[i][j] = 2*(x.length()-i);
				}
				else{ // recursive cases
					int option1 = opt[i+1][j+1]; //diagonal cell
					int option2 = opt [i][j+1]; // right cell
					int option3 = opt[i+1][j]; //below cell cell
					//if characters match we subtract 1 from option 1
					if (x.charAt(i) == y.charAt(j))
						option1 = option1 - 1;
					opt[i][j] = Math.min(option1 + 1, Math.min(option2 + 2, option3 + 2)); //calculates minim edit distance
				}						
			} // end small for
		} // end big for
		System.out.println("The Dynamic Programming Edit Distance is: " + opt[0][0]); //prints edit distance
		int i = 0; // starts at top left cell
		int j = 0; //top left cell
		while (true){ // start while
			if (i == x.length()) break; //once we reach an edge it ends
			else if (j == y.length()) break;
			else{
				if (opt[i][j] == opt[i+1][j] + 2){ // x[i] lines up with a gap
					str2.append("-"); //adds a gap
					str1.append(x.charAt(i)); //no gap for the other
					str3.append("2");
					i++;
					
				}
				else if (opt[i][j] == opt[i][j+1] + 2) { // y[j] lines up with a gap
					str1.append("-"); //adds a gap
					str2.append(y.charAt(j)); //no gap for the other
					str3.append("2");
					j++;
					}				
						
				else { //x[i] matches up with y[j]
				str1.append(x.charAt(i)); 
				str2.append(y.charAt(j));
				if (x.charAt(i) == y.charAt(j)) str3.append("0");
				else str3.append("1");
				i++;
				j++;
				}
			}
			}// end while
		//System.out.println(str1); //horizontal print option
		//System.out.println(str2);
		System.out.println("The optimal alignment is: ");
		for (int k =0; k<str1.length(); k++) {
			System.out.print(str1.charAt(k) + "  "); //prints optimal alignment veritcally
			System.out.print(str2.charAt(k) + " ");
			System.out.println(str3.charAt(k));
		}
		
		
		} //end function
		
				
		
	

	  

	/**
	 * @param x a non-null String
	 * @param y a non-null String
	 * 
	 * Prints out the edit distance between x and y and the time taken to compute it
	 * using the recursive version recursiveEditDistance
	 */

	public static void timeRecursiveEditDistance(String x, String y) { //begin function
		Stopwatch watch = new Stopwatch(); //initialize stopwatch
		//uses previous function to calculate edit distance
		System.out.println("The Edit Distance solved recursively is: " + recursiveEditDistance(x,y)); 
		double timeSpent = watch.elapsedTime();
		System.out.println("Time spent for recursive: ");
		System.out.println(timeSpent);//prints time spent
	} //end function

	

	  

			  

	/**
	 * @param x a non-null String
	 * @param y a non-null String
	 * 
	 * Prints out the edit distance between x and y and the time taken to compute it
	 * using the dynamic programming version editDistance
	 */

	public static void timeEditDistance(String x, String y) { //begin function
		Stopwatch watch = new Stopwatch(); //initialize stopwatch
		//uses previous function to find edit distnace dynamically
		System.out.println("The Edit Distance solved dynamically is: " + editDistance(x,y));
		double timeSpent = watch.elapsedTime();
		System.out.println("Time spent for dynamic programming: ");
		System.out.println(timeSpent);//prints time spent
	} //end function

	  

			  

	/**
	 * @param dnaLength a non-negative int
	 * @return a random String of length dnaLength comprised of the four chars A, T, G, and C
	 */

	public static String randomDNAString(int dnaLength)	{ //begin function
		StringBuilder DNA = new StringBuilder(); //initialize stringbuilder
		for (int i=0; i<dnaLength; i++) { //begin for loop
			double x = Math.random(); //random double between 0 and 1
			if (x < .25) DNA.append("A"); //25% chance of A
			else if (x < .5) DNA.append("T"); //25% chance of T
			else if (x < .75) DNA.append("G"); //25% chance of G
			else DNA.append("C"); //25% chance of C
			
			
		} //end for loop
		System.out.println("Random DNA string: ");
		return DNA.toString(); //returns string
	} //end function
	
} //end class
