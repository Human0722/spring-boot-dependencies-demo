package io.github.human0722.web;

import io.github.human0722.validation.User;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author human0722
 * @date 2022-12-07 16:18
 **/
@RestController
public class UserController {

    @PostMapping("/users")
    String addUser(@Valid @RequestBody User user, BindingResult bindingResult) {
        return "ok";
    }


}
