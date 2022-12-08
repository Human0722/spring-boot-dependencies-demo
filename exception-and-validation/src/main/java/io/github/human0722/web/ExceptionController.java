package io.github.human0722.web;

import io.github.human0722.exception.ForbiddenException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author human0722
 * @date 2022-12-06 21:49
 **/
@RestController
public class ExceptionController {


    @GetMapping("test_exception")
    public String throwException() throws ForbiddenException {
        int i = 5 / 0;
        throw new ForbiddenException("用户数量太多");
    }

}
