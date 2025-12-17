package lms;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Login login = new Login();
		Student studentAccountData = new Student ();
		Admin adminAccountData = new Admin();
		Menu mainMenu = new Menu();
		
		System.out.printf("Welcome to LMS!%n%n");
		System.out.println("Please choose an account:");
		System.out.println("1 for Student");
		System.out.println("2 for Admin");
		System.out.println("3 for Exit");
		System.out.printf("%nInput here: ");
		try {
			int choosingAccount = Integer.parseInt(input.nextLine());
			
			switch(choosingAccount) {
			// call the method for student login and menu
			case 1 -> {
				login.isLogginIn(input, studentAccountData);
				mainMenu.Skibidi(input, studentAccountData);
			} 
			// call the method for admin login and menu
			case 2 -> {
				login.isLogginIn(input, adminAccountData);
				mainMenu.Skibidi(input, adminAccountData);
			} 
			// stop the program when exiting
			case 3 -> System.out.printf("%nExiting..."); 
			}
		} catch (Exception e) {
			System.out.println("Read the directions properly!");
		}
	}
}