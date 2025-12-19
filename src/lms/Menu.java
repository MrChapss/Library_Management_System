package lms;
import java.util.Scanner;

public class Menu {
	Book books = new Book();
	
	public void menu(Scanner input, User data) {
		while(true) {
			data.Message();
			System.out.printf("%nInput here: ");
			int userInput = Integer.parseInt(input.nextLine());
			
			if (userInput == 4) {
				System.out.println("Exiting...");
				break;
			}
			switch (userInput) {
				case 1 -> books.addingBook(input);
				case 2 -> books.deletingBook(input);
				case 3 -> books.isBookAvailable(input);
			}
		} 
	}
}
