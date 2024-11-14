import java.util.Arrays;
public class LCS {
	
    public static void main(String[] args) {
    	String x = "Spanking";
    	String y = "Amputation";		
    	System.out.println("Recursion Result is "+ recursiveLCSlength(x, y));
		int length = bottomLCSlength(x, y);
		System.out.println("Bottom up Answer is " + length);
		String answer = dpLCS(x, y);
		System.out.println("The answer is " + answer);

    }	
		
    
    
    
	public static String dpLCS(String x, String y){ // start function
		// build the table
		StringBuilder str1 = new StringBuilder();
		int[][]opt = optimizingTable(x, y);
		int i = 0; // movement to the right
		int j = 0; // movement down
		while (true){ // start while
			if (i == x.length()) break;
			else if (j == y.length()) break;
			else{
				if (opt[i][j] == opt[i+1][j]){
					// if the right of me is the same as me
					// go to the right. The arbitrary choice 
					// is always go to the right first
					i++;
				}
				else if (opt[i][j] == opt[i][j+1]){
					// else if the down of me is the same as me
					// go down
					j++;
				}
				else{
					// else, go diagonal, append letter
					if (x.charAt(i) == y.charAt(j)){
						str1.append(x.charAt(i));
					}
					i++;
					j++;				
				}		
			}
		} // end while
		return str1.toString();
	} // end function
	
	
    
	public static int bottomLCSlength(String x, String y) {
		// opt[i][j] contains the same value as recursiveLCSlength(x, y, i, j)
			
		// Suffixes starting at positions 0 and 0 are the whole strings.
		int[][]opt = optimizingTable(x, y);
		return opt[0][0];
	}	
	
	public static int[][] optimizingTable(String x, String y) {
		int[][] table = new int [x.length()+1][y.length()+1];
		for (int i = x.length(); i>=0; i--){ // start big for
			for (int j = y.length(); j>=0; j--){ // start small for
				if (i == x.length()){ // base case 1
					table [i][j] = 0;
				}
				else if (j == y.length()){ // base case 2
					table[i][j] = 0;
				}
				else{ // none base case
					int option1 = table[i+1][j+1]; //diagonal cell
					int option2 = table [i][j+1]; // right cell
					int option3 = table[i+1][j]; //below cell cell
					//if characters match we take diagonal + 1
					if (x.charAt(i) == y.charAt(j))
						option1 = option1 + 1;
					table[i][j] = Math.max(option1, Math.max(option2, option3));
				}						
			} // end small for
		} // end big for
		
				
		return table;
	} // end optimizing table
    
	
	
	
	
	
	

    public static int recursiveLCSlength(String x, String y) {
    // suffixes starting at positions 0 and 0 are the whole strings. 
    	return 	recursiveLCSlength(x, y, 0, 0);
    }
	
	/*
	 * Computes the length of a longest common subsequence (LCS) of x and y
	 * @param x
	 * @param y
	 * @return the LCS length
	 */
	public static int recursiveLCSlength (String x, String y, int i, int j) {
		if (i == x.length()) return 0; //base case 1
		else if (j == y.length()) return 0; //base case 2
		else {
			//recursive cases
			int option1 = recursiveLCSlength(x, y, i + 1, j + 1);
			int option2 = recursiveLCSlength(x, y, i + 1, j);
			int option3 = recursiveLCSlength(x, y, i, j + 1);
			// if we found two characters that are matching, we have
			// option 1, i and j both advance by 1.
			if (x.charAt(i) == y.charAt(j))
				return option1 = option1 + 1;
			else{ // start else 2
				return Math.max(option2, option3);
			}
			} // end else 2
		}// end else 1
		

	
}