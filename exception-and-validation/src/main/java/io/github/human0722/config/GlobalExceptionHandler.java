package io.github.human0722.config;

import io.github.human0722.exception.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author human0722
 * @description Global Exception Handler
 * @date 2022-12-06 21:52
 **/
public class GlobalExceptionHandler {

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public String handleValidationExceptions(
//            MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        StringBuilder stringBuilder = new StringBuilder();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            stringBuilder.append(fieldName).append(":").append(errorMessage).append(",");
//        });
//        System.out.println(stringBuilder.toString());
//        return stringBuilder.toString();
//    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<String> serviceException(Exception e) {
        e.printStackTrace();
        return ResponseEntity.ok(e.getMessage());
    }

}
