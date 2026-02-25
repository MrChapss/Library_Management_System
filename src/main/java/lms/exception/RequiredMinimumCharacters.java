package lms.exception;

public class RequiredMinimumCharacters extends RuntimeException{
    public RequiredMinimumCharacters(String message) {
        super(message);
    }
}
