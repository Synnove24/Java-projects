public class RealBasketballScoreboard extends BasketballScoreboard{ //begin class that extends previous class
	//initialize a score values
	public int scoreValue;
	
	/**
	 * constructor
	 * creates a scoreboard with the default home and guest team names
	 */
	public RealBasketballScoreboard() {
		super();
		//super.home = "home";
		//super.guest = "guest";
	}
	
	/**
	 * constructor
	 * creates a scoreboard with the home and guest team names given by the user
	 * @param home
	 * @param guest
	 */
	public RealBasketballScoreboard(String home, String guest) {
		super(home, guest);
		//super.home = home;
		//ssuper.guest = guest;
	}
	
	/**
	 * Increment the guest score by the given score
	 */
	public void homeScored(int scoreValue) {
		//checks to make sure value entered is 1,2 or 3
		if ((scoreValue != 1) && (scoreValue != 2) && (scoreValue != 3)) {
			System.out.println("A score of " +  scoreValue + " is not legal in basketball");
		}
		else {
			homescore = homescore + scoreValue; //adds given constant to home score
		}
	}
	
	/**
	 * Increment the guest score by the given score
	 */
	public void guestScored(int scoreValue) {
		//checks to make sure value entered is 1, 2 or 3
		if ((scoreValue != 1) && (scoreValue != 2) && (scoreValue != 3)) {
			System.out.println("A score of " +  scoreValue + " is not legal in basketball");
		}
		guestscore = guestscore + scoreValue; //adds given constant to guest score
	}
}