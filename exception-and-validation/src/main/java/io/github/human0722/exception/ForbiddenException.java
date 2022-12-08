package io.github.human0722.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author human0722
 * @description TODO
 * @date 2022-12-06 21:58
 **/
@ResponseStatus( code = HttpStatus.FORBIDDEN, reason = "403 Forbidden")
public class ForbiddenException extends RuntimeException{

    public ForbiddenException(String message) {
        super(message);
    }
}
