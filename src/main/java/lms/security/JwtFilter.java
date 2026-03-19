package lms.security;

// Used to filter once per request only (to avoid multiple or flood request?)
import org.springframework.web.filter.OncePerRequestFilter;
// HttpServlet is the way of java handling incoming HTTP requests
import jakarta.servlet.http.HttpServletRequest;
// ServletResponse is the way of java handling outgoing HTTP response
import jakarta.servlet.http.HttpServletResponse;
// The purpose is to pass it forward to next filter
import jakarta.servlet.FilterChain;
// ServletException is used when there's wrong in Servlet(HTTP request) or Filter layer.
import jakarta.servlet.ServletException;
// Used when something wrong in reading/writing request or response data
import java.io.IOException;
// To tell spring to recognize this as bean (@Component = general class recognized by spring)
import org.springframework.stereotype.Component;
// To get user info in database by using username
import lms.service.AccountService;
// To secured information of the current request (prevents overwriting the filtered authentication)
import org.springframework.security.core.context.SecurityContextHolder;

@Component
public class JwtFilter extends OncePerRequestFilter{
    // If same package I can just declare it, If not I have to import it.
    final private JwtService jwtService;
    final private AccountService accountService;
    // constructor injector to use the methods inside the classes
    public JwtFilter (JwtService jwtService,
                      AccountService accountService){
        this.jwtService=jwtService;
        this.accountService=accountService;
    }
    // Polymorphism the method of OncePerRequestFilter annotation
    @Override
    // doFilterInternal(...) where filter logic resides (similar to main method)
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain
                                    ) throws ServletException, IOException{
        // Using if conditional to handle null header and not starting in bearer
        // header is a part of a token information
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader == null ||
                // filtering it and pass then stop using the return.
                !authorizationHeader.startsWith("Bearer ")){
            filterChain.doFilter(request, response);
            return;
        }
        // prefix variable + length() = amount of index of word in a variable
        // (in short, no need to manually type the index to remove the "Bearer " in the token)
        String prefix = "Bearer ";
        // substring job is to extract token using the index starting from "Bearer "
        String token = authorizationHeader.substring(prefix.length()).trim();
        // extracting username to prevent a user with null username
        String username = jwtService.extractUsername(token);
        // SecurityContextHolder = holds the security info
        // getContext() = container of info
        // getAuthentication() = the object or the user
        boolean isAuthenticatedUser = SecurityContextHolder.getContext().getAuthentication() == null;
        if (username == null || !isAuthenticatedUser){
            filterChain.doFilter(request, response);
            return;
        }
    }
}

// need natin ma-understand this all annotation kahit comment lang natin
// delete and repeat
// straight forward kahit clueless, we will win
