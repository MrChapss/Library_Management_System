package lms.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.Instant;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResponseRequest {
    private int id;
    private String username;

    @JsonFormat(pattern = "HH:mm:ss, MM-dd-yyyy", timezone = "UTC")
    private Instant createdAt;
}
