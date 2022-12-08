package io.github.human0722;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;

/**
 * @author human0722
 * @description TODO
 * @date 2022-12-08 15:02
 **/
public class BindingResultUtil {
    static public void processBindingResult(BindingResult bindingResult) {
        HashMap<String, String> errorMap = new HashMap<>();
        bindingResult.getFieldErrors().forEach((item)->{
            errorMap.put(item.getField(), item.getDefaultMessage());
        });
    }
}
