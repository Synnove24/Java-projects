public class charge {
	

	private double x;
	private double y;
	private double charge;
		
	public void charge (double x, double y,double charge) {
		this.x = x;
		this.y = y;	
		this.charge = charge;
	}
		
	public void charge() {
		x = 0;
		y = 0;	
	}
	
	public double getx() {
		return x;
	}
	
	public double gety() {
		return y;
	}
	
	public void setx(double newx) {
		x = newx;
	}
	
	public void sety(double newy) {
		y = newy;
	}
	
	public String toString() {
		return "The x is: " + x + "The y is: " + y + "The charge is: " + charge;
	}
	
	/*
	 * write a function that takes in a new x and y coordinate and 
	 * calculates the energy is takes from
	 * current location to new location
	 */
	
	public double potentialAt ( double newX, double newY) {
		double k = 8.99e09;
		double dx = newX - x;
		double dy = newY - y;
		return k * charge / Math.sqrt(dx*dx - dy*dy);
	}
	
	public static void main(String[] args){
		//charge c1 = new charge (0.51, 0.63, 21.3);
		//charge c2 = new charge (0.13, 0.94, 81.9);
		//System.out.println(c1);
		//System.out.println(c2);
		//System.out.println(c1.potentialAt(0.5,0.5));
		
	}
}