package lms;
import java.util.Scanner;
// login class is for login methods only
class Login {
	private final StudentDAO dao = new StudentDAO();
	private final int maxRetries = 3;
	
	public boolean logIn(Scanner input) {
	    for (int attempts=1; attempts<=maxRetries; attempts++) {
	        System.out.printf("%nPlease enter your Username: ");
	        String userName = input.nextLine();
	        
	        System.out.print("Please enter your Password: ");
	        String password = input.nextLine();
	        
	        if (attempts==maxRetries) {
	        	System.out.println("You have reached the maximum retries! Try again later.");
	        	return false;
	        } if (dao.isAccountValid(userName, password)) {
	        	System.out.println("Login successfully!");
	        	return true;
	        } else {
	        	System.out.println("Username or password is incorrect!");
	        } 
	    }
	    input.close();
	    return false;
	}
	public boolean signUp(Scanner input) {
		for (int attempts=1; attempts<=maxRetries; attempts++) {
			System.out.printf("%nPlease enter your username: ");
			String userName = input.nextLine();
			
			System.out.print("Please enter your password: ");
			String password = input.nextLine();
			
			if (dao.addAccount(userName, password)) {
				System.out.println("Created account successfully!");
				return true;
			} else {
				System.out.println("Account is already made!");
			}
		}
		input.close();
		return false;
	}

}
