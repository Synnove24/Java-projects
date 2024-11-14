import java.util.Arrays;

class factorialtypes {
	private static int[] memo;
	private static final int UNKNOWN_VALUE = -1;

	public static void createAndinitalizeTable(int n) {
		memo = new int[n + 1];
		for (int i = 0; i <= n; i++)
			memo[i] = UNKNOWN_VALUE;
	}

	static int factorial(int n) {
		if (n == 0)
			return 1;
		return n * factorial(n - 1);
	}

	static int memofactorial(int n) {
		if (memo[n] == UNKNOWN_VALUE) {
			if (n == 0)
				memo[n] = 1;
			else
				memo[n] = n * memofactorial(n - 1);
			return memo[n];
		} else {
			return memo[n];
		}
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
		createAndinitalizeTable(n);
		System.out.println(memofactorial(n));
		//System.out.println(Arrays.toString(memo));
		System.out.println(dpfactorial(n));
		
	}
}