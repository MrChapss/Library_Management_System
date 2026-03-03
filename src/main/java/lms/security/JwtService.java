package lms.security;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
@Service
public class JwtService {
    @Value("${jwt.secretKey}")
    private String secretKey;
    @Value("${jwt.expirationToken}")
    private long expirationToken;
}
