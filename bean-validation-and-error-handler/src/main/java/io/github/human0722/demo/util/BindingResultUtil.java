package io.github.human0722.demo.util;

import io.github.human0722.demo.exception.ServiceException;
import org.springframework.validation.BindingResult;

/**
 * @author xueliang
 * @date 2022-12-08 15:40
 */
public class BindingResultUtil {
   static public void processBindingResult(BindingResult bindingResult) {
       if (bindingResult.hasErrors()) {
           StringBuilder stringBuilder = new StringBuilder();
           bindingResult.getFieldErrors().forEach((item)->{
               stringBuilder.append(item.getField()).append(":").append(item.getDefaultMessage()).append(",");
           });
           throw new ServiceException(
                   ResponseCodeEnum.PARAMETER_ERROR.getCode(),
                   stringBuilder.toString());
       }
   }
}
