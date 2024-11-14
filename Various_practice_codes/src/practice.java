
public class practice{
	public static void main (String[] args) {
		int n = Integer.parseInt(args[0]);
		for (int i = n; i>0; i--) {
			int j;
			for (j = 0; j <i; j++) 
				System.out.print(" ");
			while (j <= n) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			
			
			

			
		}
	}
	
}