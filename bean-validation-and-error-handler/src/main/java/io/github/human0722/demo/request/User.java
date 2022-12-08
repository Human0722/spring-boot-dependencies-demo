package io.github.human0722.demo.request;


import io.github.human0722.demo.validation.AddGroup;
import io.github.human0722.demo.validation.UpdateGroup;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * @author xueliang
 * @date 2022-12-08 15:36
 */
@Data
public class User {

    @NotBlank(message = "id不能为空", groups = {UpdateGroup.class})
    @Null(message = "新增时不能有id", groups = {AddGroup.class})
    private String id;
    @NotBlank(message = "name不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String name;
    @NotBlank
    private String age;
}
