package lms.security;

// Used for a method that require to return an object as key object
import javax.crypto.SecretKey;
// Used to transfer a byte[] data into a key object
import io.jsonwebtoken.JwtParserBuilder;
import io.jsonwebtoken.security.Keys;
// Used to decode the String secretKey into a byte[] data
import io.jsonwebtoken.io.Decoders;
// For springboot to recognize is bean type of service
import org.springframework.stereotype.Service;
// Annotation used for using the value inside the application.properties file
import org.springframework.beans.factory.annotation.Value;
// To use the builder in Jwts
import io.jsonwebtoken.Jwts;
// Used to read the details of token
import io.jsonwebtoken.JwtParser;
// Used to set the current time for issuedAt
import java.util.Date;
// Used as a variable for parsed token (claims) and extract subject (username) in the token
import io.jsonwebtoken.Claims;



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
    // tell the main purpose of this method (provide example if necessary)
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
    // what's the main purpose of this method? (provide example if necessary)
    // method for extracting username or reader of token
    public String extractUsername(String token) {
        JwtParser tokenParser = Jwts.parser()
            .verifyWith(getSigningKey())
            .build();
        Claims tokenClaims = tokenParser.parseSignedClaims(token).getPayload();
        return tokenClaims.getSubject();
    }
}
