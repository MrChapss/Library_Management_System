package lms.dto;

import java.time.Instant;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class TokenStatus {
    @JsonFormat(pattern = "yyyy-MM-dd, HH:mm:ss", timezone = "UTC")
    private Instant timestamp;
    private int status;
    private String message;
    private String error;

}
