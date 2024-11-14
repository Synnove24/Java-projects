public class Helloworld{
	public static void main (String[] args) {
		//printing
		System.out.println("hello world");
		System.out.print("test");
		System.out.print("Whatever");
		System.out.print("\n hello");
		//takes two arguments and prints x loves x
		String var1 = args[0];
		String var2 = args[1];
		System.out.println(var1 +" loves " + var2);
		//takes in two integers and adds them
		int var3 = Integer.parseInt(args[2]);
		int var4 = Integer.parseInt(args[3]);
		System.out.println("the result is " + (var3 + var4));
				

	}
	
}

