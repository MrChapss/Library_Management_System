package lms.security;

// Used for a method that require to return an object as key object
import javax.crypto.SecretKey;
// Used to transfer a byte[] data into a key object
import io.jsonwebtoken.security.Keys;
// Used to decode the String secretKey into a byte[] data
import io.jsonwebtoken.io.Decoders;
// For springboot to recognize is bean type of service
import org.springframework.stereotype.Service;
// Annotation used for using the value inside the application.properties file
import org.springframework.beans.factory.annotation.Value;

@Service
public class JwtService {
    /* The syntax for the @Value annotation is that the declaration of the variable
       must be similar to the name in the application properties. */
    @Value("${jwt.secretKey}")
    private String secretKey;
    @Value("${jwt.expirationToken}")
    private long expirationToken;

    // method that generate validate a token using the secret key
    private SecretKey getSigningKey(){
        byte[] byteKey = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(byteKey);
    }
    // initial commit
}
