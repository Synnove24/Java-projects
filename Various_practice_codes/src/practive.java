public class practive{
	public static void main(String[] args) {
		int A = Integer.parseInt(args[0]);
		int B = Integer.parseInt(args[1]);
		
		while ( B%A != 0) {
			A++;
					
		}
		System.out.println(A);
		
	}
}