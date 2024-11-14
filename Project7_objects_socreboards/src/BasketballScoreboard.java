public class BasketballScoreboard implements Scoreboard { //begin class
	//initialize instances
	public String home; //Name of home team
	public String guest; //Name of guest team
	public int homescore; //initialize home score
	public int guestscore; //initialize guest score
	public int constant;
/**
 * constructor
 * creates a scoreboard with the default home and guest team names
 */
	public BasketballScoreboard() {
		this.home = "Home";
		this.guest = "Guest";
	}
	
	/**
	 * constructor
	 * creates a scoreboard with the home and guest team names given by the user
	 * @param home
	 * @param guest
	 */
	public BasketballScoreboard(String home, String guest ) {
		this.home = home;
		this.guest = guest;
	}
	
	/**
	 * Increment the guest score by the default score
	 */
	public void homeScored() {
		constant = 2; // 2 for basketball
		homescore = homescore + constant; //adds a constant score to the home team
	}
	
	/**
	 * Increment the guest score by the default score
	 */
	public void guestScored() {
		constant = 2; //2 for basketball
		guestscore = guestscore + constant; //adds a constant to the guest team
	}
	
	/**
	 * Returns string representation of the score
	 */
	public String toString() {
		return home + ": " + homescore +  "\n" + guest + ": " + guestscore;
	}
	
	public static void main(String[] args) {
		//test
		BasketballScoreboard s1 = new BasketballScoreboard("Synnove", "Hunnes");
		s1.homeScored();
		System.out.println(s1.toString());
	}
	
}