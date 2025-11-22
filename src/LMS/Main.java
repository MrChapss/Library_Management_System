package LMS;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        // declare the class object
        Admin adminData = new Admin();
        Student studentData = new Student();
        Book bookData = new Book();
        //Validator checkAcc = new Validator();
        
        //input
        System.out.println("Choose an account to login (1-2): ");
        System.out.println("1. Student");
        System.out.println("2. Admin");
        System.out.printf("%nYour input: ");
        //basta switch case to para choose kung user lang or admin ba
        int userOption = Integer.parseInt(input.nextLine());
        
        // may switch narin sa wakas
        switch (userOption) {
        case 1:
        	do {
        		System.out.printf("%nPlease enter your id: ");
            	int userID = Integer.parseInt(input.nextLine());
            	studentData.setId(userID);
            	
            	System.out.print("Please enter your name: ");
                String userName = input.nextLine();
                studentData.setName(userName);
                
        	} while (studentData.checkAcc(studentData.getName(), studentData.getId()));
        	break;
        	
        case 2:
        	do {
        		System.out.printf("%nPlease enter your id: ");
            	int userID = Integer.parseInt(input.nextLine());
            	adminData.setId(userID);
            	
            	System.out.print("Please enter your name: ");
                String userName = input.nextLine();
                adminData.setName(userName);
                
        	} while (adminData.checkAcc(adminData.getName(), adminData.getId()));
        	break;
        	
        default:
        	System.out.println("Choose from 1-2 only!");
        }
        
        
        //another switch para sa menu na
        switch (userOption) {
        case 1:
        	System.out.print("Choose from 1-4: ");
        	int userMenu = Integer.parseInt(input.nextLine());
        	switch (userMenu) {
	        	case 1:
	        		System.out.println("Sa ere");        	
	        		break;
	        	
	        	case 2:
	        		System.out.println("the less I know the better");
	        		break;
	        		
	        	case 3:
	        		System.out.println("it is done");
	        		break;
        	}
        case 2:
        	System.out.println("watata");
        	break;
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
