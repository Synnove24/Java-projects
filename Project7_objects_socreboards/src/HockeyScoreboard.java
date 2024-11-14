public class HockeyScoreboard implements Scoreboard{ //begin class
	//initialize instances
	//team names
	public String home;
	public String guest;
	//initialize scores
	public int homescore;
	public int guestscore;
	public int constant;
/**
 * constructor
 * creates a scoreboard with the default home and guest team names
 */
	public HockeyScoreboard() {
		this.home = "Home";
		this.guest = "Guest";
	}
	
	/**
	 * constructor
	 * creates a scoreboard with the home and guest team names given by the user
	 * @param home
	 * @param guest
	 */
	public HockeyScoreboard(String home, String guest ) {
		this.home = home;
		this.guest = guest;
	}
	
	/**
	 * Increment the guest score by the default score
	 */
	public void homeScored() {
		constant = 1; //1 for hockey
		homescore = homescore + constant; //adds a constant to the guest team
	}
	
	/**
	 * Increment the guest score by the default score
	 */
	public void guestScored() {
		constant = 1; //1 for hockey
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
		HockeyScoreboard s1 = new HockeyScoreboard("Synnove", "Hunnes");
		s1.homeScored();
		System.out.println(s1.toString());
	}
	
}