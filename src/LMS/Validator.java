package LMS;

public class Validator {
	private int min = 1;
	private final int max = 3;
	
    public boolean Account(String name, int id){
    	
        if (!name.equals("Mark") || id != 123){
        	
            System.out.printf("Your ID or Name is incorrect!%n");
            
            if (min == max) {
            	System.out.printf("%nYou have reached the maxium retries! Try again later.");
            	return false;
            }
            min++;
            return true;
        } else {
        	System.out.println("Login success!");
        	return false;
        } 
        
        
        
    }
}
