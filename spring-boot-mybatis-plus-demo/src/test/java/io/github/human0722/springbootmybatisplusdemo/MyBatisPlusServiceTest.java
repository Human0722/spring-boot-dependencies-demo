package io.github.human0722.springbootmybatisplusdemo;

import io.github.human0722.springbootmybatisplusdemo.domain.User;
import io.github.human0722.springbootmybatisplusdemo.servie.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

/**
 * @author human0722
 * @date 2022-11-29 14:11
 **/
@SpringBootTest
public class MyBatisPlusServiceTest {

    @Autowired
    private UserService userService;


    @Test
    public void testGetCount() {
        long count = userService.count();
        System.out.println("affect rows:" + count);
    }

    @Test
    public void testBatchInsert() {
        ArrayList<User> users = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            User user = new User();
            user.setAge(10 + i);
            user.setName("randy" + i);
            user.setEmail("randy@qq"+ i + ".com");
            users.add(user);
        }
        userService.saveBatch(users);
    }
}
