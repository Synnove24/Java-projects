public class ifstatement{
	public static void main (String[] args) {
		int x = Integer.parseInt(args[0]);
		if (x < 0) x = (x * -1);
		//if there are 2 or more lines in if statement, you need squiggly brackets
		System.out.println(x);
	}
	
}