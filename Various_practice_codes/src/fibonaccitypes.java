public class fibonaccitypes { //start
	public final static int	 IMPOSSIBLEVALUE = -1;
	
	/*
	 * 
	 * 
	 */
	public static int fibonacci (int n) {
			// what is base case, what is recursive base
			if (n==1) return 0;
			else if (n==2) return 1;
			else {	
				return fibonacci(n-2) + fibonacci(n-1);
				
			}
		}
	
	public static int[] makeTable(int n){
		//make table of n+1 slot
		int[] table = new int [n+1];
		//initialize table with all impossible values
		for (int i=0; i<=n; i++){
			table[i] = IMPOSSIBLEVALUE;
		}
		return table;
	}
	/*
	 * step 2:
	 * if i can find the value in the table, I return it
	 * otherwise I stick the solution in the table and return it
	 * @return: int, the nith fibonacci number
	 * @param: int, the nth term
	 * 
	 */

public static int memofib (int n, int[] table){
	if (table[n] != IMPOSSIBLEVALUE){
	} 
	else{ 
		if (n==0) table[n] =0;
		else if (n==1) table[n] = 1;
		else{
			table[n] = memofib(n-1, table) + memofib (n-2, table);
		}
	} 
	return table[n];
}



	/*
	 * Bottom up dynamic programming
	 * No recursion! Use a loop instead
	 * @return integer - nth fibonacci sequence 
	 * @param integer - nth term
	 */
	
	public static int bottomFib(int n) {
		int[] table = new int [n+1];
		table[0] = 0;
		table[1] = 1;
		
		for (int i = 2; i<= n; i++) {
			table[i] = table[i-1] + table[i-2];
		}
		return table[n];
		
	}
	
	
	public static void main(String[] args) {
			int n = 39;
			int x = fibonacci (n);
			System.out.println(x);
			int[] table = makeTable(n);
			System.out.println(bottomFib(n));
			System.out.println(memofib(n,table));
			
			
	}
	
		
		
} //end