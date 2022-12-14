package io.github.human0722.demo.controller;

import io.github.human0722.demo.annotation.Auth;
import io.github.human0722.demo.annotation.Logical;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author xueliang
 * @description TestController
 * @date 2022-12-12 17:01
 */
@RestController
public class TestController {

    @GetMapping("/test")
    @Auth(permissions = "method_permission", logical = Logical.OR)
    public String handleTest() {
        System.out.println("Inside Controller");
        return "ResponseContent";
    }
}
