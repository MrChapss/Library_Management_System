package LMS;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        // declare the class object
        Admin adminData = new Admin();
        Student studentData = new Student();
        Book bookData = new Book();
        Validator checkAcc = new Validator();

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
            	studentData.setStudentId(userID);
            	
            	System.out.print("Please enter your name: ");
                String userName = input.nextLine();
                studentData.setStudentName(userName);
        	} while (checkAcc.Account(studentData.getStudentName(), studentData.getStudentId()));
        	
        	
        	//1 kung student tapos tawagin nalang yung method ni class object
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
        



        //output
        //System.out.println("Hello! " + studentData.getStudentName());
        //System.out.println("Hello! " + studentData.getStudentId());
        
    }
}
