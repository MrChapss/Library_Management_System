package lms;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Login user = new Login();
		Student studentAccountData = new Student ();
		Admin adminAccountData = new Admin();
		Menu home = new Menu();
		
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
				user.isLogginIn(input, studentAccountData);
				home.menu(input, studentAccountData);
			} 
			// call the method for admin login and menu
			case 2 -> {
				user.isLogginIn(input, adminAccountData);
				home.menu(input, adminAccountData);
			} 
			// stop the program when exiting
			case 3 -> System.out.printf("%nExiting..."); 
			}
		} catch (Exception e) {
			System.out.println("Read the directions properly!");
		}
	}
}