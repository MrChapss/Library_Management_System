<<<<<<< HEAD
package lms;
import java.util.ArrayList;

public class Book {
    private ArrayList<String> nameBook = new ArrayList<String>();
    private int bookId;
    private boolean isBookAvailable;

    public Boolean createBook(String name){
        while (true) {
        	
        	nameBook.add(name);
        	
        	if (name.equals("stop")) {
        		return false;
        	}
        	return true;
        	// taga stop mag add ng books
        	
        	
        	// checker para malaman kung nag duplicate or nah
        	/*
        	if (nameBook.contains(name)) {
        		System.out.println("This book already exist!");
        	}
        	*/
        	
        }
    }

    public void setBookId(int id) {
        this.bookId = id;
    }

    public void setBookAvailable (boolean available){
        this.isBookAvailable = available;
    }

    //public String<> getNameBook(){return nameBook;}
    public int getBookId(){return bookId;}
    public boolean isBookAvailable(){return isBookAvailable;}
    
    /* METHOD TO PARA SA CHECK BOOKS, ETC.
    public int studentMenu(int studentInput) {
    	switch (studentInput) {
    		case 1 ->{
    			while (true) {
    				
    			}
    		}
    	}
    }
    */
    
    // ayusin muna yung purpose ni book class
    
    //ganito yung flow
    
    //name muna ng book
    //id of the book (check kung meron existing id)
    //yung sa availability parang check balance tulad sa bank simulator sim
}
=======
package lms;
>>>>>>> properBai
