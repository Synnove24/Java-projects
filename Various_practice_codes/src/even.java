public class even{
		public static void main (String[] args) {
			int n = Integer.parseInt(args[0]);
			for (int i = 0; i<=n; i++) {
				if (i % 2 ==1) continue;
				else System.out.println(i);
			}
			

	}
	
}