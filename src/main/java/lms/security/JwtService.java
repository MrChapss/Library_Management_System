package lms.security;

import
import io.jsonwebtoken.security.Keys;
// Used to decode the String secretKey
import io.jsonwebtoken.io.Decoders;
// For springboot to recognize is bean type of service
import org.springframework.stereotype.Service;
// Annotation used for using the value inside the application.properties file
import org.springframework.beans.factory.annotation.Value;

@Service
public class JwtService {
    @Value("${jwt.secretKey}")
    private String secretKey;
    @Value("${jwt.expirationToken}")
    private long expirationToken;

    // method that generate validate a token using the secret key
    private SecretKey getSigningKey(){
    Decoders.BASE64.decode(secretKey);
    }
}
