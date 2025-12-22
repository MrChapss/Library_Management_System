package lms;
import java.util.Scanner;
// login class is for login methods only
class Login {
	private int maxRetries = 3;
	private int minRetries = 0;
	// I put the all login on this function adding input and object as a parameter
	public boolean isLoggingIn(Scanner input, User data) {
	    do {
	        System.out.printf("%nPlease enter your Username: ");
	        String userName = input.nextLine();
	        data.setUserName(userName);
	        
	        System.out.print("Please enter your Password: ");
	        String userPassWord = input.nextLine();
	        data.setPassWord(userPassWord);
	        
	        maxRetries--;
	        // check the account details if true then stop the loop
	        if (!data.isAccountValid(data.getUserName(), data.getPassWord())) {
	        	System.out.println("Successfully login!"); return true;
	        // tell the user how many retries left
	        } if (maxRetries > minRetries) {
	        	System.out.printf("You have %d retries left!%n",maxRetries);
	        // stop the program when user hit the maximum retries
	        } if (maxRetries == minRetries) {
	        	System.out.println("Try again later!"); return false;
	        }
	    } while (true);
	}
	

}
