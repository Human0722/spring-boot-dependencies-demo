package io.github.human0722.demo.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author xueliang
 * @description TODO
 * @date 2022-12-06 10:58
 */
@SpringBootTest
public class ErrorControllerTest {

    @Autowired
    private ErrorController errorController;

    @Test
    void testErrorController() {
        System.out.println(errorController.test());
    }
}
