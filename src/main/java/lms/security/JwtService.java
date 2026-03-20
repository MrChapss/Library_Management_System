package lms.security;

// For springboot to recognize is bean type of service
import org.springframework.stereotype.Service;
// Annotation used for using the value inside the application.properties file
import org.springframework.beans.factory.annotation.Value;
// Used for a method that require to return an object as key object
import javax.crypto.SecretKey;
// Used to transfer a byte[] data into a key object
import io.jsonwebtoken.security.Keys;
// Used to decode the String secretKey into a byte[] data
import io.jsonwebtoken.io.Decoders;
// To use the builder in Jwts
import io.jsonwebtoken.Jwts;
// Used to read the details of token
import io.jsonwebtoken.JwtParser;
// Used to set the current time for issuedAt
import java.util.Date;
// Used as a variable for parsed token (claims) and extract subject (username) in the token
import io.jsonwebtoken.Claims;
// Used for representing user object data
import org.springframework.security.core.userdetails.UserDetails;
@Service
public class JwtService {

    /* The syntax for the @Value annotation is that the declaration of the variable
       must be similar to the name in the application properties. */
    @Value("${jwt.secretKey}")
    private String secretKey;
    @Value("${jwt.expirationToken}")
    private long expirationToken;
    // tell the main purpose of this method (provide example if necessary)
    // method that validate a token using the secret key
    private SecretKey getSigningKey(){
        byte[] byteKey = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(byteKey);
    }
    // The main purpose of the method is to provide a token that user will less enter username and password every login
    // method for generating token
    public String generateToken(String username){
        return Jwts.builder()
            .subject(username)
            .issuedAt(new Date(System.currentTimeMillis()))
            .expiration(new Date(System.currentTimeMillis() + expirationToken))
            // work as seal stamp
            .signWith(getSigningKey())
            // the version of ".builder()" but in Jwts
            .compact();
    }
    // The main purpose of this method is to identify who made a request in the server
    // Method for reads username out of the token
    public String extractUsername(String token) {
        JwtParser tokenParser = Jwts.parser()
            .verifyWith(getSigningKey())
            .build();
        Claims tokenClaims = tokenParser.parseSignedClaims(token).getPayload();
        return tokenClaims.getSubject();
    }
    // The main purpose is to validate the token
    public boolean isTokenValid(String token, UserDetails details) {
        // 1. extract the username
        String userName = extractUsername(token);
        // true, if the extracted username is equal to user details and not expiration of the token
        return (details.getUsername().equals(userName) && !isTokenExpired(token));
    }
    // This is a helper method for "isTokenValid" for preventing expired token
    private boolean isTokenExpired(String token){
        // read the token
       JwtParser tokenDetails = Jwts.parser()
               .verifyWith(getSigningKey())
               .build();
       // Claims "tokenInfo" hold all the data from the token (I get the actual data using the .getPayLoad() method)
       Claims tokenInfo = tokenDetails.parseSignedClaims(token).getPayload();
       // return the true if not expired, return false if expired
       return (new Date(System.currentTimeMillis()).before(tokenInfo.getExpiration()));
    }
}
