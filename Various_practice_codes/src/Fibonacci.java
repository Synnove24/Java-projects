public class Fibonacci { //start
	
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
		public static void main(String[] args) {
			int x = fibonacci (7);
			System.out.println(x);
			
			
	}
		
} //end