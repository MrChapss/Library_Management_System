package LMS;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        // declare the class object
        Admin adminData = new Admin();
        Student studentData = new Student();
        Book bookData = new Book();
        
        //input
        System.out.println("Choose an account to login (1-2): ");
        System.out.println("1. Student");
        System.out.println("2. Admin");
        System.out.printf("%nYour input: ");
        //basta switch case to para choose kung user lang or admin ba
        int userOption = Integer.parseInt(input.nextLine());
        
        // may switch narin sa wakas
        switch (userOption) {
        //FOR STUDENT
        case 1 -> {
        	do {
        		System.out.printf("%nPlease enter your id: ");
            	int userID = Integer.parseInt(input.nextLine());
            	studentData.setId(userID);
            	
            	System.out.print("Please enter your name: ");
                String userName = input.nextLine();
                studentData.setName(userName);
                
        	} while (studentData.checkAcc(studentData.getName(), studentData.getId()));
        }
        //FOR ADMIN/LIBRARIAN
        case 2 -> {
        	do {
        		System.out.printf("%nPlease enter your id: ");
            	int userID = Integer.parseInt(input.nextLine());
            	adminData.setId(userID);
            	
            	System.out.print("Please enter your name: ");
                String userName = input.nextLine();
                adminData.setName(userName);
                
        	} while (adminData.checkAcc(adminData.getName(), adminData.getId()));
        }
        //IF CHOOSE MORE THAN 1-2	
        default -> System.out.println("Choose from 1-2 only!");
        }
        
        //SWITCH FOR MENU
        switch (userOption) {
        //agenda sa ngayong araw ay loop at break
        // like paano ko siya ma loop na para bang may exit kada option (goods na)
        // problema nalang kung paano siya mag exit na maayos itsura ng code
        // lagay ko nalang sa student class yung mga variable na ginamit para ma-access yung menu 
        case 1 -> {
        	do {
        		System.out.printf("%nWelcome to S-Library%n");
            	System.out.println("1. Check Books");
            	System.out.println("2. Book mark"); // Barrow a book
            	System.out.println("3. Remove a book mark"); //return a book
            	System.out.println("4. Exit");
            	System.out.print("Choose from 1-4: ");
            	int studentMenu = Integer.parseInt(input.nextLine());
            	switch (studentMenu) {
    	        	case 1 -> {
    	        		while (true) {
    	        			// call the method of check books in student class
    	        			System.out.println("Sa ere");
    		        		System.out.print("Input 'back' to go menu: ");
    		        		
    		        		// then it proceeds here for input/output
    		        		String backOption = input.nextLine();
    		        		
    		        		if (backOption.equals("back")) {
    		        			break;
    		        		}
    	        		}
    	        	}
    	        	
    	        	case 2 -> {
    	        		System.out.println("the less I know the better");
    	        	}
    	        		
    	        	case 3 -> System.out.println("it is done");
    	        	
    	        	case 4 -> System.out.println("Exiting...");
    	        		
            		}
        	} while (true);
        }
        	
        	
        	
        case 2 -> {
        		System.out.printf("%nWelcome Admin to S-Library%n");
            	System.out.println("1. Add Books");
            	System.out.println("2. Remove Books"); 
            	System.out.println("3. Check Books"); //return a book
            	System.out.println("4. Exit");
            	System.out.print("Choose from 1-4: ");
            	int studentMenu = Integer.parseInt(input.nextLine());
            	
            	adminData.menuChoice(studentMenu);
            	
		    
			}
		}
        	
        
        
        
        
        // logic for checking account
        /*
        do {
            System.out.print("Please enter your id: ");
            int userID = Integer.parseInt(input.nextLine());
            studentData.setStudentId(userID);

            System.out.print("Please enter your name: ");
            String userName = input.nextLine();
            studentData.setStudentName(userName);

        } while(checkAcc.Account(studentData.getStudentName(), studentData.getStudentId()));
        */
        
        // testing ground
        /*
        System.out.print("Enter name student: ");
        String userName = input.nextLine();
        studentData.setName(userName);
        
        System.out.print("Enter name student: ");
        String userName2 = input.nextLine();
        adminData.setName(userName2);
        */
        
        //output
        //System.out.println("Hello! " + studentData.getName());
        //System.out.println("Hello! " + adminData.getName());
        
    }
}
