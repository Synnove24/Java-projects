import java.util.Arrays;
class tryy {
	private static final int IMPOSSIBLEVALUE = -1;

	public static int[] createAndinitalizeTable(int n) {
		int[] table = new int [n+1];
		//initialize table with all impossible values
		for (int i=0; i<=n; i++){
			table[i] = IMPOSSIBLEVALUE;
		}
		return table;
	}

	static int factorial(int n) {
		if (n == 0)
			return 1;
		return n * factorial(n - 1);
	}

	static int memofactorial(int n, int[] table) {
		if (table[n] != IMPOSSIBLEVALUE){
		} 
		else{ 
			if (n==0) table[n] =0;
			else if (n==1) table[n] = 1;
			else{
				table[n] = memofactorial(n-1, table) * memofactorial(n, table);
			}
		} 
		return table[n];
	}
	
	static int dpfactorial(int n) { // start dpFib //if n =3
		int[] table = new int[n + 1]; //table size 4
		table[0] = 1; //[1,0,0,0]
		table[1] = 1; //[1,1,0,0]
		for (int i = 2; i <= n; i++)
			table[i] = table[i - 1] * i; //[1,1,2,0], [1,1,2,6]
		//System.out.println(Arrays.toString(table));
		return table[n]; //6
	} // end dpFib

	public static void main(String[] args) {
		int n = 3;
		System.out.println(factorial(n));
		int[] table = createAndinitalizeTable(n);
		System.out.println(memofactorial(n, table));
		//System.out.println(Arrays.toString(memo));
		System.out.println(dpfactorial(n));
		
	}
}