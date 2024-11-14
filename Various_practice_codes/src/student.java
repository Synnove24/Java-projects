	/*
	 * Make a blueprint for students in general that allows me to create
	 *  individual students
	 *  This is the point of object oriented programming which java is best at
	 */
public class student {
	//instance variables
	private String firstName;
	private String lastName;
	private long ID;
	private int year;
	private int numCourse;
	

 //In order to activate the object oriented mode, you need a constructor
 //This is the function responsible to create individual students. As a 
 //result this constructors name should be the same as your class name.
 //Constuctor is a place to initialize your instance variables.
 
	public student (String firstname, String lastName1, long ID1,  int year1, int numCourse1) {
		this.firstName = firstname;
		lastName = lastName1;
		ID = ID1;
		year = year1;
		numCourse = numCourse1;
	}
		
	/*
	 * Overload my constructor for first year student
	 */
	public student (String firstName1, String lastName1) {
		firstName = firstName1;
		lastName = lastName1;
		//randomly generate an ID for student
		ID = (int) Math.random()*(1000000);
		year = 1;
		numCourse = 4;
	}
	public String getFirstname() {
		return firstName;
	}
	public String getLastname() {
		return lastName;
	}
	
	//public void changeFirstName(String newFirstName) {
	//	firstName = newFirstName;
	//}
	
	public long getID() {
		return ID;
	}
	
	public void addCourse() {
		numCourse++;
	}
	
	public void dropCourse() {
		numCourse--;
	}
	
	/*
	 * special function, toString will return a string representation of your object
	 *
	 */
	
	public String toString() {
		return "Student Name is " + firstName + " " + lastName + " Student ID is: " + ID + 
				" Number of courses the student is taking: " + numCourse + " Students current year: "
				+ year;
	}
	
	public static void main(String[] args) {
		student Kofi = new student("Kofi", "Osei",123456,3,5);
		student Synnove = new student("Synnove", "Hunnes",242424,3,4);
		student Kirstin = new student("Kirstin", "Poppen",242424,3,4);
		student Peter = new student("Peter", "Philiewio");
		//can use this in different java file in this default package
		System.out.println(Kofi.getLastname());
		System.out.println(Synnove.toString());
	}
}