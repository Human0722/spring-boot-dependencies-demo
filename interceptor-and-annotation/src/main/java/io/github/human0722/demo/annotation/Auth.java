package io.github.human0722.demo.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
/**
 * @author xueliang
 * @date 2022-12-14 10:38
 */
@Documented
@Target({METHOD, TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Auth {
    String[] permissions() default { };

    String logical() default Logical.AND;
}
