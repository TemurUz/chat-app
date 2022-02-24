package temur.uz.chatapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({
        "success",
        "message"
})
@Getter
@Setter
@ToString
public class Result {
    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("message")
    private String message;
}
