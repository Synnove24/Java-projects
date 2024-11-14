public class elif{
	public static void main (String[] args) {
		double roll = Math.random();
		System.out.println(roll);
		if (roll > 0 && roll <= 0.25) 
			System.out.println("Side 1");
		else if (roll > 0.25 && roll <= 0.5)
			System.out.println("side 2");
		else if (roll > 0.5 && roll < 0.75)
			System.out.println("side 3");
		else	
			System.out.println("side 4");
	}
	
}