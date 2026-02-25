package lms.api;
// JsonFormat - formatting time for human to be readable
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
//import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ApiResponse<T> {
    @JsonFormat(pattern = "yyyy-MM-dd, HH:mm:ss", timezone = "UTC")
    private Instant timestamp;
    private int status;
    private String message;
    // what the hell is T bro (search this later)
    private T data;
    //private List<String> errors;
    private String error;
}
