class choose {
private final static int UNKNOWN = -1;
	
public static int[][] initTable(int n, int k){
	int[][] table = new int [n+1] [k+1];
	for (int col = 0; col <=k; col++){
		for (int row = 0; row <= n; row++){
			table[row][col] = UNKNOWN;
		}
	}
	return table;
}

// compute C(n,k) using dynamic programming
// Fill in the table using ROW-MAJOR-ORDER!

public static int dpChooseRow(int n, int k){ // start function
	int[][] table = new int [n+1][k+1];
	for (int i=0; i<=n; i++){ // start outer loop
		for (int j=0; j<=Math.min(i,k); j++){
			// base case
			if (j==0 || i==j){
				table[i][j] =1;
			}
			else{
				table[i][j] = table[i-1][j] + table[i-1][j-1];
			}	
		}		
	} // end outter loop
	return table[n][k];
} // end function

// Compute C(n, k) using dynamic programming
// Fill in the table using COLUMN MAJOR ORDER!

public static int dpChooseCol (int n, int k){
	int[][] table = new int [n+1][k+1];
	for (int j=0; j<=k; j++){ // start big loop
		for (int i=j; i<=n; i++){
			// base case
			if (j==0 || i==j){
				table[i][j] =1;
			}
			else{
				table[i][j] = table[i-1][j] + table[i-1][j-1];
			}	
		}
		
	} // end big loop
	return table[n][k];
}


public static int memoChoose(int n, int k, int[][] table){
	if (table[n][k] == UNKNOWN){
		// recursively compute, put it in table
		// first, base case:
		if (k==0 || n==k) table[n][k]= 1;
		else{
			table[n][k]=recursiveChoose(n-1, k-1) + recursiveChoose(n-1, k);
		}
	}
	return table[n][k];
}
/* takes in n and k and returns n choose k*/	
public static int recursiveChoose (int n, int k){
	// base case:
	if (k==0 || n==k) return 1;
	return recursiveChoose(n-1, k-1) + recursiveChoose(n-1, k);
	
}

	public static void main(String[] args) { // start main
		int n = 6;
		int k = 2;
		System.out.println(recursiveChoose (n, k));
		int[][] table = initTable(n, k);
		System.out.println(memoChoose(n, k, table));
		System.out.println(dpChooseRow(n, k));
		System.out.println(dpChooseCol(n,k));
	} // end main

}