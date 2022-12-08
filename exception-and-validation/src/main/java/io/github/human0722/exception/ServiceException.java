package io.github.human0722.exception;

import org.springframework.http.HttpStatus;

/**
 * @author human0722
 * @date 2022-12-06 21:55
 **/
public class ServiceException extends RuntimeException{
    private HttpStatus code;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(HttpStatus code, String message) {
        super(message);
        this.code = code;
    }
}
