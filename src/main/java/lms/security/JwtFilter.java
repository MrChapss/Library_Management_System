package lms.security;

// Used to filter once per request only (to avoid multiple or flood request?)
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import java.io.IOException;
// why use component? what's the use of component in this class?
import org.springframework.stereotype.Component;
// Used for extracting username and validate a token
import lms.security.JwtService;
// To get user info in database by using username
import lms.service.AccountService;

@Component
public class JwtFilter extends OncePerRequestFilter{
    final private JwtService jwtService;
    final private AccountService accountService;

    public JwtFilter (JwtService jwtService,
                      AccountService accountService){
        this.accountService=accountService;
        this.jwtService=jwtService;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain
                                    ) throws ServletException, IOException{

    }
}
