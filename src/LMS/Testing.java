package LMS;
import java.util.Scanner;
import java.util.ArrayList;

public class Testing {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String bookN;
		ArrayList<String> bookName = new ArrayList<String>();
		
		
		for (int i=1; i<=5; i++) {
			System.out.print("Enter the name of the book: ");
			bookN = input.nextLine();
			
			bookName.add(bookN);
			
		}
		
		for (int j=0; j<bookName.size(); j++) {
			System.out.println((j+1)+ ". " + bookName.get(j));
		}
		
	}
}





/* DELETE THIS LINE

do {
System.out.printf("%nWelcome Admin to S-Library%n");
System.out.println("1. Add Books");
System.out.println("2. Remove Books"); 
System.out.println("3. Check Books"); //return a book
System.out.println("4. Exit");
System.out.print("Choose from 1-4: ");
int studentMenu = Integer.parseInt(input.nextLine());
switch (studentMenu) {
	case 1 -> {
		while (true) {
			// bug or bold dto tangina
			// ayaw mag work ng line 113 as feedback para sa while (line 108)
			System.out.print("Input the name of the book: ");
			String nameBook = input.nextLine();
			bookData.createBook(nameBook);
			// call the method of check books in student class
			/*
    		System.out.print("Input 'back' to go menu: ");
    		
    		// then it proceeds here for input/output
    		String backOption = input.nextLine();
    		
    		if (backOption.equals("back")) {
    			break;
    		}
    		*/
/* DELETE THIS LINE
		}
	}
	
/* DELETE THIS LINE
	
	case 2 -> {
		System.out.println("the less I know the better");
	}
		
	case 3 -> System.out.println("it is done");
	
	case 4 -> System.out.println("Exiting...");
		
	}
} while (true);


*/