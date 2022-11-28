package io.github.human0722.springbootmybatisplusdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author xueliang
 * @description TODO
 * @date 2022-11-28 17:13
 */
@Data
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
