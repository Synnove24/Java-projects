public class factorial { //start
	
	/*
	 * Write a function that calculates n!
	 * Users, don't enter negative
	 * 
	 */
		public static int Factorial (int n) {
			// what is base case, what is recursive base
			if (n==0) return 1;
			else {	
				return n * Factorial(n-1);
			}
		}
		public static void main(String[] args) {
			int x = Factorial (5);
			System.out.println(x);
			
	}
		
} //end