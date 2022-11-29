package io.github.human0722.springbootmybatisplusdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("io.github.human0722.springbootmybatisplusdemo.dao")
public class SpringBootMybatisPlusDemoApplication {

    /**
     *  MyBatis-Plus 是一个ORM框架，通过操作对象自动生成SQL
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisPlusDemoApplication.class, args);
    }

}
