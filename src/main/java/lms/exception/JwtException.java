package lms.exception;

public class JwtException extends RuntimeException{
    private int statusCode;
    private String errorType;

    public JwtException(String message, int statusCode, String errorType){
        super(message);
    }
    
}
