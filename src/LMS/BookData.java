package LMS;

public class BookData {
    private String nameBook;
    private int bookId;
    private boolean isBookAvailable;

    public void setNameBook(String name){
        this.nameBook = name;
    }

    public void setBookId(int id) {
        this.bookId = id;
    }

    public void setBookAvailable (boolean available){
        this.isBookAvailable = available;
    }

    public String getNameBook(){return nameBook;}
    public int getBookId(){return bookId;}
    public boolean isBookAvailable(){return isBookAvailable;}
}
