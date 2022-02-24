package temur.uz.chatapp.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseCode {

    NOT_FOUND(489, "Object not found"),
    GENERAL_ERROR(500, "General error"),
    USER_NOT_FOUND(488, "user not found");



    private final int code;
    private final String message;
}
