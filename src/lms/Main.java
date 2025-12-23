package lms;
import java.util.Scanner;
import java.sql.Connection;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Login user = new Login();
		User studentAccountData = new Student ();
		User adminAccountData = new Admin();
		Menu home = new Menu();
		
		Connection con = DBconnection.getConnection();
		if (con!=null) System.out.println("connected ang liga!");
		
		first:
		while (true) {
			// introduction message of the program
			System.out.printf("Welcome to LMS!%n%n");
			System.out.println("Please choose an account:");
			System.out.println("1 for Student");
			System.out.println("2 for Admin");
			System.out.println("3 for Exit");
			System.out.printf("Input here: ");
			// I put try-catch here is user input anything but integer num from 1-3
			try {
				// I use integer parseInt here so it will not skip
				int selectedAccount = Integer.parseInt(input.nextLine());
				// using switch to select an account
				switch(selectedAccount) {
				// call the method for student login and menu
				case 1 -> {
					// I use the input "Scanner" and objectAccount to make it work
					if (user.isLoggingIn(input, studentAccountData) == true) {
						home.menu(input, studentAccountData);
					} else {
						break first;
					}
				} 
				// call the method for admin login and menu
				case 2 -> {
					if (user.isLoggingIn(input, adminAccountData) == true) {
						home.menu(input, adminAccountData);
					} else {
						break first;
					}
				} 
				// stop the program when exiting using the break label
				case 3 -> {
					System.out.printf("%nExiting...%n%n");
					break first;
				}
				// if user input anything but 1-3
				default -> System.out.printf("Choose from 1-3 only!%n%n");
				}
				// if user input anything but number
			} catch (NumberFormatException e) {
				System.out.printf("%nRead the directions properly!%n%n");
				
			}
		}
	}
}