package lms.security;

// Used to filter once per request only (to avoid multiple or flood request?)
import org.apache.tomcat.util.http.parser.Authorization;
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
//

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
    // I don't know what is this and what for
    @Override
    // doFilterInternal(...) where filter logic resides (similar to main method)
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain
                                    ) throws ServletException, IOException{
        // Using if conditional to handle null header and not starting in bearer
        String authorizationHeader = request.getHeader("Authorization");
        String bearerHeader = request.getHeader("Bearer ");
        // the update version have a variable that holds the authorization and bearer and also divide into 2 if condition
        if (authorizationHeader == null){
            filterChain.doFilter(request, response);
            return;
        }
        if (!bearerHeader.startsWith("Bearer ")){
            filterChain.doFilter(request, response);
            return;
        }
    }
}
// need natin ma-understand this all annotation kahit comment lang natin
