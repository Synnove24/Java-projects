public class puzzle {
	/*
	 * Recursive solves Tower of Hanoi
	 */
	public static void moves (int n, boolean left) {
		if (n==1 && left==true) {
			System.out.println("Move " + n + "to the left");	
		}
		else if (n==1 && left==false) {
			System.out.println("Move " + n + "to the right");
		}
		else {
			//what happens if there is more than one peg
			moves(n-1,!left); //move n-1 peg in opposite direction
			//move the bottom peg in the same direction
			if (left==true) System.out.println("Move " + n + "to the left");
			else System.out.println("Move " + n + "to the right");
			moves(n-1,!left);
		}
			
	}
	public static void main(String[] args) {
		int N = 5;
		moves (N,true);
		
	}
}