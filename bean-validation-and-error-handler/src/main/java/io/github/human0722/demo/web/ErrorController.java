package io.github.human0722.demo.web;

import io.github.human0722.demo.request.User;
import io.github.human0722.demo.util.BindingResultUtil;
import io.github.human0722.demo.util.Response;
import io.github.human0722.demo.validation.AddGroup;
import io.github.human0722.demo.validation.UpdateGroup;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author xueliang
 * @date 2022-12-06 10:56
 */
@RestController
public class ErrorController {

    @PostMapping("/users")
    public Response<String> addUsers(
            @Validated(AddGroup.class) @RequestBody User user, BindingResult bindingResult) {
        BindingResultUtil.processBindingResult(bindingResult);
        return Response.success("ok");
    }

    @PutMapping("/users")
    public Response<String> updateUsers(
            @Validated(UpdateGroup.class) @RequestBody User user, BindingResult bindingResult) {
        BindingResultUtil.processBindingResult(bindingResult);
        return Response.success("ok");
    }

}
