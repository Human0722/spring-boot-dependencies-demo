package io.github.human0722.demo.exception;

import io.github.human0722.demo.util.Response;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author xueliang
 * @date 2022-12-06 15:56
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public Response handleServiceException(ServiceException e) {
        return Response.error(e.getCode(),e.getMessage());
    }
}
