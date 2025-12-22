package lms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
// the book class is responsible for CRUD functions on the menu
// i might remove this class (nah)

// paano ko to gagawing generalize (ito agenda ko bukas)
class bookService {
	protected ArrayList<String> books = new ArrayList<String>();
	
	public void addingBook(Scanner input) {
		while (true) {
			System.out.print("Input the name of the book: ");
			String nameOfBook = input.nextLine();
			if (!books.contains(nameOfBook)) {
				System.out.printf("'%s' is successfully added!%n",nameOfBook);
				books.add(nameOfBook);
			} else {
				System.out.printf("'%s' is already added!%n",nameOfBook);
			}
			if (nameOfBook.isBlank()) {
				books.remove(nameOfBook);
			}
			if (nameOfBook.equals("4")) {
				books.remove("4"); 
				break;
			}
		}
	}
	public void isBookAvailable(Scanner input) {
		if (books.isEmpty()) {
			System.out.printf("There are no books availabale at the moment!%n");
		} else {
			for (int i=0; i<books.size(); i++) {
				Collections.sort(books);
				System.out.println(books.get(i));
			}
		} 
	}
	public void deletingBook(Scanner input) {
		while (true) {
			System.out.print("Input the name of the book to remove: ");
			String nameOfBook = input.nextLine();
			if (nameOfBook.equals("4")) {
				break;
			}
			if (!books.contains(nameOfBook)) {
				System.out.printf("The book '%s' does not exist!%n",nameOfBook);
			} else {
				System.out.printf("'%s' is successfully deleted!%n", nameOfBook);
				books.remove(nameOfBook);
			}
		}
	}
}