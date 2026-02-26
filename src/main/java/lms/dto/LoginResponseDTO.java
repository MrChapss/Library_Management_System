package lms.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.Instant;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class LoginResponseDTO {
    private String username;
    // login timestamp?
    @JsonFormat(pattern = "yyyy-MM-dd, HH:mm:ss", timezone = "UTC")
    private Instant last_login_at;
}
