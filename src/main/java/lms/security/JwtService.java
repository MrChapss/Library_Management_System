package lms.security;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
@Service
public class JwtService {
    @Value(
    private String secretKey;
    private long expirationToken;
    );

}
