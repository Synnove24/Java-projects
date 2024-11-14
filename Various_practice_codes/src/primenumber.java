public class primenumber{
		public static void main (String[] args) {
			int n = Integer.parseInt(args[0]);
			boolean isPrime = true;
			for (int i = 2; i<n; i++) {
				if (n % i ==0) {
					System.out.println( n + " is not a prime number");
					isPrime = false;
					break;
				}
			}
			if (isPrime == true) {
				System.out.println( n + " is a prime number");
			}

	}
	
}