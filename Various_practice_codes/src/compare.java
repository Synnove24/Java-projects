public class compare{
	public static void main (String[] args) {
		int var1 = Integer.parseInt(args[0]);
		int var2 = Integer.parseInt(args[1]);	
		int var3 = Integer.parseInt(args[2]);
		System.out.println("The result is " + (var1 == var2 && var2 == var3));
	

	}
	
}