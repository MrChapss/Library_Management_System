package lms;
import java.util.Scanner;

class Login {
	
	public void isLogginIn(Scanner input, User data) {
	    do {
	        System.out.printf("%nPlease enter your id: ");
	        int userID = Integer.parseInt(input.nextLine());
	        data.setId(userID);

	        System.out.print("Please enter your username: ");
	        String userName = input.nextLine();
	        data.setUserName(userName);
	        
	    } while (data.isAccountValid(data.getUserName(), data.getId()));
	}

}
