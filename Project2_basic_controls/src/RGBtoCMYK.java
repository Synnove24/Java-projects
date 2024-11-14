public class RGBtoCMYK{ //class
	public static void main (String[] args) { //begin main
		//converts RGB color codes to CMYK
		//Get RGB values from user and create double variables for them
		double red = Integer.parseInt(args[0]);
		double green = Integer.parseInt(args[1]);
		double blue = Integer.parseInt(args[2]);
		//initialize CMYK colors
		double cyan;
		double yellow;
		double magenta;
		//define black by finding the maximum of red green and blue and dividing 255
		double black = 1 - Math.max(Math.max(red, blue), green)/255;
		//check for black
		if (black ==1) {
			cyan = 0;
			yellow = 0;
			magenta = 0;
		}
		//if its not black, then formulas are used to find other colors between 0 and 1
		else {
			cyan = (1 - red/255.0 - black)/(1-black);
			magenta = (1 - green/255.0 - black)/(1-black);
			yellow = (1 - blue/255.0 - black)/(1-black);
		}
		//print CMYK color codes
		System.out.println("Cyan: " + cyan);
		System.out.println("Magenta: " + magenta);
		System.out.println("Black: " + black);
		System.out.println("Yellow: " + yellow);
		
	} //end main
	
}