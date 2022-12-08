package io.github.human0722.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xueliang
 * @date 2022-12-06 10:56
 */
@RestController
@RequestMapping(ErrorController.BASE_URL)
public class ErrorController {

    public static final String BASE_URL = "/happy";


    @GetMapping
    public String test() {
        return "ok";
    }

}
