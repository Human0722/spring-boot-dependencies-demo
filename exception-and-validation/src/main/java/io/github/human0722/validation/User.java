package io.github.human0722.validation;


import javax.validation.constraints.NotBlank;

/**
 * @author human0722
 * @date 2022-12-07 16:02
 **/
public class User {
    @NotBlank(message = "Name is mandatory")
    public String name;

    @NotBlank(message = "Email is mandatory")
    public String email;

}
