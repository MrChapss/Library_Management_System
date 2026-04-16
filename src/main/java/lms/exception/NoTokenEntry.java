package lms.exception;

public class NoTokenEntry extends RuntimeException{
    public NoTokenEntry(String message){
        super (message);
    }
}
