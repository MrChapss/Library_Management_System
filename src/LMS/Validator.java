package LMS;

public class Validator {
	private int limit = 1;
	private final int max = 3;
	
    public boolean Account(String name, int id){
    	
        if (!name.equals("Mark") || id != 123){
        	
            System.out.printf("Your ID or Name is incorrect!%nPlease try again.%n%n");
            
            if (limit == max) {
            	System.out.println("You have reached the maxium retries!");
            	return false;
            }
            limit++;
            return true;
        } else {
        	System.out.println("Login success!");
        	return false;
        } 
        
        
        
    }
}
