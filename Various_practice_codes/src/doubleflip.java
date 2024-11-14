public class doubleflip{
		public static void main (String[] args) {
			int n = Integer.parseInt(args[0]); //flip coin n time
			int m = Integer.parseInt(args[1]); //how many people flipping coin
			double head = 0;
			for (int j = 0; j <=m; j++) {  //start j loop
			for (int i =0; i < n; i++) {  //start i loop
				double flip = Math.random();
				if (flip >= 0 && flip <0.5) {
					System.out.println("head");
					head++;
				}
				else System.out.println("tail");
			} // end i loop
			System.out.println("fraction of head is " + head / n);
			} //end j loop
		
	}
	
}