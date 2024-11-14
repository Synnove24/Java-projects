public class Ordered{  //tells which class
	public static void main (String[] args) { //start main
		//create a code that only returns true is x>y>z or x<y<z
		//define x,y, and z from user
		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);	
		int z = Integer.parseInt(args[2]);
		//initialize isOrdered
		boolean isOrdered;
		//check for x>y>z and x<y<z
		//if true, isOrdered becomes true, otherwise it becomes false
		if (x < y && y < z) {
			isOrdered = true;
		}
		else if (x > y && y > z) {
			isOrdered = true;
		}
		else {
			isOrdered = false;
		}
		//print result
		System.out.println(isOrdered);
		
	} //end main
	
}