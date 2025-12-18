package lms;
import java.util.Scanner;

public class Menu {
	Book books = new Book();
	
	public void menu(Scanner input, User data) {
		do {
			data.Message();
			System.out.printf("%nInput here: ");
			int userInput = Integer.parseInt(input.nextLine());
			
			// working nga siya HAHAHAHAH basta may switch statement
			// problema nalang kung paano ma-polymorph to sa class Student at Admin
			switch (userInput) {
				case 1 -> books.addingBook(input);
				case 2 -> books.deletingBook(input);
				case 3 -> books.isBookAvailable(input);
				case 4 -> System.out.println("Exiting...");
			}
		} while (true);
		
		
		
	}
}
