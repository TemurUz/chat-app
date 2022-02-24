package temur.uz.chatapp.exceptions;

import java.util.Map;

import lombok.Value;
import org.springframework.lang.Nullable;

@Value(staticConstructor = "of")
public class ErrorResponse {
    int code;
    String message;
    @Nullable
    Map<String, Object> meta;

    public static ErrorResponse of(int code, String msg) {
        return of(code, msg, null);
    }


    public static ErrorResponse of(ResponseCode responseCode) {
        return of(responseCode.getCode(), responseCode.getMessage());
    }

}
