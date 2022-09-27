package temur.uz.chatapp.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Slf4j
public class ControllerAdvice {

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    ErrorResponse on(Exception e) {
        log.error(ResponseCode.GENERAL_ERROR.getMessage(), e);
        return ErrorResponse.of(ResponseCode.GENERAL_ERROR.getCode(), ResponseCode.GENERAL_ERROR.getMessage() + " : " + e.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorResponse on(NotFoundException e) {
        log.error(e.getMessage());
        return ErrorResponse.of(ResponseCode.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorResponse on(UserNotFoundException e) {
        log.error(e.getMessage());
        return ErrorResponse.of(ResponseCode.USER_NOT_FOUND);
    }

    @ExceptionHandler(UserDataFailedIsNotSavedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorResponse on(UserDataFailedIsNotSavedException e) {
        log.error(e.getMessage());
        return ErrorResponse.of(ResponseCode.USER_DATA_FAILED_IS_NOT_SAVED);
    }

}
