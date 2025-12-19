package lms;
import java.util.Scanner;

class Login {
	private int maxRetries = 3;
	private int minRetries = 0;
	
	public boolean isLogginIn(Scanner input, User data) {
	    do {
	    	try {
		        System.out.printf("%nPlease enter your Username: ");
		        String userName = input.nextLine();
		        data.setUserName(userName);
		        
		        System.out.printf("%nPlease enter your Password: ");
		        String userPassWord = input.nextLine();
		        data.setPassWord(userPassWord);
	    	} catch (Exception e) {
	    		System.out.println("Input your ID only!");
	    	}
	        
	        
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
