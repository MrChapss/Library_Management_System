package lms;

class Admin extends User {
	@Override
	public boolean isAccountValid(String userName, int id) {
		if (userName.equals("Admin") && id == 123) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public void Message() {
		System.out.printf("%nWelcome to main menu of LMS!%n%n");
		System.out.println("Please choose an action from below:");
		System.out.println("1 to add a book");
		System.out.println("2 to remove a book");
		System.out.println("3 to check available books");
		System.out.println("4 to exit program");
		
	}
}