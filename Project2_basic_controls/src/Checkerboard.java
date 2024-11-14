public class Checkerboard{ //start class
	public static void main (String[] args) { //start main
		//takes argument n and creates an nxn checkerboard
		int n = Integer.parseInt(args[0]);
		//outside look goes from 1 to n and prints the border
		for ( int i=1; i <= n; i++){ //start i loop
			System.out.print("|");
			//inside loop goes from 1 to n and creates the astericks 
			//for each even step it does the space first
			for ( int j=1; j <= n; j++){ //start j loop
				//checks for even number
				if ((i%2)==0) {
					System.out.print(" *");
				}
				else System.out.print("* ");
			} //end j loop
			System.out.println("|");
		} //end i loop
	} //end main
	
}