class ProgrammingFinal {
    public static void main(String[] args){
	HockeyScoreboard HS1 = new HockeyScoreboard("Gusties", "Johnies") ;
	HockeyScoreboard HS2 = new HockeyScoreboard() ;
	BasketballScoreboard BS1 = new BasketballScoreboard() ;
	RealBasketballScoreboard BS2 = new RealBasketballScoreboard("Lynx", "Sparks") ;
	
	System.out.println("HS1:\n" + HS1) ;
	//HS1:
	//Gusties: 0
	//Johnies: 0

	HS2.homeScored() ; 
	System.out.println("HS1:\n" + HS1) ; 
	//HS1:
	//Gusties: 0
	//Johnies: 0

	System.out.println("HS2:\n" + HS2) ;
	//HS2:
	//Home: 1
	//Guest: 0


	System.out.println("BS1:\n" + BS1) ;
	//BS1:
	//Home: 0
	//Guest: 0


	BS1.homeScored() ; 
	BS2.homeScored() ;
	BS2.guestScored(3) ; 
	System.out.println("BS1:\n" + BS1) ; 
	// BS1:
	// Home: 2
	// Guest: 0
	
	System.out.println("BS2:\n" + BS2) ;
	// BS2:
	// Lynx: 2
	// Sparks: 3
	
	BS2.guestScored() ; 
	System.out.println("BS2:\n" + BS2) ;
        //BS2:
	//Lynx: 2
	//Sparks: 5
	
	BS2.homeScored(1) ; 
	BS2.homeScored(8) ; 
	// A score of 8 is not legal in basketball
	BS2.guestScored() ; 
	System.out.println("BS2:\n" + BS2) ;
	//BS2:
	//Lynx: 3
	//Sparks: 7
	
    }
}