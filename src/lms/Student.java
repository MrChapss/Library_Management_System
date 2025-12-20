package lms;

class Student extends User{
	@Override
	public boolean isAccountValid(String userName, String passWord) {
		if (userName.equals("Mark") && passWord.equals("roblox") ) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public void menuInstruction() {
		System.out.printf("%nWelcome to main menu of LMS!%n%n");
		System.out.println("Please choose an action from below:");
		System.out.println("1 to return a book ");
		System.out.println("2 to borrow a book");
		System.out.println("3 to check available books");
		System.out.println("4 to exit program");
		
	}
}
