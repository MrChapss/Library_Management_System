package lms;
import java.util.Scanner;

class Login {
	private int maxRetries = 3;
	private int minRetries = 0;
	
	public void isLogginIn(Scanner input, User data) {
	    do {
	    	try {
	    		System.out.printf("%nPlease enter your id: ");
		        int userID = Integer.parseInt(input.nextLine());
		        data.setId(userID);
	    	} catch (Exception e) {
	    		System.out.println("Input your ID only!");
	    	}
	        System.out.print("Please enter your username: ");
	        String userName = input.nextLine();
	        data.setUserName(userName);
	        
	        maxRetries--;
	        
	        if (maxRetries > minRetries) {
	        	System.out.printf("You have %d retries left!%n",maxRetries);
	        } if (maxRetries == minRetries) {
	        	System.out.println("Try again later!"); break;
	        }
	    } while (data.isAccountValid(data.getUserName(), data.getId()));
	}

}
