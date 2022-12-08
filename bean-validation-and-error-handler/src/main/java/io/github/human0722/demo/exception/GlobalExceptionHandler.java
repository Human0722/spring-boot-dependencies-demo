package io.github.human0722.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author xueliang
 * @date 2022-12-06 15:56
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handlerZero() {
        return "message from exceptionHandler";
    }
}
